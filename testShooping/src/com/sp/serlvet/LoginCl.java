package com.sp.serlvet;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCl extends HttpServlet {

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

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		
		//�õ��û��������룬��֤�û��Ƿ�Ϸ�
		
		String u=request.getParameter("username");
		
		String p=request.getParameter("password");
		
		//��֤�û�
		UserBeanBO ubb=new UserBeanBO();
		
		if(ubb.checkUser(u, p)){
			
			//�û��Ϸ�
			
			//1.�ѳɹ���¼���û���Ϣ����session�������õ���
			
			UserBean ub=ubb.getUserBean(u);
			request.getSession().setAttribute("userInfo", ub);
			
			//2.�ѹ��ﳵ����Ϣȡ����׼����һ��ҳ����ʾ
			MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
			
			ArrayList al=mcb.showMyCart();
			
			//��al����request
			request.setAttribute("mycartInfo", al);
			
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
		}else{
			
			//�û����Ϸ�
			
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
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
