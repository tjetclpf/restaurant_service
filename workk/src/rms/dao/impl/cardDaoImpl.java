package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.food;

import rms.dao.cardDao;
import rms.util.DBUtil;

public class cardDaoImpl implements cardDao{
	// 创建dbutil变量
		private DBUtil db;
	@Override
	public boolean addcard(card z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into card values(?,?,?,?,?,?)";
		try {
			int i = this.db.update(sql, z.getCid(), z.getCname(),z.getCpassword(), z.getVip(),z.getMon(),z.getDj());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
		
	}
	@Override
	public boolean deletecard(int cid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from card where cid=" + cid;
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
	public boolean updatecard(card z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update card set cname=?,cpassword=?,vip=?,mon=?,dj=? where cid=?";
		try {
			int i = this.db.update(sql,z.getCname(),z.getCpassword(),z.getVip(),z.getMon(),z.getDj(),z.getCid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}
	@Override
	public card selectByCid(int cid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from card where cid=" + cid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new card(rs.getInt("cid"),rs.getString("cname") ,rs.getInt("cpassword"), rs.getInt("vip"),rs.getInt("mon"), rs.getInt("dj"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	}
		return null;
	
	}
	@Override
	public int addMoney(int cid, int mon) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		int i=0;
		String sql = "update card set mon=(?+(select mon from card where cid=?)) where cid=?";
		try {
			 i = this.db.update(sql,mon,cid,cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int deleteMoney(int cid, int mon) {
		// 实例化dbutil对象
				this.db = new DBUtil();
				// 创建sql语句
				int i=0;
				String sql = "update card set mon=((select mon from card where cid=?)-?) where cid=?";
				try {
					 i = this.db.update(sql,cid,mon,cid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return i;
	}
}