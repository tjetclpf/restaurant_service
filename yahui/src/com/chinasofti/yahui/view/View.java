package com.chinasofti.yahui.view;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.work;

public class View {
	public void welcome(){
		System.out.println("------------欢迎来到亚惠餐厅----------");
	}
	/*public void logon1(){
		System.out.println("请输入员工编号：");
		System.out.println("请输入员工姓名：");
		System.out.println("请输入密码：");
	}
	public void logon2(){
		System.out.println("请输入经理编号：");
		System.out.println("请输入经理姓名：");
		System.out.println("请输入密码：");
	}*/
	public void welcome1(){
		System.out.println("欢迎进入员工管理界面");
		System.out.println("----------------------");
		System.out.println("1、选菜");
		System.out.println("2、结账");
		System.out.println("3、开卡");
		System.out.println("4、挂失");
		System.out.println("5、打印小票");
		System.out.println("6、充值");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
	}
	public void welcome11(){
		System.out.println(">>>购物车");
		System.out.println("---------------------");
		System.out.println("1、点菜到购物车");
		System.out.println("2、购物车删除菜品");
		System.out.println("3、修改购物车");
		System.out.println("4、查询购物车");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
		
	}
	
	public void welcome12(){
		System.out.println(">>>结账:");
		System.out.println("---------------------");
		System.out.println("1、普通顾客");
		System.out.println("2、普通会员");
		System.out.println("3、超级会员");
	}
	

	public void println(String msg){ 
		System.out.println(msg);
	}
	public void welcome2(){
		System.out.println("欢迎进入经理管理界面");
		System.out.println("---------------------");
		System.out.println("1、管理员工");
		System.out.println("2、补卡");
		System.out.println("3、客户冻结");
		System.out.println("4、菜品管理");
		System.out.println("5、菜品类管理");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
	}
	public void welcome21(){
		System.out.println(">>>管理员工");
		System.out.println("---------------------");
		System.out.println("1、增加员工");
		System.out.println("2、删除员工");
		System.out.println("3、修改员工");
		System.out.println("4、查询员工");
		System.out.println("5、查询所有员工");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
		
	}
	public void welcome24(){
		System.out.println(">>>管理菜品");
		System.out.println("---------------------");
		System.out.println("1、增加菜品");
		System.out.println("2、删除菜品");
		System.out.println("3、修改菜品");
		System.out.println("4、查询菜品");
		System.out.println("5、查询所有菜品");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
		
	}
	public void welcome25(){
		System.out.println(">>>管理菜品类");
		System.out.println("---------------------");
		System.out.println("1、增加菜品类");
		System.out.println("2、删除菜品类");
		System.out.println("3、修改菜品类");
		System.out.println("4、查询菜品类");
		System.out.println("0、退出系统");
		System.out.println("---------------------");
		
	}
	public static void show(ArrayList<food> a){
	System.out.println("菜名编号"+"\t"+"菜品类编号"+"\t"+"菜名"+"\t"+"菜价"+"\t"+"存库"+"\t"+"是否特菜价");
	System.out.println("===============================================================================");
	for (food f: a) {
		System.out.println(f.getFid()+"\t"+f.getFtid()+"\t\t"+f.getFname()+"\t"+f.getFprice()+"\t"+f.getStock()+"\t"+f.getSpc_food());
	}
	}
	public static void show1(ArrayList<work> a){
		System.out.println("员工编号"+"\t"+"工作类别"+"\t"+"员工姓名"+"\t"+"员工密码");
		System.out.println("===============================================================================");
		for (work w: a) {
			System.out.println(w.getEid()+"\t"+w.getEjob()+"\t"+w.getEname()+"\t"+w.getEpassword());
		}
		}
}
