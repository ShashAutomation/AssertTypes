package AssertTypes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Hardassert {
	 WebDriver driver;
	    SoftAssert asserts;
		@BeforeMethod
		public void chromeRun()
		{
			System.setProperty("webdriver.chrome.driver", "E:\\lib\\Chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.com/");
			
		}
		@Test(priority=1)
		public void test1()    //failed
		{
			String title=driver.getTitle();
			System.out.println(title);
			Assert.assertEquals(title, "Google123","title not matched");     //fail code
			System.out.println(driver.getCurrentUrl());     //URL not printed on console
	
		}
		
		@AfterMethod
		public void close()
		{
			driver.quit();
		}
}
