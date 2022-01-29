package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;

@Repository
public class MypageDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDTO selectBySeq(int seq) {
		return mybatis.selectOne("Mypage.getUser",seq);
	}
	
	public List<JoinChalDTO> getUserChalList(String nickname){
		return mybatis.selectList("Mypage.getUserChalList",nickname);
	}
	
	public List<BoardDTO> getUserBoard(String nickname){
		return mybatis.selectList("Mypage.getUserBoard",nickname);
	}
	public int delete(int seq) {
		return mybatis.delete("Mypage.delete",seq);
	}
	public List<BoardReplyDTO> getUserBoardReply(String writernickname){
		return mybatis.selectList("Mypage.getUserBoardReply",writernickname);
	}
	public int update(MemberDTO memberDTO) {
		return mybatis.update("Mypage.updateUserInfo",memberDTO);
	}
}