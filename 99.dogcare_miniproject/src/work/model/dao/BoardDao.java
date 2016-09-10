package work.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import work.model.dto.Board;


/**
 * @author heehwan
 *
 */
/**
 * @author heehwan
 *
 */
/**
 * @author heehwan
 *
 */
/**
 * @author heehwan
 *
 */
public class BoardDao {
	
	// FactoryDap pattern ���뼳�� : doa �������� ���»���
		private FactoryDao factory = FactoryDao.getInstance();

	// jdbc property
		private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}

	// ��� ���
		// insert into Manager
		// values('user01', '�ñ��1', 'pass01', 'Manager','010-1111-1111', '����� ���۱�');


	/**�Խ��Ǳ� ��� ��� 
	 * @param board �Խ��� �� ����� �Ϸ�� ǥ�� 
	 * @return ���Ȯ��
	 */
	public int insertBoard(Board board) {
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				// conn = DriverManager.getConnection(url, user, password);
				conn = factory.getConnection();
				System.out.println("sql 1");
				
				String sql = "insert into board values(BOARD_NUMBER.NEXTVAL,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getcNumber());
				pstmt.setString(2, board.getTitle());
				pstmt.setString(3, board.getContent());
				pstmt.setString(4, board.getPrice());
				pstmt.setString(5, board.getPossibleDogKind());
				
				
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("insert > ����");
				e.printStackTrace();
			} finally {
				factory.close(conn, pstmt);
			}
			return 0;
		}
		
	
	
		
		/**�Խ��� ����ü ��ȸ 
		 * @return �Խ��Ǳ��� ������
		 */
	
		public ArrayList<Board> selectList() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<Board> list = new ArrayList<Board>();

			int boardNumber = 0;
			String cNumber = null;
			String title = null;
			String content = null;
			String price = null;
			String possibleDogKind = null;
		
			try {
				// conn=DriverManager.getConnection(url, user, password);
				conn = factory.getConnection();
				String sql = "select * from board order by board_number ";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				System.out.println(">>>>> sql 1");
				while (rs.next()) {
					boardNumber = rs.getInt("board_number");
					cNumber = rs.getString("c_Number");
					title = rs.getString("title");
					content = rs.getString("content");
					price = rs.getString("price");
					possibleDogKind = rs.getString("possible_Dog_Kind");
					
					list.add(new Board(boardNumber,cNumber,title,content,price,possibleDogKind));
					System.out.println(">>>: " + list);
				}
				return list;
			} catch (SQLException e) {
				System.out.println("ERROE : ����ȸ");
			} finally {
				factory.close(conn, pstmt, rs);
			}
			return null;
		}
		

		
			/**
			 * Ư�� �Խñۻ� ��ȸ ���(�Խ��Ǳ�)
			 * @param boardNumber �Խ��� �۹�ȣ
			 * @return �Խ��Ǳ�
			 */
			public Board selectBoard(int boardNumber) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				// conn = DriverManager.getConnection(url, user, password);
				conn = factory.getConnection();
				String sql = "select * from board where board_number = ?";

				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, boardNumber);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					
					String cNumber = rs.getString("c_Number");
					String title = rs.getString("title");
					String content = rs.getString("content");
					String price = rs.getString("price");
					String possibleDogKind = rs.getString("possible_Dog_Kind");

					Board emp = new Board(cNumber, title, content, price, possibleDogKind);
					System.out.println("emp(sql) :"+emp);
					return emp;
				}

			} catch (SQLException e) {
				System.out.println("Error : ��� ����");
				e.printStackTrace();
			} finally {
				factory.close(conn, pstmt, rs);

			}
			return null;
		}

}
