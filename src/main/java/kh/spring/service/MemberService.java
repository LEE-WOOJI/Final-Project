package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.utils.CommonUtils;
import kh.spring.utils.EncrpytionUtils;
import kh.spring.utils.Static;

@Service
public class MemberService {
   @Autowired
   private MemberDAO mdao;
   //로그인
   public int isLoginAllowed(String id,String pw) {
      return mdao.isLoginAllowed(id,pw);
   }
   
   //아이디 중복체크
      public MemberDTO isIDExist(String id) {
         return mdao.isIDExist(id);
      }
   //비밀번호 중복체크
      public MemberDTO isPWExist(String pw) {
         return mdao.isPWExist(pw);
      }
   //닉네임 중복체크
      public MemberDTO isNICExist(String nickname) {
         return mdao.isNICExist(nickname);
      }
   //이메일 중복체크
      public MemberDTO isEMAILExist(String email) {
         return mdao.isEMAILExist(email);
      }
   //회원가입
      public int insertMember(MemberDTO dto) {
         dto.setPw(EncrpytionUtils.getSHA512(dto.getPw()));
         return mdao.insertMember(dto);
      }

      
   // 회원가입 시 이미지 업로드.
      public int insertMemberImg(String oriName, String sysName,int chalSeq) {
         return mdao.insertMemberImg(oriName,sysName,chalSeq);
      }
   //비밀번호 찾기
      public boolean searchPw(String id) {
         MemberDTO memberInfo = mdao.isIDExist(id);
         if(memberInfo != null) {
            String email = memberInfo.getEmail();
            
            if(email == "") return false;
            
            String env_temp_pw =EncrpytionUtils.getSHA512(Static.TEMP_PASSWORD);
            MemberDTO sendSearchPwInfo = new MemberDTO();
            sendSearchPwInfo.setEmail(email);
            sendSearchPwInfo.setPw(env_temp_pw);
            mdao.updateTempPassword(sendSearchPwInfo);
            CommonUtils.sendMail(email,Static.TEMP_PASSWORD);
         }
         return true;
      }
   //아이디 찾기
      
//      public boolean searchId(String email) {
//         MemberDTO memberInfo = mdao.isEMAILExist(email);// email to id
//         if(memberInfo != null) {
//            String id = memberInfo.getid();
//            
//            
//            if(id == "") return false;
//            
//            CommonUtils.sendMail(email);
//         }
//         return true;
//      }
      
   //카카오 로그인
      public boolean kakaoInsert(String nickname, String email) {
         
         MemberDTO idcheck = mdao.isIDExist(email);
         /*
          * MemberDTO emailcheck =mdao.isEMAILExist(email);
          * 
          * if(emailcheck != null) { return false; }
          */
         
         if(idcheck == null) {
            mdao.kakaoInsert(nickname,email);
            return true;
         }else {
            if(idcheck.getBlacklist() == null) {
               return true;
            }else {
               if(idcheck.getBlacklist().equals('Y') == false) {
                  return true;
               }else {
                  return false;
               }
            }
         }
         
      }
   
//   //전체조회
//   public List<ChalBasicDTO> listBound(int start, int end){
//      return cdao.listBound(start, end);
//   }
//   
//   //검색 1.키워드
//   public List<ChalBasicDTO> searchK(int start, int end, String keyword){
//      return cdao.searchK(start,end,keyword);
//   }
//   
//   //검색 2.태그
//   public List<ChalBasicDTO> searchT(int start, int end, String keyword){
//      return cdao.searchT(start,end,keyword);
//   }
//   
//   //검색 3.일수
//   public List<ChalBasicDTO> searchD(int start, int end, String keyword){
//      return cdao.searchD(start,end,keyword);
//   }
//   
//
//   // 챌린지 디테일 불러오기
//   public ChalBasicDTO selectBySeq(int seq) {
//      return cdao.selectBySeq(seq);
//   }
//   
//
//   // 챌린지 디테일에 사람들이 올린 인증샷 불러오기
//   public List<CertiImgDTO> selectCertiImg(int seq) {
//      return cdao.selectCertiImg(seq);
//   }
//   
//
//   //카테고리
//   public List<ChalBasicDTO> listCategory(String category){
//      return cdao.listCategory(category);
//   }
//   
//   //카테고리 정렬
//   public List<ChalBasicDTO> categoryFilter(String category, String filter){
//      return cdao.categoryFilter(category, filter);
//   }

}