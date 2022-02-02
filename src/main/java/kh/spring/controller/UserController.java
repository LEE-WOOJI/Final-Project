package kh.spring.controller;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.ChalDTO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.RefundDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.CertiService;
import kh.spring.service.ChalService;
import kh.spring.service.MemberService;
import kh.spring.service.RefundService;
import kh.spring.service.UserService;
import kh.spring.utils.EncrpytionUtils;


@RequestMapping("/user/")
@Controller
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	MemberService memberService;
	@Autowired
	private HttpSession session;
	@Autowired
	BoardReplyService brService;
	@Autowired
	private ChalService cservice;

	@Autowired
	private CertiService ctservice;

	@Autowired
	private RefundService rservice;


	// 메인jsp에서 로그인 버튼을 눌렀을떄
	@RequestMapping("loginform")
	public String login() {

		return "/user/login";
	}

	// 회원 로그인 페이지
	@RequestMapping("login")
	public String login(String id,String pw, HttpServletRequest request) {


		int result = memberService.isLoginAllowed(id,EncrpytionUtils.getSHA512(pw));	

		if(result>0) { // 로그인에 성공했을 경우
			HttpSession session = request.getSession(); // 서버쪽 세션 금고에
			session.setAttribute("loginId", id); // loginID라는 키값으로 사용자 ID를 저장

			// 아이디값으로 댓글 정보 찾기.
			MemberDTO info = brService.searchInfoById(id);
			String writerNickname = info.getNickname();
			// 닉네임 세션값 저장.
			session.setAttribute("writerNickname", writerNickname);
			System.out.println("로그인에 성공했습니다.");
		}
		return "redirect:/";
	}

	// 로그아웃 버튼을 눌렀을떄
	@RequestMapping("logout")
	public String logout() {

		session.invalidate();
		return "redirect: /";
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

	//이메일 중복확인
	@RequestMapping("emailcheck")
	@ResponseBody
	public String email(Model model,String email, HttpServletRequest request) {
		HashMap <String, String> returnMap = new HashMap <String, String>();
		MemberDTO result = memberService.isEMAILExist(email);   
		if(result != null) { // 이메일이 없을경우
			return "true";
		}

		return "false";

	}

	// 아이디 찾기 버튼을 눌렀을때 (화면이동)
	@RequestMapping(value="searchIdForm",method = RequestMethod.GET)
	public String searchId() {
		return "/user/searchId";
	}

	//아이디 찾기
	@RequestMapping("searchId")
	@ResponseBody
	public String searchId(Model model,String email, HttpServletRequest request) {
		MemberDTO result = memberService.isEMAILExist(email);	
		if(result != null) { // 이메일이 없을경우
			return result.getId();
		}
		return "";
	}

	// 비밀번호 찾기 버튼을 눌렀을때 (화면이동)
	@RequestMapping(value="searchPwForm",method = RequestMethod.GET)
	public String searchPwForm() {
		return "/user/searchPw";
	}


	//비밀번호 찾기
	@RequestMapping("searchPw")
	@ResponseBody
	public boolean searchPw(Model model,String id, HttpServletRequest request) {
		boolean result = memberService.searchPw(id);   
		return result;
	} 

	// 회원가입 버튼을 눌렀을때
	@RequestMapping("signup")
	public String signup() {
		return "/user/signup";
	}

	// 회원가입 완료 버튼을 눌렀을때
	@RequestMapping("signproc")
	public String signup(Model model, MemberDTO dto, MultipartFile file[]) throws Exception {
		int memSeq = memberService.insertMember(dto);

		for(MultipartFile mf : file) {
			if(!file[0].isEmpty()) {
				String realPath = session.getServletContext().getRealPath("files");

				File realPathFile = new File(realPath);
				if(!realPathFile.exists()) {
					realPathFile.mkdir();   
				}
				String oriName = mf.getOriginalFilename();
				String sysName = UUID.randomUUID()+"_"+oriName;
				mf.transferTo(new File(realPath+"/"+sysName));
				// member image insert
				memberService.insertMemberImg(oriName,sysName,memSeq);
			}
		}

		return "redirect:/user/loginform";
	}

	//카카오 로그인 버튼을 눌렀을떄
	@RequestMapping("kakaologin")
	public String kakaologin(Model model,String nickname,String email,HttpServletRequest request) {

		boolean result = memberService.kakaoInsert(nickname,email);
		if(result) {
			//로그인처리
			HttpSession session = request.getSession(); // 서버쪽 세션 금고에
			session.setAttribute("loginId", email); // loginID라는 키값으로 사용자 ID를 저장
		}else {
			//로그인처리
			HttpSession session = request.getSession(); // 서버쪽 세션 금고에
			session.setAttribute("loginFailId", email); // loginID라는 키값으로 사용자 ID를 저장

			System.out.println("로그인에 성공했습니다.");
		}
		return "redirect:/";
	}

	//예외 처리 
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}


	//유저 환급 정보
	@RequestMapping("refundInfo")
	public String refundInfo(int chalSeq, Model model) {
		System.out.println("정보입니다" + chalSeq);
		String nickname = (String)session.getAttribute("writerNickname");
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

	//유저 취소 정보
	@RequestMapping("cancleInfo")
	public String cancleInfo(int chalSeq, Model model) {
		String nickname = (String)session.getAttribute("writerNickname");
		ChalDTO chalInfo = cservice.chalInfo(chalSeq);
		Timestamp startDate = chalInfo.getStartDate();
		Timestamp endDate = chalInfo.getEndDate();
		int price = 10000;
		RefundDTO dto = new RefundDTO(0,chalInfo.getChalSeq(),chalInfo.getChalName(),price,0,nickname,null,null);
		model.addAttribute("dto",dto);
		model.addAttribute("startDate",startDate);
		model.addAttribute("endDate",endDate);
		return "/user/cancleInfo";
	}

	//유저 환급 신청
	@RequestMapping("refund")
	public String refund(int chalSeq, String bank, String account, Model model) {
		System.out.println("환급이빈다");
		String nickname = (String)session.getAttribute("writerNickname");
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
		List<JoinChalDTO> blist =  cservice.myChalListB(nickname);
		List<JoinChalDTO> plist =  cservice.myChalListP(nickname);
		List<JoinChalDTO> flist =  cservice.myChalListF(nickname);
		model.addAttribute("nickname",nickname);
		model.addAttribute("blist",blist);
		model.addAttribute("plist",plist);
		model.addAttribute("flist",flist);
		return "/user/myChalList ";
	}

	//유저 환급 신청
	@RequestMapping("cancle")
	public String cancle(int chalSeq, String bank, String account, Model model) {
		String nickname = (String)session.getAttribute("writerNickname");
		ChalDTO chalInfo = cservice.chalInfo(chalSeq);
		int price = 10000;
		int result = rservice.insert(new RefundDTO(0,chalInfo.getChalSeq(),chalInfo.getChalName(),price,0,nickname,bank,account));
		System.out.println("실행 결과 : " + result);
		List<JoinChalDTO> blist =  cservice.myChalListB(nickname);
		List<JoinChalDTO> plist =  cservice.myChalListP(nickname);
		List<JoinChalDTO> flist =  cservice.myChalListF(nickname);
		model.addAttribute("nickname",nickname);
		model.addAttribute("blist",blist);
		model.addAttribute("plist",plist);
		model.addAttribute("flist",flist);
		return "/user/myChalList";
	}

}