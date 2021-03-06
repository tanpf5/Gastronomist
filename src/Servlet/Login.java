package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DatabaseManager;
import JavaBean.Administrator;
import JavaBean.Normaluser;
import JavaBean.OrderedDish;

public class Login extends HttpServlet {

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

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		DatabaseManager dbm = new DatabaseManager();
		String admin = request.getParameter("admin?");
		if (admin == null) {
			Normaluser user = dbm.normaluserLogin(username, password);
			if (user == null) {
				String url="index.jsp";
				url=new String(url.getBytes("GBK"),"ISO8859_1"); 
				response.sendRedirect(url);
			}
			else {
				Collection<OrderedDish> cart = new ArrayList<OrderedDish>();
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("type", 1);
				String url="homePage.jsp";
				url=new String(url.getBytes("GBK"),"ISO8859_1"); 
				response.sendRedirect(url); 
			}
		}
		else {
			Administrator administrator = dbm.adminLogin(username, password);
			if (administrator == null) {
				String url="index.jsp";
				url=new String(url.getBytes("GBK"),"ISO8859_1"); 
				response.sendRedirect(url);
			}
			else {
				Collection<OrderedDish> cart = new ArrayList<OrderedDish>();
				request.getSession().setAttribute("admin", administrator);
				request.getSession().setAttribute("type", 2);
				String url="homePage.jsp";
				url=new String(url.getBytes("GBK"),"ISO8859_1"); 
				response.sendRedirect(url); 
			}
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
