package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ChalDAO;
import kh.spring.dto.ChalBasicDTO;
import kh.spring.dto.ChalDTO;

@Service
public class ChalService {
	@Autowired
	private ChalDAO cdao;
	
	//전체조회
	public List<ChalBasicDTO> listBound(int start, int end){
		return cdao.listBound(start, end);
	}
}
