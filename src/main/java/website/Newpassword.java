package website;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/Newpassword")
public class Newpassword extends HttpServlet

{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String email=request.getParameter("0");
		String otp=request.getParameter("1");
		String newpasswordd=request.getParameter("2");
		
		PrintWriter printWriter = response.getWriter();
		
		if(otp.equals("1234")) {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
//				String url = "jdbc:mysql://localhost:3306/inter";
//							
//				String user = "root";
//	
//				String password = "Siraj@mysql12345";
				
				String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12579586";

				String user = "sql12579586";
				
				String password = "mk4RIexj6U";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			Statement stmt=connection.createStatement();
			
			String s="update cust4 set passwordd='"+newpasswordd+"'where email='"+email+"'";

			stmt.execute(s);
			
			String i="select passwordd from cust4 where email='"+email+"'";
			
			ResultSet rs=stmt.executeQuery(i);
			
			if(rs.next())
			{					
				RequestDispatcher rd=request.getRequestDispatcher("Homehtml.html");
				rd.forward(request,response);
			}
		else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Enterotptryhtml.html");
				rd.forward(request,response);
			}
				connection.close();
			}
			
		catch (SQLException e) 
			{
				printWriter.println("sahi pakade ho bhai");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		}
		else if(otp.length()<=0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Enterotptryhtml.html");
			rd.forward(request,response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("Enterotptryhtml.html");
			rd.forward(request,response);
		}
		
		
	}
	
}
