package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.MemberDTO;

@Repository
public class BoardReplyDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	// 댓글 출력.
	public List<BoardReplyDTO> selectAllBybSeq(int refBoardSeq){
		return mybatis.selectList("BoardReply.selectAllBybSeq",refBoardSeq);
	}
	
	// 아이디값으로 댓글 정보 찾기.
	public MemberDTO searchInfoById(String id) {
		return mybatis.selectOne("BoardReply.searchInfoById",id);
	}
	
	// 댓글 입력.
	public int insert(int refBoardSeq, String writerNickname, String repContents) {
		Map<String,String> map = new HashMap<>();
		map.put("refBoardSeq", String.valueOf(refBoardSeq));
		map.put("writerNickname", writerNickname);
		map.put("repContents", repContents);
		return mybatis.insert("BoardReply.insert",map);
	}
	
	// 댓글 수정.
	public int modify(int seq, String repContents) {
		Map<String,String> map = new HashMap<>();
		map.put("seq", String.valueOf(seq));
		map.put("repContents", repContents);
		return mybatis.insert("BoardReply.modify",map);
	}
	
	// 댓글 삭제.
	public int delete(int rseq) {
		return mybatis.insert("BoardReply.delete",rseq);
	}
	
	//마이페이지에서 검색
	public List<BoardReplyDTO> mySearch(String nickname, String option, String keyword){
		Map<String,String> map = new HashMap<>();
		map.put("nickname", nickname);
		map.put("option", option);
		map.put("keyword", keyword);
		return mybatis.selectList("BoardReply.mySearch",map);
	}
}
