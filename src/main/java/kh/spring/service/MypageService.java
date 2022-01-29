package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MypageDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;

@Service
public class MypageService {
	@Autowired
	private MypageDAO mypageDAO;
	
	public MemberDTO selectBySeq(int seq) {
		return mypageDAO.selectBySeq(seq);
	}
	
	public List<JoinChalDTO> getUserChalList(String nickname){
		return mypageDAO.getUserChalList(nickname);
	}
	
	public List<BoardDTO> getUserBoard(String nickname){
		return mypageDAO.getUserBoard(nickname);
	}
	public int delete(int seq) {
		return mypageDAO.delete(seq);
	}
	public List<BoardReplyDTO> getUserBoardReply(String writernickname){
		return mypageDAO.getUserBoardReply(writernickname);
	}
}
