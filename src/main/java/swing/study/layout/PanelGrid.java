package swing.study.layout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class PanelGrid extends JPanel {
	private JTextField tfName;
	private JTextField tfNo;
	private JTextField tfClass;
	private JTextField tfSubject;


	public PanelGrid() {

		initialize();
	}
	private void initialize() {
		setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblName = new JLabel("이름");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		tfName = new JTextField();
		add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNo = new JLabel("학번");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblNo);
		
		tfNo = new JTextField();
		tfNo.setColumns(10);
		add(tfNo);
		
		JLabel lblClass = new JLabel("학과");
		lblClass.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblClass);
		
		tfClass = new JTextField();
		tfClass.setColumns(10);
		add(tfClass);
		
		JLabel lblSubject = new JLabel("과목");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSubject);
		
		tfSubject = new JTextField();
		tfSubject.setColumns(10);
		add(tfSubject);
	}

}
