package swing.study.layout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing.study.frame.PanelBorder;

public class FrameLayout extends JFrame {

	private JPanel contentPane;
/////////////////추가
	private  LayoutGuBun gubun;
	////////////////추가끝
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {/////////여기서부터 소스 수정
					/*
					 * FrameLayout frame = new FrameLayout(LayoutGuBun.FLOW); //생성할때 플로우로 한것
					 * ////////////////// frame.setVisible(true);
					 */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

/////////
	public FrameLayout(LayoutGuBun gubun) {
		
		this.gubun = gubun;
/////////////
		initialize();
	}
	private void initialize() {
		setTitle("레이아웃 종류");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		////////////////여기서부터 소스 수정
		JPanel pSwitch = null;
		switch(gubun) {
		case FLOW:
			pSwitch = new PanelFlow();
			setTitle("플로우레이아웃");
			break;
			
			////추가2
		case BORDER:
			pSwitch = new PanelBorder();
			setTitle("보더레이아웃");
			break;
			//추가2끝
		////추가2
		case GRID:
		pSwitch = new PanelGrid();
		setTitle("그리드레이아웃");
		break;
	//추가2끝
	////추가3
		case ABSOLUTE:
		pSwitch = new PanelAbsolute();
		setTitle("앱솔루트레이아웃");
		break;
						}	
		contentPane.add(pSwitch, BorderLayout.CENTER);
		/////////////////수정끝
		
		//추가수정
//		setVisible(true); // 이렇게 해주면 스윙메인에서는 필요없다.
		//추가수정끝
		
	}

}
