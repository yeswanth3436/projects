
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class prequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
				
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Reddy");
        if(con!=null) {
        	out.println("connected....");
        }
      
        String q="select id,name,reason from request";
        	Statement st=con.createStatement();
        	ResultSet rs=st.executeQuery(q);
        	out.println("<html><body><table><tr><th>ID</th>&nbsp;&nbsp;&nbsp;<th>NAME</th><th>REASON</th></tr></table></body></html>");
        	while(rs.next())
        	{
        		out.println(rs.getString(1));
        		out.println(rs.getString(2));
        		out.println(rs.getString(3));
        	}
        	
		
        out.println("<>");
		}
		catch(Exception e)
		{		
			out.println("<h1>You have already sent the request</h1>");  
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
