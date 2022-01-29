package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.ChalingService;
import kh.spring.service.MypageService;
import kh.spring.service.UserService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {

	@Autowired
	ChalingService chservice; 
	@Autowired
	MypageService memberService;
	@Autowired
	BoardReplyService brService;

	//회원 마이페이지 홈
	@RequestMapping("info")
	public String mypage(Model model ,int seq, HttpServletRequest request) {
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		System.out.print(memberDTO.toString());
		return "user/mypage";

	}
	//참여중인 목록
	@RequestMapping("chaling")
	public String chalingPage(Model model,String nickName ,HttpServletRequest request) {
//		// 로그인아이디 세션값 저장.
//		HttpSession session = request.getSession();
//		session.setAttribute("loginID", "qweobnk");
//		// 로그인아이디 세션값 꺼내기.
//		String id = (String) session.getAttribute("loginID");
//		System.out.println(id);
//		// 아이디값으로 정보찾기
//		MemberDTO info = brService.searchInfoById(id);
//		String joinChalNickname = info.getNickname();
//		System.out.println(joinChalNickname);
//		// 닉네임 세션값 저장.
//		session.setAttribute("joinChalNickname", joinChalNickname);
		List<JoinChalDTO> joinChalList = memberService.getUserChalList(nickName);
		model.addAttribute("list", joinChalList);;
		return "/user/chaling";
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
	@RequestMapping("updateUserInfo")
	public String  updateUesrInfoPage(Model model, int seq) {
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		return "user/updateUserInfo";
	}
	
	@RequestMapping("delete")
	public String deleteUser(int seq) {
		memberService.delete(seq);
		return "home";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}