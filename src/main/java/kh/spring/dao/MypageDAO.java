package kh.spring.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;

@Repository
public class MypageDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public MemberDTO selectBySeq(String nickname) {
		return mybatis.selectOne("Mypage.getUser",nickname);
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
	// 인증 등록.
	public int insertCerti(CertiDTO dto) throws ParseException {
		return mybatis.insert("Mypage.insertCerti",dto);
	}
	
	// 인증 이미지 등록.
	public int insertCertiImg(String oriName, String sysName,int certiSeq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("oriName", oriName);
		map.put("sysName", sysName);
		map.put("certiSeq", String.valueOf(certiSeq));
		return mybatis.insert("Mypage.insertCertiImg",map);
	}
	
	// 인증 이미지 불러오기.
	public CertiImgDTO findCertiImgName(int parentSeq) {
		return mybatis.selectOne("Mypage.findCertiImgName",parentSeq);
	}
	
	// 인증한 목록 출력.
	public List<CertiDTO> findCertiList(int chalSeq, String chalName, String refNickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("chalSeq", String.valueOf(chalSeq));
		map.put("chalName", chalName);
		map.put("refNickname", refNickname);
		return mybatis.selectList("Mypage.findCertiList",map);
	}

}