package Docker;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest2 {

	@Test
	public void Test() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String title = driver.getTitle();
		System.out.println("Title is : "+title);
		driver.quit();
	}
}
