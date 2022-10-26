package stepdefinitions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.AppProperty;
import utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * 시나리오 진행 시 Before, After 같은 메소드와 유틸성 메소드에 대한 Hook 정의 클래스
 */
public class Hook {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Before(order = 0)
    public void before(Scenario scenario) throws InterruptedException {
        log.info("Start Appium Testing");
        AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
        TimeUnit.SECONDS.sleep(10);
        toggleWifi("On");
        TimeUnit.SECONDS.sleep(5);
    }

    @After
    public void after(Scenario scenario) {
        log.info("Terminate current driver");
        log.info("scenario status: {}", scenario.getStatus());

        if (scenario.isFailed()) {
            log.info("Current scenario : {} FAILED, take screenshot", scenario.getName().trim());
            String file = ((TakesScreenshot) AndroidManager.getDriver()).getScreenshotAs(OutputType.BASE64);
            String cleanFileName = scenario.getName().trim().replaceAll(" ", "_");

            // byte[] file =
            // ((TakesScreenshot)AndroidManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            byte[] decodedBytes = Base64.decodeBase64(file);

            String scrShotDir = "defect_screenshots";
            new File(scrShotDir).mkdirs();

            Path currentDirectoryPath = Paths.get("").toAbsolutePath();
            String currentPath = currentDirectoryPath.toString();

            // if (!currentPath.equals("/Users/choichiwon/Jenkins/ThinkBig")) return;

            String dest = cleanFileName + ".png";

            try {
                OutputStream stream = new FileOutputStream(scrShotDir + "/" + dest);
                stream.write(decodedBytes);
                // FileUtils.copyFile(file, new File(scrShotDir + "/" + dest));
                log.info("screenshot name: {}", dest);
                stream.close();
            } catch (IOException e) {
                log.error("Image not transferred to screenshot folder");
                e.printStackTrace();
            }
        }
    }

    /**
     * Wi-Fi on/off depending on parameter
     * 
     * @param onOrOff Wi-Fi Off or On
     * @throws InvalidParameterException onOrOff parameter value가 'On" 또는 "Off" 둘 다
     *                                   아닐 때
     */
    @When("Turn {string} WiFi")
    public void toggleWifi(String onOrOff) {
        if (!onOrOff.equals("On") && !onOrOff.equals("Off"))
            throw new InvalidParameterException("The parameter 'onOrOff' only available 'On' or 'Off'");

        try {
            log.info("Wifi {}", onOrOff);
            switch (onOrOff) {
                case "On":
                    if (AndroidManager.getDriver().getConnection().isWiFiEnabled()) {
                        break;
                    }
                    AndroidManager.getDriver().toggleWifi();
                    break;
                case "Off":
                    if (!AndroidManager.getDriver().getConnection().isWiFiEnabled()) {
                        break;
                    }
                    AndroidManager.getDriver().toggleWifi();
                    break;
                default:
                    break;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 스크린샷 테스트
     */
    @When("Take screenshot")
    public void testScreenShot() {
        try {
            log.info("스크린샷 테스트");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);
            System.out.println(result);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
