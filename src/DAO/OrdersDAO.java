package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import JavaBean.Dish;
import JavaBean.Normaluser;
import JavaBean.Orders;
import JavaBean.Restaurant;

public class OrdersDAO {

	private Connection conn;
	private DatabaseManager dbm;
	
	public OrdersDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dataBaseManager;
	}
	
	public void insertOrder(int id, int user_id, int dish_id, double price, 
			String tele_num, String address){
		try {
	        String insert = "INSERT INTO Orders " +
	        				"(id, user_id, dish_id, price, tele_num, address) " +
	        				"VALUES (?, ?, ?, ?, ?, ?)";   
	        
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.setInt(2, user_id);
			pstmt.setInt(3, dish_id);
			pstmt.setDouble(4, price);
			pstmt.setString(5, tele_num);
			pstmt.setString(6, address);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting order", e);
		}		
	}
	
	public void updateOrder(int id, int mark){
		//Orders order = findById(id);
		try {
			String update = "update Orders "
						   +"set mark = ? "
						   +"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, mark);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error updating order", e);
		}		
	}
	
	public int findNextOrderId(){
		try {
			int lastId = 0;
			String qry = "select * from Orders"; 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(qry);
			
			while (rs.next()){
				lastId = Math.max(rs.getInt("id"), lastId);		
			}
			return ++lastId;
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error in orders table", e);
		}
	}
	
	public Collection<Orders> findMyOrder(int ui) {
		try {
			Collection<Orders> orders = new ArrayList<Orders>(); 
			String qry = "select * "
						+"from Orders "
						+"where user_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, ui);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				Normaluser user_id = dbm.checkInfo(rs.getInt("user_id"));
				Dish dish_id = dbm.findDishById(rs.getInt("dish_id"));
				double price = rs.getDouble("price");
				String tele_num = rs.getString("tele_num");
				String address = rs.getString("address");
				int mark = rs.getInt("mark");
				orders.add(new Orders(this, id, user_id, dish_id, price, tele_num, address, mark));
			}
			return orders;
			
			
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding restaurant", e);
		}
	}
	public Orders findById(int i) {
		try {
			String qry = "select * "
						+"from Orders "
						+"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return null;
			
			int id = rs.getInt("id");
			Normaluser user_id = dbm.checkInfo(rs.getInt("user_id"));
			Dish dish_id = dbm.findDishById(rs.getInt("dish_id"));
			double price = rs.getDouble("price");
			String tele_num = rs.getString("tele_num");
			String address = rs.getString("address");
			int mark = rs.getInt("mark");
			return new Orders(this, id, user_id, dish_id, price, tele_num, address, mark);
			
			
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding restaurant", e);
		}
	}

}
