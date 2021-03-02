package swing.study;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;

public class StudentMgnMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMgnMain frame = new StudentMgnMain();
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
	public StudentMgnMain() {
		setTitle("학생관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 424, 50);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("학생 관리 프로그램");
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 55, 424, 50);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("학적/학생 관리");
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 25));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 105, 424, 50);
		contentPane.add(panel_2);
		
		JButton button = new JButton("학생 조회 관리");
		button.setFont(new Font("굴림", Font.BOLD, 25));
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 155, 424, 50);
		contentPane.add(panel_3);
		
		JButton button_1 = new JButton("   성적 관리   ");
		button_1.setFont(new Font("굴림", Font.BOLD, 25));
		panel_3.add(button_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(5, 205, 424, 50);
		contentPane.add(panel_4);
		
		JButton button_2 = new JButton("      종료      ");
		button_2.setFont(new Font("굴림", Font.BOLD, 25));
		panel_4.add(button_2);
	}

}
