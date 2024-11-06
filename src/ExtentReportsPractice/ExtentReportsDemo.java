package ExtentReportsPractice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
		//ExtentReports, ExtentSparksReporter
		
		String path=System.getProperty("user.dir")+"//Reports//index.html";
		
		ExtentSparkReporter reporter=new  ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Result");
		reporter.config().setReportName("Web Automation");
		
		extent=new  ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "sonali");
	}
	
	@Test
	public void initialDemo() {
		
		ExtentTest eTest=extent.createTest("initialDemo");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com");
		
		System.out.println(driver.getTitle());
		eTest.log(Status.FAIL, "Test Fail");
		eTest.log(Status.PASS, "Test Completed");

		extent.flush();
	}

}
