package rms.biz;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.work;

public interface foodBiz {
	//添加菜品
	public String addFood(food z);
	//删除菜品
	public String removeFood(int fid);
	//修改菜品
	public String updateFood(food z);
	//查询菜品
	public food selectByFid(int fid);
	//查询所有菜品
	public ArrayList<food> Allfood();
}
