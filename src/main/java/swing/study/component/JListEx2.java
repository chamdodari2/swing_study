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
	//수정1  !!!!
	private JList<String> nameList;
	private ArrayList<String> stdList = new ArrayList<>();
	private JList<String> nameList2;
	///수정1 end
	public JListEx2() {
		///수정2
		stdList.add("김인환");   //셀렉트했다고보는거
		stdList.add("이태훈");
		stdList.add("김산건");
		stdList.add("전수린");
		//수정3 2 end
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
		///수정3 어레이리스트를 벡터로 변환하기
		nameList = new JList<>();
		nameList.setListData(new Vector<String>(stdList));
		//nameList.setFixedCellHeight(100);
		///////
		nameList.setVisibleRowCount(5);
		scrollPane.setViewportView(nameList);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pList.add(scrollPane_1);
		
		nameList2 = new JList();
		
		//추가1
		nameList2.setModel(getModel(stdList));	   //getModel 메소드 추가	 (내가 원하는 리스트를 선택하면 보여주는기능(?))
		//추가1끝
		scrollPane_1.setViewportView(nameList2); 
		
		
	}

	private ListModel<String> getModel(List<String> stdList) {  //미리만들어논게 있다. 디폴트 테이블모델이랑
		DefaultListModel<String> model = new DefaultListModel<String>();
		for(String e : stdList) {
		model.addElement(e);
		}
		return model;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfValue) {
			actionPerformedTfValue(e);
		}
	}
	protected void actionPerformedTfValue(ActionEvent e) {  //우측화면에도 왼쪽과 똑같이 실시간으로 보이게하기
		String value = tfValue.getText().trim();
//		JOptionPane.showMessageDialog(null,value);
		
		stdList.add(value);
		nameList.setListData(new Vector<String>(stdList));   //새로 백터를 만들어서 추가한거임
		tfValue.setText("");
		tfValue.requestFocus();
		
		DefaultListModel model = (DefaultListModel<String>)nameList2.getModel();  
		model.addElement(value);
	}
}
