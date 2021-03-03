package swing.study.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class JLabelEx extends JFrame implements MouseListener {

	private JPanel contentPane;
	private String path = System.getProperty("user.dir") + File.separator + ("images")+File.separator;  //상대경로 설정하기. 남의컴에 이썽두 볼수있다 
	private JLabel lblNorth;
	private JLabel lblCenter;
	private JLabel lblSouth;
	
		
	public JLabelEx() {
	System.out.println(path);		
	initialize();
	}
private void initialize() {
	
	
	setTitle("JLabel");
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 444, 337);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	
	lblNorth = new JLabel("사랑합니다");
	lblNorth.addMouseListener(this);
	lblNorth.setBackground(Color.PINK);
	lblNorth.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblNorth, BorderLayout.NORTH);
	
	lblCenter = new JLabel("");
	lblCenter.setIcon(new ImageIcon(path+"배수지.jpg")); //절대경로이다. 내컴퓨터에 있는거만 띄울수있다.
	lblCenter.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblCenter, BorderLayout.CENTER);
	
	lblSouth = new JLabel("보고싶으면 전화하세요");
	lblSouth.setBackground(Color.PINK);
	lblSouth.setIcon(new ImageIcon(path+"이유영.jpg"));
	lblSouth.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(lblSouth, BorderLayout.SOUTH);
}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == lblNorth) {
			mouseClickedLblNorth(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedLblNorth(MouseEvent e) {
		lblCenter.setIcon(new ImageIcon(path+"이유영.jpg"));
		lblSouth.setText("010-1234-1234");
		JOptionPane.showMessageDialog(null, "변경완료");
	}
}
