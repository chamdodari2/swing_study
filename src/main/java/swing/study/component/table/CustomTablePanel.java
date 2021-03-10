package swing.study.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public abstract class CustomTablePanel extends JPanel {
	private JTable table;

	public CustomTablePanel() {

		initialize();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "부서번호", "New column", "New column", "New column" }));
		scrollPane.setViewportView(table);
	}

	public DefaultTableModel getModel() {//
		CustomTableModel model = new CustomTableModel(getData(), getColumnNames());
		return model;
	}

	public Object[][] getData() {//
		return new Object[][] { { null, null, null }, };
	}

	public <T> void setList(List<T> list) {
		Object[][] data = new Object[list.size()][]; //
		for (int i = 0; i < data.length; i++) { //
			data[i] = toArray(list.get(i));//
		}
		CustomTableModel model = new CustomTableModel(data, getColumnNames()); //
		table.setModel(model);// 15
		
		setAlignAndWidth();
	
	}

	protected abstract void setAlignAndWidth();

	protected void setTableCellWidth(int... width) { // 20
		TableColumnModel tcm = table.getColumnModel(); // 21

		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void setTableCellAlign(int align, int... idx) {// 17
		TableColumnModel tcm = table.getColumnModel();// 18

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	private abstract Object[] toArray(T t);

	public abstract String[] getColumnNames(); //

	public class CustomTableModel extends DefaultTableModel {
	}

}
