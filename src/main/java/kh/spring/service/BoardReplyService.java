package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardReplyDAO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.MemberDTO;

@Service
public class BoardReplyService {

	@Autowired
	private BoardReplyDAO bDao;
	
	// 댓글 출력.
	public List<BoardReplyDTO> selectAllBybSeq(int refBoardSeq){
		return bDao.selectAllBybSeq(refBoardSeq);
	}
	
	// 아이디값으로 댓글 정보 찾기.
	public MemberDTO searchInfoById(String id) {
		return bDao.searchInfoById(id);
	}
	
	// 댓글 입력.
	public int insert(int refBoardSeq, String writerNickname, String repContents) {
		return bDao.insert(refBoardSeq, writerNickname, repContents);
	}
	
	// 댓글 수정.
	public int modify(int seq, String repContents) {
		return bDao.modify(seq, repContents);
	}
	
	// 댓글 삭제.
	public int delete(int rseq) {
		return bDao.delete(rseq);
	}
}
