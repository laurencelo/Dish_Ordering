package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StaffDao staffDao = new StaffDaoImpl();
		
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		String p = staffDao.validateCustomer(pass);
		
		if(submitType.equals("login") && (p!=null && p!="")){
			System.out.println(p);
			request.setAttribute("message", "Login success");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			// p=request.getParameter("password");
			// staffDao.register(p);
			// request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Password doesn't match, please enter correct password!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
