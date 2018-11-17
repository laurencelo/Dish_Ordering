package dao;

import model.Dish;
import java.util.*;
import model.Order;
import model.DishList;
public interface UserDao {
	public DishList getDishList();
	public String saveOrder(Order order);
}
