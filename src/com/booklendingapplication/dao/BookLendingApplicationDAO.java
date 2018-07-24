package com.booklendingapplication.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.booklendingapplication.pojo.Book;
import com.booklendingapplication.pojo.User;

public interface BookLendingApplicationDAO 
{
	public User checkLogin(long id,String password) throws SQLException;

	public ArrayList<Book> getBooks() throws SQLException;
	
	public Boolean insertBook(Book book) throws SQLException;

	public ArrayList<Book> getMyBooks(String username) throws SQLException;

	public int deleteBook(String id) throws SQLException;

	public int updateBook(Book book) throws SQLException;

	public Book getBook(String id) throws SQLException;
	
	public boolean request(String bookId, String userId) throws SQLException;
	
	public ArrayList<Book> requestForApproval(String userId) throws SQLException;

	public ArrayList<Book> myRequestApprovalStatus(String userId) throws SQLException;

	public boolean approveRequest(String id, String bookId) throws SQLException;

	public boolean rejectRequest(String requstId, String bookId) throws SQLException;

	public boolean returnedRequest(String requstId, String bookId) throws SQLException;

	public boolean withdrawRequest(String requstId, String bookId) throws SQLException;

	public ArrayList<Book> searchBooks(String name,String author,String owner,String availableFrom,String availableTo) throws SQLException;

	public User myAccount(String id) throws SQLException;

	public int updatePassword(String id, String password) throws SQLException;
}
