package Practice;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSCert {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		
		
		Proxy proxy=new Proxy();
		proxy.setHttpProxy("ip:4040");
		option.setCapability("Proxy", proxy);
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		driver.close();
	}

}
