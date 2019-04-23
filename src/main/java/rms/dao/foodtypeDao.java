package rms.dao;

import rms.domain.foodtype;

public interface foodtypeDao {
	//菜品类别编号查询的方法
	public foodtype selectByFtid(int ftid);
	//添加菜品类别的方法
	public boolean addFoodtype(foodtype z);
	//删除菜品类别的方法
	public boolean deleteFoodtype(int ftid);
	//修改菜品类别的方法
	public boolean updateFoodtype(foodtype z);
}
