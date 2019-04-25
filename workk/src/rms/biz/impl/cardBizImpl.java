package rms.biz.impl;

import com.chinasofti.yahui.domain.card;

import rms.biz.cardBiz;
import rms.dao.cardDao;
import rms.dao.impl.cardDaoImpl;


public class cardBizImpl implements cardBiz{
	private cardDao cadao;
	
	public cardBizImpl() {
		super();
		this.cadao=new cardDaoImpl();
	}

	@Override
	public String addcard(card z) {
		// 查询id是否已经存在
		card c = this.cadao.selectByCid(z.getCid());
		if (c != null) {
			return "添加的卡号id已存在";
		}
		return this.cadao.addcard(z) ? "添加成功!" : "添加失败!";
	}

	@Override
	public String removeCard(int cid) {
		return this.cadao.deletecard(cid) ? "删除成功" : "删除失败";
	}

	@Override
	public String updateCard(card z) {
		return this.cadao.updatecard(z) ? "修改成功" : "修改失败";
	}

	@Override
	public card selectByCid(int cid) {
		card c = this.cadao.selectByCid(cid);
		return c;
	}

	@Override
	public String addMoney(int cid, int mon) {
		// TODO Auto-generated method stub
		if(this.cadao.addMoney(cid,mon)>0){
			return "修改成功";
		}else{
			return "修改失败";
		}
		
	}

	@Override
	public String deleteMoney(int cid, int mon) {
		// TODO Auto-generated method stub
				if(this.cadao.deleteMoney(cid,mon)>0){
					return "修改成功";
				}else{
					return "修改失败";
				}
	}

}
