package com.sp.model;
import java.util.*;
public class Test {

	//hashmapʹ�õļ򵥰���
	
	public static void main(String []args){
		
		HashMap hm=new HashMap();
		
		hm.put("1", "3");
		hm.put("2", "4");
		hm.put("5", "100");
		
		
		hm.remove("2");
		hm.clear();
		//ȡ������key
		
		//ʹ�õ�����
		Iterator it=hm.keySet().iterator();
		
		while(it.hasNext()){
			
			//ȡ��key
			String key=(String)it.next();
			
			
			
			//����keyȡ��value
			
			String nums=(String)hm.get(key);
			System.out.println("key===="+key+" num="+nums);
		}
	}
}
