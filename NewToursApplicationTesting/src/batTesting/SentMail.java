package batTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SentMail
{

	public class Inbox 
	{
		@BeforeClass
		public void LogIn()
		{
			System.out.println("Application LogIn");
		}
		
		@Test
		public void SentMail()
		{
			System.out.println("SentMail Checking");
		}
		
		@AfterClass
		public void LogOut()
		{
			System.out.println("Application SignOff");
		}
	}
}
