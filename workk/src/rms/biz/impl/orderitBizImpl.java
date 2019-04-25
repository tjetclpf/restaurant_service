package rms.biz.impl;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.orderit;

import rms.biz.orderitBiz;
import rms.dao.orderitDao;
import rms.dao.impl.orderitDaoImpl;

public class orderitBizImpl implements orderitBiz{
	private orderitDao orddao;

	public orderitBizImpl() {
		super();
		this.orddao=new orderitDaoImpl();
	}

	@Override
	public String addorderit(orderit z) {
		// 查询id是否已经存在
			orderit c = this.orddao.selectByOid(z.getOid());
			if (c != null) {
				return "添加的菜品id已存在";
			}
			return this.orddao.addOrderit(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeorderit(int oid) {
		return this.orddao.deleteOrderit(oid) ? "删除成功" : "删除失败";
	}

	@Override
	public String updateOrderit(orderit z) {
		return this.orddao.updateOrderit(z) ? "修改成功" : "修改失败";
	}

	@Override
	public orderit selectOid(int oid) {
		orderit c = this.orddao.selectByOid(oid);
		return c;
	}
	
}
