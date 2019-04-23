package rms.biz;

import rms.domain.shop;

public interface shopBiz {
	    //购物车添加
		public String addShop(shop z);
		//购物车删除
		public String removeShop(int fid);
		//购物车修改
		public String updateShop(shop z);
		//购物车查询
		public shop selectByFid(int fid);
}
