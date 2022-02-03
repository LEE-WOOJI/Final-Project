package kh.spring.dto;

public class HeartDTO {
	private int hseq;
	private int refChalSeq;
	private String refNickname;
	private int heart;
	public HeartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeartDTO(int hseq, int refChalSeq, String refNickname, int heart) {
		super();
		this.hseq = hseq;
		this.refChalSeq = refChalSeq;
		this.refNickname = refNickname;
		this.heart = heart;
	}
	public int gethseq() {
		return hseq;
	}
	public void sethseq(int hseq) {
		this.hseq = hseq;
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
