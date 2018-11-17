package test;
import java.util.List;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class UC6_CancelOrderTest {
	WebDriver driver;

	@Before
	public void openRemoveDishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/ooad/");
		driver.findElements(By.id("adminMode")).get(0).click();
		Thread.sleep(500);
		driver.findElement(By.id("username")).sendKeys("1");
		driver.findElement(By.id("password")).sendKeys("user1");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("cancelOrder")).click();
		Thread.sleep(500);
	}
	
	@Test
	public void returnToAdminMode() throws InterruptedException {
		driver.findElement(By.tagName("a")).click();
		Thread.sleep(500);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void cancelOrderCancel() throws InterruptedException{
		List<WebElement> cancelBtnOld = driver.findElements(By.className("cancelButton"));
		cancelBtnOld.get(0).click();
		Thread.sleep(500);
		driver.switchTo().alert().dismiss();
		List<WebElement> cancelBtnNew = driver.findElements(By.className("cancelButton"));
		Assert.assertEquals(cancelBtnOld.size(), cancelBtnNew.size());
	}
	
	@Test
	public void cancelOrderOk() throws InterruptedException{
		List<WebElement> cancelBtnOld = driver.findElements(By.className("cancelButton"));
		cancelBtnOld.get(0).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		List<WebElement> cancelBtnNew = driver.findElements(By.className("cancelButton"));
		Assert.assertEquals(cancelBtnOld.size(), cancelBtnNew.size()+1);
	}
	
	@After
	public void closePage() {
		driver.quit();
	}
}
