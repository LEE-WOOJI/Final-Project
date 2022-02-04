package kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ChalDTO;
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
	
	// 닉네임으로 찜 목록 출력.
	public List<HeartDTO> selectRefSeq(String nickname) {
		return mybatis.selectList("Heart.selectRefSeq", nickname);
	}
	
	// 글피 정보 출력.
	public ChalDTO selectByChalSeq(int chalSeq) {
		return mybatis.selectOne("Heart.selectByChalSeq", chalSeq);
	}

}
