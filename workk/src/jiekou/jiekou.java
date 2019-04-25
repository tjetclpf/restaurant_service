package jiekou;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.mem_lin;
import com.chinasofti.yahui.domain.orderit;
import com.chinasofti.yahui.domain.orderr;
import com.chinasofti.yahui.domain.shop;
import com.chinasofti.yahui.domain.work;

public interface jiekou {
	//添加职工
	public String addMan(work z);
	//删除职工
	public String removeMan(int eid);
	//修改职工
	public String updateMan(work z);
	//查询员工
	public work selectByEid(int eid);
	//查询所有员工
	public List<work> AllMan();

	//添加菜品
	public String addFood(food z);
	//删除菜品
	public String removeFood(int fid);
	//修改菜品
	public String updateFood(food z);
	//查询菜品
	public food selectByFid(int fid);
	//查询所有菜品
	public ArrayList<food> Allfood();

	//添加菜品类
	public String addFoodtype(foodtype z);
	//查询菜品类
	public foodtype selectByFtid(int ftid);
	//删除菜品类
	public String removeFoodtype(int ftid);
	//修改菜品类
	public String updateFoodtype(foodtype z);

	//添加购物车
	public String addShop(shop z);
	//删除购物车
	public String removeShop(int fid);
	//修改购物车
	public String updateShop(shop z);
	//查询购物车
	public shop selectByFidg(int fid);
	public void qingli();
	public void qinglidd();
	//添加卡
	public String addcard(card z);
	//删除卡
	public String removeCard(int cid);
	//修改卡
	public String updateCard(card z);
	//查询卡
	public card selectByCid(int cid);
	//充值
	public String addMoney(int cid,int mon);
	//消费
	public String deleteMoney(int cid,int mon);
	/*==========订单=========*/
	//添加订单
	public String addorderr(orderr z);
	//删除订单
	public String removeOrderr(int oid);
	//修改订单
	public String updateOrderr(orderr z);
	//查询订单
	public orderr selectByOid(int oid);
	//查询所有订单
	public ArrayList<orderr> Allorderr();
	/*==========订单项表=========*/
	//添加订单项表
	public String addorderit(orderit z);
	//删除订单项表
	public String removeorderit(int oid);
	//修改订单项表
	public String updateOrderit(orderit z);
	//查询订单项表
	public orderit selectOid(int oid);
	/*==========会员表=========*/
	//添加会员
	public String addmem(mem_lin z);
	//删除会员
	public String removeMem(int cid);
	//修改会员
	public String updateMem(mem_lin z);
	//查询会员
	public mem_lin selectHyCid(int cid);
	/*=========登录=========*/
	//登录
	public work findByEidAndEpassword(work z);
}