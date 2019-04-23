package rms.biz;

import rms.domain.food;

public interface foodBiz {
	//添加菜品
	public String addFood(food z);
	//删除菜品
	public String removeFood(int fid);
	//修改菜品
	public String updateFood(food z);
	//查询菜品
	public food selectByFid(int fid);
}
