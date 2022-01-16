package kh.spring.dto;

import java.sql.Timestamp;

public class ChalAllDTO {
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
	private int imgseq;
	private String oriName;
	private String sysName;
	private int likeSeq;
	private String refNickName;
	
	public ChalAllDTO() {}
	
	public ChalAllDTO(int chalSeq, String chalName, Timestamp startDate, Timestamp endDate, int personnel,
			String chalInfo, String tag, String price, String day, String category, int imgseq, String oriName,
			String sysName, int likeSeq, String refNickName) {
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
		this.imgseq = imgseq;
		this.oriName = oriName;
		this.sysName = sysName;
		this.likeSeq = likeSeq;
		this.refNickName = refNickName;
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
	public int getImgseq() {
		return imgseq;
	}
	public void setImgseq(int imgseq) {
		this.imgseq = imgseq;
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
	public int getLikeSeq() {
		return likeSeq;
	}
	public void setLikeSeq(int likeSeq) {
		this.likeSeq = likeSeq;
	}
	public String getRefNickName() {
		return refNickName;
	}
	public void setRefNickName(String refNickName) {
		this.refNickName = refNickName;
	}
	
	
	
}
