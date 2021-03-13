package swing.study.component;  //부서가 어레이리스트에 다 왔으면 좋겠다

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import swing.study.panel.Department;
import swing.study.panel.DeptPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ListSelectionModel;

public class JListEx3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnAdd;
	private DeptPanel pLeftCenter;
	private JList<Department> deptList; //뭘담을거냐! Department를 담을거다
	private DefaultListModel<Department> model;
	private JPanel pBtns;
	private JButton btnConfirm;
	private JButton btnUpdate;
	private JButton btnDelete;
	
	

	
	public JListEx3() {
		initialize();
		
		model.addElement(new Department(1,"기획",8));
		model.addElement(new Department(2,"영업",18));
		model.addElement(new Department(3,"개발",28));
	}
	private void initialize() {
		setTitle("JLIst응용");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 20, 0));
		
		JPanel pLeft = new JPanel();
		contentPane.add(pLeft);
		pLeft.setLayout(new BorderLayout(0, 0));
		
		pLeftCenter = new DeptPanel();
		pLeft.add(pLeftCenter, BorderLayout.CENTER);		
		
		JPanel pLeftSouth = new JPanel();
		pLeft.add(pLeftSouth, BorderLayout.SOUTH);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pLeftSouth.add(btnAdd);
		
		JPanel pRight = new JPanel();
		pRight.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBD80\uC11C\uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(pRight);
		
		deptList = new JList<>();   //여기도 꺽쇠 해줘야 Department 담긴다
		deptList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultListModel<Department>();
		pRight.setLayout(new BorderLayout(0, 0));
		deptList.setModel(model);
//		deptList.setModel(getDeptModel());   //메소드 생성해주기 아까처럼!!
		pRight.add(deptList);
		
		pBtns = new JPanel();
		pRight.add(pBtns, BorderLayout.SOUTH);
		
		btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		pBtns.add(btnConfirm);
		
		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pBtns.add(btnUpdate);
		
		btnDelete = new JButton("삭제");
		btnDelete.addActionListener(this);
		pBtns.add(btnDelete);
	}

//	private ListModel<Department> odel() {   //호출되면  DefaultListModel
//		DefaultListModel<Department> model = new DefaultListModel<Department>();
//		return model;
//	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDelete) {
			actionPerformedBtnDelete(e);
		}
		if (e.getSource() == btnUpdate) {
			actionPerformedBtnUpdate(e);
		}
		if (e.getSource() == btnConfirm) {
			actionPerformedBtnConfirm(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {// 왼쪽에 입력하면 우측에 나오게 하기 -> 
		Department dept = pLeftCenter.getDepartment();  //오른쪽에 선택된걸 가져와서
//		JOptionPane.showMessageDialog(null, dept);		
//		DefaultListModel<Department> model = (DefaultListModel<Department>)deptList.getModel();
		
		
		if(btnAdd.getText().equals("추가")) {	 //버튼이 추가로 바뀌었으면
			pLeftCenter.clearTf();
			model.addElement(dept);
			JOptionPane.showMessageDialog(null, "추가되었습니다.");	
		}else {
			int idx = deptList.getSelectedIndex(); //선택한 인덱스를 찾아서
			model.setElementAt(dept, idx);			//가져온 모델을 수정한당 (받아온데이터는 dept 변경할 위치는 idx )
			pLeftCenter.clearTf();
			btnAdd.setText("추가");
		}
		
		
	}
	protected void actionPerformedBtnConfirm(ActionEvent e) {  //추가를 누르면 선택된 값을 가져와서 메세지다이어로그가 보여준다.
//		int idx = deptList.getSelectedIndex();  //위치만 가져오는거라서 쓰기 힘ㄷ르다. 
//		Department selDept = model.get(idx);
//		String message1 =String.format("%d %s %d", selDept.getDeptNo(),selDept.getDeptName(),seldept.getFloor());
	
		Department dept =  deptList.getSelectedValue();	
		String message = String.format("%d %s %d", dept.getDeptNo(),dept.getDeptName(),dept.getFloor());
		JOptionPane.showMessageDialog(null, message);
	}
	protected void actionPerformedBtnUpdate(ActionEvent e) {  //수정
	Department dept =  deptList.getSelectedValue(); 
	pLeftCenter.setDepartment(dept);   //선택된정보를 왼쪽으로 set해온당
	
	//이렇게 해도된다 1
	//if(btnAdd.getText().eqals("추가")){???
	//if(btnAdd.getText().eqals("추가"))
	//끝
	btnAdd.setText("수정");
	

	}
	protected void actionPerformedBtnDelete(ActionEvent e) { //삭제					
		Department dept =  deptList.getSelectedValue();	         //벨류로 가져온다 확인할때처럼
		 model.removeElement(dept);			//벨류에서 제거해달라 dept를!!
//		model.addElement(dept);
		JOptionPane.showMessageDialog(null, "삭제되었습니다.");
		
		
	}
}
