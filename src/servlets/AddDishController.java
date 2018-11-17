package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import model.Dish;
import dao.StaffDao;
import dao.StaffDaoImpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/addDish")
public class AddDishController extends HttpServlet {
	StaffDao staffDao = new StaffDaoImpl();
	private static final long serialVersionUID = 1L;
	
	private void addDish(String dishName,String dishPrice,String dishInventory) {
		Dish dishTmp=new Dish(dishName,Integer.parseInt(dishInventory),Double.parseDouble(dishPrice));
		staffDao.addDish(dishTmp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		String dishName = request.getParameter("dishname");
		int dishInventory = Integer.parseInt(request.getParameter("dishinventory"));
		double dishPrice = Double.valueOf(request.getParameter("dishprice"));
		String submitType = request.getParameter("submit");

		if (submitType.equals("addDish")) {
			this.addDish(dishName, Double.toString(dishPrice), Integer.toString(dishInventory));
		} else {
			request.setAttribute("message", "Password doesn't match, please enter correct password!");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}

	}

}
