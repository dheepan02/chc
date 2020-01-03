package TestPack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class hellojava {

	@BeforeSuite
	public void beforesuite() {
		System.out.println("Before suite");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("Before test");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("after test");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("after class");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before method");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("after method");
	}

	@BeforeGroups(value = "database")
	public void beforegroup() {
		System.out.println("before group");
	}

	@AfterGroups(value = "database")
	public void aftwrgroup() {
		System.out.println("after group");
	}

	@BeforeGroups(value = "ui")
	public void beforegroupui() {
		System.out.println("before group ui");
	}

	@AfterGroups(value = "ui")
	public void aftwrgroupui() {
		System.out.println("after group ui");
	}

	private String str;

	public hellojava(String s) {
		this.str = s;
	}

	@DataProvider(name = "testdata")

	public Object[][] getData() {

		Object[][] obj = new Object[2][2];
		obj[0][0] = "user1";
		obj[0][1] = "pass1";
		 obj[1][0] = "user2";
		 obj[1][1] = "pass2";
		return obj;

	}

	// , dependsOnMethods = "test1"
	@Test(priority = 1, groups = "ui", dataProvider = "testdata", invocationCount = 1, threadPoolSize = 4, dependsOnMethods = "test1", alwaysRun = true)
	// @Test(dataProvider = "testdata", priority =1, dependsOnMethods = "test1" )
	public void test2(String sUsername, String sPassword) {

		System.out.println(sUsername);
		System.out.println(sPassword);

	}

	@Test(priority = 0,description="summa", groups = "database", alwaysRun = true)
	@Parameters({ "auther", "counts" })
	public void test1(@Optional("tester")String auther, @Optional("888")int counts) {
		// System.out.println("Test1 test method. str = " + str);
		System.out.println(auther);
		System.out.println(counts);
	}

	public class SimpleTestFactory {
		@Factory
		public Object[] factoryMethod() {
			Object[] testes = new Object[1];
			testes[0] = new hellojava("sample string");
			// testes[1] = new hellojava("p");
			return testes;
			// return new Object[] { new hellojava(), new hellojava(),new hellojava() };
		}
	}
}
