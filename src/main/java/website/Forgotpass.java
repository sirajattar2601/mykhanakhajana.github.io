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

@WebServlet(value="/Forgotpass")
public class Forgotpass extends HttpServlet

{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailorcontactnumber=request.getParameter("1");
		
		PrintWriter printWriter = response.getWriter();
		
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
			
			String s="select email from cust4 where email='"+emailorcontactnumber+"' or contactnumber='"+emailorcontactnumber+"'";
					
			ResultSet rs=stmt.executeQuery(s);
		
			if(emailorcontactnumber.length()<=0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("Forgotpasstryhtml.html");
				rd.forward(request,response);
			}
			
			else if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("Enterotphtml.html");
				rd.forward(request,response);
			}
		else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Signupnotaccounthtml.html");
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
	
}
