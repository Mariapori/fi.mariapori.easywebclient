package fi.mariapori.easywebclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class WebClient {
	public static String DownloadString(String URL) throws IOException {
		URL url = new URL(URL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		List<String> rivit = new ArrayList<String>();
		BufferedReader br = null;
		if (con.getResponseCode() == 200) {
		    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    String strCurrentLine;
		        while ((strCurrentLine = br.readLine()) != null) {
		        	rivit.add(strCurrentLine);
		        }
				String result = String.join(", ", rivit);
				return result.replace(",", "");
		}	
		return null;
	}
}
