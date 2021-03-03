package swing.study.component;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class JCheckBoxEx extends JFrame implements ItemListener {

	private JPanel contentPane;
	private JCheckBox chckbxApple;
	private JLabel lblRes;
	private int sum;
	private String resStr = "현재0 원 입니다.";
	private JCheckBox chckbxPear;
	private JCheckBox chckbxCherry;

	
	public JCheckBoxEx() {
		initialize();
		chckbxCherry.setSelected(true);  //체리 기본으로 선택하게하기
	}
	private void initialize() {
		setTitle("체크박스 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(new BoxLayout(pNorth, BoxLayout.Y_AXIS));
		
		JLabel lblTitle = new JLabel("사과 100원, 배 500원, 체리 20000원");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		pNorth.add(lblTitle);
		
		JPanel panel = new JPanel();
		pNorth.add(panel);
		
		chckbxApple = new JCheckBox("사과");
		chckbxApple.addItemListener(this);
		panel.add(chckbxApple);
		
		chckbxPear = new JCheckBox("배");
		chckbxPear.addItemListener(this);
		panel.add(chckbxPear);
		
		chckbxCherry = new JCheckBox("체리");
		chckbxCherry.addItemListener(this);
		panel.add(chckbxCherry);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblRes = new JLabel(resStr);
		pSouth.add(lblRes);
		lblRes.setHorizontalAlignment(SwingConstants.LEFT);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == chckbxCherry) {
			itemStateChangedChckbxCherry(e);
		}
		if (e.getSource() == chckbxPear) {
			itemStateChangedChckbxPear(e);
		}
		if (e.getSource() == chckbxApple) {
			itemStateChangedChckbxApple(e);
		}resStr = String.format("현재%d 원 입니다.", sum);
		lblRes.setText(resStr);
	}
	protected void itemStateChangedChckbxApple(ItemEvent e) {
		
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 100;
			
		}else {
			sum -= 100;
		}
//		resStr = String.format("현재%d 원 입니다.", sum);
//		lblRes.setText(resStr);
	}
	protected void itemStateChangedChckbxPear(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 500;
			
		}else {
			sum -= 500;
		}
//		resStr = String.format("현재%d 원 입니다.", sum);
//		lblRes.setText(resStr);
		
	}
	protected void itemStateChangedChckbxCherry(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			sum += 20000;
			
		}else {
			sum -= 20000;
		}
	}
}
