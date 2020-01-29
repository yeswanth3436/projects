import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Loginval
 */
public class Loginval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginval() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  String uname = request.getParameter("user");
	        String pw = request.getParameter("pass");

	        if (uname.equals("L123") && pw.equals("ladmin"))
	        {
	            Cookie loginCookie = new Cookie("user",uname);
									//setting cookie to expiry in 1 mins
		    loginCookie.setMaxAge(1*60);
		    response.sendRedirect("Leader.html");
	            return;
	        }
	        else if(uname.equals("M009") && pw.equals("madmin"))
	        {
	        	response.sendRedirect("Manager.html");
	            return;	
	        }
	        else
	        {
	            response.sendRedirect("error.html");
	            return;
	        }
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
