package com.boolendingapplication.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booklendingapplication.dao.BookLendingApplicationDAO;
import com.booklendingapplication.dao.BookLendingApplicationDAOImpl;
import com.booklendingapplication.pojo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() 
    {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
	    String user = (String)request.getParameter("username");
		long username = Long.parseLong(user);
		String password = request.getParameter("password");
		
		BookLendingApplicationDAO BookLendingApplicationDAOObj = new BookLendingApplicationDAOImpl();  
		Boolean check = false;
		String firstName = "";
		String pwd = "";
		User userObj;
		try {
			userObj = BookLendingApplicationDAOObj.checkLogin(username, password);
			pwd = userObj.getPassword();
			firstName = userObj.getFirst_name();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(pwd))
			check = true;
		else
			check = false;
		
		if(check == true)
		{
			session.setAttribute("sessionusername", user);
			session.setAttribute("sfirstname", firstName);
			RequestDispatcher requestDispatcher; 
			requestDispatcher = request.getRequestDispatcher("HomeController");
			requestDispatcher.forward(request, response);
		}
		else
		{	  
			RequestDispatcher requestDispatcher; 
			request.setAttribute("errormsg", "Invalid Details");
			requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
			System.out.println(username+" "+password);
		}
	}

}