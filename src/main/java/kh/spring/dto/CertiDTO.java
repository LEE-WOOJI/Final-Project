package kh.spring.dto;

import oracle.sql.TIMESTAMP;

public class CertiDTO {
	private int seq;
	private String refNickname;
	private String certiTitle;
	private String certiContents;
	private TIMESTAMP certiDate;
	
	public CertiDTO() {}

	public CertiDTO(int seq, String refNickname, String certiTitle, String certiContents, TIMESTAMP certiDate) {
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
	public TIMESTAMP getCertiDate() {
		return certiDate;
	}
	public void setCertiDate(TIMESTAMP certiDate) {
		this.certiDate = certiDate;
	}
	
}
