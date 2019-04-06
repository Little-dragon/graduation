package com.xaau.utils;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Test
	public void format_String(){
		HashMap<String , String> result = new HashMap<String , String>();
		String src = "cab=b*#b*#, ca=b*#b*#b*#b";
		String type = "";
		String question_name = "";
		String[] list = src.split(",");
		for(int i = 0;i < list.length;i++){
			type = list[i].trim().substring(0,1);
			String[] temp = list[i].trim().split("=");
			question_name = temp[0].substring(1 , temp[0].length());
			String[] answers = temp[1].split("\\*#");
			for(int j = 0;j < answers.length;j++){
				System.out.println(answers[j]);
			}
		}
//		return result;
	}
}
