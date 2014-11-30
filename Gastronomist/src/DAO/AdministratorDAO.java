package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JavaBean.Administrator;
import JavaBean.Normaluser;

public class AdministratorDAO {

	private DatabaseManager dbm;
	private Connection conn;
	
	public AdministratorDAO(Connection conn, DatabaseManager dataBaseManager) {
		// TODO Auto-generated constructor stub
		this.conn = conn;
		this.dbm = dataBaseManager;
	}

	public Administrator login(String un, String pw){
		try {
			String qry = "select * "
						+"from Administrator "
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
			
			return new Administrator(this, id, user_name, password);
		}
		catch (SQLException e) {
			dbm.cleanup();
			throw new RuntimeException("error finding administrator", e);
		}
	}
}
