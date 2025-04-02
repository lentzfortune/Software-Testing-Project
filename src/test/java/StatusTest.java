import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
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
    public void testStatus() throws InterruptedException {
        // Get website
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :(
        Thread.sleep(40000);

        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[2]/button/span")).click();
        Thread.sleep(2000);

        // Add text status and change settings
        WebElement Status_Add_Check = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div"));
//        driver.findElement(By.linkText("Text")).click();
        Thread.sleep(2000);
        // Add image status and change settings

        // View statuses

        // Pause second status

        // Exit status early

        // Delete Statuses

        // Change status privacy


        driver.quit();
    }

}
