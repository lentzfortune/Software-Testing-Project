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

public class StatusTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    Robot robot;

    @BeforeClass
    public void setUp() throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\School Years\\Junior Year\\Spring 2025\\Software Testing\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        robot = new Robot();
    }

    @Test(priority = 1)
    public void testTextStatus() throws InterruptedException {
        // Get website
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :(
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);


        // Click status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[2]/button/span")).click();
        Thread.sleep(2000);

        // Add text status and change settings
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div")).click();
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
    }

    @Test(priority = 2)
    public void testImageStatus() throws InterruptedException {
        // Add image status and change settings
        // Click add
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/header/div/span/div/div[1]/button")).click();
        Thread.sleep(2000);

        // Click Photos & videos
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div[1]/li/div")).click();
        Thread.sleep(2000);

        // Find the input
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(2000);

        // Upload the photo
        fileInput.sendKeys("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\Projects\\intellij\\WhatsApp-Testing\\cat.jpg");
        Thread.sleep(2000);

        // Robot to close the file explorer because it hates me
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);

        // Add filter
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/div/div[1]/div[1]/div[2]/div[2]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/div/div[1]/div[2]/div/div/div[6]/div")).click();
        Thread.sleep(2000);

        // Send status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/div/div[2]/div[2]/div/div")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void testViewStatus() throws InterruptedException {
        // View statuses
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div")).click();
        Thread.sleep(1000);

        // Click views
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/span/div/div/div/div[6]/div/button/div/div[2]")).click();
        Thread.sleep(2000);

        // Click out of views
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/header/div/div[1]/div")).click();
        Thread.sleep(2000);

        // Pause second status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/span/div/div/div/div[2]/div[3]/div/div/button/button/span")).click();
        Thread.sleep(2000);

        // Download picture
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/span/div/div/div/div[2]/div[3]/div/div/div[2]/span/div/button/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[1]/div")).click();
        Thread.sleep(2000);

        // Dismiss download bar
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);

        // Exit early
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/button[1]/span")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void testDeleteStatus() throws InterruptedException {
        // Delete text Status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div")).click();
        Thread.sleep(1000);

        // Delete status and confirm
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/span/div/div/div/div[2]/div[3]/div/div/div[2]/span/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);

        // Delete image status
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div")).click();
        Thread.sleep(2000);

        // Delete status and confirm
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/span/div/div/div/div[2]/div[3]/div/div/div[2]/span/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void testChangePrivacy() throws InterruptedException {
        // Change status privacy
        // Click 3 dots
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/header/div/span/div/div[2]/button")).click();
        Thread.sleep(2000);

        // Click status privacy
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li")).click();
        Thread.sleep(2000);

        // Click my contacts except...
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[2]/button[2]")).click();
        Thread.sleep(2000);

        // Search
        // Locate the input field
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div"));

        // Type in Lentz
        Actions actions = new Actions(driver);
        actions.moveToElement(inputField).click().sendKeys("Lentz Fortune").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Type in David
        actions.moveToElement(inputField).click().sendKeys("Deividas Ilgunas").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Type in Daniel
        actions.moveToElement(inputField).click().sendKeys("Daniel De Sousa").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // click check mark
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/span/div/div/div")).click();
        Thread.sleep(2000);

        // Click Only share with...
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[2]/button[3]")).click();
        Thread.sleep(2000);

        // Type in Lentz
        inputField = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/div/div/div"));

        actions.moveToElement(inputField).click().sendKeys("Lentz Fortune").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Type in David
        actions.moveToElement(inputField).click().sendKeys("Deividas Ilgunas").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Type in Daniel
        actions.moveToElement(inputField).click().sendKeys("Daniel De Sousa").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Select all contacts
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/header/div/span/div/div/button")).click();
        Thread.sleep(2000);

        // Type in Lentz
        actions.moveToElement(inputField).click().sendKeys("Lentz Fortune").perform();
        Thread.sleep(2000);

        // Select name
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);

        // Clear search bar
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[1]/div/div[2]/span/button")).click();
        Thread.sleep(2000);

        // Select check mark
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/span/div/div/div")).click();
        Thread.sleep(2000);

        // Select my contacts
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[2]/button[1]")).click();
        Thread.sleep(2000);

        // Select back button
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/header/div/div[1]/div")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}


