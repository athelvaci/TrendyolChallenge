package testing;

import static org.junit.Assert.*;

import org.junit.Test;
import com.trendyolConf.spring.library.ConfigurationReader;

public class ConfigurationTest {

	@Test
	public void test() {
		
		ConfigurationReader configurationReader = new ConfigurationReader("SERVICE-A", "jdbc:mysql://localhost/trendyolcase", 3000);
		String output = configurationReader.getValue("SiteName");
		assertEquals(output, "trendyol.com");
		while(true){
			output = configurationReader.getValue("ayse");
			System.out.println("TEST----- "+output);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

}
