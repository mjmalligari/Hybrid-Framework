package TestNGEX_Prog;

	import org.openqa.selenium.WebElement; 
	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TC_Login {
	
		public static void main(String[] args) throws Exception 
		{
			System.setProperty("webdriver.chrome.driver","E:\\Eclips_Prog\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver crm=new ChromeDriver();
			crm.manage().window().maximize();
			crm.get("http://apps.qaplanet.in/qahrm/login.php");
		//crm.navigate().to("http://apps.qaplanet.in/qahrm/login.php");

			
			Thread.sleep(1000);
			
			if(crm.getTitle().equals("OrangeHRM - New Level of HR Management"))
			{
				System.out.println("Home page displayed");
			}
			else
			{
				System.out.println("Home page not dislayed");
				return;
			}
			
			WebElement un=crm.findElement(By.name("txtUserName"));
			WebElement pwd=crm.findElement(By.name("txtPassword"));
			WebElement lgn=crm.findElement(By.name("Submit"));
			WebElement clr=crm.findElement(By.name("clear"));
			
			
			//System.out.println(un.getAttribute("class"));
			
			if(un.isDisplayed())
			{
				System.out.println("User Name diplayed");
			}
			else
			{
				System.out.println("User Name not displayed");
				return;
			}
			
			if(pwd.isDisplayed())
			{
				System.out.println("Password displayed");
			}
			else
			{
				System.out.println("Password not displayed");
				return;
			}
			
			if(lgn.isDisplayed())
			{
				System.out.println("login displayed");
			}
			else
			{
				System.out.println("loign not displayed");
				return;
			}
			
			if(clr.isDisplayed())
			{
				System.out.println("Clear displayed");
			}
			else
			{
				System.out.println("Clear not displayed");
				return;
			}
			
			String Sun="qaplanet1";
			String Spwd="lab1";
		
			un.clear();
			un.sendKeys(Sun);
			pwd.clear();
			pwd.sendKeys(Spwd);
			lgn.click();
			
			Thread.sleep(2000);
			 
			String Wlctxt=crm.findElement(By.xpath("//ul[@id='option-menu']/li[1]")).getText();
			
			if(Wlctxt.equals("Welcome "+Sun))
			{
				System.out.println("Welcome "+Sun+" displayed");
			}
			else
			{
				System.out.println("welcome "+Sun+" not displayed");
				return;
			}
			
			WebElement cpwd=crm.findElement(By.linkText("Change Password"));
			WebElement lgt=crm.findElement(By.linkText("Logout"));
			
			if(cpwd.isDisplayed())
			{
				System.out.print("Change Password displayed");
			}
			else
			{
				System.out.print("Change Password is not displayed");
				return;
			}
			
			if(lgt.isDisplayed())
			{
				System.out.println("Logout displayed");
			}
			else
			{
				System.out.println("Logout not diaplayed");
				return;
			}
			
			lgt.click();
			
			Thread.sleep(2000);
			
			if(crm.getTitle().equals("OrangeHRM - New Level of HR Management"))
			{
				System.out.println("Logout success and Home page displayed");
				
			}
			else
			{
				System.out.println("Failed to Logout");
				return;
			}
			
			crm.close();
			crm.quit();
}
}