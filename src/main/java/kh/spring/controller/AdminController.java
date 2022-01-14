package kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import kh.spring.service.AdminService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService aService;

	@RequestMapping("main") // 메인으로 이동.
	public String main(Model model) {
		return "/admin/adminMain";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}
