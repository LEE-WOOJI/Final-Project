package kh.spring.dto;

public class RefundDTO {
	private int seq;
	private int chalSeq;
	private String chalName;
	private int price;
	private int rate;
	private String nickname;
	private String bank;
	private String account;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getChalSeq() {
		return chalSeq;
	}
	public void setChalSeq(int chalSeq) {
		this.chalSeq = chalSeq;
	}
	public String getChalName() {
		return chalName;
	}
	public void setChalName(String chalName) {
		this.chalName = chalName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public RefundDTO(int seq, int chalSeq, String chalName, int price, int rate, String nickname, String bank,
			String account) {
		super();
		this.seq = seq;
		this.chalSeq = chalSeq;
		this.chalName = chalName;
		this.price = price;
		this.rate = rate;
		this.nickname = nickname;
		this.bank = bank;
		this.account = account;
	}
	public RefundDTO() {}
	
}
