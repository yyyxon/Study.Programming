package day1004;

public class TestVO {
	private String img, info, url;
	
	public TestVO(String img, String info, String url) {
		super();
		this.img = img;
		this.info = info;
		this.url = url;
	}

	public TestVO() {
		super();
	}

	public String getImg() {
		return img;
	}

	public String getInfo() {
		return info;
	}

	public String getUrl() {
		return url;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "TestVO [img=" + img + ", info=" + info + ", url=" + url + "]";
	}

}
