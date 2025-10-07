package Docker;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class FireFoxTest4 {

	@Test
	public void Test() throws MalformedURLException {
		FirefoxOptions options = new FirefoxOptions();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, options);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String title = driver.getTitle();
		System.out.println("Title is : "+title);
		driver.quit();
	}
}
