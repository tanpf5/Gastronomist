package JavaBean;

import java.io.Serializable;

import DAO.DishDAO;

public class Dish implements Serializable{

	private DishDAO dishDAO;
	private int id;
	private Restaurant rest_id;
	private String di_name;
	private double price;
	private int times;
	private int mark_times;
	private int mark;
	
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dish(DishDAO dishDAO, int id, Restaurant rest_id, String di_name,
			double price, int times, int mark_times, int mark) {
		super();
		this.dishDAO = dishDAO;
		this.id = id;
		this.rest_id = rest_id;
		this.di_name = di_name;
		this.price = price;
		this.times = times;
		this.mark_times = mark_times;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRest_id() {
		return rest_id;
	}

	public void setRest_id(Restaurant rest_id) {
		this.rest_id = rest_id;
	}

	public String getDi_name() {
		return di_name;
	}

	public void setDi_name(String di_name) {
		this.di_name = di_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public int getMark_times() {
		return mark_times;
	}

	public void setMark_times(int mark_times) {
		this.mark_times = mark_times;
	}
	
	
}
