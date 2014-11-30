package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import JavaBean.Normaluser;

public class NormaluserDAO {
	
	private Connection conn;
	private DatabaseManager dbm;

	public NormaluserDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dataBaseManager;
	}
	
	public void signup(int id, String username, String password,
			String tele_num, String address) {
		try {
	        String insert = "INSERT INTO Normaluser VALUES (?, ?, ?, ?, ?)";   
	        
			PreparedStatement pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.setString(4, tele_num);
			pstmt.setString(5, address);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error signup in normal user", e);
		}		
	}
	
	public Normaluser login(String un, String pw){
		try {
			String qry = "select id, user_name, password, tele_num, address "
						+"from Normaluser "
						+"where user_name = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, un);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return null;
			
			int id = rs.getInt("id");
			String user_name = rs.getString("user_name");
			String password = rs.getString("password");
			String tele_num = rs.getString("tele_num");
			String address = rs.getString("address");
			
			return new Normaluser(this, id, user_name, password, tele_num, address);
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding normal user", e);
		}
	}
	
	public boolean checkDuplicatedUsername(String username){
		try {
			String qry = "select id, user_name, password, tele_num, address "
						+"from Normaluser "
						+"where user_name = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return false;
			return true;
			
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding normal user", e);
		}
	}
	
	public Normaluser checkInfo(int i) {
		try {
			String qry = "select id, user_name, password, tele_num, address "
						+"from Normaluser "
						+"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(qry);
			pstmt.setInt(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			if (!rs.next())
				return null;
			
			int id = rs.getInt("id");
			String user_name = rs.getString("user_name");
			String password = rs.getString("password");
			String tele_num = rs.getString("tele_num");
			String address = rs.getString("address");
			
			return new Normaluser(this, id, user_name, password, tele_num, address);
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error checking normal user", e);
		}
	}
	
	public void updateInfo(int i, String tn, String a) {
		try {
			String cmd = "update Normaluser "
						+"set tele_num = ?, address = ? "
						+"where id = ?";
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, tn);
			pstmt.setString(2, a);
			pstmt.setInt(3, i);
			pstmt.executeUpdate();
						
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error updating normal user", e);
		}
	}

}
