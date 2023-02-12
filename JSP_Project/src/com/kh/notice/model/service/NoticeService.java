package com.kh.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

import static com.kh.common.JDBCTemplate.*; // JDBCTemplate 클래스의 모든메소드들을 그냥 가져다 쓰겟다.

public class NoticeService {

    public ArrayList<Notice>selectNoticeList(){
        
        Connection conn = getConnection(); // JDBCTemplate.getConnection();와 같은코드 => static로 import해왔기 때문에 생략가능.
        
        ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
        
        close();
        
        return list;
    }
    
    public int increaseCount(int noticeNo) {
        Connection conn = getConnection();
        
        int result = new NoticeDao().increaseCount(noticeNo , conn);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close();
        return result;
    }
    
    public Notice selectNotice(int noticeNo) {
        Connection conn = getConnection();
        
        Notice n = new NoticeDao().selectNotice(noticeNo , conn);
        
        close();
        
        return n;
    }
    
    public int insertNotice(Notice n) {
        Connection conn = getConnection();
        
        int result = new NoticeDao().insertNotice(n , conn);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close();
        
        return result;
    }
    
    public int updateNotice(Notice n) {
        Connection conn = getConnection();
        
        int result = new NoticeDao().updateNotice(n , conn);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close();
        return result;
    }
    
    public int deleteNotice(int noticeNo) {
        Connection conn = getConnection();
        
        int result = new NoticeDao().deleteNotice(noticeNo , conn);
        
        commitOrRollback(result, conn);
        
        return result;
    }
    
    public void commitOrRollback(int result , Connection conn) {
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close();
    }
    
    
}
