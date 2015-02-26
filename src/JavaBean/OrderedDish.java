package JavaBean;

import java.io.Serializable;

public class OrderedDish implements Serializable {
	
	private int dish_id;
	private int quantity;
	private double total_price;
	
	public OrderedDish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderedDish(int dish_id, int quantity, double price) {
		super();
		this.dish_id = dish_id;
		this.quantity = quantity;
		this.total_price = price;
	}

	public int getDish_id() {
		return dish_id;
	}

	public void setDish_id(int dish_id) {
		this.dish_id = dish_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	
}
