package rms.dao;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.orderr;

public interface orderrDao {
	//添加订单的方法
	public boolean addorderr(orderr z);
	//删除订单的方法
	public boolean deleteorderr(int oid);
	//修改订单的方法
	public boolean updateorderr(orderr z);
	//订单查询的方法
	public orderr selectByOrderr(int oid);
	//查询所有学生的方法
	public ArrayList<orderr> selectAll();
	public void qinglidd();
}
