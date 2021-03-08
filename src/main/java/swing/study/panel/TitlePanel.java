package swing.study.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class TitlePanel extends JPanel {
	private JTextField tfNo;
	private JTextField tfName;

	
	public TitlePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "직책정보", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNo = new JLabel("직책번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);
		
		JLabel lblName = new JLabel("직책명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
			
		tfName = new JTextField();
		tfName.setColumns(10);
		add(tfName);
		
	}
	public Title getTitle() {
		int titleNo = Integer.parseInt(tfNo.getText().trim());
		String titleName = tfName.getText().trim();
		return new Title(titleNo,titleName);		
	}
	
	public void setTitle(Title title) {
		tfNo.setText(title.gettNo() + "");
		tfName.setText(title.gettName() + "");
			
	}
	
	public void clearTf() {
		tfNo.setText("");
		tfName.setText("");
		
		
		
	}
}
