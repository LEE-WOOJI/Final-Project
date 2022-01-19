package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ChalDAO;
import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.ChalBasicDTO;

@Service
public class ChalService {
	@Autowired
	private ChalDAO cdao;
	
	//전체조회
	public List<ChalBasicDTO> listBound(int start, int end){
		return cdao.listBound(start, end);
	}
	
	//검색 1.키워드
	public List<ChalBasicDTO> searchK(int start, int end, String keyword){
		return cdao.searchK(start,end,keyword);
	}
	
	//검색 2.태그
	public List<ChalBasicDTO> searchT(int start, int end, String keyword){
		return cdao.searchT(start,end,keyword);
	}
	
	//검색 3.일수
	public List<ChalBasicDTO> searchD(int start, int end, String keyword){
		return cdao.searchD(start,end,keyword);
	}
	

	// 챌린지 디테일 불러오기
	public ChalBasicDTO selectBySeq(int seq) {
		return cdao.selectBySeq(seq);
	}
	
	// 챌린지 디테일에 사람들이 올린 인증샷 불러오기
	public List<CertiImgDTO> selectCertiImg(int seq) {
		return cdao.selectCertiImg(seq);
	}
	
}
