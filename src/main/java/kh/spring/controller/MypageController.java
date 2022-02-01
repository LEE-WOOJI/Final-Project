package kh.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.BoardService;
import kh.spring.service.MypageService;

@Controller
@RequestMapping("/mypage/")
public class MypageController<ProfileDTO> {

	@Autowired
	private HttpSession session;
	@Autowired
	private MypageService memberService;
	@Autowired
	private BoardReplyService brService;
	@Autowired
	private BoardService bService;
	private int ProfileDTO;
	private MypageService mService;

//	@RequestMapping("mypageUserUpdate")
//	public String  mypageUserUpdatePage(Model model, int nickname) {
//		MemberDTO memberDTO = memberService.selectBySeq(nickname);
//		model.addAttribute("nickname",memberDTO);
//		return "/mypage/mypageUserUpdate";
//	}

	@RequestMapping("mypageUserUpdate")
	public String update(HttpServletRequest httpServletRequest,Model model) {
		
		String nickname = (String)session.getAttribute("writerNickname");
		String phone = httpServletRequest.getParameter("phone");
		String email = httpServletRequest.getParameter("email");
		String address1 = httpServletRequest.getParameter("address1");
		String address2 = httpServletRequest.getParameter("address2");
		String pw = httpServletRequest.getParameter("pw");
		MemberDTO memberDTO = memberService.selectBySeq(nickname);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		memberDTO.setAddress1(address1);
		memberDTO.setAddress2(address2);
		memberDTO.setPw(pw);
		model.addAttribute("user",memberDTO);
		memberService.update(memberDTO);
		return "/mypage/mypageUserUpdate";
	}

//	@RequestMapping("updateUserProfile")
//	public String updateUserProfile(Model model, int nickname) {
//		MemberDTO memberDTO = memberService.selectBySeq(nickname);
//		model.addAttribute("user",memberDTO);
//		return "mypage/updateProfile";
//	}

//	@RequestMapping("updateUserProfileAction")
//	public String updateUserProfileAction(Model model,HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws IOException {
//		int nickname = Integer.parseInt(httpServletRequest.getParameter("nickname"));
//		String realPath = session.getServletContext().getRealPath("files");
//		System.out.print(realPath);
//		String filename ="ssh.png";
//		//		FileCopyUtils.copy(file.getBytes(), new File(realPath+"/"+filename));
//		File f = new File(realPath+"/"+filename);
//		MemberDTO memberDTO = memberService.selectBySeq(nickname);
//		model.addAttribute("user",memberDTO);
//		return "user/updateProfile";
//	}

//	//회원정보
//	@RequestMapping("info")
//	public String mypage(Model model ,int nickname, HttpServletRequest request) {
//		MemberDTO memberDTO = memberService.selectBySeq(nickname);
//		model.addAttribute("user",memberDTO);
//		System.out.print(memberDTO.toString());
//		return "user/mypage";
//	}

//	참여중인 목록 메인으로 이동.
	@RequestMapping("mypageMain")
	public String chalingPage(Model model,HttpServletRequest request) {
		String nickName = (String)session.getAttribute("writerNickname");
		List<JoinChalDTO> joinChalList = memberService.getUserChalList(nickName);
		model.addAttribute("list", joinChalList);
		model.addAttribute("nickName",nickName);
		return "/mypage/mypageMain";
	}

	@RequestMapping("myBoard")
	public String myBoardPage(Model model, String nickName) {
		List<BoardDTO> boardList = memberService.getUserBoard(nickName);
		model.addAttribute("list", boardList);
		return "/user/myBoard";
	}
	@RequestMapping("myBoardReply")
	public String myBoardReply(Model model, String nickName) {
		List<BoardReplyDTO> boardReplyList = memberService.getUserBoardReply(nickName);
		model.addAttribute("list", boardReplyList);
		return "/user/myBoardReply";
	}

	@RequestMapping("delete")
	public String deleteUser(int nickname) {
		memberService.delete(nickname);
		return "home";
	}

	@RequestMapping("certi") // 인증 상세목록으로 이동.
	public String certi(Model model, int chalSeq, String chalName, String refNickname) {
		// 인증한 목록 출력.
		List<CertiDTO> list = mService.findCertiList(chalSeq, chalName, refNickname);
		model.addAttribute("list",list);
		return "/user/certi";
	}

	@RequestMapping("certiWriteForm") // 인증 작성폼으로 이동.
	public String certiWriteForm(Model model, CertiDTO dto) {
		model.addAttribute("list",dto);
		return "/user/certiwriteform";
	}

	// 인증 작성은 ImageController에서 구현.

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
	
	// 마이페이지 프로필 사진 불러오기
//	@RequestMapping("mypage") // 프로필 파일 이미지를 게시판에 불러오기.
//	public void board(String nickname, HttpServletResponse response) throws Exception {
//		// nickname으로 member테이블 seq(profile테이블의 parentSeq)찾기.
//		int parentSeq = memberService.findParentSeq(nickname);
//		// member테이블 seq(profile테이블의 parentSeq)로 imgName 찾기.
////		kh.spring.dto.ProfileDTO dto = memberService.findImgName(parentSeq);
//		ProfileDTO dto = memberService.findImgName(parentSeq);
//		if(dto==null) {
//			String oriName = "profiledefault.jpg";
//			String sysName = "profiledefault.jpg";
//			String realPath = session.getServletContext().getRealPath("files");
//			File target = new File(realPath+"/"+sysName);
//
//			try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
//					DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
//				byte[] fileContents = new byte[(int) target.length()];
//				dis.readFully(fileContents);
//
//				oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
//				response.reset();
//				response.setHeader("Content-Disposition", "attachment; filename="+ oriName);
//
//				dos.write(fileContents);
//				dos.flush();	
//			}
//		}else {
//			String oriName = dto.getOriName();
//			String sysName = dto.getSysName();
//			String realPath = session.getServletContext().getRealPath("files");
//			File target = new File(realPath+"/"+sysName);
//
//			try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
//					DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
//				byte[] fileContents = new byte[(int) target.length()];
//				dis.readFully(fileContents);
//
//				oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
//				response.reset();
//				response.setHeader("Content-Disposition", "attachment; filename="+ oriName);
//
//				dos.write(fileContents);
//				dos.flush();	
//			}
//		}
	}