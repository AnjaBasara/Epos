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
	


	private static final String quoteURL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

	public InspirationQuote getQuote() throws ParseException {
		try {
			String result = sendGet(quoteURL);

			Gson gson = new GsonBuilder().create();
			JsonObject quotesJson = gson.fromJson(result, JsonObject.class);

			
				JsonObject quoteJson = (JsonObject) quotesJson;
				InspirationQuote q = new InspirationQuote();
				q.setQuoteText(quoteJson.get("quoteText").getAsString());
				q.setQuoteAuthor(quoteJson.get("quoteAuthor").getAsString());
				q.setSenderName(quoteJson.get("senderName").getAsString());
				q.setSenderLink(quoteJson.get("senderLink").getAsString());
				q.setQuoteLink(quoteJson.get("quoteLink").getAsString());		
				

			return q;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String sendGet(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

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

		return response.toString();
	}



}
