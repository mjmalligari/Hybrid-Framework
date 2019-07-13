package TestNGEX_Prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.*;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC1_DataProv_thruOtherClass  // extends TC1_DataProviderClassEx
{
	WebDriver driver;
	WebDriverWait wait;
	
	
	@BeforeClass
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Eclips_Prog\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 60);
	}
	
	@AfterClass
	public void end()
	{
		driver.close();
		driver.quit();
	}
	
	@Test(dataProvider="TC1_DataProv", dataProviderClass=TC1_DataProviderClassEx.class)
	public void execut(String sun,String spwd)
	{
		
		driver.get("http://apps.qaplanet.in/hrm/login.php");
		
		assertEquals(driver.getTitle(), "OrangeHRM - New Level of HR Management");
		Reporter.log("OrangeHRM - New Level of HR Management page is displayed");
		
		WebElement un=driver.findElement(By.name("txtUserName"));
		assertTrue(un.isDisplayed());
		Reporter.log("UN Displayed");
		
		WebElement pwd=driver.findElement(By.name("txtPassword"));
		assertTrue(pwd.isDisplayed());
		Reporter.log("PWD Displayed");
		
		WebElement lgn=driver.findElement(By.name("Submit"));
		assertTrue(lgn.isDisplayed());
		Reporter.log("Login button displayed");
		
		un.clear();
		un.sendKeys(sun);
		pwd.clear();
		pwd.sendKeys(spwd);
		
		lgn.click();
		
		assertEquals(driver.getTitle(), "OrangeHRM");
		Reporter.log("OrangeHRM page is displayed");
		
	}
	
}
