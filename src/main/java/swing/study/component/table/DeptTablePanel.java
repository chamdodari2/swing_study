package swing.study.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import swing.study.panel.Department;

public class DeptTablePanel extends JPanel {
	private JTable table;

	public DeptTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(getModel()); // 1

		scrollPane.setViewportView(table);
	}

	public DefaultTableModel getModel() {//6
		CustomTableModel model = new CustomTableModel(getData(),getColumnNames());
		return model;
	}

	public Object[][] getData() {// 2
		return new Object[][] { { null, null, null }, };
	}

	public String[] getColumnNames() {// 3
		return new String[] { "부서번호", "부서명", "위치" };
	}

	public void setList(List<Department> deptList) { // 4
		Object[][] data = new Object[deptList.size()][]; //7
		for(int i = 0; i<data.length;i++) { //8
			data[i] = toArray(deptList.get(i));//8-2
		}
		CustomTableModel model = new CustomTableModel(data,getColumnNames()); //14
		table.setModel(model);//15
		
		//컬럼 내용 정렬			//16
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		
		//컬럼 너비 조정 			//19
		setTableCellWidth(100, 250,100);
		
		//조건에 맞는 셀 색조절
	}

	private void setTableCellWidth(int...width) { //20  
		TableColumnModel  tcm  = table.getColumnModel(); //21
		
		for(int i = 0; i<width.length;i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	private void setTableCellAlign(int align, int...idx) {//17
		TableColumnModel  tcm  = table.getColumnModel();//18
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); 
		dtcr.setHorizontalAlignment(align);
		
		for(int i = 0; i<idx.length;i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private Object[] toArray(Department department) {//9
		Object[] row = new Object[] {//10
		department.getDeptNo(),
		department.getDeptName(),
		department.getFloor()
		}; 
		return row;
	}

	private class CustomTableModel extends DefaultTableModel { //5  수정못하게
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);

		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}
}
