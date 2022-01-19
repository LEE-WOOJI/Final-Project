package kh.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.ProfileDTO;
import kh.spring.service.BoardService;
import kh.spring.service.ImageService;

@Controller
@RequestMapping("/image/")
public class ImageController {

	@Autowired
	BoardService bService;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("board") // 프로필 파일 이미지를 게시판에 불러오기.
	public void board(String nickname, HttpServletResponse response) throws Exception {
		// nickname으로 member테이블 seq(profile테이블의 parentSeq)찾기.
		int parentSeq = bService.findParentSeq(nickname);
		// member테이블 seq(profile테이블의 parentSeq)로 imgName 찾기.
		ProfileDTO dto = bService.findImgName(parentSeq);
		String oriName = dto.getOriName();
		String sysName = dto.getSysName();
		String realPath = session.getServletContext().getRealPath("files");
		File target = new File(realPath+"/"+sysName);

		try(DataInputStream dis = new DataInputStream(new FileInputStream(target));
				DataOutputStream dos = new DataOutputStream(response.getOutputStream());){
			byte[] fileContents = new byte[(int) target.length()];
			dis.readFully(fileContents);

			oriName = new String(oriName.getBytes("utf8"),"ISO-8859-1");
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename="+ oriName);

			dos.write(fileContents);
			dos.flush();	
		}
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/";
	}
}
