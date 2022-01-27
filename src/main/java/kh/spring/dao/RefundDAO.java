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
	
}
