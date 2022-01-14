package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ChalDTO;

@Repository
public class ChalDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전체 조회하기
	public List<ChalDTO> selectAll(){
		return mybatis.selectList("Chal.selectAll");
	}
}
