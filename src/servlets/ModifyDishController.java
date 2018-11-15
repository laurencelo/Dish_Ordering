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

import dao.StaffDao;
import dao.StaffDaoImpl;
import dao.UserDaoImpl;
import model.Dish;

@WebServlet("/modifyDish")
public class ModifyDishController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private ArrayList<Dish> dl;
	
	private void printDishTable(PrintWriter out) {
		
		out.print("<table>");
		out.print("<thead><tr><th>Dish Name</th><th>Inventory</th><th>Price</th><th>Modify</th></tr></thead>");
		out.print("<tbody id=\"dishListTable\">");
		dl.forEach((dish)->{
			out.print("<tr><td><input type=\"text\" value=\""+dish.getDishName()+"\"></input></td><td><input type=\"text\" value=\""+dish.getInventory()+"\"></input></td><td><input type=\"text\" value=\""+dish.getPrice()+"\"></input></td><td><button class=\"modifyButton\">Modify</button></td></tr>");
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
			
			this.dl = userDaoImpl.getDishList();
			HttpSession session=request.getSession(false);
			if (session.getAttribute("userId")==null) {
				out.print("<div>Please Log in first</div>");
			}else {
				printDishTable(out);
			}
			
		}else if (request.getParameterMap().containsKey("modification")) {
			String originalName=request.getParameter("originalName");
			String modifiedName=request.getParameter("modifiedName");
			String modifiedInventory=request.getParameter("modifiedInventory");
			String modifiedPrice=request.getParameter("modifiedPrice");
			System.out.println(originalName);
			System.out.println(modifiedName);
			System.out.println(modifiedInventory);
			System.out.println(modifiedPrice);
			this.dl=this.userDaoImpl.modifyDish(originalName, modifiedName, modifiedInventory, modifiedPrice);
			printDishTable(out);
		}
		

	}
}
