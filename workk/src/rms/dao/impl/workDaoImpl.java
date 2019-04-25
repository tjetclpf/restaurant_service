package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chinasofti.yahui.domain.work;

import rms.dao.workDao;
import rms.util.DBUtil;

public class workDaoImpl implements workDao {
	// 创建dbutil变量
	private DBUtil db;

	@Override
	public boolean addMan(work z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into work values(?,?,?,?)";
		try {
			int i = this.db.update(sql, z.getEjob(), z.getEname(),z.getEpassword(), z.getEid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public work selectByEid(int eid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from work where eid=" + eid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new work(rs.getInt("ejob"),rs.getString("ename") ,rs.getInt("epassword"), rs.getInt("eid"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean deleteMan(int eid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from work where eid=" + eid;
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
	public boolean updateMan(work z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update work set ejob=" + z.getEjob() + "," + "ename'="+z.getEname()+"',"+"epassword=" + z.getEname() + "," + "eid="
				+ z.getEpassword()+ "where eid="+ z.getEid();
		try {
			int i = this.db.update(sql);
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public ArrayList<work> selectAll() {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from work" ;
		try {
			ResultSet rs = this.db.query(sql);
			ArrayList<work> list=new ArrayList<work>();
			while (rs.next()) {
				list.add(new work(rs.getInt("ejob"),rs.getString("ename") ,rs.getInt("epassword"), rs.getInt("eid")));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public work find(work z) {
		// 实例化dbutil对象
			this.db = new DBUtil();
			// 创建sql语句
			String sql = "select * from work where eid=? and epassword=?";
			try {
				ResultSet rs = this.db.query(sql,z.getEid(),z.getEpassword());
				if (rs.next()) {
					work w=new work();
					w.setEname(rs.getString("ename"));
					w.setEjob(rs.getInt("ejob"));
					return w;
				}else {
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
	}

	}
}