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
	
	// FactoryDap pattern 적용설계 : doa 공통기능을 갖는생성
		private FactoryDao factory = FactoryDao.getInstance();

	// jdbc property
		private static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
		return instance;
	}

	// 등록 기능
		// insert into Manager
		// values('user01', '맡기미1', 'pass01', 'Manager','010-1111-1111', '서울시 동작구');


	/**게시판글 등록 기능 
	 * @param board 게시판 글 등록이 완료된 표시 
	 * @return 등록확인
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
				System.out.println("insert > 실패");
				e.printStackTrace();
			} finally {
				factory.close(conn, pstmt);
			}
			return 0;
		}
		
	
	
		
		/**게시판 글전체 조회 
		 * @return 게시판글을 배포함
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
				System.out.println("ERROE : 상세조회");
			} finally {
				factory.close(conn, pstmt, rs);
			}
			return null;
		}
		

		
			/**
			 * 특정 게시글상세 조회 기능(게시판글)
			 * @param boardNumber 게시판 글번호
			 * @return 게시판글
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
				System.out.println("Error : 등록 오류");
				e.printStackTrace();
			} finally {
				factory.close(conn, pstmt, rs);

			}
			return null;
		}

}
