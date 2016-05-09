package Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ActionSelectAll implements ActionListener {

	List<JCheckBox> checkList;
	
	public ActionSelectAll(List<JCheckBox> checkList) {
		this.checkList = checkList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton b = (JButton)obj;
		
		if(b.getLabel().equals("전체10개추가")){
			for(int i=0;i<checkList.size();i++){
				checkList.get(i).setSelected(true);
			}
			b.setLabel("전체해제");
		} else {
			for(int i=0;i<checkList.size();i++){
				checkList.get(i).setSelected(false);
			}
			b.setLabel("전체10개추가");
		}
		
	}

}
