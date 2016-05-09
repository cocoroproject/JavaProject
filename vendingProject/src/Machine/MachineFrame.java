package Machine;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Can.Can;
import Can.CanArray;
import Coin.Coin;
import Coin.CoinArray;

public class MachineFrame extends JFrame {
	String password;
	public MachineFrame(String password){
		this.password = password;
		
		CanArray.canList.add(new Can("사이다", 0, 750));
		CanArray.canList.add(new Can("콜라", 0, 500));
		CanArray.canList.add(new Can("밀키스", 0, 650));
		CanArray.canList.add(new Can("립톤", 0, 1350));
		CanArray.canList.add(new Can("환타", 0, 800));
		CanArray.canList.add(new Can("핫식스", 0, 1200));
		
		CoinArray.coinList.add(new Coin("500",10));
		CoinArray.coinList.add(new Coin("100",10));
		CoinArray.coinList.add(new Coin("50",10));
		
		setTitle("자판기");
		setPreferredSize(new Dimension(650,550));
		setLocation(400,150);
		WindowListener win = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}
		};
		addWindowListener(win);

		Container contentPanel = getContentPane();
		
		JPanel panelRight = new MachinePanelRight(password);
		JPanel panelLeft = new MachinePanelLeft();
		
		contentPanel.add(panelRight,BorderLayout.EAST);
		contentPanel.add(panelLeft,BorderLayout.CENTER);

		pack();
		setVisible(true);
		
	}
}
