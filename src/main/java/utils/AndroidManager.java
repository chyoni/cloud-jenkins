package utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * AndroidDriver, WebDriverWait 과 같이 드라이버 관련된 클래스,
 * Id, xPath 같은 Selector 를 사용하게 정의한 클래스
 * */
public class AndroidManager {
    private static final Logger log = LoggerFactory.getLogger(AndroidManager.class);

    private static WebDriverWait wait;
    private static AndroidDriver driver;

    private AndroidManager() {}

    /**
     * UiAutomator2 Driver를 생성한다. 이 Driver의 capability는 app.properties 파일에 의해 결정된다.
     * */
    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                URL remoteUrl = new URL(AppProperty.getInstance().getRemoteUrl());

                desiredCapabilities.setCapability("appium:udid", AppProperty.getInstance().getUDID());
                desiredCapabilities.setCapability("platformName", AppProperty.getInstance().getPlatformName());
                desiredCapabilities.setCapability("appium:automationName", AppProperty.getInstance().getAutomationName());
                desiredCapabilities.setCapability("appium:platformVersion", AppProperty.getInstance().getPlatformVersion());
                desiredCapabilities.setCapability("appium:skipUnlock", AppProperty.getInstance().getSkipUnlock());
                desiredCapabilities.setCapability("appium:autoGrantPermissions", AppProperty.getInstance().getAutoGrantPermissions());
                desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", AppProperty.getInstance().getEnsureWebviewsHavePages());
                desiredCapabilities.setCapability("appium:nativeWebScreenshot", AppProperty.getInstance().getNativeWebScreenshot());
                desiredCapabilities.setCapability("appium:newCommandTimeout", AppProperty.getInstance().getNewCommandTimeout());
                desiredCapabilities.setCapability("appium:connectHardwareKeyboard", AppProperty.getInstance().getConnectHardwareKeyboard());

                driver = new AndroidDriver(remoteUrl, desiredCapabilities);
            } catch (MalformedURLException e) {
                log.error("MalformedURLException occur");
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    /**
     * WebDriverWait Object를 가져온다. duration은 10초
     * */
    public static WebDriverWait getWait() {
        return getWait(10);
    }

    /**
     * WebDriverWait Object를 가져온다. 여기서 duration은 기다리는 시간을 의미
     * @param duration duration time (seconds)
     * */
    public static WebDriverWait getWait(int duration) {
        if (wait == null) {
            if (driver == null) {
                driver = getDriver();
            }
            wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        } else {
            wait.withTimeout(Duration.ofSeconds(duration));
        }
        return wait;
    }

    /**
     * Id를 통해 원하는 Element를 가져온다.
     * @param id element id
     * */
    public static WebElement getElementById(String id) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    /**
     * Accessibility Id를 통해 원하는 Element를 가져온다.
     * @param accessibilityId element id
     * */
    public static WebElement getElementByAccessibilityId(String accessibilityId) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(accessibilityId)));
    }

    /**
     * Id를 통해 원하는 Element를 가져오는데, 기본 duration 10초 이상 기다림이 필요하다고 판단 시, 또는 더 적게 필요할 때에 duration에 원하는 시간을 추가한다.
     * @param id element id
     * @param duration duration time (seconds)
     * */
    public static WebElement getElementByIdUntilDuration(String id, int duration) {
        return getWait(duration).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    /**
     * xPath를 통해 원하는 Element를 가져온다.
     * @param xPath element xPath
     * */
    public static WebElement getElementByXpath(String xPath) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    /**
     * 같은 아이디의 여러개 Element가 있는 경우, index 번호를 통해 원하는 Element를 가져온다.
     * @param id elements id
     * @param index element index that you want to get
     * */
    public static WebElement getElementsByIdAndIndex(String id, int index) {
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id))).get(index);
    }


    /**
     * 원하는 element가 swipe 가능한 화면 내 존재할 때 text가 있으면 해당 텍스트를 통해 element를 return
     * @param text element text
     * @return WebElement
     * */
    public static WebElement getElementByTextAfterSwipe(String text) {
        log.info("text --> {}", "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\""+text+"\"))");
        return getDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\""+text+"\"))"
                ));
    }
    /**
    * Parameter로 전달한 Text를 가지고 있는 Element를 얻거나 그 Element까지 Scroll한다. 여기서 Scrollable한 List는 Horizontal List이어야 하고, 해당 List의 Resource-id를 전달해야한다.
    * @param resourceId scrollable list의 resource_id
    * @param text 찾고자 하는 엘리멘트가 가지는 text
    * */
    public static WebElement    getElementByTextAndHorizontalScrollableListIdAfterSwipe(String resourceId, String text) {
        log.info("This is uiautomatorText: {}", "new UiScrollable(new UiSelector().resourceId(\""+resourceId+"\")).setAsHorizontalList()" +
                ".scrollIntoView(new UiSelector().text(\""+text+"\"))");

        return getDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\""+resourceId+"\")).setAsHorizontalList()" +
                                ".scrollIntoView(new UiSelector().text(\""+text+"\"))"
                ));
    }

    /**
     * 토스트 팝업의 메시지를 리턴한다.
     * @param xPath xPath
     * @return toast message
     * */
    public static String getToastMessageByXpath(String xPath) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath))).getText();
    }


}
