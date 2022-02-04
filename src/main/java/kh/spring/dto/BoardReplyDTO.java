package kh.spring.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


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
	
	// 날짜 가공해서 출력.
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.format(write_date.getTime());
	}
	
	// 날짜 시간 디테일하게 출력.
	public String getDetailDate() {
		long current_time = System.currentTimeMillis();
		long write_time = this.write_date.getTime();
		
		long time_gap = current_time - write_time;
		
		if(time_gap < 1000*60) {
			return "방금 전"; 
		}else if(time_gap < 1000*60*60) {
			return time_gap/1000/60 + "분 전"; 
		}else if(time_gap < 1000*60*60*24) {
			return time_gap/1000/60/60 + "시간 전";
		}else {
			return this.getFormedDate();
		}
	}	
}
