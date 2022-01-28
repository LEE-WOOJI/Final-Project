package kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.JoinChalDTO;
import kh.spring.dto.MemberDTO;
@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public MemberDTO selectBySeq(int seq) {
		return mybatis.selectOne("Member.selectBySeq", seq);
	}
	
	public List<JoinChalDTO> selectMyChal(String nickName) {
		return mybatis.selectList("Member.selectMyChal", nickName);
	}
}
