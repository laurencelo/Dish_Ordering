package dao;

import model.Dish;
import java.util.*;

public interface UserDao {
	public ArrayList<Dish> getDishList();
	public void save();
}
