package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC3_AddDishTest {
	WebDriver driver;

	@Before
	public void openAddDishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
		driver.findElements(By.id("adminMode")).get(0).click();
		Thread.sleep(500);
		driver.findElement(By.id("username")).sendKeys("1");
		driver.findElement(By.id("password")).sendKeys("user1");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("addDish")).click();
		Thread.sleep(500);
	}

	@Test
	public void returnToAdminMode() throws InterruptedException {
		driver.findElement(By.tagName("a")).click();
		Thread.sleep(500);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void addDishSuccess() throws InterruptedException {
		driver.findElement(By.name("dishname")).sendKeys("testDish");
		driver.findElement(By.name("dishprice")).sendKeys("11.11");
		driver.findElement(By.name("dishinventory")).sendKeys("1111");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		String successMsg = driver.switchTo().alert().getText();
		Assert.assertEquals("dish test added successfully!", successMsg);
	}

	@After
	public void closePage() {
		driver.quit();
	}
}
