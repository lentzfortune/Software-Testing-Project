import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.time.Duration;

public class MessagingTest {
    FirefoxOptions options = new FirefoxOptions();
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    @BeforeClass
    public void setUp() {
        //Stuff so that it wont bug me when I am trying to download something or record a voice message.
        options.addPreference("media.navigator.permission.disabled", true);
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        action = new Actions(driver);
    }
    @Test(priority = 1)
    public void testSendingMultipleMessages() throws InterruptedException{
        //Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);

        // Click on chat
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);

        // Click on textbox and create array to hold messages.
        String[] messages = {"Hi there my friends. I will be showing off different fonts with + emojis", "_Here is some text with italics._", "*Here is some bolded text.*", "~And here is some text with a strikethrough.~"};
        WebElement body = driver.findElement(By.tagName("body"));
        Random r = new Random();
        WebElement inputField = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[2]/div[1]"));
        WebElement emojiField = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[1]/button"));
        for (int i = 0; i < messages.length; i++) {
            //Send messages from messages[]
            action.moveToElement(inputField).click().sendKeys(messages[i]).perform();
            Thread.sleep(1000);
            emojiField.click();
            Thread.sleep(200);
            //Attach 3 random emojis to the message.
            for(int j = 0; j < 3; j++) {
                driver.findElement(By.xpath("//*[@id=\"" + r.nextInt(10) + "\"]")).click();
            }
            Thread.sleep(500);
            //Center the cursor on the screen to get out of the emoji selection screen.
            action.moveToElement(body, 0, 0)
                    .moveByOffset(body.getSize().width / 2, body.getSize().height / 2).click().perform();
            //Send the message
            driver.findElement(By.xpath("//button[@aria-label='Send']")).click();
            Thread.sleep(3000);
        }
    }
    @Test(priority = 2)
    public void testPhotos() throws InterruptedException{
        //Open WhatsApp
//        driver.get("https://web.whatsapp.com/");
//
//        // Wait for manual login :broken_heart:
//        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
//        Thread.sleep(2000);

        // Click on chat
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);

        //Click on media and attach something
        WebElement mediaSpan = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[1]/div/button/span"));
        mediaSpan.click();
        WebElement photosAndVideosInput = driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[5]/div/ul/div/div/div[2]/li/div/input"));
        photosAndVideosInput.sendKeys("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\Projects\\intellij\\WhatsApp-Testing\\chicken_jockey.jpg");
        Thread.sleep(2000);
        //Add 2 filters to the picture
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[2]/div/div/div[2]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[2]/div/div/div[3]/div")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[2]/button/span")).click();
        //Add a caption with an emoji.
        action.moveToElement(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]/div[1]/p"))).click().sendKeys("chicken jockey.").perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[3]/div/div/div[2]/div[2]/button[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@title='Animals & Nature']"))).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[@data-emoji='🐔']")).click() ;
        Thread.sleep(1500);
        //Click send
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[2]/div[2]/div/div/span"));
        sendButton.click();
        Thread.sleep(2000);

    }
    @Test(priority = 3)
    public void testVideosAndForwarding() throws InterruptedException{
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        // Click on chat
        WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Sigma']/ancestor::div[@role='gridcell']")));
        chat.click();
        Thread.sleep(2000);
        //Play video
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='button' and .//span[normalize-space()='Sigma']]"))).click();
        String videoButtonXPath = "/html/body/div[1]/div/div/div[3]/div/div[5]/span/div/span/div/div/div/section/div[3]/div[2]/div/div[1]/button";
        WebElement videoButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(videoButtonXPath)));

        // Scroll the video button into view so that it is visible.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", videoButton);
        Thread.sleep(18000);
        //Download video
        WebElement downloadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Download' and @aria-label='Download']")));
        downloadButton.click();
        //Forward video
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div[2]/div/div[1]/div[2]/div/div[5]/button")).click();
        //Click on me as a contact
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(1000);
        //Find and click the group
        By inputBoxSelector = By.xpath("//div[@role='textbox' and @aria-label='Search']");
        WebElement inputBox = wait.until(ExpectedConditions.elementToBeClickable(inputBoxSelector));
        action.moveToElement(inputBox).click().pause(Duration.ofMillis(300)).sendKeys("Sigma2").pause(Duration.ofMillis(200)).perform();
        Thread.sleep(500);
        By contactBoxSelector = By.xpath("//span[@title='Sigma2']/ancestor::div[@role='gridcell']");
        WebElement Sigma2Box = wait.until(ExpectedConditions.elementToBeClickable(contactBoxSelector));
        Sigma2Box.click();
        //Forward it
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/span[2]/div/div/div/div/div/div/div/span/div/div/div")).click();
        Thread.sleep(4000);
    }
    @Test(priority = 4)
    public void testStickers() throws InterruptedException{
        //Open WhatsApp
//        driver.get("https://web.whatsapp.com/");
//
//        // Wait for manual login :broken_heart:
//        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
//        Thread.sleep(2000);

        // Click on chat
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);
        //Click on emoji tab
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[1]/button")).click();
        Thread.sleep(750);
        //Switch to sticker tab
        driver.findElement(By.xpath("//*[@id=\"expressions-panel-container\"]/span/div/ul/div[2]/div/div/div[3]/button")).click();
        Thread.sleep(750);
        //Upload image to make stickers
        WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='file']")));
        fileInput.sendKeys("C:\\Users\\jorda\\OneDrive - Florida Gulf Coast University\\Projects\\intellij\\WhatsApp-Testing\\goku-awesome.jpeg");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[1]/div[2]/div[7]/button")).click();
        Thread.sleep(750);
        //Js executor object to interact with slider and change the blur
        WebElement slider = driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/span/div/div/div/div[2]/div/div[1]/div[3]/div/div[1]/div[2]/div/input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", slider, "75");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@role='button' and @aria-label='Send']")).click();
        Thread.sleep(2000);
        /*
        //Go on chat where sticker is
        WebElement chat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@title='Sigma']/ancestor::div[@role='gridcell']")));
        chat.click();
        Thread.sleep(1000);
        //Click on sticker and favorite it over sticker
        WebElement stickerElement = driver.findElement(By.xpath("//img[@alt='Sticker with no label']"));
        stickerElement.click();
        Thread.sleep(1000);
        WebElement favorites = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/span[3]/div/div/div/div/div[2]/div/div/button")));
        favorites.click();
        Thread.sleep(1000);
        //Click on my contact.
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        //Click on emoji tab
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[1]/div[1]/button")).click();
        Thread.sleep(750);
        //Switch to sticker tab
        driver.findElement(By.xpath("//*[@id=\"expressions-panel-container\"]/span/div/ul/div[2]/div/div/div[3]/button")).click();
        Thread.sleep(1000);
        //Switch to favorites tab
        driver.findElement(By.xpath("//div[@title='Favorite']"));
        Thread.sleep(750);
        WebElement stickerSequel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@src, 'blob:https://web.whatsapp.com/957d300b-bf35-43c9-849c-8c5596a91137')]")));
        //Click the sticker
        stickerSequel.click();*/
    }
    @Test(priority = 5)
    public void testVoiceMessage() throws InterruptedException{
        /*Open WhatsApp
        driver.get("https://web.whatsapp.com/");

        // Wait for manual login :broken_heart:
        WebElement chatList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[3]/div/header/div/div/div/div/span/div/div[2]/div[2]/button")));
        Thread.sleep(2000);*/

        // Click on chat
        driver.findElement(By.xpath("//span[@title='+1 (239) 738-4322']/ancestor::div[@role='gridcell']")).click();
        Thread.sleep(2000);
        //Click on voice message button
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(4000);
        //Pause it for 2 seconds
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[1]/div/div/div[2]/button")).click();
        Thread.sleep(750);
        //Delete it
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[1]/div/div/button[1]")).click();
        Thread.sleep(2000);
        //Record another for a couple seconds.
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span/div/div[2]/div[2]/button")).click();
        Thread.sleep(5000);
        //Send it
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[1]/div/div/button[2]")).click();
        Thread.sleep(4000);
        //Create list of all audio messages and play the last one
        List<WebElement> voiceMessages = driver.findElements(By.xpath("//span[@aria-label='Voice message']"));
        if (!voiceMessages.isEmpty()) {
            // Get the last (most recent) one
            WebElement latestVoiceMessage = voiceMessages.get(voiceMessages.size() - 1);
            try {
                // Go up to the message container
                WebElement container = latestVoiceMessage.findElement(By.xpath("./ancestor::div[contains(@class, '_ak4a')]"));

                // Find the play button inside the container
                WebElement playButton = container.findElement(By.xpath(".//button[@aria-label='Play voice message']"));

                playButton.click();

            } catch (Exception e) {
                System.out.println("Could not play the latest voice message: " + e.getMessage());
            }
        } else {
            System.out.println("No voice messages found.");
        }
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
