package kh.spring.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import kh.spring.dto.HeartDTO;

public class HeartDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public HeartDTO findHeart(Map<String, Integer> map) {
		return mybatis.selectOne("Heart.findHeart",map); 
	}
	public HeartDTO findHeart(HeartDTO hdto) {
		return mybatis.selectOne("Heart.findHeart",hdto);
	}

	// 좋아요 정보(heart_table에 게시글 번호, 회원 번호) 저장
	public int insertHeart(HeartDTO hdto) {
		return mybatis.insert("Heart.insertHeart", hdto);
	}

	// 좋아요 삭제
	public void deleteHeart(HeartDTO hdto) {
		mybatis.delete("Heart.deleteHeart",hdto);
	}

}
