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
				
				sendSearchPwInfo.setId(id);
				sendSearchPwInfo.setPw(env_temp_pw);
				mdao.updateTempPassword(sendSearchPwInfo);
				CommonUtils.sendMail(email,Static.TEMP_PASSWORD);
			}
			return true;
		}
		//아이디 찾기
		
		public boolean searchId(String email) {
			MemberDTO memberInfo = mdao.isEMAILExist(email);
		if(memberInfo != null) {
				String id = memberInfo.getId();
				if(id == "") return false;
				
				CommonUtils.sendMail(email, id);
			}
			return true;
		}
		
	//카카오 로그인
		public boolean kakaoInsert(String nickname, String email) {
			
			MemberDTO idcheck = mdao.isIDExist(email);
		
			
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
   

}