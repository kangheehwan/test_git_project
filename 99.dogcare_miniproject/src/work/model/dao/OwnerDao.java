package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;


import work.model.dto.Owner;

public class OwnerDao {
	
		// FactoryDap pattern 적용설계 : doa 공통기능을 갖는생성
		private FactoryDao factory = FactoryDao.getInstance();

		// jdbc property
		private static OwnerDao instance = new OwnerDao();

		public static OwnerDao getInstance() {
			return instance;
		}
		// default constructor
		// ** 기본생성자 :jdb driver 로딩 로직 => Factory Dao
	

		
		/**
		 * 맡기미 등록
		 * @param member 맡기미 객체
		 * @return 맡기미 객체
		 */
		public int insertMember(Owner member) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				// conn = DriverManager.getConnection(url, user, password);
				conn = factory.getConnection();
				// 1 2 3 4 5 6 7
				String sql = "insert into Owner values(?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, member.getUserId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getUserPw());
				pstmt.setString(4, member.getGrade());
				pstmt.setString(5, member.getMobile());
				pstmt.setString(6, member.getAddress());
				 
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
		 * 맡기미 로그인
		 * @param userId 사용자 아이디
		 * @param userPw 사용자 비밀번호
		 * @return 맡기미 확인
		 */
		public HashMap<String, String> selectLogin(String userId, String userPw) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			HashMap<String, String> loginMap = new HashMap<String, String>();
		
			try {
				// conn = DriverManager.getConnection(url, user, password);
				conn = factory.getConnection();
				String sql = "select name, grade from owner where user_id=? and user_pw=?";
				//System.out.println(sql);
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, userId);
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
		
		//아이디 중복검사 
		public int checkId(String usrid) throws Exception{
			Connection conn = null;
			PreparedStatement pstmt = null;
			int re = 0;
			try{
				conn = factory.getConnection();
				String selectSQL="select * from owner where user_id=?";
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setString(1,usrid);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					re = 1;
				}
			}finally{
				factory.close(conn,pstmt);
			}
			return re;
		}//end list()

	
	
	/**
	 * 맡기미객체정보 
	 * @param userId 맡기미 아이디 
	 * @return 맡기미 객체
	 */
	public Owner selectOne(String userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select * from Owner where user_id = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String userPw = rs.getString("user_pw");
				String name = rs.getString("name");
				String mobile = rs.getString("mobile");
				String grade = rs.getString("grade");
				String address = rs.getString("address");
				

				Owner emp = new Owner(userId, name, userPw, grade, mobile,address);
				System.out.println("emp(sql) :"+emp);
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
	 * 맡기미 정보수정
	 * @param member 맡기미 객체
	 * @return 맡기미 변경정보객체
	 */
	public int updateMember(Owner member) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			// 1 2 3 4 5
			String sql = "update owner set user_pw=?, name=?, mobile=?, address=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			// 여기까지 전용통로개설
			
			// 여기서부터 매핑되도록 전달값 설정
			pstmt.setString(1, member.getUserPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getMobile());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getUserId());
			
			
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
	

	/**
	 * 맡기미 아이디찾기
	 * @param name 맡기미 이름
	 * @param mobile 맡기미 전화번호
	 * @return 맡기미 아이디
	 */
	public String findIdUseMobile(String name, String mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select user_id from owner where name=? and mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mobile);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String userId = rs.getString("user_Id");
				
				return userId;
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
	 * 맡기미 비밀번호
	 * @param userId 사용자아이디
	 * @param mobile 전화번호
	 * @return 맡기미 비밀번호
	 */
	public String findPwFromMobile(String userId, String mobile) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String temp = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select user_pw from owner where user_id=? and mobile=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
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
			// TODO Auto-generated catch block
			System.out.println("가입여부조회 실패");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);
		}
		return null;
	}
	
}






