package kh.spring.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CertiDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//어떠한 유저가 어떤 챌린지에 대해 몇번 인증을 올렸는지 확인
	public int certiCount(String nickname, int chalSeq) {
		Map<Object,Object> map = new HashMap<>();
		map.put("nickname",nickname);
		map.put("chalSeq", String.valueOf(chalSeq));		
		return mybatis.selectOne("Certi.certiCount", map);
	}
}
