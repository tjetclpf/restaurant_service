package rms.biz;

import com.chinasofti.yahui.domain.shop;

public interface shopBiz {
	//添加购物车
	public String addShop(shop z);
	//删除购物车
	public String removeShop(int fid);
	//修改购物车
	public String updateShop(shop z);
	//查询购物车
	public shop selectByFidg(int fid);
	//清理表
	public void qingli();
}
