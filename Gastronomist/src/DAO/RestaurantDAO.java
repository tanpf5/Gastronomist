package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import JavaBean.Restaurant;

public class RestaurantDAO {

	private Connection conn;
	private DatabaseManager dbm;
	
	public RestaurantDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dbm;
	}
	
	public Restaurant find(int i) {
		try {
			String qry = "select * "
						+"from Restaurant "
						+"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return null;
			
			int id = rs.getInt("id");
			String re_name = rs.getString("re_name");
			String re_te_num = rs.getString("re_te_num");
			
			return new Restaurant(this, id, re_name, re_te_num);
			
			
		} catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding restaurant", e);
		}
	}
	
	public Collection<Restaurant> allRestaurant() {
		try {
			Collection<Restaurant> restaurants = new ArrayList<Restaurant>(); 
			String qry = "select * from Restaurant"; 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(qry);
			
			while (rs.next()){
				int id = rs.getInt("id");
				String re_name = rs.getString("re_name");
				String re_te_num = rs.getString("re_te_num");
				restaurants.add(new Restaurant(this, id, re_name, re_te_num));
			}
			return restaurants;
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error getting all restaurants", e);
		}
	}

}
