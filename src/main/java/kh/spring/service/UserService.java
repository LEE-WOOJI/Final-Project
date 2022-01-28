package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.UserDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.utils.Static;

@Service
public class UserService {
	@Autowired
	private UserDAO udao;
	
	//유저 전체 조회
	public List<MemberDTO> selectBound(int start, int end){
		return udao.selectBound(start, end);
	}
	
	//유저 검색 조회
	public List<MemberDTO> searchBound(int start, int end, String id, String nickname, String blacklist){
		return udao.searchBound(start, end, id, nickname, blacklist);
	}
	
	//유저 탈퇴
	public int delete(String id) {
		return udao.delete(id);
	}
	
	//유저 블랙
	public int black(String id, String black) {
		return udao.black(id, black);
	}
	
	//등급에 맞는 유저 수 조회
	public List<MemberDTO> userGrade(String grade){
		return udao.userGrade(grade);
	}
	
	//등급에 맞으면서 검색대상 조회
	public List<MemberDTO> userGradeSearch(String grade, String option, String keyword){
		return udao.userGradeSearch(grade, option, keyword);
	}
	
	//유저 인원 수
	public int userCount() {
		return udao.userCount();
	}
	
	//검색대상의 유저 인원 수
	public int userSearchCount(String id, String nickname, String blacklist) {
		return udao.userSearchCount(id, nickname, blacklist);
	}
	//원하는 등급으로 변경하기
	public int GradeMeta(String grade, String id) {
		return udao.GradeMeta(grade, id);
	}
	//페이징
	//유저 현재 페이지
	public Map<String,String> pageCheck(int currentPage) throws Exception{
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount()) {
			currentPage = pageTotalCount();
		}
		
		int start = currentPage * Static.RECORD_COUNT_PER_PAGE - (Static.RECORD_COUNT_PER_PAGE-1);
		int end = currentPage * Static.RECORD_COUNT_PER_PAGE;
		
		Map<String,String> map = new HashMap<>();
		map.put("currentPage", String.valueOf(currentPage));
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		
		return map;
	}
	
	//유저 페이지
	public int pageTotalCount() throws Exception{
		int recordTotalCount = this.userCount();
		
		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		return pageTotalCount;
	}
	
	//유저 네비
	public String PageNavi(int currentPage)throws Exception{
		int recordTotalCount = this.userCount();
		
		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		
		int startNavi = (currentPage-1)/Static.NAVI_COUNT_PER_PAGE*Static.NAVI_COUNT_PER_PAGE+1;
		int endNavi = startNavi + Static.NAVI_COUNT_PER_PAGE-1;
		
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		if(startNavi==1) {
			needPrev = false;
		}
		if(endNavi==pageTotalCount) {
			needNext = false;
		}

		String pageNavi ="";
		if(needPrev) {
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/userChal?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/board/main?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/userChal?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}
	
	//유저 검색
	
}
