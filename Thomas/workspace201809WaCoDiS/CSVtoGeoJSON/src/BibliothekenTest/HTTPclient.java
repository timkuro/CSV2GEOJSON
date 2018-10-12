package BibliothekenTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPclient {

	public static void main(String[] args) throws Exception{
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("https://raw.githubusercontent.com/jokecamp/FootballData/master/other/stadiums-with-GPS-coordinates.csv");
		CloseableHttpResponse response1 = httpclient.execute(httpGet);
		
		//Fehler bei Website aufrufen
		
		StringBuffer buffer1 = new StringBuffer("");
		
		try {
			HttpEntity entity1 = response1.getEntity();
			InputStream content1 = entity1.getContent();
			BufferedReader rd = new BufferedReader(new InputStreamReader(content1));

			String line = "";
			while ((line = rd.readLine()) != null) {
				buffer1.append(line + "\n");
			}
			
		    /*
			System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    */
			
			EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}
		
		System.out.println(buffer1);
		
		


		

	}

}