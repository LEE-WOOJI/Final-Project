package kh.spring.controller;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ChalDTO;
import kh.spring.dto.RefundDTO;
import kh.spring.service.CertiService;
import kh.spring.service.ChalService;
import kh.spring.service.RefundService;


@RequestMapping("/user/")
@Controller
public class UserController {
	
	@Autowired
	private ChalService cservice;
	
	@Autowired
	private CertiService ctservice;
	
	@Autowired
	private RefundService rservice;
	
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
  
    //유저 환급 정보
    @RequestMapping("refundInfo")
    public String refundInfo(String nickname, int chalSeq, Model model) {
    	ChalDTO chalInfo = cservice.chalInfo(chalSeq);
    	int certiCount = ctservice.certiCount(nickname, chalSeq);
    	Timestamp startDate = chalInfo.getStartDate();
    	Timestamp endDate = chalInfo.getEndDate();
    	int day = Integer.parseInt(chalInfo.getDay());
    	int rate = (certiCount/day)*100; //100을 곱해주는 이유 프론트 단에서 귀찮게 단위변경안하기 위해_걍 정수로 보내주고 나중에 계산할때 나눠주면됨
    	int price = 0;
    	if(rate >= 50){
    		price = (10000 * rate)/100;
    	}else {
    		price = 0;
    	}
    	RefundDTO dto = new RefundDTO(0,chalInfo.getChalSeq(),chalInfo.getChalName(),price,rate,nickname,null,null);
    	model.addAttribute("dto",dto);
    	model.addAttribute("startDate",startDate);
    	model.addAttribute("endDate",endDate);
    	return "/user/refundInfo";
    }
    
    //유저 환급 신청
    @RequestMapping("refund")
    public String refund(String nickname, int chalSeq, String bank, String account, Model model) {
    	ChalDTO chalInfo = cservice.chalInfo(chalSeq);
    	int certiCount = ctservice.certiCount(nickname, chalSeq);
    	int day = Integer.parseInt(chalInfo.getDay());
    	int rate = (certiCount/day)*100; //100을 곱해주는 이유 프론트 단에서 귀찮게 단위변경안하기 위해_걍 정수로 보내주고 나중에 계산할때 나눠주면됨
    	int price = 0;
    	if(rate >= 50){
    		price = (10000 * rate)/100;
    	}else {
    		price = 0;
    	}
    	int result = rservice.insert(new RefundDTO(0,chalInfo.getChalSeq(),chalInfo.getChalName(),price,rate,nickname,bank,account));
    	System.out.println("실행 결과 : " + result);
    	return "/user/mypage";
    }
    
}