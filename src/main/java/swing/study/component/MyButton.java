package swing.study.component;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	private String imgpath = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경
	
	
	
	public MyButton() {
	
		setIcon(new ImageIcon(imgpath+ "전화1.gif"));
		setRolloverIcon(new ImageIcon(imgpath+ "전화1.gif"));
		setPressedIcon(new ImageIcon(imgpath+ "전화2.gif"));
	}

}
