package swing.study.component;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import swing.study.panel.Department;
import swing.study.panel.DeptPanel;
import swing.study.panel.Employee;
import swing.study.panel.EmployeePanel;
import swing.study.panel.Title;
import swing.study.panel.TitlePanel;

public class JTabbedPaneEx extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnConfirm;
	private JTabbedPane tabbedPane;
	private DeptPanel pDept;
	private TitlePanel pTitle;
	private EmployeePanel pEmp;
	


	public JTabbedPaneEx() {
		initialize();
	}
	private void initialize() {
		setTitle("JTabbedPane 예제");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 290, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pDept = new DeptPanel();
		pDept.setToolTipText("");
		tabbedPane.addTab("부서", null, pDept, "부서관리");
		
		pTitle = new TitlePanel();
		tabbedPane.addTab("직책", null, pTitle,"직책관리");
		
		pEmp = new EmployeePanel();
		tabbedPane.addTab("사원", null, pEmp, "사원관리");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) {// 확인 누르면 겟하기
		//현재 선택된 탭을 가져와서
		Component comp = tabbedPane.getSelectedComponent();			
//		System.out.println(comp);
		//getXX()호출
		if (comp == pDept) {
			DeptPanel deptPanel = (DeptPanel) comp;
			Department department = deptPanel.getDepartment();
			JOptionPane.showMessageDialog(null, department);

		}else if(comp == pTitle) {
			TitlePanel titlePanel = (TitlePanel) comp;
			Title title = titlePanel.getTitle();
			JOptionPane.showMessageDialog(null, title);	
			
		}else if(comp == pEmp) {
			EmployeePanel employeePanel = (EmployeePanel) comp;
			Employee employee = employeePanel.getEmployee();
			JOptionPane.showMessageDialog(null, employee);	
			
		}
	}
}
