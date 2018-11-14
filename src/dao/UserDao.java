package dao;

import model.Dish;
import java.util.*;
import model.Order;

public interface UserDao {
	public ArrayList<Dish> getDishList();
	public String saveOrder(Order order);
}
