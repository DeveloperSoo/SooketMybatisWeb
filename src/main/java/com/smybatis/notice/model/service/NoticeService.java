package com.smybatis.notice.model.service;

import java.util.List;

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



	public List<Notice> selectListAll() {
		List<Notice> nList = nDao.selectListAll(session);
		return nList;
	}



	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.selectOneByNo(session, noticeNo);
		return notice;
	}



	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(session, noticeNo);
		return result;
	}



	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(session, notice);
		return result;
	}

}
