package kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.ChalDTO;
import kh.spring.service.ChalService;

@RequestMapping("/chal/")
@Controller
public class ChalController {
	@Autowired
	ChalService cservice;
	
	@RequestMapping("list")
	public String chalList(Model model) {
		List<ChalDTO> list = cservice.selectAll();
		model.addAttribute("list",list);
		return "/chal/chalList";
	}
}
