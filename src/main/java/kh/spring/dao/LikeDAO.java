package kh.spring.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.LikeDTO;

@Repository
public class LikeDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public boolean likeCheck(String id, String chalNum) {
		return mybatis.selectMap("Likey.likeCheck",id, chalNum) != null;
	}

}
