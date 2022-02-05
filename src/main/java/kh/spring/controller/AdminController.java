package kh.spring.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.AdminUtilsDTO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.RefundDTO;
import kh.spring.service.AdminService;
import kh.spring.service.BoardService;
import kh.spring.service.RefundService;
import kh.spring.service.UserService;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	AdminService aService;

	@Autowired
	BoardService bService;

	@Autowired
	UserService uService;

	@Autowired
	RefundService rService;

	@RequestMapping("main") // 메인으로 이동.
	public String main(Model model) {
		// 회원 수 출력.
		int memberResult = aService.getMemberCount();
		// 자유게시판 글 수 출력.
		int boardResult = aService.getBoardCount();
		// 챌린지 수 출력.
		int chalResult = aService.getChalCount();
		// 등급 출력.
		AdminUtilsDTO gradeResult = aService.getGradeCount();
		// 유저수 추이의 날짜 출력.
		AdminUtilsDTO dateResult = aService.getDate();
		// 유저수 추이의 누적 가입자 수 출력.
		AdminUtilsDTO signUpAccumResult = aService.getSignUpAccumCount();
		// 유저수 추이의 일일 가입자 수 출력.
		AdminUtilsDTO signUpDailyResult = aService.getSignUpDailyCount();
		// 등급별 결제 수 출력.
		AdminUtilsDTO payResult = aService.getPayCountByGrade();
		
		model.addAttribute("memberResult",memberResult);
		model.addAttribute("boardResult",boardResult);
		model.addAttribute("chalResult",chalResult);
		model.addAttribute("gradeResult",gradeResult);
		model.addAttribute("dateResult",dateResult);
		model.addAttribute("signUpAccumResult",signUpAccumResult);
		model.addAttribute("signUpDailyResult",signUpDailyResult);
		model.addAttribute("payResult",payResult);
		return "/admin/adminMain";
	}

	@RequestMapping("board") // 자유게시판 관리로 이동.
	public String board(Model model, int cpage) throws Exception {
		// 자유게시판 글 수 출력.
		int boardResult = aService.getBoardCount();
		// 자유게시판 글 목록 출력.
		Map<String,String> map = bService.pageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));

		String navi = aService.getBoardPageNavi(currentPage);
		List<BoardDTO> list = bService.selectAll(start,end);
		model.addAttribute("cpage",cpage);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		model.addAttribute("boardResult",boardResult);
		return "/admin/adminBoard";
	}

	@RequestMapping("boardSearch") // 자유게시판 관리에서 글 검색.
	public String boardSearch(Model model, int cpage, String select, String keyword) throws Exception {
		// 자유게시판 검색한 글 수 출력.
		int boardResult = aService.getSearchBoardCount(select,keyword);
		// 자유게시판 검색한 글 목록 출력.
		Map<String,String> map = bService.pageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));

		String navi = aService.getBoardPageNaviSearch(currentPage,select,keyword);
		List<BoardDTO> list = bService.selectAllSearch(start,end,select,keyword);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		model.addAttribute("boardResult",boardResult);
		return "/admin/adminBoardSearch";
	}

	@RequestMapping("boardDelete") // 자유게시판 관리에서 글 삭제.
	public String boardDelete(Model model, int cpage, String select, String keyword, int[] checkbox) {
		for(int i=0; i<checkbox.length; i++) {
			bService.delete(checkbox[i]);
		}
		model.addAttribute("cpage",cpage);
		return "redirect:/admin/board";
	}

	@RequestMapping("chal") // 챌린지 관리로 이동.
	public String chal(Model model, int cpage) throws Exception {
		// 챌린지 수 출력.
		int chalResult = aService.getChalCount();
		// 챌린지 목록 출력.
		Map<String,String> map = aService.chalPageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));

		String navi = aService.getChalPageNavi(currentPage);
		List<ChalDTO> list = aService.selectChalAll(start,end);
		for(int i=0; i<list.size(); i++) {
			Timestamp endDate = list.get(i).getEndDate();
			int chalSeq = list.get(i).getChalSeq();
			Long datetime = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(datetime);
			String chalStat = "";
			if(timestamp.getTime()-endDate.getTime()<0) {
				chalStat ="진행중";
				aService.updateChalStatus(chalSeq,chalStat);
			}else {
				chalStat ="만료";
				aService.updateChalStatus(chalSeq,chalStat);
			}
		}
		model.addAttribute("cpage",cpage);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		model.addAttribute("chalResult",chalResult);
		return "/admin/adminChal";
	}

	@RequestMapping("chalSearch") // 챌린지 관리에서 글 검색.
	public String chalSearch(Model model, int cpage, String select, String keyword) throws Exception {
		// 챌린지 검색한 글 수 출력.
		int chalResult = aService.getSearchChalCount(select,keyword);
		// 챌린지 검색한 글 목록 출력.
		Map<String,String> map = aService.chalPageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));

		String navi = aService.getChalPageNaviSearch(currentPage,select,keyword);
		List<ChalDTO> list = aService.selectChalAllSearch(start,end,select,keyword);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		model.addAttribute("chalResult",chalResult);
		return "/admin/adminChalSearch";
	}

	@RequestMapping("chalDelete") // 챌린지 관리에서 글 삭제.
	public String chalDelete(Model model, int cpage, String select, String keyword, int[] checkbox) throws Exception {
		for(int i=0; i<checkbox.length; i++) {
			aService.chalDelete(checkbox[i]);
		}
		model.addAttribute("cpage",cpage);
		return "redirect:/admin/chal";
	}

	@RequestMapping("chalRenew") // 챌린지 관리에서 갱신.
	public String chalRenew(Model model, int cpage, String select, String keyword, int[] checkbox) throws Exception {
		for(int i=0; i<checkbox.length; i++) {
			aService.chalRenew(checkbox[i]);
		}
		model.addAttribute("cpage",cpage);
		return "redirect:/admin/chal";
	}

	@RequestMapping("chalWriteForm") // 챌린지 작성 폼으로 이동.
	public String chalWriteForm(Model model, int cpage, String select, String keyword) {
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		return "/admin/adminChalWriteForm";
	}

	// 챌린지 등록은 ImageController에서 구현.

	@RequestMapping("chalModifyForm") // 챌린지 수정 폼으로 이동.
	public String chalModify(Model model, int cpage, String select, String keyword, int chalSeq) throws ParseException {
		// chalSeq로 챌린지 찾기.
		ChalDTO list = aService.chalSearchBySeq(chalSeq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("list",list);
		return "/admin/adminChalModifyForm";
	}

	// 챌린지 수정은 ImageController에서 구현.


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

	//유저 환급 관리 - 환급(은행명 환급완료로 바뀜)
	@RequestMapping("userRefundGo")
	public String refundGo(String nickname, String chalName) {
		System.out.println(nickname);
		int result = rService.update(nickname, chalName);
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
		model.addAttribute("chalName",chalName);
		model.addAttribute("nickname",nickname);
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
        List<RefundDTO> list = rService.refundSearch(start, end, chalName, nickname);
        String result = glist.toJson(list);
        return result;
	}
	
	//유저 인증 관리
	@RequestMapping("certi")
	public String joinChal(Model model, int cpage)throws Exception{
		//인증 개수 출력
		int certiResult = aService.getCertiCount();
		//인증 목록 출력
		Map<String,String> map = aService.certiPageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));
		
		String navi = aService.getCertiPageNavi(currentPage);
		List<CertiDTO> list = aService.selectCertiAll(start,end);
		
		
		model.addAttribute("capage",cpage);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		model.addAttribute("certiResult",certiResult);

		return "/admin/adminCerti";
	}
	
	//유저 인증 삭제
	@RequestMapping("certiDelete")
	public String certiDelete(Model model, int cpage, String select, String keyword, int[] checkbox) {
		for(int i=0; i<checkbox.length; i++) {
			aService.certiDelete(checkbox[i]);
		}
		model.addAttribute("cpage",cpage);
		return "redirect:/admin/certi";
	}
	
	//인증 관리에서 검색
	@RequestMapping("certiSearch")
	public String CertiSearch(Model model, int cpage, String select, String keyword) throws Exception{
		Map<String,String> map = aService.certiPageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));
		System.out.println(select + ":" + keyword);
		String navi = aService.getCertiPageNaviSearch(currentPage, select, keyword);
		List<CertiDTO> list = aService.selectCertiAllSearch(start,end,select,keyword);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		return "/admin/adminCertiSearch";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}
