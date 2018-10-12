package BibliothekenTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.sound.midi.Synthesizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestHTTPClientVogella {

	public static void main(String [] args) throws Exception{
	
	StringBuffer sBuff = new StringBuffer();
	HttpClient client = new DefaultHttpClient();
	HttpGet request = new HttpGet("https://raw.githubusercontent.com/jokecamp/FootballData/master/other/stadiums-with-GPS-coordinates.csv");
	HttpResponse response = client.execute(request);

	// Get the response
	BufferedReader rd = new BufferedReader
	    (new InputStreamReader(
	    response.getEntity().getContent()));

	String line = "";
	while ((line = rd.readLine()) != null) {
	    sBuff.append(line + "\n");
	    System.out.print(sBuff.toString());
	}
	
	}
}