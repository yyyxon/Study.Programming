package day0720;

import java.io.Serializable;


//Serializable 상속 받아서 직렬화 가능하도록 변경
public class UserData implements Serializable{

	private static final long serialVersionUID = -3691619400185001598L;
	
	//숨기고싶은 데이터에 transient 예약어 사용 => 직렬화 방지(JVM밖으로 나가지 않는다.)
	private /*transient*/ String name;
	private double height;
	private /*transient*/ double weight; 
	
	public UserData() {
		
	}
	
	public UserData(String name, double height, double weight) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "UserData [name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}

}
