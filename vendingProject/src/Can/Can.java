package Can;

public class Can {

	String canName;
	int canNum;
	int canPrice;

	public Can(String canName, int canNum, int canPrice) {
		super();
		this.canName = canName;
		this.canNum = canNum;
		this.canPrice = canPrice;

	}

	@Override
	public String toString() {
		return "음료이름 : " + canName + ", 음료갯수 : " + canNum + " 음료가격 : " + canPrice + "]";
	}

	public String getCanName() {
		return canName;
	}

	public void setCanName(String canName) {
		this.canName = canName;
	}

	public int getCanNum() {
		return canNum;
	}

	public void setCanNum(int canNum) {
		this.canNum = canNum;
	}

	public int getCanPrice() {
		return canPrice;
	}

	public void setCanPrice(int canPrice) {
		this.canPrice = canPrice;
	}
}
