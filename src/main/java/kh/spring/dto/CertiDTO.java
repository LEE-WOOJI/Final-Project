package kh.spring.dto;

import java.sql.Timestamp;

public class CertiDTO {
	private int seq;
	private int chalSeq;
	private String chalName;
	private String refNickname;
	private String certiTitle;
	private String certiContents;
	private Timestamp certiDate;
	
	public CertiDTO() {}
	
	public CertiDTO(int seq, int chalSeq, String chalName, String refNickname, String certiTitle, String certiContents,
			Timestamp certiDate) {
		super();
		this.seq = seq;
		this.chalSeq = chalSeq;
		this.chalName = chalName;
		this.refNickname = refNickname;
		this.certiTitle = certiTitle;
		this.certiContents = certiContents;
		this.certiDate = certiDate;
	}
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
	public String getRefNickname() {
		return refNickname;
	}
	public void setRefNickname(String refNickname) {
		this.refNickname = refNickname;
	}
	public String getCertiTitle() {
		return certiTitle;
	}
	public void setCertiTitle(String certiTitle) {
		this.certiTitle = certiTitle;
	}
	public String getCertiContents() {
		return certiContents;
	}
	public void setCertiContents(String certiContents) {
		this.certiContents = certiContents;
	}
	public Timestamp getCertiDate() {
		return certiDate;
	}
	public void setCertiDate(Timestamp certiDate) {
		this.certiDate = certiDate;
	}
	
	
}
