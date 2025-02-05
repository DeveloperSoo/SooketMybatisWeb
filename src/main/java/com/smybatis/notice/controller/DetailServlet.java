package com.smybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.smybatis.member.common.NavigationUtil;
import com.smybatis.notice.model.service.NoticeService;
import com.smybatis.notice.model.vo.Notice;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/notice/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		// 페이지로 이동을 하는데 그 페이지가 비어있지 않으려면
		// 디비에서 Notice 객체를 가져오고 request에 setAttribute해서
		// detail.jsp에서 데이터가 출력되도록 해야함.
//		if(request.getParameter("noticeNo") != null) {
//			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
//		}else {
//			int noticeNo = 1;
//		}

		int noticeNo = request.getParameter("noticeNo") != null 
				? Integer.parseInt(request.getParameter("noticeNo")) : 1;
		
		Notice notice = nService.selectOneByNo(noticeNo);
		if(notice != null) {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다!");
		}
	}

}
