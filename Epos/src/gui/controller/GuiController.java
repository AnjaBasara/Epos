package gui.controller;
import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
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
	public static InspirationQuote quote; //Quote koji je trenutno prikazan u NewQuotes prozoru
	public static MainWindow mainWindow; //Prozor koji se prvi otvara
	public static List<InspirationQuote> listOfQuotes = new ArrayList<>(); //Lista sacuvanih quote-ova	
	public static int num = 0; //Broji quotove za OldQuote, pogledati metode returnPreviousQuote i returnNextQuote

	public static void main(String[] args) throws Exception {
		//Provera internet konekcije
		if(!netIsAvailable()){
			JOptionPane.showInternalMessageDialog
					(new MainWindow().getContentPane(), "This app needs internet connection to run!",
							"No internet connection", JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		else{
		deserialize(); //Ucitavamo quote-ove iz json fajla
		generateQuote(); //Pravimo quote za NewQuotes prozor
		showMainWindow(); //Pocetak
		}
	}
	
	//Metoda za pokretanje OldQuotes prozora
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
	
	//Metoda za pokretanje MainWindow
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
	
	//Metoda za pokretanje NewQuotes prozora
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
	
	//Uzimanje quote-a sa interneta
	public static void generateQuote() throws ParseException{
		InspirationQuoteAPI comm = new InspirationQuoteAPI();	
		quote = comm.getQuote();
	}
		
	//Serijalizacija liste quotova koje korisnik zeli sacuvati pomocu ObjectMapper klase
	public static void serialize() throws IOException{ 
		ObjectMapper  mapper = new ObjectMapper();
		mapper.writeValue(new FileOutputStream("quotes.json"), listOfQuotes);
	}
	
	//Deserijalizacija
	public static void deserialize() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		//Najlakse nam je ovako da ucitamo iz fajla
		InspirationQuote [] quotes = objectMapper.readValue(new FileInputStream("quotes.json"), InspirationQuote[].class);
		listOfQuotes = Arrays.asList(quotes); //Parsiramo u array
		// Ova linija je potrebna zato sto lista napravljena pomocu Arrays.asList(quotes) ne moze da se edituje
		listOfQuotes = new ArrayList<>(listOfQuotes); 
	}
	
	//Dodavanje quote-a u listu
	public static void addToList(){
		listOfQuotes.add(quote);
	}

	//Izlazak iz aplikacije
	public static void exitApp() throws IOException {
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
	
	//Za Prozor OldQuotes, sluzi za navigaciju kroz listu
	public static InspirationQuote returnPreviousQuote(){
		if(num > 0) num--;
		return listOfQuotes.get(num);
	}
	
	//Za Prozor OldQuotes, sluzi za navigaciju kroz listu
	public static InspirationQuote returnNextQuote(){
		//Mozda da se izbaci greska, tj da se kaze korisniku da nema vise quotova dalje, vazi i za preth. metodu
		if(num < listOfQuotes.size() - 1) num++; 
		return listOfQuotes.get(num);
	}
	
	//Provera internet konekcije
	private static boolean netIsAvailable() {
	    try {
	        final URL url = new URL("http://www.google.com");
	        final URLConnection conn = url.openConnection();
	        conn.connect();
	        return true;
	    } catch (MalformedURLException e) {
	        throw new RuntimeException(e);
	    } catch (IOException e) {
	        return false;
	    }
	}

	//Prebaci num na poslednji element, koristi se kada korisnik pise svoj quote
	public static void setNumLast() {
		num = listOfQuotes.size() - 1;
	}
	
	//Vrati trenutni quote
	public static InspirationQuote getCurrentQuote(){
		return listOfQuotes.get(num);
	}

	//Izbaci quote
	public static void removeQuote() {
		listOfQuotes.remove(num);
		if(listOfQuotes.size() != 0){
			if(num == listOfQuotes.size()) num--; //Ako smo na poslednje quote-u, pomeri za jedan unazad		
		}else{
			num = -1;
		}
		
	}
}
