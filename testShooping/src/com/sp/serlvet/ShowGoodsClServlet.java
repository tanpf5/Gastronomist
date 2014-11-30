package com.sp.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShowGoodsClServlet extends HttpServlet {

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
		
		//�õ�type,�ж��û������ҳ����������ʾ�������ϸ��Ϣ
		
		String type=request.getParameter("type");
		
		
		if(type.equals("showDetail")){
		
		//�õ�Ҫ��ʾ�Ļ����id
		String goodsId=request.getParameter("id");
		//����GoodsBeanBO(С��)[���Ը���õ�����ľ�����Ϣ]
		GoodsBeanBO gbb=new GoodsBeanBO();
		
		GoodsBean gb=gbb.getGoodsBean(goodsId);
		
		//��gb����request
		
		request.setAttribute("goodsInfo", gb);
		
		//��ת
		
		request.getRequestDispatcher("showDetail.jsp").forward(request, response);
		}else if(type.equals("fenye")) {
			
			//�õ�pageNow
			String pageNow=request.getParameter("pageNow");
			
			
			//��pageNow���뵽request
			request.setAttribute("abc", pageNow);
			//���ع������
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
