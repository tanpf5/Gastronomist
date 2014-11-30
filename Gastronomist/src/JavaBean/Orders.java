package JavaBean;

import java.io.Serializable;

import DAO.OrdersDAO;

public class Orders implements Serializable{
	
	private OrdersDAO ordersDAO;
	private int id;
	private Users user_id;
	private Dish dish_id;
	private double price;
	private String tele_num;
	private String address;
	private int mark;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(OrdersDAO ordersDAO, int id, Users user_id, Dish dish_id, double price,
			String tele_num, String address) {
		super();
		this.ordersDAO = ordersDAO;
		this.id = id;
		this.user_id = user_id;
		this.dish_id = dish_id;
		this.price = price;
		this.tele_num = tele_num;
		this.address = address;
	}

	public Orders(OrdersDAO ordersDAO, int id, Users user_id, Dish dish_id,
			double price, String tele_num, String address, int mark) {
		super();
		this.ordersDAO = ordersDAO;
		this.id = id;
		this.user_id = user_id;
		this.dish_id = dish_id;
		this.price = price;
		this.tele_num = tele_num;
		this.address = address;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser_id() {
		return user_id;
	}

	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}

	public Dish getDish_id() {
		return dish_id;
	}

	public void setDish_id(Dish dish_id) {
		this.dish_id = dish_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}
	
	

}
