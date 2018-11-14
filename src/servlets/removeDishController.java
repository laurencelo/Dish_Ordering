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

@WebServlet("/removeDish")
public class removeDishController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	private ArrayList<Dish> getMenu() {
		return userDaoImpl.getDishList();
	}

	private ArrayList<Dish> dl;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.dl = getMenu();

		// Print Menu
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Remove Dish</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("<div>Choose a dish to remove:</div><br>");
		for (int i = 0; i < dl.size(); i++) {
			out.println("<div>");
			out.println("<form id=\"dishBtnForm\">"
					+ "<input onclick=\"confirmMsg()\" id=\"dishBtn\" type=\"submit\" name=\"dishName\" value=\""
					+ dl.get(i).getDishName() + "\">" + "</form><br>");
//			out.print(
//					"<form action=\"removeDish\" method=\"GET\"><input class=\"addDish\" type=\"submit\" name=\"dishName\" value=\""
//							+ dl.get(i).getDishName() + "\"></form><br>");
			out.println("</div>");
//			out.println(
//					"<script>document.querySelectorAll(\"input.addDish\").forEach((node)=>{node.addEventListener(\"submit\",(event)=>{event.preventDefault();})});document.querySelectorAll(\"form\").forEach((node)=>{node.addEventListener(\"submit\",(event)=>{event.preventDefault();})}) </script>");
			out.println("<script>function confirmMsg() {"
					+ "if(confirm(\"Remove this dish?\")){document.getElementById(\"dishBtnForm\").action=\"removeDish\"}"
					+ "}</script>");
		}
		out.println("<a href=\"welcome.jsp\">return</a>");
		out.println("</body>");

		// Get dish name when user clicks on OK, dishName may be null when entering
		// removeDish page at first time
		String dishName = "";
		if (request.getParameter("dishName") != null) {
			dishName = request.getParameter("dishName");
		}

		// Remove dish by given dish name
		StaffDao staffDao = new StaffDaoImpl();
		for (Dish d : dl) {
			if (dishName != null && dishName.equals(d.getDishName())) {
				dl.remove(d);
				staffDao.removeDish(dishName);
				break;
			}
		}
	}
}
