package kh.spring.dto;

public class ProfileDTO {
	private int seq;
	private String parentSeq; //유저seq
	private String oriName;
	private String sysName;
	
	public ProfileDTO() {}
	
	public ProfileDTO(int seq, String parentSeq, String oriName, String sysName) {
		super();
		this.seq = seq;
		this.parentSeq = parentSeq;
		this.oriName = oriName;
		this.sysName = sysName;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getParentSeq() {
		return parentSeq;
	}
	public void setParentSeq(String parentSeq) {
		this.parentSeq = parentSeq;
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
}
