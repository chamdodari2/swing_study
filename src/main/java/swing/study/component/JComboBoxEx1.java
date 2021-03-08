package swing.study.component;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class JComboBoxEx1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JComboBox<String> cmb1;  //전부 스트링으로
	private JComboBox<String> cmb2;
	private JComboBox<String> cmb3;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;


	public JComboBoxEx1() {
		initialize();  //컴포넌트 초기화하고 데이터 추가하겠다
		
		addDataCmb1();
		addDataCmb2();
		addDataCmb3();
		
	}
	private void addDataCmb1() {
		//단순한 스트링배열
		String[] fruits = {"apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry"};
		
		for(String f : fruits) {  //반복문으로 넣기
			cmb1.addItem(f);
		}
		
	}
	private void addDataCmb2() { //모델로 넣기
		String[] fruits = {"apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry"};
		DefaultComboBoxModel<String> cbm = (DefaultComboBoxModel<String>)cmb2.getModel();
		
		for(String f : fruits) {
			cbm.addElement(f);
		}
		
	}
	private void addDataCmb3() { //그냥 배열로 하면 식상하니까 List로 
		List <String> fruits =  Arrays.asList("apple","banana","kiwi","mango","pear","peach","berry","strawberry","blackberry");
		DefaultComboBoxModel<String> model =  new DefaultComboBoxModel<> (new Vector<>(fruits));  //벡터로 변환 (벡터생성자에 어레이리스트를 집어넣어주면)
		cmb3.setModel(model);
		
	}
	private void initialize() {
		setTitle("JComboBox 기본예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 0));
		
		JPanel pCmb1 = new JPanel();
		contentPane.add(pCmb1);
		
		cmb1 = new JComboBox<>();  //꺽쇠 넣어줘야함
		pCmb1.add(cmb1);
		
		tf1 = new JTextField();
		tf1.addActionListener(this);
		pCmb1.add(tf1);
		tf1.setColumns(10);
		
		JPanel pCmb2 = new JPanel();
		contentPane.add(pCmb2);
		
		cmb2 = new JComboBox<>();
		pCmb2.add(cmb2);
		
		tf2 = new JTextField();
		tf2.addActionListener(this);
		pCmb2.add(tf2);
		tf2.setColumns(10);
		
		JPanel pCmb3 = new JPanel();
		contentPane.add(pCmb3);
		
		cmb3 = new JComboBox<>();
		pCmb3.add(cmb3);
		
		tf3 = new JTextField();
		tf3.addActionListener(this);
		pCmb3.add(tf3);
		tf3.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tf3) {
			actionPerformedTf3(e);
		}
		if (e.getSource() == tf2) {
			actionPerformedTf2(e);
		}
		if (e.getSource() == tf1) {
			actionPerformedTf1(e);
		}
	}
	protected void actionPerformedTf1(ActionEvent e) {
		
		String item = tf1.getText().trim();
		cmb1.addItem(item);
		tf1.setText("");
	}
	protected void actionPerformedTf2(ActionEvent e) {
		
		String item = tf2.getText().trim();
		cmb2.addItem(item);
		tf2.setText("");
	}
	protected void actionPerformedTf3(ActionEvent e) {
		
		String item = tf3.getText().trim();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmb3.getModel();
		model.addElement(item);
		tf3.setText("");
		
	}
}
