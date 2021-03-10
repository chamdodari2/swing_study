package swing.study.component.table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MyTablePanel extends JPanel {
	private JTable table;

	public MyTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(getModel());
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 목록에서 컨트롤 눌러도 하나만 선택되게하기
		scrollPane.setViewportView(table);
	}

	public DefaultTableModel getModel() {
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	public String[] getColumnNames() {
		return new String[] { "학생번호", "학생명", "국어", "영어", "수학", "총점", "평균" };
	}

	public Object[][] getData() { // 이거수정쓰

		Object[][] datas = new Object[1][7]; // 1행7열에 넣기
		datas[0] = new Object[] { null, null, null, null, null, null, null }; // 0번에
		return datas;
	}

	public void setList(List<Student> stdList) {
		Object[][] datas = new Object[stdList.size()][]; // 학생수로 확인가능
		for (int i = 0; i < datas.length; i++) { // 행의 갯수만큼 반복돌리기
			datas[i] = toArray(stdList.get(i)); // 함수 하나더만듬
		}

		CustomTableModel model = new CustomTableModel(datas, getColumnNames());
		table.setModel(model);

		// 컬럼내용 정렬
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		setTableCellAlign(SwingConstants.RIGHT, 2,3,4,5,6);
		//end 
		
		//컬럼별 너비 조절
		setTableCellwidth(100,150,80,80,80,80,80);
		//end

		//조건에 맞는 셀 색조절(총점이 200점 미만은 빨강)
		setTableCellCondition(0,1,2,3,4,5,6);
	}

	public void setTableCellCondition(int...idx) {
		conditionTableCellRenderer ctcr = new conditionTableCellRenderer();
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(5).setCellRenderer(ctcr);
		for(int i= 0; i< idx.length;i++) {
			tcm.getColumn(idx[i]).setCellRenderer(ctcr);
			}
	}
	
	

	public void setTableCellwidth(int...width) {
		TableColumnModel tcm = table.getColumnModel(); // 각 컬럼(7개)을 가져와서 거기다가
		
		for(int i= 0 ; i< width.length;i++) {
		tcm.getColumn(i).setPreferredWidth(width[i]);
		}
		
	}

	public void setTableCellAlign(int align, int... idx) { // idx 가변배열 
		TableColumnModel tcm = table.getColumnModel(); // 각 컬럼(7개)을 가져와서 거기다가 조절할거임
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr); // 0번칼럼에는 가운데정렬해달라

		}
	}

	private Object[] toArray(Student std) {
		Object[] data = new Object[] { std.getStdNo(), // 맨첫번째에 학생번호 받아서넣기
				std.getStdName(), std.getKor(), std.getEng(), std.getMath(), std.getTotal(),
				String.format("%.2f", std.getAvg()) };

		return data;
	}

	private class CustomTableModel extends DefaultTableModel {

		
		public CustomTableModel(Object[][] data, Object[] columnNames) {
			super(data, columnNames);

		}

		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}

	}
	private class conditionTableCellRenderer extends JLabel implements TableCellRenderer{  //얘추가함

		@Override  //해당하는 조건에 맞는지 모든 칼럼 순회   value는 값이 들어가있는것을 이야기함
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value==null?"":value.toString());  //공백이냐
			setOpaque(true);
			int total = (int)table.getValueAt(row,5);  //총점에 있는걸 가지고 할거다
			if(total <200) { //row는 그대로, 열은 바뀌어야함 : 5번째에 있는 값을 의미
			setBackground(Color.orange);
			}else {
				setBackground(Color.WHITE);
			}
				setHorizontalAlignment(SwingConstants.RIGHT);
				return this;
		}
		
	}

}
