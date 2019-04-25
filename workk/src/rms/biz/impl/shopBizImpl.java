package rms.biz.impl;

import com.chinasofti.yahui.domain.shop;

import rms.biz.shopBiz;
import rms.dao.shopDao;
import rms.dao.impl.shopDaoImpl;

public class shopBizImpl implements shopBiz{
	private shopDao shdao;
	
	public shopBizImpl() {
		super();
		this.shdao=new shopDaoImpl();
	}

	@Override
	public String addShop(shop z) {
		// 查询id是否已经存在
		shop c = this.shdao.selectByFidg(z.getFid());
		if (c != null) {
			return "添加的菜品id已存在";
		}
		return this.shdao.addShop(z) ? "添加成功!" : "添加失败!";
		
	}

	@Override
	public String removeShop(int fid) {
		return this.shdao.deleteShop(fid) ? "删除成功" : "删除失败";
	
	}

	@Override
	public String updateShop(shop z) {
		return this.shdao.updateShop(z) ? "修改成功" : "修改失败";
		
	}

	@Override
	public shop selectByFidg(int fid) {
		shop c = this.shdao.selectByFidg(fid);
		return c;
		
	}

	@Override
	public void qingli() {
		this.shdao.qingli();
		
	}
	
}
