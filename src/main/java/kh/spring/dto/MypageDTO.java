package kh.spring.dto;

public class MypageDTO {
	private int seq;
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String phone;
	private String email;
	private String bank;
	private String account;
	private String money;
	private String grade;
	private String blacklist;
	private String kakaologin;
	
	public MypageDTO() {}

	public MypageDTO(int seq, String id, String pw, String name, String nickname, String phone, String email, String bank,
			String account, String money, String grade, String blacklist, String kakaologin) {
		super();
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
		this.bank = bank;
		this.account = account;
		this.money = money;
		this.grade = grade;
		this.blacklist = blacklist;
		this.kakaologin = kakaologin;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBlacklist() {
		return blacklist;
	}
	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}
	public String getKakaologin() {
		return kakaologin;
	}
	public void setKakaologin(String kakaologin) {
		this.kakaologin = kakaologin;
	}
	
}
