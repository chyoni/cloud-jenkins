package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * 첫 화면 (독서, 학습, 라이브러리 버튼이 가운데 상단에 배치되어 보이는)에서의 작업을 정의한 클래스
 * */
public class HomeScreenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 홈 화면 > 상단 "독서" 버튼 클릭
     */
    @Given("독서 버튼 클릭")
    public void clickReadingBtn() {
        try {
            log.info("홈 > 독서 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.독서_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 홈 화면 > 상단 "학습" 버튼 클릭
     * */
    @Given("학습 버튼 클릭")
    public void clickStudyBtn() {
        try {
            log.info("홈 > 학습 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.학습_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 홈 화면 > 상단 "라이브러리" 버튼 클릭
     */
    @Given("라이브러리 버튼 클릭")
    public void clickLibraryBtn() {
        try {
            log.info("홈 > 라이브러리 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.라이브러리_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 홈 화면 > 상단 "검색" 버튼 클릭
     */
    @When("검색 버튼 클릭")
    public void clickSearchBtn() {
        try {
            log.info("홈 > 검색 버튼 클릭");
            AndroidManager.getElementById(Constant.검색_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 홈 화면 > 우측 상단 설정 버튼 클릭
     * */
    @Given("설정 버튼 클릭")
    public void clickSetBtn() {
        log.info("홈 > 설정 버튼 클릭");
        AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnSetting").click();
    }

    /**
     * 홈 화면 > 우측 상단 독서앨범 버튼 클릭
     * */
    @Given("독서앨범 버튼 클릭")
    public void 독서앨범버튼클릭() {
        log.info("홈 > 독서앨범 버튼 클릭");
        AndroidManager.getElementById(Constant.독서앨범_id).click();
    }

    /**
     * 홈 화면 > 우측 상단 스마트올 백과 버튼 클릭
     * */
    @Given("스마트올 백과 버튼 클릭")
    public void 스마트올백과버튼클릭() {
        log.info("홈 > 스마트올 백과 버튼 클릭");
        AndroidManager.getElementById(Constant.스마트올백과_id).click();
    }

    /**
     * 홈 화면 > 좌측 상단 웅진 스마트올 버튼 클릭
     * */
    @Given("웅진 스마트올 버튼 클릭")
    public void 웅진스마트올버튼클릭() {
        log.info("홈 > 웅진 스마트올 버튼 클릭");
        AndroidManager.getElementById(Constant.웅진스마트올_id).click();
    }

    /**
     * 홈 화면 > 우측 상단 프로필 버튼 클릭
     * */
    @Given("프로필 버튼 클릭")
    public void 프로필버튼클릭() {
        log.info("홈 > 프로필 버튼 클릭");
        AndroidManager.getElementById(Constant.프로필_id).click();
    }

    /**
     * 마이 버튼 클릭
     */
    @When("마이 버튼 클릭")
    public void clickMyBtn() {
        try {
            log.info("마이 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.myButton_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마이 - 오디오 이북 클릭
     */
    @When("마이 - 오디오 이북 클릭")
    public void clickAudioEBookBtnOnMyView() {
        try {
            log.info("마이 - 오디오 이북 클릭");
            AndroidManager.getElementByXpath(Constant.audioEBookBtnOnMyView_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마이 - 오디오 이북의 연속 재생할 책 5권 선택
     */
    @When("마이 - 오디오 이북의 연속 재생할 책 {int}권 선택")
    public void selectAudioEBooksByParam(int count) {
        try {
            log.info("마이 - 오디오 이북의 연속 재생할 책 5권 선택");
            for (int i = 0; i < count; i++) {
                AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/contentsImg", i).click();
                TimeUnit.SECONDS.sleep(2);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
