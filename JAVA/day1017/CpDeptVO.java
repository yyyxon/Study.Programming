package day1017;

public class CpDeptVO {
	
	private int deptno;
	private String dname, loc, name;
	
	public CpDeptVO() {

	}
	
	public CpDeptVO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public CpDeptVO(String name, String dname, String loc) {
		super();
		this.name = name;
		this.dname = dname;
		this.loc = loc;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	public String getLoc() {
		return loc;
	}
	
	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "CpDeptVO [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
}
