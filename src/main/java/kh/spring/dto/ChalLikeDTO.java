package kh.spring.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ChalLikeDTO {
	//Chal + ChalImg+Like
	private int chalSeq;
	private String chalName;
	private Timestamp startDate;
	private Timestamp endDate;
	private int personnel;
	private String chalInfo;
	private String tag;
	private String price;
	private String day;
	private String category;
	private int seq;
	private String oriName;
	private String sysName;
	private int hseq;
	private int refChalSeq;
	private String refNickname;
	private int heart;
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
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public int getPersonnel() {
		return personnel;
	}
	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}
	public String getChalInfo() {
		return chalInfo;
	}
	public void setChalInfo(String chalInfo) {
		this.chalInfo = chalInfo;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSysName() {
		return sysName;
	}
	public void setSysName(String sysName) {
		this.sysName = sysName;
	}
	public int getHseq() {
		return hseq;
	}
	public void setHseq(int hseq) {
		this.hseq = hseq;
	}
	public int getRefChalSeq() {
		return refChalSeq;
	}
	public void setRefChalSeq(int refChalSeq) {
		this.refChalSeq = refChalSeq;
	}
	public String getRefNickname() {
		return refNickname;
	}
	public void setRefNickname(String refNickname) {
		this.refNickname = refNickname;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	public ChalLikeDTO(int chalSeq, String chalName, Timestamp startDate, Timestamp endDate, int personnel,
			String chalInfo, String tag, String price, String day, String category, int seq, String oriName,
			String sysName, int hseq, int refChalSeq, String refNickname, int heart) {
		super();
		this.chalSeq = chalSeq;
		this.chalName = chalName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.personnel = personnel;
		this.chalInfo = chalInfo;
		this.tag = tag;
		this.price = price;
		this.day = day;
		this.category = category;
		this.seq = seq;
		this.oriName = oriName;
		this.sysName = sysName;
		this.hseq = hseq;
		this.refChalSeq = refChalSeq;
		this.refNickname = refNickname;
		this.heart = heart;
	}
	public ChalLikeDTO() {}
	
	// 디테일 페이지에서 글피 시작까지 남은 시간 계산하기 위한 simpleDateFormat 
		//"yyyy/MM/dd" 이런식으로 날짜를 넣어야해서 추가함.
		public String getDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			return sdf.format(this.startDate.getTime());
		}
		
		// 결제 페이지에서 글피 시작 날짜 표현 부분
		public String getSDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
			return sdf.format(this.startDate.getTime());
		}
		
		// 결제 페이지에서 글피 종료 날짜 표현 부분
		public String getEDate() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
			return sdf.format(this.endDate.getTime());
		}
}
