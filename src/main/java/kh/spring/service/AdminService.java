package kh.spring.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AdminDAO;
import kh.spring.dao.BoardDAO;
import kh.spring.dto.AdminUtilsDTO;
import kh.spring.dto.CertiDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.dto.ChalImgDTO;
import kh.spring.utils.Static;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adao;
	@Autowired
	private BoardDAO bdao;

	// 관리자 페이지 메인에서 회원 수 출력.
	public int getMemberCount() {
		return adao.getMemberCount();
	}

	// 관리자 페이지 메인에서 자유게시판 글 수 출력.
	public int getBoardCount() {
		return adao.getBoardCount();
	}

	// 관리자 페이지 메인에서 챌린지 수 출력.
	public int getChalCount() {
		return adao.getChalCount();
	}

	// 관리자 페이지 메인에서 등급 출력.
	public AdminUtilsDTO getGradeCount() {
		return adao.getGradeCount();
	}
	
	// 관리자 페이지 메인에서 유저수 추이의 날짜 출력.
	public AdminUtilsDTO getDate() {
		return adao.getDate();
	}
	
	// 관리자 페이지 메인에서 유저수 추이의 누적 가입자 수 출력.
	public AdminUtilsDTO getSignUpAccumCount(){
		return adao.getSignUpAccumCount();
	}

	// 관리자 페이지 메인에서 유저수 추이의 일일 가입자 수 출력.
	public AdminUtilsDTO getSignUpDailyCount(){
		return adao.getSignUpDailyCount();
	}
	
	// 관리자 페이지 메인에서 등급별 결제 수 출력.	
	public AdminUtilsDTO getPayCountByGrade(){
		return adao.getPayCountByGrade();
	}

	// 관리자 페이지 챌린지 관리에서 챌린지 목록 출력.
	public List<ChalDTO> selectChalAll(int start, int end){
		return adao.selectChalAll(start, end);
	}

	// 관리자 페이지 챌린지 관리에서 검색 시 챌린지 수 출력.
	public int getChalRecordCountSearch(String select, String keyword) {
		return adao.getChalRecordCountSearch(select,keyword);
	}

	// 관리자 페이지 챌린지 관리에서 검색 시 챌린지 목록 출력.
	public List<ChalDTO> selectChalAllSearch(int start, int end, String select, String keyword){
		return adao.selectChalAllSearch(start, end, select, keyword);
	}

	// 관리자 페이지 챌린지 관리에서 챌린지 삭제.
	public int chalDelete(int seq){
		return adao.chalDelete(seq);
	}

	// 관리자 페이지 챌린지 관리에서 갱신.
	public int chalRenew(int seq) {
		return adao.chalRenew(seq);
	}

	// 관리자 페이지 챌린지 관리에서 챌린지 상태 변경.
	public int updateChalStatus(int chalSeq,String chalStat){
		return adao.updateChalStatus(chalSeq,chalStat);
	}

	// 관리자 페이지 챌린지 관리에서 챌린지 등록.
	public int insertChal(String from, String to, ChalDTO dto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String fromDate = from+" 00:00:00";
		String toDate = to+" 00:00:00";
		// 시작일
		Timestamp startDate = new Timestamp(sdf.parse(fromDate).getTime());
		// 종료일
		Timestamp endDate = new Timestamp(sdf.parse(toDate).getTime());
		// 날짜
		String day = String.valueOf((((sdf.parse(toDate).getTime()-sdf.parse(fromDate).getTime())/ (1000*60*60*24))));
		dto.setStartDate(startDate);
		dto.setEndDate(endDate);
		dto.setDay(day);
		return adao.insertChal(dto);
	}
	
	// 관리자 페이지 챌린지 관리에서 챌린지 등록시 이미지 업로드.
	public int insertChalImg(String oriName, String sysName,int chalSeq) {
		return adao.insertChalImg(oriName,sysName,chalSeq);
	}
	
	// chalSeq로 ChalImg테이블의 imgName 찾기.
	public ChalImgDTO findChalImgName(int chalSeq) {
		return adao.findChalImgName(chalSeq);
	}

	// 관리자 페이지 챌린지 관리에서 chalSeq로 챌린지 찾기.
	public ChalDTO chalSearchBySeq(int chalSeq){
		return adao.chalSearchBySeq(chalSeq);
	}

	// 관리자 페이지 챌린지 관리에서 챌린지 수정.
	public int modifyChal(String from, String to, ChalDTO dto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		SimpleDateFormat sdfV2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if(from.contains(":")&&to.contains(":")){
			String fromDate = from.substring(0,19);
			String toDate = to.substring(0,19);
			// 시작일
			Timestamp startDate = new Timestamp(sdfV2.parse(fromDate).getTime());
			// 종료일
			Timestamp endDate = new Timestamp(sdfV2.parse(toDate).getTime());
			// 날짜
			String day = String.valueOf((((sdfV2.parse(toDate).getTime()-sdfV2.parse(fromDate).getTime())/ (1000*60*60*24))));
			dto.setStartDate(startDate);
			dto.setEndDate(endDate);
			dto.setDay(day);
			return adao.modifyChal(dto);
		}else {
			String fromDate = from+" 00:00:00";
			String toDate = to+" 00:00:00";
			// 시작일
			Timestamp startDate = new Timestamp(sdf.parse(fromDate).getTime());
			// 종료일
			Timestamp endDate = new Timestamp(sdf.parse(toDate).getTime());
			// 날짜
			String day = String.valueOf((((sdf.parse(toDate).getTime()-sdf.parse(fromDate).getTime())/ (1000*60*60*24))));
			dto.setStartDate(startDate);
			dto.setEndDate(endDate);
			dto.setDay(day);
			return adao.modifyChal(dto);
		}
	}
	
	// 관리자 페이지 챌린지 관리에서 챌린지 수정시 이미지 업로드.
	public int modifyChalImg(String oriName, String sysName,int chalSeq) {
		return adao.modifyChalImg(oriName,sysName,chalSeq);
	}

	// 관리자페이지 자유게시판 관리 네비.
	public String getBoardPageNavi(int currentPage) throws Exception {
		int recordTotalCount = bdao.getRecordCount();

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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/board?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/board?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/board?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}

	// 관리자페이지 자유게시판 검색 시 네비.
	public String getBoardPageNaviSearch(int currentPage, String select, String keyword) throws Exception {
		int recordTotalCount = bdao.getRecordCountSearch(select, keyword);

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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/boardSearch?cpage="+(startNavi-1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/boardSearch?cpage="+i+"&select="+select+"&keyword="+keyword+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/boardSearch?cpage="+(endNavi+1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}

	// 관리자페이지 챌린지 관리 현재 페이지 검사.
	public Map<String, String> chalPageCheck(int currentPage) throws Exception {
		if(currentPage < 1) { 
			currentPage = 1;
		}else if(currentPage > getChalPageTotalCount()) {
			currentPage = getChalPageTotalCount();
		}

		int start = currentPage * Static.RECORD_COUNT_PER_PAGE - (Static.RECORD_COUNT_PER_PAGE-1); // 변수의 중첩사용 막아줌.
		int end = currentPage * Static.RECORD_COUNT_PER_PAGE;

		Map<String,String> map = new HashMap<>();
		map.put("currentPage", String.valueOf(currentPage));
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));

		return map;
	}

	// 관리자페이지 챌린지 관리 페이지.
	public int getChalPageTotalCount() throws Exception {
		int recordTotalCount = this.getChalCount();

		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		return pageTotalCount;
	}

	// 관리자페이지 챌린지 관리 네비.
	public String getChalPageNavi(int currentPage) throws Exception {
		int recordTotalCount = this.getChalCount();

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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/chal?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/chal?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/chal?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}

	// 관리자페이지 챌린지 검색 시 네비.
	public String getChalPageNaviSearch(int currentPage, String select, String keyword) throws Exception {
		int recordTotalCount = this.getChalRecordCountSearch(select, keyword);

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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/chalSearch?cpage="+(startNavi-1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/chalSearch?cpage="+i+"&select="+select+"&keyword="+keyword+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/chalSearch?cpage="+(endNavi+1)+"&select="+select+"&keyword="+keyword+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}
	
	//관리자 인증관리 페이지에서 인증 수 출력
	public int getCertiCount(){
		return adao.getCertiCount();
	}
	
	// 관리자 인증관리 관리에서 인증 목록 출력.
	public List<CertiDTO> selectCertiAll(int start, int end){
		return adao.selectCertiAll(start, end);
	}
	
	//인증 관리 페이지 현재 페이지 검사
	public Map<String,String> certiPageCheck(int currentPage) throws Exception{
		if(currentPage < 1){
			currentPage = 1;
		}else if(currentPage > getCertiPageTotalCount()){
			currentPage = getCertiPageTotalCount();
		}

		int start = currentPage * Static.RECORD_COUNT_PER_PAGE - (Static.RECORD_COUNT_PER_PAGE-1);
		int end = currentPage * Static.RECORD_COUNT_PER_PAGE;

		Map<String, String> map = new HashMap<>();
		map.put("currentPage", String.valueOf(currentPage));
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));

		return map;
	}
	
	//인증 관리 페이지 인증 관리 페이지
	public int getCertiPageTotalCount() throws Exception{
		int recordTotalCount = this.getCertiCount();

		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		return pageTotalCount;
	}
	
	//인증 관리 페이지 인증 관리 내비
	public String getCertiPageNavi(int currentPage) throws Exception{
		int recordTotalCount = this.getCertiCount();
		
		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
				pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
			}else {
				pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		System.out.println(pageTotalCount + " : " + recordTotalCount );
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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/certi?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/certi?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/certi?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

			return pageNavi;
		}
	
	//관리자 페이지 인증 관리에서 삭제
	public int certiDelete(int seq) {
		return adao.certiDelete(seq);
	}
	//관리자 인증 관리 검색
	public String getCertiPageNaviSearch(int currentPage, String select, String keyword)throws Exception{
		int recordTotalCount = this.getCertiCountSearch(select,keyword);
		int pageTotalCount = 0;
		if(recordTotalCount%Static.RECORD_COUNT_PER_PAGE==0) {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE;
		}else {
			pageTotalCount = recordTotalCount/Static.RECORD_COUNT_PER_PAGE+1;
		}
		System.out.println(pageTotalCount + " : " + recordTotalCount );
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
			pageNavi +="								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/certiSearch?cpage="+(startNavi-1)+"\"\r\n"
					+ "									aria-label=\"Previous\"> <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Previous</span>\r\n"
					+ "								</a></li>";
		}
		for(int i=startNavi; i<=endNavi; i++) {
			pageNavi+="<li class=\"page-item\"><a class=\"page-link\" href=/admin/certiSearch?cpage="+i+">"+i+"</a></li>";
		}
		if(needNext) {
			pageNavi += "								<li class=\"page-item\"><a class=\"page-link\" href=\"/admin/certiSearch?cpage="+(endNavi+1)+"\"\r\n"
					+ "									aria-label=\"Next\"> <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "										<span class=\"sr-only\">Next</span>\r\n"
					+ "								</a></li>";
		}

		return pageNavi;
	}
	
	// 관리자 페이지 인증 관리에서 검색 시 이증 수 출력.
	public int getCertiCountSearch(String select, String keyword) {
		return adao.getCertiCountSearch(select,keyword);
	}
	
	// 관리자 페이지 챌린지 관리에서 검색 시 챌린지 목록 출력.
	public List<CertiDTO> selectCertiAllSearch(int start, int end, String select, String keyword){
		return adao.selectCertiAllSearch(start, end, select, keyword);
	}
}

