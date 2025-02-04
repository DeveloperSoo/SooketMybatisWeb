package com.smybatis.notice.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.smybatis.notice.model.vo.Notice;

public class NoticeDao {
	
	public NoticeDao() {}
	

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

}
