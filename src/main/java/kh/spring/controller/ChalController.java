package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ChalBasicDTO;
import kh.spring.service.ChalService;

@RequestMapping("/chal/")
@Controller
public class ChalController {
	@Autowired
	ChalService cservice;
	
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
}
