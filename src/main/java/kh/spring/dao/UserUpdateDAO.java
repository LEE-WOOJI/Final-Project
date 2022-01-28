package kh.spring.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class UserUpdateDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	//회원 정보 조회
	public SqlSessionTemplate userupdate(String id, String pw, String name, String nickname, String phone, String email, String address1, String address2, String bank, String account, String money, String grade) {
		return mybatis;
		
	}
}
