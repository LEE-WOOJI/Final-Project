package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CertiImgDTO;
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
	
	//검색하기 1.제목
	public List<ChalBasicDTO> searchK(int start, int end, String keyword){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);
		map.put("keyword", keyword);
		return mybatis.selectList("Chal.searchK", map);
	}
	
	//검색하기 2.태그
		public List<ChalBasicDTO> searchT(int start, int end, String keyword){
			Map<Object,Object> map = new HashMap<>();
			map.put("start",start);
			map.put("end", end);
			map.put("keyword", keyword);
			return mybatis.selectList("Chal.searchT", map);
	}
	
	//검색하기 3.일수
	public List<ChalBasicDTO> searchD(int start, int end, String keyword){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);
		map.put("keyword", keyword);
		return mybatis.selectList("Chal.searchD", map);
	}
	

	//디테일 페이지로 가져갈, 해당 chalSeq로 관련 정보 select
	public ChalBasicDTO selectBySeq(int seq) {
		return mybatis.selectOne("Chal.selectBySeq",seq);

	}
	
	//디테일 페이지에서 보여질 사용자 인증샷 select
	public List<CertiImgDTO> selectCertiImg(int seq){
		return mybatis.selectList("Chal.selectCertiImg", seq);
	}
}
