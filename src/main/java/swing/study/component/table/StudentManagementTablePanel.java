package swing.study.component.table;

import javax.swing.SwingConstants;

import swing.study.panel.StudentManagement;

public class StudentManagementTablePanel extends AbstractCustomTablePanel<StudentManagement> {

	@Override
	protected void setAlignAndWidth() {
		
		setTableCellAlign(SwingConstants.CENTER, 0, 1,2,3,4,5,6,7,8);
		
		setTableCellWidth(100,250,100,100,100,100,100,100,100);
		
	}

	@Override
	public Object[] toArray(StudentManagement t) {
		return new Object[] {t.getStdNo(),t.getStdName(),t.getDeptName(),t.getGrade(),t.getStateName(),t.getMilitaryName(),t.getIdNo(),t.getHpNo(),t.getDayNighShift()};
	}

	@Override
	public String[] getColumnNames() {

		return new String[] {"학번","이름","학과명","학년","학적상태","병역사항","주민번호","휴대폰번호","주야구분"};
	}

}
