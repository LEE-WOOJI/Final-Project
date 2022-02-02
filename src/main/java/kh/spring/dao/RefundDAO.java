package kh.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.RefundDTO;

@Repository
public class RefundDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<RefundDTO> listBound(int start, int end){
		Map<Object,Object> map = new HashMap<>();
		map.put("start",start);
		map.put("end", end);		
		return mybatis.selectList("Refund.listBound", map);
	}
	
	public int delete(String nickname) {
		return mybatis.update("Refund.delete", nickname);
	}
	
	public List<RefundDTO> refundSearch(int start, int end, String chalName, String nickname){
		Map<Object,Object> map = new HashMap<>();
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		map.put("chalName",chalName);
		map.put("nickname", nickname);		
		return mybatis.selectList("Refund.refundSearch", map);
	}
	
	public int insert(RefundDTO dto) {
		Map<Object,Object> map = new HashMap<>();
		map.put("chalSeq", dto.getChalSeq());
		map.put("chalName", dto.getChalName());
		map.put("price",dto.getPrice());
		map.put("rate",dto.getRate());
		map.put("nickname",dto.getNickname());
		map.put("bank",dto.getBank());
		map.put("account",dto.getAccount());
		return mybatis.update("Refund.insert", map);
	}
	
	//환급 중복
	public int refundOk(String nickname, int chalSeq) {
		System.out.println("DAO" + chalSeq);
		Map<Object,Object> map = new HashMap<>();
		map.put("nickname", nickname);
		map.put("chalSeq", chalSeq);
		return mybatis.selectOne("Refund.refundOk",map);
	}
	
	//환급 처리
	public int update(String nickname, String chalName) {
		Map<Object,Object> map = new HashMap<>();
		map.put("nickname", nickname);
		map.put("chalName", chalName);
		return mybatis.update("Refund.update", map);
	}
}
