package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.shop;

import rms.dao.shopDao;
import rms.util.DBUtil;

public class shopDaoImpl implements shopDao{
		// 创建dbutil变量
		private DBUtil db;
			
			
	//增加购物车
	@Override
	public boolean addShop(shop z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into shop values(?,?,?,?)";
		try {
			int i = this.db.update(sql, z.getFid(),z.getFname(),z.getFprice(),z.getSnum());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
		
	}


	@Override
	public shop selectByFidg(int fid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from shop where fid=" + fid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new shop(rs.getInt("fid"),rs.getString("fname"),rs.getInt("fprice"),rs.getInt("snum") );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}


	@Override
	public boolean deleteShop(int fid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from shop where fid=" + fid;
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateShop(shop z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update shop set fname=?,fprice=?,snum=? where fid=?";
		try {
			int i = this.db.update(sql,z.getFname(),z.getFprice(),z.getSnum(),z.getFid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
		
	}


	@Override
	public void qingli() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from shop"	;
		try {
			int i = this.db.update(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
