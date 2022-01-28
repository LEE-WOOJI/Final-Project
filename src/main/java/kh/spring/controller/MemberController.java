package kh.spring.controller;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.MemberService;


@RequestMapping("/user/")
@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	private HttpSession session;
	@Autowired
    BoardReplyService brService;
	
	  // 메인jsp에서 로그인 버튼을 눌렀을떄
    @RequestMapping("loginform")
    public String login() {
    	
    
        return "/user/login";
    }

    // 회원 로그인 페이지
    @RequestMapping("login")
    public String login(String id,String pw, HttpServletRequest request) {
    	System.out.println("컨트롤러"+id+pw);
    	int result = memberService.isLoginAllowed(id,pw);	
    	System.out.println("컨트롤러 result"+result);
		if(result>0) { // 로그인에 성공했을 경우
			HttpSession session = request.getSession(); // 서버쪽 세션 금고에
			session.setAttribute("loginID", id); // loginID라는 키값으로 사용자 ID를 저장
	        // 아이디값으로 댓글 정보 찾기.
	        MemberDTO info = brService.searchInfoById(id);
	        String writerNickname = info.getNickname();
	        // 닉네임 세션값 저장.
	        session.setAttribute("writerNickname", writerNickname);
			
			System.out.println("로그인에 성공했습니다.");
		}
        return "/user/login";
    }
    
    //아이디 중복확인
    @GetMapping("idcheck")
    @ResponseBody
    public String login(Model model,String id, HttpServletRequest request) {
    	HashMap <String, String> returnMap = new HashMap <String, String>();
    	MemberDTO result = memberService.isIDExist(id);	
		if(result != null) { // 아이디가 없을경우
			return "true";
		}
		return "false";
    } 
    
    //비밀번호 중복확인
    @RequestMapping("pwcheck")
    public boolean pw(String pw, HttpServletRequest request) {
    	
    	MemberDTO result = memberService.isPWExist(pw);	
		if(result != null) { // 비밀번호가 일치하지 않을경우
			return true;
		}
        return false;
    }
    
    //닉네임 중복확인
    @RequestMapping("nickcheck")
    @ResponseBody
    public String nickname(Model model,String nickname, HttpServletRequest request) {
    	HashMap <String, String> returnMap = new HashMap <String, String>();
    	MemberDTO result = memberService.isNICExist(nickname);	
		if(result != null) { // 닉넥임이 없을경우
			return "true";
		}
		
        return "false";
        
    }
	
	  // 회원가입 버튼을 눌렀을때
	 @RequestMapping("signup")
	public String signup() {
		
		 
		 return "/user/signup";
	}
	 
	  // 회원가입 완료 버튼을 눌렀을때
	 @RequestMapping("signproc")
	public String signup(Model model, MemberDTO dto) {
		 memberService.insertMember(dto);
		 
		 return "redirect:/user/login";
	}
	 
	 //카카오 로그인 버튼을 눌렀을떄
	 @RequestMapping("kakaologin")
	  public String kakaologin(Model model,String id,String nickname,String email,String blacklist, HttpServletRequest request) {
		 
		 HashMap <String, String> returnMap = new HashMap <String, String>();
	    	int result = memberService.kakaoInsert(id,nickname,email,blacklist);	
		
			
	        return "/user/login";
	    }

		

	
	//예외 처리 
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        e.printStackTrace();
        return "redirect:/";
    }
//    //회원가입 폼 페이지
//    @RequestMapping("signup")
//    public String signup() {
//    	@RequestMapping("modify") // 게시 글 수정.
//    	public String boardModify(Model model, int cpage, int seq, String select, String keyword, BoardDTO dto) {
//    		bService.modify(seq,dto.getTitle(),dto.getContents());
//    		BoardDTO bList = bService.selectBySeq(seq);
//    		model.addAttribute("seq",seq);
//    		model.addAttribute("cpage",cpage);
//    		model.addAttribute("select",select);
//    		model.addAttribute("keyword",keyword);
//    		model.addAttribute("bList",bList);
//    		return "/user/signup";
//    	}
//    	
//    }
//  
    			
    
}