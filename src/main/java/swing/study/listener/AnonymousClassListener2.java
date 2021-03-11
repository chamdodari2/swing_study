package swing.study.listener;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AnonymousClassListener2 extends JFrame {

	private JPanel contentPane;

	public AnonymousClassListener2() {
		initialize();
	}

	public void initialize() {
		setTitle("익명클래스");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btn = new JButton("Action");
		btn.addActionListener(new ActionListener() {   // new 뒷부분을 클래스내용 가져옴

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				JButton btn = (JButton) e.getSource();
				if (e.getActionCommand().equals("Action")) {
					btn.setText("액션");

				} else {
					btn.setText("Action");
				}

			}
		});
		contentPane.add(btn, BorderLayout.CENTER);
	}

}
