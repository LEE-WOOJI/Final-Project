package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ChalLikeDTO;
import kh.spring.dto.HeartDTO;
@Repository
public class HeartDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	
	public int findHeart(HeartDTO hdto) {
		return mybatis.selectOne("Heart.findHeart",hdto);
	}

	// 좋아요 정보(heart_table에 게시글 번호, 회원 번호) 저장
	public int insertHeart(HeartDTO hdto) {
		return mybatis.insert("Heart.insertHeart", hdto);
	}

	// 좋아요 삭제
	public int deleteHeart(HeartDTO hdto) {
		return mybatis.delete("Heart.deleteHeart",hdto);
	}
	
	
	// 닉네임으로 찜한 글피의 시퀀스 찾기
	public List<Integer> selectRefSeq(String nickname){
		return mybatis.selectList("Heart.selectRefSeq",nickname);
	}
	

}
