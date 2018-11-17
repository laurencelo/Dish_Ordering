package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.UserDaoImpl;
import model.Dish;

@WebServlet("/modifyDish")
public class ModifyDishController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private ArrayList<Dish> dl;
	private ArrayList<Dish> getDishList(){
		 return userDaoImpl.getDishList().getList();
	}

	private ArrayList<Dish> modifyDish(String originalName, String modifiedName, String modifiedInventory,
			String modifiedPrice) {
		Dish oldDish = new Dish(originalName, 0, 0);
		Dish newDish = new Dish(modifiedName, Integer.parseInt(modifiedInventory), Double.parseDouble(modifiedPrice));
		return this.userDaoImpl.modifyDish(oldDish, newDish);
	}

	private void printDishTable(PrintWriter out) {

		out.print("<table is-bordered is-striped is-narrow is-hoverable is-fullwidth>");
		out.print("<thead><tr><th>Dish Name</th><th>Inventory</th><th>Price</th><th>Modify</th></tr></thead>");
		out.print("<tbody id=\"dishListTable\">");
		dl.forEach((dish) -> {
			out.print("<tr><td><input class=\"input is-info\" type=\"text\" value=\"" + dish.getDishName()
					+ "\"></input></td><td><input class=\"input is-info\" type=\"number\" value=\"" + dish.getInventory()
					+ "\"></input></td><td><input class=\"input is-info\" type=\"number\" value=\"" + dish.getPrice()
					+ "\"></input></td><td><button class=\"modifyButton button is-danger is-small is-outlined\">Modify</button></td></tr>");
		});
		out.print("</tbody>");
		out.print("</table>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();

		if (request.getParameterMap().containsKey("init")) {

			this.dl = this.getDishList();
			HttpSession session = request.getSession(false);
			if (session.getAttribute("userId") == null) {
				out.print("<div>Please Log in first</div>");
			} else {
				printDishTable(out);
			}

		} else if (request.getParameterMap().containsKey("modification")) {
			String originalName = request.getParameter("originalName");
			String modifiedName = request.getParameter("modifiedName");
			String modifiedInventory = request.getParameter("modifiedInventory");
			String modifiedPrice = request.getParameter("modifiedPrice");
			this.dl = this.modifyDish(originalName, modifiedName, modifiedInventory, modifiedPrice);
			printDishTable(out);
		}

	}
}
