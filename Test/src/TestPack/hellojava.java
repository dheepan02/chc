package TestPack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class hellojava {
	private String str;

	public  hellojava(String s) {
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

	// , dependsOnMethods = "test1"....
	@Test(priority = 1, dataProvider = "testdata")
	// @Test(dataProvider = "testdata", priority =1, dependsOnMethods = "test1" )
	public void test2(String sUsername, String sPassword) {

		System.out.println(sUsername);
		System.out.println(sPassword);

		WebDriver driver;
	}

	@Test(priority = 0)
	public void test1( ) {
		System.out.println("Test1 test method. str = "+str);

	}

	public class SimpleTestFactory {
		@Factory
		public Object[] factoryMethod() {
			Object[] testes = new Object[2];
			testes[0] = new hellojava("o");
			testes[1] = new hellojava("p");
			return testes;
			// return new Object[] { new hellojava(), new hellojava(),new hellojava() };
		}
	}
}
