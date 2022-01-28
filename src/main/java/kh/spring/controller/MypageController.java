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

import kh.spring.dto.ChalDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.ChalingService;
import kh.spring.service.UserService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {

	@Autowired
	ChalingService chservice; 
	@Autowired
	UserService memberService;
	@Autowired
	BoardReplyService brService;

	//회원 마이페이지 홈
	@RequestMapping("mypage")
	public String mypage(Model model ,int seq, HttpServletRequest request) {
		MemberDTO memberDTO = memberService.selectBySeq(seq);
		model.addAttribute("user",memberDTO);
		System.out.print(memberDTO.toString());
		
		// 로그인아이디 세션값 저장.
		HttpSession session = request.getSession();
		session.setAttribute("loginID", "qweobnk");
		return "/user/mypage";
	}
	//참여중인 목록
	@RequestMapping("chaling")
	public String chalingPage(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 로그인아이디 세션값 꺼내기.
		String id = (String) session.getAttribute("loginID");
		System.out.println(id);
		// 아이디값으로 정보찾기
		MemberDTO info = brService.searchInfoById(id);
		String joinChalNickname = info.getNickname();
		System.out.println(joinChalNickname);
		// 닉네임 세션값 저장.
		session.setAttribute("joinChalNickname", joinChalNickname);
		List<JoinChalDTO> joinChalList = memberService.selectMyChal(joinChalNickname);
		model.addAttribute("list", joinChalList);
		return "/user/chaling";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}