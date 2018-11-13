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
		double sum = 0;
		for (int i = 0; i < this.dLI.size(); i++) {
			sum += this.dLI.get(i).getPrice();
		}
		this.total=sum;
		return this.total;
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
