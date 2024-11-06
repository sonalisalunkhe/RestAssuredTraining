package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScr {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		

		FileUtils.copyFile(scr, new File("/Users/anuyatuser/eclipse-workspace/PracticeWorkplace/SeleniumWebDriver/src/Practice/screenshot/"+"scr.png"));
	driver.close();
	}

}
