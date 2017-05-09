package staticWebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class CaptureCompleteWebTableData 
{

	public static void main(String[] args) 
	{
FirefoxDriver driver = new FirefoxDriver();
		
		driver.get("http://timeanddate.com/worldclock");
		
		Sleeper.sleepTightInSeconds(15);

		// html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[1]/td[1]/a
		// html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[36]/td[1]/a
		// html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[36]/td[8]
		
		String Part1 = "html/body/div[1]/div[7]/section[2]/div[1]/table/tbody/tr[";
		String Part2 = "]/td[";
		String Part3 = "]";

		for(int i=1;i<=36;i++)
		{
			for(int j=1;j<=8;j++)
			{
				String x = driver.findElement(By.xpath(Part1+i+Part2+j+Part3)).getText();
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
		
	}

}
