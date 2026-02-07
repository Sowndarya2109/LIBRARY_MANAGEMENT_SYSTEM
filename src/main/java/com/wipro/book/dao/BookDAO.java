package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.BookBean;
import com.wipro.book.util.DBUtil;

public class BookDAO {
	public int createBook(BookBean bookBean) {
		Connection con = DBUtil.getDBConnection();
		String query = "INSERT INTO Book_TBL VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, bookBean.getIsbn());
			ps.setString(2, bookBean.getBookName());
			ps.setString(3, String.valueOf(bookBean.getBookType()));
			ps.setInt(4, bookBean.getAuthor().getAuthorCode());
			ps.setFloat(5, bookBean.getCost());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	public BookBean fetchBook(String isbn) {
		Connection con = DBUtil.getDBConnection();
		String Bookquery = "SELECT * FROM Book_TBL WHERE isbn = ?";
		AuthorDAO authorDAO = new AuthorDAO();
		BookBean bookBean = new BookBean();
		try {
			PreparedStatement ps = con.prepareStatement(Bookquery);
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			   bookBean.setIsbn(rs.getString(1));
			   bookBean.setBookName(rs.getString(2));
			   bookBean.setBookType(rs.getString(3).charAt(0));
			   bookBean.setAuthor(authorDAO.getAuthor(rs.getInt(4)));
			   bookBean.setCost(rs.getFloat(5));
			   return bookBean;
			}
			return null;		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
