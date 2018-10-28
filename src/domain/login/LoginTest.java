package domain.login;


import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	WebDriver driver;
	
	@Before
	public void openLogInPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOADProject/");
	}
	
	@Test
	public void testLoginSuccess() throws InterruptedException{
		Thread.sleep(3000);
		WebElement adminMode = driver.findElements(By.tagName("button")).get(0);
		adminMode.click();
		Thread.sleep(3000);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("12345");
		Thread.sleep(3000);
		WebElement loginBTN = driver.findElement(By.name("submit"));
		loginBTN.click();
		Thread.sleep(3000);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	@Test
	public void testLoginFailure() throws InterruptedException {
		Thread.sleep(3000);
		WebElement adminMode = driver.findElements(By.tagName("button")).get(0);
		adminMode.click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("fail");
		Thread.sleep(3000);
		WebElement loginBTN = driver.findElement(By.name("submit"));
		loginBTN.click();
		Thread.sleep(3000);
		Assert.assertNotEquals("Welcome Page", driver.getTitle());
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
