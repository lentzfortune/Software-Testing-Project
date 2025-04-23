import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

public class ProfileTest
{
    WebDriver driver;
    Robot robot;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws AWTException {
        driver = new ChromeDriver();
        robot = new Robot();
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[3]/header/header/div")));
//        WebElement loginButton = driver.findElement(By.linkText("Log in"));
    }
    @Test(priority = 1)
    public void profilePic() throws InterruptedException {
        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button"));
        profileButton.click();
        WebElement addPic = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[1]/div/button"));
        addPic.click();
        Thread.sleep(2000);
        File picUpload = new File("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\Projects\\intellij\\WhatsApp-Testing\\robot.png");
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(2000);
        fileInput.sendKeys(picUpload.getAbsolutePath());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div/div[2]/span/div/div")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void changeName() throws InterruptedException{
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div/span[2]/button"));
        editButton.click();
        for(int i = 0;i < 30;i++){
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            Thread.sleep(100);}
        WebElement selectableText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/div[3]/div/div/p"));
        selectableText.sendKeys("John Doe");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/span[2]/button")).click();

    }
    @Test(priority = 3)
    public void changeStatus() throws InterruptedException{
        WebElement editStatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div/span[2]/button"));
        editStatus.click();
        for(int i = 0;i < 30; i++){
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            Thread.sleep(100);
        }
        WebElement selectableText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div[1]/div[3]/div/div/p"));
        selectableText.sendKeys("Thinking about Mac and Cheese");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div[1]/span[2]/button")).click();

    }
    @Test(priority = 4)
    public void cannotBeBlank() throws InterruptedException{
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div/span[2]/button"));
        editButton.click();
        for(int i = 0;i < 30;i++){
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            Thread.sleep(100);}
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/span[2]/button")).click();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

        WebElement editStatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div/span[2]/button"));
        editStatus.click();
        for(int i = 0;i < 30; i++){
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
            Thread.sleep(100);}
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div[1]/span[2]/button")).click();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);

    }
    @Test(priority = 5)
    public void changeBack() throws InterruptedException{
        Thread.sleep(3000);
        WebElement addPic = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[1]/div/button"));
        addPic.click();
        WebElement removeImage = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div[4]/li"));
        removeImage.click();
        Thread.sleep(3000);
        //confirm
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div[2]/div/button[2]")).click();
        Thread.sleep(3000);
        WebElement selectableText = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/div[3]/div/div/p"));
        selectableText.sendKeys("Lentz Fortune ");
        WebElement emojiButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/span[1]/div[2]/button"));
        emojiButton.click();
        Thread.sleep(3000);
        //click emoji
        driver.findElement(By.xpath("//*[@id=\"8\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[2]/div[2]/div[1]/span[2]/button")).click();
        Thread.sleep(3000);
        WebElement selectableText2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div[1]/div[3]/div/div/p"));
        selectableText2.sendKeys("Battery about to die");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]/div[1]/span[2]/button")).click();

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}