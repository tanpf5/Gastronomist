//����һ��BO(model)
//���ڴ����빺����ص�ҵ���߼�(�ɰ���������һ�����ﳵ)
package com.sp.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class MyCartBO {

	//����һ��hashmap���ϣ����ڴ�����id���������
	
	HashMap<String,String> hm=new HashMap<String,String>();
	
//	����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;
	
	//���ﳵ���ܼ�
	
	private float allPrice=0.0f;
	
	/**
	 * �����ܼ�
	 * @return
	 */
	public float getAllPrice(){
		
		return this.allPrice;
	}
	
	
	/**
	 * ����id���ػ��������
	 * @param goodsId:����id
	 * @return ���������
	 */
	
	
	public String getGoodsNumById(String goodsId){
		
		return (String)hm.get(goodsId);
	}
	
	//1.��ӻ���
	public void addGoods(String goodsId,String goodsNum){
		
		hm.put(goodsId, goodsNum);
	}
	
	//2.ɾ������
	public void delGoods(String goodsId){
		
		hm.remove(goodsId);
	}
	
	
	//3.��ջ���
	
	public void clear(){
		
		hm.clear();
	}
	
	//4.�޸Ļ�������
	public void upGoods(String goodsId,String newNum){
		
		hm.put(goodsId, newNum);
	}
	
	//5.��ʾ���ﳵ(�е���)
	public ArrayList showMyCart(){
		
		//����jdk5.0
		ArrayList <GoodsBean> al=new ArrayList <GoodsBean>();
		
		try {
			
			//��֯ sql
			
			String sql="select * from goods where goodsId in";//(1,4)
			
			//ʹ�õ�������ɴ�hm��ȡ������id�� Ҫ��(Ϊ���ô�������ˣ��Ҿ�һ���򵥰���)
			
			Iterator it=hm.keySet().iterator();
			
			String sub="(";
			while(it.hasNext()){
				
				//ȡ��goodsId
				String goodsId=(String)it.next();
				//�ж�goodsId�ǲ������id
				if(it.hasNext()){
				sub+=goodsId+",";
				}else{
					
					sub+=goodsId+")";
				}
			}
			
			sql+=sub;
			
			ct=new ConnDB().getConn();
			
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
			//���ܼ����
			this.allPrice=0.0f;
			while(rs.next()){
				
				
				GoodsBean gb=new GoodsBean();
				int goodsId=rs.getInt(1);
				gb.setGoodsId(goodsId);
				gb.setGoodsName(rs.getString(2));
				gb.setGoodsIntro(rs.getString(3));
				float unit=rs.getFloat(4);
				gb.setGoodsPrice(unit);
				gb.setGoodsNum(rs.getInt(5));
				gb.setPublisher(rs.getString(6));
				gb.setPhoto(rs.getString(7));
				gb.setType(rs.getString(8));
				
				this.allPrice=this.allPrice+unit*Integer.parseInt(this.getGoodsNumById(goodsId+""));
				
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
