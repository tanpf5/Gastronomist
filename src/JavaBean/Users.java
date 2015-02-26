package JavaBean;

import java.io.Serializable;

import DAO.UsersDAO;

public class Users implements Serializable{
	
	private UsersDAO usersDAO;
	protected int id;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(UsersDAO usersDAO, int id) {
		super();
		this.usersDAO = usersDAO;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
