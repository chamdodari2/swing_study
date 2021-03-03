package swing.study.component;  //이게 더 좋은코드다 

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class JCheckBoxCustomEx extends JFrame  implements ItemListener{

	private JPanel contentPane;
	private ArrayList<Fruit> list;
	private int sum;
	private JLabel lblTitle;
	private String resStr = "현재0 원 입니다.";
//	private JCheckBox chckbxPear;
//	private JCheckBox chckbxCherry;
	private JLabel lblRes;
	
	public JCheckBoxCustomEx(ArrayList<Fruit> list) {
		this.list = list;
		initialize();
//		list.forEach(s->System.out.print(s));
	}
	private void initialize() {
		setTitle("실전 CheckBox");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(550, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pNorth = new JPanel();
		contentPane.add(pNorth, BorderLayout.NORTH);
		
		lblTitle = new JLabel("사과 100원, 배 500원, 체리 2000원 바나나 1000");
		pNorth.add(lblTitle);
		
		JPanel pSouth = new JPanel();
		contentPane.add(pSouth, BorderLayout.SOUTH);
		
		lblRes = new JLabel("현재 0원 입니다");
		pSouth.add(lblRes);
		
		JPanel pCenter = new JPanel();
		contentPane.add(pCenter, BorderLayout.CENTER);
		
		String title = "";
		for(Fruit f : list) {
			title += f.toString()+ " "; // 과일이름일아 가격 가져와서 뒤에다가 계속 추가
			JCheckBox ck = new JCheckBox(f.getName());
			
			pCenter.add(ck);
			ck.addItemListener(this);
			
			
		}
		lblTitle.setText(title);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
//		JOptionPane.showMessageDialog(null, e.getSource());
		JCheckBox cb = (JCheckBox) e.getSource();  //선택된 체크박스. 여기에 담겨져있으면 선택된 체크박스가 올거고 그 텍스트 사과 배 ,, 겥함
		
		Fruit selecFruit = list.get(list.indexOf(new Fruit(cb.getText())));
		
		if(e.getStateChange()== ItemEvent.SELECTED) {
			sum += selecFruit.getPrice();
		}else {
			sum -= selecFruit.getPrice();
		}
		resStr = String.format("현재 %d 원 입니다.", sum);
		lblRes.setText(resStr);
		
	}	
	

}
