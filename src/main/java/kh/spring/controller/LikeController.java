package kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dao.LikeDAO;
import kh.spring.dto.LikeDTO;

@RequestMapping("/like")
@Controller
public class LikeController {
	
	@Autowired
	private LikeDAO ldao;
	private HttpSession session;
	
	@ResponseBody
	@RequestMapping("/fill")
	public LikeDTO likeCheck(@RequestParam String likeNum, HttpSession session) {
		LikeDTO dto = new LikeDTO();
//		String id = request.getParameter("loginID");
//		String likeNum = request.getParameter("likeNum");	
//		System.out.println(id);
		dto.setLikeNum(likeNum);
		dto.setId((String)session.getAttribute("Id"));
		
//		boolean DetailLikeCheck = ldao.likeCheck(likeNum);
		System.out.println("하트 체크 : "+dto);
		return dto;
	}
	
	@ResponseBody
	@RequestMapping("/empty")
	public LikeDTO removeCheck(@RequestParam String likeNum, HttpSession session) {
		LikeDTO dto = new LikeDTO();
		
		dto.setLikeNum(likeNum);
		dto.setChalNum((String)session.getAttribute("Id"));
		return dto;
	}
}
