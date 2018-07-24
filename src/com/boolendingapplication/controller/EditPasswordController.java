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
 * Servlet implementation class EditPasswordController
 */
@WebServlet("/EditPasswordController")
public class EditPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("sessionusername");
		String password = (String) request.getParameter("new");
		BookLendingApplicationDAO bookLendingApplicationDAO = new BookLendingApplicationDAOImpl();
		int check = 0;
		try {
			check = bookLendingApplicationDAO.updatePassword(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check==1) {
			RequestDispatcher requestDispatcher; 
			request.setAttribute("msg","Updated password");
			requestDispatcher = request.getRequestDispatcher("/myAccount");
			requestDispatcher.forward(request, response);
		}
		else {
			RequestDispatcher requestDispatcher; 
			request.setAttribute("error","Error in updating password");
			requestDispatcher = request.getRequestDispatcher("/myAccount");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
