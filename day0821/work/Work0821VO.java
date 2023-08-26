package day0821.work;

import java.sql.Date;

public class Work0821VO {
	
	//private empno, ename, hiredate, sal
	
	private int empno;
	private String ename;
	private Date hiredate;
	private String job;
	private int sal;
	
	public Work0821VO() {
		super();
	}

	public Work0821VO(int empno, String ename, Date hiredate, String job, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.job = job;
		this.sal = sal;
	}

	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public Date getHiredate() {
		return hiredate;
	}
	
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}
	
	public int getSal() {
		return sal;
	}
	
	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Work0821VO [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", job=" + job + ", sal="
				+ sal + "]";
	}
	

}
