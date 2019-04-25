package rms.biz.impl;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.work;

import rms.biz.foodtypeBiz;

import rms.dao.foodtypeDao;
import rms.dao.impl.foodtypeDaoImpl;

public class foodtypeBizImpl implements foodtypeBiz{
	private foodtypeDao fd;
	
	public foodtypeBizImpl() {
		super();
		this.fd=new foodtypeDaoImpl();
	}

	@Override
	public String addFoodtype(foodtype z) {
		// 查询id是否已经存在
		foodtype c = this.fd.selectByFtid(z.getFtid());
		if (c != null) {
			return "添加的菜品id已存在";
		}

		return this.fd.addFoodtype(z) ? "添加成功!" : "添加失败!";
		
	}
		//查询菜品类
	@Override
	public foodtype selectByFtid(int ftid) {
		foodtype c = this.fd.selectByFtid(ftid);
		return c;
	}

	@Override
	public String removeFoodtype(int ftid) {
		return this.fd.deleteFoodtype(ftid) ? "删除成功" : "删除失败";
		
	}

	@Override
	public String updateFoodtype(foodtype z) {
		return this.fd.updateFoodtype(z) ? "修改成功" : "修改失败";
	}
	
}
