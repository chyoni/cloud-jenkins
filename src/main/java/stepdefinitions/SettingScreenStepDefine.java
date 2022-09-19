package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;

import static org.junit.Assert.fail;

/**
 * 세팅화면에서 이루어지는 작업에 대한 클래스
 * */
public class SettingScreenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 설정 > 좌측 하단 공지/이벤트 버튼 클릭
     * */
    @When("공지 - 이벤트 클릭")
    public void clickAnnotationAndEventBtn() {
        try {
            log.info("홈 > 설정 > 좌측 공지/이벤트 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rl_event_area").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
