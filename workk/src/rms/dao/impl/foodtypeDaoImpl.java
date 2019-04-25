package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.foodtype;
import com.chinasofti.yahui.domain.work;

import rms.dao.foodtypeDao;
import rms.util.DBUtil;

public class foodtypeDaoImpl implements foodtypeDao{
	// 创建dbutil变量
		private DBUtil db;

	@Override
	public boolean addFoodtype(foodtype z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into foodtype values(?,?)";
		try {
			int i = this.db.update(sql, z.getFtid(), z.getFtname());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
		
	}

	@Override
	public foodtype selectByFtid(int ftid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from foodtype where ftid=" + ftid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new foodtype(rs.getInt("ftid"),rs.getString("ftname") );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean deleteFoodtype(int ftid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from foodtype where ftid=" + ftid;
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
	public boolean updateFoodtype(foodtype z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update foodtype set ftname=? where ftid=?";
		try {
			int i = this.db.update(sql,z.getFtname(),z.getFtid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

}
