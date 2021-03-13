package swing.study;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import swing.study.Menu.JMenuEx;
import swing.study.Menu.JPopupMenuEx;
import swing.study.component.FrameComponentEx;
import swing.study.component.Fruit;
import swing.study.component.JButtonEx;
import swing.study.component.JCheckBoxCustomEx;
import swing.study.component.JCheckBoxEx;
import swing.study.component.JComboBoxEx1;
import swing.study.component.JComboBoxEx2;
import swing.study.component.JComboBoxEx3;
import swing.study.component.JLabelEx;
import swing.study.component.JLabelEx1;
import swing.study.component.JListEx;
import swing.study.component.JListEx2;
import swing.study.component.JListEx3;
import swing.study.component.JRadioButtonEx;
import swing.study.component.JSliderEx;
import swing.study.component.JSpinnerEx;
import swing.study.component.JTabbedPaneEx;
import swing.study.component.JTableEx;
import swing.study.component.JTextFieldAreaEx;
import swing.study.dlg.JFileChooserEx;
import swing.study.dlg.JOptionPaneConfirmEx;
import swing.study.dlg.JOptionPaneInputEx;
import swing.study.dlg.JOptionPaneMessageEx;
import swing.study.frame.ContentPaneEx;
import swing.study.frame.JPanelEx;
import swing.study.layout.FrameLayout;
import swing.study.layout.LayoutGuBun;
import swing.study.listener.AnonymousClassListener2;
import swing.study.listener.IndepClassListener;
import swing.study.listener.InnerClassListener;
import swing.study.listener.MouseListenerEx;

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
	private JPanel pComponent1;
	private JButton btn04;
	private JButton btn05;
	private JPanel pCheckRadio;
	private JButton btn06;
	private JButton btn07;
	private JPanel pText;
	private JButton btn08;
	private JPanel pList;
	private JButton btn10;
	private JButton btn09;
	private JButton btn11;
	private JPanel pCombo;
	private JButton btn12;
	private JButton btn13;
	private JButton btn14;
	private JPanel pSliderSpinner;
	private JPanel pSlider;
	private JPanel pSpinner;
	private JButton btn15;
	private JButton btn16;
	private JPanel panel;
	private JButton btn17;
	private JButton btn0402;
	private JButton btn18;
	private JPanel panel_1;
	private JButton btn19;
	private JButton btn20;
	private JButton btn21;
	private JButton btn22;
	private JButton btn23;
	private JPanel panel_2;
	private final JButton button = new JButton("New button");
	private JButton btn24;
	private JButton btn25;
	private JPanel panel_3;
	private JButton btn26;
	private JButton btn27;
	private JButton btn28;
	private JPanel panel_4;
	private JButton btn29;
	
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
		setBounds(10, 10, 778, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 5, 10, 10));
		
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
		
		pComponent1 = new JPanel();
		pComponent1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JLabel & JButton & JToggleButton", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pComponent1);
		pComponent1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn04 = new JButton("JLabel");
		btn04.addActionListener(this);
		pComponent1.add(btn04);
		
		btn05 = new JButton("Jbutton &JToggleButton");
		btn05.addActionListener(this);
		
		btn0402 = new JButton("JLabel_size");
		btn0402.addActionListener(this);
		pComponent1.add(btn0402);
		pComponent1.add(btn05);
		
		pCheckRadio = new JPanel();
		pCheckRadio.setBorder(new TitledBorder(null, "JCheckBox  & JRadiButton", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pCheckRadio);
		pCheckRadio.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn06 = new JButton("JCheckBox");
		btn06.addActionListener(this);
		pCheckRadio.add(btn06);
		
		btn07 = new JButton("JRadioButton");
		btn07.addActionListener(this);
		pCheckRadio.add(btn07);
		
		pText = new JPanel();
		pText.setBorder(new TitledBorder(null, "\uD14D\uC2A4\uD2B8\uD544\uB4DC", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pText);
		
		btn08 = new JButton("TextField 관련예제");
		btn08.addActionListener(this);
		pText.add(btn08);
		
		pList = new JPanel();
		pList.setBorder(new TitledBorder(null, "JList", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pList);
		pList.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn09 = new JButton("JList 예1");
		btn09.addActionListener(this);
		pList.add(btn09);
		
		btn10 = new JButton("JList 예2");
		btn10.addActionListener(this);
		pList.add(btn10);
		
		btn11 = new JButton("JList 예3");
		btn11.addActionListener(this);
		pList.add(btn11);
		
		pCombo = new JPanel();
		pCombo.setBorder(new TitledBorder(null, "JComboBox", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(pCombo);
		pCombo.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn12 = new JButton("JComboBox 예1");
		btn12.addActionListener(this);
		pCombo.add(btn12);
		
		btn13 = new JButton("JComboBox 예2");
		btn13.addActionListener(this);
		pCombo.add(btn13);
		
		btn14 = new JButton("JComboBox 예3");
		btn14.addActionListener(this);
		pCombo.add(btn14);
		
		pSliderSpinner = new JPanel();
		contentPane.add(pSliderSpinner);
		pSliderSpinner.setLayout(new GridLayout(0, 1, 0, 0));
		
		pSlider = new JPanel();
		pSlider.setBorder(new TitledBorder(null, "JSlider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSlider);
		pSlider.setLayout(new BorderLayout(0, 0));
		
		btn15 = new JButton("JSlider 예");
		btn15.addActionListener(this);
		pSlider.add(btn15, BorderLayout.CENTER);
		
		pSpinner = new JPanel();
		pSpinner.setBorder(new TitledBorder(null, "JSpinner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pSliderSpinner.add(pSpinner);
		pSpinner.setLayout(new BorderLayout(0, 0));
		
		btn16 = new JButton("JSpinner 예");
		btn16.addActionListener(this);
		pSpinner.add(btn16, BorderLayout.CENTER);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JTabbedPane & JTable", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel);
		
		btn17 = new JButton("JTabbedPane");
		btn17.addActionListener(this);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(btn17);
		
		btn18 = new JButton("JTable");
		btn18.addActionListener(this);
		panel.add(button);
		panel.add(btn18);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn19 = new JButton("독립클래스");
		btn19.addActionListener(this);
		panel_1.add(btn19);
		
		btn20 = new JButton("내부 클래스");
		btn20.addActionListener(this);
		panel_1.add(btn20);
		
		btn21 = new JButton("익명 클래스");
		btn21.addActionListener(this);
		panel_1.add(btn21);
		
		btn22 = new JButton("마우스리스너");
		btn22.addActionListener(this);
		panel_1.add(btn22);
		
		btn23 = new JButton("마우스어댑터");
		btn23.addActionListener(this);
		panel_1.add(btn23);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "JMenu & JPopupMenu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn24 = new JButton("메뉴바");
		btn24.addActionListener(this);
		panel_2.add(btn24);
		
		btn25 = new JButton("팝업메뉴");
		btn25.addActionListener(this);
		panel_2.add(btn25);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "JOptionPane", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		btn26 = new JButton("InputDlg");
		btn26.addActionListener(this);
		panel_3.add(btn26);
		
		btn27 = new JButton("confirmClg");
		btn27.addActionListener(this);
		panel_3.add(btn27);
		
		btn28 = new JButton("messageDlg");
		btn28.addActionListener(this);
		panel_3.add(btn28);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "JFileChooser", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_4);
		
		btn29 = new JButton("JFileChooser");
		btn29.addActionListener(this);
		panel_4.add(btn29);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn29) {
			actionPerformedBtn29(e);
		}
		if (e.getSource() == btn28) {
			actionPerformedBtn28(e);
		}
		if (e.getSource() == btn27) {
			actionPerformedBtn27(e);
		}
		if (e.getSource() == btn26) {
			actionPerformedBtn26(e);
		}
		if (e.getSource() == btn25) {
			actionPerformedBtn25(e);
		}
		if (e.getSource() == btn24) {
			actionPerformedBtn24(e);
		}
	
		if (e.getSource() == btn22) {
			actionPerformedBtn22(e);
		}
		if (e.getSource() == btn21) {
			actionPerformedBtn21(e);
		}
		if (e.getSource() == btn20) {
			actionPerformedBtn20(e);
		}
		if (e.getSource() == btn19) {
			actionPerformedBtn19(e);
		}
		if (e.getSource() == btn18) {
			actionPerformedBtn18(e);
		}
		if (e.getSource() == btn0402) {
			actionPerformedBtn0402(e);
		}
		if (e.getSource() == btn17) {
			actionPerformedBtn17(e);
		}
		if (e.getSource() == btn16) {
			actionPerformedBtn16(e);
		}
		if (e.getSource() == btn15) {
			actionPerformedBtn15(e);
		}
		if (e.getSource() == btn14) {
			actionPerformedBtn14(e);
		}
		if (e.getSource() == btn13) {
			actionPerformedBtn13(e);
		}
		if (e.getSource() == btn12) {
			actionPerformedBtn12(e);
		}
		if (e.getSource() == btn11) {
			actionPerformedBtn11(e);
		}
		if (e.getSource() == btn10) {
			actionPerformedBtn10(e);
		}
		if (e.getSource() == btn09) {
			actionPerformedBtn09(e);
		}
		if (e.getSource() == btn08) {
			actionPerformedBtn08(e);
		}
		if (e.getSource() == btn07) {
			actionPerformedBtn07(e);
		}
		if (e.getSource() == btn06) {
			actionPerformedBtn06(e);
		}
		if (e.getSource() == btn05) {
			actionPerformedBtn05(e);
		}
		if (e.getSource() == btn04) {
			actionPerformedBtn04(e);
		}
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
		frame.setVisible(true);  
		
	}

	protected void actionPerformedBtnGridLayout(ActionEvent e) { 
		FrameLayout frame = new FrameLayout(LayoutGuBun.GRID);
		frame.setVisible(true);  
	}
	protected void actionPerformedBtnAbsoluteLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.ABSOLUTE);
		frame.setVisible(true);  
	}
	protected void actionPerformedBtnBorderLayout(ActionEvent e) {
		FrameLayout frame = new FrameLayout(LayoutGuBun.BORDER);
		frame.setVisible(true);  
	}
	protected void actionPerformedBtn03(ActionEvent e) {
		FrameComponentEx frame = new FrameComponentEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn04(ActionEvent e) {
		JLabelEx frame = new JLabelEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn05(ActionEvent e) {
		JButtonEx frame = new JButtonEx();
		frame.setVisible(true);
		
	}
	protected void actionPerformedBtn06(ActionEvent e) {
		JCheckBoxEx frame = new JCheckBoxEx();
		frame.setVisible(true);
		
		ArrayList<Fruit> list = new ArrayList<Fruit>();  //db에서 목록을 가져왔다고 치는거
		list.add(new Fruit("사과",100));
		list.add(new Fruit("배",500));
		list.add(new Fruit("체리",2000));
		list.add(new Fruit("바나나",1000));
		list.add(new Fruit("메론",3000));
		
		JCheckBoxCustomEx frame1 = new JCheckBoxCustomEx(list);
//		frame1.setFruitList(list);
		frame1.setVisible(true);
//		
	}
	protected void actionPerformedBtn07(ActionEvent e) {
		JRadioButtonEx frame = new JRadioButtonEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn08(ActionEvent e) {
		JTextFieldAreaEx frame = new JTextFieldAreaEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn09(ActionEvent e) {
		JListEx frame = new JListEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn10(ActionEvent e) {
		JListEx2 frame = new JListEx2();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn11(ActionEvent e) {		
		JListEx3 frame = new JListEx3();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn12(ActionEvent e) {
		JComboBoxEx1 frame = new JComboBoxEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn13(ActionEvent e) {
		JComboBoxEx2 frame = new JComboBoxEx2();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn14(ActionEvent e) {
		JComboBoxEx3 frame = new JComboBoxEx3();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn15(ActionEvent e) {
		JSliderEx frame = new JSliderEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn16(ActionEvent e) {
		JSpinnerEx frame = new JSpinnerEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn17(ActionEvent e) {
		JTabbedPaneEx frame = new JTabbedPaneEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn0402(ActionEvent e) {
		JLabelEx1 frame = new JLabelEx1();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn18(ActionEvent e) {
		JTableEx frame = new JTableEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn19(ActionEvent e) {
		IndepClassListener frame = new IndepClassListener();
		frame.setVisible(true);
		
		
	}
	protected void actionPerformedBtn20(ActionEvent e) {
		InnerClassListener frame = new InnerClassListener();
		frame.setVisible(true);
		
	}
	protected void actionPerformedBtn21(ActionEvent e) {
		AnonymousClassListener2 frame = new AnonymousClassListener2();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn22(ActionEvent e) {
		MouseListenerEx frame = new MouseListenerEx();
		frame.setVisible(true);
	}

	protected void actionPerformedBtn24(ActionEvent e) {  //메뉴바
		JMenuEx frame = new JMenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn25(ActionEvent e) { //팝업메뉴	
		JPopupMenuEx frame = new JPopupMenuEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn26(ActionEvent e) {
		JOptionPaneInputEx frame = new JOptionPaneInputEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn27(ActionEvent e) {
		JOptionPaneConfirmEx frame = new JOptionPaneConfirmEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn28(ActionEvent e) {
		JOptionPaneMessageEx frame = new JOptionPaneMessageEx();
		frame.setVisible(true);
	}
	protected void actionPerformedBtn29(ActionEvent e) {
		JFileChooserEx frame = new JFileChooserEx();
		frame.setVisible(true);
	}
}