package com.naver.wemo.DAO;

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
	 
	 public void select(Memo memo)
	 { sqlSession.selectOne("Cal.select", memo); }
	 
	 public int update(Memo memo)
	 { return sqlSession.update("Cal.update", memo); }

	public boolean isCalendarWriter(int num, String uSER_EMAIL) {
		return false;
	}

	public int calendarDelete(int num) {
		return sqlSession.delete("Cal.calendarDelete", num);
	}

	public int REupdate(Memo memo) {
		return sqlSession.update("Cal.REupdate",memo);
	}

	public int DGupdate(Memo memo) {
		return sqlSession.update("Cal.DGupdate",memo);
	}
	 
}
