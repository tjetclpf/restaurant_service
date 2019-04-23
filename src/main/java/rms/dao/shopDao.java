package rms.dao;

import rms.domain.shop;

public interface shopDao {
	//购物车fid查询的方法
	public shop selectByFid(int fid);
	//购物车添加方法
	public boolean addShop(shop z);
	//购物车删除的方法
	public boolean deleteShop(int fid);
	//购物车修改的方法
	public boolean updateShop(shop z);
}
