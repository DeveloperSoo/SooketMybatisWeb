package com.smybatis.notice.model.service;

import org.apache.ibatis.session.SqlSession;

import com.smybatis.member.common.SqlSessionTemplate;
import com.smybatis.notice.model.dao.NoticeDao;
import com.smybatis.notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDao nDao;
	private SqlSession session;
	
	public NoticeService() {
		nDao = new NoticeDao();
		session = SqlSessionTemplate.getSqlSession();
	}
	
	

	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(session, notice);
		return result;
	}
	
	
	
}
