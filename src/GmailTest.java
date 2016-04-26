import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import OtherFiles.Common;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;


public class GmailTest
{

	// Create webdriver interface reference as fields of test class
	WebDriver driver;
	private String baseUrl;
Common common = new Common(driver);
	// Call class method setup, and instanciate webdriver interface reference with FirefoxDriver
	@BeforeClass
	
		public void setUp() throws IOException, Exception {
			driver = new FirefoxDriver();
			Thread.sleep(5000);
			driver.manage().window().maximize();
			 baseUrl = "https://www.google.co.in/";
	    
	}

	// Call class method tearDown, and close firefox driver instance
	@AfterClass
	public void tearDown() throws IOException {
		
		driver.quit();
	}
	
	@Test (priority=1)
	public void LogIn() throws ParseException, InterruptedException {
		Thread.sleep(3000);
		driver.get(baseUrl + "/?gfe_rd=cr&ei=W7QdV83qCsz08wfslpiQBQ&gws_rd=ssl");
		common.log("<br></br> Step :: Click On LogIn.");
		driver.findElement(By.id("gb_70")).click();
		Thread.sleep(2000);
		common.log("<br></br> Step :: Enter Registered Email Address.");
		  driver.findElement(By.id("Email")).clear();
		    driver.findElement(By.id("Email")).sendKeys("manisha.vtest@gmail.com");	
		    driver.findElement(By.id("next")).click();
		    Thread.sleep(3000);
		common.log("<br></br> Step :: Enter Password.");
		 driver.findElement(By.id("Passwd")).clear();
		    driver.findElement(By.id("Passwd")).sendKeys("Manisha@123");
		common.log("<br></br> Step :: Click On Login");
    driver.findElement(By.id("signIn")).click();  
    Reporter.log(" successfully Login");
		  
		    
			}
	@Test (priority=2)
	public void SendMail() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='gbw']/div/div/div[1]/div[2]/a")).click();
		Thread.sleep(5000);
		common.log("<br></br> Step :: Click On Compose button .");
		// driver.switchTo().frame("canvas_frame");
		driver.findElement(By.xpath("//div[@class='z0']/div")).click();

		/* Enter email details */
		Thread.sleep(1000);
		common.log("<br></br> Step :: Enter mail Id .");
		driver.findElement(By.xpath("//td//img[2]")).click();
		driver.findElement(By.className("vO")).sendKeys("test@test.com");
		common.log("<br></br> Step :: Enter subject.");
		driver.findElement(By.className("aoT")).sendKeys("Testing Mail");
		
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		
		driver.findElement(By.xpath("//*[@id=':nv']")).sendKeys("Message");
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_ENTER);
		common.log("<br></br> Step ::Verify message has been sent sucessfully.");
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.vh")).getText(), "Your message has been sent. View message");
		Reporter.log("Mail sent successfully ");
	}
	
	
	public void Logout() throws ParseException, InterruptedException {
		driver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span']")).click();
		driver.findElement(By.xpath("//*[@id='gb_71']']")).click();
		common.log("<br></br>Log Out Sucessfully.");
		Reporter.log(" successfully Logout");
	}
 
	
	
	
}



