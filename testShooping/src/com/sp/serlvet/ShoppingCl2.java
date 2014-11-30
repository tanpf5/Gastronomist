package com.sp.serlvet;
import com.sp.model.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShoppingCl2 extends HttpServlet {

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
		//��������
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//���������������ȥ����û��Ƿ��¼�������û�е�¼�ͽ����¼����
		//�����¼������ֱ�ӽ�����ʾ�û���Ϣ�͹��ﳵ�����ҳ��
		
		//1����session���Ƿ����û���¼����Ϣ
		
		UserBean ub=(UserBean)request.getSession().getAttribute("userInfo");
		
		if(ub==null){
			
			//˵���û�û�е�¼��
			//����ת��shopping2.jsp,
			request.getRequestDispatcher("shopping2.jsp").forward(request, response);
			
		}else{
			//˵����¼��
			//����ת��shopping3.jsp
			request.getRequestDispatcher("shopping3.jsp").forward(request, response);
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
