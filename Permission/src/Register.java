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

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Register() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String a1=request.getParameter("id");
		String a2=request.getParameter("fname");
		String a3=request.getParameter("pass");
				
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Reddy");
        if(con!=null) {
        	out.println("connected....");
        }
        out.println("connection successful");
        
        PreparedStatement pstmt=con.prepareStatement("insert into employee(id,username,password) values(?,?,?)");
        pstmt.setString(1, a1);
        pstmt.setString(2, a2);
        pstmt.setString(3, a3);
        pstmt.executeUpdate();
        RequestDispatcher rd=request.getRequestDispatcher("Sucess.html");
		rd.forward(request,response);
		}
		catch(Exception e)
		{		
			out.println(e);  
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
