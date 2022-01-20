package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ChalDAO;
import kh.spring.dto.ChalBasicDTO;

@Service
public class ChalingService {
	@Autowired
	private ChalDAO cdao;
	
	public List<ChalBasicDTO> listBount(int start, int end) {
		return cdao.listBound(start, end);
	}
}
