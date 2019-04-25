package rms.dao;

import com.chinasofti.yahui.domain.card;

public interface cardDao {
	//添加卡的方法
	public boolean addcard(card z);
	//删除卡的方法
	public boolean deletecard(int cid);
	//修改卡的方法
	public boolean updatecard(card z);
	//卡编号查询的方法
	public card selectByCid(int cid);
	//充值
	public int addMoney(int cid,int mon);
	//刷钱
	public int deleteMoney(int cid,int mon);
}
