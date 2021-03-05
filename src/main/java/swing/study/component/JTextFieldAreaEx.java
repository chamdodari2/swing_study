package swing.study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class JTextFieldAreaEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfName;
	private JPasswordField pfPass1;
	private JPasswordField pfPass2;
	private JTextArea ta;
	JLabel lblConfirm;
	private JDateChooser dateChooser; ////
	private JButton btnAdd;
	private JButton btnCancel;

	public JTextFieldAreaEx() {
		initialize();
	}

	private void initialize() {
		setTitle("텍스트 필드");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pCenter.add(scrollPane, BorderLayout.CENTER);

		ta = new JTextArea();
		ta.setEditable(false);
		scrollPane.setViewportView(ta);

		JPanel pNorth = new JPanel();
		pNorth.setPreferredSize(new Dimension(450, 250));
		pNorth.setBorder(new EmptyBorder(10, 20, 10, 20));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblName);
////////////////////////////////////////////////////////////////////////////
		tfName = new JTextField();   //필드에 선언된 변수 tfName텍스트 필드 생성(객체화) (아래칸)
//		tfName.addActionListener(this); /// 얘 지워줘야한다  누르면 리스트가 생긴다? 
		pNorth.add(tfName);  //얘느 ㄴㄴ   //성명칸에 추가()
		tfName.setColumns(10);

		JLabel lblPass1 = new JLabel("비밀번호");
		lblPass1.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass1);

		pfPass1 = new JPasswordField();
		pfPass1.getDocument().addDocumentListener(listener);
		pfPass1.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(pfPass1);

		JLabel lblPass2 = new JLabel("비밀번호 확인");
		lblPass2.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblPass2);

		pfPass2 = new JPasswordField();
		pfPass2.getDocument().addDocumentListener(listener);

		pfPass2.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(pfPass2); 

		JPanel panel = new JPanel();
		pNorth.add(panel);

		lblConfirm = new JLabel("");
		lblConfirm.setFont(new Font("굴림", Font.BOLD, 12));
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.RED);

		pNorth.add(lblConfirm);

		JLabel lblBirth = new JLabel("생년월일");
		lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		pNorth.add(lblBirth);

		dateChooser = new JDateChooser(new Date()); // 오늘날짜루 기본 설정하기
		pNorth.add(dateChooser);

		btnAdd = new JButton("추가"); //추가버튼 생성
		btnAdd.addActionListener(this);  //추가버튼에 액션리스너 -추가버튼을 누르면리스트가 생긴다?
		pNorth.add(btnAdd);		

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);  //캔슬버튼을 누르면 리스트가 생긴다? 읽어온다?
		pNorth.add(btnCancel);
	}

	public void actionPerformed(ActionEvent e) {  //버튼을 누르면 어떤 기능?
		if (e.getSource() == btnCancel) {  // 이벤트를 발생시킨 객체의 위치값을 가져오는데, 그게 취소버튼이면
			actionPerformedBtnCancel(e);  //해당메서드 호출
		}
		if (e.getSource() == btnAdd) {//추가버튼이면 해당메서드 호출
			actionPerformedBtnAdd(e);
		}
//		if (e.getSource() == tfName) {   얘가 필요없어졌으니까 밑에 메소드내용도 삭제하기 (네임에 입력했으면)
//			actionPerformedTfName(e);
//		}
	}

//	protected void actionPerformedTfName(ActionEvent e) {  //얘두 삭제
//		if (tfName.getText().length() != 0) { // 입력한 길이가 한글자 이상이면
//			// if(pfPass1.getText() ==pfPass2.getText()) {
//
////			Date d = dateChooser.getDate(); 
////			String msg = String.format("%s - %tF%n",tfName.getText(),d);
////			ta.append(msg);
//
////			ta.append(tfName.getText() + "\n");
//			tfName.setText(""); // 칸 클리어
//		}
//	}

	// }
	protected void actionPerformedBtnAdd(ActionEvent e) {  //추가버튼 누르면 실행
		if (lblConfirm.getText().equals("일치")) { //일치한다고 뜨면 실행시킬것들
			Date d = dateChooser.getDate();  //오늘날짜를 가져온다.
			String msg = String.format("%s - %tF%n", tfName.getText(), d); //성명의 텍스트를 가져온다.
			ta.append(msg);  //가져온걸 ta에 넣는다.
			clearTf();

		} else {
			pfPass2.setText("");
			pfPass2.requestFocus();
			pfPass1.selectAll();

		}

	}

	public void clearTf() {

		tfName.setText("");
		pfPass1.setText("");
		pfPass2.setText("");
		dateChooser.setDate(new Date());
		lblConfirm.setText("");
		tfName.requestFocus();
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clearTf();
	}

	DocumentListener listener = new DocumentListener() {
		@Override // 삭제되거나 추가되거나 변경될떄 각각 호출되는것. 우리는 하나의 메소드로 통일할꺼임
		public void removeUpdate(DocumentEvent e) {
			getMessage();

		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			getMessage();

		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			getMessage();

		}

		private void getMessage() { // 뭘 누르던간에 얘가 호출된다.
			String pw1 = new String(pfPass1.getPassword());
			String pw2 = String.valueOf(pfPass2.getPassword());
			if (pw1.equals(pw2)) {
				lblConfirm.setText("일치");

			} else {
				lblConfirm.setText("불일치");

			}

		}

	};
}