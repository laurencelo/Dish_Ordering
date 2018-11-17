package model;
import java.util.ArrayList;
import model.Dish;
import model.Order;
public class DishList {
	private ArrayList<Dish> list;
	private ArrayList<Dish> removeDish(Dish dish) {
		for (int i=0;i<list.size();i++) {
			if(list.get(i).getDishName()==dish.getDishName()) {
				list.remove(dish);
			};
		}
		return this.getList();
	}
	public void UpdateDishList(DishList dl) {
		this.list=dl.getList();
	} 
	public ArrayList<Dish> getList() {
		return list;
	}
	public void setList(ArrayList<Dish> list) {
		this.list = list;
	};
}
