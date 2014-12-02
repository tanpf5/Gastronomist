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
import JavaBean.Normaluser;
import JavaBean.OrderedDish;

public class Signup extends HttpServlet {

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

		String user_name = request.getParameter("uid");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		String tele_num = request.getParameter("tel");
		String address = request.getParameter("address");
		
		if (!password.equals(confirm)) {
			String url = "signup.jsp?message=differentpassword";
			url = new String(url.getBytes("GBK"),"ISO8859_1"); 
			response.sendRedirect(url); 
		}
		else {
		
			DatabaseManager dbm = new DatabaseManager();
			int id = dbm.findNextUserId();
			boolean succ = dbm.signup(id, user_name, password, tele_num, address);
			
			if (succ) {
				Normaluser user = dbm.checkInfo(id);
				Collection<OrderedDish> cart = new ArrayList<OrderedDish>();
				request.getSession().setAttribute("cart", cart);
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("type", 1);
				String url="homePage.jsp";
				url=new String(url.getBytes("GBK"),"ISO8859_1"); 
				response.sendRedirect(url); 
			}
			else {
				String url = "signup.jsp?message=duplicatedusername";
				url = new String(url.getBytes("GBK"),"ISO8859_1"); 
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
