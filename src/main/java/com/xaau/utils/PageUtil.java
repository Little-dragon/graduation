package com.xaau.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PageUtil {
	public static  HashMap<String , String> handle(String src){
		//很有兴趣,有兴趣, ,文科,       转换为很有兴趣,有兴趣和文科
		HashMap<String , String> map = new HashMap<>();
		String[] a = src.split(" ");
		int j = 1;
		for(int i = 0,len = a.length;i < len;i++) {
			if(a[i].startsWith(",")) {
				a[i] = a[i].substring(1 , a[i].length());
			}
			map.put("q" + j++, a[i].substring(0 , a[i].length() - 1));
		}
		return map;
	}
	
	public static int listToString(List<String> list){
		   StringBuilder sb=new StringBuilder();
		   for(String item : list){
		      if(sb.length()==0) {
		         sb.append(item.toString());
		      } else {
		         sb.append(","+item.toString());
		      }
		   }
		   return Integer.parseInt(sb.toString());
		}

	public static String format_time(String time){

		String result = "";
		return result;
	}
}
