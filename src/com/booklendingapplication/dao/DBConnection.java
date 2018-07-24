package com.booklendingapplication.dao;

import java.sql.*;

public class DBConnection 
{
	public Connection getConnection() throws SQLException
	{
		Connection connection=null;
	    try
	    {  
	    	Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
	    	connection=DriverManager.getConnection("jdbc:mysql://localhost/BookLendingApplication?" +
	                    "user=root&password=admin");
	    	return connection;
	    }
	    catch(Exception e)
	    { 
	    	if(connection != null)
	    	{
	    		connection.close();
	    	}
	    	return null;	
	    }
	}
}
