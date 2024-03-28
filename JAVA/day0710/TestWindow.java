package day0710;

import java.awt.Frame;
import java.awt.Window;

@SuppressWarnings("serial")
public class TestWindow extends Window{
	
	public TestWindow(Frame f) {
		super(f);
		f.setSize(400,400);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Frame f = new Frame("나는 프레임");
		new TestWindow(f);
		
	}

}
