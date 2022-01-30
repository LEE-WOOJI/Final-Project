package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//유저 조회(범위)
	public List<MemberDTO> selectBound(int start, int end){
		Map<String,String> map = new HashMap<>();
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		return mybatis.selectList("User.selectBound", map);
	}
	
	//유저 조회(검색)
	public List<MemberDTO> searchBound(int start,int end, String id, String nickname, String blacklist){
		Map<String,String> map = new HashMap<>();
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		map.put("id",id);
		map.put("nickname", nickname);
		map.put("blacklist", blacklist);
		return mybatis.selectList("User.searchBound", map);
	}
	
	//유저 탈퇴
	public int delete(String id) {
		return mybatis.update("User.delete",id);
	}
	
	//유저 블랙
	public int black(String id, String black) {
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("black", black);
		return mybatis.update("User.black",map);
	}
	
	//등급에 맞는 유저 조회
		public List<MemberDTO> userGrade(String grade){
			return mybatis.selectList("User.userGrade", grade);
	}
		
	//검색 결과에 맞으면서 등급에 맞는 유저 조회
		public List<MemberDTO> userGradeSearch(String grade, String option, String keyword){
			Map<String,String> map = new HashMap<>();
			map.put("grade",grade);
			map.put("option", option);
			map.put("keyword", keyword);
			return mybatis.selectList("User.userGradeSearch", map);
		}
	//원하는 등급으로 변경하기
	public int GradeMeta(String grade, String id) {
		Map<String,String> map = new HashMap<>();
		map.put("grade",grade);
		map.put("id", id);
		return mybatis.update("User.gradeMeta", map);
	}
	//유저 수 
	public int userCount() {
		return mybatis.selectOne("User.userCount");
	}
	
	//검색한 유저 수
	public int userSearchCount(String id, String nickname, String blacklist) {
		Map<String,String> map = new HashMap<>();
		map.put("id",id);
		map.put("nickname", nickname);
		map.put("blacklist", blacklist);
		return mybatis.selectOne("User.userSearchCount", map);
	}
	
}
