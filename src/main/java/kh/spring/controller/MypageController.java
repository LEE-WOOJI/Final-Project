package kh.spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.BoardService;
import kh.spring.service.ChalService;
import kh.spring.service.HeartService;
import kh.spring.service.MypageService;
import kh.spring.service.RefundService;

@RequestMapping("/mypage/")
@Controller
public class MypageController {

	@Autowired
	private HttpSession session;
	@Autowired
	private MypageService memberService;
	@Autowired
	private BoardReplyService brService;
	@Autowired
	private MypageService mService;
	@Autowired
	private BoardService bService;
	@Autowired
	private ChalService cservice;
	@Autowired
	private RefundService rservice;
	@Autowired
	private HeartService hservice;
	
	//회원정보
	@RequestMapping("updateUserInfo")
	public String  updateUesrInfoPage(Model model, int seq) {
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		return "user/updateUserInfo";
	}
	//회원정보 폼
	@RequestMapping("updateForm")
	public String updateForm(Model model) {
		String id = (String) session.getAttribute("loginId");
		MemberDTO memberDTO = memberService.userInfo(id);
		model.addAttribute("dto",memberDTO);
		return "user/mypageUserUpdate";
		
	}
	
	//회원정보 수정은 ImageController에서 구현.

	@RequestMapping("updateUserProfileAction")
	public String updateUserProfileAction(Model model,HttpServletRequest httpServletRequest, @RequestParam("file") MultipartFile file) throws IOException {
		int seq = Integer.parseInt(httpServletRequest.getParameter("seq"));
		String realPath = session.getServletContext().getRealPath("files");
		System.out.print(realPath);
		String filename ="ssh.png";
		//		FileCopyUtils.copy(file.getBytes(), new File(realPath+"/"+filename));
		File f = new File(realPath+"/"+filename);
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		return "user/updateProfile";
	}

	//회원 마이페이지 홈
	@RequestMapping("info")
	public String mypage(Model model ,int seq, HttpServletRequest request) {
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		System.out.print(memberDTO.toString());
		return "/user/mypage";

	}
	//참여중인 목록
	@RequestMapping("myChalList")
	public String myChalList(Model model) {
		String nickname = (String)session.getAttribute("writerNickname");
		List<JoinChalDTO> blist =  cservice.myChalListB(nickname);
		List<JoinChalDTO> plist =  cservice.myChalListP(nickname);
		List<JoinChalDTO> flist =  cservice.myChalListF(nickname);
		model.addAttribute("nickname",nickname);
		model.addAttribute("blist",blist);
		model.addAttribute("plist",plist);
		model.addAttribute("flist",flist);
		return "/user/myChalList";
	}

	//환급 신청되는지 확인
	@ResponseBody
	@RequestMapping(value ="refundOk", produces = "text/html;charset=utf8")
	public String chalCancel(int chalSeq) {
		String nickname = (String)session.getAttribute("writerNickname");
		System.out.println("들어오나" + chalSeq);
		//중복확인 메서드
		int num = rservice.refundOk(nickname, chalSeq);
		System.out.println("결과값" + num);
		if(num == 1) {
			return "true";
		}
		return "false";
	}
	//내가 작성한 글과 댓글
	@RequestMapping("myBoardAndReply")
	public String myBoardPage(Model model) {
		String nickname = (String)session.getAttribute("writerNickname");
		List<BoardDTO> boardList = memberService.getUserBoard(nickname);
		List<BoardReplyDTO> boardReplyList = memberService.getUserBoardReply(nickname);
		model.addAttribute("nickname",nickname);
		model.addAttribute("blist", boardList);
		model.addAttribute("rlist", boardReplyList);
		return "/user/mypageBoard";
	}
	@RequestMapping("myBARSearch")
	public String myBoardReply(Model model, String option, String keyword) {
		String nickname = (String)session.getAttribute("writerNickname");
		System.out.println(option + ":" + keyword);
		if(option.equals("title")) {
			List<BoardDTO> boardList = bService.mySearch(nickname, option, keyword);
			List<BoardReplyDTO> boardReplyList = memberService.getUserBoardReply(nickname);
			model.addAttribute("nickname",nickname);
			model.addAttribute("blist", boardList);
			model.addAttribute("rlist", boardReplyList);
		}else if(option.equals("contents")) {
			List<BoardDTO> boardList = bService.mySearch(nickname, option, keyword);
			List<BoardReplyDTO> boardReplyList = brService.mySearch(nickname, "repContents", keyword);
			model.addAttribute("nickname",nickname);
			model.addAttribute("blist", boardList);
			model.addAttribute("rlist", boardReplyList);
		}else if(option.equals("seq")) {
			List<BoardDTO> boardList = bService.mySearch(nickname, option, keyword);
			List<BoardReplyDTO> boardReplyList = brService.mySearch(nickname, "refBoardSeq", keyword);
			model.addAttribute("nickname",nickname);
			model.addAttribute("blist", boardList);
			model.addAttribute("rlist", boardReplyList);
		}
		return "/user/mypageBoard";
	}
	//회원정보삭제
	@RequestMapping("delete")
	public String deleteUser() {
		String id = (String) session.getAttribute("loginId");
		memberService.delete(id);
		session.invalidate();
		session.removeAttribute("loginId");
		return "redirect:/";
	}

	@RequestMapping("certi") // 인증 상세목록으로 이동.
	public String certi(Model model, String chalName, int refChalSeq) {
		int chalSeq = refChalSeq;
		String nickname = (String)session.getAttribute("writerNickname");
		// 인증한 목록 출력.
		List<CertiDTO> list = mService.findCertiList(chalSeq, chalName, nickname);
		CertiDTO info = new CertiDTO();
		info.setChalSeq(chalSeq);
		info.setChalName(chalName);
		info.setRefNickname(nickname);
		model.addAttribute("list",list);
		model.addAttribute("info",info);
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

	@RequestMapping("like") // 찜 페이지로 이동
	public String like() {
		String nickname = (String)session.getAttribute("writerNickname");
		// 닉네임으로 찜한 글피 seq 값 뽑기.
		List<Integer> list =  new ArrayList<Integer>();
		list = hservice.selectRefSeq(nickname);
		
		for(int i=0; i < list.size(); i++) {
		         			
		        }
		
//		
//		for(~){
//			리스트에 담겨진 chalSeq값 하나씩 뽑아서 chalInfo()안에 넣고 그 정보값을 ChalLikeDTO에 저장하는 내용
//			}
		
		return "/user/like";
	}
}