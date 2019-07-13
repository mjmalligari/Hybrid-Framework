package TestNGEX_Prog;

import org.testng.annotations.DataProvider;

public class TC1_DataProviderClassEx 
{
	@DataProvider(name="TC1_DataProv")
	public static Object[][] dataPro()
	{
		Object[][] arr=new Object[2][2];
		arr[0][0]="qaplanet1";
		arr[0][1]="lab1";
		arr[1][0]="qaplane1";
		arr[1][1]="lab1";
		return arr;
	}
}
