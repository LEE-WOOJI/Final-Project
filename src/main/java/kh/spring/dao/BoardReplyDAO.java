package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardReplyDTO;

@Repository
public class BoardReplyDAO {

	@Autowired
	SqlSessionTemplate mybatis;
	
	// 댓글 출력.
	public List<BoardReplyDTO> selectAllBybSeq(int refBoardSeq){
		return mybatis.selectList("BoardReply.selectAllBybSeq",refBoardSeq);
	}
	
	// 댓글 입력.
	public int insert(BoardReplyDTO dto) {
		return mybatis.insert("BoardReply.insert",dto);
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
}
