package com.smybatis.member.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.smybatis.member.common.NavigationUtil;
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
		// HttpSession 객체를 가져옴
		HttpSession session = request.getSession();
		// 세션에 저장된 정보를 가져와야함. getAttribute() 메소드 이용
		Object obj = session.getAttribute("result");
		// getAttribute() 메소드는 반환형은 Object이기 때문에 Member타입으로 형변환을 시켜줘야함
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
				NavigationUtil.navigateToError(request, response, "404", "데이터가 존재하지 않습니다.");
//				request.getRequestDispatcher("/WEB-INF/views/commonerror.jsp").forward(request, response);
			}			
		}else {
			NavigationUtil.navigateToError(request, response, "404", "로그인이 필요합니다..");
			//request.getRequestDispatcher("/WEB-INF/views/commonerror.jsp").forward(request, response);
		}	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
}
