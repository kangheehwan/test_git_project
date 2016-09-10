package work.model.service;

import java.util.ArrayList;

import work.model.dao.CaringDao;
import work.model.dto.Board;
import work.model.dto.Caring;
import work.model.dto.Manager;

public class CaringService {

	private CaringDao dao = CaringDao.getInstance();

	// 맡기미강아지등록
	public int enrollPet(Caring caring) {
		int enrollMap = dao.insertPet(caring);

		return enrollMap;
	}

	// 돌봄현황보기
	public Caring findCaring(String cNumber) {
		Caring caring = dao.selectOne(cNumber);
		System.out.println("\n## service result : " + caring);
		return caring;

	}

	// 돌보미해제
	public void deleteCaring(String cNumber) {
	
		dao.deleteCaring(cNumber);

	}

	

}
