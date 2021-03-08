package swing.study.panel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;
import java.awt.Dimension;

public class EmployeePanel extends JPanel {
	private JTextField tfNo;
	private JTextField tfName;
	private JTextField tfPass2;
	private JPasswordField pfPass1;

	
	public EmployeePanel() {

		initialize();
	}
	private void initialize() {
		setBorder(new TitledBorder(null, "\uC0AC\uC6D0\uC815\uBCF4", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNo = new JLabel("사원번호");
		lblNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNo);
		
		tfNo = new JTextField();
		panel_2.add(tfNo);
		tfNo.setColumns(10);
		
		JLabel lblName = new JLabel("사원명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		panel_2.add(tfName);
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblTitle);
		
		JComboBox cmbTitle = new JComboBox();
		panel_2.add(cmbTitle);
		
		JLabel lblManager = new JLabel("직속상사");
		lblManager.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblManager);
		
		JComboBox cmbManager = new JComboBox();
		panel_2.add(cmbManager);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblSalary);
		
		JSpinner spinSalary = new JSpinner();
		panel_2.add(spinSalary);
		
		JLabel lblDept = new JLabel("부서");
		lblDept.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblDept);
		
		JComboBox cmbSalary = new JComboBox();
		panel_2.add(cmbSalary);
		
		JLabel lblHireDate = new JLabel("입사일");
		lblHireDate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblHireDate);
		
		JDateChooser dateHire = new JDateChooser();
		panel_2.add(dateHire);
		
		JLabel lblPass1 = new JLabel("비밀번호");
		lblPass1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPass1);
		
		pfPass1 = new JPasswordField();
		panel_2.add(pfPass1);
		
		JLabel lblPass2 = new JLabel("비밀번호 확인");
		lblPass2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblPass2);
		
		tfPass2 = new JTextField();
		tfPass2.setColumns(10);
		panel_2.add(tfPass2);
		
		JPanel spacePanel = new JPanel();
		panel_2.add(spacePanel);
		
		JPanel lblResultPanel = new JPanel();
		panel_2.add(lblResultPanel);
		lblResultPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label = new JLabel("New label");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.RED);
		label.setFont(new Font("굴림", Font.BOLD, 20));
		lblResultPanel.add(label);
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pPic = new JPanel();
		pTop.add(pPic);
		pPic.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPic = new JLabel("");
		lblPic.setPreferredSize(new Dimension(100, 120));
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		pPic.add(lblPic);
		
		JPanel pBtnPic = new JPanel();
		pPic.add(pBtnPic, BorderLayout.SOUTH);
		
		JButton btnAddPic = new JButton("사진추가");
		pBtnPic.add(btnAddPic);
	}
	public void setEmployee(Employee employee) {
		
	}
	public Employee getEmployee() {
		return null;
		
	}
	public void clearTf() {
		
	}
}
