/**
 * 
 */
package work.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * ##factory pattern -- 특정한 공통 기능을 제공하는 공장 클래스 --설계규칙: 1. private 생성자(){} 2.
 * public static 클래스 getInstance() {return 인스턴스 변수명;} 3. private static 클래스
 * 참조변수명 =new 클래스이름();
 * 
 * 
 * ##DAO 공통기능 0. jdbc driver 드라이버 : 생성자 1. Connectiin 생성 2. 자원해제
 * 
 * ## FactoryDao pattern -- DAO 클래스의 공통기능 : Connection 생성,자원해제 -- singleton
 * pattern 적용설계
 * 
 * @author heehwan
 * 
 *         ##singleton patter -- 하나의 클래스에 대해서 단일 객체 서비스 -- 설계규칙: 1. private
 *         생성자(){} 2.public static 클래스 getInstance
 *
 *
 *         ##dbserver 관련 property 파일 외부 자원파일사용 --java.io*
 *         --java.util.ResourceBundle : 규칙준수 ,사용편리
 *
 *
 *         ##resourceBundle 사용규칙 1. 외부 자원파일 위치 : classpath(output dir )기준 상대 경로
 *         2. 파일 확장자:.peoperties 3. 파일 property 기술 : key =value 4. 주의 사항 : key
 *         value = 기호 사이에 공백불가
 *
 */

public class FactoryDao {
	// connection pool :javax.sql.DataSource
	// coded name =java:comp/env/
	// Resource name="jdbc/Oracle":context.xml
	private String dsName = "java:comp/env/jdbc/Oracle";
	private DataSource ds;

	private static FactoryDao instance = new FactoryDao();

	private FactoryDao() {
		try {
			ds = (DataSource) new InitialContext().lookup(dsName);
		} catch (NamingException e) {
			System.out.println("DataSource 이름검색 오류발생 ");
			e.printStackTrace();
		}
	}

	/**
	 * 인스턴스 객체생성
	 * @return 인스턴스
	 */
	public static FactoryDao getInstance() {
		return instance;
	}

	/**
	 * 디비 연결 connection
	 * @return 연결
	 */
	public Connection getConnection() {
		try {
			// connection pool(DataSource)에게 연결객체 하나 가져와서 반환
			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println("DataSource 연결객체 가져오기 오류 발생");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 디비연결후 종류 
	 * @param conn 연결정보
	 * @param stmt 상태정보
	 */
	public void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	/**디비 해체
	 * @param conn 연결정보
	 * @param stmt 상태정보
	 * @param rs 	결과값반환
	 */
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (SQLException e) {
			System.out.println("close exception");
			e.printStackTrace();
		}
	}
}