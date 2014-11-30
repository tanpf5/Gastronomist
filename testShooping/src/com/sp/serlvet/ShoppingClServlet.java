package com.sp.serlvet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sp.model.*;
public class ShoppingClServlet extends HttpServlet {

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
		
		
		
		//�õ�typeֵ���ж��û���Ҫ���������Ĳ���
		String type=request.getParameter("type");
		//���������ﳵ����
		
		//1.����ͼ��session��ȡ��һ��������
		MyCartBO mbo=(MyCartBO)request.getSession().getAttribute("mycart");
		
		if(mbo==null){
			
			//˵�����û���һ�ι���
			//����һ�����ﳵ��������sesion
			mbo=new MyCartBO();
			request.getSession().setAttribute("mycart", mbo);
		}
		
		if(type.equals("addGoods")){
		
		
		//���Ҫ����Ļ����id
		String goodsId=request.getParameter("goodsId");
		
		//����MyCartBO[���ﳵ],��ɹ���
		//MyCartBO mbo=new MyCartBO();//?????����������ж�����ﳵ!!![���ڣ����Ǳ�����취����֤ʼ��ֻ��һ�����ﳵ ] [session???]
		
		
		
		
		//Ĭ�Ϲ�����1���飬�Ժ�����޸�
		mbo.addGoods(goodsId, "1");
		
		
		}else if(type.equals("delGoods")){
			
			
			//�õ�Ҫɾ���Ļ����id
			String goodsId=request.getParameter("goodsId");
			
			//�ӹ��ﳵ��ɾ��(��session��)
			mbo.delGoods(goodsId);
		}else if(type.equals("show")){
			//do nothing
		}else if(type.equals("delAll")){
			
			mbo.clear();
		}else if(type.equals("updateGoods")){
			
			//�û�ϣ���޸�����
			
			//������servlet�еõ������id,���µ�����
			
			//���ջ���id 
			
			String goodsId[]=request.getParameterValues("goodsId");
			String newNums[]=request.getParameterValues("newNums");
			
			//����һ�¿����Ƿ�õ��µ��޸�ֵ
			for(int i=0;i<goodsId.length;i++){
				
				System.out.println("id==="+goodsId[i]+"  ����="+newNums[i]);
				//�޸�
				mbo.upGoods(goodsId[i], newNums[i]);
			}
			
			
			
		}
		
		
		//�ѹ��ﳵ�Ļ���ȡ����׼������һ��ҳ����ʾ
		
		ArrayList al=mbo.showMyCart();
		
		//���뵽request
		request.setAttribute("mycartinfo", al);
		//��ת��
		request.getRequestDispatcher("showMycart.jsp").forward(request, response);
		
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
