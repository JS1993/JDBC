package com.jiangsu.jdbc;

import java.util.Scanner;

public class ClientUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ոݔ���Ñ���");
		String name = sc.next();
		System.out.println("Ոݔ���ܴa");
		String password = sc.next();
		
	    user u = DoLogin.findUser(name, password);
	    if(u!=null){
	    	System.out.println("��ꑳɹ�");
	    }else{
	    	System.out.println("ͬ���������ܴa�e�`");
	    }
	}

}
