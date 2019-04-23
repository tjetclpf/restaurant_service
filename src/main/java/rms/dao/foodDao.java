package rms.dao;

import rms.domain.food;

public interface foodDao {
	//菜品编号查询的方法
	public food selectByFid(int fid);
	//添加菜品的方法
	public boolean addFood(food z);
	//删除菜品的方法
	public boolean deleteFood(int fid);
	//修改菜品的方法
	public boolean updateFood(food z);
}
