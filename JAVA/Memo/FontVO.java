package day0714.Work;

import java.awt.Font;
import java.io.Serializable;

public class FontVO implements Serializable{
	
	private String fontName;
	private int fontStyle;
	private int fontSize;
	
	public FontVO() {
		fontName = "돋움";
		fontStyle = Font.PLAIN;
		fontSize = 15;
	}
	
	public FontVO(String fontName, int fontStyle, int fontSize) {
		super();
		this.fontName = fontName;
		this.fontStyle = fontStyle;
		this.fontSize = fontSize;
	}
	
	@Override
	public String toString() {
		return "FontVO [fontName=" + fontName + ", fontStyle=" + fontStyle + ", fontSize=" + fontSize + "]";
	}
	

	public String getFontName() {
		return fontName;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public int getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
