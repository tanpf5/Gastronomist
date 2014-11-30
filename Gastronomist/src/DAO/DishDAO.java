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
				int mark = rs.getInt("mark");
				dishes.add(new Dish(this, id, rest_id, di_name, price, times, mark));
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
	        String insert = "INSERT INTO Dish VALUES (?, ?, ?, ?, ?, ?)";   
	        
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.setInt(2, rest_id);
			pstmt.setString(3, di_name);
			pstmt.setDouble(4, price);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			
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
			int mark = rs.getInt("mark");
			return new Dish(this, id, rest_id, di_name, price, times, mark);
			
			
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding restaurant", e);
		}
	}
}