package day0818.work;

public class WorkVO {
	
	private String country;
	private String maker;
	private String model;
	private String car_year;
	private int price;
	private String car_option;
	
	public WorkVO() {
		super();
	}
	
	public WorkVO(String country, String maker, String model, String car_year, int price, String car_option) {
		super();
		this.country = country;
		this.maker = maker;
		this.model = model;
		this.car_year = car_year;
		this.price = price;
		this.car_option = car_option;
	}

	public String getCountry() {
		return country;
	}
	
	public String getMaker() {
		return maker;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getCar_year() {
		return car_year;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getCar_option() {
		return car_option;
	}

	@Override
	public String toString() {
		return "WorkVO [country=" + country + ", maker=" + maker + ", model=" + model + ", car_year=" + car_year
				+ ", price=" + price + ", car_option=" + car_option + "]";
	}
	
}
