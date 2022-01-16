package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ChalBasicDTO;

@Repository
public class ChalDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전체 조회하기
	public List<ChalBasicDTO> listBound(int start, int end){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);		
		return mybatis.selectList("Chal.listBound", map);
	}
}
