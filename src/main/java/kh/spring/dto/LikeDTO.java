package kh.spring.dto;

public class LikeDTO {
	private int seq;
	private int refChalSeq;
	private String refNickName;
	
	public LikeDTO() {}

	public LikeDTO(int seq, int refChalSeq, String refNickName) {
		super();
		this.seq = seq;
		this.refChalSeq = refChalSeq;
		this.refNickName = refNickName;
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
	public String getRefNickName() {
		return refNickName;
	}
	public void setRefNickName(String refNickName) {
		this.refNickName = refNickName;
	}
	
}
