package AssertTypes;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert {
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
	public void test1()     //should fail, but passed.
	{
		String title=driver.getTitle();
		System.out.println(title);
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(title, "Google123","title not matched");    //fail code
		System.out.println(driver.getCurrentUrl());     //URL printed on console
		
	}
	@Test(priority=2)
	public void test2()     //failed!
	{
		String title=driver.getTitle();
		System.out.println(title);
		SoftAssert assert1=new SoftAssert();
		assert1.assertEquals(title, "Google123","title not matched");
		assert1.assertAll();   //code is recommended
		
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
}
