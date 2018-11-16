package test;

import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrderTest {
	WebDriver driver;

	@Before
	public void openCreateOrderPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
		Thread.sleep(1000);
	}
	
//	@Test
	public void backToHome() throws InterruptedException{
		
	}

	@Test
	public void createOrderSuccess() throws InterruptedException {
		driver.findElement(By.id("menu")).click();
		List<WebElement> dishList = driver.findElements(By.className("addDish"));
		for (WebElement dish : dishList) {
			dish.click();
		}
		driver.findElement(By.id("checkoutOrder")).click();
		driver.findElement(By.id("swipeCard")).click();
		Thread.sleep(1000);
		String successMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Assert.assertEquals("Saving order success!", successMsg);
	}

//	@Test
	public void backToCart() throws InterruptedException {
		
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
