package rms.dao;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.foodtype;

public interface foodtypeDao {
	//添加菜品类
	public boolean addFoodtype(foodtype z);
	//菜品编号查询的方法
	public foodtype selectByFtid(int ftid);
	//删除菜品类的方法
	public boolean deleteFoodtype(int ftid);
	//修改菜品类的方法
	public boolean updateFoodtype(foodtype z);
}
