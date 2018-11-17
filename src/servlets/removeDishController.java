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
import model.DishList;

@WebServlet("/removeDish")
public class removeDishController extends HttpServlet {
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	private DishList dl;
	StaffDao staffDao = new StaffDaoImpl();

	private DishList getMenu() {
		return userDaoImpl.getDishList();
	}

	private void removeDish(String dishName) {
		Dish tmpDish = new Dish(dishName, 0, 0);
		this.staffDao.removeDish(tmpDish);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		this.dl = getMenu();
		String dishName = "";

		if (request.getParameterMap().containsKey("dishName")) {
			dishName = request.getParameter("dishName");
			for (Dish d : dl.getList()) {
				if (dishName != null && dishName.equals(d.getDishName())) {
					this.removeDish(dishName);
					this.dl.UpdateDishList(this.getMenu()); 
					break;
				}
			}
		} else if (request.getParameterMap().containsKey("init")) {
			this.dl.getList().forEach((dish) -> {
				out.print("<button class=\"dishBtn button is-danger is-medium is-outlined \">" + dish.getDishName() + "</button><br><br>");
			});
		}

	}
}
