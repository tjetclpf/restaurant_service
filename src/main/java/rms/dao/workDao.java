package rms.dao;

import rms.domain.work;

public interface workDao {
	//员工编号查询的方法
	public work selectByEid(int eid);
	//添加员工的方法
	public boolean addMan(work z);
	//删除员工的方法
	public boolean deleteMan(int eid);
	//修改员工的方法
	public boolean updateMan(work z);
}
