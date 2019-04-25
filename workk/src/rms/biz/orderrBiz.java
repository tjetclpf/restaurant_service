package rms.biz;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.orderr;

public interface orderrBiz {
	//添加订单
	public String addorderr(orderr z);
	//删除订单
	public String removeOrderr(int oid);
	//修改订单
	public String updateOrderr(orderr z);
	//查询订单
	public orderr selectByOid(int oid);
	//查询所有订单
	public ArrayList<orderr> Allorderr();
	
	public void qinglidd();
}
