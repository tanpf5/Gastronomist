package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Dish;
import JavaBean.OrderedDish;

public class Checkout extends HttpServlet {

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
		double sum_price = 0;
		
		Iterator<OrderedDish> iterator = cart.iterator();
		while (iterator.hasNext()) {
			OrderedDish orderedDish = iterator.next();
			Dish dish = dbm.findDishById(orderedDish.getDish_id());
			sum_price += orderedDish.getQuantity() * dish.getPrice();
		}
		
		request.setAttribute("sum_price", sum_price);
		RequestDispatcher rd = request.getRequestDispatcher("checkout.jsp");
		rd.forward(request, response);
		
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
