package swing.study.dlg;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JOptionPaneConfirmEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JLabel lblRes;

	public JOptionPaneConfirmEx() {
		initialize();
	}
	private void initialize() {
		setTitle("Confirm Dlg 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblRes = new JLabel("New label");
		lblRes.setHorizontalAlignment(SwingConstants.CENTER);
		lblRes.setFont(new Font("굴림", Font.BOLD, 20));
		contentPane.add(lblRes);
		
		btnNewButton = new JButton("누르시오");
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		String imgPath = System.getProperty("user.dir") + File.separator + ("images")+File.separator; 
		ImageIcon icon = new ImageIcon(imgPath + "열쇠.png");
		int res = 	JOptionPane.showConfirmDialog(
				null, 
				"계속 할것입니까?", 
				"Confirm", 
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.WARNING_MESSAGE, 
				icon);
		
		if(res == JOptionPane.YES_OPTION) {
		lblRes.setText("Yes");	
		}
		if(res == JOptionPane.NO_OPTION) {
			lblRes.setText("No");	
			}
		if(res == JOptionPane.CANCEL_OPTION) {
			lblRes.setText("Cancel");	
			}
		if(res==-1) {
			lblRes.setText("선택하지 않음");
		}
		System.out.println(res);
	}
}
