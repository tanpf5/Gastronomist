package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Dish;


public class FindDishes extends HttpServlet {

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
		
		int type = (Integer) request.getSession().getAttribute("type");
		int rest_id = Integer.parseInt(request.getParameter("id"));
		DatabaseManager dbm = new DatabaseManager();
		Collection<Dish> dishes= dbm.findAllDishByRest(rest_id);
		request.setAttribute("dishes", dishes);
		request.setAttribute("rest_id", rest_id);
		RequestDispatcher rd;
		if (type == 1) {
			rd = request.getRequestDispatcher("showDish.jsp");
		}
		else {
			rd = request.getRequestDispatcher("editMenu.jsp");
		}
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
