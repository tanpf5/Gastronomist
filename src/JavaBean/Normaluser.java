package JavaBean;

import java.io.Serializable;

import DAO.NormaluserDAO;

public class Normaluser extends Users implements Serializable {

	private NormaluserDAO normaluserDAO;
	private String username;
	private String password;
	private String tele_num;
	private String address;
	
	public Normaluser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Normaluser(NormaluserDAO normaluserDAO, int id, String username, String password, String tele_num,
			String address) {
		super();
		this.normaluserDAO = normaluserDAO;
		this.id = id;
		this.username = username;
		this.password = password;
		this.tele_num = tele_num;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTele_num() {
		return tele_num;
	}
	public void setTele_num(String tele_num) {
		this.tele_num = tele_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
