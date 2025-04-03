import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class StatusTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\School Years\\Junior Year\\Spring 2025\\Software Testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }
    @Test(priority = 1)
    public void testStatus() throws InterruptedException, AWTException {
        // Get website
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :(
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Click status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[2]/button/span")).click();
        Thread.sleep(2000);

        // Add text status and change settings
        WebElement Status_Add_Check = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div"));
        Status_Add_Check.click();
        Thread.sleep(2000);

        // Click texts
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div[2]")).click();
        Thread.sleep(2000);

        // Type status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[2]/div/div[1]")).sendKeys("H");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div")).sendKeys("i");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[2]/div/div")).sendKeys(" ");
        Thread.sleep(2000);

        // Add emoji
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[1]/div/div[1]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div[1]/div/div[2]/div/div/div/div/div/div[7]/div/div/div/span[8]")).click();
        Thread.sleep(2000);

        // Change font
        for (int i = 0; i < 2; i++) {
            driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[1]/div/div[2]/button/span")).click();
            Thread.sleep(1000);
        }

        // Change color
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[1]/div/div[3]/button/span")).click();
        Thread.sleep(2000);

        // Send status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[3]/div/div[2]/div")).click();
        Thread.sleep(2000);







        // Add image status and change settings
        // Click add
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/header/div/span/div/div[1]/button")).click();
        Thread.sleep(2000);

        // Click Photos & videos
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div[1]/li/div")).click();
        Thread.sleep(2000);

        // Find the input
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(4000);

        // Upload the photo
        fileInput.sendKeys("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\Projects\\intellij\\WhatsApp-Testing\\cat.jpg");
        Thread.sleep(4000);

        // Robot
        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        System.out.println("Closed file explorer with ESC!");
        Thread.sleep(4000);

        // View statuses

        // Pause second status

        // Exit status early

        // Delete Statuses

        // Change status privacy



    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
