package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.CertiDAO;

@Service
public class CertiService {
	@Autowired
	private CertiDAO cdao;
	
	//어던 유저가 어떤 챌린지에 대해 얼마나 많은 인증샷을 올렸는지 조회
	public int certiCount(String nickname, int chalSeq) {
		return cdao.certiCount(nickname, chalSeq);
	}
}
