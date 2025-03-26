import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlaze {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
            driver.get("https://www.demoblaze.com");
            driver.manage().window().maximize();
            WebElement signUpButton = driver.findElement(By.xpath(("//a[contains(text(),'Sign up')]")));
            Actions action = new Actions(driver);
    		action.moveToElement(signUpButton).click().build().perform();
    		
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username"))).sendKeys("harikrish0123");
            driver.findElement(By.id("sign-password")).sendKeys("password123");
            driver.findElement(By.xpath("//button[text()='Sign up']")).click();
            Thread.sleep(3000); // To avoid alert issues
            driver.switchTo().alert().accept(); // Handle signup alert
    		
            // Login process
            driver.findElement(By.id("login2")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("harikrish0123");
            driver.findElement(By.id("loginpassword")).sendKeys("password123");
            driver.findElement(By.xpath("//button[text()='Log in']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))); // Wait for login success

          // Add product to cart
            driver.findElement(By.linkText("Samsung galaxy s6")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Add to cart']"))).click();
            Thread.sleep(3000); // Wait for the alert to appear
            driver.switchTo().alert().accept(); // Handle add-to-cart alert
            driver.navigate().back();

          // Check cart functionality
            driver.findElement(By.id("cartur")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Samsung galaxy s6')]")));

            // Purchase functionality
            driver.findElement(By.xpath("//button[text()='Place Order']")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Krish");
            driver.findElement(By.id("country")).sendKeys("INDIA");
            driver.findElement(By.id("city")).sendKeys("BANGALORE");
            driver.findElement(By.id("card")).sendKeys("1234567890123456");
            driver.findElement(By.id("month")).sendKeys("09");
            driver.findElement(By.id("year")).sendKeys("2025");
            driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
            driver.close();    
}
}


