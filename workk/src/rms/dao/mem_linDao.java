package rms.dao;

import com.chinasofti.yahui.domain.mem_lin;

public interface mem_linDao {
	//会员查询的方法
	public mem_lin selectByCid(int cid);
	//添加会员的方法
	public boolean addMem_lin(mem_lin z);
	//删除会员的方法
	public boolean deleteMem_lin(int cid);
	//修改会员的方法
	public boolean updateMem_lin(mem_lin z);
}
