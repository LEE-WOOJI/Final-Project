package kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board/")
@Controller
public class BoardController {

	@RequestMapping("boardMain")
	public String board() {
		return "/board/boardMain";
	}
}
