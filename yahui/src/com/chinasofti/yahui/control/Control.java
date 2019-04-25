package com.chinasofti.yahui.control;



import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;

import com.chinasofti.yahui.control.ProxyClient;
import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.orderr;
import com.chinasofti.yahui.domain.shop;
import com.chinasofti.yahui.domain.work;
import com.chinasofti.yahui.jiekou.jiekou;
import com.chinasofti.yahui.util.UserInput;
import com.chinasofti.yahui.view.View;

public class Control {
	//属性
	private View v;
	private UserInput ui;
	public static final String IP="10.10.49.28";
	public static final int PORT=7348;
	private jiekou ji;
	
	//构造方法
	public Control() {
		this.v=new View();
		this.ui=new UserInput();
		//创建代理对象
				ji=ProxyClient.getClient(jiekou.class, IP, PORT);
				
			}

	public void start(){
		while (true) {
			this.v.welcome();
			work h=new work();
			int eid =this.ui.getInt("请输入您的员工编号:");
			int epassword=this.ui.getInt("请输入您的密码:");
			h.setEid(eid);
			h.setEpassword(epassword);
			h=this.ji.findByEidAndEpassword(h);
				if(h.getEname()==null){
					System.out.println("登录失败");
				}else{
					if(h.getEjob()==2){
						//进入经理界面
						this.start6();
					}if(h.getEjob()==1){
						//进入员工界面
						this.start5();
					}else{
						System.out.println("输入有误，请重新选择！");
					}
			}
			
			}
		}
	public void start6(){
		while (true) {
			this.v.welcome2();
			int select=this.ui.getInt("请选择：");
			if(select==0){
				this.v.println("系统终止");
				System.exit(0);
			}else if(select==1){
				this.yuangong();
			}else if(select==2){	
				this.buka();
			}else if(select==3){
				this.dongjie();
			}else if(select==4){
				//菜品管理
				this.food();
			}else if(select==5){
				//菜品类管理
				this.foodtype();
			}
		}
	}
	public void start5(){	
		while (true) {
			this.v.welcome1();
			int select=this.ui.getInt("请选择：");
			if(select==0){
				this.v.println("系统终止");
				System.exit(0);
			}else if(select==1){
				this.shop();
			}else if(select==2){
				this.start3();
			}else if(select==3){
				this.kaika();
			}else if(select==4){
				this.guashi();
			}else if(select==5){
				this.xiaopiao();
			}else if(select==6){
				this.chongzhi();
			}
		}
	}

	private void foodtype() {
		while (true) {
		this.v.welcome25();
		int select=this.ui.getInt("请选择：");
		if(select==0){
			this.v.println("系统终止");
			System.exit(0);
		}else if(select==1){
			this.addfoodtype();
		}else if(select==2){
			this.removefoodtype();
		}else if(select==3){
			this.updatefoodtype();
		}else if(select==4){
			this.selectByftid();
		}
		}
}
	private void food() {
		while (true) {
		this.v.welcome24();
		int select=this.ui.getInt("请选择：");
		if(select==0){
			this.v.println("系统终止");
			System.exit(0);
		}else if(select==1){
			this.addfood();
		}else if(select==2){
			this.removefood();
		}else if(select==3){
			this.updatefood();
		}else if(select==4){
			this.selectbyfid();
		}else if(select==5){
			this.Allfood();
		}
		}
}
	private void Allfood() {
		this.v.println(">>>所有菜品信息查询");
		ArrayList<food> fo=new ArrayList<food>();
		fo=this.ji.Allfood();
		View.show(fo);
	}

	private void shop() {
		while (true) {
		this.v.welcome11();
		int select=this.ui.getInt("请选择：");
		if(select==0){
			this.v.println("系统终止");
			System.exit(0);
		}else if(select==1){
			this.addshop();
		}else if(select==2){
			this.removeshop();
		}else if(select==3){
			this.updateshop();
		}else if(select==4){
			this.selectbyfidg();
		}
		}
}
	
