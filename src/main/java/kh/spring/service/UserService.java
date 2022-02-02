package kh.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.UserDAO;
import kh.spring.dto.MemberDTO;
import kh.spring.utils.Static;

@Service
public class UserService {
   @Autowired
   private UserDAO udao;
   
   //유저 전체 조회
   public List<MemberDTO> selectBound(int start, int end){
      return udao.selectBound(start, end);
   }
   
   //유저 검색 조회
   public List<MemberDTO> searchBound(int start, int end, String id, String nickname, String blacklist){
      return udao.searchBound(start, end, id, nickname, blacklist);
   }
   
   //유저 탈퇴
   public int delete(String id) {
      return udao.delete(id);
   }
   
   //유저 블랙
   public int black(String id, String black) {
      return udao.black(id, black);
   }
   
   //등급에 맞는 유저 수 조회
   public List<MemberDTO> userGrade(String grade){
      return udao.userGrade(grade);
   }
   
   //등급에 맞으면서 검색대상 조회
   public List<MemberDTO> userGradeSearch(String grade, String option, String keyword){
      return udao.userGradeSearch(grade, option, keyword);
   }
   
   //유저 인원 수
   public int userCount() {
      return udao.userCount();
   }
   
   //검색대상의 유저 인원 수
   public int userSearchCount(String id, String nickname, String blacklist) {
      return udao.userSearchCount(id, nickname, blacklist);
   }
   //원하는 등급으로 변경하기
   public int GradeMeta(String grade, String id) {
      return udao.GradeMeta(grade, id);
   }
   
}