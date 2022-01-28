package kh.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/user/")
@Controller
public class UserController {
	

    // 회원 로그인 페이지
    @RequestMapping("login")
    public String login() {
        return "/user/login";
    }
    //예외 처리 
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "redirect:/";
    }
    //회원가입 폼 페이지
    @RequestMapping("signup")
    public String signup() {
    	return "/user/signup";
    }
  
}