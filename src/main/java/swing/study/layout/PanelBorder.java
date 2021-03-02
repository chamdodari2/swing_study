package swing.study.layout;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;

public class PanelBorder extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelBorder() {

		initialize();
	}
	private void initialize() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel("North");
		lblNewLabel_1.setOpaque(true);  //jlabel은 투명 -> 불투명
		lblNewLabel_1.setBackground(Color.ORANGE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Center");
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);
		
		JLabel lblWest = new JLabel("West");
		lblWest.setBackground(Color.GREEN);
		lblWest.setOpaque(true);
		add(lblWest);
		
		JLabel lblNewLabel_2 = new JLabel("East");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("South");
		lblNewLabel_3.setBackground(Color.BLUE);
		lblNewLabel_3.setOpaque(true);
		add(lblNewLabel_3);
	}

}
