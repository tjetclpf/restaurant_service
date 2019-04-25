package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.yahui.domain.orderit;
import com.chinasofti.yahui.domain.work;

import rms.dao.orderitDao;
import rms.util.DBUtil;

public class orderitDaoImpl implements orderitDao{
	// 创建dbutil变量
		private DBUtil db;
	
	@Override
	public orderit selectByOid(int oid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from order where oid=" + oid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new orderit(rs.getInt("oid"),rs.getInt("fid") ,rs.getInt("onumber"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return null;
	}

	@Override
	public boolean addOrderit(orderit z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into orderit values(?,?,?)";
		try {
			int i = this.db.update(sql, z.getOid(), z.getFid(),z.getOnumber());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteOrderit(int oid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from orderit where oid=" + oid;
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
	public boolean updateOrderit(orderit z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update orderit set fid=?,onumber=? where oid=?";
		try {
			int i = this.db.update(sql,z.getClass(),z.getOnumber(),z.getOid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}
	
}
