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
 * ##factory pattern -- Ư���� ���� ����� �����ϴ� ���� Ŭ���� --�����Ģ: 1. private ������(){} 2.
 * public static Ŭ���� getInstance() {return �ν��Ͻ� ������;} 3. private static Ŭ����
 * ���������� =new Ŭ�����̸�();
 * 
 * 
 * ##DAO ������ 0. jdbc driver ����̹� : ������ 1. Connectiin ���� 2. �ڿ�����
 * 
 * ## FactoryDao pattern -- DAO Ŭ������ ������ : Connection ����,�ڿ����� -- singleton
 * pattern ���뼳��
 * 
 * @author heehwan
 * 
 *         ##singleton patter -- �ϳ��� Ŭ������ ���ؼ� ���� ��ü ���� -- �����Ģ: 1. private
 *         ������(){} 2.public static Ŭ���� getInstance
 *
 *
 *         ##dbserver ���� property ���� �ܺ� �ڿ����ϻ�� --java.io*
 *         --java.util.ResourceBundle : ��Ģ�ؼ� ,�����
 *
 *
 *         ##resourceBundle ����Ģ 1. �ܺ� �ڿ����� ��ġ : classpath(output dir )���� ��� ���
 *         2. ���� Ȯ����:.peoperties 3. ���� property ��� : key =value 4. ���� ���� : key
 *         value = ��ȣ ���̿� ����Ұ�
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
			System.out.println("DataSource �̸��˻� �����߻� ");
			e.printStackTrace();
		}
	}

	/**
	 * �ν��Ͻ� ��ü����
	 * @return �ν��Ͻ�
	 */
	public static FactoryDao getInstance() {
		return instance;
	}

	/**
	 * ��� ���� connection
	 * @return ����
	 */
	public Connection getConnection() {
		try {
			// connection pool(DataSource)���� ���ᰴü �ϳ� �����ͼ� ��ȯ
			return ds.getConnection();
		} catch (SQLException e) {
			System.out.println("DataSource ���ᰴü �������� ���� �߻�");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ��񿬰��� ���� 
	 * @param conn ��������
	 * @param stmt ��������
	 */
	public void close(Connection conn, Statement stmt) {
		close(conn, stmt, null);
	}

	/**��� ��ü
	 * @param conn ��������
	 * @param stmt ��������
	 * @param rs 	�������ȯ
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