package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.HeartDAO;
import kh.spring.dto.ChalLikeDTO;
import kh.spring.dto.HeartDTO;

@Service
public class HeartService {
	@Autowired
	private HeartDAO hdao;
//	
//	public int detail(int seq) {
//			
//		return 
//	}
//	public HeartDTO findHeart(int seq, int refChalSeq) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("seq", seq);
//		map.put("refChalSeq", refChalSeq);
//		return hdao.findHeart(map); //이거 쓰는거에요? 밑에 잇어가지구 find'Heart가
//	}
	public int findHeart(HeartDTO hdto) {
		return hdao.findHeart(hdto);
	}
	
	public int insertHeart(HeartDTO hdto) {
		return hdao.insertHeart(hdto);
	}
	
	public int deleteHeart(HeartDTO hdto) {
		return hdao.deleteHeart(hdto);
	}
	
	public List <Integer> selectRefSeq(String nickname){
		return hdao.selectRefSeq(nickname);
	}

	
	
}
