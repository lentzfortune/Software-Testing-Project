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

    @Test(priority = 1) public void createCommunity() throws InterruptedException {

        driver.get("https://web.whatsapp.com/");

        // Opens Whatsapp
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Press Community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[4]/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div/div/div/div[1]/div/div")).click();
        Thread.sleep(2000);
        
        // Creating the community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div/div[2]/div")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("T");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("e");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("s");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[3]/div/div[2]/div[3]/div/div/p")).sendKeys("t");
        Thread.sleep(2000);

        // Adds Emoji
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[1]/div/div[3]/div/div[2]/span/div/button/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[5]/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/span[1]")).click();
        Thread.sleep(2000);

        // Adding Profile Picture
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[1]/div/div[2]/div/button[1]")).click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\redsl\\IdeaProjects\\test\\arduino.png");
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/span[2]/div/div/div/div/div/div/div/div/div[2]/span/div/div")).click();
        Thread.sleep(2000);

        // Creates Community
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[2]/div[1]/span/div/span/div/div[2]/span/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 2) public void addingAndKickingGroups() throws InterruptedException {
    }

    @Test(priority = 3) public void addingAndKickingMembers() throws InterruptedException {
    }

    @Test(priority = 4) public void editingCommunity() throws InterruptedException {
    }

    @Test(priority = 5) public void exitCommunity() throws InterruptedException {
    }

    @AfterClass public void tearDown() {
        driver.quit();
    }

}
