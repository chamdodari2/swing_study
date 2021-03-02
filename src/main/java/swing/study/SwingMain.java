package swing.study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing.study.component.FrameComponentEx;
import swing.study.frame.ContentPaneEx;
import swing.study.frame.JPanelEx;
import swing.study.layout.FrameLayout;
import swing.study.layout.LayoutGuBun;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;

public class SwingMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn01;
	private JButton btn02;
	private JPanel pLayout;
	private JButton btnFlowLayout;
	private JButton btnFlowLayout_1;
	private JButton btnBorderLayout;
	private JButton btnGridLayout;
	private JButton btnAbsoluteLayout;
	private JButton btn03;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
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
	public SwingMain() {
		initialize();
	}
	private void initialize() {
		setTitle("스윙 스터디");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		btn01 = new JButton("Jframe 예");
		btn01.addActionListener(this);
		contentPane.add(btn01);
		
		btn02 = new JButton("JPanel 예");
		btn02.addActionListener(this);
		contentPane.add(btn02);
		
		pLayout = new JPanel();
		pLayout.setBorder(new TitledBorder(null, "레이아웃", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pLayout);
		pLayout.setLayout(new GridLayout(0, 1, 0, 10));
		
		btnFlowLayout = new JButton("플로우 레이아웃");
		////////소스추가   --> 람다로 바꿀수 있어야한당
		btnFlowLayout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameLayout flow = new FrameLayout(LayoutGuBun.FLOW);
				//	flow.setVisible(true);
				
				
				
			}
		});
		////////소스추가끝
		//추가수정
		btnFlowLayout_1 =new JButton("플로우레이아웃");
		btnFlowLayout_1.addActionListener(this);
	// ??덜침	btnFlowLayout.add ddd flow =(e -> new FrameLayout(LayoutGuBun.FLOW));
		
		//추가수정끝
		pLayout.add(btnFlowLayout_1);
		
		btnBorderLayout = new JButton("보더 레이아웃");
		btnBorderLayout.addActionListener(this);
		pLayout.add(btnBorderLayout);
		
		btnGridLayout = new JButton("그리드 레이아웃");
		btnGridLayout.addActionListener(this);
		pLayout.add(btnGridLayout);
		
		btnAbsoluteLayout = new JButton("절대 레이아웃");
		btnAbsoluteLayout.addActionListener(this);
		pLayout.add(btnAbsoluteLayout);
		
		btn03 = new JButton("JComponent 공통 속성");
		btn03.addActionListener(this);
		contentPane.add(btn03);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn03) {
			actionPerformedBtn03(e);
		}
		if (e.getSource() == btnBorderLayout) {
			actionPerformedBtnBorderLayout(e);
		}
		if (e.getSource() == btnAbsoluteLayout) {
			actionPerformedBtnAbsoluteLayout(e);
		}
		if (e.getSource() == btnGridLayout) {
			actionPerformedBtnGridLayout(e);
		}
		if (e.getSource() == btnFlowLayout_1) {
			actionPerformedBtnFlowLayout_1(e);
		}
		if (e.getSource() == btn02) {
			actionPerformedBtn02(e);
		}
		if (e.getSource() == btn01) {
			actionPerformedBtn01(e);
		}
	}
	protected void actionPerformedBtn01(ActionEvent e) {
		ContentPaneEx frame = new ContentPaneEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn02(ActionEvent e) {
		JPanelEx frame = new JPanelEx();
		frame.setVisible(true);
	}
	
	////액션포폼드 추가 (디자인에서 추가한거임)
	protected void actionPerformedBtnFlowLayout_1(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.FLOW);
		frame.setVisible(true);  // 이 두줄은 메인 트라이안에서 가져왔당
		
	}

	protected void actionPerformedBtnGridLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.GRID);
		frame.setVisible(true);  //서브창 꺼지면 메인창까지 꺼지는현상 없애기??
	}
	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.ABSOLUTE);
		frame.setVisible(true);  //서브창 꺼지면 메인창까지 꺼지는현상 없애기??
	}
	protected void actionPerformedBtnBorderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.BORDER);
		frame.setVisible(true);  //서브창 꺼지면 메인창까지 꺼지는현상 없애기??
	}
	protected void actionPerformedBtn03(ActionEvent e) {
		FrameComponentEx frame = new FrameComponentEx();
		frame.setVisible(true);
	}
}
