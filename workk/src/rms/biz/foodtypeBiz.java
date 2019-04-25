package rms.biz;

import java.util.ArrayList;

import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.work;

public interface foodtypeBiz {
	//添加菜品类
	public String addFoodtype(foodtype z);
	//查询菜品类
	public foodtype selectByFtid(int ftid);
	//删除菜品类
	public String removeFoodtype(int ftid);
	//修改菜品类
	public String updateFoodtype(foodtype z);

}
