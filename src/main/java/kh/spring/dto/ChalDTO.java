package kh.spring.dto;

import java.sql.Timestamp;

public class ChalDTO {
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
	private String chalStat;
	
	public ChalDTO() {}
	
	public ChalDTO(int chalSeq, String chalName, Timestamp startDate, Timestamp endDate, int personnel, String chalInfo,
			String tag, String price, String day, String category, String chalStat) {
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
		this.chalStat = chalStat;
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

	public String getChalStat() {
		return chalStat;
	}

	public void setChalStat(String chalStat) {
		this.chalStat = chalStat;
	}
}
