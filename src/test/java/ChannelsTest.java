import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ChannelsTest {

    WebDriver driver;
    Robot robot;
    WebDriverWait wait;
    @BeforeTest
    public void setup() throws InterruptedException, AWTException {
        driver = new ChromeDriver();
        robot = new Robot();
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[3]/header/header/div")));
//        WebElement loginButton = driver.findElement(By.linkText("Log in"));
//        loginButton.click();


    }

    //Follow channel
    @Test(priority = 0)
    public void followChannel() throws InterruptedException {
        WebElement channelsButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[3]"));
        channelsButton.click();
        Thread.sleep(2000);
    }

    //react and follow
    @Test(priority = 1)
    public void channelReact() throws InterruptedException {
        Thread.sleep(2000);
        WebElement channelSelect = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div[1]/div[3]"));
        channelSelect.click();
        Thread.sleep(2000);
        WebElement searchBar = driver.findElement(By.cssSelector("p[class=\"selectable-text copyable-text x15bjb6t x1n2onr6\"]"));
        searchBar.click();
        searchBar.sendKeys("Minecraft");
        Thread.sleep(2000);
        WebElement minecraftButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/span/div/div/div[2]/div/div/div/div[1]"));
        minecraftButton.click();
        Thread.sleep(2000);

        //WebElement radioButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[2]/div[3]/div[9]/div/div/div[1]/div[1]/div[1]/div/div[3]/div[1]/div/div[1]/div"));
        //radioButton.click();
        Thread.sleep(1500);
        WebElement followChannel = driver.findElement(By.cssSelector("button[class=\"x889kno x1a8lsjc xbbxn1n xxbr6pl x1n2onr6 x1rg5ohu xk50ysn x1f6kntn xyesn5m x1z11no5 xjy5m1g x1mnwbp6 x4pb5v6 x178xt8z xm81vs4 xso031l xy80clv x13fuv20 xu3j5b3 x1q0q8m5 x26u7qi x1v8p93f xogb00i x16stqrj x1ftr3km x1hl8ikr xfagghw x9dyr19 x9lcvmn xbtce8p xcjl5na x14v0smp x1k3x3db xgm1il4 xuxw1ft xv52azi\"]"));
        followChannel.click();
        Thread.sleep(1500);
    }

    @Test(priority = 2)
    //Share a channel
    public void channelShare() throws InterruptedException {
        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/header/div[3]/div/div/div/button/span"));
        menu.click();
        WebElement menuSelect = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div/li[1]/div"));
        WebElement channelInfoButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div/li[1]"));
        channelInfoButton.click();
        Thread.sleep(2000);
        WebElement forwardButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[1]/div[2]/button[2]/div/span"));
        forwardButton.click();
        Thread.sleep(2000);
        WebElement receipientButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/span/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div/span"));
        receipientButton.click();
        Thread.sleep(1500);
        WebElement searchBar = driver.findElement(By.cssSelector("p[class=\"selectable-text copyable-text x15bjb6t x1n2onr6\"]"));
        searchBar.click();
        searchBar.sendKeys("Mirsa");
        Thread.sleep(2000);
        receipientButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/span/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div[2]"));
        receipientButton.click();
        Thread.sleep(2000);
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/span/div/div/div/div/div/div/span/div/div/div/span"));
        sendButton.click();
        Thread.sleep(1500);
        sendButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/span/div/div/div/div/div/div/div[2]/div/div/span"));
        sendButton.click();
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void makeChannel() throws InterruptedException {
        WebElement backButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/span/div/div/header/div/div[1]/div"));
        backButton.click();
        Thread.sleep(1500);
        WebElement addChannelButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/header/div/div[2]/div/button/span"));
        addChannelButton.click();
        Thread.sleep(1500);
        WebElement createChannel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/li[1]"));
        createChannel.click();
        Thread.sleep(1500);
        WebElement continueButton = driver.findElement(By.cssSelector("button[class=\"x889kno x1a8lsjc xbbxn1n xxbr6pl x1n2onr6 x1rg5ohu xk50ysn x1f6kntn xyesn5m x1z11no5 xjy5m1g x1mnwbp6 x4pb5v6 x178xt8z xm81vs4 xso031l xy80clv x13fuv20 xu3j5b3 x1q0q8m5 x26u7qi x1v8p93f xogb00i x16stqrj x1ftr3km x1hl8ikr xfagghw x9dyr19 x9lcvmn xbtce8p xcjl5na x14v0smp x1k3x3db xgm1il4 xuxw1ft xv52azi\"]"));
        continueButton.click();
        Thread.sleep(1500);
        WebElement channelName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div[2]/div/div[2]/div[3]/div/div/p"));
        channelName.click();
        Thread.sleep(1500);
        channelName.sendKeys("Computer Science and Software Engineering Club");
        Thread.sleep(1500);
        WebElement channelDisc = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div/div[1]/div[3]/div/div[2]/div[3]/div/div[1]"));
        channelDisc.sendKeys("Official whatsapp channel of CSSEC");
        continueButton = driver.findElement(By.cssSelector("button[class=\"x889kno x1a8lsjc xbbxn1n xxbr6pl x1n2onr6 x1rg5ohu xk50ysn x1f6kntn xyesn5m x1z11no5 xjy5m1g x1mnwbp6 x4pb5v6 x178xt8z xm81vs4 xso031l xy80clv x13fuv20 xu3j5b3 x1q0q8m5 x26u7qi x1v8p93f xogb00i x16stqrj x1ftr3km x1hl8ikr xfagghw x9dyr19 x9lcvmn xbtce8p xcjl5na x14v0smp x1k3x3db xgm1il4 xuxw1ft xv52azi\"]"));
        continueButton.click();
        Thread.sleep(1500);
        WebElement channelChat = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]/p"));
        channelChat.click();
        channelChat.sendKeys("Come to Game Night!");
        Thread.sleep(2000);
        WebElement plusButton = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[1]/div/button"));
        plusButton.click();
        Thread.sleep(2000);
        File fileUpload = new File("C:\\Users\\lentz\\Downloads\\Game Night Flyer (1).png");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div/div[1]/li")).click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(2000);
        fileInput.sendKeys(fileUpload.getAbsolutePath());
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);
        continueButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[2]/div[2]/div/div"));
        continueButton.click();
        Thread.sleep(2000);


    }
    @Test(priority = 4)
    public void takeScreenShot_share() throws InterruptedException, IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        Thread.sleep(4500);
        File scr = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\lentz\\Downloads\\whatsappPic.png");
        FileHandler.copy(scr, des);
        Thread.sleep(1500);
        WebElement shareButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div/div[2]/div[3]/div[4]/div/div/div[1]/div[2]/div[1]/div"));
        shareButton.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[2]/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div[2]/div/div/div/div[3]/div/div[2]")).click();
        Thread.sleep(2000);
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/span/div/div/div"));
        sendButton.click();
        Thread.sleep(2000);


    }
    @Test(priority = 5)
    public void uploadChannelPic() throws InterruptedException{
        WebElement backHome = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/span/div/div/div[2]/div[1]/div/div/div[1]/div/div"));
        backHome.click();
        WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div/div[4]/div/header/div[3]/div/div[2]/div/button"));
        menu.click();
        ////*[@id="main"]/header/div[3]/div/div[2]/div/button
        ////*[@id="main"]/header/div[3]/div/div[2]/div/button
        Thread.sleep(2000);
        WebElement channelInfoButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div/li[1]"));
        channelInfoButton.click();
        Thread.sleep(2000);
        WebElement addPic = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[1]/div[1]/div[1]/div/button"));
        addPic.click();
        Thread.sleep(2000);
        File picUpload = new File("C:\\Users\\lentz\\Downloads\\ChatGPT Image Apr 20, 2025, 05_28_06 PM.png");
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        Thread.sleep(2000);
        fileInput.sendKeys(picUpload.getAbsolutePath());
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/div/div[2]/span/div/div")).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Thread.sleep(2000);
        WebElement deleteChannel = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/section/div[6]/div[2]"));
        deleteChannel.click();
        Thread.sleep(2000);
        WebElement redButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[5]/span/div/span/div/div/div/div[5]/button/div"));
        redButton.click();
        //WebElement text = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div[2]/div"));
        //text.click();
        //Thread.sleep(2000);
        //text.sendKeys("2396010066");
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div[2]/div/button[2]/div")).click();

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}








