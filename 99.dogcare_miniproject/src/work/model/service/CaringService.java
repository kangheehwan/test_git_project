package work.model.service;

import java.util.ArrayList;

import work.model.dao.CaringDao;
import work.model.dto.Board;
import work.model.dto.Caring;
import work.model.dto.Manager;

public class CaringService {

	private CaringDao dao = CaringDao.getInstance();

	// �ñ�̰��������
	public int enrollPet(Caring caring) {
		int enrollMap = dao.insertPet(caring);

		return enrollMap;
	}

	// ������Ȳ����
	public Caring findCaring(String cNumber) {
		Caring caring = dao.selectOne(cNumber);
		System.out.println("\n## service result : " + caring);
		return caring;

	}

	// ����������
	public void deleteCaring(String cNumber) {
	
		dao.deleteCaring(cNumber);

	}

	

}
