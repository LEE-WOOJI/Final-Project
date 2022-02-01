package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.dto.ProfileDTO;

@Repository
public class MemberDAO {


	@Autowired
	private SqlSessionTemplate mybatis;
	// 로그인 기능
	public int isLoginAllowed(String id, String pw) {
		Map<String,String> map = new HashMap<>();
		System.out.println("디에이오"+id+pw);
		//map.put("seq", String.valueOf(seq)); 
		map.put("id", id);
		map.put("pw", pw);
		return mybatis.selectOne("Member.isLoginAllowed", map);
	}
	//아이디 중복체크
	public MemberDTO isIDExist(String id) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		
		return mybatis.selectOne("Member.isIDExist", map);
	}
	//비밀번호 중복체크
	public MemberDTO isPWExist(String pw) {
		Map<String,String> map = new HashMap<>();
		map.put("pw", pw);
		
		return mybatis.selectOne("Member.isPWExist", map);
	}
	//이메일 중복체크
	public MemberDTO isEMAILExist(String email) {
		Map<String,String> map = new HashMap<>();
		map.put("email", email);
		
		return mybatis.selectOne("Member.isEMAILExist", map);
	}
	//회원가입 성공
	public int insertMember(MemberDTO dto) {
		
		mybatis.insert("Member.insertMember",dto);
		return dto.getSeq();
		
	}
	//회원가입 시 이미지 저장
	public int insertMemberImg(String oriName, String sysName,int seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("oriName"  , oriName);
		map.put("sysName"  , sysName);
		map.put("seq", String.valueOf(seq));
		return mybatis.insert("Member.insertMemberImg",map);
	}
		
	//닉네임 중복체크
	public MemberDTO isNICExist(String nickname) {
		Map<String,String> map = new HashMap<>();
		map.put("nickname", nickname);
		
		return mybatis.selectOne("Member.isNICExist", map);
	}
	//아이디 찾기
	public MemberDTO searchId(String email) {
		Map<String,String> map = new HashMap<>();
		map.put("email", email);
		
		return mybatis.selectOne("Member.searchId", map);
	}
	//비밀번호 찾기
	public MemberDTO searchPw(String id) {
		Map<String,String> map = new HashMap<>();
		map.put("id", id);
		
		return mybatis.selectOne("Member.searchPw", map);
	}
	
	
	//카카오 로그인
	public int kakaoInsert( String nickname, String email) {
		Map<String,String> map = new HashMap<>();
		map.put("id", email);
		map.put("email", email);
		map.put("nickname", nickname);
		
		return mybatis.insert("Member.kakaoInsert", map);
            
        }
	
	//임시 비밀 번호 저장
	public void updateTempPassword(MemberDTO dto) {
		mybatis.update("Member.updateTempPassword",dto);
	}
	
	
	

}

 
   
   


