package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import JavaBean.Administrator;
import JavaBean.Dish;
import JavaBean.Normaluser;
import JavaBean.Orders;
import JavaBean.Restaurant;

import com.mysql.jdbc.Driver;

public class DatabaseManager {
	private Connection conn;
	private UsersDAO usersDAO;
	private NormaluserDAO normaluserDAO;
	private AdministratorDAO administratorDAO;
	private DishDAO dishDAO;
	private OrdersDAO ordersDAO;
	private RestaurantDAO restaurantDAO;
	
	public DatabaseManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/Gastronomist";        
			String username = "root";
			String password = "";
			
			Connection conn = DriverManager.getConnection(url, username, password);   
			//conn.setAutoCommit(false);
			
			usersDAO = new UsersDAO(conn, this);
			normaluserDAO = new NormaluserDAO(conn, this);
			administratorDAO = new AdministratorDAO(conn, this);
			dishDAO = new DishDAO(conn, this);
			ordersDAO = new OrdersDAO(conn, this);
			restaurantDAO = new RestaurantDAO(conn, this);
	      }
		catch(SQLException e) {
	    	  throw new RuntimeException("cannot connect to database", e); } 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int findNextUserId(){
		return usersDAO.findNextUserId();
	}
	
	public boolean signup(int id, String user_name, String password,
			String tele_num, String address) {
		if (normaluserDAO.checkDuplicatedUsername(user_name)) return false;
		usersDAO.signup(id);
		normaluserDAO.signup(id, user_name, password, tele_num, address);
		return true;
	}
	
	public Normaluser normaluserLogin(String un, String pw) {
		return normaluserDAO.login(un, pw);
	}
	
	public Administrator adminLogin(String un, String pw) {
		return administratorDAO.login(un, pw);
	}
	
	public Normaluser checkInfo(int i){
		return normaluserDAO.checkInfo(i);
	}
	
	public boolean updateInfo(int i, String un, String pw, String tn, String a) {
		if (normaluserDAO.checkDuplicatedUsername(i, un)) return false;
		normaluserDAO.updateInfo(i, un, pw, tn, a);
		return true;
	}
	
	public void updateOrder(int id, int mark) {
		ordersDAO.updateOrder(id, mark);
	}
	
	public Restaurant findRestaurant(int id) {
		return restaurantDAO.find(id);
	}
	
	public Collection<Restaurant> getAllRestaurant() {
		return restaurantDAO.allRestaurant();
	}
	
	public Collection<Dish> findAllDishByRest(int id){
		return dishDAO.findAllDishByRest(id);
	}
	
	public boolean insertDish(int id, int rest_id, String di_name, double price){
		if (dishDAO.checkDuplicatedDishname(di_name)) return false;
		dishDAO.insertDish(id, rest_id, di_name, price);
		return true;
	}
	
	public boolean updateDish(int id, int rest_id, String di_name, double price) {
		if (dishDAO.checkDuplicatedDishname(id, di_name)) return false;
		dishDAO.updateDish(id, rest_id, di_name, price);
		return true;
	}
	
	public void deleteDish(int id) {
		dishDAO.deleteDish(id);
	}
	
	public int findNextDishId(){
		return dishDAO.findNextDishId();
	}
	
	public void insertOrder(int id, int user_id, int dish_id, double price, 
			String tele_num, String address){
		ordersDAO.insertOrder(id, user_id, dish_id, price, tele_num, address);
	}
	
	public int findNextOrderId(){
		return ordersDAO.findNextOrderId();
	}
	
	public Collection<Orders> findMyOrder(int id) {
		return ordersDAO.findMyOrder(id);
	}
	
	public Dish findDishById(int id){
		return dishDAO.findById(id);
	}
	
	public Orders findOrderById(int id) {
		return ordersDAO.findById(id);
	}
	
	public void updateDishMark(int id, int mark_times, int mark){
		dishDAO.updateDishMark(id, mark_times, mark);
	}
	
	public void commit() {
		try {
	         conn.commit();
	    }
		catch(SQLException e) {
			throw new RuntimeException("cannot commit database", e);
		}
	}
	
	public void close() {
	      try {
	         conn.close();
	      }
	      catch(SQLException e) {
	    	  throw new RuntimeException("cannot close database", e);
	      } 
	}
	
	public void cleanup() {
	      try {
	         conn.rollback();
	         conn.close();
	      }
	      catch(SQLException e) {
	    	  System.out.println("fatal error: cannot cleanup connection"); }
	}
	
	public void updateDishTimes(int id, int times) {
		dishDAO.updateDishTimes(id, times);
	}
	
}
