package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Dish;
import JavaBean.Orders;

public class Mark extends HttpServlet {

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

		int order_id = Integer.parseInt(request.getParameter("id"));
		int mark = Integer.parseInt(request.getParameter("mark"));
		
		DatabaseManager dbm = new DatabaseManager();
		Orders order = dbm.findOrderById(order_id);
		Dish dish = order.getDish_id();
		dbm.updateOrder(order_id, mark);
		int dish_id = dish.getId();
		int new_mark_times = dish.getMark_times() + 1;
		int new_mark = 
				(int) Math.rint((dish.getMark() * (new_mark_times - 1) + mark) / new_mark_times);
		dbm.updateDishMark(dish_id, new_mark_times, new_mark);
		
		String url="myOrder.do";
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
