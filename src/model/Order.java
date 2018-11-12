package model;

import java.util.*;

public class Order {
	int orderId;
	double total;
	ArrayList<DishLineItem> dLI;
	
	public Order() {
		this.dLI= new ArrayList<DishLineItem>();
	}

	public void putDishLineItem(DishLineItem dLI) {
		this.dLI.add(dLI);
	}
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<DishLineItem> getdLI() {
		return dLI;
	}

	public void setdLI(ArrayList<DishLineItem> dLI) {
		this.dLI = dLI;
	}

}
