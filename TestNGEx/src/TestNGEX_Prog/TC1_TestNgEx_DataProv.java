package TestNGEX_Prog;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
	import static org.testng.Assert.*;


	import org.testng.Reporter;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

public class TC1_TestNgEx_DataProv {


		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void start()
		{
			System.setProperty("webdriver.chrome.driver","E:\\Eclips_Prog\\chromedriver_win32\\chromedriver.exe");
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
		
			
		//with data providers
		@DataProvider(name="logindetails")
		public Object[][] logindtls()
		{
			Object[][] lgnarr=new Object[2][2];
			lgnarr[0][0]="qaplanet1";
			lgnarr[0][1]="lab1";
			lgnarr[1][0]="qaplane2";
			lgnarr[1][1]="lab2";
			return lgnarr;
		}
		
		@Test(dataProvider="logindetails")
		
		public void datProExecut(Object sun, Object spwd)
		{
			driver.get("http://apps.qaplanet.in/hrm/login.php");
			
			assertEquals(driver.getTitle(), "OrangeHRM - New Level of HR Management");
			Reporter.log("OrangeHRM - New Level of HR Management page displayed\n");
			
			WebElement un=driver.findElement(By.name("txtUserName"));
			assertTrue(un.isDisplayed());
			
			WebElement pwd=driver.findElement(By.name("txtPassword"));
			assertTrue(pwd.isDisplayed());
			
			WebElement lgn=driver.findElement(By.name("Submit"));
			assertTrue(lgn.isDisplayed());
			
			Reporter.log("UN, PWD, lgn displayed\n");
			String s1=sun.toString();
			String s2=spwd.toString();
			System.out.println(s1);
			System.out.println(s2);
			
			un.clear();
			un.sendKeys(s1);
			pwd.clear();
			pwd.sendKeys(s2);
			
			lgn.click();
			
			assertEquals(driver.getTitle(), "OrangeHRM");
			Reporter.log("OrangeHRM page displayed");
		}
		
		
	}	

