package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	// 로그인 기능
	public int isLoginAllowed(String id, String pw) {
		Map<String,String> map = new HashMap<>();
		System.out.println("디에이오"+id+pw);
		//map.put("seq", String.valueOf(seq)); 
		map.put("id", id);
		map.put("pw", pw);
		return mybatis.selectOne("Member.isLoginAllowed", map);
	}
	//아이디 중복체크
	public MemberDTO isIDExist(String id) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		
		return mybatis.selectOne("Member.isIDExist", map);
	}
	//비밀번호 중복체크
	public MemberDTO isPWExist(String pw) {
		Map<String,String> map = new HashMap<>();
		map.put("pw", pw);
		
		return mybatis.selectOne("Member.isPWExist", map);
	}
	//회원가입 성공
	public void insertMember(MemberDTO dto) {
		mybatis.insert("Member.insertMember",dto);
	}
	//닉네임 중복체크
	public MemberDTO isNICExist(String nickname) {
		Map<String,String> map = new HashMap<>();
		map.put("nickname", nickname);
		
		return mybatis.selectOne("Member.isNICExist", map);
	}
	
	
	
	//카카오 로그인

	public int kakaoInsert( String nickname, String email) {
		Map<String,String> map = new HashMap<>();
		map.put("id", email);
		map.put("email", email);
		map.put("nickname", nickname);
		
		return mybatis.insert("Member.kakaoInsert", map);
            
        }
	
	

//	// 게시판 목록 출력.
//	public List<BoardDTO> selectAll(int start, int end){
//		Map<String,String> map = new HashMap<>();
//		map.put("start", String.valueOf(start));
//		map.put("end", String.valueOf(end));
//		return mybatis.selectList("Board.selectAll",map);
//	}
//
//	// 게시판 검색 시 목록 출력.
//	public List<BoardDTO> selectAllSearch(int start, int end, String select, String keyword){
//		Map<String,String> map = new HashMap<>();
//		map.put("start", String.valueOf(start));
//		map.put("end", String.valueOf(end));
//		map.put("select", select);
//		map.put("keyword", keyword);
//		return mybatis.selectList("Board.selectAllSearch",map);
//	}
//
//	// 게시판 글 수 출력.
//	public int getRecordCount() {
//		return mybatis.selectOne("Board.getRecordCount");
//	}
//
//	// 게시판 검색 시 글 수 출력.
//	public int getRecordCountSearch(String select, String keyword) {
//		Map<String,String> map = new HashMap<>();
//		map.put("select", select);
//		map.put("keyword", keyword);
//		return mybatis.selectOne("Board.getRecordCountSearch",map);
//	}
//
//	// seq로 작성한 글의 detail 출력.
//	public BoardDTO selectBySeq(int seq){
//		return mybatis.selectOne("Board.selectBySeq",seq);
//	}
//
//	// 조희수 증가.
//	public int addViewCount(int seq){
//		return mybatis.update("Board.addViewCount",seq);
//	}
//
//	// 게시글 수정.
//	public int modify(int seq, String title, String contents){
//		Map<String,String> map = new HashMap<>();
//		map.put("seq", String.valueOf(seq));
//		map.put("title", title);
//		map.put("contents", contents);
//		return mybatis.update("Board.modify",map);
//	}
//
//	// 게시글 삭제.
//	public int delete(int seq){
//		return mybatis.delete("Board.delete",seq);
//	}
//
//	// nickname으로 member테이블 seq(profile테이블의 parentSeq)찾기.
//	public int findParentSeq(String nickname){
//		return mybatis.selectOne("Board.findParentSeq",nickname);
//	}
//
//	// member테이블 seq(profile테이블의 parentSeq)로 imgName 찾기.
//	public ProfileDTO findImgName(int parentSeq){
//		return mybatis.selectOne("Board.findImgName",parentSeq);
//	}
}
