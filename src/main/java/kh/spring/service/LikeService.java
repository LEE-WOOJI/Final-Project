package kh.spring.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.LikeDAO;

@Service
public class LikeService {

	@Autowired
	private LikeDAO ldao;
	
	public boolean likeCheck(String id, String likeNum) {
		return ldao.likeCheck(id, likeNum);
	}
}
