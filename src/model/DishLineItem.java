package model;

public class DishLineItem {

	String dishName;
	double price;
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSubtotal() {
		return getPrice();
	}
	public DishLineItem(String dishName, double price){
		this.dishName=dishName;
		this.price=price;
	}
	public DishLineItem(){};
}
