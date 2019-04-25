package rms.biz;

import com.chinasofti.yahui.domain.orderit;

public interface orderitBiz {
	//添加订单项表
	public String addorderit(orderit z);
	//删除订单项表
	public String removeorderit(int oid);
	//修改订单项表
	public String updateOrderit(orderit z);
	//查询订单项表
	public orderit selectOid(int oid);
}