	//点菜
	public void addshop(){
		ArrayList<food> fo=new ArrayList<food>();
		fo=this.ji.Allfood();
		View.show(fo);
		v.println(">>>点菜到购物车:");
		String s= this.ji.addShop(new shop(this.ui.getInt("请输入菜名编号:"),this.ui.getString("请输入菜名:"),this.ui.getInt("请输入菜价"),this.ui.getInt("请输入数量:")));
		System.out.println(s);
		
	}
	private void removeshop() {
		this.v.println(">>>购物车删除菜品：");
		String s = this.ji.removeShop(this.ui.getInt("请输入fid:"));
		System.out.println(s);
	}
	private void updateshop(){
		this.v.println(">>>修改购物车");
		String s = this.ji.updateShop(new shop(this.ui.getInt("请输入菜名编号fid:"),
				this.ui.getString("请输入的菜名fname:"), this.ui.getDouble("请输入菜价fprice:"),this.ui.getInt("请输入数量snum:")));
		System.out.println(s);
		
	}
	
	private void selectbyfidg() {
		v.println(">>>查询购物车:");
		shop s = this.ji.selectByFidg(this.ui.getInt("请输入fid:"));
		System.out.println("fid:" + s.getFid() + "\t" + "ftname:" + s.getFname()+ "\t" + "fprice:" + s.getFprice()+ "\t" + "snum:" + s.getSnum());
	}

	//结账
	public void start3(){
		while (true) {
		this.v.welcome12();
		int select=this.ui.getInt("请选择：");
		
		 if(select==1){
			 this.jiezhang1();
		}else if(select==2){
			this.jiezhang2();
		}else if(select==3){
			this.jiezhang3();
		}
		}
	}
//结账
	public void jiezhang1(){
		this.v.println(">>>结账:");
		orderr s =this.ji.selectByosum(this.ui.getString("请输入订单编号:"));
		System.out.println("订单编号:"+s.getUuid()+"总计:"+s.getOsum());
		
		
	}
	public void jiezhang2(){
		this.v.println(">>>结账:");
		orderr s =this.ji.selectByosum(this.ui.getString("请输入订单编号:"));
		System.out.println("订单编号:"+s.getUuid()+"总计:"+s.getOsum()*0.9);
		
	}
	public void  jiezhang3() {
		this.v.println(">>>结账:");
		orderr s =this.ji.selectByosum(this.ui.getString("请输入订单编号:"));
		System.out.println("订单编号:"+s.getUuid()+"总计:"+s.getOsum()*0.7);
		
	}
	//开卡
	private void kaika(){
		this.v.println(">>>新办卡:");
		String s =this.ji.addcard(new card(this.ui.getInt("请输入卡号:"),this.ui.getString("请输入会员姓名:"),
				this.ui.getInt("请输入新卡密码:"),this.ui.getInt("是否为会员"),this.ui.getInt("请输入要存的金额:"),this.ui.getInt("是否为活跃状态？")));
		System.out.println(s);
		
	}
	//挂失
	private void guashi(){
		this.v.println(">>>挂失:");
		String s=this.ji.updatecard(this.ui.getInt("请输入卡号:"),this.ui.getString("请输入会员姓名:"),this.ui.getInt("请输入卡的密码:"));
		System.out.println(s);
	}
	//打印小票
	private void xiaopiao(){
		this.v.println(">>>打印小票:");
		orderr s =this.ji.selectAll(this.ui.getInt("请输入订单的序号:"));
		System.out.println("序号:"+"\t"+"订单编号:"+"\t"+"创建日期:"+"\t"+"员工编号:"+"\t"+"卡号"+"\t"+"地点"+"\t"+"总计"+"\t"+"收钱"+"\t"+"找钱"+"\t"+"结账方式");
		
	}
	//充值
	private void chongzhi(){
		this.v.println(">>>充值:");
		String s=this.ji.addMoney(this.ui.getInt("请输入要充值的卡号:"),this.ui.getInt("请输入要充值的金额:"));
		System.out.println(s);
	}
		public void buka(){
			v.println(">>>补卡:");
			card s =this.ji.bucard(this.ui.getInt("请输入丢失卡的卡号cid:"));
			System.out.println("cid:" + s.getCid()+ "\t" + "cname:" + s.getCname());
		}
		public void dongjie(){
			v.println(">>>客户冻结:");
			card s =this.ji.dongCard(this.ui.getInt("请输入要冻结的客户卡号:"));
			System.out.println("卡号:" + s.getCid()+"\t"+"是否已经冻结:" + s.getDj());
		}
		
