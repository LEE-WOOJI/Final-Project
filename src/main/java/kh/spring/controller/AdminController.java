package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.MemberDTO;
import kh.spring.dto.RefundDTO;
import kh.spring.service.AdminService;
import kh.spring.service.RefundService;
import kh.spring.service.UserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService aService;
	
	@Autowired
	UserService uService;
	
	@Autowired
	RefundService rService;


	//유저 블랙관리 페이지로 이동
	@RequestMapping("userBlack")
	public String black(Model model) {
		List<MemberDTO> list = uService.selectBound(1, 5);
		model.addAttribute("list",list);
		return "/admin/adminUserB";
	}
	
	//유저 블랙관리 페이지 더보기
	@ResponseBody
	@RequestMapping(value = "userBlackMore", produces = "text/html;charset=utf8")
	public String blackMore(int moreNum) {
		int start = moreNum;
	      int end = start + 4;
	      System.out.println(end);
	      List<MemberDTO> list = uService.selectBound(start, end); 
	      Gson glist = new Gson(); 
	      String result = glist.toJson(list); //json으로 변환
	      return result;
	}
	
	//유저 블랙관리 페이지에서 검색
	@RequestMapping("userBlackSearch")
	public String blackSearch(Model model, String id, String nickname, String blacklist) {
		int start = 1;
		int end = start + 4;
		System.out.println(id + ":" + nickname);
		List<MemberDTO> list = uService.searchBound(start, end, id, nickname, blacklist);
		model.addAttribute("list", list);
		model.addAttribute("id",id);
		model.addAttribute("nickname",nickname);
		model.addAttribute("blacklist",blacklist);
		return "/admin/adminUserBS";
	}
	
	//유저 블랙관리 페이지에서 검색하고 더보기
	@ResponseBody
	@RequestMapping(value = "userBlackSearchMore", produces = "text/html;charset=utf8")//유저 블랙 서치 더보기
	public String blackSearchMore(int moreNum, String id, String nickname, String blacklist) {
		int start = moreNum;
		int end = start + 4;
		System.out.println(id);
		System.out.println(moreNum +"유저 블랙 서치들어옴");
		Gson glist = new Gson();
        List<MemberDTO> list = uService.searchBound(start, end, id, nickname, blacklist);
        String result = glist.toJson(list);
        return result;
	}
	
	//유저 블랙 페이지 - 유저 탈퇴
	@RequestMapping("userBlackDelete") 
	public String blackOut(String id) {
		uService.delete(id);
		return "redirect:/admin/userBlack";
	}
	
	
	//유저 블랙 페이지 - 유저 정지
	@RequestMapping("userBlackStop") 
	public String blackStop(String id, String blacklist) {
		System.out.println(blacklist+ ":" +id);
		String black = "Y";
		if(blacklist.equals("Y")) {black = "N";}
		System.out.println(black);
		uService.black(id, black);
		return "redirect:/admin/userBlack";
	}
	
	
	// 유저 등급 관리 페이지로 이동
	@RequestMapping("userGrade") 
	public String grade(Model model) {
		List<MemberDTO> blist = uService.userGrade("bronze");
		List<MemberDTO> slist = uService.userGrade("silver");
		List<MemberDTO> glist = uService.userGrade("gold");
		
		model.addAttribute("blist",blist);
		model.addAttribute("slist",slist);
		model.addAttribute("glist",glist);
		return "/admin/adminUserG";
	}
	
	//유저 등급 관리 페이지에서 검색
	@RequestMapping("userGradeSearch")
	public String gradeSearch(String option, String searchText, Model model) {
		System.out.println(option + ":" + searchText);
		List<MemberDTO> blist = uService.userGradeSearch("bronze", option, searchText);
		List<MemberDTO> slist = uService.userGradeSearch("silver", option, searchText);
		List<MemberDTO> glist = uService.userGradeSearch("gold", option, searchText);
		System.out.println(blist.size());
		model.addAttribute("blist",blist);
		model.addAttribute("slist",slist);
		model.addAttribute("glist",glist);
		return "/admin/adminUserG";
	}
	
	//유저 등급 관리 페이지에서 등급 변경
	@RequestMapping("userGradeMeta")
	public String gradeMeta(String grade, String id) {
		System.out.println(grade + " ; " + id);
		uService.GradeMeta(grade, id);
		return "redirect:/admin/userGrade";
	}
	
	//유저 환급 관리 페이지로 이동
	@RequestMapping("userRefund")
	public String refund(Model model) {
		List<RefundDTO> list = rService.listBound(1, 5);
		model.addAttribute("list",list);
		return "/admin/adminUserR";
	}
	
	//유저 환급 관리 - 환급(삭제)
	@RequestMapping("userRefundGo")
	public String refundGo(String nickname) {
		System.out.println(nickname);
		int result = rService.delete(nickname);
		System.out.println(result);
		return "redirect:/admin/userRefund";
	}
	
	//유저 환급 관리 페이지에서 더보기
	@ResponseBody
	@RequestMapping(value = "userRefundMore" , produces = "text/html;charset=utf8")
	public String refundMore(int moreNum) {
		int start = moreNum;
		int end = start + 4;
		System.out.println(moreNum +"유저 환급 더보기들어옴");
		Gson glist = new Gson();
        List<RefundDTO> list = rService.listBound(start, end);
        String result = glist.toJson(list);
        return result;
	}
	//유저 환급 관리 페이지에서 검색
	@RequestMapping("userRefundSearch")
	public String refundSearch(String chalName, String nickname, Model model) {
		System.out.println(chalName + ":" + nickname);
		int start = 1;
		int end = start + 4;
		List<RefundDTO> list = rService.refundSearch(start, end, chalName, nickname);
		model.addAttribute("list",list);
		return "/admin/adminUserRS";
	}
	
	//유저 환급 관리 페이지에서 검색하고 더보기
	@ResponseBody
	@RequestMapping("userRefundSearchMore")
	public String refundSearchMore(int moreNum, String chalName, String nickname, Model model) {
		int start = moreNum;
		int end = start + 4;
		System.out.println(moreNum +"유저 환급 검색 더보기들어옴");
		Gson glist = new Gson();
        List<RefundDTO> list = rService.listBound(start, end);
        String result = glist.toJson(list);
        return result;
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}
