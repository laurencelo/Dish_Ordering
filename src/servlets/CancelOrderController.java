package servlets;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
import java.io.PrintWriter;
import dao.StaffDaoImpl;
import model.Order;
import model.DishLineItem;
import model.OrderList;
/**
 * Servlet implementation class serveletdemo
 */
@WebServlet("/cancelOrder")
public class CancelOrderController extends HttpServlet {
	private StaffDaoImpl staffDaoImpl = new StaffDaoImpl();
    private OrderList ol;
    private OrderList getOrderList(){
        return this.staffDaoImpl.getOrderList();
    };
    private void printOrderDetailTable(PrintWriter out){  	   
    	   this.ol=getOrderList();
    	   out.print("<table class=\"table is-bordered is-striped is-narrow is-hoverable is-fullwidth \"><thead><tr><th>Order ID</th><th>Order Total</th><th>Dish Name</th><th>Dish Price</th></tr></thead><tbody id=\"orderTable\">");
           for(int i=0;i<ol.getList().size();i++) {
           	 boolean firstTime=true;
                out.print( "<tr><td rowspan=\""+(ol.getList().get(i).getdLI().size()<1?1:ol.getList().get(i).getdLI().size())+"\">"+ol.getList().get(i).getOrderId()+"<div><button class=\"cancelButton button is-danger is-small is-outlined \">cancel</button></div></td><td rowspan="+(ol.getList().get(i).getdLI().size()<1?1:ol.getList().get(i).getdLI().size())+">"+ol.getList().get(i).getTotal()+"</td>"); 
                for(int j=0;j<ol.getList().get(i).getdLI().size();j++) {
               	 out.print((firstTime?"":"<tr>")+"<td>"+ol.getList().get(i).getdLI().get(j).getDishName()+"</td><td>"+ol.getList().get(i).getdLI().get(j).getPrice()+"</td></tr>");
               	 firstTime=false;
                }
           }
           out.print("</tbody></table>");
    }
    
    private void cancelOrder(String orderId) {
    	for(int i=0;i<this.ol.getList().size();i++) {
    		if (ol.getList().get(i).getOrderId()==Integer.parseInt(orderId)) {
    		this.ol=this.staffDaoImpl.cancelOrder(new Order(),this.ol,i);
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
			HttpSession session=request.getSession(false);
			if(session.getAttribute("userId")!=null) {
			printOrderDetailTable(out);
			System.out.println(session.getAttribute("userId"));
			}
			else {
				out.print("<div>Please Login first!</div>");
			}
            
		} else if (request.getParameterMap().containsKey("orderID")) {
			HttpSession session=request.getSession(false);
			if(session!=null) {
			cancelOrder(request.getParameter("orderID"));
			printOrderDetailTable(out);}
			else {
				out.print("<div>Please Login first!</div>");
			}
		}
	}


}