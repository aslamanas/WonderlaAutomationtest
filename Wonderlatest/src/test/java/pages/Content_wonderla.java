package pages;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;

public class Content_wonderla {
	WebDriver driver;
	
	public Content_wonderla(WebDriver driver)
	{
		this.driver=driver;
	}
		
	
	public void titlevrf()
	{
		System.out.println(driver.getTitle());
		String At=driver.getTitle();
		String Ex="ammusment park";
		if(At.equals(Ex))
		{
			System.out.println("Title pass");
		}
		else
		{
			System.out.println("Title fail");
		}
	} 
	
	
	
	
	public void converf()
	{
		String con=driver.getPageSource();
		if(con.contains("English"))
		{
			System.out.println("Content pass");
		}
		else
		{
			System.out.println("Content fail");
		}
	}
	
	
	
	
	public void logoverify()
	{
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/nav/div[2]/div[2]/a/img"));
		boolean l=logo.isDisplayed();
		if(l)
		{
			System.out.println("logo is visible");
		}
		else
		{
			System.out.println("logo is not visible");
		}
	}
	
	
	
	
	
	/*public void locators()
	{
		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[1]/div[1]/div/div/ul/li[2]/a")).click();
		driver.navigate().back();
	} */
	
	
	
	
	
	public void links()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
		System.out.println(li.size());
		for(WebElement f:li)
		{
			String link=f.getAttribute("href");
			String text=f.getText();
		}
	}
	
	
	
	
	
	public void dpdn()
	{
		WebElement dropdown=driver.findElement(By.xpath("//*[@id=\"top-navbar-collapse\"]/li[4]/a"));
		JavascriptExecutor jj=(JavascriptExecutor) driver;
		jj.executeScript("arguments[0].click();", dropdown);
	
	} 
	
	

	
	
	public void scroling()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div[2]/div[2]/div/div[2]/div/a[3]"));
	}
	
	
	
	
	
	public void ss() throws Exception
	{
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(ss,new File("C:\\Users\\User\\wonder\\ang.png"));
		
		WebElement lg=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/nav[1]/div[2]/div[2]/a/img"));
		File im=lg.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(im,new File("./Screenshot/aa.png"));
	}
	
	
	
	
	
	
	
	/*
	public void alerts()
	{
		driver.findElement(By.xpath("//*[@id=\"top-navbar-collapse\"]/li[3]/a")).click();
		//driver.switchTo().alert().accept()/dismiss();
		Alert a=driver.switchTo().alert();
		String Actual=a.getText();
		System.out.println(Actual);
		a.dismiss();
		if(Actual.equals("hi"))
		{
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
	} 
*/
	
	
	
	
	public void windhand()
	{
		String parentwindow=driver.getWindowHandle();
		System.out.println("parent window title  " +driver.getTitle());
		driver.findElement(By.xpath("/html/body/main/header/nav/div[2]/div[1]/div/button")).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for(String handle:allwindowhandles)
		{
			System.out.println(handle);
			if(!handle.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(handle);
				driver.findElement(By.xpath("/html/body/main/header/nav/div[2]/div[1]/div/div/div/div/div/div/div[2]/div[7]/div/input")).click();
				driver.close();
			}
			driver.switchTo().window(parentwindow);
		}
	}
	
	
	/*
	@Parameters("browser")
	 public void crossbtest(String browser)
	 {
		if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Edge")) 
		{
			driver=new EdgeDriver();
		}
	 }
	*/
	
	
	
	
	
	
	
	
	
	
	
}

	
		
		
		
