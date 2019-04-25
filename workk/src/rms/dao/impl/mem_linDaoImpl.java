package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.yahui.domain.mem_lin;
import com.chinasofti.yahui.domain.orderit;

import rms.dao.mem_linDao;
import rms.util.DBUtil;

public class mem_linDaoImpl implements mem_linDao{
	// 创建dbutil变量
			private DBUtil db;
	@Override
	public mem_lin selectByCid(int cid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from mem_lin where cid=" + cid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new mem_lin(rs.getInt("cid"),rs.getInt("vip") ,rs.getInt("pre_quo"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean addMem_lin(mem_lin z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into mem_lin values(?,?,?)";
		try {
			int i = this.db.update(sql, z.getCid(), z.getVip(),z.getPre_quo());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteMem_lin(int cid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from mem_lin where cid=" + cid;
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
	public boolean updateMem_lin(mem_lin z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update mem_lin set vip=?,pre_quo=? where cid=?";
		try {
			int i = this.db.update(sql,z.getVip(),z.getPre_quo(),z.getCid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

}
