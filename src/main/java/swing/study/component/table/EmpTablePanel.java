package swing.study.component.table;

import javax.swing.SwingConstants;

import swing.study.panel.Employee;

public class EmpTablePanel extends AbstractCustomTablePanel<Employee> {

	@Override
	protected void setAlignAndWidth() {//1
		// 컬럼내용 정렬 
		setTableCellAlign(SwingConstants.CENTER, 0, 1, 2,3,4,5);
	

		// 컬럼별 너비 조절 
		setTableCellWidth(100,250,100,100,100,100); 

	}

	@Override
	public Object[] toArray(Employee t) {
		return new Object[] {  //String도 되고 int도 되야해서
		t.getEmpNo(),
		t.getEmpName(),
		t.getTitle().gettName(),
		String.format("%s,(%d)",t.getTitle().gettName(),t.getTitle().gettNo()),
		t.getManager()==null?"":t.getManager().getEmpName(),
		String.format("%,d",t.getSalary()),
		t.getDept().getDeptName(),
		String.format("%s,(%d)",t.getDept().getDeptName(),t.getDept().getDeptNo())
		};
		}

	@Override
	public String[] getColumnNames() {//2
	
		return new String[] {"사원번호","사원명","직책","직속상사","급여","부서"};
	}

}
