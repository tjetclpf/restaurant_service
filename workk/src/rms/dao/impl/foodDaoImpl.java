package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.food;
import com.chinasofti.yahui.domain.work;

import rms.dao.foodDao;
import rms.util.DBUtil;

public class foodDaoImpl implements foodDao {
	// 创建dbutil变量
	private DBUtil db;

	@Override
	public boolean addFood(food z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into food values(?,?,?,?,?,?)";
		try {
			int i = this.db.update(sql, z.getFid(), z.getFtid(),z.getFname(), z.getFprice(),z.getStock(),z.getSpc_food());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public food selectByFid(int fid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from food where fid=" + fid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new food(rs.getInt("fid"),rs.getInt("ftid") ,rs.getString("fname"), rs.getDouble("fprice"),rs.getInt("stock"), rs.getString("spc_food"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean deleteFood(int fid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from food where fid=" + fid;
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
	public boolean updateFood(food z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update food set ftid=?,fname=?,fprice=?,stock=?,spc_food=? where fid=?";
		try {
			int i = this.db.update(sql,z.getFtid(),z.getFname(),z.getFprice(),z.getStock(),z.getSpc_food(),z.getFid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<food> selectAll() {
		// 实例化dbutil对象
				this.db = new DBUtil();
				// 创建sql语句
				String sql = "select * from food" ;
				try {
					ResultSet rs = this.db.query(sql);
					ArrayList<food> list=new ArrayList<food>();
					while (rs.next()) {
						list.add(new food(rs.getInt("fid"),rs.getInt("ftid") ,rs.getString("fname"), rs.getDouble("fprice"),rs.getInt("stock"), rs.getString("spc_food")));
					}
					return list;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
}
