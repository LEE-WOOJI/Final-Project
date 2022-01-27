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

import kh.spring.dto.AdminUtilsDTO;
import kh.spring.dto.BoardDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.service.AdminService;
import kh.spring.service.BoardService;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	AdminService aService;
	@Autowired
	BoardService bService;

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

		model.addAttribute("memberResult",memberResult);
		model.addAttribute("boardResult",boardResult);
		model.addAttribute("chalResult",chalResult);
		model.addAttribute("gradeResult",gradeResult);
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

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}
