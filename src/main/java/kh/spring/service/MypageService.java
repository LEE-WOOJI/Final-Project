package kh.spring.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MypageDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;

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
	public int delete(String id) {
		return mypageDAO.delete(id);
	}
	public List<BoardReplyDTO> getUserBoardReply(String writernickname){
		return mypageDAO.getUserBoardReply(writernickname);
	}
	
	// 회원 정보 수정.
	public int update(MemberDTO dto) {
		return mypageDAO.update(dto);
	}
	// 인증 등록.
	public int insertCerti(CertiDTO dto) throws ParseException {
		return mypageDAO.insertCerti(dto);
	}

	// 인증 이미지 등록.
	public int insertCertiImg(String oriName, String sysName,int certiSeq) {
		return mypageDAO.insertCertiImg(oriName, sysName, certiSeq);
	}

	// 인증 이미지 불러오기.
	public CertiImgDTO findCertiImgName(int seq) {
		return mypageDAO.findCertiImgName(seq);
	}
	
	// 글피 디테일에서 인증 사진 불러오기
	public CertiImgDTO findCertiImgForDetail(int chalSeq) {
		return mypageDAO.findCertiImgForDetail(chalSeq);
	}


	// 인증한 목록 출력.
	public List<CertiDTO> findCertiList(int chalSeq, String chalName, String refNickname) {
		return mypageDAO.findCertiList(chalSeq,chalName,refNickname);
	}
	
	// 인증 중복 검사.
	public int certiCheck(Timestamp certiDate) {
		return mypageDAO.certiCheck(certiDate);
	}
	
	
	//유저 정보 폼
	public MemberDTO userInfo(String id) {
		return mypageDAO.userInfo(id);
		
	}
	
	// seq로 profile테이블의 imgName 찾기.
	public ProfileDTO findProfileImgName(int seq) {
		return mypageDAO.findProfileImgName(seq);
	}
	
	// 프로필 이미지 등록.
	public int insertProfileImg(String oriName,String sysName,int seq) {
		return mypageDAO.insertProfileImg(oriName,sysName,seq);
	}
	
	// 프로필 이미지 수정.
	public int modifyProfileImg(String oriName,String sysName,int seq) {
		return mypageDAO.modifyProfileImg(oriName,sysName,seq);
	}
}