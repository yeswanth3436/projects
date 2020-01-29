import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Request() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String a1=request.getParameter("id");
		String a2=request.getParameter("tname");
		String a3=request.getParameter("event");
				
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Reddy");
        if(con!=null) {
        	out.println("connected....");
        }
        out.println("connection successful");
        
        PreparedStatement pstmt=con.prepareStatement("insert into Request(id,name,reason) values(?,?,?)");
        pstmt.setString(1, a1);
        pstmt.setString(2, a2);
        pstmt.setString(3, a3);
        pstmt.executeUpdate();
        out.println("<h1>Sucessfully sent to the leader</h1>");
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
