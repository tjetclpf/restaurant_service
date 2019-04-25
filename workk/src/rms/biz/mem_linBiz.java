package rms.biz;

import com.chinasofti.yahui.domain.mem_lin;

public interface mem_linBiz {
	//添加会员
	public String addmem(mem_lin z);
	//删除会员
	public String removeMem(int cid);
	//修改会员
	public String updateMem(mem_lin z);
	//查询会员
	public mem_lin selectHyCid(int cid);
}
