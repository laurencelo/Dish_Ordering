package model;
public class Dish {
	private String dishName;
	private int inventory;
	private double price;
	
	public Dish(String dishName, int inventory, double price) {
		this.dishName = dishName;
		this.inventory = inventory;
		this.price = price;
	}

	public String getDishName() {
		return dishName;
	}
	public int getInventory() {
		return inventory;
	}
	public double getPrice() {
		return price;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public DishLineItem getLineItem() {
		DishLineItem dLI = new DishLineItem();
		dLI.setDishName(this.dishName);
		dLI.setPrice(this.price);
		return dLI;
	}
////	return a dish object
//	public Dish display() {
//		return new Dish( this.dishName, this.inventory, this.price);
	}
