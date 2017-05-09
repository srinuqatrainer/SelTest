package batTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Inbox 
{
	@BeforeClass
	public void LogIn()
	{
		System.out.println("Application LogIn");
	}
	
	@Test
	public void InBox()
	{
		System.out.println("InBox Checking");
	}
	
	@AfterClass
	public void LogOut()
	{
		System.out.println("Application SignOff");
	}
}
