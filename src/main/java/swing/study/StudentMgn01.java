package swing.study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

public class StudentMgn01 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMgn01 frame = new StudentMgn01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentMgn01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 726, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("학적/학생관리 ");
		label.setBounds(12, 5, 702, 35);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 30));
		panel.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(5, 52, 726, 42);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setHgap(30);
		contentPane.add(panel_6);
		
		JLabel label_5 = new JLabel("주야구분");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		panel_6.add(comboBox);
		
		JLabel label_1 = new JLabel("학과 ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_6.add(comboBox_1);
		
		JLabel label_2 = new JLabel("학년 ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_6.add(comboBox_2);
		
		JLabel label_3 = new JLabel("학적구분 ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("굴림", Font.BOLD, 15));
		panel_6.add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_6.add(comboBox_3);
		
		JButton btnNewButton = new JButton("조회 ");
		panel_6.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 144, 319, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(0, 0, 292, 287);
		list.setToolTipText("");
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"아ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_1.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(294, 0, 25, 287);
		panel_1.add(scrollBar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(364, 144, 159, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("주야구분");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 13));
		panel_2.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("주간");
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		JLabel label_6 = new JLabel("학년");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setFont(new Font("굴림", Font.BOLD, 13));
		panel_2.add(label_6);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		panel_2.add(textField);
		
		JLabel label_9 = new JLabel("학번");
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setFont(new Font("굴림", Font.BOLD, 13));
		panel_2.add(label_9);
		
		textField_1 = new JTextField();
		textField_1.setText("18010016");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 117, 106, 28);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("▼ 학생 목록");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(365, 117, 106, 28);
		contentPane.add(panel_4);
		
		JLabel label_4 = new JLabel("▼ 상세 정보 ");
		label_4.setFont(new Font("굴림", Font.BOLD, 15));
		panel_4.add(label_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(364, 236, 337, 28);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("생년월일");
		lblNewLabel_2.setBounds(0, 0, 80, 28);
		panel_5.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(79, 4, 255, 21);
		panel_5.add(textField_3);
		textField_3.setText("980920");
		textField_3.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(539, 144, 159, 90);
		contentPane.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_7 = new JLabel("학과");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("굴림", Font.BOLD, 13));
		panel_7.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setText("주간");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		panel_7.add(textField_4);
		
		JLabel label_8 = new JLabel("성명");
		label_8.setHorizontalAlignment(SwingConstants.LEFT);
		label_8.setFont(new Font("굴림", Font.BOLD, 13));
		panel_7.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setText("1");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		panel_7.add(textField_6);
		
		JLabel label_11 = new JLabel("학적구분");
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setFont(new Font("굴림", Font.BOLD, 13));
		panel_7.add(label_11);
		
		JComboBox comboBox_6 = new JComboBox();
		panel_7.add(comboBox_6);
		
		JPanel panel_8추가저장삭제홈 = new JPanel();
		panel_8추가저장삭제홈.setBounds(428, 330, 172, 82);
		contentPane.add(panel_8추가저장삭제홈);
		panel_8추가저장삭제홈.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton button_2 = new JButton("추가");
		button_2.setFont(new Font("굴림", Font.BOLD, 13));
		panel_8추가저장삭제홈.add(button_2);
		
		JButton button_1 = new JButton("저장");
		button_1.setFont(new Font("굴림", Font.BOLD, 13));
		panel_8추가저장삭제홈.add(button_1);
		
		JButton button = new JButton("삭제");
		button.setFont(new Font("굴림", Font.BOLD, 13));
		panel_8추가저장삭제홈.add(button);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("굴림", Font.BOLD, 13));
		panel_8추가저장삭제홈.add(btnHome);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(364, 269, 159, 28);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel label_10 = new JLabel("성별");
		label_10.setHorizontalAlignment(SwingConstants.LEFT);
		label_10.setFont(new Font("굴림", Font.BOLD, 13));
		label_10.setBounds(0, 0, 81, 28);
		panel_8.add(label_10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(80, 0, 79, 28);
		panel_8.add(comboBox_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBounds(539, 269, 159, 28);
		contentPane.add(panel_9);
		
		JLabel label_12 = new JLabel("병역사항");
		label_12.setHorizontalAlignment(SwingConstants.LEFT);
		label_12.setFont(new Font("굴림", Font.BOLD, 13));
		label_12.setBounds(0, 0, 81, 28);
		panel_9.add(label_12);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(80, 0, 79, 28);
		panel_9.add(comboBox_5);
	}
}
