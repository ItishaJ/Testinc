package Testinc.Testinc;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class inc {
	
	@Test

	public static void main() {
		 
			 System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			    System.setProperty("webdriver.chrome.logfile", "D://chromedriver.log");
			    ChromeOptions options = new ChromeOptions();
			    options.addArguments("--disable-extensions");
			    options.setBinary("C://Program Files (x86)//Google//Chrome//Application//chrome.exe");
		     WebDriver driver = new ChromeDriver(options);              
				driver.manage().window().maximize();
				WebDriverWait wait= new WebDriverWait(driver,10);

				//Google.com
				
				driver.get("https://www.google.co.in/");             //Go to google
				
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst-ib"))).sendKeys("Selenium");   //Search Term , Replace with "Selenium" with "Seleniumsdfgjlghsdfjlghjlsdfkgh;lsdhg;ld" to verify results
			    driver.findElement(By.name("btnG")).click();                                                       //Search
			    
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='rcnt']"))).isDisplayed();   //Wait for the results
			    
			    List<WebElement> results = driver.findElements(By.cssSelector("cite[class='_Rm']"));     //List of all results
			
			    if(results.size()>0){
			    System.out.println(results.size()+" results are dispalyed on Page 1. Following are the links: ");
			    
			    // Links on search term
			    for (int i=0;i<results.size()-1;i++)
			    {
			       System.out.println(results.get(i).getText());
			    }
			}else{
				
				System.out.println("No results displayed for the searched term.");
			}
    driver.close();          //close the browser
				
	}

}
