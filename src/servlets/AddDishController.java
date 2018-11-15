package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.StaffDao;
import dao.StaffDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/addDish")
public class AddDishController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddDishController() {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StaffDao staffDao = new StaffDaoImpl();

		String dishName = request.getParameter("dishname");
		int dishInventory = Integer.parseInt(request.getParameter("dishinventory"));
		double dishPrice = Double.valueOf(request.getParameter("dishprice"));
		String submitType = request.getParameter("submit");

		if (submitType.equals("addDish")) {
			staffDao.addDish(dishName, dishPrice, dishInventory);
//			request.setAttribute("message", "Add dish success");
//			request.getRequestDispatcher("dish.jsp").forward(request, response);
//			response.sendRedirect("modifyDish.jsp");
		} else {
			request.setAttribute("message", "Password doesn't match, please enter correct password!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
