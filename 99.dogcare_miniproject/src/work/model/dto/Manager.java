package work.model.dto;

import java.io.Serializable;

/*CREATE TABLE PETMANAGER(
		C_NUMBER VARCHAR(20)    PRIMARY KEY,
		 NAME VARCHAR(20)   NOT NULL,
		 USER_PW VARCHAR(20)   NOT NULL,
		 MOBILE VARCHAR(20)   NOT NULL,
		 GRADE VARCHAR(10)   NOT NULL,
		 POSSIBLE_AREA   VARCHAR(15)   NOT NULL,
		 ENVIROMENT VARCHAR(20)      NOT NULL ,
		 CARRIER   VARCHAR(20)    NOT NULL ,
	     DOG_CARE VARCHAR(10)
);
*/
	
	
public class Manager implements Serializable {	

	/*맡기미 아이디*/
	public String cNumber;
	
	/*맡기미 이름*/
	public String name;
	
	/*사용자 비밀번호*/
	public String userPw;
	
	/*사용자 회원등급*/
	public String grade;
	
	/*사용자 연락처*/
	public String mobile;
	
	/*사용자 돌봄가능지역*/
	public String posssibleArea;
	
	/*거주환경*/
	public String enviroment;
	
	/*경력*/
	public String carrier;
	
	/*현재돌봄여부*/
	public String dogCare;

	public Manager(String cNumber, String name, String userPw, String grade, String mobile, String posssibleArea,
			String enviroment, String carrier, String dogCare) {
		super();
		this.cNumber = cNumber;
		this.name = name;
		this.userPw = userPw;
		this.grade = grade;
		this.mobile = mobile;
		this.posssibleArea = posssibleArea;
		this.enviroment = enviroment;
		this.carrier = carrier;
		this.dogCare = dogCare;
	}

	public Manager(String cNumber, String name, String userPw, String mobile, String posssibleArea,
			String enviroment, String carrier) {
		super();
		this.cNumber = cNumber;
		this.name = name;
		this.userPw = userPw;
		this.mobile = mobile;
		this.posssibleArea = posssibleArea;
		this.enviroment = enviroment;
		this.carrier = carrier;

	}
	
	public Manager(String cNumber, String name, String userPw, String mobile, String posssibleArea,
			String enviroment, String carrier, String dogCare) {
		super();
		this.cNumber = cNumber;
		this.name = name;
		this.userPw = userPw;
		this.mobile = mobile;
		this.posssibleArea = posssibleArea;
		this.enviroment = enviroment;
		this.carrier = carrier;
		this.dogCare = dogCare;
	}

	

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
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

	public String getPosssibleArea() {
		return posssibleArea;
	}

	public void setPosssibleArea(String posssibleArea) {
		this.posssibleArea = posssibleArea;
	}

	public String getEnviroment() {
		return enviroment;
	}

	public void setEnviroment(String enviroment) {
		this.enviroment = enviroment;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getDogCare() {
		return dogCare;
	}

	public void setDogCare(String dogCare) {
		this.dogCare = dogCare;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Manager [cNumber=");
		builder.append(cNumber);
		builder.append(", name=");
		builder.append(name);
		builder.append(", userPw=");
		builder.append(userPw);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", mobile=");
		builder.append(mobile);
		builder.append(", posssibleArea=");
		builder.append(posssibleArea);
		builder.append(", enviroment=");
		builder.append(enviroment);
		builder.append(", carrier=");
		builder.append(carrier);
		builder.append(", dogCare=");
		builder.append(dogCare);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cNumber == null) ? 0 : cNumber.hashCode());
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
		Manager other = (Manager) obj;
		if (cNumber == null) {
			if (other.cNumber != null)
				return false;
		} else if (!cNumber.equals(other.cNumber))
			return false;
		return true;
	}

	
}
