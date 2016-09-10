package work.model.dto;

/*
CREATE TABLE CARING(
		CARE_NUMBER    NUMBER(10)    PRIMARY KEY,
		USER_ID VARCHAR(20)   NOT NULL,
		C_NUMBER VARCHAR(20)  NOT NULL,
		DOG_NUMBER  VARCHAR(15)   NOT NULL,
		DOG_NAME  VARCHAR(20)   NOT NULL,
		DOG_KIND  VARCHAR(20)   NOT NULL,
		DOG_AGE  NUMBER(5)   NOT NULL,
		GENDER VARCHAR(10) NOT NULL,
 		constraint FK_CARING_USERID foreign key(user_Id) references OWNER(user_Id),
  		constraint FK_CARING_C_NUMBER foreign key(C_NUMBER) references PETMANAGER(C_NUMBER)
);
*/
public class Caring {
	
	/*돌봄매칭번호*/
	public int careNumber;
	
	/*주인아이디 번호*/
	public String userId;
	
	/*돌봄 자격증 번호*/
	public String cNumber;
	
	/*강아지등록 번호*/
	public String dogNumber;
	
	/*강아지 이름*/
	public String dogName;
	
	
	/*강아지 이름*/
	public String dogKind;
	
	/*강아지 나이*/
	public int dogAge;
	
	/*강아지 성별*/
	public String gender;

	public Caring(int careNumber, String userId, String cNumber, String dogNumber, String dogName, String dogKind,
			int dogAge, String gender) {
		super();
		this.careNumber = careNumber;
		this.userId = userId;
		this.cNumber = cNumber;
		this.dogNumber = dogNumber;
		this.dogName = dogName;
		this.dogKind = dogKind;
		this.dogAge = dogAge;
		this.gender = gender;
	}
	
	

	public Caring(String userId, String cNumber, String dogNumber, String dogName, String dogKind, int dogAge,
			String gender) {
		super();
		this.userId = userId;
		this.cNumber = cNumber;
		this.dogNumber = dogNumber;
		this.dogName = dogName;
		this.dogKind = dogKind;
		this.dogAge = dogAge;
		this.gender = gender;
	}

	public int getCareNumber() {
		return careNumber;
	}

	public void setCareNumber(int careNumber) {
		this.careNumber = careNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getcNumber() {
		return cNumber;
	}

	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}

	public String getDogNumber() {
		return dogNumber;
	}

	public void setDogNumber(String dogNumber) {
		this.dogNumber = dogNumber;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogKind() {
		return dogKind;
	}

	public void setDogKind(String dogKind) {
		this.dogKind = dogKind;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("caring [careNumber=");
		builder.append(careNumber);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", cNumber=");
		builder.append(cNumber);
		builder.append(", dogNumber=");
		builder.append(dogNumber);
		builder.append(", dogName=");
		builder.append(dogName);
		builder.append(", dogKind=");
		builder.append(dogKind);
		builder.append(", dogAge=");
		builder.append(dogAge);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + careNumber;
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
		Caring other = (Caring) obj;
		if (careNumber != other.careNumber)
			return false;
		return true;
	}

	
}
