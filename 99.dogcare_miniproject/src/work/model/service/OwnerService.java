package work.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import work.model.dao.OwnerDao;

import work.model.dto.Owner;
import work.util.Utility;

public class OwnerService {

	private OwnerDao dao = OwnerDao.getInstance();
	// �α���
	public HashMap<String, String> login(String userId, String userPw) {
		System.out.println("service before");
		HashMap<String, String> loginMap = dao.selectLogin(userId, userPw);
		return loginMap;

	}
	//���̵��ߺ��˻�
	public int checkedId(String usrid) throws Exception{
		int checkIdInt = dao.checkId(usrid);
		return checkIdInt;
	}
	
	
	//�ñ�̵��
	public int enroll(Owner member) {
		
		member.setGrade("owner");

		int enrollMap = dao.insertMember(member);
		return enrollMap;
	}
	
	//�ñ�̰˻�(���̵�)
	public Owner findMember(String userId) {
		Owner member = dao.selectOne(userId);
		System.out.println("\n## service result : " + member);
		return member;

	}
	
	/**
	 * �ñ����������(������) ��û���� --Controller => Service => DAO
	 */
	public int updateMember(Owner member) {
		
		int updateInfo = dao.updateMember(member);
		
		return updateInfo;
	}
	/**
	 * ���̵�ã�� --Controller => Service => DAO
	 */
	public String findId(String name, String mobile) {
		System.out.println(name+mobile);
		String findIdMap = dao.findIdUseMobile(name,mobile);
		System.out.println("\n## service result : "+findIdMap);
		return findIdMap;

	}
	
	
	/**
	 * ��й�ȣã�� --Controller => Service => DAO
	 */
	public String findPw(String userId, String mobile) {
		System.out.println(userId+mobile);
		String finPwMap = dao.findPwFromMobile(userId,mobile);
		System.out.println("\n## service result : "+finPwMap);
		return finPwMap;

	}
	
	
	
	

	
}
