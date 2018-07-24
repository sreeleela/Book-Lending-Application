package com.boolendingapplication.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booklendingapplication.dao.BookLendingApplicationDAO;
import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;

/**
 * Servlet implementation class WithdrawRequestController
 */
@WebServlet("/WithdrawRequestController")
public class WithdrawRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("sessionusername");
		String requestId = request.getParameter("requestId");
		String bookId = request.getParameter("bookId");
		BookLendingApplicationDAO bookLendingApplicationDAO = new BookLendingApplicationDAOImpl();
		boolean check = false;
		try {
			check = bookLendingApplicationDAO.withdrawRequest(requestId,bookId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(check == true) {
			response.setContentType("text/plain");
			response.getWriter().write("Request Withdrawn");
		}
		else if(check == false){
			response.setContentType("text/plain");
			response.getWriter().write("Error in Withdrawing Request");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
