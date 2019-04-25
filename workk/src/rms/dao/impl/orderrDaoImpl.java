package rms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.yahui.domain.card;
import com.chinasofti.yahui.domain.orderr;
import com.chinasofti.yahui.domain.work;

import rms.dao.orderrDao;
import rms.util.DBUtil;

public class orderrDaoImpl implements orderrDao{
	// 创建dbutil变量
			private DBUtil db;
	@Override
	public boolean addorderr(orderr z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "insert into orderr values(ss_ss.nextval,ss_ss.nextval,sysdate,?,?,?,?,?)";
		try {
			int i = this.db.update(sql,z.getEid(),z.getAid(), z.getOsum(),z.getOimon(),z.getOomon());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteorderr(int oid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "delete from order where oid=" + oid;
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
	public boolean updateorderr(orderr z) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "update orderr set Uuid=?,Odate=?,Eid=?,Aid=?,Osum=?,Oimon=?,Oomon=? where Oid=?";
		try {
			int i = this.db.update(sql, z.getUuid(),z.getOdate(), z.getEid(),z.getAid(), z.getOsum(),z.getOimon(),z.getOomon(),z.getOid());
			return i > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("出现了错误" + e.getMessage());
			return false;
		}
	}

	@Override
	public orderr selectByOrderr(int oid) {
		// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from orderr where oid=" + oid;
		try {
			ResultSet rs = this.db.query(sql);
			if (rs.next()) {
				return new orderr(rs.getInt("oid"),rs.getString("uuid") ,rs.getDate("odate"), rs.getInt("eid"),rs.getString("aid"), rs.getInt("osum"),rs.getInt("oimon"), rs.getInt("oomon"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
	}
		return null;
	}

	@Override
	public ArrayList<orderr> selectAll() {
	// 实例化dbutil对象
		this.db = new DBUtil();
		// 创建sql语句
		String sql = "select * from orderr" ;
		try {
			ResultSet rs = this.db.query(sql);
			ArrayList<orderr> list=new ArrayList<orderr>();
			while (rs.next()) {
				orderr or=new orderr();
				or.setOid(rs.getInt("oid"));
				or.setUuid(rs.getString("uuid"));
				or.setOdate(rs.getDate("odate"));
				or.setEid(rs.getInt("eid"));
				or.setAid(rs.getString("aid"));
				or.setOsum(rs.getInt("osum"));
				or.setOimon(rs.getInt("oimon"));
				or.setOomon(rs.getInt("oomon"));
				
				list.add(or);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void qinglidd() {
		// TODO Auto-generated method stub
		// 实例化dbutil对象
				this.db = new DBUtil();
				// 创建sql语句
				String sql = "delete from orderr"	;
				try {
					int i = this.db.update(sql);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
