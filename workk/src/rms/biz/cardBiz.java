package rms.biz;

import com.chinasofti.yahui.domain.card;

public interface cardBiz {
	//添加卡
	public String addcard(card z);
	//删除卡
	public String removeCard(int cid);
	//修改卡
	public String updateCard(card z);
	//查询卡
	public card selectByCid(int cid);
	//加钱
	public String addMoney(int cid, int mon);
	//减钱
	public String deleteMoney(int cid,int mon);
}
