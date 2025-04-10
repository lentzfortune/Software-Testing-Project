import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SettingsTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    String settingsPath = "//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[1]/button";
    FirefoxProfile profile = new FirefoxProfile();
    FirefoxOptions options = new FirefoxOptions();

    @BeforeClass
    public void setUp() {
        profile.setPreference("media.navigator.permission.disabled", true);
        profile.setPreference("permissions.default.camera", 1);
        options.setProfile(profile);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        action = new Actions(driver);

    }
    @Test(priority = 1)
    public void testDeleteAccountPage() throws InterruptedException {
        //Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        //Open Settings
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);

        //Click on Account
        driver.findElement(By.xpath("//div[text()='Account']")).click();
        Thread.sleep(1000);

        //Go on the "How to delete your account" tab
        String originalWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div/div/button[3]/div/div/div[2]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(2000);
        //Scroll slowly down the "How to delete your account" page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Get the total height of the document
        Long pageHeight = (Long) js.executeScript("return document.body.scrollHeight");

        //First, scroll down slowly
        int slowScrollIncrement = 20;
        int slowScrollSleepTime = 50;
        boolean reachedBottom = false;

        while (!reachedBottom) {
            // Scroll a bit
            js.executeScript("window.scrollBy(0, arguments[0]);", slowScrollIncrement);
            Thread.sleep(slowScrollSleepTime);

            // Get current current position for necessary values
            Long scrollTop = (Long) js.executeScript("return window.pageYOffset;");
            Long innerHeight = (Long) js.executeScript("return window.innerHeight;");
            Long scrollHeight = (Long) js.executeScript("return document.body.scrollHeight;");

            // Check if bottom was reached
            if (scrollTop + innerHeight >= scrollHeight) {
                reachedBottom = true;
            }
        }
        Thread.sleep(1000);
        //Second, scroll up quickly
        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(2000);
        //Close new window and go back to chats
        driver.close();
        driver.switchTo().window(originalWindowHandle);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);
    }
    @Test(priority = 2)
    public void testEditAccountPage() throws InterruptedException {
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        //Open Settings
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);

        //Click on profile
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div[2]/div/div/div/button[1]/div/div/div[2]")).click();
        Thread.sleep(1000);

        //Click on change photo, take photo, submit changes.
        WebElement changePhotoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Change profile photo']")));
        changePhotoButton.click();
        Thread.sleep(750);
        WebElement takePhotoOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Take photo')]")));
        takePhotoOption.click();
        Thread.sleep(8000);
        WebElement takePhotoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button' and @aria-label='Take photo']")));
        takePhotoButton.click();
        Thread.sleep(1000);
        WebElement submitImageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button' and @aria-label='Submit image']")));
        submitImageButton.click();
        Thread.sleep(1000);

        //Go back to the chats
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);

    }
    @Test(priority = 3)
    public void testBlockAccount() throws InterruptedException {
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        //Open Settings
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);

        //Open privacy
        driver.findElement(By.xpath("//div[normalize-space(text())='Privacy']")).click();
        Thread.sleep(1000);

        // Locate the scrollable element (adjust the locator as needed)
        WebElement scrollableElement = driver.findElement(By.xpath("//div[contains(@class, 'xyw6214')]"));

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollableElement);
        Thread.sleep(2000);

        //Click on blocked contacts
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div[4]/div[2]")).click();
        Thread.sleep(1000);

        //Block a contact
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div[1]/div")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//span[@title='(239) 529-8214']")).click();
        Thread.sleep(1000);

        //Unblock contact
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='button' and @aria-label='Delete'])[last()]")));
        deleteButton.click();
        Thread.sleep(500);
        WebElement unblockButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[normalize-space()='Unblock']]")));
        unblockButton.click();
        Thread.sleep(1000);

        //Go back to chats
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);

    }
    @Test(priority = 4)
    public void testReadReceipts() throws InterruptedException {
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        //Click on Jordan's chat to check the setting
        driver.findElement(By.xpath("//span[@title='Jordan (event. ly cofunder)']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);

        //Open Settings
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);

        //Look for "Read receipts" and click
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div[1]/div/div[2]/div/div[1]/p"))).click().sendKeys("Read").perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[normalize-space(text())='Privacy']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@class, 'selectable-text') and normalize-space(text())='Read receipts']")).click();
        Thread.sleep(750);

        //Go back to the chats
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);

        //Click on Jordan again, check the setting works
        driver.findElement(By.xpath("//span[@title='Jordan (event. ly cofunder)']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);


    }
    @Test(priority = 5)
    public void testWallpaperChange() throws InterruptedException {
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        //Click on chat and check wallpaper
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(1500);

        //Open Settings
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);
        //Open chats and switch theme to light and go back
        driver.findElement(By.xpath("//div[normalize-space()='Chats']")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div/div/div[1]/div[2]/div/div[2]")).click();
        Thread.sleep(750);
        WebElement light = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-icon='checkbox-round-passive']")));
        light.click();
        Thread.sleep(750);
        WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[normalize-space(text())='OK']]")));
        okButton.click();
        Thread.sleep(1500);
        //Switch to dark and go back
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div/div/div[1]/div[2]/div/div[2]")).click();
        Thread.sleep(750);
        WebElement dark = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-icon='checkbox-round-passive']")));
        dark.click();
        Thread.sleep(1000);
        WebElement okButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[normalize-space()='OK']]")));
        okButton2.click();
        Thread.sleep(1500);
        //Switch to default again
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div/div/div[1]/div[2]/div/div[2]")).click();
        Thread.sleep(750);
        WebElement systemDefault = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.//input[@aria-label='System default']]")));
        systemDefault.click();
        Thread.sleep(750);
        WebElement okButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//div[normalize-space()='OK']]")));
        okButton3.click();
        Thread.sleep(1500);
        //Switch the background of a chat and check
        WebElement wallpaperButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button'][.//div[normalize-space(text())='Wallpaper']]")));
        wallpaperButton.click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div[2]/span[3]")).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(1500);
        //Change it back
        driver.findElement(By.xpath(settingsPath)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[normalize-space()='Chats']")).click();
        Thread.sleep(750);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button'][.//div[normalize-space(text())='Wallpaper']]"))).click();
        Thread.sleep(750);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[1]/span/div/div/span/div/div/div/div[2]/span[1]")).click();
        Thread.sleep(750);
        //Check wallpaper
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[1]/div[1]/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(1500);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}