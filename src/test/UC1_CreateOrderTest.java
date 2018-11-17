package test;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC1_CreateOrderTest {
	WebDriver driver;

	@Before
	public void openCreateOrderPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
		Thread.sleep(500);
	}
	
	@Test
	public void backToHome() throws InterruptedException{
		driver.findElement(By.id("menu")).click();
		Thread.sleep(500);
		driver.findElement(By.id("returnBtn")).click();
		Thread.sleep(500);
		Assert.assertEquals("Home Page", driver.getTitle());
	}
	
	@Test
	public void backToCart() throws InterruptedException {
		driver.findElement(By.id("menu")).click();
		List<WebElement> dishList = driver.findElements(By.className("addDish"));
		for (WebElement dish : dishList) {
			dish.click();
		}
		driver.findElement(By.id("checkoutOrder")).click();
		Thread.sleep(500);
		driver.findElement(By.id("backBtn")).click();
		Thread.sleep(500);
		Assert.assertEquals("Create Order", driver.getTitle());
	}

	@Test
	public void createOrderSuccess() throws InterruptedException {
		driver.findElement(By.id("menu")).click();
		List<WebElement> dishList = driver.findElements(By.className("addDish"));
		for (WebElement dish : dishList) {
			dish.click();
		}
		driver.findElement(By.id("checkoutOrder")).click();
		Thread.sleep(500);
		driver.findElement(By.id("swipeCard")).click();
		Thread.sleep(500);
		String successMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		Assert.assertEquals("Saving order success!", successMsg);
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
