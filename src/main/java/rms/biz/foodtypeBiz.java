package rms.biz;

import rms.domain.food;
import rms.domain.foodtype;

public interface foodtypeBiz {
	//添加菜品类别
	public String addFoodtype(foodtype z);
	//删除菜品类别
	public String removeFoodtype(int ftid);
	//修改菜品类别
	public String updateFoodtype(foodtype z);
	//查询菜品类别
	public foodtype selectByFtid(int ftid);
}
