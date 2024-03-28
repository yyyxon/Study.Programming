package day0707;

public class WorkVO {
	
	private int number;
	private String name;
	private int javaScore;
	private int oracleScore;
	
	public WorkVO() {
	}
	
	@Override
	public String toString() {
		return name + javaScore + oracleScore;
	}

	public WorkVO(int number, String name, int javaScore, int oracleScore) {
		this.number = number;
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getJavaScore() {
		return javaScore;
	}
	
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	
	public int getOracleScore() {
		return oracleScore;
	}
	
	public void setOracleScore(int oracleScore) {
		this.oracleScore = oracleScore;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
