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
import JavaBean.Normaluser;
import JavaBean.OrderedDish;

public class MakeOrder extends HttpServlet {

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

		Collection<OrderedDish> cart 
			= (Collection<OrderedDish>) request.getSession().getAttribute("cart");
		Normaluser user = (Normaluser) request.getSession().getAttribute("user");
		DatabaseManager dbm = new DatabaseManager();
		int user_id = user.getId();
		String tele_num = request.getParameter("number");
		String address = request.getParameter("address");
		
		Iterator<OrderedDish> iterator = cart.iterator();
		while (iterator.hasNext()) {
			OrderedDish od = iterator.next();
			int dish_id = od.getDish_id();
			Dish dish = dbm.findDishById(dish_id);
			double price = dish.getPrice();
			int times = dish.getTimes();
			int quantity = od.getQuantity();
			dbm.updateDishTimes(dish_id, times + quantity);
			int order_id = dbm.findNextOrderId();
			dbm.insertOrder(order_id, user_id, dish_id, price, tele_num, address);
		}
		cart.removeAll(cart);
		String url="homePage.jsp";
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
