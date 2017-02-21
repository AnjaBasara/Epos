package gui.controller;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.JsonObject;

import api.InspirationQuoteAPI;
import domain.InspirationQuote;
import gui.MainWindow;
import gui.NewQuotes;
import gui.OldQuotes;

public class GuiController {
	//Staticki atributi
	public static InspirationQuote quote;
	public static JsonObject quoteJson;
	public static MainWindow mainWindow;
	//ovde pisite staticke metode da bi se lakse pozivale iz MainWindow
	
	
	public static void main(String[] args) throws Exception {
		generateQuote();
		showMainWindow();
		
	}
	
	public static void showOldQuotes(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OldQuotes frame = new OldQuotes();
					frame.setVisible(true);
					mainWindow.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showMainWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(mainWindow == null)mainWindow = new MainWindow();
					mainWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void showNewQuotes(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewQuotes frame = new NewQuotes();
					frame.setVisible(true);
					mainWindow.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void generateQuote() throws ParseException{
		InspirationQuoteAPI comm = new InspirationQuoteAPI();
		quoteJson = comm.getQuote();
		quote = extractQuoteFromJsonObjest(quoteJson);
	}
	
	public static InspirationQuote extractQuoteFromJsonObjest(JsonObject quoteJson){
		InspirationQuote q = new InspirationQuote();
		//pravi se objekat klase InspirationQuote i puni odgovarajucim atributima
		q.setQuoteText(quoteJson.get("quoteText").getAsString());
		q.setQuoteAuthor(quoteJson.get("quoteAuthor").getAsString());
		q.setSenderName(quoteJson.get("senderName").getAsString());
		q.setSenderLink(quoteJson.get("senderLink").getAsString());
		q.setQuoteLink(quoteJson.get("quoteLink").getAsString());
		return q;
	}

	public static void serialize(){
		
	}

	public static void exitApp() {
		// TODO Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(mainWindow.getContentPane(), "Are you sure you want to exit?",
				"Exit", JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.NO_OPTION)
			return;
		if (option == JOptionPane.YES_OPTION) {
			//Ovde ide za serijalizaciju linija
			System.exit(0);
		}
	}
}
