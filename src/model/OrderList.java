package model;
import java.util.ArrayList;
import model.Dish;
import model.Order;
public class OrderList {
	private ArrayList<Order> list;
	private ArrayList<Order> removeDish(Order order) {
		for (int i=0;i<list.size();i++) {
			if(list.get(i).getOrderId()==order.getOrderId()) {
				list.remove(order);
			};
		}
		return this.getList();
	}
	public void UpdateOrderList(OrderList ol) {
		this.list=ol.getList();
	} 
	public ArrayList<Order> getList() {
		return list;
	}
	public void setList(ArrayList<Order> list) {
		this.list = list;
	};

}
