package swing.study.component;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class JComboBoxEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmb;  //이미지아이콘
	private JLabel lblImg;
	private String imgPath = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	
	private Map<String,ImageIcon> map = new HashMap<String, ImageIcon>();  //키와 벨류를 가지는 맵 생성
	
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "사과.jpg"),
			new ImageIcon(imgPath + "배.jpg"),
			new ImageIcon(imgPath + "체리.jpg")
	};
	
	private String[] fruits = {"apple","pear","cherry"};
	
	public JComboBoxEx2() {  //맵에다가 풋한거. 
		for(int i = 0; i<icons.length; i++)
		map.put(fruits[i], icons[i]);
		initialize();
	}
	private void initialize() {
		setTitle("JComboBox 이벤트예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
//		JPanel pNorth = new JPanel();
//		contentPane.add(lblImg, BorderLayout.NORTH);
		
		cmb = new JComboBox<>();  //꺽쇠쓰 추가
		cmb.setModel(new DefaultComboBoxModel<String>(fruits));
		cmb.setSelectedIndex(-1);
		cmb.addActionListener(this);
		
				
		contentPane.add(cmb, BorderLayout.NORTH);
		
		lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblImg, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cmb) {
			actionPerformedCmb(e);
		}
	}
	protected void actionPerformedCmb(ActionEvent e) {
	Object obj = cmb.getSelectedItem();
	lblImg.setIcon(map.get(obj));  //String값 가져와서  아이콘이 나오게하기
		
	}
}
