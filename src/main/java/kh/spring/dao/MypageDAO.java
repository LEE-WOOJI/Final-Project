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

	public MemberDTO selectBySeq(int seq) {
		return mybatis.selectOne("Mypage.getUser",seq);
	}

	public List<JoinChalDTO> getUserChalList(String nickname){
		return mybatis.selectList("Mypage.getUserChalList",nickname);
	}

	public List<BoardDTO> getUserBoard(String nickname){
		return mybatis.selectList("Mypage.getUserBoard",nickname);
	}
	
	public int delete(String id) {
		return mybatis.delete("Mypage.delete",id);
	}
	
	public List<BoardReplyDTO> getUserBoardReply(String writernickname){
		return mybatis.selectList("Mypage.getUserBoardReply",writernickname);
	}
	
	// 회원 정보 수정.
	public int update(MemberDTO dto) {
		return mybatis.update("Mypage.updateUserInfo",dto);
	}

	// 인증 등록.
	public int insertCerti(CertiDTO dto) throws ParseException {
		mybatis.insert("Mypage.insertCerti",dto);
		return dto.getChalSeq();
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
	public CertiImgDTO findCertiImgName(int seq) {
		return mybatis.selectOne("Mypage.findCertiImgName",seq);
	}
	
	// 글피디테일 인증 사진 불러오기
	public CertiImgDTO findCertiImgForDetail(int chalSeq) {
		return mybatis.selectOne("Mypage.findCertiImgName",chalSeq);
	}


	// 인증한 목록 출력.
	public List<CertiDTO> findCertiList(int chalSeq, String chalName, String refNickname) {
		Map<String, String> map = new HashMap<String,String>();
		map.put("chalSeq", String.valueOf(chalSeq));
		map.put("chalName", chalName);
		map.put("refNickname", refNickname);
		return mybatis.selectList("Mypage.findCertiList",map);
	}
	
	//유저 폼
	public MemberDTO userInfo (String id) {
		return mybatis.selectOne("Mypage.userInfo", id);
	}

	// seq로 profile테이블의 imgName 찾기.
	public ProfileDTO findProfileImgName(int seq) {
		return mybatis.selectOne("Mypage.findProfileImgName", seq);
	}
	
	// 프로필 이미지 등록.
	public int insertProfileImg(String oriName,String sysName,int seq) {
		Map<String, String> map = new HashMap<>();
		map.put("oriName", oriName);
		map.put("sysName", sysName);
		map.put("seq", String.valueOf(seq));
		return mybatis.insert("Mypage.insertProfileImg", map);
	}
	
	// 프로필 이미지 수정.
	public int modifyProfileImg(String oriName,String sysName,int seq) {
		Map<String, String> map = new HashMap<>();
		map.put("oriName", oriName);
		map.put("sysName", sysName);
		map.put("seq", String.valueOf(seq));
		return mybatis.update("Mypage.modifyProfileImg", map);
	}
}