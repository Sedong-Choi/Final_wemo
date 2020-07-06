package com.naver.wemo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naver.wemo.DAO.CalendarDAO;
import com.naver.wemo.domain.Calendar;
import com.naver.wemo.domain.Memo;

@Controller
public class CalendarController {
	
	@Autowired Calendar calendar;
	 
	@Autowired CalendarDAO calendardao;
	
	@Autowired Memo memo;
	 
	
	@RequestMapping("/Calendar")
	public String newCalendar() {
		return "Calendar";
	}
	
	@RequestMapping("/CalendarWrite.net")
	public String calendar_write() {
		return "";
	}
	
	@PostMapping("calendarDeleteAction.net")
	public ModelAndView calendarDeleteAction(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request,String USER_EMAIL, int num) throws Exception{
		
		boolean usercheck = calendardao.isCalendarWriter(num, USER_EMAIL);
		
		if(usercheck == false) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('비밀번호가 다릅니다.');"); 
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		
		int result = calendardao.calendarDelete(num);
		
		if(result == 0) {
			System.out.println("삭제 실패");
			mv.setViewName("error/error");
			mv.addObject("url", request.getRequestURL());
			mv.addObject("message", "삭제 실패");
			return mv; 
		}
		
		System.out.println("삭제 성공");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter(); 
		out.println("<script>"); 
		out.println("alert('삭제 되었습니다.');"); 
		out.println("location.href='BoardList.bo';"); 
		out.println("</script>");
		out.close();
		return null;
	}
	
	@RequestMapping(value="/calendarupdate.net", method=RequestMethod.GET)
	public void calendarupdate(Memo memo, HttpServletResponse response) 
								throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = calendardao.update(memo);
		out.println("<script>");
		// 삽입이 된 경우
		   if (result == 1) {
			   out.println("alert('수정되었습니다.');");
			   out.println("location.href='Calendar';");
		   } else {
			   out.println("alert('수정실패했습니다.');");
			   out.println("location.href='Calendar';");
		   }
		   out.println("</script>");
		   out.close();
	}
	
	@RequestMapping(value="/calendarREupdate.net", method=RequestMethod.GET)
	public void calendarREupdate(Memo memo,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = calendardao.REupdate(memo);
		out.println("<script>");
		// 삽입이 된 경우
		   if (result == 1) {
			   out.println("alert('수정되었습니다.');");
			   out.println("location.href='Calendar';");
		   } else {
			   out.println("alert('수정실패했습니다.');");
			   out.println("location.href='Calendar';");
		   }
		   out.println("</script>");
		   out.close();
	}
	
	@RequestMapping(value="/calendarDGupdate.net", method=RequestMethod.GET)
	public void calendarDGupdate(Memo memo,HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int result = calendardao.DGupdate(memo);
		out.println("<script>");
		// 삽입이 된 경우
		   if (result == 1) {
			   out.println("alert('수정되었습니다.');");
			   out.println("location.href='Calendar';");
		   } else {
			   out.println("alert('수정실패했습니다.');");
			   out.println("location.href='Calendar';");
		   }
		   out.println("</script>");
		   out.close();
	}
}
