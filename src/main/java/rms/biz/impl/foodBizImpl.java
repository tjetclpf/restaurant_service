package rms.biz.impl;

import rms.biz.foodBiz;
import rms.dao.foodDao;
import rms.dao.impl.foodDaoImpl;
import rms.domain.food;

public class foodBizImpl implements foodBiz{
	private foodDao dao;
	
	public foodBizImpl() {
		super();
		this.dao = new foodDaoImpl();
	}

	@Override
	public String addFood(food z) {
		// 查询id是否已经存在
		food c = this.dao.selectByFid(z.getFid());
		if (c != null) {
			return "添加的菜品id已存在";
		}

		return this.dao.addFood(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeFood(int fid) {
		// TODO Auto-generated method stub
		return this.dao.deleteFood(fid) ? "删除成功" : "删除失败";
	}

	@Override
	public food selectByFid(int fid) {
		food c = this.dao.selectByFid(fid);
		return c;
	}

	@Override
	public String updateFood(food z) {
		return this.dao.updateFood(z) ? "修改成功" : "修改失败";
	}


}
