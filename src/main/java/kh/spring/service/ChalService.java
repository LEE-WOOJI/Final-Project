package kh.spring.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ChalDAO;
import kh.spring.dto.CertiImgDTO;
import kh.spring.dto.ChalBasicDTO;
import kh.spring.dto.JoinChalDTO;

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
	

	//카테고리
	public List<ChalBasicDTO> listCategory(String category){
		return cdao.listCategory(category);
	}
	
	//카테고리 정렬
	public List<ChalBasicDTO> categoryFilter(String category, String filter){
		return cdao.categoryFilter(category, filter);
	}
	
	//결제끝나면, 참가자수 +1 
	public int addPersonnel(int seq) {
		return cdao.addPersonnel(seq);
	}

	public int joinChal(int refChalSeq, String nickname, String chalName, Timestamp startDate, 
			Timestamp endDate, int personnel, String chalInfo, String tag, String chalStat) {
		return cdao.joinChal(refChalSeq,nickname,chalName,startDate,endDate,personnel,chalInfo,tag,chalStat);
		
	}

}
