package work.model.dto;


/*CREATE TABLE BOARD(
		 BOARD_NUMBER    NUMBER(10)    PRIMARY KEY,
		 C_NUMBER VARCHAR(20) NOT NULL,
		 TITLE   VARCHAR(100)   NOT NULL,
		 CONTENT   VARCHAR(100)   NOT NULL,
		 PRICE  varchar(50)   NOT NULL,
		 POSSIBLE_DOG_KIND  VARCHAR(10)   NOT NULL,
		 constraint FK_BOARD_C_NUMBER foreign key(C_NUMBER) references PETMANAGER(C_NUMBER)
);
*/
public class Board {
	
	/*게시글  번호*/
	public int boardNumber;
	
	/*돌보미 자격증 번호*/
	public String cNumber;
	
	/*제목 */
	public String title;
	
	/*자기소개서*/
	public String content;
	
	/*서비스가격*/
	public String price;
	
	/*돌봄가능종*/
	public String possibleDogKind;
	
	
	/**
	 * 게시판 객체
	 * @param boardNumber
	 * @param cNumber
	 * @param title
	 * @param content
	 * @param price
	 * @param possibleDogKind
	 */
	public Board(int boardNumber, String cNumber, String title, String content, String price, String possibleDogKind) {
		super();
		this.boardNumber = boardNumber;
		this.cNumber = cNumber;
		this.title = title;
		this.content = content;
		this.price = price;
		this.possibleDogKind = possibleDogKind;
	}
	
	
	public Board( String cNumber, String title, String content, String price, String possibleDogKind) {
		super();
		this.cNumber = cNumber;
		this.title = title;
		this.content = content;
		this.price = price;
		this.possibleDogKind = possibleDogKind;
	}




	public int getBoardNumber() {
		return boardNumber;
	}


	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}


	public String getcNumber() {
		return cNumber;
	}


	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getPossibleDogKind() {
		return possibleDogKind;
	}


	public void setPossibleDogKind(String possibleDogKind) {
		this.possibleDogKind = possibleDogKind;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [boardNumber=");
		builder.append(boardNumber);
		builder.append(", cNumber=");
		builder.append(cNumber);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", price=");
		builder.append(price);
		builder.append(", possibleDogKind=");
		builder.append(possibleDogKind);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boardNumber;
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
		Board other = (Board) obj;
		if (boardNumber != other.boardNumber)
			return false;
		return true;
	}
	
	

	
	


}


