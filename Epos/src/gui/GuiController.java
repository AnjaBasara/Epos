package gui;

import java.awt.EventQueue;
import java.util.List;

import api.InspirationQuoteAPI;
import domain.InspirationQuote;

public class GuiController {
	
	
	//ovde pisite staticke metode da bi se lakse pozivale iz MainWindow
	
	
	public static void main(String[] args) throws Exception{
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainWindow frame = new MainWindow();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
		
		//Pravi se objekat klase InspirationQuoteAPI i poziva metoda koja vraca citat
		InspirationQuoteAPI comm = new InspirationQuoteAPI();
		InspirationQuote quote = comm.getQuote();
		System.out.println(quote.getQuoteText());
		
	}


}
