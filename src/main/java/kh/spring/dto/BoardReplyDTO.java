package kh.spring.dto;

import java.sql.Timestamp;


public class BoardReplyDTO {
	private int seq;
	private int refBoardSeq;
	private String writerNickname;
	private Timestamp write_date;
	private String repContents;
	
	public BoardReplyDTO() {}

	public BoardReplyDTO(int seq, int refBoardSeq, String writerNickname, Timestamp write_date, String repContents) {
		super();
		this.seq = seq;
		this.refBoardSeq = refBoardSeq;
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
	public int getRefBoardSeq() {
		return refBoardSeq;
	}
	public void setRefBoardSeq(int refBoardSeq) {
		this.refBoardSeq = refBoardSeq;
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
