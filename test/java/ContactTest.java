import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class CommunityTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Robot robot;


    @BeforeClass public void setUp() throws AWTException {
        System.setProperty("webdriver.gecko.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new FirefoxDriver();
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

    @Test(priority = 2) public void addingToFavorites() throws InterruptedException {
    }

    @Test(priority = 3) public void pinningMessage() throws InterruptedException {
    }

    @Test(priority = 4) public void blockAndReport() throws InterruptedException {
    }

    @Test(priority = 5) public void deletingChats() throws InterruptedException {
    }

    @AfterClass public void tearDown() {
        driver.quit();
    }

}
