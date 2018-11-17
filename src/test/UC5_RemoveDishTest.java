package test;
import java.util.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class UC5_RemoveDishTest {
	WebDriver driver;

	@Before
	public void openRemoveDishPage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOADProject/");
		driver.findElements(By.id("adminMode")).get(0).click();
		Thread.sleep(500);
		driver.findElement(By.id("username")).sendKeys("1");
		driver.findElement(By.id("password")).sendKeys("user1");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		driver.findElement(By.id("removeDish")).click();
		Thread.sleep(500);
	}
	
//	@Test
	public void returnToAdminMode() throws InterruptedException {
		driver.findElement(By.tagName("a")).click();
		Thread.sleep(500);
		Assert.assertEquals("Welcome Page", driver.getTitle());
	}
	
	@Test
	public void removeDishOk() throws InterruptedException {
		List<WebElement> cancelBtnOld = driver.findElements(By.className("dishBtn"));
		cancelBtnOld.get(0).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		List<WebElement> cancelBtnNew = driver.findElements(By.className("dishBtn"));
		Assert.assertEquals(cancelBtnNew.size(), cancelBtnOld.size());
	}
	
//	@Test
	public void removeDishCancel() throws InterruptedException{
		List<WebElement> cancelBtnOld = driver.findElements(By.className("dishBtn"));
		cancelBtnOld.get(0).click();
		Thread.sleep(500);
		driver.switchTo().alert().dismiss();
		List<WebElement> cancelBtnNew = driver.findElements(By.className("dishBtn"));
		Assert.assertEquals(cancelBtnNew.size(), cancelBtnOld.size());
	}
	
	@After
	public void closePage() {
		driver.quit();
	}
}
