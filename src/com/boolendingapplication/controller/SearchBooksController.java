package com.boolendingapplication.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;
import com.booklendingapplication.pojo.Book;

/**
 * Servlet implementation class SearchBooksController
 */
@WebServlet("/SearchBooksController")
public class SearchBooksController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBooksController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookLendingApplicationDAOImpl bookLendingApplicationDAOImpl = new BookLendingApplicationDAOImpl();
		String name=request.getParameter("name");
		String author = request.getParameter("author");
		String  owner = request.getParameter("owner");
		String  availableFrom = request.getParameter("availableFrom");
		String  availableTo = request.getParameter("availableTo");
		
		ArrayList<Book> books = null;
		try {
			books = bookLendingApplicationDAOImpl.searchBooks(name,author,owner,availableFrom,availableTo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher; 
		request.setAttribute("name",name);
		request.setAttribute("author",author);
		request.setAttribute("firstName",owner);
		request.setAttribute("availableFrom",availableFrom);
		request.setAttribute("availableTo",availableTo);
		
		request.setAttribute("books",books);
		requestDispatcher = request.getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
