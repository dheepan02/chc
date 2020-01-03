package TestPack;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Opengoogle {

	WebDriver driver;

	String testName = "";

	// @BeforeTest
	// @Parameters({ "test-name" })
	public void beforeTest(String testName) {
		this.testName = testName;
		long id = Thread.currentThread().getId();
		System.out.println("Before test " + testName + ". Thread id is: " + id);
	}

	// @BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Before test-class " + testName + ". Thread id is: " + id);
	}

	@Test
	public void testMethodOne() throws MalformedURLException, InterruptedException {
		long id = Thread.currentThread().getId();
		String URL = "http://www.DemoQA.com";
		String Node = "http://192.168.40.32:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setVersion("60.5.1");
		cap.setPlatform(Platform.WINDOWS);
		cap.setCapability("marionette", true);

		driver = new RemoteWebDriver(new URL(Node), cap);

		driver.navigate().to(URL);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("Sample test-method " + testName + ". Thread id is: " + id);
	}

	// @AfterClass
	public void afterClass() {
		long id = Thread.currentThread().getId();
		System.out.println("After test-method  " + testName + ". Thread id is: " + id);
	}

	@AfterTest
	public void afterTest() {
		long id = Thread.currentThread().getId();
		System.out.println("After test  " + testName + ". Thread id is: " + id);
	}
}
