package work.model.service;


import java.util.HashMap;
import work.model.dao.ManagerDao;

import work.model.dto.Manager;

public class ManagerService {

	private ManagerDao dao = ManagerDao.getInstance();
	// �α���
	public HashMap<String, String> login(String cNumber, String userPw) {
		System.out.println("service before");
		HashMap<String, String> loginMap = dao.selectLogin(cNumber, userPw);
		return loginMap;

	}
	
	
	//�ñ��ȸ�����
		public int enrollManager(Manager member) {
			
			member.setGrade("manager");
			member.setDogCare("�������");
			

			int enrollMap = dao.insertMember(member);
			return enrollMap;
		}
		
	
		//���̵�ã�� --Controller => Service => DAO
		public String findcNumber(String name, String mobile) {
			System.out.println(name+mobile);
			String findcNumberMap = dao.findcNumberMobile(name,mobile);
			System.out.println("\n## service result : "+findcNumberMap);
			return findcNumberMap;

		}
		
		//��й�ȣ �˻�
		
		public String findPw(String cNumber, String mobile) {
			System.out.println(cNumber+mobile);
			String finPwMap = dao.findPwFromMobile(cNumber,mobile);
			System.out.println("\n## service result : "+finPwMap);
			return finPwMap;

		}
		
		//�ñ�̰˻�(���̵�)
		public Manager findMember(String cNumber) {
			Manager member = dao.selectOne(cNumber);
			System.out.println("\n## service result : " + member);
			return member;

		}
		
		//�ñ�̰˻�(�ڰ�����ȣ)
				public Manager findManager(String cNumber) {
					Manager member = dao.selectOne(cNumber);
					System.out.println("\n## service result : " + member);
					return member;

				}
		
		
		 // �ñ��ȸ����������(������) ��û���� --Controller => Service => DAO
		 
		public int updateMember(Manager member) {
			System.out.println("service1");
			int updateInfo = dao.updateMember(member);
			System.out.println("service2:"+updateInfo);
			return updateInfo;
		}
		
		//�������ΰ˻�
		public String checkCaring(String cNumber) throws Exception {
			System.out.println("service 1 checkCaring:");
			String checkCaring = dao.checkCaring(cNumber);
			System.out.println("service 2 checkCaring :"+checkCaring);
			return checkCaring;
		}
	

	
	

	
}
