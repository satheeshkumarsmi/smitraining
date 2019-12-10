package Services;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;
import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
@Test
public class JunitTest {
	
	private static final String AssertJUnit = null;

	@Test
	public void batchRepository() throws URISyntaxException 
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    String randomServerPort="8080";
		final String baseUrl = "http://localhost:" + randomServerPort + "/insertbatch";
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	     
	    //Verify request succeed	    assertEquals(200, result.getStatusCodeValue());
	    assertEquals(true, result.getBody().contains("res"));
	}
}
