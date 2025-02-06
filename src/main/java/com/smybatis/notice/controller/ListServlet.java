package com.smybatis.notice.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.smybatis.member.common.NavigationUtil;
import com.smybatis.notice.model.service.NoticeService;
import com.smybatis.notice.model.vo.Notice;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/notice/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService nService = new NoticeService();
		int currentPage = request.getParameter("currentPage") != null  
				? Integer.parseInt(request.getParameter("currentPage")) : 1;
		
		List<Notice> nList = nService.selectListAll(currentPage);
		if(nList.size() > 0) {
			// currentPage: 1~5, startNavi: 1, endNavi: 5*1;
			// currentPage: 6~10, startNavi: 6, endNavi: 10 = 5*2;
			// currentPage: 11~15, startNavi: 11, endNavi: 15 = 5*3;
			int naviCountperPage = 5;
			int startNavi = (currentPage-1)/naviCountperPage*naviCountperPage+1;
			int endNavi = (startNavi-1) + naviCountperPage;
			
			
			request.setAttribute("nList", nList);
			request.setAttribute("startNavi", startNavi);
			request.setAttribute("endNavi", endNavi);
			request.getRequestDispatcher("/WEB-INF/views/notice/list.jsp").forward(request, response);			
		}else {
			NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
		}
	}
}
