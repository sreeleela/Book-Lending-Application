 package com.booklendingapplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.booklendingapplication.pojo.Book;
import com.booklendingapplication.pojo.Request;
import com.booklendingapplication.pojo.User;

public class BookLendingApplicationDAOImpl implements BookLendingApplicationDAO
{
	public User user;
	@Override
	public User checkLogin(long id, String password) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		user = new User();
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from users where rid = "+id+";"); 
			while (rs.next())
			{
				user.setFirst_name(rs.getString(3));
				user.setPassword(rs.getString(2));
			} 
			return user;
		}
		catch(Exception e)
		{ 
			return user;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public ArrayList<Book> getBooks() throws SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select books.id,books.isbn,books.name,books.author,books.edition,books.publisher,books.description,books.availablefrom,books.availableto,users.first_name,books.hold,books.available from books books,users users where books.deleted=0 and books.user=users.rid"); 
			while (rs.next())
			{
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookISBN(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setBookAuthor(rs.getString(4));
				book.setBookEdition(rs.getString(5));
				book.setBookPublisher(rs.getString(6));
				book.setBookDescription(rs.getString(7));
				book.setBookAvailableFrom(rs.getDate(8));
				book.setBookAvailableTo(rs.getDate(9));
				book.setBookOwner(rs.getString(10));
				book.setBookHold(rs.getInt(11));
				book.setBookAvailable(rs.getInt(12));
				books.add(book);
			} 
			return books;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return books;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public ArrayList<Book> searchBooks(String name,String author,String owner,String availableFrom,String availableTo) throws SQLException
	{
		String str = "";
		if(!(name.equals(""))) {
			str = str + "books.name='"+name+"'";
		}
		if(!(author.equals("")) && !str.equals("")) {
			str = str + " and books.author='"+author+"'";
		}
		else if(!(author.equals("")) && str.equals("")) {
			str = str + "books.author='"+author+"'";
		}
		if(!(owner.equals("")) && !str.equals("")) {
			str = str + " and users.first_name='"+owner+"'";
		}
		else if(!(owner.equals("")) && str.equals("")) {
			str = str + "users.first_name='"+owner+"'";
		}
		if(!(availableFrom.equals("")) && !str.equals("")) {
			str = str + " and books.availableFrom >='"+availableFrom+"'";
		}
		else if(!(availableFrom.equals("")) && str.equals("")) {
			str = str + "books.availableFrom >='"+availableFrom+"'";
		}
		if(!(availableTo.equals("")) && !str.equals("")) {
			str = str + " and books.availableTo <='"+availableTo+"'";
		}
		else if(!(availableTo.equals("")) && str.equals("")) {
			str = str + "books.availableTo <='"+availableTo+"'";
		}
		if(!str.equalsIgnoreCase("")) {
			str = " and "+ str;
		}
		
		Connection connection = null;
		Statement stmt = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select books.id,books.isbn,books.name,books.author,books.edition,books.publisher,books.description,books.availablefrom,books.availableto,users.first_name,books.hold,books.available from books books,users users where books.deleted=0 and books.user=users.rid"+str); 
			while (rs.next())
			{
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookISBN(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setBookAuthor(rs.getString(4));
				book.setBookEdition(rs.getString(5));
				book.setBookPublisher(rs.getString(6));
				book.setBookDescription(rs.getString(7));
				book.setBookAvailableFrom(rs.getDate(8));
				book.setBookAvailableTo(rs.getDate(9));
				book.setBookOwner(rs.getString(10));
				book.setBookHold(rs.getInt(11));
				book.setBookAvailable(rs.getInt(12));
				books.add(book);
			} 
			return books;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return books;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}

	@Override
	public Boolean insertBook(Book book) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "insert into books(isbn ,name,author, edition,publisher,"
					+ "description,availablefrom,availableto,user) values('"+
					book.getBookISBN()+"','"+book.getBookName()+"','"+
					book.getBookAuthor()+"','"+book.getBookEdition()+"','"+
					book.getBookPublisher()+"','"+book.getBookDescription()+"','"+
					date.format(book.getBookAvailableFrom())+"','"+date.format(book.getBookAvailableTo())+"',"+
					book.getBookOwner()+")";
			stmt.executeUpdate(sql);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public ArrayList<Book> getMyBooks(String username) throws SQLException
	{
		Connection connection = null;
		Statement stmt = null;
		ArrayList<Book> books = new ArrayList<Book>();
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select books.id,books.isbn,books.name,books.author,books.edition,books.publisher,books.description,books.availablefrom,books.availableto,books.available from books books where books.deleted=0 and user = '"+username+"'"); 
			while (rs.next())
			{
				Book book = new Book();
				book.setBookId(rs.getInt(1));
				book.setBookISBN(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setBookAuthor(rs.getString(4));
				book.setBookEdition(rs.getString(5));
				book.setBookPublisher(rs.getString(6));
				book.setBookDescription(rs.getString(7));
				book.setBookAvailableFrom(rs.getDate(8));
				book.setBookAvailableTo(rs.getDate(9));
				book.setBookAvailable(rs.getInt(10));
				books.add(book);
			} 
			return books;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return books;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public int deleteBook(String id) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			String checkSQL = "select deleted from books where id ="+id;
			ResultSet rs=stmt.executeQuery(checkSQL); 
			while (rs.next())
			{
				int check = rs.getInt(1);
				if(check == 1) {
					return 0;
				}
			}
			String deleteSQL = "update books set deleted=1 where id = ?";
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,Integer.parseInt(id));;
			int result = preparedStatement.executeUpdate();
			return result;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return 2;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public Book getBook(String id) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		Book book = null;
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from books where id = "+id);
			book = new Book();
			while (rs.next())
			{
				book.setBookId(rs.getInt(1));
				book.setBookISBN(rs.getString(2));
				book.setBookName(rs.getString(3));
				book.setBookAuthor(rs.getString(4));
				book.setBookEdition(rs.getString(5));
				book.setBookPublisher(rs.getString(6));
				book.setBookDescription(rs.getString(7));
				book.setBookAvailableFrom(rs.getDate(8));
				book.setBookAvailableTo(rs.getDate(9));
			} 
			return book;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return book;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public int updateBook(Book book) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "update books set isbn ='"+
					book.getBookISBN()+"', name ='"+book.getBookName()+"',author='"+
					book.getBookAuthor()+"',edition='"+book.getBookEdition()+"',publisher='"+
					book.getBookPublisher()+"',description='"+book.getBookDescription()+"',availablefrom='"+
					date.format(book.getBookAvailableFrom())+"',availableto='"+date.format(book.getBookAvailableTo())+"' where id="+book.getBookId();
			int result = stmt.executeUpdate(sql);
			return result;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return 2;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public boolean request(String bookId, String userId) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();
			DateFormat dateFormat  = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String sql = "insert into requests(user, book, request_date) "+
					"values('"+
					userId+"','"+bookId+"','"+
					dateFormat.format(date)+"'"+")";
			stmt.executeUpdate(sql);
			stmt.executeUpdate("update books set hold=1 where id = "+bookId);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}

	@Override
	public ArrayList<Book> requestForApproval(String userId) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ArrayList<Book> books = null;
		try {
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();
			books = new ArrayList<Book>();
			ResultSet rs=stmt.executeQuery("select books.isbn, books.id, books.name, users.first_name, users.email, requests.id, requests.request_date, requests.reject_accept, requests.withdraw, requests.returned from users users, requests requests,books books where requests.book = books.id and requests.user=users.rid and users.rid != "+userId+" order by requests.id desc"); 
			while (rs.next())
			{
				Book book = new Book();
				book.setBookISBN(rs.getString(1));
				book.setBookId(rs.getInt(2));
				book.setBookName(rs.getString(3));
				book.setBookOwner(rs.getString(4));
				book.setBookDescription(rs.getString(5));
				book.setRequestId(rs.getString(6));
				book.setRequestDate(rs.getDate(7));
				book.setReject_accept(rs.getInt(8));
				book.setWithdraw(rs.getInt(9));
				book.setReturned(rs.getInt(10));
				books.add(book);
			} 
			return books;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return books;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public ArrayList<Book> myRequestApprovalStatus(String userId) throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ArrayList<Book> books = null;
		try {
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();
			books = new ArrayList<Book>();
			ResultSet rs=stmt.executeQuery("select books.isbn, books.id, books.name, users.first_name, requests.id, requests.request_date, requests.reject_accept,requests.withdraw,requests.returned,users.email  from users users, requests requests,books books where requests.book = books.id and books.user=users.rid and requests.user = "+userId+" order by requests.id desc"); 
			while (rs.next())
			{
				Book book = new Book();
				book.setBookISBN(rs.getString(1));
				book.setBookId(rs.getInt(2));
				book.setBookName(rs.getString(3));
				book.setBookOwner(rs.getString(4));
				book.setRequestId(rs.getString(5));
				book.setRequestDate(rs.getDate(6));
				book.setReject_accept(rs.getInt(7));
				book.setWithdraw(rs.getInt(8));
				book.setReturned(rs.getInt(9));
				book.setBookDescription(rs.getString(10));
				books.add(book);
			} 
			return books;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return books;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public boolean approveRequest(String requstId, String bookId) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			String approveSQL = "update Requests set reject_accept=1 where id = ?";
			preparedStatement = connection.prepareStatement(approveSQL);
			preparedStatement.setInt(1,Integer.parseInt(requstId));;
			preparedStatement.executeUpdate();
			stmt=connection.createStatement();  
			stmt.executeUpdate("update books set hold=0,available=0,availablefrom=null,availableto=null where id = "+bookId);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public boolean rejectRequest(String requstId, String bookId) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			String approveSQL = "update Requests set reject_accept=0 where id = ?";
			preparedStatement = connection.prepareStatement(approveSQL);
			preparedStatement.setInt(1,Integer.parseInt(requstId));;
			preparedStatement.executeUpdate();
			stmt=connection.createStatement();  
			stmt.executeUpdate("update books set hold=0 where id = "+bookId);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public boolean returnedRequest(String requstId, String bookId) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			String approveSQL = "update Requests set returned=1 where id = ?";
			preparedStatement = connection.prepareStatement(approveSQL);
			preparedStatement.setInt(1,Integer.parseInt(requstId));;
			preparedStatement.executeUpdate();
			stmt=connection.createStatement();  
			stmt.executeUpdate("update books set available=1 where id = "+bookId);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public boolean withdrawRequest(String requstId, String bookId) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			String approveSQL = "update Requests set withdraw=1 where id = ?";
			preparedStatement = connection.prepareStatement(approveSQL);
			preparedStatement.setInt(1,Integer.parseInt(requstId));;
			preparedStatement.executeUpdate();
			stmt=connection.createStatement();  
			stmt.executeUpdate("update books set hold=0 where id = "+bookId);
			return true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return false;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public User myAccount(String id) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		user = new User();
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from users where rid = "+id+";"); 
			while (rs.next())
			{
				user.setUsername(rs.getInt(1));
				user.setPassword(rs.getString(2));
				user.setFirst_name(rs.getString(3));
				user.setLast_name(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setMajor(rs.getString(6));
				user.setCollege(rs.getString(7));
				user.setDept(rs.getString(8));
			} 
			return user;
		}
		catch(Exception e)
		{ 
			return user;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
	
	@Override
	public int updatePassword(String id,String password) throws SQLException 
	{
		Connection connection = null;
		Statement stmt = null;
		PreparedStatement preparedStatement = null;
		try
		{
			connection = new DBConnection().getConnection();
			stmt=connection.createStatement();  
			String updatePasswordSQL = "update users set password='"+password+"' where rid = "+id;
			preparedStatement = connection.prepareStatement(updatePasswordSQL);
			int result = preparedStatement.executeUpdate();
			return result;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			return 2;
		}
		finally
		{
			if(stmt != null)
				stmt.close();
			if(connection != null)
				connection.close(); 
		}
	}
}
