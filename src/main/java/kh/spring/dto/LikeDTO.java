package kh.spring.dto;

public class LikeDTO {
	private String likeNum;
	private String chalNum;
	private String id;
	
	public LikeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeDTO(String likeNum, String chalNum, String id) {
		super();
		this.likeNum = likeNum;
		this.chalNum = chalNum;
		this.id = id;
	}

	public String getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(String likeNum) {
		this.likeNum = likeNum;
	}

	public String getChalNum() {
		return chalNum;
	}

	public void setChalNum(String chalNum) {
		this.chalNum = chalNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
