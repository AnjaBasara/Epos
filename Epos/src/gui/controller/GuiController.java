package gui.controller;
import java.awt.EventQueue;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public static List<InspirationQuote> listOfQuotes = new ArrayList<>();

	
	public static int num = 0; //Broji quotove za OldQuote, pogledati metode returnPreviousQuote i returnNextQuote
	//ovde pisite staticke metode da bi se lakse pozivale iz MainWindow
	
	
	public static void main(String[] args) throws Exception {
		deserialize();
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
		quote = comm.getQuote();
	}
		
	

	public static void serialize() throws IOException{ /////////////////////////////
		//Google biblioteka za json, pravi objekat klase Gson
		/*Gson gson = new GsonBuilder().create();
		
		try {
			FileWriter writer = new FileWriter("quote.json");
			writer.write(gson.toJson(quote)); // Marina: Gore imamo atribut quote, koji je trenutno prikazan
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		ObjectMapper  mapper = new ObjectMapper();
		mapper.writeValue(new FileOutputStream("quotes.json"), listOfQuotes);
		
	}
	
	public static void deserialize() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		InspirationQuote [] quotes = objectMapper.readValue(new FileInputStream("quotes.json"), InspirationQuote[].class); //Najlakse nam je ovako da ucitamo iz fajla
		listOfQuotes = Arrays.asList(quotes); //Parsiramo u array
		listOfQuotes = new ArrayList<>(listOfQuotes); // Ova linija je potrebna zato sto lista napravljena pomocu Arrays.asList(quotes) ne moze da se esituje
	}
	
	public static void addToList(){
		listOfQuotes.add(quote);
	}

	public static void exitApp() throws IOException {
		// TODO Auto-generated method stub
		int option = JOptionPane.showConfirmDialog(mainWindow.getContentPane(), "Are you sure you want to exit?",
				"Exit", JOptionPane.YES_NO_OPTION);

		if (option == JOptionPane.NO_OPTION)
			return;
		if (option == JOptionPane.YES_OPTION) {
			//Ovde ide za serijalizaciju linija
			serialize();
			System.out.println("cuvaju se quoteovi");
			System.exit(0);
		}
	}
	
	public static InspirationQuote returnPreviousQuote(){
		if(num > 0) num--;
		return listOfQuotes.get(num);
	}
	
	public static InspirationQuote returnNextQuote(){
		if(num < listOfQuotes.size() - 1) num++; //Mozda da se izbaci greska, tj da se kaze korisniku da nema vise quotova dalje, vazi i za preth. metodu
		return listOfQuotes.get(num);
	}
}
