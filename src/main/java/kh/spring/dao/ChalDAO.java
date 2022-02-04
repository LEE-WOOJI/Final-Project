package kh.spring.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.ChalBasicDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.dto.ChalLikeDTO;
import kh.spring.dto.JoinChalDTO;

@Repository
public class ChalDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//전체 조회하기
	public List<ChalLikeDTO> listBound(int start, int end){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);		
		return mybatis.selectList("Chal.listBound", map);
	}
	
	//검색하기 1.제목
	public List<ChalLikeDTO> searchK(int start, int end, String keyword){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);
		map.put("keyword", keyword);
		return mybatis.selectList("Chal.searchK", map);
	}
	
	//검색하기 2.태그
		public List<ChalLikeDTO> searchT(int start, int end, String keyword){
			Map<Object,Object> map = new HashMap<>();
			map.put("start",start);
			map.put("end", end);
			map.put("keyword", keyword);
			return mybatis.selectList("Chal.searchT", map);
	}
	
	//검색하기 3.일수
	public List<ChalLikeDTO> searchD(int start, int end, String keyword){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);
		map.put("keyword", keyword);
		return mybatis.selectList("Chal.searchD", map);
	}

	//카테고리
	public List<ChalLikeDTO> listCategory(String category){
		return mybatis.selectList("Chal.listCategory", category);
	}
	
	//카테고리 정렬
	public List<ChalLikeDTO> categoryFilter(String category, String filter){
		Map<Object,Object> map = new HashMap<>();
		map.put("category", category);
		map.put("filter", filter);
		return mybatis.selectList("Chal.filter", map);
	}
	
	//디테일 페이지로 가져갈, 해당 chalSeq로 관련 정보 select
	public ChalLikeDTO selectBySeq(int seq) {
		return mybatis.selectOne("Chal.selectBySeq",seq);
	}
	
	//디테일 페이지에서 보여질 사용자 인증샷 select
	public List<CertiImgDTO> selectCertiImg(int seq){
		return mybatis.selectList("Chal.selectCertiImg", seq);
	}
	
	//결제완료 시, 참여자수 +1 카운팅
	public int addPersonnel(int seq) {
		return mybatis.update("Chal.addPersonnel",seq);
	}
	
	// 결제완료 시 , joinChal 테이블에 추가됨
	public int joinChal(int refChalSeq, String nickname, String chalName, Timestamp startDate, 
			Timestamp endDate, int personnel, String chalInfo, String tag, String chalStat) {
		Map<Object,Object> map = new HashMap<>();
		map.put("refChal", refChalSeq);
		map.put("refNickname", nickname);
		map.put("chalName", chalName);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("personnel", personnel);
		map.put("chalInfo", chalInfo);
		map.put("tag", tag);
		map.put("chalStat", chalStat);
		return mybatis.insert("Chal.joinChal", map);

	}
	
	//해당 챌린지가 있는지 확인하고, 정보값을 불러옴
	public ChalDTO chalInfo(int chalSeq) {
		return mybatis.selectOne("Chal.chalInfo", chalSeq);
	}
	
	//어떤 유저가 과거에 참여한 챌린지 조회
	public List<JoinChalDTO> myChalListB(String nickname){
		return mybatis.selectList("Chal.myChalListB", nickname);
	}
	
	//어떤 유저가 참여하고 있는 챌린지 조회
	public List<JoinChalDTO> myChalListP(String nickname){
		return mybatis.selectList("Chal.myChalListP", nickname);
	}
		
	//어떤 유저가 참여할 챌린지 조회
	public List<JoinChalDTO> myChalListF(String nickname){
		return mybatis.selectList("Chal.myChalListF", nickname);
	}
	
	//시퀀스 찾기
	public int seqSearch(String chalName) {
		return mybatis.selectOne("Chal.seqSearch", chalName);
	}

	//중복참여 방지 
	public int alreadyJoined(int seq, String nickname) {
		Map<Object,Object> map = new HashMap<>();
		map.put("seq", seq);
		map.put("nickname", nickname);
		return mybatis.selectOne("Chal.alreadyJoined", map);
	}
		

	//인원추가
	public int addPJ(int chalSeq) {
		return mybatis.update("Chal.addPJ", chalSeq);
	}
}
