package test;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC4_ModifyDishTest {
	WebDriver driver;

	@Before
	public void openModifyDishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOADProject/");
		driver.findElements(By.id("adminMode")).get(0).click();
		Thread.sleep(500);
		driver.findElement(By.id("username")).sendKeys("1");
		driver.findElement(By.id("password")).sendKeys("user1");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("modifyDish")).click();
		Thread.sleep(500);
	}
	
	@Test
	public void returnToAdminMode() throws InterruptedException {
		driver.findElement(By.tagName("a")).click();
		Thread.sleep(500);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void modifyDishSuccess() throws InterruptedException {
		List<WebElement> dish = driver.findElements(By.className("input"));
		WebElement name = dish.get(0);
		WebElement inv = dish.get(1);
		WebElement price = dish.get(2);
		name.clear();
		inv.clear();
		price.clear();
		name.sendKeys("mdfTest");
		inv.sendKeys("999");
		price.sendKeys("999");
		Thread.sleep(500);
		driver.findElements(By.className("modifyButton")).get(0).click();
		Thread.sleep(500);
		String successMsg = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		Assert.assertEquals("dish modified successfully!", successMsg);
	}
	
	@After
	public void closePage() {
		driver.quit();
	}
}
