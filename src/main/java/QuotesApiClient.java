import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class QuotesApiClient {
	public static void getRandomQuote() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL("https://api.api-ninjas.com/v1/quotes?category=learning");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("X-Api-Key", Keys.API_KEY.getKey());
			connection.setRequestProperty("accept", "application/json");

			try (InputStream responseStream = connection.getInputStream()) {
				ObjectMapper mapper = new ObjectMapper();
				JsonNode root = mapper.readTree(responseStream);
				String quote = root.get(0).get("quote").asText();
				String author = root.get(0).get("author").asText();
				System.out.println("\"" + quote + "\" - " + author);
			}
		} catch (MalformedURLException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

