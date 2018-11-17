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
import model.DishList;

public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ps;
	int queryPosition;
	DbManager db = new DbManager();

	public DishList getDishList() {
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
		DishList dl=new DishList();
		dl.setList(dishList);
		return dl;
	}

	public String saveOrder(Order order) {
		HashMap<String, Integer> orderStatistics = new HashMap<>();
		HashSet<String> outOfOrder = new HashSet<>();
		int[] status = new int[0];
		DishList dl = this.getDishList();
//check dishes in this order against inventory
		order.getdLI().forEach((dish) -> {

				if (orderStatistics.containsKey(dish.getDishName())) {
					orderStatistics.put(dish.getDishName(), orderStatistics.get(dish.getDishName()) + 1);
					
				} else {
					orderStatistics.put(dish.getDishName(), 1);
					
				}

		});
		orderStatistics.keySet().forEach((dish) -> {
			dl.getList().forEach((fetched) -> {
				if (dish.equals(fetched.getDishName())&&fetched.getInventory() < orderStatistics.get(dish)) {
					outOfOrder.add(dish);
				}
			});
		});
//		Dishes in the order will not outnumber inventory
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
//				update inventory after an oder is placed
				orderStatistics.entrySet().forEach((dish) -> {
					dl.getList().forEach((listDish) -> {
						if (listDish.getDishName().equals(dish.getKey())) {
							int newInventory = listDish.getInventory() - dish.getValue();
							try {
								stmt.addBatch("UPDATE dish SET inventory=" + newInventory + " where name=\""
										+ listDish.getDishName() + "\";");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
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
			StringBuilder t = new StringBuilder();
			t.append("Cannot place order, because following dish(es) will be out of stock: ");
			outOfOrder.forEach((dish) -> {
				t.append(dish + " ");
			});
			return t.toString();
		}

	}

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
		return status == 0 ? null : getDishList().getList();
	}
}
