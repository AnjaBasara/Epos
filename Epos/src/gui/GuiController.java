package gui;

import java.awt.EventQueue;

public class GuiController {
	
	
	//ovde pisite staticke metode da bi se lakse pozivale iz MainWindow
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
