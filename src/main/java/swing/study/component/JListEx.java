package swing.study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JListEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private String imgPath = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	
	private ImageIcon[] icons = {
			new ImageIcon(imgPath + "집.png"),
			new ImageIcon(imgPath + "돋보기.png"),
			new ImageIcon(imgPath + "와이파이.png"),
			new ImageIcon(imgPath + "열쇠.png")
	};
	
	//밑에꺼 가져오기
	private String[] fruits = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
	private JButton btn01;
	private JList<String> strList;
	//가져오기끝
	public JListEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JList 예제1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
//		JList strList = new JList(); 얘는 밑에 다시 수정해서 적어준다
//		strList.setModel(new AbstractListModel() {   위로 올린다!!!
//			String[] values = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
		
		//추가1
//		JList<String> strList = new JList<>(fruits);  //UI에서 안된다.  (생성해서 바로집어넣는거 윈도우빌드에서는 아직 구현안됐다) 밑에두줄로 수정!
		strList = new JList<>();
		strList.setListData(fruits);  //이거까지 적어줘야한다
		//추가1끝		
		contentPane.add(strList);
	////////////////////////////////////////////////////////////	
		//이미지넣기??? 놓침
		JList <ImageIcon>  list = new JList<>();
		list.setListData(icons);
		//////////이미지넣기 수정끝
		contentPane.add(list);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btn01 = new JButton("첫리스트 선택확인");
		btn01.addActionListener(this);
		pBtns.add(btn01);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		int idx = strList.getSelectedIndex();  //인덱스 가져오기
		String selStr = strList.getSelectedValue();
		List<String> selededList =strList.getSelectedValuesList();
		String messag = String.format("index : %d%n selectedValue : %s%n selectedList  : %s",
				idx ,selStr, selededList);
	
		JOptionPane.showMessageDialog(null,messag);
	}
}
