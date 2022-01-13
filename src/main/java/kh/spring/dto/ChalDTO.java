package kh.spring.dto;

import oracle.sql.TIMESTAMP;

public class ChalDTO {
	private int seq;
	private String chalName;
	private TIMESTAMP startDate;
	private TIMESTAMP endDate;
	private int personnel;
	private String chalInfo;
	private String tag;
	private String price;
	private String day;
	
	public ChalDTO() {}

	public ChalDTO(int seq, String chalName, TIMESTAMP startDate, TIMESTAMP endDate, int personnel, String chalInfo,
			String tag, String price, String day) {
		super();
		this.seq = seq;
		this.chalName = chalName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.personnel = personnel;
		this.chalInfo = chalInfo;
		this.tag = tag;
		this.price = price;
		this.day = day;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getChalName() {
		return chalName;
	}
	public void setChalName(String chalName) {
		this.chalName = chalName;
	}
	public TIMESTAMP getStartDate() {
		return startDate;
	}
	public void setStartDate(TIMESTAMP startDate) {
		this.startDate = startDate;
	}
	public TIMESTAMP getEndDate() {
		return endDate;
	}
	public void setEndDate(TIMESTAMP endDate) {
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
}
