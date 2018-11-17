package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.StaffDao;
import dao.StaffDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Controller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StaffDao staffDao = new StaffDaoImpl();

	public String login(String id, String password) {
		return staffDao.validateCustomer(id, password);
	}

	public LoginController() {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pass = request.getParameter("password");
		String userId = request.getParameter("userId");
		String submitType = request.getParameter("submit");
//		login function

		String p = login(userId, pass);

		if (submitType.equals("login") && (p != null && p != "")) {
//			https://www.javatpoint.com/servlet-http-session-login-and-logout-example
			HttpSession session = request.getSession();
			session.setAttribute("userId", request.getParameter("userId"));
			request.setAttribute("message", "Login success");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else if (submitType.equals("register")) {
			// p=request.getParameter("password");
			// staffDao.register(p);
			// request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "Password doesn't match, please enter correct password!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Please Login</title>");
		out.println("</head>");
		out.println("<body>");
		if (session.getAttribute("userId") == null) {
			out.println("<div>You should login first</div>");
		} else {
			out.println("<div>You have logged in</div>" + session.getAttribute("userId") + "!");
		}
		out.println("</body>");
		out.close();
	}

}
