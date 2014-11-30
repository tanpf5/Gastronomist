//����model�࣬������goods����ص�ҵ���߼�
package com.sp.model;
import java.sql.*;
import java.util.ArrayList;
public class GoodsBeanBO {
	
	//����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	/**
	 * ���ع��ж���ҳ
	 * 
	 */
	
	public int getPageCount(int pageSize){
		
		int pageCount=0;
		int rowCount=0;
		try {
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select count(*) from goods");
			
			//�õ����ж�������¼
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				rowCount=rs.getInt(1);
					
			}
			
			if(rowCount%pageSize==0){
				
				pageCount=rowCount/pageSize;
			}else{
				
				pageCount=rowCount/pageSize+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return pageCount;
	}
	
	
	/**
	 * ��ҳ��ʾ�������Ϣ
	 * @prameter int pageSize:ÿҳ��ʾ������¼
	 * @author ˳ƽ
	 * @prameter int pageNow:��ʾ�ڼ�ҳ
	 * @return ArrayList ������Ҫ��ʾ���Ｏ�ϡ�
	 * ctrl+shift+m(���������)
	 */
	public ArrayList getGoodsByPage(int pageSize,int pageNow){
		
		ArrayList al=new ArrayList();
		
		try {
			
			ct=new ConnDB().getConn();
			
			
			ps=ct.prepareStatement("select top "+pageSize
					+" * from goods where goodsId not in (select top "
					+(pageNow-1)*pageSize+" goodsId from goods)");
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				GoodsBean gb=new GoodsBean();
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				//���뵽al
				
				al.add(gb);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			this.close();
		}
		
		return al;
	}
	
	//����һ������id,�õ����������Ϣ�ĺ���
	public GoodsBean getGoodsBean(String id){
		
		
		GoodsBean gb=new GoodsBean();
		
		try {
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement("select * from goods where goodsId=?");
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				
				//���뵽gb
				gb.setGoodsId(rs.getInt(1));
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				gb.setGoodsPrice(rs.getFloat(4));
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return gb;
		
	}
	
	//�رպ���
	
	public void close(){
		
		try {
			
			if(rs!=null){
				
				rs.close();
				rs=null;//
			}
			if(ps!=null){
				
				ps.close();
				ps=null;
			}
			
			if(!ct.isClosed()){
				
				ct.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
