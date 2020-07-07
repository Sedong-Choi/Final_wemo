package com.naver.wemo.controller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.naver.wemo.DAO.CalendarDAO;
import com.naver.wemo.domain.Memo;

@Controller
public class CalendarController {
	
	@Autowired Memo memo;
	 
	@Autowired CalendarDAO calendardao; 
	 
	@RequestMapping("/Calendar")
	public String newCalendar() {
		return "Calendar";
	}
	
	@RequestMapping("/CalendarWrite.net")
	public String calendar_write(Memo memo) {
		calendardao.insert(memo);
		return "";
	}
	
	@PostMapping("calendarDeleteAction.net")
	public ModelAndView calendarDeleteAction(ModelAndView mv, HttpServletResponse response,
			HttpServletRequest request,String USER_EMAIL, int num) throws Exception{
		
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
		   } else {
			   out.println("alert('수정실패했습니다.');");
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
		   } else {
			   out.println("alert('수정실패했습니다.');");
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
		   } else {
			   out.println("alert('수정실패했습니다.');");
		   }
		   out.println("</script>");
		   out.close();
	}
	
	@ResponseBody
	@RequestMapping(value = "/calendarListAjax.net")
	public Map<String,Object> calendarListAjax(
			@RequestParam(value="page", defaultValue="1", required=false) int page,
			@RequestParam(value="limit", defaultValue="1000", required=false) int limit
			)
			{
		int listcount = calendardao.getListCount();	// 총 리스트  수를 받아옴.
		
		List<Memo> calendarlist = calendardao.getcalendarList(page, limit); // 리스트 받아옴
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("page", page);
		map.put("listcount", listcount);
		map.put("calendarlist", calendarlist);
		map.put("limit", limit);
		return map;
			}
}
