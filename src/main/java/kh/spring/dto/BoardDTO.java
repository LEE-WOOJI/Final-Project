package kh.spring.dto;

import java.sql.Timestamp;

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
	
}
