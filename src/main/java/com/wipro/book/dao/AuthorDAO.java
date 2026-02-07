package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

public class AuthorDAO {
	public AuthorBean getAuthor(int authorCode) {
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM Author_TBL WHERE Author_Code = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, authorCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AuthorBean author = new AuthorBean();
				author.setAuthorCode(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				author.setContactNo(rs.getLong(3));			
				return author;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}
	public AuthorBean getAuthor(String authorName) {
		Connection con = DBUtil.getDBConnection();
		String query = "SELECT * FROM Author_TBL WHERE Author_name = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, authorName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				AuthorBean author = new AuthorBean();
				author.setAuthorCode(rs.getInt(1));
				author.setAuthorName(rs.getString(2));
				author.setContactNo(rs.getLong(3));			
				return author;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}	
	}

}
