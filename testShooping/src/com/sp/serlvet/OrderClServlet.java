package com.sp.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class OrderClServlet extends HttpServlet {

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
		
		//������ɶ���(�Ѷ���д�����ݿ�)
		//�����񽫻ύ��OrderBeanBO
		
		OrderBeanBO obb=new OrderBeanBO();
		
		//�õ����ﳵ
		MyCartBO mcb=(MyCartBO)request.getSession().getAttribute("mycart");
		//�û�id
		long userId=((UserBean)request.getSession().getAttribute("userInfo")).getUserid();
		OrderInfoBean oib=obb.addOrder(mcb, userId+"");
		if(oib!=null){
			
			//���ok
			//׼����ʾ��������ϸ��Ϣ������,���¸�ҳ��shopping4.jsp
			
			request.setAttribute("detailbean", oib);
			request.getRequestDispatcher("shopping4.jsp").forward(request, response);
		}else{
			//��Ӷ���ʧ��
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
