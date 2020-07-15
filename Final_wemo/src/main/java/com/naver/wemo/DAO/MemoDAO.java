package com.naver.wemo.DAO;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.wemo.domain.Memo;

@Repository
public class MemoDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
<<<<<<< HEAD
	public List<Memo> getMemoList(Memo memo) {
		return sqlSession.selectList("Memoes.getMemoList", memo);		
=======
	public void firstInsert(Member member) {
		// 회원 가입시 한 번만 입력되게 한다.
		Memo memo= new Memo();
		memo.setUSER_EMAIL(member.getUSER_EMAIL());	//회원 EMAIL
		// memo.setMEMO_NUM => xml 에서 memo colum 최대값 찾아서 셋팅해줌
		memo.setMEMO_SUB("STUDY");					//최초 STUDY
		memo.setMEMO_POSITION("absolute");			//최초 style = position
		memo.setMEMO_TOP("100px");					//최초 TOP 좌표
		memo.setMEMO_LEFT("100px");					//최초 LEFT 좌표
		memo.setMEMO_COLOR(""); 					//최초 메모 배경색
		memo.setMEMO_ZIN(1000); 					//최초 zindex
		memo.setMEMO_WIDTH("350px");				//최초 메모 폭
		memo.setMEMO_HEIGHT("200px");				//최초 메모 높이
		memo.setMEMO_TEX("새로운 메모를 작성해 보세요!");	//최초 TEXT
		// 최초 작성일, 최종 수정일은 xml에서 sysdate로 처리
		// 최초 PREV_TEX == MEMO_TEX 와 동일
		memo.setMEMO_FAV("Y");						//최초 즐겨찾기 Yes
		memo.setMEMO_LOC("N"); 						//최초 잠금 No
		sqlSession.insert("Memoes.firstinsert", memo);
>>>>>>> refs/remotes/origin/Hyuncheol
	}
<<<<<<< HEAD

	public int memoForNewAccount(String USER_EMAIL) {
		return sqlSession.insert("Memoes.memoForNewAccount",USER_EMAIL);
	}

	public int newMemo(Memo memo) {
		return sqlSession.insert("Memoes.newMemo", memo);
	}

	public Memo getLatestMemoInfo(Memo memo) {
		return sqlSession.selectOne("Memoes.getLatestMemoInfo", memo);
	}

	public int adjustMemoboxzindex(Memo memo) {
		return sqlSession.update("Memoes.adjustMemoboxzindex", memo);
	}

	public int getCountMemolist(Memo memo) {
		return sqlSession.selectOne("Memoes.getCountMemolist", memo);
	}

	public int deleteMemo(Memo memo) {
		return sqlSession.delete("Memoes.deleteMemo", memo);
	}

	public int saveMemoProperties(Memo memoObj) {
		return sqlSession.update("Memoes.saveMemoProperties", memoObj);
	}

	public List<Memo> getFavMemoList(Memo memo) {
		return sqlSession.selectList("Memoes.getFavMemoList", memo);
=======
	public void newInsert(Memo memo) {
		
		System.out.println(memo.getMEMO_TOP());
		memo.setMEMO_POSITION("absolute");
		if(memo.getMEMO_SUB().equals("STUDY")){
			memo.setMEMO_COLOR("#010101");
		}else if(memo.getMEMO_SUB().equals("MONEY")){
			memo.setMEMO_COLOR("#4266f5");
		}else if(memo.getMEMO_SUB().equals("HEALTH")){
			memo.setMEMO_COLOR("#de8e73");
		};
		memo.setMEMO_TEX("");	
		memo.setPREV_TEX("");
		memo.setMEMO_FAV("N");
		memo.setMEMO_LOC("N");
		memo.setMEMO_WIDTH("350px");				//최초 메모 폭
		memo.setMEMO_HEIGHT("200px");				//최초 메모 높이
		sqlSession.insert("Memoes.newinsert",memo);
>>>>>>> refs/remotes/origin/Hyuncheol
	}
	
	public List<Memo> getTraMemoList(Memo memo) {
		return sqlSession.selectList("Memoes.getTraMemoList", memo);
	}

	public int updateMemoFavorite(Memo memo) {
		return sqlSession.update("Memoes.updateMemoFavorite",memo);
	}

	public List<Memo> searchMemoList(Memo memo) {
		return sqlSession.selectList("Memoes.searchMemoList", memo);
	}

	public int moveToTrashBackAndForth(Memo memo) {
		return sqlSession.update("Memoes.moveToTrashBackAndForth", memo);
	}

	public Map<String, Object> getCountSectionlist(String USER_EMAIL) {
		return sqlSession.selectOne("Memoes.getCountSectionlist", USER_EMAIL);
	}
	
}
