package work.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import work.model.dto.Manager;



/**
 * @author heehwan
 *
 */
public class ManagerDao {

	// FactoryDap pattern 적용설계 : doa 공통기능을 갖는생성
	private FactoryDao factory = FactoryDao.getInstance();



	// jdbc property
	private static ManagerDao instance = new ManagerDao();

	public static ManagerDao getInstance() {
		return instance;
	}
	// default constructor
	// ** 기본생성자 :jdb driver 로딩 로직 => Factory Dao

	
	/**
	 *돌보미 등록
	 * @param member 돌보미객체
	 * @return 돌보미확인
	 */
	public int insertMember(Manager member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			// 1 2 3 4 5 6 7
			String sql = "insert into petmanager values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getcNumber());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getUserPw());
			pstmt.setString(4, member.getGrade());
			pstmt.setString(5, member.getMobile());
			pstmt.setString(6, member.getPosssibleArea());
			pstmt.setString(7, member.getEnviroment());
			pstmt.setString(8, member.getCarrier());
			pstmt.setString(9, member.getDogCare());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert > 실패");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}


	/** 
	 * 돌보미 로그인
	 * @param cNumber 자격증번호
	 * @param userPw 비밀번호
	 * @return 로그인값 이름,등급
	 */
	public HashMap<String, String> selectLogin(String cNumber, String userPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> loginMap = new HashMap<String, String>();

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select name, grade from petmanager where c_Number=? and user_pw=?";
			// System.out.println(sql);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				loginMap.put("name", rs.getString("name"));
				loginMap.put("grade", rs.getString("grade"));

				System.out.println("\n## dao result : " + loginMap);
				return loginMap;
			}

		} catch (SQLException e) {
			System.out.println("Error : 등록 오류");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}



	/**
	 * 돌보미자격번호 찾기(이름,핸드폰)
	 * @param 돌보미이름
	 * @param mobile 전화번호
	 * @return 자격증번호
	 */
	public String findcNumberMobile(String name, String mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select C_NUMBER from petManager where name=? and mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String cNumber = rs.getString("C_NUMBER");

				return cNumber;
			}

		} catch (SQLException e) {
			System.out.println("Error : 등록 오류");
			e.printStackTrace();
		} finally {

			factory.close(conn, pstmt, rs);

		}
		return null;
	}

	

	/**
	 * 비밀번호 검색(핸드폰을 통한)
	 * @param cNumber 자격증번호
	 * @param mobile 비밀번호
	 * @return 비밀번호
	 */
	public String findPwFromMobile(String cNumber, String mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select user_pw from petManager where c_number=? and mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);
			pstmt.setString(2, mobile);
			rs = pstmt.executeQuery();
			if (rs == null) {
				return null;
			}
			if (rs.next()) {
				String userPw = rs.getString("user_pw");
				return userPw;
			}
		} catch (SQLException e) {
			System.out.println("가입여부조회 실패");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}

	

	/**
	 * 돌보미 상세조회
	 * @param cNumber 자격번호
	 * @return 돌보미 객체
	 */
	public Manager selectOne(String cNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select * from petManager where c_Number = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				
		
				String userPw = rs.getString("user_pw");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String possibleArea = rs.getString("possible_Area");
				String enviroment = rs.getString("enviroment");
				String carrier = rs.getString("carrier");
				String dogCare = rs.getString("dog_care");

				 Manager emp = new Manager(cNumber, name, userPw, mobile,possibleArea,enviroment,carrier,dogCare);
				System.out.println("emp(sql) :" + emp);
				return emp;
			}

		} catch (SQLException e) {
			System.out.println("Error : 등록 오류");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);

		}
		return null;
	}
	
	






	/**
	 * 돌보미정보수정
	 * @param member 돌보미객체
	 * @return 돌보미객체
	 */
	public int updateMember(Manager member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			// 1 2 3 4 5
			System.out.println("sql 1");
			String sql = "update petManager set user_pw=?, name=?, mobile=?,  possible_area=?,enviroment=?,carrier=? where c_number=?";
			pstmt = conn.prepareStatement(sql);
			// 여기까지 전용통로개설
			
			// 여기서부터 매핑되도록 전달값 설정
			pstmt.setString(1, member.getUserPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMobile());
			pstmt.setString(4, member.getPosssibleArea());
			pstmt.setString(5, member.getEnviroment());
			pstmt.setString(6, member. getCarrier());
			pstmt.setString(7, member. getcNumber());
			
			
			System.out.println();
			// 실행요청함. 괄호안에 sql 넣지 말것!!
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("update > 실패");
			e.printStackTrace();
		} finally {
			// 자원해제
			factory.close(conn, pstmt);
		}
		return 0;
	}
	
	
	
	
	//돌봄여부검사 
			public String checkCaring(String cNumber) throws Exception{
				Connection conn = null;
				PreparedStatement pstmt = null;
							
				try{
					conn = factory.getConnection();
					System.out.println("checkCaring sql1");
					String selectSQL="select dog_care from petmanager where c_Number=?";
					pstmt = conn.prepareStatement(selectSQL);
					pstmt.setString(1,cNumber);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()){
						String check= rs.getString("dog_care") ;
						return check;
					}
				}finally{
					factory.close(conn,pstmt);
				}
				return null;
			}
			
			

		
}

