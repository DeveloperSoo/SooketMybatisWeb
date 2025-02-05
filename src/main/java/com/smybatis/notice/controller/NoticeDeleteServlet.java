package com.smybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.smybatis.member.common.NavigationUtil;
import com.smybatis.notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteServlet
 */
@WebServlet("/notice/delete")
public class NoticeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService= new NoticeService();	
		int result = 0;
		int noticeNo = (request.getParameter("noticeNo") != null )
						?Integer.parseInt(request.getParameter("noticeNo")) : 0;
		result = nService.deleteNotice(noticeNo);
		
		if(result > 0) {
			response.sendRedirect("/notice/list");
		}else {
			NavigationUtil.navigateToError(request, response, "404", "삭제할 데이터가 없습니다.");
		}
	}
}
