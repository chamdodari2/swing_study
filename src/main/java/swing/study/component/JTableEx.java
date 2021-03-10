package swing.study.component;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import swing.study.component.table.DeptTablePanel;
import swing.study.component.table.EmpTablePanel;
import swing.study.component.table.MyTablePanel;
import swing.study.component.table.Student;
import swing.study.component.table.TitleTablePanel;
import swing.study.panel.Department;
import swing.study.panel.Employee;
import swing.study.panel.StudentManagement;
import swing.study.panel.Title;
import swing.study.component.table.StudentManagementTablePanel;

public class JTableEx extends JFrame {

	private JPanel contentPane;
	private JTable table1;


	private List<Student> stdList = new ArrayList<>();  //
	private List<Department> deptList = new ArrayList<>();//11
	private List<Title> titleList = new ArrayList<>();//11
	private List<Employee> empList = new ArrayList<>();//11
	private List<StudentManagement> stdMgnList = new ArrayList<>();//11
	
	
	public JTableEx() {//
		stdList.add(new Student(1,"김인환",50,60,60));
		stdList.add(new Student(2,"이태훈",70,71,70));
		stdList.add(new Student(3,"김상건",90,92,100));
		stdList.add(new Student(4,"전수린",60,63,67));
		
		deptList.add(new Department(1,"개발",8));		//12
		deptList.add(new Department(2,"인사",9));		
		deptList.add(new Department(3,"홍보",10));
		
		titleList.add(new Title(1,"사장"));
		titleList.add(new Title(2,"부장"));
		titleList.add(new Title(3,"과장"));
		titleList.add(new Title(4,"대리"));
		
		empList.add(new Employee(1,"이태훈",titleList.get(0),new Employee(1,"김상건"),2000000,deptList.get(0)));
		empList.add(new Employee(2,"이성래",titleList.get(1),new Employee(1,"김상건"),1500000,deptList.get(1)));
		empList.add(new Employee(3,"이태훈",titleList.get(2),new Employee(1,"김상건"),2000000,deptList.get(1)));
	//////////////////////////////////////////////////수정중	
		stdMgnList.add(new StudentManagement(1,"김예진","스윙",1,"졸업","미필","960828","01095660476","주"));
 ////////////////////////////////////////////////////////
		
		
		
		initialize();
	}
	private void initialize() {
		setTitle("JTable 예");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 688, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane1 = new JScrollPane();
		panel1.add(scrollPane1, BorderLayout.CENTER);
		
		table1 = new JTable(getModel());
		
		scrollPane1.setViewportView(table1);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		//////////////////////////////////////////std list 추가
		
		
	//	pCustomTable2.seList(stdList);

		MyTablePanel pCustomTable2 = new MyTablePanel();
		pCustomTable2.setList(stdList);
		panel2.add(pCustomTable2, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		contentPane.add(panel3);
		panel3.setLayout(new BorderLayout(0, 0));
		
		DeptTablePanel pDeptTable3 = new DeptTablePanel();
		pDeptTable3.setList(deptList);	//13
		panel3.add(pDeptTable3, BorderLayout.CENTER);
		
		JPanel panel4 = new JPanel();
		contentPane.add(panel4);
		panel4.setLayout(new BorderLayout(0, 0));
		
		TitleTablePanel panel = new TitleTablePanel();//모프하면 생긴당
		panel.setList(titleList); //이렇게 해줘야 리스트 받아올수있다!!!!!!!!
		panel4.add(panel, BorderLayout.CENTER); //

		
		
		JPanel pTable5 = new JPanel();
		contentPane.add(pTable5);
		pTable5.setLayout(new BorderLayout(0, 0));
		
		EmpTablePanel pEmpTable = new EmpTablePanel();
		pEmpTable.setList(empList);
		pTable5.add(pEmpTable, BorderLayout.CENTER);
		
		JPanel pTable6 = new JPanel();
		contentPane.add(pTable6);
		pTable6.setLayout(new BorderLayout(0, 0));
		
		StudentManagementTablePanel pStdMgnTable = new StudentManagementTablePanel();
		pStdMgnTable.setList(stdMgnList);
		pTable6.add(pStdMgnTable, BorderLayout.CENTER);

	}
	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(),getColumnNames());
		return model;
	}
	
	class CustomTableModel extends DefaultTableModel{

		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);
			
		}

		@Override
		public boolean isCellEditable(int row, int column) {		
			return false;
		}
		
		
	}
	public Object[][] getData() {			
		return	new Object[][] {
				{1, "박유진", 10, "여자"},
				{2, "이태훈", 11, "남자"},   //이렇게 해도되는데 번거로워진다
			};
//			getColumnNames()  //얘도 함수로 뺏다

	}
	public String[] getColumnNames() {
		return new String[] {
			"학생번호", "학생명", "나이", "성별"
		};
	}

}
