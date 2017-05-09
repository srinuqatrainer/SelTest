package orangeHRM;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OHRM {
	public static void main(String[] args) 
	{
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		WebElement block = driver.findElement(By.xpath(".//*[@id='social-icons']"));
		List <WebElement>links = block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			links.get(i).click();
			driver.navigate().back();
			links = block.findElements(By.tagName("a"));
		}
		driver.quit();
	}
}
