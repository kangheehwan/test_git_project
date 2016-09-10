package work.model.service;
import java.util.ArrayList;
import java.util.HashMap;
import work.model.dto.Board;
import work.model.dto.Manager;
import work.model.dao.BoardDao;
import work.model.dao.ManagerDao;

public class BoardService {
	
	private BoardDao dao = BoardDao.getInstance();
	
	//�ñ��ȸ�����
	public int enrollBoard(Board board) {
		System.out.println("sql 1 ");
		int enrollMap = dao.insertBoard(board);
		System.out.println("sql 2 :" +enrollMap);
		
		return enrollMap;
	}
	
	
	//����ȸ����ü���� 
	public ArrayList<Board> findBoardAll() {
		ArrayList<Board> list = dao.selectList();
		return list;
	}
	
	//����ȸ���ۺ��� (�Խ��Ǳ۹�ȣ)
			public Board findBoard(int boardNumber) {
				Board board = dao.selectBoard(boardNumber);
				System.out.println("\n## service result : " + board);
				return board;

			}
	
	
	
	

}
