package dao;

import java.util.ArrayList;

import db.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.*;
import model.Dish;

public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	public ArrayList<Dish> getDishList() {
		ArrayList<Dish> dishList = new ArrayList<Dish>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from dish");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dish dish = new Dish(rs.getString(1), Integer.parseInt(rs.getString(2)), Double.parseDouble(rs.getString(3)));
				dishList.add(dish);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return dishList;
	}

	public void save() {
	}
}
