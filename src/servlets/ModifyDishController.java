package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StaffDao;
import dao.StaffDaoImpl;
import dao.UserDaoImpl;
import model.Dish;

@WebServlet("/modifyDish")
public class ModifyDishController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	private ArrayList<Dish> getMenu() {
		return userDaoImpl.getDishList();
	}

	private ArrayList<Dish> dl;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.dl = getMenu();
		PrintWriter out = response.getWriter();
		String dishname = request.getParameter("dname");
		String dishprice = request.getParameter("dprice");
		String dishinventory = request.getParameter("dInventory");
		System.out.println(request.getParameter("dname"));
		
//		out.print("<tr><td>" + dishname + "</td><td>" + dishprice + "</td><td>" + dishinventory + "</td></tr>");
		request.setAttribute("dname", "111111111");
		request.setAttribute("dprice", dishprice);
		request.setAttribute("dinventory", dishinventory);
		request.getRequestDispatcher("modifyDish.jsp").forward(request, response);
//		if (request.getParameterMap().containsKey("addDish")&&request.getParameter("addDish").equals("true")) {
//			for (Dish d : dl) {
//				if (request.getParameter("dishName").equals(d.getDishName())) {
//					this.order.putDishLineItem(d.getLineItem());
//					DishLineItem temp = this.order.getdLI().get(this.order.getdLI().size() - 1);
//					out.print("<tr><td>" + temp.getDishName() + "</td><td>" + temp.getPrice() + "</td></tr>");
//				}
//			}
//		} else if (request.getParameterMap().containsKey("swipeCreditCard")&&request.getParameter("swipeCreditCard").equals("true")){
//						out.print(this.userDaoImpl.saveOrder(this.order));
//			this.order = new Order();
//		}

	}
}
