package swing.study.component;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JLabelEx1 extends JFrame {

	private JPanel contentPane;


	public JLabelEx1() {
		initialize();
	}
	private void initialize() {
		setTitle("이미지불러오기");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator;
		ImageIcon icon = new ImageIcon(imgPath + "파란꽃.jpg");
		
		
		JLabel lblImg1 = new JLabel(icon);  //아이콘 넣어줘야한다!!!
		contentPane.add(lblImg1);
		
		
		//레이블의 사이즈에 맞춰 이미지 변경
		Image img = icon.getImage();   //받기
		Image changeImg = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);  //이미지를 이 간격에 맞춰서?? (픽셀단위임)
		ImageIcon changeIcon = new ImageIcon(changeImg);  //그럼 위 사이즈에 맞게 이미지가 변경된다
		
		JLabel lblImg2 = new JLabel(changeIcon);
		contentPane.add(lblImg2);
	}

}
