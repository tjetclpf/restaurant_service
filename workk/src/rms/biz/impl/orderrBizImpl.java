package rms.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.orderr;
import com.chinasofti.yahui.domain.shop;

import rms.biz.orderrBiz;
import rms.dao.orderrDao;
import rms.dao.impl.orderrDaoImpl;

public class orderrBizImpl implements orderrBiz{
	private orderrDao ordao;

	public orderrBizImpl() {
		super();
		this.ordao=new orderrDaoImpl();
	}

	@Override
	public String addorderr(orderr z) {
		// 查询id是否已经存在
		orderr c = this.ordao.selectByOrderr(z.getOid());
		if (c != null) {
			return "添加的订单id已存在";
		}
		return this.ordao.addorderr(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeOrderr(int oid) {
		return this.ordao.deleteorderr(oid) ? "删除成功" : "删除失败";
	}

	@Override
	public String updateOrderr(com.chinasofti.yahui.domain.orderr z) {
		return this.ordao.updateorderr(z) ? "修改成功" : "修改失败";
	}

	@Override
	public orderr selectByOid(int oid) {
		orderr c = this.ordao.selectByOrderr(oid);
		return c;
	}

	@Override
	public ArrayList<orderr> Allorderr() {
		// TODO Auto-generated method stub
		return this.ordao.selectAll();
	}

	@Override
	public void qinglidd() {
		// TODO Auto-generated method stub
		this.ordao.qinglidd();
	}
	
}
