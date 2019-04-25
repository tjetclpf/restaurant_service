package rms.dao;

import com.chinasofti.yahui.domain.shop;

public interface shopDao {
	//购物车查询的方法
	public shop selectByFidg(int fid);
	//添加购物车的方法
	public boolean addShop(shop z);
	//删除购物车的方法
	public boolean deleteShop(int fid);
	//修改购物车的方法
	public boolean updateShop(shop z);
	//清理表
	public void qingli();
}
