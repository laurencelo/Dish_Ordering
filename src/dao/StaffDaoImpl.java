package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import db.DbManager;



public class StaffDaoImpl implements StaffDao {

	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
//	@Override
//	public int register(String password) {
//		int status = 0;
//		try{
//			conn = db.getConnection();
//			ps =conn.prepareStatement("insert into customer values(?)");
////			ps.setString(1, c.getUsername());
//			ps.setString(1, password);
////			ps.setString(3, c.getName());
//			status = ps.executeUpdate();
//			conn.close();
//		}catch(Exception e){
//			System.out.println(e);
//		}
//		return status;
//	}

	@Override
	public String validateCustomer(String password) {
		String fetchedPassword = "";
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from user where password=?");
			ps.setString(1, password);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				fetchedPassword = rs.getString(1);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return fetchedPassword;
	}
	
	public int addDish(String dishName, double dishPrice, int dishInventory) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into dish values(?, ?, ?)");
			ps.setString(1, dishName);
			ps.setInt(2, dishInventory);
			ps.setDouble(3, dishPrice);
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
	
	public int removeDish(String dishName) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("DELETE FROM dish WHERE name=(?)");
			ps.setString(1, dishName);
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}
}
