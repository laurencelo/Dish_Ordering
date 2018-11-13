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

	private ArrayList<Dish> getMenu() {
		return userDaoImpl.getDishList();
	}

	private ArrayList<Dish> dl;

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
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Menu</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("<div>Menu</div>");
		for (int i = 0; i < dl.size(); i++) {
			out.println("<div>");
			out.print(dl.get(i).getDishName() + "\t");
			out.print(dl.get(i).getPrice() + "\t");
			out.print(
					"<form action=\"createOrder\" method=\"GET\"><input class=\"addDish\" type=\"submit\" name=\"dishName\" value=\""
							+ dl.get(i).getDishName() + "\"></form>");
			out.println("</div>");
			out.println(
					"<script>document.querySelectorAll(\"input.addDish\").forEach((node)=>{node.addEventListener(\"submit\",(event)=>{event.preventDefault();})});document.querySelectorAll(\"form\").forEach((node)=>{node.addEventListener(\"submit\",(event)=>{event.preventDefault();})}) </script>");
		}
		out.println("</body>");
		
		String dishName = request.getParameter("dishName");
		for (Dish d : dl) {
			if (dishName != null && dishName.equals(d.getDishName())) {
				this.order.putDishLineItem(d.getLineItem());
			}
		}
		out.println("<br>");
		out.println("<div>Order</div>");
		out.println("<div>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Dish name</th><th>Dish price</th>");
		out.print("</tr>");
		for (int i = 0; i < this.order.getdLI().size(); i++) {
			String t1 = this.order.getdLI().get(i).getDishName();
			double t2 = this.order.getdLI().get(i).getPrice();
//			System.out.println(t1 + "\t" + t2);
			out.println("<tr><td>" + t1 + "</td><td>" + t2 + "</td></tr>");

		}
		out.println("</table>");
		out.println("</div>");
		out.print("<button> Submit </button>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String dishName = request.getParameter("dishName");
		System.out.println(dishName);
	}

}
