package work.model.service;
import java.util.ArrayList;
import java.util.HashMap;
import work.model.dto.Board;
import work.model.dto.Manager;
import work.model.dao.BoardDao;
import work.model.dao.ManagerDao;

public class BoardService {
	
	private BoardDao dao = BoardDao.getInstance();
	
	//맡기미회원등록
	public int enrollBoard(Board board) {
		System.out.println("sql 1 ");
		int enrollMap = dao.insertBoard(board);
		System.out.println("sql 2 :" +enrollMap);
		
		return enrollMap;
	}
	
	
	//돌봄회원전체보기 
	public ArrayList<Board> findBoardAll() {
		ArrayList<Board> list = dao.selectList();
		return list;
	}
	
	//돌봄회원글보기 (게시판글번호)
			public Board findBoard(int boardNumber) {
				Board board = dao.selectBoard(boardNumber);
				System.out.println("\n## service result : " + board);
				return board;

			}
	
	
	
	

}
