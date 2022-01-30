package kh.spring.dto;

public class HeartDTO {
	private int seq;
	private int refChalSeq;
	private String refNickname;
	private int heart;
	public HeartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeartDTO(int seq, int refChalSeq, String refNickname, int heart) {
		super();
		this.seq = seq;
		this.refChalSeq = refChalSeq;
		this.refNickname = refNickname;
		this.heart = heart;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getRefChalSeq() {
		return refChalSeq;
	}
	public void setRefChalSeq(int refChalSeq) {
		this.refChalSeq = refChalSeq;
	}
	public String getRefNickname() {
		return refNickname;
	}
	public void setRefNickname(String refNickname) {
		this.refNickname = refNickname;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
	
}
