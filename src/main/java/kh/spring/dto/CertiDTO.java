package kh.spring.dto;

import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class CertiDTO {
	private int seq;
	private String refNickname;
	private String certiTitle;
	private String certiContents;
	private Timestamp certiDate;
	
	public CertiDTO() {}

	public CertiDTO(int seq, String refNickname, String certiTitle, String certiContents, Timestamp certiDate) {
		super();
		this.seq = seq;
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
