package swing.study.component.table;

import javax.swing.SwingConstants;

import swing.study.panel.Title;

public class TitleTablePanel extends AbstractCustomTablePanel<Title> {

	@Override
	protected void setAlignAndWidth() {
		setTableCellAlign(SwingConstants.CENTER, 0, 1);
		
		setTableCellWidth(100,250);
	}

	@Override
	public Object[] toArray(Title t) {
		
		return new Object[] {t.gettNo(),t.gettName()};
	}

	@Override
	public String[] getColumnNames() {  //필요한거있으면 이렇게 오버라이딩 해주면된다ㅏ
	
		return new String[] {"직책번호","직책명"};
	}
	
	

	

}
