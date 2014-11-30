package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDAO {
	
	private Connection conn;
	private DatabaseManager dbm;
	
	public UsersDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dataBaseManager;
	}

	public int findNextUserId(){
		try {
			int lastId = 0;
			String qry = "select * from Users"; 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(qry);
			
			while (rs.next()){
				lastId = Math.max(rs.getInt("id"), lastId);		
			}
			return ++lastId;
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error in user table", e);
		}
	}
	
	public void signup(int id) {
		try {
	        String insert = "INSERT INTO Users VALUES (?)";   
	        
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error signup in user", e);
		}		
	}
	
}
