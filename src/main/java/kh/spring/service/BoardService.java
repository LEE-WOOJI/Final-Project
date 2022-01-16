package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.BoardDAO;
import kh.spring.dto.BoardDTO;
import kh.spring.utils.Static;

@Service
public class BoardService {
	@Autowired
	private BoardDAO bdao;

	// 게시판 목록 출력.
	public List<BoardDTO> selectAll(int start, int end){
		return bdao.selectAll(start, end);
	}

	// 게시판 검색 시 목록 출력.
	public List<BoardDTO> selectAllSearch(int start, int end, String select, String keyword){
		return bdao.selectAllSearch(start, end, select, keyword);
	}

	// 게시판 글 수 출력.
	public int getRecordCount() {
		return bdao.getRecordCount();
	}

	// 게시판 검색 시 글 수 출력.
	public int getRecordCountSearch(String select, String keyword) {
		return bdao.getRecordCountSearch(select, keyword);
	}
	
	// 게시판 현재 페이지 검사.
	public Map<String, String> pageCheck(int currentPage) throws Exception {
		if(currentPage < 1) { 
			currentPage = 1;
		}else if(currentPage > getPageTotalCount()) {
			currentPage = getPageTotalCount();
		}

		int start = currentPage * Static.RECORD_COUNT_PER_PAGE - (Static.RECORD_COUNT_PER_PAGE-1); // 변수의 중첩사용 막아줌.
		int end = currentPage * Static.RECORD_COUNT_PER_PAGE;

		Map<String,String> map = new HashMap<>();
		map.put("currentPage", String.valueOf(currentPage));
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));

		return map;
	}

	// 게시판 페이지.
	public int getPageTotalCount() throws Exception {
		int recordTotalCount = this.getRecordCount();

		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		return pageTotalCount;
	}

	// 게시판 네비.
	public String getPageNavi(int currentPage) throws Exception {
		int recordTotalCount = this.getRecordCount();

		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}

		int startNavi = (currentPage-1)/Static.NAVI_COUNT_PER_PAGE*Static.NAVI_COUNT_PER_PAGE+1;
		int endNavi = startNavi+Static.NAVI_COUNT_PER_PAGE-1;

		if(endNavi > pageTotalCount) {  
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		String pageNavi ="";
		if(needPrev) {
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/board/main?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/board/main?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/board/main?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}

	// 게시판 검색 시 네비.
	public String getPageNaviSearch(int currentPage, String select, String keyword) throws Exception {
		int recordTotalCount = this.getRecordCountSearch(select, keyword);

		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}

		int startNavi = (currentPage-1)/Static.NAVI_COUNT_PER_PAGE*Static.NAVI_COUNT_PER_PAGE+1;
		int endNavi = startNavi+Static.NAVI_COUNT_PER_PAGE-1;

		if(endNavi > pageTotalCount) {  
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		String pageNavi ="";
		if(needPrev) {
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/board/search?cpage="+(startNavi-1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/board/search?cpage="+i+"&select="+select+"&keyword="+keyword+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/board/search?cpage="+(endNavi+1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}
	
	// seq로 작성한 글의 detail 출력.
	public BoardDTO selectBySeq(int seq){
		return bdao.selectBySeq(seq);
	}
	
	// 조희수 증가.
	public int addViewCount(int seq){
		return bdao.addViewCount(seq);
	}
	
	// 게시글 수정.
	public int modify(int seq, String title, String contents){
		return bdao.modify(seq,title,contents);
	}	
	
	// 게시글 삭제.
	public int delete(int seq){
		return bdao.delete(seq);
	}	
}