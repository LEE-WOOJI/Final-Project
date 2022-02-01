package kh.spring.service;

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

	public MemberDTO selectBySeq(String nickname) {
		return mypageDAO.selectBySeq(nickname);
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
	public int update(MemberDTO memberDTO) {
		return mypageDAO.update(memberDTO);
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
	public CertiImgDTO findCertiImgName(int parentSeq) {
		return mypageDAO.findCertiImgName(parentSeq);
	}

	// 인증한 목록 출력.
	public List<CertiDTO> findCertiList(int chalSeq, String chalName, String refNickname) {
		return mypageDAO.findCertiList(chalSeq,chalName,refNickname);
	}
	
//	//db에서 user 프로필사진 이름 변경
//	public void img_update(String userId, String profile_img)
}