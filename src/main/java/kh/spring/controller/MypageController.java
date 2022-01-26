package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.ChalingService;

@Controller
@RequestMapping("/mypage/")
public class MypageController {

	@Autowired
	ChalingService chservice; 

	//회원 마이페이지 홈
	@RequestMapping("mypage")
	public String mypage() {
		return "/user/mypage";
	}
	//진행중이 글피
	@RequestMapping("chaling")
	public String userpage(int seq, Model model) {
		List<ChalDTO>list = chservice.chaling(seq);
		model.addAttribute("list",list);
		return "/user/chaling";
	}
	//회원 정보 보기
//	@RequestMapping("userupdate")
//	public String userupdate(int seq, Model model) {
//		
//	}
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}