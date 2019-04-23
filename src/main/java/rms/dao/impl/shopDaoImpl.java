package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import rms.dao.shopDao;
import rms.domain.shop;
import rms.util.DBUtil;

public class shopDaoImpl implements shopDao {
	// 创建dbutil变量
	private DBUtil db;

	@Override
	public boolean addShop(shop z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into shop values(?,?,?,?)";
		try {
			int i = this.db.update(sql, z.getFid(), z.getFname(),z.getFprice(), z.getSnum());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public shop selectByFid(int fid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from shop where fid=" + fid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new shop(rs.getInt("fid"),rs.getString("fname") ,rs.getDouble("fprice"), rs.getInt("snum"));
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
		String sql = "update shop set fid=" + z.getFid() + "," + "fname='"+z.getFname()+"',"+"fprice=" + z.getFprice() + "," + "snum="
				+ z.getSnum()+ "where fid="+ z.getFid();
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}
}
