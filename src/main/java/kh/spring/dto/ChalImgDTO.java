package kh.spring.dto;

public class ChalImgDTO {
	private int seq;
	private int chalSeq;
	private String oriName;
	private String sysName;
	
	public ChalImgDTO() {}

	public ChalImgDTO(int seq, int chalSeq, String oriName, String sysName) {
		super();
		this.seq = seq;
		this.chalSeq = chalSeq;
		this.oriName = oriName;
		this.sysName = sysName;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getchalSeq() {
		return chalSeq;
	}
	public void setchalSeq(int chalSeq) {
		this.chalSeq = chalSeq;
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