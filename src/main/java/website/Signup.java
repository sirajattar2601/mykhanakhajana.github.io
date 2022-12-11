package website;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;



@WebServlet(value="/Signup")
public class Signup extends HttpServlet 

{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		PrintWriter printWriter = resp.getWriter();
		
		String name = req.getParameter("1");
		String email = req.getParameter("2");
		String passwordd = req.getParameter("3");
		String contactnumber = req.getParameter("4");
		String address = req.getParameter("5");
		String city = req.getParameter("6");
		String state = req.getParameter("7");
		String zip = req.getParameter("8");
		
		
		
		if(name.length()>=1 || email.length()>=1 || passwordd.length()>=1 || contactnumber.length()>=1 || address.length()>=1 || city.length()>=1 || state.length()>=1 || zip.length()>=1)
		{
		
		 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			String url = "jdbc:mysql://localhost:3306/inter";
//		
//			String user = "root";
//			
//			String password = "Siraj@mysql12345";
			
			String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12579586";

			String user = "sql12579586";
			
			String password = "mk4RIexj6U";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();
			
			String insert = "insert into cust4 values('"+name+"', '"+email+"', '"+passwordd+"', '"+contactnumber+"', '"+address+"', '"+city+"', '"+state+"', '"+zip+"')";

			statement.execute(insert);		
			
			RequestDispatcher rd=req.getRequestDispatcher("Loginhtml.html");
			
			rd.forward(req,resp);

		} 	
		
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		
			printWriter.println("Something wrong please click back and try again...");
		}
		
		}
		
	else
	{
		RequestDispatcher rd=req.getRequestDispatcher("Signuptryhtml.html");
		
		rd.forward(req,resp);

	}

	}
	
}