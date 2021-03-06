package Servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Administrator;
import JavaBean.Dish;
import JavaBean.Normaluser;
import JavaBean.Orders;
import JavaBean.Restaurant;

public class Test extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DatabaseManager dbm = new DatabaseManager();
	/*  Collection<Dish> dishes = (Collection<Dish>) request.getAttribute("dishes");
		Collection<Orders> orders = (Collection<Orders>) request.getAttribute("orders");
		Iterator<Dish> iterator = dishes.iterator();
		while (iterator.hasNext()) {
			Dish dish = iterator.next();
			String dish_name = dish.getDi_name();
			double price = dish.getPrice();
			int times = dish.getTimes();
			int mark = dish.getMark();
		}*/
		int id = dbm.findNextDishId();
		boolean succ = dbm.insertDish(id, 1, "tofu", 3.99);
		succ = dbm.updateDish(id, 1, "dumpling", 4.99);
		dbm.deleteDish(id);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
