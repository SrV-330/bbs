package com.wsf.util;

public class Tool {
	public final static void test(String...strings ){
		for(String s:strings){
			System.out.println(s);
		}
	}
	public final static boolean isNullOrEmpty(String...strings){
		
		for(String s:strings){
			if(s==null){
				return true;
			}else if("".equals(s.trim())){
				return true;
			}
		}
		return false;
	}

}
