package com.wave.util;
import it.sauronsoftware.base64.Base64;

public class Util {
	public static boolean isNull(String property){
		return property==null||property.equals("");
	}
	public static void main(String[] args) {
		String string="1,2,3,4";
		String code[]=string.split(",");
		for(String str:code){
			System.out.println(str);
		}
//		String str="bobo:"+"1234";
//		String str2=Base64.encode(str);
//		System.out.println("-------"+str+"-------");
//		System.out.println("加密后:"+str2);
//		str2="basic:"+str2;
//		System.out.println("加basic :"+str2);
//		String subStr = str2.substring(6);
//		String endStr = Base64.decode(subStr, "UTF-8");
//		String code[] = endStr.split(":");
//		System.out.println("解密后："+code[1]);
//		String password = CodeUtil.get256Encode(code[1]);
//		System.out.println("password:"+password);
//		str="12345";
//		System.out.println("对"+str+"加密:"+Base64.encode(str));
//		str="1234";
//		System.out.println("对"+str+"加密:"+Base64.encode(str));
	}
}
