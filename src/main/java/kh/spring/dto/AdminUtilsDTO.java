package kh.spring.dto;

public class AdminUtilsDTO {
	// 등급 출력시 사용.
	private int goldcount;
	private int silvercount;
	private int bronzecount;
	
	public AdminUtilsDTO() {
		
	}
	
	public AdminUtilsDTO(int goldcount, int silvercount, int bronzecount) {
		this.goldcount = goldcount;
		this.silvercount = silvercount;
		this.bronzecount = bronzecount;
	}
	
	public int getGoldcount() {
		return goldcount;
	}
	public void setGoldcount(int goldcount) {
		this.goldcount = goldcount;
	}
	public int getSilvercount() {
		return silvercount;
	}
	public void setSilvercount(int silvercount) {
		this.silvercount = silvercount;
	}
	public int getBronzecount() {
		return bronzecount;
	}
	public void setBronzecount(int bronzecount) {
		this.bronzecount = bronzecount;
	}
}
