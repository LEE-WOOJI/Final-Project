package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;

@Service
public class UserService {
	@Autowired
	private MemberDAO memberdao;
	
	public MemberDTO selectBySeq(int seq) {
		return memberdao.selectBySeq(seq);
	}

	public List<JoinChalDTO> selectMyChal(String nickName){
		return memberdao.selectMyChal(nickName);
		
	}
}
