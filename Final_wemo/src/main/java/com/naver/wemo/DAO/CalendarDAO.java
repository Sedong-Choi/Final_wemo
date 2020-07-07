package com.naver.wemo.DAO;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.wemo.domain.Memo;

@Repository
public class CalendarDAO {

	
	 @Autowired
	 private SqlSessionTemplate sqlSession;
	 
	 public void insert(Memo memo)
	 { sqlSession.insert("Cal.insert", memo); }
	 
	 public int update(Memo memo)
	 { return sqlSession.update("Cal.update", memo); }	

	public int calendarDelete(int num) {
		return sqlSession.delete("Cal.calendarDelete", num);
	}

	public int REupdate(Memo memo) {
		return sqlSession.update("Cal.REupdate",memo);
	}

	public int DGupdate(Memo memo) {
		return sqlSession.update("Cal.DGupdate",memo);
	}

	public int getListCount() {
		return sqlSession.selectOne("Cal.count");
	}

	public List<Memo> getcalendarList(int page, int limit) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return sqlSession.selectList("Cal.list",map);
	}
	 
}
