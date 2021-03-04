package swing.study.component;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;

import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JRadioButtonEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "사과.jpg"),
			new ImageIcon(imgPath + "배.jpg"),
			new ImageIcon(imgPath + "체리.jpg")
	};
	private JLabel lblimg;
	
	public JRadioButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("라디오 버튼 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 10, 0));
		
		JPanel pLeft = new JPanel();
		pLeft.setBorder(new TitledBorder(null,"간단한 라디오버튼", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton pRadio = new CustomRadioButton();
		pLeft.add(pRadio);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(null, "응용 예제", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pRight);
		pRight.setLayout(new BorderLayout(0, 0));
		
		CustomRadioButton panel = new CustomRadioButton();
		pRight.add(panel, BorderLayout.NORTH);
		
		lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		pRight.add(lblimg, BorderLayout.CENTER);
		
		//리스너 달기 각각 라디오 버튼에다가
			for(JRadioButton r : panel.getRdBtns()) {
				r.addItemListener(this);
				
				
			}
			panel.getRdbtnApple().setSelected(true); // 사과를 기본선택으로 하기
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		JRadioButton rd = (JRadioButton) e.getSource();
		
		if(e.getStateChange() == ItemEvent.SELECTED) {   //해당되는게 선택되었을때만 보여주겠다.
//		JOptionPane.showMessageDialog(null, rd.getText());
			String text = rd.getText();
			switch(text) {
			case "사과" :
				lblimg.setIcon(icons[0]);
				break;
			case "배" :
				lblimg.setIcon(icons[1]);
				break;
				default:
//			case "체리" :
				lblimg.setIcon(icons[2]);
				break;
		}
	}

	}}
