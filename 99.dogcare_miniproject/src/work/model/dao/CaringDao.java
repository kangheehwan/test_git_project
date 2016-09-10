package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import work.model.dto.Board;
import work.model.dto.Caring;
import work.model.dto.Manager;

import java.sql.ResultSet;

import java.util.ArrayList;

public class CaringDao {

	// FactoryDap pattern ���뼳�� : doa �������� ���»���
	private FactoryDao factory = FactoryDao.getInstance();

	// jdbc property
	private static CaringDao instance = new CaringDao();

	public static CaringDao getInstance() {
		return instance;
	}

	/**
	 * ��� ���
	 * 
	 * @param caring
	 *            ��������
	 * @return ��������Ȯ�ΰ�
	 */
	public int insertPet(Caring caring) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			System.out.println("sql 1");

			String sql = "insert into caring values(CARE_NUMBER.NEXTVAL,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, caring.getUserId());
			pstmt.setString(2, caring.getcNumber());
			pstmt.setString(3, caring.getDogNumber());
			pstmt.setString(4, caring.getDogName());
			pstmt.setString(5, caring.getDogKind());
			pstmt.setInt(6, caring.getDogAge());
			pstmt.setString(7, caring.getGender());
			pstmt.executeUpdate();
			pstmt.close();

			String sql1 = "update petManager set dog_care='������' where c_number=? ";

			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, caring.getcNumber());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert > ����");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt);
		}
		return 0;
	}

	/**
	 * ������ ����ȸ
	 * 
	 * @param cNumber
	 *            �ڰݹ�ȣ
	 * @return ������ ��ü
	 */
	public Caring selectOne(String cNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			String sql = "select * from caring where c_Number = ?order by care_number desc";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);

			rs = pstmt.executeQuery();
			if (rs.next()) {

				int careNumber = rs.getInt("care_number");
				String userId = rs.getString("user_id");
				String dogNumber = rs.getString("dog_number");
				String dogName = rs.getString("dog_name");
				String dogKind = rs.getString("dog_kind");
				int dogAge = rs.getInt("dog_age");
				String gender = rs.getString("gender");
				
				Caring caring = new Caring(careNumber, userId, cNumber,dogNumber, dogName, dogKind, dogAge, gender);
				System.out.println("caring(sql) :" + caring);
				return caring;
			}

		} catch (SQLException e) {
			System.out.println("Error : ��� ����");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);

		}
		return null;
	}
	
	
	
	//������ �����ϱ�
	public void deleteCaring(String cNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// conn = DriverManager.getConnection(url, user, password);
			conn = factory.getConnection();
			
			
			
			String sql = "delete from board where c_Number = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNumber);
			
			pstmt.executeUpdate();
			pstmt.close();
			
		
			String sql1 = "update petManager set dog_care='�������' where c_number=? ";

			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, cNumber);

			rs = pstmt.executeQuery();
			if (rs.next()) {

			}

		} catch (SQLException e) {
			System.out.println("Error : ������ ���� ���� �ʾҽ��ϴ�.");
			e.printStackTrace();
		} finally {
			factory.close(conn, pstmt, rs);

		}
	}

}
