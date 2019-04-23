package rms.biz.impl;

import rms.biz.shopBiz;
import rms.dao.shopDao;
import rms.dao.impl.shopDaoImpl;
import rms.domain.shop;

public class shopBizImpl implements shopBiz{
	private shopDao dao;
	
	public shopBizImpl() {
		super();
		this.dao = new shopDaoImpl();
	}

	@Override
	public String addShop(shop z) {
		// 查询id是否已经存在
		shop c = this.dao.selectByFid(z.getFid());
		if (c != null) {
			return "fid购物车已存在";
		}

		return this.dao.addShop(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeShop(int fid) {
		// TODO Auto-generated method stub
		return this.dao.deleteShop(fid) ? "删除成功" : "删除失败";
	}

	@Override
	public shop selectByFid(int fid) {
		shop c = this.dao.selectByFid(fid);
		return c;
	}

	@Override
	public String updateShop(shop z) {
		return this.dao.updateShop(z) ? "修改成功" : "修改失败";
	}


}
