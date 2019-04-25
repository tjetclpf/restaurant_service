package rms.biz;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.work;

public interface workBiz {
    //添加职工
	public String addMan(work z);
	//删除职工
	public String removeMan(int eid);
	//修改职工
	public String updateMan(work z);
	//查询员工
	public work selectByEid(int eid);
	//查询所有员工
	public ArrayList<work> AllMan();
	//登录
	public work findByEidAndEpassword(work z);
	
	
}
