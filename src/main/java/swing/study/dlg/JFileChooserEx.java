package swing.study.dlg;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblIng;
	private JButton btnOpen;
	private JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));

	public JFileChooserEx() {
		initialize();
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblIng = new JLabel("");
		contentPane.add(lblIng, BorderLayout.CENTER);

		btnOpen = new JButton("이미지 불러오기");
		btnOpen.addActionListener(this);
		contentPane.add(btnOpen, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			if (e.getActionCommand().equals("불러오기")) {
				actionPerformedBtnOpen(e);
			}else {
				actionPerformedBtnSave(e);  //해당 이미지를 파일로 저장
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////
	private File actionPerformedBtnSave(ActionEvent e) {
		//이미지스 말고 download폴더에  Label에 있는 이미지를 저장되도록 하기 과제! 만약 다운로드 폴더가 존재하지 않으면 생성후  저장되도록 하세요.  chobo2 ch15에 있는 FileEx2 참고
		//즉 수행을 시켜서 불러온 이미지 (배수지) 가 나오면 그 이미지를 저장되도록 하는게 과제다
		File file = new File("");
		
		int res = chooser.showOpenDialog(null);	
		if (res == JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하셨습니다", "", JOptionPane.WARNING_MESSAGE);
			
		}
//		File file = null;
//		if(res ==JFileChooser.APPROVE_OPTION) {
//			file = chooser.getSelectedFile();
//		}return file;
		return file;
	
		
	}
/////////////////////////////////////////////////
	protected void actionPerformedBtnOpen(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG & GIF images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		int res = chooser.showOpenDialog(null);
		if (res != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String chooserPirePath = chooser.getSelectedFile().getPath();
		lblIng.setIcon(new ImageIcon(chooserPirePath));

		if (btnOpen.getText().equals("불러오기")) {
			btnOpen.setText("저장하기");
		}
	}
}
