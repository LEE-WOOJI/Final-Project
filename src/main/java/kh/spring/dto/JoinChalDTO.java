package kh.spring.dto;

import java.sql.Timestamp;

public class JoinChalDTO {
	private int seq;
	private int refChalSeq; //챌린지 seq 참조
	private String refNickname;
	private String chalName;
	private Timestamp startDate;
	private Timestamp endDate;
	private int personnel;
	private String chalInfo;
	private String tag;
	private String chalStat;
	
	public JoinChalDTO() {}

	public JoinChalDTO(int seq, int refChalSeq, String refNickname, String chalName, Timestamp startDate,
			Timestamp endDate, int personnel, String chalInfo, String tag, String chalStat) {
		super();
		this.seq = seq;
		this.refChalSeq = refChalSeq;
		this.refNickname = refNickname;
		this.chalName = chalName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.personnel = personnel;
		this.chalInfo = chalInfo;
		this.tag = tag;
		this.chalStat = chalStat;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public String getChalStat() {
		return chalStat;
	}
	public void setChalStat(String chalStat) {
		this.chalStat = chalStat;
	}
}
