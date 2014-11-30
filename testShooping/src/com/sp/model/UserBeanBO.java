/**
 * ����һ��model(������users����ص�ҵ���߼�)
 */
package com.sp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserBeanBO {
	
	//	����һЩ����[]
	private ResultSet rs=null;
	private Connection ct=null;
	private PreparedStatement ps=null;

	/**
	 * �����û������ظ��û���ȫ����Ϣ
	 * @param u���û���
	 * @return userbean
	 */
	
	public UserBean getUserBean(String u){
		
		UserBean ub=new UserBean();
		try {
			
			
			ct=new ConnDB().getConn();
			ps=ct.prepareStatement("select top 1 * from users where username=?");
			ps.setString(1, u);
			rs=ps.executeQuery();
			if(rs.next()){
				
				ub.setUserid(rs.getLong(1));
				ub.setUsername(rs.getString(2));
				ub.setTruename(rs.getString(3));
				ub.setPasswd(rs.getString(4));
				ub.setEmail(rs.getString(5));
				ub.setPhone(rs.getString(6));
				ub.setAddress(rs.getString(7));
				ub.setPostcode(rs.getString(8));
				ub.setGrade(rs.getInt(9));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			this.close();
		}
		
		return ub;
	}
	
	/**
	 * ��֤�û��Ƿ�Ϸ�
	 * @param u
	 * @param p
	 * @return
	 */
	public boolean checkUser(String u,String p){
		
		
		boolean b=false;
		
		
		try {
			
			//sqlע��©��
			
			ct=new ConnDB().getConn();
			
			//top 1��ʾ�鵽һ����¼�ͷ��أ���߲�ѯ�ٶ�
			ps=ct.prepareStatement("select top 1 passwd from users where username=?");
			
			ps.setString(1, u);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				//ȡ�����ݿ������
				String dbPasswd=rs.getString(1);
				
				if(dbPasswd.equals(p)){
					
					b=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally{
			
			//�ر���Դ
			this.close();
		}
		
		return b;
		
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
