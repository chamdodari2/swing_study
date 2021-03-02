package swing.study.layout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelAbsolute extends JPanel {
	private JTextField textField;

	
	public PanelAbsolute() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(332, 39, 57, 15);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(151, 137, 97, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 220, 116, 21);
		add(textField);
		textField.setColumns(10);
	}
}
