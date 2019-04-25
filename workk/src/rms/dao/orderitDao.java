package rms.dao;

import com.chinasofti.yahui.domain.orderit;

public interface orderitDao {
		//订单编号查询的方法
		public orderit selectByOid(int oid);
		//添加订单的方法
		public boolean addOrderit(orderit z);
		//删除订单的方法
		public boolean deleteOrderit(int oid);
		//修改订单的方法
		public boolean updateOrderit(orderit z);
}
