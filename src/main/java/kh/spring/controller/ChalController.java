package kh.spring.controller;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.ChalLikeDTO;
import kh.spring.dto.HeartDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.service.BoardReplyService;
import kh.spring.service.ChalService;
import kh.spring.service.HeartService;

@RequestMapping("/chal/")
@Controller
public class ChalController {
	@Autowired
	ChalService cservice;
	
	@Autowired
	private HeartService hService;
	
	@Autowired
	BoardReplyService brService;

	@Autowired
	private HttpSession session;

	//1.전체 리스트
	//처음 리스트에 들어왔을 때
	@RequestMapping("list")
	public String chalList(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		int start = 1;
		int end = start + 5;
		List<ChalLikeDTO> list = cservice.listBound(start, end);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println(nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		
		System.out.println(heartlist.get(0).getHeart());
		model.addAttribute("list",heartlist);
		return "/chal/chalList";
	}

	//더보기 버튼을 눌렀을 때
	@ResponseBody
	@RequestMapping(value = "more", produces = "text/html;charset=utf8")
	public String chalMore(int moreNum) {
		String nickname = (String) session.getAttribute("writerNickname");
		int start = moreNum;
		int end = start + 5;
		System.out.println(end);
		List<ChalLikeDTO> list = cservice.listBound(start, end); //7~12까지의 챌린지 정보를 dto리스트로 담아 list에 저장
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		Gson glist = new Gson(); 
		String result = glist.toJson(heartlist); //json으로 변환
		return result;
	}

	//검색 버튼을 눌렀을 때
	@RequestMapping("search")
	public String chalSearch(String option, String searchText, Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		System.out.println(option + ":" + searchText);
		int start = 1;
		int end = start + 2;
		if(option.equals("name")) {
			List<ChalLikeDTO> klist = cservice.searchK(start, end, searchText);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : klist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println(nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			model.addAttribute("option",option);
			model.addAttribute("searchText",searchText);
			model.addAttribute("list",heartlist);
		}else if(option.equals("tag")) {
			List<ChalLikeDTO> tlist = cservice.searchT(start, end, searchText);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : tlist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println(nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			model.addAttribute("option",option);
			model.addAttribute("searchText",searchText);
			model.addAttribute("list",heartlist);
		}else if(option.equals("day")) {
			List<ChalLikeDTO> dlist = cservice.searchD(start, end, searchText);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : dlist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println(nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			model.addAttribute("option",option);
			model.addAttribute("searchText",searchText);
			model.addAttribute("list",heartlist);
		}
		return "/chal/chalListSearch";
	}

	//검색더보기 버튼을 눌렀을 때
	@ResponseBody
	@RequestMapping(value = "searchMore", produces = "text/html;charset=utf8")
	public String searchMore(String opt, String key,int moreNum) {
		String nickname = (String) session.getAttribute("writerNickname");
		int start = moreNum;
		int end = start + 2;
		Gson glist = new Gson();
		String result = null;
		System.out.println(end);
		System.out.println(opt + ":" + key);
		if(opt.equals("name")) {
			List<ChalLikeDTO> klist = cservice.searchK(start, end, key);
			System.out.println(key);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : klist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			result = glist.toJson(heartlist); //json으로 변환
		}else if(opt.equals("tag")) {
			List<ChalLikeDTO> tlist = cservice.searchT(start, end, key);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : tlist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			result = glist.toJson(heartlist);
		}else if(opt.equals("day")) {
			List<ChalLikeDTO> dlist = cservice.searchD(start, end, key);
			List<ChalLikeDTO> heartlist = new ArrayList<>();
			for(ChalLikeDTO c : dlist) {
				HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
				System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
				int check = hService.findHeart(input);
				if(check==1) {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
				}else {
					heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
				}
				System.out.println(check);
			}
			result = glist.toJson(heartlist);
		}
		return result;
	}

	//카테고리 1.건강
	@RequestMapping("health")
	public String chalHealth(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "건강";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}
	//카테고리 2.취미
	@RequestMapping("hobby")
	public String chalHobby(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "취미";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}
	//카테고리 3.금융
	@RequestMapping("finance")
	public String chalFinance(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "금융";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}
	//카테고리 4.공부
	@RequestMapping("study")
	public String chalStudy(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "공부";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}
	//카테고리 5.생활
	@RequestMapping("life")
	public String chalLife(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "생활";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}
	//카테고리 6.펫/환경
	@RequestMapping("pet")
	public String chalPet(Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		String category = "펫/환경";
		List<ChalLikeDTO> list = cservice.listCategory(category);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("더보기라네" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
			System.out.println(check);
		}
		model.addAttribute("category",category);
		model.addAttribute("list",heartlist);
		return "/chal/chalCategory";
	}

	//정렬
	@ResponseBody
	@RequestMapping(value = "filter", produces = "text/html;charset=utf8")
	public String filter(String category, String filter, Model model) {
		String nickname = (String) session.getAttribute("writerNickname");
		System.out.println(category + ":" + filter);
		Gson glist = new Gson();
		List<ChalLikeDTO> list = cservice.categoryFilter(category, filter);
		List<ChalLikeDTO> heartlist = new ArrayList<>();
		for(ChalLikeDTO c : list) {
			HeartDTO input = new HeartDTO(0,c.getChalSeq(),nickname,0);
			System.out.println("정렬" + nickname + ":" + input.getRefChalSeq());
			int check = hService.findHeart(input);
			if(check==1) {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),1));
			}else {
				heartlist.add(new ChalLikeDTO(c.getChalSeq(),c.getChalName(),c.getStartDate(),c.getEndDate(),c.getPersonnel(),c.getChalInfo(),c.getTag(),c.getPrice(),c.getDay(),c.getCategory(),c.getSeq(),c.getOriName(),c.getSysName(),c.getHseq(),c.getRefChalSeq(),c.getRefNickname(),0));
			}
		}
		String result = glist.toJson(heartlist);
		System.out.println(list.get(0).getChalName() + list.size());
		
		return result;
	}

	// 참여한 글피인지 중복 검사.
	@ResponseBody
	@RequestMapping(value ="alreadyJoined", produces = "text/html;charset=utf8")
	public String alreadyJoined(int seq) {
		String nickname = (String)session.getAttribute("writerNickname");
		//같은 글피에 참여한 적 있는지 중복검사
		int num = cservice.alreadyJoined(seq,nickname);
		String result = "중복아님";
		if(num == 1) {
			result = "중복";
		}
		return result;
	}

	/* 글피 디테일 페이지로 넘어가기*/

	@RequestMapping("detail")
	// chalList.jsp 에서 해당'chalSeq'를 받아오기.
	public String chalDetail(int seq, Model model) {

		//블랙리스트 유무를 위하여 로그인 세션 받아옴
		String id = (String) session.getAttribute("loginId");
		String nickname = (String)session.getAttribute("writerNickname");

		if(id != null) {
			MemberDTO member = brService.searchInfoById(id);
			model.addAttribute("member", member);
		}

		// 챌린지 정보 
		ChalLikeDTO dtt = cservice.selectBySeq(seq);
		//이 챌린지는 좋아요 되어있는가?
		int check = hService.findHeart(new HeartDTO(0,seq,nickname,0));
		// 해당 챌린지의 인증샷 불러오기
		List<CertiImgDTO> list = cservice.selectCertiImg(seq);
		ChalLikeDTO dto = new ChalLikeDTO(dtt.getChalSeq(),dtt.getChalName(),dtt.getStartDate(),dtt.getEndDate(),dtt.getPersonnel(),dtt.getChalInfo(),dtt.getTag(),dtt.getPrice(),dtt.getDay(),dtt.getCategory(),dtt.getSeq(),dtt.getOriName(),dtt.getSysName(),dtt.getHseq(),dtt.getRefChalSeq(),dtt.getRefNickname(),check);
		

		// 태그 자르기
		String[]tag = dto.getTag().split(",");
		System.out.println(dto.getChalSeq());
		model.addAttribute("seq",dto.getChalSeq());
		model.addAttribute("dto",dto);
		model.addAttribute("list",list);
		model.addAttribute("tag1",tag[0]);
		model.addAttribute("tag2",tag[1]);
		model.addAttribute("tag3",tag[2]); 

		return "/chal/chalDetail";
	}

	/*글피 결제 페이지로 넘어가기*/
	@RequestMapping("chalPayment")
	public String chalPayment(int seq, Model model) {
		String id = (String) session.getAttribute("loginId");
		ChalLikeDTO dto = cservice.selectBySeq(seq);

		// 결제페이지에서 유저의 이름,이메일,핸드폰 번호를 받기 위하여.
		if(id != null) {
			MemberDTO member = brService.searchInfoById(id);
			model.addAttribute("member", member);
		}

		model.addAttribute("dto",dto);
		return "/chal/chalPayment";
	}

	/*결제 완료 후 보여질 페이지*/
	@RequestMapping("chalOut")
	public String chalOut(Integer refChalSeq, String nickname, String chalName, Timestamp startDate, 
			Timestamp endDate, Integer  personnel, String chalInfo, String tag, String chalStat) {
		// 참여자 수 +1 증가
		cservice.addPersonnel(refChalSeq);
		cservice.addPJ(refChalSeq);
		// JoinChal 테이블에 추가
		cservice.joinChal(refChalSeq,nickname,chalName,startDate,endDate,personnel,chalInfo,tag,chalStat);
		return "/chal/chalOut";
	}
}

