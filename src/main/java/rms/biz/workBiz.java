package rms.biz;

import rms.domain.work;

public interface workBiz {
    //添加职工
	public String addMan(work z);
	//删除职工
	public String removeMan(int eid);
	//修改职工
	public String updateMan(work z);
	//查询员工
	public work selectByEid(int eid);
	/*
	public List<work> AllEmp();
	*/
	
}
