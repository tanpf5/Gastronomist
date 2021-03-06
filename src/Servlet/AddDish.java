package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;

public class AddDish extends HttpServlet {

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

		int rest_id = Integer.parseInt(request.getParameter("rest_id"));
		
		String di_name = request.getParameter("dish_name");
		Double price = Double.parseDouble(request.getParameter("price"));
		
		DatabaseManager dbm = new DatabaseManager();
		int dish_id = dbm.findNextDishId();
		
		boolean succ = dbm.insertDish(dish_id, rest_id, di_name, price);
		if (succ) {
			String url="dish.do?id="+rest_id;
			url=new String(url.getBytes("GBK"),"ISO8859_1"); 
			response.sendRedirect(url);
		} else {
			String url="addDish.jsp?rest_id="+rest_id;
			url=new String(url.getBytes("GBK"),"ISO8859_1"); 
			response.sendRedirect(url);
		}
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
