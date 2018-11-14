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
import dao.StaffDaoImpl;
import model.Order;
import model.DishLineItem;

/**
 * Servlet implementation class serveletdemo
 */
@WebServlet("/cancelOrder")
public class CancelOrderController extends HttpServlet {
	private StaffDaoImpl staffDaoImpl = new StaffDaoImpl();
    private ArrayList<Order> ol;
    private ArrayList<Order> getOrderList(){
        return this.staffDaoImpl.getOrderList();
    };
    private void printOrderDetailTable(PrintWriter out){  	   
    	   this.ol=getOrderList();

    	   out.print("<table><thead><tr><th>Order ID</th><th>Order Total</th><th>Dish Name</th><th>Dish Price</th></tr></thead><tbody id=\"orderTable\">");
           for(int i=0;i<ol.size();i++) {
           	 boolean firstTime=true;
                out.print( "<tr><td rowspan=\""+(ol.get(i).getdLI().size()<1?1:ol.get(i).getdLI().size())+"\">"+ol.get(i).getOrderId()+"<div><button class=\"cancelButton\">cancel</button></div></td><td rowspan="+(ol.get(i).getdLI().size()<1?1:ol.get(i).getdLI().size())+">"+ol.get(i).getTotal()+"</td>"); 
                for(int j=0;j<ol.get(i).getdLI().size();j++) {
               	 out.print((firstTime?"":"<tr>")+"<td>"+ol.get(i).getdLI().get(j).getDishName()+"</td><td>"+ol.get(i).getdLI().get(j).getPrice()+"</td></tr>");
               	 firstTime=false;
                }
           }
           out.print("</tbody></table>");
    }
    
    private void cancelOrder(int orderID) {
    	for(int i=0;i<this.ol.size();i++) {
    		if (this.ol.get(i).getOrderId()==orderID) {
    			this.ol=this.staffDaoImpl.save(ol.get(i));
//    			ol.remove(i);
    			break;
    		}
    	};
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if (request.getParameterMap().containsKey("init")&&request.getParameter("init").equals("true")) {
			System.out.println("inside");
			printOrderDetailTable(out);
            
		} else if (request.getParameterMap().containsKey("orderID")) {
			cancelOrder(Integer.parseInt(request.getParameter("orderID")));
			printOrderDetailTable(out);
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
	}

}