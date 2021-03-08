package swing.study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

public class JListEx2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfValue;
//	Start - 좌측,우측 JList를 String타입으로 정해주기
	private JList<String> nameList;
	private JList<String> nameList2;	
//	end
	
//	Start - DB연동했다고 칠 데이터들을 담을  필드변수 stdList를  ArraList<String>타입으로 선언 및 객체생성
	private ArrayList<String> stdList = new ArrayList<>();
//	end
	
	
//	Start - 필드에 선언해놓은 stdList 변수에 학생목록 데이터 입력
	public JListEx2() {
		stdList.add("김인환");   //셀렉트했다고보는거
		stdList.add("이태훈");
		stdList.add("김산건");
		stdList.add("전수린");
// end
		initialize();	
	}
	private void initialize() {
		setTitle("실시간 추가");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("이름 입력 후 <Exnter> 키");
		pNorth.add(lblTitle);
		
		tfValue = new JTextField();
		tfValue.addActionListener(this);
		pNorth.add(tfValue);
		tfValue.setColumns(10);
		
		JPanel pList = new JPanel();
		pList.setBorder(new EmptyBorder(0, 100, 0, 100));
		contentPane.add(pList, BorderLayout.CENTER);
		pList.setLayout(new GridLayout(0, 2, 10, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pList.add(scrollPane);
//	start - 좌측 스트링타입 리스트인  필드변수 nameList 객체생성
		nameList = new JList<>();
//end
		
//  start - 필드변수 namelist에 데이터를 세팅할건데, 스트링타입 벡터로 형변환해서 위의 학생목록이 담긴 stdList에 담긴 데이터들을 셋팅한다.
		nameList.setListData(new Vector<String>(stdList));
// end
		
		//nameList.setFixedCellHeight(100);

///////
		nameList.setVisibleRowCount(5);
		scrollPane.setViewportView(nameList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);
		
		nameList2 = new JList();
		
// start 우측 리스트인 nameList2를 세팅할건데, 모델을 써서 그대로 가져올거다 : getModel을 써서 학생목록을 그대로 가져올거다
		nameList2.setModel(getModel(stdList));	   
//end
		scrollPane_1.setViewportView(nameList2); 
	
		
	}
//start - 새로운 getModel 메소드 생성 (미리 만들어져있는 DefaultListModel, ListModel을 활용) 
	private ListModel<String> getModel(List<String> stdList) {  //매개변수는 String타입의 List인 stdList라는 이름으로 받아올거임
		DefaultListModel<String> model = new DefaultListModel<String>();  //변수 model에 스트링타입의 디폴트리스트모델 객체생성
		for(String e : stdList) { //처음부터 stdList의 끝까지 읽기 반복
		model.addElement(e); //model에 입력
		}
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfValue) {
			actionPerformedTfValue(e);
		}
	}
	//버튼은 누르면 액션이 실행되고, 텍스트필드는 텍스트가 입력하고 엔터치면 액션이 실행된당
	
	
//	start - 텍스트필드에 입력하면 입력받은걸   화면에 추가하기 
	protected void actionPerformedTfValue(ActionEvent e) { 
		String value = tfValue.getText().trim();  //변수 value에  getText와 trim으로 받기!
//		JOptionPane.showMessageDialog(null,value);
		
		stdList.add(value);  //필드에서 만든 학생목록 변수 stdList에 입력받은 값 추가
		nameList.setListData(new Vector<String>(stdList));   //좌측리스트에 세팅데이터 : 변경된 학생목록 stdList를 새로 벡터로 변환해서 추가
		tfValue.setText("");   //텍스트필드 클린
		tfValue.requestFocus(); //새로고침해서 보여줌
//	start - 모델을 통해서 우측화면에도 똑같이 보이게하기.
		DefaultListModel model = (DefaultListModel<String>)nameList2.getModel();  //디폴트리스트모델타입의 변수 model 선언, String타입으로 변환한 nameList2에 getModel메소드 호출  
		model.addElement(value);
		
//end
	}
}
