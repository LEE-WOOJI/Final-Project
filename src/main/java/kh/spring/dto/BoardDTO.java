package kh.spring.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class BoardDTO {
	private int seq;
	private String title;
	private String contents;
	private String nickname;
	private int view_count;
	private Timestamp write_date;
	
	public BoardDTO() {}

	public BoardDTO(int seq, String title, String contents, String nickname, int view_count, Timestamp write_date) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.nickname = nickname;
		this.view_count = view_count;
		this.write_date = write_date;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
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