package servlets;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import model.Dish;
import dao.UserDaoImpl;
import model.Order;
import model.DishList;

/**
 * Servlet implementation class serveletdemo
 */
@WebServlet("/createOrder")
public class CreateOrderController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private Order order = new Order();
	private DishList dl;

	private DishList getMenu() {
		return userDaoImpl.getDishList();
	}

	private double getTotal() {
		return this.order.getTotal();
	}
	
	private String checkOut() {
		return this.userDaoImpl.saveOrder(this.order);
	}

	private void setDishLineItem(String dishName, DishList dl) {
		for (Dish d : dl.getList()) {
			if (dishName.equals(d.getDishName())) {
				this.order.putDishLineItem(d.getLineItem());
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.dl = getMenu();
		PrintWriter out = response.getWriter();
		if (request.getParameterMap().containsKey("addDish") && request.getParameter("addDish").equals("true")) {
			this.setDishLineItem(request.getParameter("dishName"), dl);
			this.order.getdLI().forEach((dish) -> {
				out.print("<tr><td>" + dish.getDishName() + "</td><td>$" + dish.getPrice() + "</td></tr>");
			});
		} else if (request.getParameterMap().containsKey("swipeCreditCard")
				&& request.getParameter("swipeCreditCard").equals("true")) {
			out.print(checkOut());
			this.order = new Order();
		} else if (request.getParameterMap().containsKey("resetOrder")
				&& request.getParameter("resetOrder").equals("true")) {
			out.print("");
			this.order = new Order();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		// String dishName = request.getParameter("dishName");
		// System.out.println(dishName);
		PrintWriter out = response.getWriter();
		out.print("$" + Double.toString(getTotal()));
	}

}