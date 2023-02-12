package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
import com.kh.common.model.vo.PageInfo;

import static com.kh.common.JDBCTemplate.*;
public class BoardDao {

	private Properties prop = new Properties();
	
	public BoardDao() {
		
		try {
			prop.loadFromXML(new FileInputStream(BoardDao.class.getResource("/sql/board/board-mapper.xml").getPath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		
		// select문 -> ResultSet객체

		int listCount = 0;
		
		PreparedStatement psmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			rset = psmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return listCount; 
		
		
	}
	
	public ArrayList<Board> selectList(Connection conn, PageInfo pi){
		
		// select문 => ResultSet
		ArrayList<Board> list = new ArrayList<>();
		
		PreparedStatement psmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			/*
			 * boardLimit이 10이라고 가정.
			 * 
			 * currentPage = 1 => 시작값 1, 끝값 10
			 * currentPage = 2 => 시작값 11, 끝값 20
			 * currentPage = 3 => 시작값 21, 끝값 30
			 * 
			 * 시작값 = (currentPage -1) * boardLimit +1;
			 * 끝값 = 시작값 + boardLimit -1;
			 */
			int startRow = (pi.getCurrentPage() -1)* pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			psmt.setInt(1, startRow);
			psmt.setInt(2, endRow);
			
			rset = psmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Board(rset.getInt("BOARD_NO"),
						  rset.getString("CATEGORY_NAME"),
						  rset.getString("BOARD_TITLE"),
						  rset.getString("USER_ID"),
						  rset.getInt("COUNT"),
						  rset.getDate("CREATE_DATE")));
							
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return list;
		
	}
	
	public int increaseCount(Connection conn, int boardNo) {
		
		int result = 0;
		
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;
	}
	
	public Board selectBoard(Connection conn, int boardNo) {
		
		// select => ResultSet
		
		Board b = null;
		PreparedStatement psmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			rset = psmt.executeQuery();
			
			if(rset.next()) {
				b = new Board(
						rset.getInt("BOARD_NO"),
						rset.getString("CATEGORY_NAME"),
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"),
						rset.getString("USER_ID"),
						rset.getDate("CREATE_DATE")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return b;
	}
	
	public Attachment selectAttachment(Connection conn, int boardNo) {
		
		Attachment at = null;
		
		PreparedStatement psmt = null;
		 
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			rset = psmt.executeQuery();
			
			if(rset.next()) {
				at = new Attachment();
				
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOrignName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return at;
	}
	
	public ArrayList<Category> selectCategoryList(Connection conn){
		ArrayList<Category> list = new ArrayList<>();
		
		PreparedStatement psmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			rset = psmt.executeQuery();
			
			while(rset.next()) {
				Category c = new Category();
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				c.setCategoryNo(rset.getInt(1)); // 1 = "CATEGORY_NO" 
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
		
		return list;
	}
	
	public int insertBoard(Board b, Connection conn) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, Integer.parseInt(b.getCategory()));
			psmt.setString(2, b.getBoardTitle());
			psmt.setString(3, b.getBoardContent());
			psmt.setInt(4, Integer.parseInt(b.getBoardWriter()));
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;
	}
	
	public int insertAttachment(Attachment at, Connection conn) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, at.getOrignName());
			psmt.setString(2, at.getChangeName());
			psmt.setString(3, at.getFilePath());
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;	
	}
	
	public int updateBoard(Connection conn, Board b) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, Integer.parseInt(b.getCategory()));
			psmt.setString(2, b.getBoardTitle());
			psmt.setString(3, b.getBoardContent());
			psmt.setInt(4, b.getBoardNo());
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;
	}
	
