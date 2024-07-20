package day1017;

import java.util.Date;

public class ProductVO {
	private String img, prdName, info;
	private int price, prdNum;
	private Date inputDate;
	
	public ProductVO() {
		super();
	}

	public ProductVO(String img, String prdName, String info, int price, int prdNum, Date inputDate) {
		super();
		this.img = img;
		this.prdName = prdName;
		this.info = info;
		this.price = price;
		this.prdNum = prdNum;
		this.inputDate = inputDate;
	}

	public String getImg() {
		return img;
	}
	
	public String getPrdName() {
		return prdName;
	}
	
	public String getInfo() {
		return info;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getPrdNum() {
		return prdNum;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}
	
	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	@Override
	public String toString() {
		return "ProductVO [img=" + img + ", prdName=" + prdName + ", info=" + info + ", price=" + price + ", prdNum="
				+ prdNum + ", inputDate=" + inputDate + "]";
	}
	
}
