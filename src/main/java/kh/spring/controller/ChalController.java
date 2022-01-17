package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kh.spring.dto.ChalBasicDTO;
import kh.spring.service.ChalService;

@RequestMapping("/chal/")
@Controller
public class ChalController {
	@Autowired
	ChalService cservice;
	
	//1.전체 리스트
	//처음 리스트에 들어왔을 때
	@RequestMapping("list")
	public String chalList(Model model) {
		int start = 1;
		int end = start + 5;
		List<ChalBasicDTO> list = cservice.listBound(start, end);
		System.out.println(list.get(0).getStartDate());
		model.addAttribute("list",list);
		return "/chal/chalList";
	}
	
	//더보기 버튼을 눌렀을 때
	@ResponseBody
	@RequestMapping(value = "more", produces = "text/html;charset=utf8")
	public String chalMore(int moreNum) {
		int start = moreNum;
		int end = start + 5;
		System.out.println(end);
		List<ChalBasicDTO> list = cservice.listBound(start, end); //7~12까지의 챌린지 정보를 dto리스트로 담아 list에 저장
		Gson glist = new Gson(); 
		String result = glist.toJson(list); //json으로 변환
		return result;
	}
	
	//검색 버튼을 눌렀을 때
	@RequestMapping("search")
	public String chalSearch(String option, String searchText, Model model) {
		System.out.println(option + ":" + searchText);
		if(option.equals("keyword")) {
			List<ChalBasicDTO> list = cservice.searchK(searchText);
			model.addAttribute("list",list);
		}
		return "/chal/chalListSearchK";
	}
}
