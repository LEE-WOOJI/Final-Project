package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.AdminDAO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adao;
}
