package day0706;

public class WorkVO {
	
	private String name;
	private int java;
	private int oracle;
	
	public WorkVO() {
		//기본 생성자
	}
	
	@Override
	public String toString() {
		return name + "\t" + java + "\t" + oracle + "\t" + (java+oracle);
	}
	
	public WorkVO(String[] dataArr) {
		this.name = dataArr[0];
		this.java = Integer.parseInt(dataArr[1]);
		this.oracle = Integer.parseInt(dataArr[2]);
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public String getName() {
		return name;
	}

	public int getJava() {
		return java;
	}

	public int getOracle() {
		return oracle;
	}

}
