package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ChalDTO;

@Controller
@RequestMapping("/mypage/")
public class MypageController {

	@Autowired
	UserService uservice;

	//회원 마이페이지 홈
	@RequestMapping("mypage")
	public String mypage() {
		return "/user/mypage";
	}

	@RequestMapping("chaling")
	public String userpage(int seq, Model model) {
		List<ChalDTO>list = uservice.chaling(seq);
		model.addAttribute("list",list);
		return "/user/chaling";
	}
@ExceptionHandler(Exception.class)
public String exceptionHandler(Exception e) {
	e.printStackTrace();
	return "redirect:/";
}
}