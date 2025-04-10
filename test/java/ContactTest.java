import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.time.Duration;

public class ContactTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Robot robot;


    @BeforeClass public void setUp() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        robot = new Robot();
    }

    @Test(priority = 1) public void addingContactToFavorite() throws InterruptedException {

        driver.get("https://web.whatsapp.com/");

        // Opens Whatsapp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Getting to contacts page
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[3]/div/div[3]/div[1]/div/div/div[1]/div/div/div")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/header/div[3]/div/div[3]/div/button/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/ul/div/div/li[1]/div")).click();
        Thread.sleep(4000);

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 1000);");

        // Select favorite
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[7]/div/div[2]")).click();
        Thread.sleep(4000);

        // Show favorites
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[3]/div/div[2]/button[3]")).click();
        Thread.sleep(4000);

        // Goes Back
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[3]/div/div[2]/button[1]")).click();
        Thread.sleep(5000);

        // Unfavorites
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[7]/div/div[2]")).click();
        Thread.sleep(4000);

        // Show favorites
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[3]/div/div[2]/button[3]")).click();
        Thread.sleep(4000);

        // Goes Back
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[3]/div/div[2]/button[1]")).click();
        Thread.sleep(5000);
    }

    @Test(priority = 2) public void mediaView() throws InterruptedException {

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Show message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/button/span")).click();
        Thread.sleep(3000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Pin message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[3]/button/span")).click();
        Thread.sleep(3000);

        // Select 24 hours
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div[1]/form/ol/li[1]/label/div/div/span/div/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(3000);

        // Show pin
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/span[1]/div/button/div/div/div/div[4]/span/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/span[1]/div/button/div/div/div/div[4]/span/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/span[1]/div/button/div/div/div/div[4]/span/div")).click();
        Thread.sleep(3000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Unpin
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[3]/button/span")).click();
        Thread.sleep(3000);

        // Show unpin
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // React
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[4]/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div/div/div/div/div/div[2]/div/div/img")).click();
        Thread.sleep(3000);

        // Show react
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Unreact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[4]/button/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div/div/div/div/div/div[2]/div/div/img")).click();
        Thread.sleep(3000);

        // Show unreact
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 3) public void downloadMedia() throws InterruptedException {

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Download Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[6]/button/span")).click();
        Thread.sleep(3000);

        // Exit
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);

        // Reupload Image
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(2000);

        // Upload the photo
        fileInput.sendKeys("C:\\Users\\redsl\\Downloads\\WhatsApp Image 2025-04-07 at 9.16.27 PM (1).jpeg");
        Thread.sleep(2000);

        // Send
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[2]/div[2]/div/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4) public void starringMessages() throws InterruptedException {

        // Getting to contacts page
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/header/div[3]/div/div[3]/div/button/span")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/ul/div/div/li[1]/div")).click();
        Thread.sleep(4000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Star message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/button/span")).click();
        Thread.sleep(3000);

        // Exit
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);

        // Show Star Message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[4]/div/div/div")).click();
        Thread.sleep(3000);

        // Exit Star
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/header/div/div[1]/div/span")).click();
        Thread.sleep(3000);

        // Click Image
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/button/div/div")).click();
        Thread.sleep(3000);

        // Unstar message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/button/span")).click();
        Thread.sleep(3000);

        // Exit
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[8]/button/span")).click();
        Thread.sleep(3000);

        // Show Star Message
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[4]/div/div/div")).click();
        Thread.sleep(3000);

        // Exit Star
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/header/div/div[1]/div/span")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 5) public void blockUser() throws InterruptedException {

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 2000);");

        // Block user
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[8]/div[1]/div[2]")).click();
        Thread.sleep(3000);

        // Confirm
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(3000);

        // Unblock User
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/section/div[8]/div[1]/div[2]")).click();
        Thread.sleep(3000);

        // Confirm
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(3000);

        // Exit
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/header/div/div[1]/div/span")).click();
        Thread.sleep(3000);
    }

    @AfterClass public void tearDown() {
        driver.quit();
    }

}
