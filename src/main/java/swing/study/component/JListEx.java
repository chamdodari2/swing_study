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
	
// start - 상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	private String imgPath = System.getProperty("user.dir") + File.separator + ("images")+File.separator; 
// end - 상대경로 설정하기
	
// start -이미지아이콘 배열에 이미지 담기
	private ImageIcon[] icons = {  
			new ImageIcon(imgPath + "집.png"),
			new ImageIcon(imgPath + "돋보기.png"),
			new ImageIcon(imgPath + "와이파이.png"),
			new ImageIcon(imgPath + "열쇠.png")
	}; 
//	end - 이미지아이콘 배열에 이미지 담기
	
//	start -  스트링 배열에 과일 목록 입력하기  (리스트 가져오기기능에 쓸꺼임)
	private String[] fruits = new String[] {"apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry"};
//	end 	
	private JButton btn01;
//	start -	JList가 String타입의 배열 fruits를  담아올수있게 꺽쇠안에 <String> 추가
	private JList<String> strList;  
//	end	 
	public JListEx() {   
		initialize();
	}
	
// 창이 호출되면 띄울거 
	private void initialize() {  
		setTitle("JList 예제1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();  //패널1
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));    //여기까지는 디자인
//
//		JList strList = new JList(); 얘는 밑에 다시 수정해서 적어준다  -> 
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

//	start - 필드변수 strList에 JList의 객체생성,꺽쇠 붙여주어서  필드에서 정해준 스트링타입으로 받기
		strList = new JList<>();    
//	end	

//	start - 필드에 생성한 String배열 fruits의 문자열들을 리스트에 출력하기  
		strList.setListData(fruits);  //리스트변수명.setListData(가져올 데이터변수명);
//		end					
		//추가1끝		
		contentPane.add(strList);

//	strat - 두번째 리스트에는 이미지배열 데이터 넣기 ()
		JList <ImageIcon>  list = new JList<>();  //두번째 리스트는 필드에 빼지 않았기 때문에 여기서 꺽쇠 붙여주고 생성
		list.setListData(icons);
// end
		contentPane.add(list);
		
		JPanel pBtns = new JPanel();
		contentPane.add(pBtns);
		
		btn01 = new JButton("첫리스트 선택확인");  //해당 버튼을 누르면 액션퍼폼드 호출
		btn01.addActionListener(this);
		pBtns.add(btn01);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	
	//strList에서 선택한 항목이 위치한 인덱스(해당 fruit배열에서의 인덱스)
	protected void actionPerformedBtn01(ActionEvent e) {
		int idx = strList.getSelectedIndex();  //int itx = strList(fruit)가 위치한 인덱스 주소 검색
		String selStr = strList.getSelectedValue(); //String selStr = strList의 데이터를 검색
		List<String> selededList =strList.getSelectedValuesList(); //List<String>seledList = strList의  데이터리스트 검색
		String messag = String.format("index : %d%n selectedValue : %s%n selectedList  : %s",
				idx ,selStr, selededList);//출력방식
	
		JOptionPane.showMessageDialog(null,messag);
	}
}
