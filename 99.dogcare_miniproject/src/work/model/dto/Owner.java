package work.model.dto;

import java.io.Serializable;

import work.util.Utility;

/**
 * @author 강희환
 * @version
 * since jdk 1.8.0.91
 */



/*CREATE TABLE  OWNER(
		USER_ID   VARCHAR(20)    PRIMARY KEY,
	    NAME VARCHAR(20)   NOT NULL,
		USER_PW VARCHAR(20)   NOT NULL,
	    GRADE VARCHAR(10)   NOT NULL,
	    MOBILE   VARCHAR(15)   NOT NULL,
	    ADDRESS VARCHAR(20)      NOT NULL
);
*/


public class Owner implements Serializable {
	
	/*맡기미 아이디*/
	public String userId;
	
	/*맡기미 이름*/
	public String name;
	
	/*사용자 비밀번호*/
	public String userPw;
	
	/*사용자 회원등급*/
	public String grade;
	
	/*사용자 연락처*/
	public String mobile;
	
	/*사용자 아이디*/
	public String address;
	

	public Owner(String userId, String name, String userPw, String grade, String mobile, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.userPw = userPw;
		this.grade = grade;
		this.mobile = mobile;
		this.address = address;
	}
	

	public Owner(String userId, String name, String userPw, String mobile, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.userPw = userPw;
		this.mobile = mobile;
		this.address = address;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(userId);
		builder.append("\t |");
		builder.append(name);
		builder.append("\t |");
		builder.append(userPw);
		builder.append("\t |");
		builder.append(grade);
		builder.append("\t |");
		builder.append(mobile);
		builder.append("\t |");
		builder.append(address);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	

}
