package rms.domain;

import java.io.Serializable;

public class work implements Serializable{
	private int eid;
	private int ejob;
	private String ename;
	private String epassword;
	
	public work() {
		super();
	}
	
	public work(int eid,int ejob,String ename,String epassword) {
		super();
		this.eid = eid;
		this.ejob = ejob;
		this.epassword = epassword;
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getEjob() {
		return ejob;
	}

	public void setEjob(int ejob) {
		this.ejob = ejob;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

}