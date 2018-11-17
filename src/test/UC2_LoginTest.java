package test;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC2_LoginTest {
	WebDriver driver;
	
	@Before
	public void openLogInPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
	}
	
	@Test
	public void testLoginSuccess() throws InterruptedException{
		Thread.sleep(500);
		WebElement adminMode = driver.findElements(By.id("adminMode")).get(0);
		adminMode.click();
		Thread.sleep(500);
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		uname.sendKeys("1");
		pwd.sendKeys("user1");
		Thread.sleep(500);
		WebElement loginBtn = driver.findElement(By.name("submit"));
		loginBtn.click();
		Thread.sleep(500);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void testLoginFailure() throws InterruptedException {
		Thread.sleep(500);
		WebElement adminMode = driver.findElements(By.id("adminMode")).get(0);
		adminMode.click();
		Thread.sleep(500);
		WebElement uname = driver.findElement(By.id("username"));
		WebElement pwd = driver.findElement(By.id("password"));
		uname.sendKeys("randomName");
		pwd.sendKeys("randomPass");
		Thread.sleep(500);
		WebElement loginBtn = driver.findElement(By.name("submit"));
		loginBtn.click();
		Thread.sleep(500);
		Assert.assertNotEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void returnToHomePage() throws InterruptedException{
		Thread.sleep(500);
		WebElement adminMode = driver.findElements(By.id("adminMode")).get(0);
		adminMode.click();
		Thread.sleep(500);
		WebElement returnBtn = driver.findElement(By.tagName("a"));
		returnBtn.click();
		Thread.sleep(500);
		Assert.assertEquals("Home Page", driver.getTitle());
		Thread.sleep(500);
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
