package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DbManager;
import model.Order;
import java.util.ArrayList;

import model.Order;
import model.Dish;
import model.DishLineItem;
import model.OrderList;
import model.User;

public class StaffDaoImpl implements StaffDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();

	@Override
	public String validateCustomer(String userId, String password) {
		User user = new User(Integer.parseInt(userId), password);
		String fetchedPassword = "";
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from user where userID=? and password=?");
			ps.setString(1, Integer.toString(user.getUserId()));
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fetchedPassword = rs.getString(2);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return fetchedPassword;
	}

	public int addDish(Dish dish) {
		String dishName = dish.getDishName();
		double dishPrice = dish.getPrice();
		int dishInventory = dish.getInventory();
		int status = 0;
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("insert into dish values(?, ?, ?)");
			ps.setString(1, dishName);
			ps.setInt(2, dishInventory);
			ps.setDouble(3, dishPrice);
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public int removeDish(Dish dish) {
		int status = 0;
		String dishName = dish.getDishName();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("DELETE FROM dish WHERE name=(?)");
			ps.setString(1, dishName);
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public OrderList getOrderList() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("select * from ordertotal");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				ArrayList<DishLineItem> dLI = new ArrayList<>();
				String orderID = rs.getString(1);
				String total = rs.getString(2);
				ps = conn.prepareStatement("select dishname, dishprice from orderdish where orderID=?");
				ps.setString(1, orderID);
				ResultSet innerRs = ps.executeQuery();
				while (innerRs.next()) {
					dLI.add(new DishLineItem(innerRs.getString(1), Double.parseDouble(innerRs.getString(2))));
				}
				order.setOrderId(Integer.parseInt(orderID));
				order.setTotal(Double.parseDouble(total));
				order.setdLI(dLI);
				orders.add(order);
			}
			;
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		OrderList ol = new OrderList();
		ol.setList(orders);
		return ol;
	}

	public OrderList cancelOrder(Order order, OrderList ol, int index) {
		ol.UpdateOrderList(this.save(ol.getList().get(index)));
		return ol;
	}

//	if nothing is deleted, it will returns null
	public OrderList save(Order order) {
		int status = 0;
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement("DELETE FROM ordertotal WHERE orderID=(?)");
			ps.setString(1, Integer.toString(order.getOrderId()));
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status == 0 ? null : getOrderList();
	}
}
