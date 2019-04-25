package rms.dao;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.work;

public interface workDao {
	//员工编号查询的方法
	public work selectByEid(int eid);
	//添加员工的方法
	public boolean addMan(work z);
	//删除员工的方法
	public boolean deleteMan(int eid);
	//修改员工的方法
	public boolean updateMan(work z);
	//查询所有员工的方法
	public ArrayList<work> selectAll();
	//
	public work find(work z);
}
