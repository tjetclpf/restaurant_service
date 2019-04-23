 package rms.biz.impl;

import rms.dao.impl.workDaoImpl;

import rms.domain.work;

import rms.biz.workBiz;
import rms.dao.workDao;
import rms.dao.impl.workDaoImpl;
import rms.domain.work;

public class workBizImpl implements workBiz{
	private workDao dao;
	
	public workBizImpl() {
		super();
		this.dao = new workDaoImpl();
	}

	@Override
	public String addMan(work z) {
		// 查询id是否已经存在
		work c = this.dao.selectByEid(z.getEid());
		if (c != null) {
			return "添加的员工id已存在";
		}

		return this.dao.addMan(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeMan(int eid) {
		// TODO Auto-generated method stub
		return this.dao.deleteMan(eid) ? "删除成功" : "删除失败";
	}

	@Override
	public work selectByEid(int eid) {
		work c = this.dao.selectByEid(eid);
		return c;
	}

	@Override
	public String updateMan(work z) {
		return this.dao.updateMan(z) ? "修改成功" : "修改失败";
	}


}

