package BibliothekenTest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class Test {

	public static void main(String[] args) throws Exception {

		// The fluent API relieves the user from having to deal with manual deallocation
		// of system
		// resources at the cost of having to buffer response content in memory in some
		// cases.

		Content c = Request.Get("https://raw.githubusercontent.com/jokecamp/FootballData/master/other/stadiums-with-GPS-coordinates.csv").execute().returnContent();
		System.out.println(c.asString());
		
		

	}
}