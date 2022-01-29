package kh.spring.dto;

public class AdminUtilsDTO {
	// 등급 출력시 사용.
	private int goldcount;
	private int silvercount;
	private int bronzecount;

	// 날짜 출력시 사용.
	private String today;
	private String today_1;
	private String today_2;
	private String today_3;
	private String today_4;
	private String today_5;
	private String today_6;

	// 누적 가입자 수 출력시 사용.
	private int signUp;
	private int signUp_1;
	private int signUp_2;
	private int signUp_3;
	private int signUp_4;
	private int signUp_5;
	private int signUp_6;

	// 일일 가입자 수 출력시 사용.
	private int signUpDaily;
	private int signUpDaily_1;
	private int signUpDaily_2;
	private int signUpDaily_3;
	private int signUpDaily_4;
	private int signUpDaily_5;
	private int signUpDaily_6;
	
	// 등급별 결제 수 출력시 사용.
	private int goldPay;
	private int silverPay;
	private int bronzePay;

	public AdminUtilsDTO() {

	}

	public AdminUtilsDTO(int goldcount, int silvercount, int bronzecount, String today, String today_1, String today_2,
			String today_3, String today_4, String today_5, String today_6, int signUp, int signUp_1, int signUp_2,
			int signUp_3, int signUp_4, int signUp_5, int signUp_6, int signUpDaily, int signUpDaily_1,
			int signUpDaily_2, int signUpDaily_3, int signUpDaily_4, int signUpDaily_5, int signUpDaily_6, int goldPay,
			int silverPay, int bronzePay) {
		this.goldcount = goldcount;
		this.silvercount = silvercount;
		this.bronzecount = bronzecount;
		this.today = today;
		this.today_1 = today_1;
		this.today_2 = today_2;
		this.today_3 = today_3;
		this.today_4 = today_4;
		this.today_5 = today_5;
		this.today_6 = today_6;
		this.signUp = signUp;
		this.signUp_1 = signUp_1;
		this.signUp_2 = signUp_2;
		this.signUp_3 = signUp_3;
		this.signUp_4 = signUp_4;
		this.signUp_5 = signUp_5;
		this.signUp_6 = signUp_6;
		this.signUpDaily = signUpDaily;
		this.signUpDaily_1 = signUpDaily_1;
		this.signUpDaily_2 = signUpDaily_2;
		this.signUpDaily_3 = signUpDaily_3;
		this.signUpDaily_4 = signUpDaily_4;
		this.signUpDaily_5 = signUpDaily_5;
		this.signUpDaily_6 = signUpDaily_6;
		this.goldPay = goldPay;
		this.silverPay = silverPay;
		this.bronzePay = bronzePay;
	}

	public int getGoldcount() {
		return goldcount;
	}

	public void setGoldcount(int goldcount) {
		this.goldcount = goldcount;
	}

	public int getSilvercount() {
		return silvercount;
	}

	public void setSilvercount(int silvercount) {
		this.silvercount = silvercount;
	}

	public int getBronzecount() {
		return bronzecount;
	}

	public void setBronzecount(int bronzecount) {
		this.bronzecount = bronzecount;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public String getToday_1() {
		return today_1;
	}

	public void setToday_1(String today_1) {
		this.today_1 = today_1;
	}

	public String getToday_2() {
		return today_2;
	}

	public void setToday_2(String today_2) {
		this.today_2 = today_2;
	}

	public String getToday_3() {
		return today_3;
	}

	public void setToday_3(String today_3) {
		this.today_3 = today_3;
	}

	public String getToday_4() {
		return today_4;
	}

	public void setToday_4(String today_4) {
		this.today_4 = today_4;
	}

	public String getToday_5() {
		return today_5;
	}

	public void setToday_5(String today_5) {
		this.today_5 = today_5;
	}

	public String getToday_6() {
		return today_6;
	}

	public void setToday_6(String today_6) {
		this.today_6 = today_6;
	}

	public int getSignUp() {
		return signUp;
	}

	public void setSignUp(int signUp) {
		this.signUp = signUp;
	}

	public int getSignUp_1() {
		return signUp_1;
	}

	public void setSignUp_1(int signUp_1) {
		this.signUp_1 = signUp_1;
	}

	public int getSignUp_2() {
		return signUp_2;
	}

	public void setSignUp_2(int signUp_2) {
		this.signUp_2 = signUp_2;
	}

	public int getSignUp_3() {
		return signUp_3;
	}

	public void setSignUp_3(int signUp_3) {
		this.signUp_3 = signUp_3;
	}

	public int getSignUp_4() {
		return signUp_4;
	}

	public void setSignUp_4(int signUp_4) {
		this.signUp_4 = signUp_4;
	}

	public int getSignUp_5() {
		return signUp_5;
	}

	public void setSignUp_5(int signUp_5) {
		this.signUp_5 = signUp_5;
	}

	public int getSignUp_6() {
		return signUp_6;
	}

	public void setSignUp_6(int signUp_6) {
		this.signUp_6 = signUp_6;
	}

	public int getSignUpDaily() {
		return signUpDaily;
	}

	public void setSignUpDaily(int signUpDaily) {
		this.signUpDaily = signUpDaily;
	}

	public int getSignUpDaily_1() {
		return signUpDaily_1;
	}

	public void setSignUpDaily_1(int signUpDaily_1) {
		this.signUpDaily_1 = signUpDaily_1;
	}

	public int getSignUpDaily_2() {
		return signUpDaily_2;
	}

	public void setSignUpDaily_2(int signUpDaily_2) {
		this.signUpDaily_2 = signUpDaily_2;
	}

	public int getSignUpDaily_3() {
		return signUpDaily_3;
	}

	public void setSignUpDaily_3(int signUpDaily_3) {
		this.signUpDaily_3 = signUpDaily_3;
	}

	public int getSignUpDaily_4() {
		return signUpDaily_4;
	}

	public void setSignUpDaily_4(int signUpDaily_4) {
		this.signUpDaily_4 = signUpDaily_4;
	}

	public int getSignUpDaily_5() {
		return signUpDaily_5;
	}

	public void setSignUpDaily_5(int signUpDaily_5) {
		this.signUpDaily_5 = signUpDaily_5;
	}

	public int getSignUpDaily_6() {
		return signUpDaily_6;
	}

	public void setSignUpDaily_6(int signUpDaily_6) {
		this.signUpDaily_6 = signUpDaily_6;
	}

	public int getGoldPay() {
		return goldPay;
	}

	public void setGoldPay(int goldPay) {
		this.goldPay = goldPay;
	}

	public int getSilverPay() {
		return silverPay;
	}

	public void setSilverPay(int silverPay) {
		this.silverPay = silverPay;
	}

	public int getBronzePay() {
		return bronzePay;
	}

	public void setBronzePay(int bronzePay) {
		this.bronzePay = bronzePay;
	}
}
