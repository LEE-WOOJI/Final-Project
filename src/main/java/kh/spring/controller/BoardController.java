package kh.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.service.BoardService;

@RequestMapping("/board/")
@Controller
public class BoardController {

	@Autowired
	BoardService bService;
	
	@RequestMapping("main") // 메인으로 이동.
	public String main(Model model, int cpage) throws Exception {
		Map<String,String> map = bService.pageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));
		
		String navi = bService.getPageNavi(currentPage);
		List<BoardDTO> list = bService.selectAll(start,end);
		model.addAttribute("cpage",cpage);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		return "/board/boardMain";
	}
	
	@RequestMapping("search") // 메인에서 글 검색.
	public String boardSearch(Model model, int cpage, String select, String keyword) throws Exception {
		Map<String,String> map = bService.pageCheck(cpage);
		int currentPage = Integer.parseInt(map.get("currentPage"));
		int start = Integer.parseInt(map.get("start"));
		int end = Integer.parseInt(map.get("end"));
		
		String navi = bService.getPageNaviSearch(currentPage,select,keyword);
		List<BoardDTO> list = bService.selectAllSearch(start,end,select,keyword);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("navi",navi);
		model.addAttribute("list",list);
		return "/board/boardSearch";
	}
	
	@RequestMapping("write") // 글쓰기로 이동.
	public String boardWrite() {
		return "/board/boardWrite";
	}
	
	@RequestMapping("detail") // 글 클릭시 글 세부내용으로 이동.
	public String boardDetail(Model model, int cpage, int seq, String select, String keyword) {
		bService.addViewCount(seq);
		BoardDTO bList = bService.selectBySeq(seq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("bList",bList);
		return "/board/boardDetail";
	}
	
	@RequestMapping("modify") // 게시 글 수정.
	public String boardModify(Model model, int cpage, int seq, String select, String keyword, BoardDTO dto) {
		bService.modify(seq,dto.getTitle(),dto.getContents());
		BoardDTO bList = bService.selectBySeq(seq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("bList",bList);
		return "/board/boardDetail";
	}
	
	@RequestMapping("delete") // 게시 글 삭제.
	public String boardDelete(Model model, int cpage, int seq) {
		bService.delete(seq);
		model.addAttribute("cpage",cpage);
		return "redirect:/board/main";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}