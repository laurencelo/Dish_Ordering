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
import model.DishLineItem;

/**
 * Servlet implementation class serveletdemo
 */
@WebServlet("/createOrder")
public class CreateOrderController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	Order order = new Order();
	private ArrayList<Dish> dl;

	private ArrayList<Dish> getMenu() {
		return userDaoImpl.getDishList();
	}

	private double getTotal() {
		return this.order.getTotal();
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
		if (request.getParameter("addDish").equals("true")) {
			for (Dish d : dl) {
				if (request.getParameter("dishName").equals(d.getDishName())) {
					this.order.putDishLineItem(d.getLineItem());
					DishLineItem temp = this.order.getdLI().get(this.order.getdLI().size() - 1);
					out.print("<tr><td>" + temp.getDishName() + "</td><td>" + temp.getPrice() + "</td></tr>");
				}
			}
		}

//		for (int i = 0; i < this.order.getdLI().size(); i++) {
//			String t1 = this.order.getdLI().get(i).getDishName();
//			double t2 = this.order.getdLI().get(i).getPrice();
//		}

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
		out.print(getTotal());
		this.order = new Order();
	}

}
