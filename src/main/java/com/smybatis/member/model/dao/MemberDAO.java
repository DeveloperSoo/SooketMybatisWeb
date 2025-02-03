package com.smybatis.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.smybatis.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneByLogin(SqlSession conn, Member member) {
		Member result = conn.selectOne("MemberMapper.selectOneByLogin", member);
		return result;
	}
	
	public Member selectOneById(SqlSession conn, String memberId) {
		Member member = conn.selectOne("MemberMapper.selectOneById", memberId); 
		return member;
	}
	

	public int insertMember(SqlSession conn, Member member) {
		int result = conn.insert("MemberMapper.insertMember", member);
		return result;
	}

	public int updateMember(SqlSession conn, Member member) {
		int result = conn.update("MemberMapper.updateMember", member); 
		return result;
	}


//		이건 구형 방식	
//	public Member selectOneByLogin(Connection conn, Member member) throws SQLException {
//		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ? AND MEMBER_PWD = ?";
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		Member result = null;
//		pstmt = conn.prepareStatement(query);
//		pstmt.setString(1, member.getMemberId());
//		pstmt.setString(2, member.getMemberPwd());
//		rset = pstmt.executeQuery();
//		
//		if(rset.next()) {
//			String memberId			=rset.getString("MEMBER_ID");
//			String memberName		=rset.getString("MEMBER_NAME");
//			String email 			=rset.getString("EMAIL");
//			result = new Member(memberId, memberName, email);
//		}
//		pstmt.close();
//		rset.close();
//		return result;
//	}
}
