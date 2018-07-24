package com.boolendingapplication.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booklendingapplication.dao.BookLendingApplicationDAO;
import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;
import com.booklendingapplication.pojo.Book;

/**
 * Servlet implementation class EditBookController
 */
@WebServlet("/EditBookController")
public class EditBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		BookLendingApplicationDAO bookLendingApplicationDAO = new BookLendingApplicationDAOImpl();
		Book book = null;
		try {
			book = bookLendingApplicationDAO.getBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher; 
		request.setAttribute("book",book);
		requestDispatcher = request.getRequestDispatcher("/editBook.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
