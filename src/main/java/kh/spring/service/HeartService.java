package kh.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import kh.spring.dao.HeartDAO;
import kh.spring.dto.HeartDTO;

public class HeartService {
	@Autowired
	private HeartDAO hdao;
//	
//	public int detail(int seq) {
//			
//		return 
//	}
	public HeartDTO findHeart(int seq, int refChalSeq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		map.put("refChalSeq", refChalSeq);
		return hdao.findHeart(map); 
	}
	public int insertHeart(HeartDTO hdto) {
		// 좋아요가 DB에 저장이 되는것이 없으면 0이 그대로 리턴으로 넘어감
		int result = 0;
		// 좋아요가 이미 있는지 확인하는 코드
		HeartDTO find = hdao.findHeart(hdto);
		
		// find가 null이면 좋아요가 없는 상태이므로 정보 저장
		// find가 null이 아니면 좋아요가 있는 상태이므로 정보 삭제
		if(find==null) {
			// insert의 리턴값은 DB에 성공적으로 insert된 갯수를 보내므로 result가 1이 됨
			result = hdao.insertHeart(hdto);
		} else {
			hdao.deleteHeart(hdto);
		}
	    	// 0 or 1이 담겨져서 @Controller에 보냄.
		return result;
	}
	
}