		private void selectById() {
			v.println(">>>员工信息查询:");
			work s = this.ji.selectByEid(this.ui.getInt("请输入eid:"));
			System.out.println("eid:" + s.getEid() + "\t" + "ejob:" + s.getEjob() + "\t" + "ename:" + s.getEname() + "\t"
					+ "epassword:" + s.getEpassword());
			
		}
		private void updateMan() {
			v.println(">>>员工信息修改:");
			String s = this.ji.updateMan(new work(this.ui.getInt("请输入修改的eid:"), this.ui.getInt("请输入修改的ejob:"),
					this.ui.getString("请输入修改的ename:"), this.ui.getInt("请输入修改的epassword:")));
			System.out.println(s);
			
		}
		private void removeMan() {
			v.println(">>>员工信息删除");
			String s = this.ji.removeMan(this.ui.getInt("请输入eid:"));
			System.out.println(s);
		}
		private void addMan() {
			this.v.println(">>>员工信息添加");
			String s = this.ji.addMan(new work(this.ui.getInt("请输入eid:"),
					this.ui.getInt("请输入ejob:"), this.ui.getString("请输入ename:"),
					this.ui.getInt("请输入epassword:")));
			System.out.println(s);
		}
		
		private void yuangong() {
			while (true) {
			this.v.welcome21();
			int select=this.ui.getInt("请选择：");
			if(select==0){
				this.v.println("系统终止");
				System.exit(0);
			}else if(select==1){
				this.addMan();
			}else if(select==2){
				this.removeMan();
			}else if(select==3){
				this.updateMan();
			}else if(select==4){
				this.selectById();
			}else if(select==5){
				this.AllMan();
			}
			}
	}
	
		private void AllMan() {
			this.v.println(">>>所有员工信息查询");
			ArrayList<work> fo=new ArrayList<work>();
			fo=this.ji.AllMan();
			View.show1(fo);
			
		}

		private void addfoodtype() {
			this.v.println(">>>菜品类信息添加");
			String s = this.ji.addFoodtype(new foodtype(this.ui.getInt("请输入菜品类编号:"),
					this.ui.getString("请输入菜品类名称:")));
			System.out.println(s);
		}
		private void removefoodtype() {
			this.v.println(">>>菜品类信息删除");
			String s = this.ji.removeFoodtype(this.ui.getInt("请输入fid:"));
			System.out.println(s);
		}
		private void selectByftid() {
			v.println(">>>菜品类信息查询:");
			foodtype s = this.ji.selectByFtid(this.ui.getInt("请输入ftid:"));
			System.out.println("ftid:" + s.getFtid() + "\t" + "ftname:" + s.getFtname());
		}
		private void updatefoodtype(){
			this.v.println(">>>菜品类信息修改");
			String s = this.ji.updateFoodtype(new foodtype(this.ui.getInt("请输入要修改的菜品类编号ftid:"),
					this.ui.getString("请输入要修改的菜品类名ftname:")));
			System.out.println(s);
		}
		private void addfood() {
			this.v.println(">>>菜品信息添加");
			String s = this.ji.addFood(new food(this.ui.getInt("请输入菜品编号:"),
					this.ui.getInt("请输人菜品类编号:"), this.ui.getString("请输入菜名:"),
					this.ui.getInt("请输人菜价:"), this.ui.getInt("请输人库存:"), this.ui.getString("请输入是否是特菜:")));
			System.out.println(s);
		}
		private void removefood() {
			this.v.println(">>>菜品信息删除");
			String s = this.ji.removeFood(this.ui.getInt("请输入fid:"));
			System.out.println(s);
		}
		private void updatefood(){
			this.v.println(">>>菜品信息修改");
			String s = this.ji.updateFood(new food(this.ui.getInt("请输入要修改的菜名编号fid:"), this.ui.getInt("请输入要修改的菜品类编号ftid:"),
					this.ui.getString("请输入要修改的菜名fname:"), this.ui.getDouble("请输入要修改的菜价fprice:"),this.ui.getInt("请输入要修改的库存stock:"),this.ui.getString("请输入该菜是否为特价菜spc_food:")));
			System.out.println(s);
			
		}
		//查询菜品信息
		private void selectbyfid(){
			this.v.println(">>>菜品信息查询");
			food s =this.ji.selectByFid(this.ui.getInt("请输入要查询的菜名编号fid:"));
			System.out.println("fid:"+s.getFid()+"\t"+s.getFtid()+"\t"+s.getFname()+"\t"+s.getFprice()+"\t"+s.getStock()+"\t"+s.getSpc_food());
		}

}





