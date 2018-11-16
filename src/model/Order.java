package model;

import java.util.*;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class Order {
	private int orderId;
	private double total;
	private ArrayList<DishLineItem> dLI;
	
	public Order() {
		this.dLI= new ArrayList<DishLineItem>();
	}
	public Order(int orderId,double total, ArrayList<DishLineItem> dLI) {
		this.orderId=orderId;
		this.total=total;
		this.dLI=dLI;
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
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		for (int i = 0; i < this.dLI.size(); i++) {
			sum += this.dLI.get(i).getPrice();
		}
		this.total=sum;
		return Double.parseDouble(df.format(this.total));
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
