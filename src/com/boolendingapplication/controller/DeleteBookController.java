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
import javax.servlet.http.HttpSession;

import com.booklendingapplication.dao.BookLendingApplicationDAO;
import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;
import com.booklendingapplication.pojo.Book;

/**
 * Servlet implementation class DeleteBookController
 */
@WebServlet("/DeleteBookController")
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bookId");
		BookLendingApplicationDAO bookLendingApplicationDAO = new BookLendingApplicationDAOImpl();
		int check = -1;
		try {
			check = bookLendingApplicationDAO.deleteBook(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("sessionusername");
		ArrayList<Book> books = null;
		try {
			books = bookLendingApplicationDAO.getMyBooks(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(check == 1) {
			RequestDispatcher requestDispatcher; 
			request.setAttribute("books",books);
			request.setAttribute("msg","Book Deleted");
			requestDispatcher = request.getRequestDispatcher("/myBooks.jsp");
			requestDispatcher.forward(request, response);
		}
		else if(check == 2 || check == -1){
			RequestDispatcher requestDispatcher; 
			request.setAttribute("books",books);
			request.setAttribute("error","Error in deleting book");
			requestDispatcher = request.getRequestDispatcher("/myBooks.jsp");
			requestDispatcher.forward(request, response);
		}
		else{
			request.setAttribute("msg","");
			request.setAttribute("error","");
			response.sendRedirect("myBooks");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
