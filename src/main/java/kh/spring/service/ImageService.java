package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.ImageDAO;

@Service
public class ImageService {
	@Autowired
	private ImageDAO iDao;
	
}
