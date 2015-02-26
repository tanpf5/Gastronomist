package JavaBean;

import java.io.Serializable;

import DAO.RestaurantDAO;

public class Restaurant implements Serializable{
	
	private RestaurantDAO restaurantDAO;
	private int id;
	private String re_name;
	private String re_tel_num;
	
	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(RestaurantDAO restaurantDAO, int id, String re_name, String re_tel_num) {
		super();
		this.restaurantDAO = restaurantDAO;
		this.id = id;
		this.re_name = re_name;
		this.re_tel_num = re_tel_num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public String getRe_tel_num() {
		return re_tel_num;
	}

	public void setRe_tel_num(String re_tel_num) {
		this.re_tel_num = re_tel_num;
	}
		
}
