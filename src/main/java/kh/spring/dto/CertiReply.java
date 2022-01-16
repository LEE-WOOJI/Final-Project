package kh.spring.dto;

import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class CertiReply {
	private int seq;
	private int refCertiSeq;
	private String writerNickname;
	private Timestamp write_date;
	private String repContents;
	
	public CertiReply() {}

	public CertiReply(int seq, int refCertiSeq, String writerNickname, Timestamp write_date, String repContents) {
		super();
		this.seq = seq;
		this.refCertiSeq = refCertiSeq;
		this.writerNickname = writerNickname;
		this.write_date = write_date;
		this.repContents = repContents;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getRefCertiSeq() {
		return refCertiSeq;
	}
	public void setRefCertiSeq(int refCertiSeq) {
		this.refCertiSeq = refCertiSeq;
	}
	public String getWriterNickname() {
		return writerNickname;
	}
	public void setWriterNickname(String writerNickname) {
		this.writerNickname = writerNickname;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public String getRepContents() {
		return repContents;
	}
	public void setRepContents(String repContents) {
		this.repContents = repContents;
	}
	
}
