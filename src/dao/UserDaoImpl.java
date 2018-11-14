package dao;

import java.util.ArrayList;

import db.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Dish;
import model.Order;

public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ps;
	int queryPosition;
	DbManager db = new DbManager();

	public ArrayList<Dish> getDishList() {
		ArrayList<Dish> dishList = new ArrayList<Dish>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from dish");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Dish dish = new Dish(rs.getString(1), Integer.parseInt(rs.getString(2)),
						Double.parseDouble(rs.getString(3)));
				dishList.add(dish);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return dishList;
	}

	public String saveOrder(Order order) {
		int[] status = new int[0];
		try {
			Statement stmt = conn.createStatement();
			this.queryPosition = 2;
			conn = db.getConnection();
			conn.setAutoCommit(false);
			stmt.addBatch("INSERT INTO orderTotal (total) VALUES (" + order.getTotal() + ");");
			stmt.addBatch("SET @orderID := LAST_INSERT_ID();");
			order.getdLI().forEach((dish) -> {
				try {
					stmt.addBatch("INSERT INTO orderDish (orderID, dishname, dishprice) VALUES (@orderID,\""
							+ dish.getDishName() + "\"," + dish.getPrice() + ");");
				} catch (SQLException e) {
					e.printStackTrace();
				}

			});

			status = stmt.executeBatch();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		for(int s:status) {
			if (s==Statement.EXECUTE_FAILED) {
				return "Data base error: Failed to save your order!";
			}
		}
		return "Saving order success!";
	}
}
