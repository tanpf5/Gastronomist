package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


import JavaBean.Dish;
import JavaBean.Restaurant;

public class DishDAO {

	private Connection conn;
	private DatabaseManager dbm;
	
	public DishDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dataBaseManager;
	}

	public Collection<Dish> findAllDishByRest(int i){
		try {
			Collection<Dish> dishes = new ArrayList<Dish>(); 
			String qry = "select * "
						+"from Dish "
						+"where rest_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry); 
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				int id = rs.getInt("id");
				Restaurant rest_id = dbm.findRestaurant(rs.getInt("rest_id")) ;
				String di_name = rs.getString("di_name");
				double price = rs.getDouble("price");
				int times = rs.getInt("times");
				int mark_times = rs.getInt("mark_times");
				int mark = rs.getInt("mark");
				dishes.add(new Dish(this, id, rest_id, di_name, price, times, mark_times, mark));
			}
			return dishes;
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting all dishes by restaurant", e);
		}		
	}
	
	public void insertDish(int id, int rest_id, String di_name, double price){
		try {
	        String insert = "INSERT INTO Dish VALUES (?, ?, ?, ?, ?, ?, ?)";   
	        
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.setInt(2, rest_id);
			pstmt.setString(3, di_name);
			pstmt.setDouble(4, price);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error inserting dish", e);
		}		
	}
	
	public int findNextDishId(){
		try {
			int lastId = 0;
			String qry = "select * from Dish"; 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(qry);
			
			while (rs.next()){
				lastId = Math.max(rs.getInt("id"), lastId);		
			}
			return ++lastId;
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error in dish table", e);
		}
	}
	
	public boolean checkDuplicatedDishname(String dishname){
		try {
			String qry = "select * "
						+"from Dish "
						+"where di_name = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, dishname);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return false;
			return true;
			
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding dish", e);
		}
	}
	
	public boolean checkDuplicatedDishname(int id, String dishname){
		try {
			String qry = "select * "
						+"from Dish "
						+"where di_name = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, dishname);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if (id != rs.getInt("id")) return true;
			}
			
			return false;
			
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding dish", e);
		}
	}
	
	public void updateDish(int id, int rest_id, String di_name, double price) {
		try {
			String update = "update Dish "
						   +"set di_name = ?, price = ? "
						   +"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, di_name);
			pstmt.setDouble(2, price);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
						
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error updating dish", e);
		}
	}
	
	public void updateDishMark(int id, int mark_times, int mark) {
		try {
			String update = "update Dish "
						   +"set mark_times = ?, mark = ? "
						   +"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, mark_times);
			pstmt.setInt(2, mark);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
						
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error updating dish", e);
		}
	}
	
	public void deleteDish(int id) {
		try {
			String delete = "DELETE from Dish " +
							"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error deleting dish", e);
		}
	}
	
	public Dish findById(int i) {
		try {
			String qry = "select * "
						+"from Dish "
						+"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return null;
			
			int id = rs.getInt("id");
			Restaurant rest_id = dbm.findRestaurant(rs.getInt("rest_id")) ;
			String di_name = rs.getString("di_name");
			double price = rs.getDouble("price");
			int times = rs.getInt("times");
			int mark_times = rs.getInt("mark_times");
			int mark = rs.getInt("mark");
			return new Dish(this, id, rest_id, di_name, price, times, mark_times, mark);
			
			
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding restaurant", e);
		}
	}
	
	public void updateDishTimes(int id, int times) {
		try {
			String update = "update Dish "
						   +"set times = ? "
						   +"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setInt(1, times);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
						
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error updating dish", e);
		}
	}
	
}
