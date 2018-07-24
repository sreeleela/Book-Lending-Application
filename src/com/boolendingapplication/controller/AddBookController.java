package com.boolendingapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booklendingapplication.dao.BookLendingApplicationDAO;
import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;
import com.booklendingapplication.pojo.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Book book = new Book();
		book.setBookISBN(request.getParameter("isbn"));
		book.setBookName(request.getParameter("name"));
		book.setBookAuthor(request.getParameter("author"));
		book.setBookPublisher(request.getParameter("publisher"));
		book.setBookEdition(request.getParameter("edition"));
		book.setBookDescription(request.getParameter("description"));
		book.setBookOwner((String) session.getAttribute("sessionusername"));
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		try {
			book.setBookAvailableFrom(date.parse((String) request.getParameter("availableFrom")));
			book.setBookAvailableTo(date.parse((String) request.getParameter("availableTo")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BookLendingApplicationDAO bookLendingApplicationDAO = new BookLendingApplicationDAOImpl();
		boolean check;
		try {
			check = bookLendingApplicationDAO.insertBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check = true) {
			response.setContentType("text/plain");
			response.getWriter().write("Book Added");
		}
		else {
			response.setContentType("text/plain");
			response.getWriter().write("Error in adding book");
		}
	}

}
