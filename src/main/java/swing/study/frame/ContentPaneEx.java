package swing.study.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ContentPaneEx extends JFrame {

	private JPanel contentPane;

	
	public ContentPaneEx() {
		initialize();
	}
	private void initialize() {
		setResizable(false);
		setTitle("테스트");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 400, 450, 300);  //모니터상에  해당위치에 해당사이즈로 창 띄운다
		//창안에 네모부분
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		//안쪽여백 정해준거
		contentPane.setBorder(new EmptyBorder(10, 20, 30, 40));
		setContentPane(contentPane);		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 50));
		
		JButton btnNewButton_1 = new JButton("New button");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("New button");
		contentPane.add(btnNewButton_3);
	}

}
