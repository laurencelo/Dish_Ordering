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
import java.util.HashMap;
import java.util.HashSet;

public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ps;
	int queryPosition;
	DbManager db = new DbManager();
	HashMap<String, Integer> orderStatistics = new HashMap<>();

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
		HashSet<String> outOfOrder = new HashSet<>();
		int[] status = new int[0];
//check dishes in this order against inventory
		orderStatistics.clear();
		order.getdLI().forEach((dish) -> {
			if (orderStatistics.size() > 0) {
				if (orderStatistics.containsKey(dish.getDishName())) {
					orderStatistics.put(dish.getDishName(), orderStatistics.get(dish.getDishName()) + 1);
					System.out.println(orderStatistics.get(dish.getDishName()));
				} else {
					orderStatistics.put(dish.getDishName(), 1);
					System.out.println(orderStatistics.get(dish.getDishName()));
				}
			} else {
				orderStatistics.put(dish.getDishName(), 1);
				System.out.println(orderStatistics.get(dish.getDishName()));
			}
		});
		ArrayList<Dish> dl = this.getDishList();
		orderStatistics.keySet().forEach((dish) -> {
			dl.forEach((fetched) -> {
				if (fetched.getInventory() < orderStatistics.get(dish)) {
					outOfOrder.add(dish);
				}
			});
		});
		if (outOfOrder.size() == 0) {
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
				order.getdLI().forEach((dish) -> {

				});
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			for (int s : status) {
				if (s == Statement.EXECUTE_FAILED) {
					return "Data base error: Failed to save your order!";
				}
			}
			return "Saving order success!";
		} else {
			StringBuilder t=new StringBuilder();
			t.append("Cannot place order, because following dish(es) will be out of stock: ");
			outOfOrder.forEach((dish)->{
				t.append(dish+" ");
			});
			return t.toString();
		}

	}

//	public ArrayList<Dish> modifyDish(String originalName, String modifiedName, String modifiedInventory,
//			String modifiedPrice) {
	public ArrayList<Dish> modifyDish(Dish oldDish, Dish newDish) {
		int status = 0;
		try {

			conn = db.getConnection();
			ps = conn.prepareStatement("UPDATE dish SET name=?, inventory=?, price=? where name=?");
			
			ps.setString(1, newDish.getDishName());
			ps.setInt(2, newDish.getInventory());
			ps.setDouble(3, newDish.getPrice());
			ps.setString(4, oldDish.getDishName());
			status = ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status == 0 ? null : getDishList();
	}
}
