package com.naver.wemo.domain;

import java.util.Date;

public class Calendar {
	private String USER_EMAIL;	// 아이디
	private String MEMO_SUB;	// 메모 주제
	private String MEMO_TEX;	// 메모 내용
	private Date MEMO_DATE;		// 메모 최초 작성일
	private Date MEMO_PRE;		// 메모 최종 작성일
	
	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}
	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}
	public String getMEMO_SUB() {
		return MEMO_SUB;
	}
	public void setMEMO_SUB(String mEMO_SUB) {
		MEMO_SUB = mEMO_SUB;
	}
	public String getMEMO_TEX() {
		return MEMO_TEX;
	}
	public void setMEMO_TEX(String mEMO_TEX) {
		MEMO_TEX = mEMO_TEX;
	}
	public Date getMEMO_DATE() {
		return MEMO_DATE;
	}
	public void setMEMO_DATE(Date mEMO_DATE) {
		MEMO_DATE = mEMO_DATE;
	}
	public Date getMEMO_PRE() {
		return MEMO_PRE;
	}
	public void setMEMO_PRE(Date mEMO_PRE) {
		MEMO_PRE = mEMO_PRE;
	}
	
}
