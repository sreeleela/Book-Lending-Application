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
 * Servlet implementation class HomeController
 */
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookLendingApplicationDAOImpl bookLendingApplicationDAOImpl = new BookLendingApplicationDAOImpl();
		ArrayList<Book> books = null;
		try {
			books = bookLendingApplicationDAOImpl.getBooks();
			//for(int i=0;i<books.size();i++) {
				//System.out.println(books.get(i).getBookName()+"	"+books.get(i).getBookAvailableFrom());
			//}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher; 
		request.setAttribute("books",books);
		requestDispatcher = request.getRequestDispatcher("/home.jsp");
		requestDispatcher.forward(request, response);
	}

}
