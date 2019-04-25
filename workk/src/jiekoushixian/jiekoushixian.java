package jiekoushixian;

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

import jiekou.jiekou;
import rms.biz.cardBiz;
import rms.biz.foodBiz;
import rms.biz.foodtypeBiz;
import rms.biz.mem_linBiz;
import rms.biz.orderitBiz;
import rms.biz.orderrBiz;
import rms.biz.shopBiz;
import rms.biz.workBiz;
import rms.biz.impl.cardBizImpl;
import rms.biz.impl.foodBizImpl;
import rms.biz.impl.foodtypeBizImpl;
import rms.biz.impl.mem_linBizImpl;
import rms.biz.impl.orderitBizImpl;
import rms.biz.impl.orderrBizImpl;
import rms.biz.impl.shopBizImpl;
import rms.biz.impl.workBizImpl;

public class jiekoushixian implements jiekou{
	private workBiz wbiz;
	private foodBiz fbiz;
	private foodtypeBiz fobiz;
	private shopBiz shbiz;
	private cardBiz cabiz;
	private orderrBiz orbiz;
	private orderitBiz ordbiz;
	private mem_linBiz membiz;
	public jiekoushixian() {
		this.wbiz=new workBizImpl();
		this.fbiz=new foodBizImpl();
		this.fobiz=new foodtypeBizImpl();
		this.shbiz=new shopBizImpl(); 
		this.cabiz=new cardBizImpl();
		this.orbiz=new orderrBizImpl();
		this.ordbiz=new orderitBizImpl();
		this.membiz=new mem_linBizImpl();
	}
	//员工
	@Override
	public String addMan(work z) {
		// TODO Auto-generated method stub
		return wbiz.addMan(z);
	}

	@Override
	public String removeMan(int eid) {
		// TODO Auto-generated method stub
		return wbiz.removeMan(eid);
	}

	@Override
	public String updateMan(work z) {
		// TODO Auto-generated method stub
		return wbiz.updateMan(z);
	}

	@Override
	public work selectByEid(int eid) {
		// TODO Auto-generated method stub
		return wbiz.selectByEid(eid);
	}

	@Override
	public List<work> AllMan() {
		// TODO Auto-generated method stub
		return wbiz.AllMan();
	}
	//菜品
	@Override
	public String addFood(food z) {
		// TODO Auto-generated method stub
		return fbiz.addFood(z);
	}

	@Override
	public String removeFood(int fid) {
		// TODO Auto-generated method stub
		return fbiz.removeFood(fid);
	}

	@Override
	public String updateFood(food z) {
		// TODO Auto-generated method stub
		return fbiz.updateFood(z);
	}

	@Override
	public food selectByFid(int fid) {
		// TODO Auto-generated method stub
		return fbiz.selectByFid(fid);
	}
	@Override
	public ArrayList<food> Allfood() {
		// TODO Auto-generated method stub
		return fbiz.Allfood();
	}

	//菜品类
	@Override
	public String addFoodtype(foodtype z) {
		// TODO Auto-generated method stub
		return fobiz.addFoodtype(z);
	}

	@Override
	public foodtype selectByFtid(int ftid) {
		// TODO Auto-generated method stub
		return fobiz.selectByFtid(ftid);
	}

	@Override
	public String removeFoodtype(int ftid) {
		// TODO Auto-generated method stub
		return fobiz.removeFoodtype(ftid);
	}

	@Override
	public String updateFoodtype(foodtype z) {
		// TODO Auto-generated method stub
		return fobiz.updateFoodtype(z);
	}
	
	
	//购物车
	@Override
	public String addShop(shop z) {
		// TODO Auto-generated method stub
		return shbiz.addShop(z);
	}

	@Override
	public String removeShop(int fid) {
		// TODO Auto-generated method stub
		return shbiz.removeShop(fid);
	}

	@Override
	public String updateShop(shop z) {
		// TODO Auto-generated method stub
		return shbiz.updateShop(z);
	}

	@Override
	public shop selectByFidg(int fid) {
		// TODO Auto-generated method stub
		return shbiz.selectByFidg(fid);
	}
	//卡
	@Override
	public String addcard(card z) {
		// TODO Auto-generated method stub
		return cabiz.addcard(z);
	}

	@Override
	public String removeCard(int cid) {
		// TODO Auto-generated method stub
		return cabiz.removeCard(cid);
	}

	@Override
	public String updateCard(card z) {
		// TODO Auto-generated method stub
		return cabiz.updateCard(z);
	}

	@Override
	public card selectByCid(int cid) {
		// TODO Auto-generated method stub
		return cabiz.selectByCid(cid);
	}
	@Override
	public String addMoney(int cid, int mon) {
		// TODO Auto-generated method stub
		return cabiz.addMoney(cid, mon);
	}
	@Override
	public String deleteMoney(int cid, int mon) {
		// TODO Auto-generated method stub
		return cabiz.deleteMoney(cid, mon);
	}
	//订单
	@Override
	public String addorderr(orderr z) {
		// TODO Auto-generated method stub
		return orbiz.addorderr(z);
	}

	@Override
	public String removeOrderr(int oid) {
		// TODO Auto-generated method stub
		return orbiz.removeOrderr(oid);
	}

	@Override
	public String updateOrderr(orderr z) {
		// TODO Auto-generated method stub
		return orbiz.updateOrderr(z);
	}

	@Override
	public orderr selectByOid(int oid) {
		// TODO Auto-generated method stub
		return orbiz.selectByOid(oid);
	}
	@Override
	public ArrayList<orderr> Allorderr() {
		// TODO Auto-generated method stub
		return orbiz.Allorderr();
	}
	//订单项表
	@Override
	public String addorderit(orderit z) {
		// TODO Auto-generated method stub
		return ordbiz.addorderit(z);
	}

	@Override
	public String removeorderit(int oid) {
		// TODO Auto-generated method stub
		return ordbiz.removeorderit(oid);
	}

	@Override
	public String updateOrderit(orderit z) {
		// TODO Auto-generated method stub
		return ordbiz.updateOrderit(z);
	}

	@Override
	public orderit selectOid(int oid) {
		// TODO Auto-generated method stub
		return ordbiz.selectOid(oid);
	}
	//会员
	@Override
	public String addmem(mem_lin z) {
		// TODO Auto-generated method stub
		return membiz.addmem(z);
	}

	@Override
	public String removeMem(int cid) {
		// TODO Auto-generated method stub
		return membiz.removeMem(cid);
	}

	@Override
	public String updateMem(mem_lin z) {
		// TODO Auto-generated method stub
		return membiz.updateMem(z);
	}

	@Override
	public mem_lin selectHyCid(int cid) {
		// TODO Auto-generated method stub
		return membiz.selectHyCid(cid);
	}
	//登录
	@Override
	public work findByEidAndEpassword(work z) {
		// TODO Auto-generated method stub
		return wbiz.findByEidAndEpassword(z);
	}
	@Override
	public void qingli() {
		shbiz.qingli();
		
	}
	
	
	@Override
	public void qinglidd() {
		orbiz.qinglidd();
		
	}
	
	
	

	
	
}
