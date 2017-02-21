package gui;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.List;

import com.google.gson.JsonObject;

import api.InspirationQuoteAPI;
import domain.InspirationQuote;

public class GuiController {
	//Staticki atributi
	public static InspirationQuote quote;
	public static JsonObject quoteJson;
	//ovde pisite staticke metode da bi se lakse pozivale iz MainWindow
	
	
	public static void main(String[] args) throws Exception {
		generateQuote();
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
		
		//Pravi se objekat klase InspirationQuoteAPI i poziva metoda koja vraca citat
		
		
	}
	public static void showOldQuotes(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OldQuotes frame = new OldQuotes();
					frame.setVisible(true);
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
}
