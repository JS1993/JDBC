package com.jiangsu.jdbc;

import java.util.Scanner;

public class ClientUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("請輸入用戶名");
		String name = sc.next();
		System.out.println("請輸入密碼");
		String password = sc.next();
		
	    user u = DoLogin.findUser(name, password);
	    if(u!=null){
	    	System.out.println("登陸成功");
	    }else{
	    	System.out.println("同戶名或者密碼錯誤");
	    }
	}

}
