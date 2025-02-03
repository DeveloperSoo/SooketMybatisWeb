package com.smybatis.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.smybatis.member.common.JDBCTemplate;
import com.smybatis.member.common.SqlSessionTemplate;
import com.smybatis.member.model.dao.MemberDAO;
import com.smybatis.member.model.vo.Member;

public class MemberService {
	private JDBCTemplate jdbcTemplate;
	private SqlSession conn;
	private MemberDAO mDao;
	
	public MemberService() {
		conn = SqlSessionTemplate.getSqlSession();
		jdbcTemplate =JDBCTemplate.getInstance();
		mDao = new MemberDAO();
	}
	
	
	public Member selectOneByLogin(Member member) {
		Member result = mDao.selectOneByLogin(conn, member);
		return result;
		
//		Connection conn = null;
//		Member result = null;
//		
//		try {
//			conn = jdbcTemplate.getConnection();
//			result = mDao.selectOneByLogin(conn, member);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		return result;
	}
	
	public Member selectOneById(String memberId) {
		Member member = mDao.selectOneById(conn, memberId);
		return member;
	}


	public int insertMember(Member member) {
		int result = mDao.insertMember(conn, member);
		return result;
	}


	public int updateMember(Member member) {
		int result = mDao.updateMember(conn, member);
		return result;
	}



}

