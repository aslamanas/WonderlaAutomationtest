package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Content_wonderla;

public class Wonderla_test {
	WebDriver driver;
	String srt="https://www.wonderla.com/";
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void url()
	{
		driver.get(srt);
	}
	@Test
	
	public void testt() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Content_wonderla obi=new Content_wonderla(driver);
		
		obi.titlevrf();
		obi.converf();
		obi.logoverify();
		//obi.locators();
		obi.links();
		obi.dpdn();
		obi.scroling();
		obi.ss();
		//obi.alerts();
		obi.windhand();
		//obi.crossbtest("browser");
		
	}	
	
}
