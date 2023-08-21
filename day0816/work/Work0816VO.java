package day0816.work;

public class Work0816VO {
	
	private int num;
	private String name;
	private String img;
	private int age;
	
	public Work0816VO() {
		super();
	}
	
	public Work0816VO(int num, String name, String img, int age) {
		super();
		this.num = num;
		this.name = name;
		this.img = img;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Work0816VO [num=" + num + ", name=" + name + ", img=" + img + ", age=" + age + "]";
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
