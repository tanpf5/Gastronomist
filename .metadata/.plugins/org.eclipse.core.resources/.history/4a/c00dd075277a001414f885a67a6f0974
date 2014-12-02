package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Dish;
import JavaBean.OrderedDish;

public class Cart extends HttpServlet {

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
		Collection<OrderedDish> cart 
			= (Collection<OrderedDish>) request.getSession().getAttribute("cart");
		int dish_id = Integer.parseInt(request.getParameter("id"));
		int rest_id = Integer.parseInt(request.getParameter("rest_id"));
		
		// check if already exist
		boolean find = false;
		Iterator<OrderedDish> iterator = cart.iterator();
		while (iterator.hasNext()) {
			OrderedDish orderedDish = iterator.next();
			if (dish_id == orderedDish.getDish_id()) {
				cart.remove(orderedDish);
				// update quantity
				orderedDish.setQuantity(orderedDish.getQuantity() + 1);
				// update total_price
				Dish dish = dbm.findDishById(dish_id);
				double price = dish.getPrice();
				orderedDish.setTotal_price(orderedDish.getTotal_price() + price);
				cart.add(orderedDish);
				find = true;
			}
		}
		// update cart in session
		if (!find) {
			Dish dish = dbm.findDishById(dish_id);
			double price = dish.getPrice();
			cart.add(new OrderedDish(dish_id, 1, price));
		}
		request.getSession().setAttribute("cart", cart);
		
		String url="dish.do?id="+rest_id;
		url=new String(url.getBytes("GBK"),"ISO8859_1"); 
		response.sendRedirect(url); 
		
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
