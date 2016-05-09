package Action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Can.CanArray;
import Machine.MachinePanelRight;
import Person.Admin;

public class PutMoney implements ActionListener {

	JTextField putMoneytext, takeMoneytext;
	List<JButton> blist;

	public PutMoney(JTextField putMoneytext, JTextField takeMoneytext, List<JButton> blist) {
		super();
		this.putMoneytext = putMoneytext;
		this.takeMoneytext = takeMoneytext;
		this.blist = blist;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (putMoneytext.getText().equals("")) {
			JOptionPane.showMessageDialog(new JFrame(), "돈을 넣지 않았습니다.");
		} else if (Pattern.matches("^[0-9]*$", putMoneytext.getText())) {

			boolean pattern;

			if (Integer.parseInt(putMoneytext.getText()) < 100) {
				pattern = Pattern.matches("[0,5]?0$", putMoneytext.getText());
			} else if (Integer.parseInt(putMoneytext.getText()) <= 10000) {
				pattern = Pattern.matches("[1-9]((\\d){0,2}[0,5])?0$", putMoneytext.getText());
			} else {
				pattern = false;
			}

			if (pattern == false) {
				JOptionPane.showMessageDialog(new JFrame(), "10000원 이하의 돈을 50원 단위로 넣어주세용");
			} else {

				takeMoneytext.setText(String
						.valueOf(Integer.parseInt(takeMoneytext.getText()) + Integer.parseInt(putMoneytext.getText())));
				for (int i = 0; i < blist.size(); i++) {
					if (blist.get(i).getLabel().equals(CanArray.canList.get(i).getCanName())) {
						if (CanArray.canList.get(i).getCanPrice() <= Integer.parseInt(takeMoneytext.getText())) {
							blist.get(i).setForeground(new Color(255, 255, 255));
							blist.get(i).setBackground(new Color(20, 175, 100));
						}
					}
				}
				
				Admin.setTotalMoney(Admin.getTotalMoney() + Integer.parseInt(putMoneytext.getText()));
				MachinePanelRight.totalMoneyLabel.setText("총 매출액 : " + Admin.getTotalMoney());

				putMoneytext.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(new JFrame(), "숫자 형식으로 입력해주세용");
		}
	}
}
