package swing.study.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing.study.panel.Department;
import swing.study.panel.DeptPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnSetDept;
	private JButton btnGetDept;
	private DeptPanel pDept;
	private JButton btnClear;

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try {
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	public JPanelEx() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pDept = new DeptPanel();
		contentPane.add(pDept, BorderLayout.CENTER);
		
		JPanel pBtn = new JPanel();
		contentPane.add(pBtn, BorderLayout.SOUTH);
		
		btnSetDept = new JButton("부서설정");
		btnSetDept.addActionListener(this);
		pBtn.add(btnSetDept);
		
		btnGetDept = new JButton("부서 가져오기");
		btnGetDept.addActionListener(this);
		pBtn.add(btnGetDept);
		
		btnClear = new JButton("초기화");
		btnClear.addActionListener(this);
		pBtn.add(btnClear);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			actionPerformedBtnClear(e);
		}
		if (e.getSource() == btnGetDept) {
			actionPerformedBtnGetDept(e);
		}
		if (e.getSource() == btnSetDept) {
			actionPerformedBtnSetDept(e);
		}
	}
	protected void actionPerformedBtnSetDept(ActionEvent e) {
		Department dept = new Department(1,"기획",9);
		pDept.setDepartment(dept);
		
	}
	protected void actionPerformedBtnGetDept(ActionEvent e) {
		Department dept = pDept.getDepartment();
		JOptionPane.showMessageDialog(null,dept);
		
		
	}
	protected void actionPerformedBtnClear(ActionEvent e) {
		pDept.clearTf();
	}
}
