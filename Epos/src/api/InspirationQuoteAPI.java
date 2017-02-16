package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import domain.InspirationQuote;

public class InspirationQuoteAPI {
	

	//URL na kom se nalazi JSON objekat, vraca nasumicno izabran citat
	private static final String quoteURL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
	
	//metoda koja pravi objekat klase InspirationQuote i puni ga podacima iz JSON objekta
	public InspirationQuote getQuote() throws ParseException {
		try {
			//poziv metode koja primenjuje GET metodu nad URL-om, rezultat je u obliku String-a
			String result = sendGet(quoteURL);
			
			//Google biblioteka za json, pravi objekat klase Gson
			Gson gson = new GsonBuilder().create();
			//Izvlaci se JSON objekat
			JsonObject quoteJson = gson.fromJson(result, JsonObject.class);

			//pravi se objekat klase InspirationQuote i puni odgovarajucim atributima
			InspirationQuote q = new InspirationQuote();
			q.setQuoteText(quoteJson.get("quoteText").getAsString());
			q.setQuoteAuthor(quoteJson.get("quoteAuthor").getAsString());
			q.setSenderName(quoteJson.get("senderName").getAsString());
			q.setSenderLink(quoteJson.get("senderLink").getAsString());
			q.setQuoteLink(quoteJson.get("quoteLink").getAsString());		
			
			//vraca se citat
			return q;
		//handlovanje izuzetaka	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//metoda za slanje GET zahteva za dati URL
	private String sendGet(String url) throws IOException {
		
		//Pravljenje objekta tipa URL na osnovu Stringa
		URL obj = new URL(url);
		
		//Otvaranje HTTP konekcije
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		//slanje GET zahteva
		con.setRequestMethod("GET");
		
		//Ucitavanje Stringova preko bafera
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

		boolean endReading = false;
		String response = "";

		while (!endReading) {
			String s = in.readLine();

			if (s != null) {
				response += s;
			} else {
				endReading = true;
			}
		}
		in.close();
		
		//vracanje odgovora u vidu Stringa
		return response.toString();
	}



}
