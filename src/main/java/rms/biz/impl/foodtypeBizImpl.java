package rms.biz.impl;

import rms.biz.foodtypeBiz;
import rms.dao.foodtypeDao;
import rms.dao.impl.foodtypeDaoImpl;
import rms.domain.foodtype;

public class foodtypeBizImpl implements foodtypeBiz{
	private foodtypeDao dao;
	
	public foodtypeBizImpl() {
		super();
		this.dao = new foodtypeDaoImpl();
	}

	@Override
	public String addFoodtype(foodtype z) {
		// 查询id是否已经存在
		foodtype c = this.dao.selectByFtid(z.getFtid());
		if (c != null) {
			return "添加的菜品类别id已存在";
		}

		return this.dao.addFoodtype(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeFoodtype(int ftid) {
		// TODO Auto-generated method stub
		return this.dao.deleteFoodtype(ftid) ? "删除成功" : "删除失败";
	}

	@Override
	public foodtype selectByFtid(int ftid) {
		foodtype c = this.dao.selectByFtid(ftid);
		return c;
	}

	@Override
	public String updateFoodtype(foodtype z) {
		return this.dao.updateFoodtype(z) ? "修改成功" : "修改失败";
	}
}

