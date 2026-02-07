package com.wipro.book.service;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;

public class Administrator {
	BookDAO bookDAO = new BookDAO();
	public String addBook(BookBean bookBean) {
		if(bookBean == null 
				|| bookBean.getBookName().isEmpty() || bookBean.getIsbn().isEmpty() 
				|| (bookBean.getBookType() != 'G' && bookBean.getBookType() != 'T')
				|| bookBean.getCost() <= 0 || bookBean.getAuthor().getAuthorName().isEmpty()) {
			return "INVALID";
		}
		int result = bookDAO.createBook(bookBean);
		if(result == 1)
			return "SUCCESS";
		return "FAILURE";
	}
	public BookBean viewBook(String isbn) {
		BookBean book = bookDAO.fetchBook(isbn);
		return book;		
	}
}
