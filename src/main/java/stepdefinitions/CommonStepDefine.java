package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * 다양한 화면에서 사용될 법한 작업에 대한 클래스
 * */
public class CommonStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 홈 화면 > 우측 상단 설정 버튼 > 좌측 하단 공지/이벤트 버튼 > 공지사항 버튼
     * */
    @Given("공지사항 버튼 클릭")
    public void clickSetBtn() {
        log.info("홈 > 우측 상단 설정 버튼 > 좌측 하단 공지/이벤트 버튼 > 공지사항 버튼 클릭");
        AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[1]/android.widget.ListView/android.view.View[1]/android.view.View")
                .click();
    }

    /**
     * 스크롤이 가능한 화면에서 스크롤 후 원하는 element의 텍스트 값을 입력받아 가져온 후 클릭
     */
    @When("스크롤 후 {string} 버튼 클릭")
    public void clickElementAfterVerticalSwipe(String elementText) {
        try {
            WebElement element = AndroidManager.getElementByTextAfterSwipe(elementText);
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * N초 대기
     */
    @When("{int}초 대기")
    public void sleepByParam(int seconds) {
        try {
            log.info("{}초 대기", seconds);
            TimeUnit.SECONDS.sleep(seconds);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}