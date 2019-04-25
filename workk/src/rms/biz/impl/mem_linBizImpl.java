package rms.biz.impl;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.mem_lin;

import rms.biz.mem_linBiz;
import rms.dao.mem_linDao;
import rms.dao.impl.mem_linDaoImpl;

public class mem_linBizImpl implements mem_linBiz{
	private mem_linDao memdao;

	public mem_linBizImpl() {
		super();
		this.memdao=new mem_linDaoImpl();
	}

	@Override
	public String addmem(mem_lin z) {
		// 查询id是否已经存在
			mem_lin c = this.memdao.selectByCid(z.getCid());
			if (c != null) {
				return "添加的菜品id已存在";
			}
			return this.memdao.addMem_lin(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeMem(int cid) {
		return this.memdao.deleteMem_lin(cid) ? "删除成功" : "删除失败";
	}

	@Override
	public String updateMem(mem_lin z) {
		return this.memdao.updateMem_lin(z) ? "修改成功" : "修改失败";
	}

	@Override
	public mem_lin selectHyCid(int cid) {
		mem_lin c = this.memdao.selectByCid(cid);
		return c;
	}
	
}
