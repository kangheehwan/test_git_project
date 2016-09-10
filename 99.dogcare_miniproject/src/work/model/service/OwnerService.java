package work.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import work.model.dao.OwnerDao;

import work.model.dto.Owner;
import work.util.Utility;

public class OwnerService {

	private OwnerDao dao = OwnerDao.getInstance();
	// 로그인
	public HashMap<String, String> login(String userId, String userPw) {
		System.out.println("service before");
		HashMap<String, String> loginMap = dao.selectLogin(userId, userPw);
		return loginMap;

	}
	//아이디중복검사
	public int checkedId(String usrid) throws Exception{
		int checkIdInt = dao.checkId(usrid);
		return checkIdInt;
	}
	
	
	//맡기미등록
	public int enroll(Owner member) {
		
		member.setGrade("owner");

		int enrollMap = dao.insertMember(member);
		return enrollMap;
	}
	
	//맡기미검색(아이디)
	public Owner findMember(String userId) {
		Owner member = dao.selectOne(userId);
		System.out.println("\n## service result : " + member);
		return member;

	}
	
	/**
	 * 맡기미정보수정(내정보) 요청서비스 --Controller => Service => DAO
	 */
	public int updateMember(Owner member) {
		
		int updateInfo = dao.updateMember(member);
		
		return updateInfo;
	}
	/**
	 * 아이디찾기 --Controller => Service => DAO
	 */
	public String findId(String name, String mobile) {
		System.out.println(name+mobile);
		String findIdMap = dao.findIdUseMobile(name,mobile);
		System.out.println("\n## service result : "+findIdMap);
		return findIdMap;

	}
	
	
	/**
	 * 비밀번호찾기 --Controller => Service => DAO
	 */
	public String findPw(String userId, String mobile) {
		System.out.println(userId+mobile);
		String finPwMap = dao.findPwFromMobile(userId,mobile);
		System.out.println("\n## service result : "+finPwMap);
		return finPwMap;

	}
	
	
	
	

	
}
