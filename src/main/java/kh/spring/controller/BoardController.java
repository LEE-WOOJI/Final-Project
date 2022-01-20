package kh.spring.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.BoardReplyDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.BoardService;

@RequestMapping("/board/")
@Controller
public class BoardController {

	@Autowired
	BoardService bService;
	@Autowired
	BoardReplyService brService;
	
	@RequestMapping("main") // 메인으로 이동.
	public String main(Model model, int cpage, HttpServletRequest request) throws Exception {
		// 로그인아이디 세션값 저장.
		HttpSession session = request.getSession();
		session.setAttribute("loginID", "hi");
		// 로그인아이디 세션값 꺼내기.
		String id = (String) session.getAttribute("loginID");
		// 아이디값으로 댓글 정보 찾기.
		MemberDTO info = brService.searchInfoById(id);
		String writerNickname = info.getNickname();
		// 닉네임 세션값 저장.
		session.setAttribute("writerNickname", writerNickname);
		
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
	public String boardDetail(Model model, int cpage, int seq, String select, String keyword) throws Exception {
		// 조휘수 증가.
		bService.addViewCount(seq);
		// 댓글 가져가기.
		List<BoardReplyDTO> rList = brService.selectAllBybSeq(seq);
		// seq로 작성한 글의 detail 출력.
		BoardDTO bList = bService.selectBySeq(seq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("bList",bList);
		model.addAttribute("rList",rList);
		return "/board/boardDetail";
	}
	
	@RequestMapping("modify") // 게시 글 수정.
	public String boardModify(Model model, int cpage, int seq, String select, String keyword, BoardDTO dto) {
		bService.modify(seq,dto.getTitle(),dto.getContents());
		BoardDTO bList = bService.selectBySeq(seq);
		model.addAttribute("seq",seq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		model.addAttribute("bList",bList);
		return "redirect:/board/detail";
	}
	
	@RequestMapping("delete") // 게시 글 삭제.
	public String boardDelete(Model model, int cpage, int seq) {
		bService.delete(seq);
		model.addAttribute("cpage",cpage);
		return "redirect:/board/main";
	}
	
	@RequestMapping("delRp") // 댓글 삭제.
	public String rpDelete(Model model, int cpage, int seq, String select, String keyword, int rseq) {
		brService.delete(rseq);
		model.addAttribute("cpage",cpage);
		model.addAttribute("seq",seq);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		return "redirect:/board/detail";
	}
	
	@RequestMapping("modRp") // 댓글 삭제.
	public String rpModify(Model model, int cpage, int seq, String select, String keyword, String repContents, int rseq) {
		brService.modify(rseq, repContents);
		model.addAttribute("cpage",cpage);
		model.addAttribute("seq",seq);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		return "redirect:/board/detail";
	}
	
	@RequestMapping("writeRp") // 댓글 작성.
	public String rpWrite(Model model, int cpage, int seq, String select, String keyword, String repContents, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 닉네임 세션값을 꺼내기.
		String writerNickname = (String) session.getAttribute("writerNickname");
		int refBoardSeq = seq;
		brService.insert(refBoardSeq,writerNickname,repContents);
		model.addAttribute("cpage",cpage);
		model.addAttribute("seq",seq);
		model.addAttribute("select",select);
		model.addAttribute("keyword",keyword);
		return "redirect:/board/detail";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}