	public int updateAttachment(Attachment at, Connection conn) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("updateAttachment");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, at.getOrignName());
			psmt.setString(2, at.getChangeName());
			psmt.setString(3, at.getFilePath());
			psmt.setInt(4, at.getFileNo());
			
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;
		
	}
	
	public int insertNewAttachment(Attachment at, Connection conn) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, at.getRefNo());
			psmt.setString(2, at.getOrignName());
			psmt.setString(3, at.getChangeName());
			psmt.setString(4, at.getFilePath());
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		return result;	
	}
	
	public int deleteBoard(int boardNo, Connection conn) {
		
		int result = 0;
		PreparedStatement psmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
		
		
		return result;
	}
	
    public void deleteAttachment(int boardNo , Connection conn) {
        
        PreparedStatement psmt = null;
        
        String sql = prop.getProperty("deleteAttachment");
        
        try {
            psmt = conn.prepareStatement(sql);
            
            psmt.setInt(1, boardNo);
            
            psmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(psmt);
        }
    }

    public ArrayList<Board> selectThumbnailList(Connection conn){
    	
    	ArrayList<Board> list = new ArrayList<>();
    	
    	PreparedStatement psmt = null;
    	
    	ResultSet rset = null;
    	
    	String sql = prop.getProperty("selectThumbnailList");
    	
    	try {
			psmt = conn.prepareStatement(sql);
			
			rset = psmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt(1));
				b.setBoardTitle(rset.getString(2));
				b.setCount(rset.getInt(3));
				b.setTitleImg(rset.getString(4));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
    	
    	return list; 
    	
    }
    
    public int insertThumbnailBoard(Connection conn, Board b) {
    	
    	int result = 0;
    	PreparedStatement psmt = null;
    	
    	String sql = prop.getProperty("insertThumbnailBoard");
    	
    	try {
    		 psmt = conn.prepareStatement(sql);
             psmt.setString(1, b.getBoardTitle());
             psmt.setString(2, b.getBoardContent());
             psmt.setInt(3, Integer.parseInt(b.getBoardWriter()));
             
             result = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(psmt);
		}
    	return result;
    }
    
    public int insertAttachmentList(Connection conn , ArrayList<Attachment> list) {
        int result = 1;
        
        PreparedStatement psmt = null;
        
        int result2 = 1;
        
        String sql = prop.getProperty("insertAttachmentList");
        
        try {
            
        	psmt = conn.prepareStatement(sql);
        	
            for(Attachment at : list) {
                
                psmt.setString(1, at.getOrignName());
                psmt.setString(2, at.getChangeName());
                psmt.setString(3, at.getFilePath());
                psmt.setInt(4, at.getFilelevel());
                
                // 실행 
                result2 = psmt.executeUpdate();
                if(result2 == 0) {
                    result = 0;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(psmt);
        }
        
        return result;
    }
    
    public ArrayList<Attachment> selectAttachmentList(Connection conn, int boardNo){
    	
    	ArrayList<Attachment> list = new ArrayList<>();
    	
    	PreparedStatement psmt = null;
    	ResultSet rset = null;
    	
    	String sql = prop.getProperty("selectAttachment");
    	
    	try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			
			rset = psmt.executeQuery();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setFilelevel(rset.getInt("FILE_LEVEL"));
				
				list.add(at);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
    	
    	return list;
    }
    
    public ArrayList<Board> searchList(Connection conn, String searchType, String keyword){
    	
    	ArrayList<Board> list = new ArrayList<>();
    	PreparedStatement psmt = null;
    	
    	ResultSet rset = null; 
    	
    	String sql = prop.getProperty("searchList");
    	// 지금은 searchType 값을 하드코딩해 두었지만, 사용자의 요청방법에 맞게끔 변경도 가능해야함.
    	
//    	switch(searchType) {
//    	case "1" : searchType = "BOARD_TITLE"; break;
//    	case "2" : searchType = "BOARD_CONTENT"; break;
//    	case "3" : searchType = "USER_ID"; break;
//    	}
    	
    	sql = sql.replace("@", searchType); // @를 내가 원하는 검색조건으로 변환해주기.
    	
    	try {
			psmt = conn.prepareStatement(sql); 
			
			psmt.setString(1, "%"+keyword+"%");// '%keyword%' => 만약에 sql문안에 '%'?'%'이렇게 작성시 -> '%'keyword'%'
			
			rset= psmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(psmt);
		}
    	
    	return list;
    }
}