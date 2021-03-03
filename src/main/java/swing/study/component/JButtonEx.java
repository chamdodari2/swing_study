package swing.study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class JButtonEx extends JFrame implements ActionListener {
	private String imgpath = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	private JPanel contentPane;
	private JButton btn01;
	private JToggleButton tglbtn;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { JButtonEx frame = new JButtonEx();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public JButtonEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JButton& 토글버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.Y_AXIS));
		
		JButton  btn01 = new JButton("call");
	//	btn01.addActionListener(this);
		btn01.setIcon(new ImageIcon(imgpath+ "전화1.gif"));
		btn01.setRolloverIcon(new ImageIcon(imgpath+ "전화1.gif"));
		btn01.setPressedIcon(new ImageIcon(imgpath+ "전화2.gif"));
		
		
		pLeft.add(btn01);
		
		tglbtn = new JToggleButton("토글버튼");
		tglbtn.addActionListener(this);
		pLeft.add(tglbtn);
		
		JPanel pRight = new JPanel();
		contentPane.add(pRight);
		pRight.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder(null, "\uC218\uD3C9\uC815\uB82C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRight.add(pTop);
		pTop.setLayout(new GridLayout(0, 1, 0, 0));
		
		MyButton btn02 = new MyButton();
		btn02.setHorizontalAlignment(SwingConstants.LEFT);
		btn02.setText("Left");
		pTop.add(btn02);
		
		MyButton btnNewButton = new MyButton();
		btnNewButton.setText("Center");
		pTop.add(btnNewButton);
		
		MyButton btnNewButton_1 = new MyButton();
		btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_1.setText("Right");
		pTop.add(btnNewButton_1);
		
		JPanel pBotton = new JPanel();
		pBotton.setBorder(new TitledBorder(null, "\uC218\uC9C1\uC815\uB82C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pRight.add(pBotton);
		pBotton.setLayout(new GridLayout(1, 0, 0, 0));
		
		MyButton btn05 = new MyButton();
		btn05.setVerticalAlignment(SwingConstants.TOP);
		btn05.setText("Top");
		pBotton.add(btn05);
		
		MyButton btn06 = new MyButton();
		btn06.setText("Center");
		pBotton.add(btn06);
		
		MyButton btn07 = new MyButton();
		btn07.setVerticalAlignment(SwingConstants.BOTTOM);
		btn07.setText("Bottom");
		pBotton.add(btn07);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tglbtn) {
			actionPerformedTglbtn(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
	}
	protected void actionPerformedTglbtn(ActionEvent e) {
		if(tglbtn.isSelected()) {
			tglbtn.setText("눌렀네");
		}else {
			tglbtn.setText("눌러봐");
			
		}
		
	}
}
