package test;
import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC7_LogoutTest {
	WebDriver driver;
	
	@Before
	public void openLogInPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
	}
	
	@Test
	public void testLogout() throws InterruptedException{
		Thread.sleep(1000);
		WebElement adminMode = driver.findElements(By.id("adminMode")).get(0);
		adminMode.click();
		Thread.sleep(1000);
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		uname.sendKeys("1");
		pwd.sendKeys("user1");
		Thread.sleep(1000);
		WebElement loginBtn = driver.findElement(By.name("submit"));
		loginBtn.click();
		WebElement logoutBtn = driver.findElement(By.tagName("a"));
		logoutBtn.click();
		Assert.assertEquals("Home Page", driver.getTitle());
	}
	
	@After
	public void closePage() {
		driver.quit();
	}
}
