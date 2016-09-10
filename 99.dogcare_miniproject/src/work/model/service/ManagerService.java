package work.model.service;


import java.util.HashMap;
import work.model.dao.ManagerDao;

import work.model.dto.Manager;

public class ManagerService {

	private ManagerDao dao = ManagerDao.getInstance();
	// 로그인
	public HashMap<String, String> login(String cNumber, String userPw) {
		System.out.println("service before");
		HashMap<String, String> loginMap = dao.selectLogin(cNumber, userPw);
		return loginMap;

	}
	
	
	//맡기미회원등록
		public int enrollManager(Manager member) {
			
			member.setGrade("manager");
			member.setDogCare("돌봄대기");
			

			int enrollMap = dao.insertMember(member);
			return enrollMap;
		}
		
	
		//아이디찾기 --Controller => Service => DAO
		public String findcNumber(String name, String mobile) {
			System.out.println(name+mobile);
			String findcNumberMap = dao.findcNumberMobile(name,mobile);
			System.out.println("\n## service result : "+findcNumberMap);
			return findcNumberMap;

		}
		
		//비밀번호 검색
		
		public String findPw(String cNumber, String mobile) {
			System.out.println(cNumber+mobile);
			String finPwMap = dao.findPwFromMobile(cNumber,mobile);
			System.out.println("\n## service result : "+finPwMap);
			return finPwMap;

		}
		
		//맡기미검색(아이디)
		public Manager findMember(String cNumber) {
			Manager member = dao.selectOne(cNumber);
			System.out.println("\n## service result : " + member);
			return member;

		}
		
		//맡기미검색(자격증번호)
				public Manager findManager(String cNumber) {
					Manager member = dao.selectOne(cNumber);
					System.out.println("\n## service result : " + member);
					return member;

				}
		
		
		 // 맡기미회원정보수정(내정보) 요청서비스 --Controller => Service => DAO
		 
		public int updateMember(Manager member) {
			System.out.println("service1");
			int updateInfo = dao.updateMember(member);
			System.out.println("service2:"+updateInfo);
			return updateInfo;
		}
		
		//돌봄여부검사
		public String checkCaring(String cNumber) throws Exception {
			System.out.println("service 1 checkCaring:");
			String checkCaring = dao.checkCaring(cNumber);
			System.out.println("service 2 checkCaring :"+checkCaring);
			return checkCaring;
		}
	

	
	

	
}
