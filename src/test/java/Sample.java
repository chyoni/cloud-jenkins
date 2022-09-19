
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

public class Sample {

    private AndroidDriver driver;
    public WebDriverWait wait;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:deviceName", "52006de7fa8a5605");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
        desiredCapabilities.setCapability("appium:platformVersion", "10");
        desiredCapabilities.setCapability("appium:skipUnlock", false);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void unit() throws TesseractException, IOException, InterruptedException {

        System.out.println(Utils.currentVideoPlayerSpeed());
//        TouchAction<?> touchAction = new TouchAction<>(AndroidManager.getDriver());
//        touchAction.press(PointOption.point(1, Utils.getScreenCenterY()))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
//                .moveTo(PointOption.point((AndroidManager.getDriver().manage().window().getSize().getWidth() -1), Utils.getScreenCenterY()))
//                .release()
//                .perform();

//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence swipe = new Sequence(finger, 1);
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), (driver.manage().window().getSize().getWidth() / 2), (driver.manage().window().getSize().getHeight() / 2)));
//        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
//                PointerInput.Origin.viewport(), (driver.manage().window().getSize().getWidth() / 2) + 100, (driver.manage().window().getSize().getHeight() / 2) - 250));
//        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(List.of(swipe));
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
