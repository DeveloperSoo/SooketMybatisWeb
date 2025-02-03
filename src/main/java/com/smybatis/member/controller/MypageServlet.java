package com.smybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.smybatis.member.model.service.MemberService;
import com.smybatis.member.model.vo.Member;

/**
 * Servlet implementation class MypageServlet
 */
@WebServlet("/member/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService mService = new MemberService();
		HttpSession session = request.getSession();
		Member searchOne = (Member)session.getAttribute("result");
		String memberId = searchOne.getMemberId();
		if(memberId != null) {
			Member member = mService.selectOneById(memberId);
//		String mId = (String)session.getAttribute(memberId);
//		String memberId = (String)(request.getSession()).getAttribute("memberId");
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/WEB-INF/views/member/mypage.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/views/commonerror.jsp").forward(request, response);
			}			
		}else {
			request.getRequestDispatcher("/WEB-INF/views/commonerror.jsp").forward(request, response);
		}	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
