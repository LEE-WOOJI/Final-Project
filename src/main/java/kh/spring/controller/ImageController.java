package kh.spring.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;

import kh.spring.dto.CertiDTO;
import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.ChalDTO;
import kh.spring.dto.ChalImgDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;
import kh.spring.service.AdminService;
import kh.spring.service.BoardService;
import kh.spring.service.MypageService;
import kh.spring.utils.EncrpytionUtils;

@Controller
@RequestMapping("/image/")
public class ImageController {

   @Autowired
   BoardService bService;
   @Autowired
   AdminService aService;
   @Autowired
   MypageService mService;
   @Autowired
   private HttpSession session;

   @RequestMapping("board") // 프로필 파일 이미지를 게시판에 불러오기.
   public void board(String nickname, HttpServletResponse response) throws Exception {
      // nickname으로 member테이블 seq(profile테이블의 parentSeq)찾기.
      int parentSeq = bService.findParentSeq(nickname);
      // member테이블 seq(profile테이블의 parentSeq)로 imgName 찾기.
      ProfileDTO dto = bService.findImgName(parentSeq);
      if(dto==null) {
         String oriName = "profiledefault.jpg";
         String sysName = "profiledefault.jpg";
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
      }else {
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
   }

   @RequestMapping(value = "/boardSnote",produces = "application/json; charset=UTF-8") // 게시판 서머노트 업로드.
   @ResponseBody
   public JsonObject uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) throws Exception  {
      System.out.println("성공");

      JsonObject jsonObject = new JsonObject();

		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		System.out.println(contextRoot);
//		String fileRoot = "D:\\Springworkspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Final-Project\\resources\\boardImg\\";
		String fileRoot = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\ROOT\\resources\\boardImg\\";
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명

		File targetFile = new File(fileRoot + savedFileName);

      try {
         InputStream fileStream = multipartFile.getInputStream();
         FileUtils.copyInputStreamToFile(fileStream, targetFile);   //파일 저장
         jsonObject.addProperty("url", "/boardImg/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
         jsonObject.addProperty("responseCode", "success");

      } catch (IOException e) {
         FileUtils.deleteQuietly(targetFile);   //저장된 파일 삭제
         jsonObject.addProperty("responseCode", "error");
         e.printStackTrace();
      }
      return jsonObject;
   }

   @RequestMapping("chalWrite") // 챌린지 등록시 이미지 업로드.
   public String chalWrite(String from, String to, ChalDTO dto, MultipartFile file[]) throws Exception {
      // 챌린지 정보 등록.
      int chalSeq = aService.insertChal(from, to, dto);
      for(MultipartFile mf : file) {
         if(!file[0].isEmpty()) {
            String realPath = session.getServletContext().getRealPath("files");

            File realPathFile = new File(realPath);
            if(!realPathFile.exists()) {
               realPathFile.mkdir();   
            }
            String oriName = mf.getOriginalFilename();
            String sysName = UUID.randomUUID()+"_"+oriName;
            mf.transferTo(new File(realPath+"/"+sysName));
            // 챌린지 이미지 등록.
            aService.insertChalImg(oriName,sysName,chalSeq);
         }
      }
      return "redirect:/admin/chal?cpage=1";
   }

   @RequestMapping("chalModifyLoad") // 챌린지 등록시 파일 이미지를 챌린지 수정에서 불러오기.
   public void chalModifyLoad(int chalSeq, HttpServletResponse response) throws Exception {
      // chalSeq로 ChalImg테이블의 imgName 찾기.
      ChalImgDTO dto = aService.findChalImgName(chalSeq);
      if(dto==null) {
         String sysName = "chal2.jpg";
         String oriName = "chal2.jpg";
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
      }else {
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
   }

   @RequestMapping("chalModify") // 챌린지 수정시 이미지 업로드.
   public String chalModify(String from, String to, ChalDTO dto, MultipartFile file[]) throws Exception {
      // 챌린지 정보 수정.
      int chalSeq = aService.modifyChal(from, to, dto);
      // chalSeq로 ChalImg테이블의 imgName 찾기.
      ChalImgDTO chalImgDTO = aService.findChalImgName(chalSeq);
      if(chalImgDTO == null) {
         for(MultipartFile mf : file) {
            if(!file[0].isEmpty()) {
               String realPath = session.getServletContext().getRealPath("files");

               File realPathFile = new File(realPath);
               if(!realPathFile.exists()) {
                  realPathFile.mkdir();   
               }
               String oriName = mf.getOriginalFilename();
               String sysName = UUID.randomUUID()+"_"+oriName;
               mf.transferTo(new File(realPath+"/"+sysName));

               // 챌린지 이미지 등록.
               aService.insertChalImg(oriName,sysName,chalSeq);
            }
         }
      }else {
         for(MultipartFile mf : file) {
            if(!file[0].isEmpty()) {
               String realPath = session.getServletContext().getRealPath("files");

               File realPathFile = new File(realPath);
               if(!realPathFile.exists()) {
                  realPathFile.mkdir();   
               }
               String oriName = mf.getOriginalFilename();
               String sysName = UUID.randomUUID()+"_"+oriName;
               mf.transferTo(new File(realPath+"/"+sysName));

               // 챌린지 이미지 수정.
               aService.modifyChalImg(oriName,sysName,chalSeq);
            }
         }   
      }
      return "redirect:/admin/chal?cpage=1";
   }

   @RequestMapping("certiWrite") // 인증 등록시 이미지 업로드.
   public String certiWrite(CertiDTO dto, MultipartFile file[], RedirectAttributes re) throws Exception {
      // 인증 정보 등록.
      int certiSeq = mService.insertCerti(dto);
      String chalName = dto.getChalName();
      int refChalSeq = dto.getChalSeq();
      re.addAttribute("chalName",chalName);
      re.addAttribute("refChalSeq",refChalSeq);
      for(MultipartFile mf : file) {
         if(!file[0].isEmpty()) {
            String realPath = session.getServletContext().getRealPath("files");

            File realPathFile = new File(realPath);
            if(!realPathFile.exists()) {
               realPathFile.mkdir();   
            }
            String oriName = mf.getOriginalFilename();
            String sysName = UUID.randomUUID()+"_"+oriName;
            mf.transferTo(new File(realPath+"/"+sysName));
            // 인증 이미지 등록.
            mService.insertCertiImg(oriName,sysName,certiSeq);
         }
      }
      return "redirect:/mypage/certi";
   }

   @RequestMapping("certiWriteLoad") // 인증 파일 이미지를 불러오기.
   public void certiWriteLoad(int seq, HttpServletResponse response) throws Exception {
      // seq로 CertiImg테이블의 imgName 찾기.
      CertiImgDTO dto = mService.findCertiImgName(seq);
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
   
   @RequestMapping("certiImgLoad") // 인증 파일 이미지를 불러오기.
   public void certiImgLoad(int chalSeq, HttpServletResponse response) throws Exception {
      // chalSeq로 CertiImg테이블의 imgName 찾기.
      CertiImgDTO dto = mService.findCertiImgForDetail(chalSeq);
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
   
   
   @RequestMapping("mypageLoad") // 마이페이지에서 내 사진 불러오기.
   public void mypageUpdate(String nickname, HttpServletResponse response) throws Exception {
      // nickname으로 member테이블 seq(profile테이블의 parentSeq)찾기.
      int parentSeq = bService.findParentSeq(nickname);
      // member테이블 seq(profile테이블의 parentSeq)로 imgName 찾기.
      ProfileDTO dto = bService.findImgName(parentSeq);
      if(dto==null) {
         String oriName = "profiledefault.jpg";
         String sysName = "profiledefault.jpg";
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
      }else {
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
   }
   
   @RequestMapping("mypageUpdate") // 회원정보 수정시 이미지 업로드.
   public String chalModify(MemberDTO dto, MultipartFile file[]) throws Exception {
      // 비밀번호 sha암호화.
      dto.setPw(EncrpytionUtils.getSHA512(dto.getPw()));
      // 마이페이지 정보 수정.
      mService.update(dto);
      int seq = dto.getSeq();
      // seq로 profile테이블의 imgName 찾기.
      ProfileDTO ProfileDTO = mService.findProfileImgName(seq);
      if(ProfileDTO == null) {
         for(MultipartFile mf : file) {
            if(!file[0].isEmpty()) {
               String realPath = session.getServletContext().getRealPath("files");

               File realPathFile = new File(realPath);
               if(!realPathFile.exists()) {
                  realPathFile.mkdir();   
               }
               String oriName = mf.getOriginalFilename();
               String sysName = UUID.randomUUID()+"_"+oriName;
               mf.transferTo(new File(realPath+"/"+sysName));

               // 프로필 이미지 등록.
               mService.insertProfileImg(oriName,sysName,seq);
            }
         }
      }else {
         for(MultipartFile mf : file) {
            if(!file[0].isEmpty()) {
               String realPath = session.getServletContext().getRealPath("files");

               File realPathFile = new File(realPath);
               if(!realPathFile.exists()) {
                  realPathFile.mkdir();   
               }
               String oriName = mf.getOriginalFilename();
               String sysName = UUID.randomUUID()+"_"+oriName;
               mf.transferTo(new File(realPath+"/"+sysName));

               // 프로필 이미지 수정.
               mService.modifyProfileImg(oriName,sysName,seq);
            }
         }   
      }
      return "redirect:/mypage/myChalList";
   }

   @ExceptionHandler(Exception.class)
   public String exceptionHandler(Exception e) {
      e.printStackTrace();
      return "redirect:/";
   }
}