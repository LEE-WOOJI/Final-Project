package kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.RefundDAO;
import kh.spring.dto.RefundDTO;

@Service
public class RefundService {
	@Autowired
	private RefundDAO rdao;
	
	public List<RefundDTO> listBound(int start, int end){
		return rdao.listBound(start, end);
	}
	
	public int delete(String nickname) {
		return rdao.delete(nickname);
	}
	
	public List<RefundDTO> refundSearch(int start, int end, String chalName, String nickname){
		return rdao.refundSearch(start, end, chalName, nickname);
	}
	
	public int insert(RefundDTO dto) {
		return rdao.insert(dto);
	}
	public int refundOk(String nickname, String chalName) {
		return rdao.refundOk(nickname, chalName);
	}
	public int update(String nickname, String chalName) {
		return rdao.update(nickname, chalName);
	}
}
