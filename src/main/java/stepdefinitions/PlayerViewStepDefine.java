package stepdefinitions;

import com.beust.ah.A;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;
import utils.Utils;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


/**
 * 플레이어(뷰어) 내에서 이루어지는 작업에 대한 클래스
 * 오디오이북, PDF, 멀티뷰어 등등 모든 뷰어 커버
 * */
public class PlayerViewStepDefine {

    private final Logger log =  LoggerFactory.getLogger(getClass());
    /**
     * 현재 페이지 번호 저장 변수
     * */
    private String currentPageOnViewer = null;

    /**
     * 속속 캐스트북 확인 버튼 클릭
     */
    @When("속속 캐스트북 확인 버튼 클릭")
    public void clickCastBookOkBtn() {
        try {
            log.info("속속 캐스트북 확인 버튼 클릭");
            WebElement alertMsg;

            try {
                alertMsg = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            } catch (Exception e) {
                return;
            }

            if (alertMsg.isDisplayed() && alertMsg.getText().contains("속속 캐스트북입니다.")) {
                AndroidManager.getElementById(Constant.안내팝업확인_id).click();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Reading continue yes or no
     * @param yesOrNo "Yes" or "No"
     */
    @When("Reading continue {string}")
    public void notReadingContinue(String yesOrNo) {
        if (!yesOrNo.equals("Yes") && !yesOrNo.equals("No")) throw new InvalidParameterException("yesOrNo parameter only available 'Yes' or 'No'");
        try {

            log.info("Reading continue {}", yesOrNo);
            WebElement alertMsg;

            try {
                alertMsg = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            } catch (Exception e) {
                return;
            }

            if (alertMsg.getText().equals("이 책은 세로로 보시면 좋아요.\n" +
                    "기기를 세로로 돌려서 보세요.")) {
                AndroidManager.getElementById(Constant.안내팝업확인_id).click();
            } else if (alertMsg.isDisplayed() && alertMsg.getText().contains("읽던 페이지를 이어서 볼까요?")) {
                switch (yesOrNo) {
                    case "Yes":
                        AndroidManager.getElementById(Constant.안내팝업확인_id).click();
                        break;
                    case "No":
                        AndroidManager.getElementById(Constant.안내팝업취소_id).click();
                        break;
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 플레이어 내부 > 더보기 버튼
     */
    @When("더보기 버튼 클릭")
    public void clickShowMoreBtn() {
        try {
            log.info("더보기 버튼 클릭");
            AndroidManager.getElementById(Constant.더보기_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 플레이어 내부 > 더보기 > 사전 버튼
     */
    @When("사전 버튼 클릭")
    public void clickDictionaryBtn() {
        try {
            log.info("더보기 내 사전 버튼 클릭");
            AndroidManager.getElementById(Constant.사전_id).click();
            TimeUnit.SECONDS.sleep(3);

            try {
                WebElement helpLayout2 = AndroidManager.getElementByIdUntilDuration(Constant.helpViewLayout_id, 3);
                if (helpLayout2.isDisplayed()) AndroidManager.getElementById(Constant.helpViewXBtn_id).click();
            } catch (Exception ignored) {}
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전 버튼 클릭 코치마크 미확인
     */
    @When("사전 버튼 클릭 코치마크 미확인")
    public void clickDictionaryBtnWithoutCoachMark() {
        try {
            log.info("사전 버튼 클릭 코치마크 미확인");
            AndroidManager.getElementById(Constant.사전_id).click();
            TimeUnit.SECONDS.sleep(1);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 플레이어 내에서 상단바 노출
     */
    @When("플레이어 내에서 상단바 노출")
    public void showUpperBar() {
        try {
            log.info("플레이어 내에서 상단바 노출");
            Utils.touchCenterInViewer(AndroidManager.getDriver());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 온라인 상태에서만 사전 검색이 가능하다는 안내 팝업 노출 확인
     */
    @When("온라인 상태에서만 사전 검색이 가능하다는 안내 팝업 노출 확인")
    public void checkDisplayedOnlyAvailableDictionaryInOnlineStatus() {
        try {
            log.info("Wifi off 안내 팝업 노출 확인");
            WebElement alertMsg = AndroidManager.getElementById(Constant.안내팝업메시지_id);

            if (alertMsg.isDisplayed() && alertMsg.getText().contains("온라인 상태에서만")) {
                return;
            }
            fail("'온라인 상태에서만 사전 검색이 가능합니다.' 라는 텍스트가 담긴 알림팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 알림팝업의 확인 버튼 클릭
     */
    @When("알림팝업의 확인 버튼 클릭")
    public void clickOkBtnOnAlertPopup() {
        try {
            log.info("알림팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업확인_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문쓰기 버튼 클릭
     */
    @When("감상문쓰기 버튼 클릭")
    public void clickWriteFeelingBtn() {
        try {
            log.info("감상문쓰기 버튼 클릭");
            AndroidManager.getElementById(Constant.감상문쓰기_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독후퀴즈 버튼 클릭
     */
    @When("독후퀴즈 버튼 클릭")
    public void clickReadingQuizBtn() {
        try {
            log.info("독후퀴즈 버튼 클릭");
            AndroidManager.getElementById(Constant.독후퀴즈_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 버튼 클릭
     */
    @When("감상문 보기 버튼 클릭")
    public void clickReadFeelingBtn() {
        try {
            log.info("감상문 보기 버튼 클릭");
            AndroidManager.getElementById(Constant.감상문보기_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Wifi 안내 팝업 노출 확인
     */
    @Then("Wifi 안내 팝업 노출 확인")
    public void checkDisplayedWifiAlert() {
        try {
            log.info("Wifi 안내 팝업 노출 확인");
            if (AndroidManager.getElementById(Constant.mBookPopupTitle_id).isDisplayed() &&
                AndroidManager.getElementById(Constant.mBookPopupTitle_id).getText().contains("Wi-Fi 안내")) {
                return;
            }
            fail("Wi-Fi 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 Wifi 안내 팝업 노출 확인
     */
    @When("감상문 보기 Wifi 안내 팝업 노출 확인")
    public void checkDisplayReadFeelingWifiAlert() {
        try {
            log.info("감상문 보기 Wifi 안내 팝업 노출 확인");
            if (AndroidManager.getElementById(Constant.thinkPlaygroundTitle_id).isDisplayed() &&
                    AndroidManager.getElementById(Constant.thinkPlaygroundTitle_id).getText().contains("Wi-Fi 안내")) {
                return;
            }
            fail("Wi-Fi 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Wifi 안내 팝업의 확인 버튼
     */
    @Then("Wifi 안내 팝업의 확인 버튼 클릭")
    public void clickOkBtnOnWifiAlert() {
        try {
            log.info("Wifi 안내 팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.mBookPopupOk_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭
     */
    @When("감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭")
    public void clickOkBtnOnReadFeelingWifiAlert() {
        try {
            log.info("감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.thinkPlaygroundOk_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 네트워크 확인 팝업에서 확인 버튼 클릭
     */
    @When("네트워크 확인 팝업에서 확인 버튼 클릭")
    public void clickOkBtnOnCheckNetworkPopup() {
        try {
            log.info("960 753");
            Utils.touchSpecificCoordinates(960, 745);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 보기 버튼 클릭
     */
    @When("오디오북 보기 버튼 클릭")
    public void clickSeeAudioBookBtn() {
        try {
            log.info("오디오북 보기 버튼 클릭");
            AndroidManager.getElementById(Constant.오디오북보기_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 버튼 클릭
     */
    @When("짝꿍책 버튼 클릭")
    public void clickPairBookBtn() {
        try {
            log.info("짝꿍책 버튼 클릭");
            AndroidManager.getElementById(Constant.짝꿍책_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 리스트 화면에서 N번째 도서 클릭
     */
    @When("짝꿍책 리스트 화면에서 {int}번째 도서 클릭")
    public void clickPairBookByParameter(int index) {
        try {
            log.info("짝꿍책 리스트 화면에서 {}번째 도서 클릭", index);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mepubviewer2:id/relativelayout_nextbook_", 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 Wifi 안내 팝업 확인
     */
    @Then("짝꿍책 Wifi 안내 팝업 확인")
    public void checkPairBookWifiAlert() {
        try {
            log.info("짝꿍책 Wifi 안내 팝업 확인");
            if (AndroidManager.getElementById(Constant.안내팝업메시지_id).isDisplayed() && AndroidManager.getElementById(Constant.안내팝업메시지_id).getText().contains("선택하신 도서를 보기 위해서는")) {
                return;
            }
            fail("WIFI OFF 시, 짝꿍책 선택 시 WIFI 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 Wifi 안내 팝업의 취소 버튼 클릭
     */
    @Then("짝꿍책 Wifi 안내 팝업의 취소 버튼 클릭")
    public void clickCancelBtnOnPairBookWifiAlert() {
        try {
            log.info("짝꿍책 Wifi 안내 팝업의 취소 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업취소_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Next page N번 실행
     * @param loopCount loop count
     */
    @When("Next page {int}번 실행")
    public void nextPageLoop(int loopCount) {
        try {
            log.info("Next page {}번 실행", loopCount);
            for (int i = 0; i < loopCount; i++) {
                Utils.nextPageInViewer(AndroidManager.getDriver());
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 시작 버튼 클릭
     */
    @When("녹음 시작 버튼 클릭")
    public void clickStartRecordingBtn() {
        try {
            log.info("코치마크 노출 시 닫기");
            checkFirstHelpLayoutScreen();
            log.info("녹음 시작 버튼 클릭");
            AndroidManager.getElementById(Constant.녹음시작_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 버튼 클릭
     */
    @When("녹음 버튼 클릭")
    public void clickRecordingBtn() {
        try {
            log.info("녹음 버튼 클릭");
            AndroidManager.getElementById(Constant.녹음_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 종료 버튼 클릭
     */
    @When("녹음 종료 버튼 클릭")
    public void closeRecordingBtn() {
        try {
            log.info("녹음 종료 버튼 클릭");
            AndroidManager.getElementById(Constant.녹음종료_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마지막 페이지 도달 시 노출되는 알림팝업 (오디오북 보기/감상문 보기)의 종료 버튼 클릭
     */
    @When("마지막 페이지 도달 시 노출되는 알림팝업의 종료 버튼 클릭")
    public void clickCloseBtnOnLastPagePopup() {
        try {
            log.info("마지막 페이지 도달 시 노출되는 알림팝업의 종료 버튼 클릭");
            AndroidManager.getElementById(Constant.thinkPlaygroundClose_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 만들기 전 화면에서 배경음 선택 시 N번째 배경음 선택
     * @param index 배경음의 순서
     */
    @When("오디오북 만들기 전 화면에서 배경음 선택 시 {int}번째 배경음 선택")
    public void selectBGMOnCreateAudioBookPage(int index) {
        try {
            log.info("오디오북 만들기 전 화면에서 배경음 선택 시 {}번째 배경음 선택", index);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mepubviewer2:id/bg_thumbnail", index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 만들기 버튼 클릭
     */
    @When("오디오북 만들기 버튼 클릭")
    public void clickCreateAudioBookBtn() {
        try {
            log.info("오디오북 만들기 버튼 클릭");
            AndroidManager.getElementById(Constant.createAudioBookBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 특정 문구가 담긴 토스트 팝업 노출 확인
     * @param toastText 토스트 문구
     */
    @When("{string} 문구가 담긴 토스트 팝업 노출 확인")
    public void checkToastPopup(String toastText) {
        try {
            log.info("{} 문구의 토스트 팝업을 확인합니다.", toastText);
            String result = AndroidManager.getToastMessageByXpath(Constant.toast_xPath);
            assertTrue("예상한 토스트 팝업이 노출되지 않았습니다. 실제결과: " + result + " expected contains text: " + toastText, result.contains(toastText));

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 이전 녹음 이력 지우기 Yes or No
     * @param flag "Yes" or "No"
     */
    @When("다시 녹음 {string}")
    public void yesOrNoRecordingHistory(String flag) {
        if (!flag.equals("Yes") && !flag.equals("No")) throw new InvalidParameterException("parameter only available 'Yes' or 'No'");
        try {
            log.info("이전 녹음 이력 지우기 {}", flag);
            WebElement element;
            try {
                element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            } catch (Exception e) {
                return;
            }

            if (element.isDisplayed() && element.getText().contains("이전에 녹음한 이력이 있습니다.")) {
                if (flag.equals("Yes")) {
                    AndroidManager.getElementById(Constant.안내팝업확인_id).click();
                } else {
                    AndroidManager.getElementById(Constant.안내팝업취소_id).click();
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 로딩 화면 확인
     */
    @When("로딩 화면 확인")
    public void checkLoadingScreen() {
        try {
            log.info("로딩 화면 확인");
            try {
                WebElement l1 = AndroidManager.getElementById(Constant.loadingImage_id);
                WebElement l2 = AndroidManager.getElementById(Constant.loadingText_id);
                if (l1.isDisplayed() || l2.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("로딩화면이 출력되지 않았습니다");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 진입 시 상하단 메뉴바 확인
     */
    @When("진입 시 상하단 메뉴바 확인")
    public void checkUpperAndBottomMenuBar() {
        try {
            log.info("진입 시 상하단 메뉴바 확인");
            AndroidManager.getElementById(Constant.더보기_id).isDisplayed();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 5초 후 전체화면모드 전환 확인
     */
    @When("5초 후 전체화면모드 전환 확인")
    public void autoTransferToFullScreenMode() {
        try {
            log.info("5초 후 전체화면모드 전환 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.더보기_id);
                if(element.isDisplayed()) {
                    fail("5초 후 자동으로 전체화면모드로 전환하지 않았습니다.");
                }
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어 종료
     */
    @When("뷰어 종료")
    public void exitViewerScreen() {
        try {
            log.info("뷰어 종료");
            AndroidManager.getElementById(Constant.viewerClose_id).click();
            try{
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/radio_rating_emotion01");
                if (element.isDisplayed()) {
                    element.click();
                    element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/button_rating_ok");
                    element.click();
                    TimeUnit.SECONDS.sleep(2);
                    element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/btn_nextbook_close");
                    element.click();
                }
            }catch (Exception e){
                return;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 선택 레이아웃 노출 시 닫기
     */
    @When("짝꿍책 선택 레이아웃 노출 시 닫기")
    public void closeNextBookLayoutIfDisplayed() {
        try {
            log.info("짝꿍책 선택 레이아웃 노출 시 닫기");
            try {
                AndroidManager.getElementByIdUntilDuration(Constant.pairBookXBtn_id, 3).click();
            } catch (Exception ignored) {}
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 읽던 페이지를 이어 보기 안내 팝업 노출 확인
     */
    @When("읽던 페이지를 이어 보기 안내 팝업 노출 확인")
    public void checkContinueReading() {
        try {
            log.info("읽던 페이지를 이어 보기 안내 팝업 노출 확인");
            WebElement alertMsg = AndroidManager.getElementById(Constant.안내팝업메시지_id);

            if (alertMsg.isDisplayed() && alertMsg.getText().contains("읽던 페이지를 이어서 볼까요?")) {
                return;
            }
            fail("읽던 페이지를 이어서 볼까요? 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 읽던 페이지 안내 팝업의 취소 버튼 클릭
     */
    @When("읽던 페이지 안내 팝업의 취소 버튼 클릭")
    public void clickNoBtnOnContinueReading() {
        try {
            log.info("읽던 페이지 안내 팝업의 취소 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업취소_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 일반 안내 팝업의 취소 버튼 클릭
     */
    @When("일반 안내 팝업의 취소 버튼 클릭")
    public void clickCancelOnCommonPopup() {
        try {
            log.info("일반 안내 팝업의 취소 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업취소_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 일반 안내 팝업의 확인 버튼 클릭
     */
    @When("일반 안내 팝업의 확인 버튼 클릭")
    public void clickOKOnCommonPopup() {
        try {
            log.info("일반 안내 팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업확인_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 처음 페이지로 진입 확인
     */
    @When("처음 페이지로 진입 확인")
    public void checkFirstPage() {
        try {
            log.info("처음 페이지로 진입 확인");
            WebElement pageIndex = AndroidManager.getElementById(Constant.currentPageIndex_id);
            if (pageIndex.isDisplayed()) {
                String currentPage = pageIndex.getText().split("/")[0];
                if (currentPage.equals("1")) {
                    return;
                }
                fail("처음 페이지가 아닙니다.");
            }
            fail("현재 페이지가 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 읽던 페이지 안내 팝업의 확인 버튼 클릭
     */
    @When("읽던 페이지 안내 팝업의 확인 버튼 클릭")
    public void clickOKBtnOnContinueReading() {
        try {
            log.info("읽던 페이지 안내 팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.안내팝업확인_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 처음 페이지가 아닌 읽던 페이지로 진입 확인
     */
    @When("처음 페이지가 아닌 읽던 페이지로 진입 확인")
    public void checkNotFirstPage() {
        try {
            log.info("처음 페이지가 아닌 읽던 페이지로 진입 확인");
            WebElement pageIndex = AndroidManager.getElementById(Constant.currentPageIndex_id);
            String currentPage = pageIndex.getText().split("/")[0];
            if (!currentPage.equals("1")) {
                return;
            }
            fail("처음 페이지로 노출되었습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어의 상단바 레이아웃 확인
     */
    @When("상단바 레이아웃 확인")
    public void checkUpperBarLayout() {
        try {
            log.info("뷰어의 상단바 레이아웃 확인");

            WebElement closeBtn = AndroidManager.getElementById(Constant.viewerClose_id);
            WebElement title = AndroidManager.getElementById(Constant.viewerBookTitle_id);
            WebElement more = AndroidManager.getElementById(Constant.더보기_id);

            if (closeBtn.isDisplayed() && title.isDisplayed() && more.isDisplayed()) {
                return;
            }
            fail("상단바 레이아웃이 정상적으로 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어 책 제목의 말줄임표 확인
     */
    @When("뷰어 책 제목의 말줄임표 확인")
    public void checkTitleOverFlow() {
        try {
            log.info("뷰어 책 제목의 말줄임표 확인");
            WebElement title = AndroidManager.getElementById(Constant.viewerBookTitle_id);
            if (title.getText().contains("...")) return;
            fail("말줄임표가 보이지 않습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 전체화면저장 버튼 클릭
     */
    @When("전체화면저장 버튼 클릭")
    public void clickAllScreenCaptureBtn() {
        try {
            log.info("전체화면저장 버튼 클릭");
            AndroidManager.getElementById(Constant.captureAllScreen_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 앨범에 현재 화면 저장 팝업 노출 확인
     */
    @When("독서 앨범에 현재 화면 저장 팝업 노출 확인")
    public void checkCurrentScreenSavePopup() {
        try {
            log.info("독서 앨범에 현재 화면 저장 팝업 노출 확인");
            WebElement element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            if (element.isDisplayed() && element.getText().contains("독서 앨범에 현재 화면을 저장합니다.")) return;
            fail("독서 앨범에 현재 화면을 저장합니다라는 알림팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 앨범의 현재 화면 저장 팝업 사라짐 확인
     */
    @When("독서 앨범의 현재 화면 저장 팝업 사라짐 확인")
    public void checkDisappearPopup() {
        try {
            log.info("독서 앨범의 현재 화면 저장 팝업 사라짐 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
                if (element.isDisplayed()) fail("독서 앨범의 현재 화면 저장 팝업이 사라지지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마음대로저장 버튼 클릭
     */
    @When("마음대로저장 버튼 클릭")
    public void clickRandomScreenCaptureBtn() {
        try {
            log.info("마음대로저장 버튼 클릭");
            AndroidManager.getElementById(Constant.captureRandomScreen_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 선을 그어 드래그 동작
     */
    @When("Y축 {int} 드래그 동작")
    public void dragByYOffset(int yOffset) {
        try {
            log.info("선을 그어 드래그 동작");
            Utils.dragScreenCenterToA(AndroidManager.getDriver(), (Utils.getScreenCenterX() + 156), yOffset);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마음대로 그림 저장 안내 팝업 확인
     */
    @When("마음대로 그림 저장 안내 팝업 확인")
    public void checkRandomScreenSavePopup() {
        try {
            log.info("마음대로 그림 저장 안내 팝업 확인");
            WebElement element = AndroidManager.getElementById(Constant.txtContent_id);
            WebElement capturedImage = AndroidManager.getElementById(Constant.imageViewCapture_id);
            if (element.isDisplayed() && element.getText().contains("독서 앨범에 그림을 저장합니다.") && capturedImage.isDisplayed()) return;
            fail("그림 저장 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마음대로 그림 저장 안내 팝업 사라짐 확인
     */
    @When("마음대로 그림 저장 안내 팝업 사라짐 확인")
    public void checkDisappearRandomScreenSavePopup() {
        try {
            log.info("마음대로 그림 저장 안내 팝업 사라짐 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.txtContent_id);
                if (element.isDisplayed()) fail("마음대로 그림 저장 안내 팝업이 사라지지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마음대로 그림 저장 안내 팝업의 취소 버튼 클릭
     */
    @When("마음대로 그림 저장 안내 팝업의 취소 버튼 클릭")
    public void clickCancelBtnOnRandomCapturePopup() {
        try {
            log.info("마음대로 그림 저장 안내 팝업의 취소 버튼 클릭");
            AndroidManager.getElementById(Constant.imageCaptureClose_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 마음대로 그림 저장 안내 팝업의 확인 버튼 클릭
     */
    @When("마음대로 그림 저장 안내 팝업의 확인 버튼 클릭")
    public void clickOKBtnOnRandomScreenSavePopup() {
        try {
            log.info("마음대로 그림 저장 안내 팝업의 확인 버튼 클릭");
            AndroidManager.getElementById(Constant.imageCaptureSave_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 일반 안내 팝업에서
     * 특정 안내 문구 일반 팝업 확인
     */
    @When("{string} 안내 문구 일반 팝업 확인")
    public void checkCommonPopupWithText(String text) {
        try {
            log.info("{} 안내 문구 일반 팝업 확인", text);
            WebElement element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            if (element.isDisplayed() && element.getText().contains(text)) return;
            fail(text + " 라는 문구가 담긴 안내 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 일반 안내 팝업 사라짐 확인
     */
    @When("일반 안내 팝업 사라짐 확인")
    public void checkDisappearCommonPopup() {
        try {
            log.info("일반 안내 팝업 사라짐 확인");

            try {
                WebElement element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
                if (element.isDisplayed()) fail("안내 팝업이 사라지지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서감상문 쓰기 화면으로 이동 확인
     */
    @When("독서감상문 쓰기 화면으로 이동 확인")
    public void checkWriteFeelingScreen() {
        try {
            log.info("독서감상문 쓰기 화면으로 이동 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.firstWriteFeelingThumbnail_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                if(AndroidManager.getElementById(Constant.templateTitle_id).isDisplayed()) return;
                fail("독서감상문 쓰기 화면으로 이동하지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 이미 감상문이 존재할 경우 노출되는 화면 확인
     */
    @When("이미 감상문이 존재할 경우 노출되는 화면 확인")
    public void checkAlreadyExistFeelingScreen() {
        try {
            log.info("이미 감상문이 존재할 경우 노출되는 화면 확인");
            WebElement alreadyText = AndroidManager.getElementByXpath(Constant.writeFeelingAlreadyExist_xPath);
            if (alreadyText.getText().equals("도서 당 작성 감상문 수는\n" +
                    "3개 입니다.")) return;

            WebElement feelingThumbnail = AndroidManager.getElementById(Constant.firstWriteFeelingThumbnail_id);
            if (alreadyText.isDisplayed() && alreadyText.getText().contains("감상문을 작성하세요") && feelingThumbnail.isDisplayed()) return;
            fail("이미 감상문이 존재할 경우 보여지는 화면이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 이미 감상문이 작성되어 있는 화면에서 감상문을 작성해주세요 버튼 클릭
     */
    @When("이미 감상문이 작성되어 있는 화면에서 감상문을 작성해주세요 버튼 클릭")
    public void clickWriteFeelingBtnOnAlreadyPage() {
        try {
            boolean isEmpty = false;
            log.info("이미 감상문이 작성되어 있는 화면에서 감상문을 작성해주세요 버튼 클릭");
            for (int i = 0; i < 3; i++) {
                WebElement date = AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/tvThumb"+ i);
                if (date.getText().isEmpty()) {
                    AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/ivReport" + i).click();
                    isEmpty = true;
                    break;
                }
            }
            if (!isEmpty) fail("한 도서에 최대 감상문 개수는 3개인데 이미 3개를 작성했습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 3개 모두 작성한 경우 화면 확인
     */
    @When("감상문 3개 모두 작성한 경우 화면 확인")
    public void checkAlreadyFullFeelingScreen() {
        try {
            log.info("감상문 3개 모두 작성한 경우 화면 확인");
            WebElement element = AndroidManager.getElementByXpath(Constant.writeFeelingAlreadyExist_xPath);
            if (element.isDisplayed() && element.getText().contains("도서 당 작성 감상문 수는\n" +
                    "3개 입니다.")) return;
            fail("3개 모두 작성한 감상문 쓰기 화면이 노출되지 않았습니다. 노출된 문구: " + element.getText());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 3개 모두 작성한 화면에서 임의의 감상문 삭제 버튼 클릭
     */
    @When("감상문 3개 모두 작성한 화면에서 임의의 감상문 삭제 버튼 클릭")
    public void clickDeleteBtnOnAlreadyWriteFeelingScreen() {
        try {
            log.info("감상문 3개 모두 작성한 화면에서 임의의 감상문 삭제 버튼 클릭");
            for (int i = 0; i < 3; i++) {
                try {
                    WebElement deleteBtn = AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/btnWrite" + i);
                    if (deleteBtn.isDisplayed()) {
                        deleteBtn.click();
                        break;
                    }
                } catch (Exception e) {
                    fail("삭제 버튼이 노출되지 않습니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문이 3개가 되도록 모두 작성시킨다.
     */
    @When("감상문 3개 모두 작성하기")
    public void loopForFullWriteFeelingState() {
        try {
            log.info("감상문이 3개가 되도록 모두 작성시킨다.");

            int i = 0;
            while (true) {
                if (i != 0) {
                    this.showUpperBar();
                    TimeUnit.SECONDS.sleep(2);
                    this.clickShowMoreBtn();
                    TimeUnit.SECONDS.sleep(2);
                    this.clickWriteFeelingBtn();
                    TimeUnit.SECONDS.sleep(2);
                    this.clickOKOnCommonPopup();
                    TimeUnit.SECONDS.sleep(2);
                }
                try {
                    WebElement element = AndroidManager.getElementByXpath(Constant.writeFeelingAlreadyExist_xPath);
                    String isFull = element.getText();

                    if (isFull.equals("감상문을 작성하세요")) {
                        Outer:
                        for (int j = 0; j < 3; j++) {
                            WebElement date = AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/tvThumb"+ j);
                            if (date.getText().isEmpty()) {
                                AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/ivReport" + j).click();
                                TimeUnit.SECONDS.sleep(2);
                                for (int k = 1; k < 5; k++) {
                                    String parentXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout";
                                    String childXPath =  parentXPath + "/android.widget.TextView";

                                    WebElement parentElement = AndroidManager.getElementByXpath(parentXPath);
                                    WebElement childElement = AndroidManager.getElementByXpath(childXPath);

                                    if (childElement.getText().equals("내 맘대로 그리기")) {
                                        parentElement.click();

                                        TimeUnit.SECONDS.sleep(2);
                                        AndroidManager.getElementById(Constant.selectTemplateOK_id).click();

                                        TimeUnit.SECONDS.sleep(2);
                                        AndroidManager.getElementById(Constant.drawingMode_id).click();

                                        TimeUnit.SECONDS.sleep(2);
                                        Utils.dragScreenCenterToA(AndroidManager.getDriver(), (Utils.getScreenCenterX() + 156), 100);

                                        TimeUnit.SECONDS.sleep(4);
                                        AndroidManager.getElementById(Constant.drawingSave_id).click();
                                        TimeUnit.SECONDS.sleep(5);

                                        break Outer;
                                    }
                                }
                            }
                        }
                    } else if (isFull.contains("도서 당 작성 감상문 수는\n" +
                            "3개 입니다.")) {
                        break;
                    }
                } catch (Exception e) {
                    for (int k = 1; k < 5; k++) {
                        String parentXPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+k+"]/android.widget.LinearLayout";
                        String childXPath =  parentXPath + "/android.widget.TextView";

                        WebElement parentElement = AndroidManager.getElementByXpath(parentXPath);
                        WebElement childElement = AndroidManager.getElementByXpath(childXPath);

                        if (childElement.getText().equals("내 맘대로 그리기")) {
                            parentElement.click();

                            TimeUnit.SECONDS.sleep(2);
                            AndroidManager.getElementById(Constant.selectTemplateOK_id).click();

                            TimeUnit.SECONDS.sleep(2);
                            AndroidManager.getElementById(Constant.drawingMode_id).click();

                            TimeUnit.SECONDS.sleep(2);
                            Utils.dragScreenCenterToA(AndroidManager.getDriver(), (Utils.getScreenCenterX() + 156), 100);

                            TimeUnit.SECONDS.sleep(4);
                            AndroidManager.getElementById(Constant.drawingSave_id).click();
                            TimeUnit.SECONDS.sleep(5);

                            break;
                        }
                    }

//                    AndroidManager.getElementById("com.wjthinkbig.mbookdiaryactivitytool:id/ivReport" + i).click();
//
//                    TimeUnit.SECONDS.sleep(5);
//                    AndroidManager.getElementByXpath(Constant.randomDrawingTemplate_xPath).click();
//
//                    TimeUnit.SECONDS.sleep(2);
//                    AndroidManager.getElementById(Constant.selectTemplateOK_id).click();
//
//                    TimeUnit.SECONDS.sleep(2);
//                    AndroidManager.getElementById(Constant.drawingMode_id).click();
//
//                    TimeUnit.SECONDS.sleep(2);
//                    Utils.dragScreenCenterToA(AndroidManager.getDriver(), (Utils.getScreenCenterX() + 156), 100);
//
//                    TimeUnit.SECONDS.sleep(4);
//                    AndroidManager.getElementById(Constant.drawingSave_id).click();
//                    TimeUnit.SECONDS.sleep(5);
                }
                i++;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 작성 리스트 화면에서 X 버튼 클릭
     */
    @When("감상문 작성 리스트 화면에서 X 버튼 클릭")
    public void clickXBtnOnWriteFeelingScreen() {
        try {
            log.info("감상문 작성 리스트 화면에서 X 버튼 클릭");
            AndroidManager.getElementById(Constant.writeFeelingAlreadyScreenCloseBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독후퀴즈 실행 확인
     */
    @When("독후퀴즈 실행 확인")
    public void checkCurrentScreenIsReadingQuiz() {
        try {
            log.info("독후퀴즈 실행 확인");
            String imageName = Utils.takeScreenShot();
            String result = Utils.imageToText(imageName);
            log.info("image to text: {}", result);
            assertTrue("독후퀴즈 실행 화면이 아닙니다.", (result.contains("맞 힌 문제") || result.contains("독 후 퀴 즈")));
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 화면 노출 확인
     */
    @When("감상문 보기 화면 노출 확인")
    public void checkSeeFeelingScreen() {
        try {
            log.info("감상문 보기 화면 노출 확인");
            WebElement element = AndroidManager.getElementById(Constant.tapForSeeFeeling_id);
            if (element.isDisplayed() && element.getText().contains("감상문 보기")) return;
            fail("감상문 보기 화면이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 탭 클릭
     */
    @When("감상문 보기 탭 클릭")
    public void clickTapForSeeFeeling() {
        try {
            log.info("감상문 보기 탭 클릭");
            AndroidManager.getElementById(Constant.tapForSeeFeeling_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 내가 쓴 감상문이 있다면 노출되는지 확인
     */
    @When("내가 쓴 감상문이 있다면 노출되는지 확인")
    public void clickSeeIfExistMyFeeling() {
        try {
            log.info("내가 쓴 감상문이 있다면 노출되는지 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.seeMyFeelingThumbnail_id);
                if (element.isDisplayed()) {
                    log.info("my report (feeling) is exists");
                    assertTrue(true);
                }
            } catch (Exception e) {
                try {
                    WebElement element = AndroidManager.getElementById(Constant.noMyReport_id);
                    if (element.isDisplayed()) {
                        log.info("my report (feeling) does not exists");
                    }
                } catch (Exception e2) {
                    fail("내가 쓴 감상문도 노출되지 않았으며, 내가 쓴 감상문이 없다는 알림 문구 또한 노출되지 않았습니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 친구들이 쓴 감상문이 있다면 노출되는지 확인
     */
    @When("친구들이 쓴 감상문이 있다면 노출되는지 확인")
    public void checkIfFriendsFeeling() {
        try {
            log.info("친구들이 쓴 감상문이 있다면 노출되는지 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.friendsReportArea_id);
                if (element.isDisplayed()) {
                    log.info("Friends report was exists");
                    assertTrue(true);
                }
            } catch (Exception e) {
                try {
                    WebElement element = AndroidManager.getElementById(Constant.noFriendsReport_id);
                    if (element.isDisplayed()) {
                        log.info("Friends report was not exists");
                        assertTrue(true);
                    }
                } catch (Exception e2) {
                    fail("친구들이 쓴 리포트 엘리먼트가 보이지도 않지만 친구들이 안 쓴 리포트 엘리먼트도 보이지 않습니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 내가 쓴 감상문 클릭
     */
    @When("내가 쓴 감상문 클릭")
    public void clickMyFeeling() {
        try {
            log.info("내가 쓴 감상문 클릭");
            try {
                WebElement element = AndroidManager.getElementById(Constant.seeMyFeelingThumbnail_id);
                if (element.isDisplayed()) element.click();
            } catch (Exception e) {
                fail("내가 쓴 감상문이 없습니다. 감상문을 작성한 후 다시 시도하세요.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 친구들이 쓴 감상문 클릭
     */
    @When("친구들이 쓴 감상문 클릭")
    public void clickFriendsFeelingThumbnail() {
        try {
            log.info("친구들이 쓴 감상문 클릭");
            try {
                WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.thinkplayground:id/imageview_book_detail_thum", 0);
                if (element.isDisplayed()) element.click();
            } catch (Exception e) {
                fail("친구들이 쓴 감상문이 없습니다. 다른 책으로 확인해보세요.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범으로 이동 확인
     */
    @When("독서앨범으로 이동 확인")
    public void checkCurrentScreenReadingAlbum() {
        try {
            log.info("독서앨범으로 이동 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.appTitle_id);
                if (element.isDisplayed() && element.getText().contains("독서앨범")) assertTrue(true);
            } catch (Exception e) {
                fail("독서앨범 페이지가 아닙니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 일반 뒤로가기 버튼 클릭
     */
    @When("일반 뒤로가기 버튼 클릭")
    public void clickCommonBackBtn() {
        try {
            log.info("일반 뒤로가기 버튼 클릭");
            AndroidManager.getElementById(Constant.commonBackButton_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 팝업에서 X 버튼 클릭
     */
    @When("감상문 보기 팝업에서 X 버튼 클릭")
    public void clickXBtnOnSeeFeeling() {
        try {
            log.info("감상문 보기 팝업에서 X 버튼 클릭");
            AndroidManager.getElementById(Constant.thinkPlaygroundClose_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 감상문 보기 팝업 사라짐 확인
     */
    @When("감상문 보기 팝업 사라짐 확인")
    public void checkDisappearSeeFeelingPopup() {
        try {
            log.info("감상문 보기 팝업 사라짐 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.tapForSeeFeeling_id);
                if (element.isDisplayed()) {
                    fail("감상문 보기 팝업이 사라지지 않았습니다.");
                }
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 페이지 노출 확인
     */
    @When("짝꿍책 페이지 노출 확인")
    public void checkPairBookPage() {
        try {
            log.info("짝꿍책 페이지 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.pairBookListBody_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("짝꿍책 페이지가 노출되지 않았습니다.");
            }

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 클릭 시 해당 도서 실행 확인
     */
    @When("짝꿍책 클릭 시 해당 도서 실행 확인")
    public void checkPairBookEntered() {
        try {
            log.info("짝꿍책 클릭 시 해당 도서 실행 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.pairBookListBody_id);
                if (element.isDisplayed()) fail("짝꿍책 선택 페이지에서 벗어나지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 안내 문구 및 최소 1권은 노출 확인
     */
    @When("짝꿍책 안내 문구 및 최소 1권은 노출 확인")
    public void checkGuideSentenceAndAtLeastOnePairBook() {
        try {
            log.info("짝꿍책 안내 문구 및 최소 1권은 노출 확인");
            WebElement firstPairBook = AndroidManager.getElementByXpath(Constant.firstPairBook_xPath);
            WebElement guidance = AndroidManager.getElementByXpath(Constant.pairBookGuidance_xPath);
            if (!firstPairBook.isDisplayed()) fail("최소 한 권의 짝꿍책도 노출되지 않았습니다.");
            if (!guidance.isDisplayed()) fail("짝꿍책 안내 문구가 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책의 도서장르 - 대상연령 - 썸네일 - 키워드 노출 확인
     */
    @When("짝꿍책의 도서장르 - 대상연령 - 썸네일 - 키워드 노출 확인")
    public void checkPairBookContents() {
        try {
            log.info("짝꿍책의 도서장르 - 대상연령 - 썸네일 - 키워드 노출 확인");
            WebElement ages = AndroidManager.getElementByXpath(Constant.firstPairBookAge_xPath);
            WebElement genres = AndroidManager.getElementByXpath(Constant.firstPairBookGenre_xPath);
            WebElement keywords = AndroidManager.getElementByXpath(Constant.firstPairBookKeywords_xPath);
            if (!ages.isDisplayed()) fail("짝꿍책의 연령대가 노출되지 않았습니다.");
            if (!genres.isDisplayed()) fail("짝꿍책의 장르가 노출되지 않았습니다.");
            if (!keywords.isDisplayed()) fail("짝꿍책의 키워드가 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 1번 짝꿍책 클릭
     */
    @When("{int}번 짝꿍책 클릭")
    public void clickPairBookByIndex(int index) {
        try {
            log.info("{}번 짝꿍책 클릭", index);
            WebElement pairBook = null;
            switch (index) {
                case 1:
                    pairBook = AndroidManager.getElementByXpath(Constant.firstPairBook_xPath);
                    break;
                case 2:
                    pairBook = AndroidManager.getElementByXpath(Constant.secondPairBook_xPath);
                    break;
                case 3:
                    pairBook = AndroidManager.getElementByXpath(Constant.thirdPairBook_xPath);
                    break;
            }
            if (pairBook == null) fail("정상적인 순서의 짝꿍책을 선택하지 않으셨습니다. 전달받은 짝꿍책 index: " + index);
            pairBook.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 짝꿍책 페이지에서 X 버튼 클릭
     */
    @When("짝꿍책 페이지에서 X 버튼 클릭")
    public void clickXBtnOnPairBookPage() {
        try {
            log.info("짝꿍책 페이지에서 X 버튼 클릭");
            AndroidManager.getElementById(Constant.pairBookXBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어 화면 진입 확인
     */
    @When("뷰어 화면 진입 확인")
    public void checkCurrentScreenViewer() {
        try {
            log.info("뷰어 화면 진입 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.viewerBookTitle_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("뷰어 화면의 상단바가 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 도움말 버튼 클릭
     */
    @When("도움말 버튼 클릭")
    public void clickHelpBtn() {
        try {
            log.info("도움말 버튼 클릭");
            AndroidManager.getElementById(Constant.helpBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 도움말 페이지 노출 확인
     */
    @When("도움말 페이지 노출 확인")
    public void checkHelpLayout() {
        try {
            log.info("도움말 페이지 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.helpViewLayout_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("도움말 화면 레이아웃이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 하단 도트마크 표시 확인
     */
    @When("하단 도트마크 표시 확인")
    public void checkDotMark() {
        try {
            log.info("하단 도트마크 표시 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.bottomIndicatorOnHelpView_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("도움말 페이지에 하단 도트마크가 표시되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 도움말 1페이지는 이전 다음 페이지 이동 정보에 대한 내용 확인
     */
    @When("도움말 1페이지는 이전 다음 페이지 이동 정보에 대한 내용 확인")
    public void checkFirstPageOnHelpView() {
        try {
            log.info("도움말 1페이지는 이전 다음 페이지 이동 정보에 대한 내용 확인");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);
            if (result.contains("좌 우 로 화 면 을 밀 어 보 세 요 !")) return;
            fail("도움말 첫 페이지에서 이전 혹은 다음 페이지의 이동 정보에 대한 내용이 없거나 첫 페이지가 아닙니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 도움말 2페이지는 전체화면저장 - 마음대로저장 - 감상문 - 독후퀴즈에 대한 내용 설명 확인
     */
    @When("도움말 2페이지는 전체화면저장 - 마음대로저장 - 감상문 - 독후퀴즈에 대한 내용 설명 확인")
    public void checkSecondPageOnHelpView() {
        try {
            log.info("도움말 2페이지는 전체화면저장 - 마음대로저장 - 감상문 - 독후퀴즈에 대한 내용 설명 확인");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);
            if (result.contains("전 체 화 면 저장") ||
                result.contains("마 음 대 로 저장") ||
                result.contains("감 상 문") ||
                result.contains("퀴 즈 를")) return;
            fail("도움말 2페이지에서의 설명이 올바르지 않습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오이북 도움말 2페이지는 보기 타입 - 잠금 기능 대한 내용 설명 확인
     */
    @When("오디오이북 도움말 2페이지는 보기 타입 - 잠금 기능 대한 내용 설명 확인")
    public void checkAudioBookSecondHelpPage() {
        try {
            log.info("오디오이북 도움말 2페이지는 보기 타입 - 잠금 기능 대한 내용 설명 확인");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);

            if (result.contains("여 백 없 이 곽 잔 화 면 으 로 책 을 볼 수 있 어 요") ||
                result.contains("한 페 이 지 씩 따 로 따 로 볼 수 있 어 요") ||
                result.contains("화 면 을 잠 그 고")) return;
            fail("오디오이북 도움말 2페이지의 설명이 잘못되었거나, 이미지 OCR에 실패했습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오른쪽에서 왼쪽으로 스와이프
     */
    @When("오른쪽에서 왼쪽으로 스와이프")
    public void swipeNextPage() {
        try {
            log.info("오른쪽에서 왼쪽으로 스와이프");
            Utils.swipeRightToLeft();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 왼쪽에서 오른쪽으로 스와이프
     */
    @When("왼쪽에서 오른쪽으로 스와이프")
    public void swipePrevPage() {
        try {
            log.info("왼쪽에서 오른쪽으로 스와이프");
            Utils.swipeLeftToRight();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 도움말 화면에서 X 버튼 클릭
     */
    @When("도움말 화면에서 X 버튼 클릭")
    public void clickXBtnOnHelpView() {
        try {
            log.info("도움말 화면에서 X 버튼 클릭");
            AndroidManager.getElementById(Constant.helpViewXBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 하단바 엘리먼트 확인
     */
    @When("하단바 엘리먼트 확인")
    public void checkBottomBar() {
        try {
            log.info("하단바 엘리먼트 확인");
            try {
                WebElement thumbnailBtn = AndroidManager.getElementById(Constant.bottomThumbnailBtn_id);
                WebElement pageIndex = AndroidManager.getElementById(Constant.currentPageIndex_id);
                if (thumbnailBtn.isDisplayed() && pageIndex.isDisplayed()) {
                    String[] index = pageIndex.getText().split("/");
                    if (index.length == 2) return;
                    fail("현재 페이지 또는 전체 페이지 수가 노출되지 않았습니다.");
                }
                fail("하단 펼쳐보기 버튼 또는 페이지 인덱스가 노출되지 않았습니다.");
            } catch (Exception e) {
                fail("하단 펼쳐보기 버튼 또는 페이지 인덱스가 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 하단바에서 펼쳐보기 버튼 클릭
     */
    @When("하단바에서 펼쳐보기 버튼 클릭")
    public void clickThumbnailBtnOnBottomBar() {
        try {
            log.info("하단바에서 펼쳐보기 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomThumbnailBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 펼쳐보기 리스트 노출 확인
     */
    @When("펼쳐보기 리스트 노출 확인")
    public void checkBottomThumbnailList() {
        try {
            log.info("펼쳐보기 리스트 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.bottomScrollThumbnailLayout_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("하단 펼쳐보기 리스트가 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 펼쳐보기 리스트 닫힘 확인
     */
    @When("펼쳐보기 리스트 닫힘 확인")
    public void checkDisappearBottomThumbnailList() {
        try {
            log.info("펼쳐보기 리스트 닫힘 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.bottomScrollThumbnailLayout_id);
                if (element.isDisplayed()) fail("펼쳐보기 리스트가 닫히지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 펼쳐보기 리스트 스와이프 기능 확인
     */
    @When("펼쳐보기 리스트 스와이프 기능 확인")
    public void checkAvailableSwipeOnBottomThumbnailList() {
        try {
            log.info("펼쳐보기 리스트 스와이프 기능 확인");
            WebElement isExist = AndroidManager.getElementByTextAndHorizontalScrollableListIdAfterSwipe("com.wjthinkbig.mepubviewer2:id/scroll_thumb", "30");
            if (isExist.isDisplayed()) return;
            fail("스와이프를 하기 위해 존재하는 스크롤 가능한 리스트의 존재하는 엘리먼트를 전달해야 합니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 펼쳐보기 리스트 X 버튼 클릭
     */
    @When("펼쳐보기 리스트 X 버튼 클릭")
    public void clickXBtnOnBottomThumbnailList() {
        try {
            log.info("펼쳐보기 리스트 X 버튼 클릭");
            AndroidManager.getElementById(Constant.thumbCloseBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어 하단바 페이지 카운트 확인
     */
    @When("뷰어 하단바 페이지 카운트 확인")
    public void checkIndexOnBottomBar() {
        try {
            log.info("뷰어 하단바 페이지 카운트 확인");
            WebElement index = AndroidManager.getElementById(Constant.currentPageIndex_id);
            String currentPage = index.getText().split("/")[0];
            if (currentPage.equals("1")) fail("다음 페이지로 이동했지만 페이지 카운팅이 되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 바나쿠 캐릭터와 토스트 팝업 확인
     */
    @When("바나쿠 캐릭터와 토스트 팝업 확인")
    public void checkBanaAndToastPopup() {
        try {
            log.info("바나쿠 캐릭터와 토스트 팝업 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.banaText_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("바나쿠 토스트 팝업이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 평가 화면 노출 확인
     */
    @When("평가 화면 노출 확인")
    public void checkRatingScreen() {
        try {
            log.info("평가 화면 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.feelPointLayout_id);
                WebElement good = AndroidManager.getElementById(Constant.goodEmoji_id);
                WebElement bad = AndroidManager.getElementById(Constant.badEmoji_id);
                if (element.isDisplayed() && good.isDisplayed() && bad.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("평가 화면이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 평가 항목 좋아요 클릭
     */
    @When("평가 항목 좋아요 클릭")
    public void clickGoodEmoji() {
        try {
            log.info("평가 항목 좋아요 클릭");
            AndroidManager.getElementById(Constant.goodEmoji_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 평가완료 버튼 노출 확인
     */
    @When("평가완료 버튼 노출 확인")
    public void checkRatingOKBtn() {
        try {
            log.info("평가완료 버튼 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.ratingOKBtn_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("평가완료 버튼이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 평가완료 버튼 클릭
     */
    @When("평가완료 버튼 클릭")
    public void clickRatingOKBtn() {
        try {
            log.info("평가완료 버튼 클릭");
            AndroidManager.getElementById(Constant.ratingOKBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Orientation is "PORTRAIT" or "LANDSCAPE"
     */
    @When("Orientation is {string}")
    public void checkCurrentOrientation(String orientation) {
        if (!orientation.equals("LANDSCAPE") && !orientation.equals("PORTRAIT")) throw new InvalidParameterException("orientation is only available 'PORTRAIT' or 'LANDSCAPE'");
        try {
            log.info("Orientation is {}", orientation);
            String currentOrientation = AndroidManager.getDriver().getOrientation().toString();
            if (currentOrientation.equals(orientation)) return;
            fail("현재 Orientation 예상한 결과와 다릅니다. 현재 orientation: " + currentOrientation + ", 예상한 orientation: " + orientation);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 회전잠금 또는 자동회전 버튼 클릭
     */
    @When("회전잠금 또는 자동회전 버튼 클릭")
    public void clickRotationLockBtn() {
        try {
            log.info("회전잠금 또는 자동회전 버튼 클릭");
            System.out.println(AndroidManager.getElementById(Constant.rotationBtn_id).getText());
            AndroidManager.getElementById(Constant.rotationBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 회전잠금 확인
     */
    @When("회전잠금 확인")
    public void checkRotationLocked() {
        try {
            log.info("회전잠금 확인");
            try {
                AndroidManager.getDriver().rotate(ScreenOrientation.PORTRAIT);
                fail("회전 잠금이 정상적으로 실행되지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 자동회전 확인
     */
    @When("자동회전 확인")
    public void checkRotationUnlocked() {
        try {
            log.info("자동회전 확인");
            try {
                AndroidManager.getDriver().unlockDevice();
                AndroidManager.getDriver().rotate(ScreenOrientation.PORTRAIT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 펼쳐보기 리스트의 10번째 페이지로 이동
     * @param index page index
     */
    @When("펼쳐보기 리스트의 {int}번째 페이지로 이동")
    public void goPageByIndex(int index) {
        try {
            log.info("펼쳐보기 리스트의 {}번째 페이지로 이동", index);
            try {
                WebElement isExist = AndroidManager.getElementByTextAndHorizontalScrollableListIdAfterSwipe("com.wjthinkbig.mepubviewer2:id/scroll_thumb", String.valueOf(index));
                if (isExist.isDisplayed()) {
                    isExist.click();
                }
            } catch (Exception e) {
                fail("해당 페이지가 없거나 이동이 불가합니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전 검색 X, Y
     * @param x xOffset
     * @param y yOffset
     */
    @When("사전 검색 X:{int} Y:{int}")
    public void method(int x, int y) {
        try {
            log.info("사전 검색 X:{} Y:{}", x, y);
            Utils.touchSpecificCoordinates(x, y);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전검색 화면 확인
     */
    @When("사전검색 화면 확인")
    public void checkDictionaryScreen() {
        try {
            log.info("사전검색 화면 확인");
            try {
                WebElement element = AndroidManager.getElementByXpath(Constant.dictionaryTitle_xPath);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("사전검색 화면이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전검색 화면의 X 버튼 클릭
     */
    @When("사전검색 화면의 X 버튼 클릭")
    public void clickXBtnOnDictScreen() {
        try {
            log.info("사전검색 화면의 X 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.dictionaryXBtn_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전검색 텍스트 찾기 화면으로 재이동 확인
     */
    @When("사전검색 텍스트 찾기 화면으로 재이동 확인")
    public void checkBackDictSearchScreen() {
        try {
            log.info("사전검색 텍스트 찾기 화면으로 재이동 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.dictionaryRunningPage_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("사전 검색을 위한 텍스트 선택 화면이 아닙니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 10자 이상 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인
     */
    @When("10자 이상 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인")
    public void checkMoreThanTenWordAndToastPopup() {
        try {
            log.info("10자 이상 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인");
            Utils.dragSourceToTarget(854, 557, 1049, 602);
            /* TouchAction deprecated
            TouchAction touchAction = new TouchAction(AndroidManager.getDriver());
            touchAction.press(PointOption.point(854, 557))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .perform()
                    .moveTo(PointOption.point(1049, 602))
                    .release()
                    .perform();
             */
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 10자 이상 영어 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인
     */
    @When("10자 이상 영어 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인")
    public void checkMoreThenTenWord() {
        try {
            log.info("10자 이상 영어 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인");
            Utils.dragSourceToTarget(695, 806, 841, 1087);
            checkToastPopup("최대 20자");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 영한사전 우측 상단 검색 버튼 클릭
     */
    @When("영한사전 우측 상단 검색 버튼 클릭")
    public void clickRightUpperSearchBtnOnEnDictionary() {
        try {
            log.info("영한사전 우측 상단 검색 버튼 클릭");
            AndroidManager.getElementById(Constant.enDictionarySearchGoBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사전 검색 종료 버튼 클릭
     */
    @When("사전 검색 종료 버튼 클릭")
    public void clickCloseBtnOnDictionaryPage() {
        try {
            log.info("사전 검색 종료 버튼 클릭");
            AndroidManager.getElementById(Constant.dictionaryCloseBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 보기 화면 노출 확인
     */
    @When("오디오북 보기 화면 노출 확인")
    public void checkAudioBookScreen() {
        try {
            log.info("오디오북 보기 화면 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.audioTap_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("오디오북 보기 화면이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 내가 녹음한 오디오북이 없다면 안내 문구 노출 확인
     */
    @When("내가 녹음한 오디오북이 없다면 안내 문구 노출 확인")
    public void checkMyAudioBookExists() {
        try {
            log.info("내가 녹음한 오디오북이 없다면 안내 문구 노출 확인");
            try {
                AndroidManager.getElementById(Constant.noMyAudio_id);
                log.info("내가 녹음한 오디오북이 없습니다.");
            } catch (Exception e) {
                log.info("내가 녹음한 오디오북이 있습니다.");
                try {
                    WebElement element = AndroidManager.getElementById(Constant.myAudio_id);
                    if (element.isDisplayed()) {
                        WebElement myAudioPlayBtn = AndroidManager.getElementByXpath(Constant.myAudioPlayBtn_xPath);
                        WebElement myAudioPlayCount = AndroidManager.getElementByXpath(Constant.myAudioPlayCount_xPath);
                        WebElement myAudioLikeBtn = AndroidManager.getElementByXpath(Constant.myAudioLikeBtn_xPath);
                        WebElement myAudioLikeCount = AndroidManager.getElementByXpath(Constant.myAudioLikeCount_xPath);
                        if (myAudioLikeBtn.isDisplayed() &&
                            myAudioLikeCount.isDisplayed() &&
                            myAudioPlayBtn.isDisplayed() &&
                            myAudioPlayCount.isDisplayed()) assertTrue(true);
                    }
                } catch (Exception e2) {
                    fail("내가 녹음한 오디오북이 없지만 안내 문구도 없는 에러가 발생했습니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 친구가 녹음한 오디오북이 없다면 안내 문구 노출 확인
     */
    @When("친구가 녹음한 오디오북이 없다면 안내 문구 노출 확인")
    public void checkFriendsAudioBookExists() {
        try {
            log.info("친구가 녹음한 오디오북이 없다면 안내 문구 노출 확인");
            try {
                AndroidManager.getElementById(Constant.noFriendsAudio_id);
                log.info("친구가 녹음한 오디오북이 없습니다.");
            } catch (Exception e) {
                log.info("친구가 녹음한 오디오북이 있습니다.");
                try {
                    WebElement element = AndroidManager.getElementById(Constant.friendsAudio_id);
                    if (element.isDisplayed()) assertTrue(true);
                } catch (Exception e2) {
                    fail("친구가 녹음한 오디오북도 없지만 오디오북이 없다는 안내 문구도 노출되지 않은 에러가 발생했습니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 보기타입 버튼 클릭
     */
    @When("보기타입 버튼 클릭")
    public void clickSeeTypeBtn() {
        try {
            log.info("보기타입 버튼 클릭");
            AndroidManager.getElementById(Constant.seeTypeBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 보기 버튼들 노출 확인
     */
    @When("보기 버튼들 노출 확인")
    public void checkFillViewAndSingleViewBtn() {
        try {
            log.info("보기 버튼들 노출 확인");
            try {
                WebElement fillViewBtn = AndroidManager.getElementById(Constant.fillViewBtn_id);
                WebElement singleViewBtn = AndroidManager.getElementById(Constant.singleViewBtn_id);
                if (fillViewBtn.isDisplayed() && singleViewBtn.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("채워보기 양면보기 버튼이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 단면보기 버튼 클릭
     */
    @When("단면보기 버튼 클릭")
    public void clickSingleViewBtn() {
        try {
            log.info("단면보기 버튼 클릭");
            AndroidManager.getElementById(Constant.singleViewBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 채워보기 버튼 클릭
     */
    @When("채워보기 버튼 클릭")
    public void clickFillViewBtn() {
        try {
            log.info("채워보기 버튼 클릭");
            AndroidManager.getElementById(Constant.fillViewBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 채워보기 시 스크롤 가능 여부 확인
     */
    @When("채워보기 시 스크롤 가능 여부 확인")
    public void checkIsScrollableView() {
        try {
            log.info("채워보기 시 스크롤 가능 여부 확인");
            try {
                WebElement layout = AndroidManager.getElementByXpath(Constant.fillViewLayout_xPath);
                assertEquals("스크롤 가능하지 않습니다.", "true", layout.getAttribute("scrollable"));
            } catch (Exception e) {
                fail("채워보기 시 보여지는 layout이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 기본보기 버튼 클릭
     */
    @When("기본보기 버튼 클릭")
    public void clickBasicViewBtn() {
        try {
            log.info("기본보기 버튼 클릭");
            AndroidManager.getElementById(Constant.basicViewBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * "이 책을 친구 목소리로 들어볼래?" 바나 캐릭터 토스트 팝업 노출 확인
     */
    @When("{string} 바나 캐릭터 토스트 팝업 노출 확인")
    public void checkBanaCharacterToastPopup(String toastMessage) {
        try {
            log.info("{} 바나 캐릭터 토스트 팝업 노출 확인", toastMessage);
            try {
                WebElement element = AndroidManager.getElementById(Constant.banaToastMessage_id);
                if (element.isDisplayed()) {
                    assertTrue("토스트 메시지가 동일하지 않습니다. 예상 메시지: " + toastMessage + " 실제 메시지: " + element.getText(),
                            element.getText().contains(toastMessage));
                }
            } catch (Exception e) {
                fail("바나 캐릭터 토스트 팝업이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 친구 녹음 오디오북 토스트 팝업 클릭
     */
    @When("친구 녹음 오디오북 토스트 팝업 클릭")
    public void clickFriendsAudioBookPopup() {
        try {
            log.info("친구 녹음 오디오북 토스트 팝업 클릭");
            try {
                WebElement element = AndroidManager.getElementById(Constant.banaToastMessage_id);
                if (element.isDisplayed()) element.click();
            } catch (Exception e) {
                fail("바나 캐릭터 토스트 팝업이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 음원 재생 - 정지 버튼 클릭
     */
    @When("음원 재생 - 정지 버튼 클릭")
    public void clickPlayOrPauseBtn() {
        try {
            log.info("음원 재생 - 정지 버튼 클릭");
            AndroidManager.getElementById(Constant.playOrPauseBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오이북 도움말 3페이지는 저장 - 감상문쓰기 - 독후퀴즈 - 짝꿍책 대한 내용 설명 확인
     */
    @When("오디오이북 도움말 3페이지는 저장 - 감상문쓰기 - 독후퀴즈 - 짝꿍책 대한 내용 설명 확인")
    public void checkThirdHelpPageOnAudioBook() {
        try {
            log.info("오디오이북 도움말 3페이지는 저장 - 감상문쓰기 - 독후퀴즈 - 짝꿍책 대한 내용 설명 확인");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);
            if (result.contains("저 장 하 고 싶 은 그 림 을 자 유 롭 게 저 장") &&
                result.contains("감 상 문 도 쓸 수 있 어 요") &&
                result.contains("알 씀 달 씀 퀴 즈 를 풀 어 봐 요")) return;
            fail("오디오이북의 도움말 3페이지가 아니거나 제대로 된 정보가 출력되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오이북 도움말 4페이지는 사전 - 감상문보기 - 오디오북 보기 대한 내용 설명 확인
     */
    @When("오디오이북 도움말 4페이지는 사전 - 감상문보기 - 오디오북 보기 대한 내용 설명 확인")
    public void checkFourthHelpPageOnAudioBook() {
        try {
            log.info("오디오이북 도움말 4페이지는 사전 - 감상문보기 - 오디오북 보기 대한 내용 설명 확인");
            String image = Utils.takeScreenShot();
            String result = Utils.imageToText(image);
            if (result.contains("궁 금 한 단 어 는 바 로 찾 아 봐 요") &&
                result.contains("친 구 들 의 감 상 문 과 오 디 오 북 으 로 도 만 날 수 있 어 요")) return;
            fail("오디오이북의 도움말 4페이지가 아니거나 제대로 된 정보가 출력되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 하단 메뉴바의 엘리먼트 확인
     */
    @When("하단 메뉴바의 엘리먼트 확인")
    public void checkBottomMenuBarOnPlayerView() {
        try {
            log.info("하단 메뉴바의 엘리먼트 확인");
            try {
                WebElement progressBar = AndroidManager.getElementById(Constant.viewerProgressBar_id);
                WebElement playAndPauseBtn = AndroidManager.getElementById(Constant.playOrPauseBtn_id);
                WebElement bottomPrevBtn = AndroidManager.getElementById(Constant.bottomPrevBtn_id);
                WebElement bottomNextBtn = AndroidManager.getElementById(Constant.bottomNextBtn_id);
                WebElement spentTimeText = AndroidManager.getElementById(Constant.spentTimeText_id);
                WebElement bottomSpeedBtn = AndroidManager.getElementById(Constant.bottomSpeedBtn_id);
                WebElement bottomLockBtn = AndroidManager.getElementById(Constant.bottomLockBtn_id);
                WebElement bottomRepeatBtn = AndroidManager.getElementById(Constant.bottomRepeatBtn_id);
                String[] spentTime = spentTimeText.getText().split("/");
                if (progressBar.isDisplayed() &&
                    playAndPauseBtn.isDisplayed() &&
                    bottomPrevBtn.isDisplayed() &&
                    bottomNextBtn.isDisplayed() &&
                    spentTimeText.isDisplayed() &&
                    bottomSpeedBtn.isDisplayed() &&
                    bottomLockBtn.isDisplayed() &&
                    bottomRepeatBtn.isDisplayed() && spentTime.length == 2) assertTrue(true);
            } catch (Exception e) {
                fail("하단 메뉴바에 보여져야 할 항목이 제대로 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 현재 페이지 정보 습득
     */
    @When("현재 페이지 정보 습득")
    public void getCurrentPageIndexOnViewer() {
        try {
            log.info("현재 페이지 정보 습득");
            WebElement pageIndex = AndroidManager.getElementById(Constant.currentPageIndex_id);
            currentPageOnViewer = pageIndex.getText().split("/")[0];
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 뷰어에서 하단바의 >> 버튼 클릭
     */
    @When(">> 버튼 클릭")
    public void clickNextPageBtnOnViewer() {
        try {
            log.info(">> 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomNextBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 다음 페이지로 이동 후 페이지 정보 확인
     */
    @When("다음 페이지로 이동 후 페이지 정보 확인")
    public void checkCurrentPage() {
        try {
            log.info("다음 페이지로 이동 후 페이지 정보 확인");
            WebElement element = AndroidManager.getElementById(Constant.currentPageIndex_id);
            String current = element.getText().split("/")[0];

            assertEquals("다음 페이지 이동 버튼 클릭을 했지만 페이지가 이동되지 않았습니다.", (Integer.parseInt(current) - 1), Integer.parseInt(currentPageOnViewer));
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * << 버튼 클릭
     */
    @When("<< 버튼 클릭")
    public void clickPrevPageOnViewer() {
        try {
            log.info("<< 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomPrevBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 이전 페이지로 이동 후 페이지 정보 확인
     */
    @When("이전 페이지로 이동 후 페이지 정보 확인")
    public void checkCurrentPageAfterGoPrevPage() {
        try {
            log.info("이전 페이지로 이동 후 페이지 정보 확인");
            WebElement element = AndroidManager.getElementById(Constant.currentPageIndex_id);
            String current = element.getText().split("/")[0];

            assertEquals("다음 페이지 이동 버튼 클릭을 했지만 페이지가 이동되지 않았습니다.", Integer.parseInt(current), Integer.parseInt(currentPageOnViewer));
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수동 - 자동 버튼 클릭
     */
    @When("수동 - 자동 버튼 클릭")
    public void clickAutoPlayBtnOnViewer() {
        try {
            log.info("자동 - 수동 버튼 클릭");
            AndroidManager.getElementById(Constant.autoPlayBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 "play" or "stopped" 확인
     * @param currentState "play" or "stopped"
     */
    @When("독서 {string} 확인")
    public void method(String currentState) {
        if (!currentState.equals("play") && !currentState.equals("stopped")) throw new InvalidParameterException("Parameter only available 'stopped' or 'play'");
        try {
            log.info("독서 {} 확인", currentState);
            boolean isPlaying = Utils.isBookPlayerRunning();
            switch (currentState) {
                case "play":
                    if (!isPlaying) {
                        fail("도서가 재생중입니다.");
                    }
                    break;
                case "stopped":
                    if (isPlaying) {
                        fail("도서가 재생중입니다.");
                    }
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
     * 하단바 반복 버튼 클릭
     */
    @When("하단바 반복 버튼 클릭")
    public void clickBottomRepeatBtn() {
        try {
            log.info("하단바 반복 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomRepeatBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 반복 실행 수행 확인
     */
    @When("반복 실행 수행 확인")
    public void checkRepeatPlayer() {
        try {
            log.info("반복 실행 수행 확인");
            boolean isPlaying = Utils.isBookPlayerRunning();
            if (isPlaying) return;
            fail("반복 수행이 실행되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 반복 실행 수행 되지 않음 확인
     */
    @When("반복 실행 수행 되지 않음 확인")
    public void checkNoRepeatPlayer() {
        try {
            log.info("반복 실행 수행 되지 않음 확인");
            boolean isPlaying = Utils.isBookPlayerRunning();
            if (!isPlaying) return;
            fail("반복 수행이 실행되는 중입니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 배속 버튼 클릭
     */
    @When("배속 버튼 클릭")
    public void clickSpeedBtnOnViewer() {
        try {
            log.info("배속 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomSpeedBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 디폴트는 보통 빠르기임을 확인
     */
    @When("디폴트는 보통 빠르기임을 확인")
    public void checkDefaultValueIsNormalSpeed() {
        try {
            log.info("디폴트는 보통 빠르기임을 확인");
            this.checkToastPopup("조금 빠르게 재생합니다");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 화면잠금 버튼 클릭
     */
    @When("화면잠금 버튼 클릭")
    public void clickLockScreenOnViewer() {
        try {
            log.info("화면잠금 버튼 클릭");
            AndroidManager.getElementById(Constant.bottomLockBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 잠금 버튼은 디폴트로 해제 확인
     */
    @When("잠금 버튼은 디폴트로 해제 확인")
    public void checkLockStateDefaultIsUnLock() {
        try {
            log.info("잠금 버튼은 디폴트로 해제 확인");
            this.checkToastPopup("화면 잠금이 설정되었습니다");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 화면 잠금 설정 표시 버튼 노출 확인
     */
    @When("화면 잠금 설정 표시 버튼 노출 확인")
    public void checkLockScreenBtnOnViewer() {
        try {
            log.info("화면 잠금 설정 표시 버튼 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.lockScreenBtn_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("우측 하단에 잠금 설정 표시 버튼이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 화면 잠금 설정 표시 버튼 클릭
     */
    @When("화면 잠금 설정 표시 버튼 클릭")
    public void clickLockScreenBtnOnViewer() {
        try {
            log.info("화면 잠금 설정 표시 버튼 클릭");
            AndroidManager.getElementById(Constant.lockScreenBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 더보기 리스트 노출 확인
     */
    @When("더보기 리스트 노출 확인")
    public void checkMoreViewList() {
        try {
            log.info("더보기 리스트 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.moreViewLayout_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("더보기 리스트가 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 더보기 리스트 미노출 확인
     */
    @When("더보기 리스트 미노출 확인")
    public void checkDisappearMoreViewList() {
        try {
            log.info("더보기 리스트 미노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.moreViewLayout_id);
                if (element.isDisplayed()) fail("더보기 리스트가 사라지지 않았습니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 연속재생 리스트 노출 시 딤 부분 클릭
     */
    @When("연속재생 리스트 노출 시 딤 부분 클릭")
    public void clickDIMOnContinuePlayList() {
        try {
            log.info("연속재생 리스트 노출 시 딤 부분 클릭");
            // ! 레이아웃이 window 위로 올라오면 driver가 dimension을 못 구하는 이상한 현상이 자꾸 발생해서 좌표를 그냥 찍음
//            TouchAction<?> touchAction = new TouchAction<>(AndroidManager.getDriver());
//            touchAction.press(PointOption.point(1866,50)).perform();
                Utils.touchCenterInViewer(AndroidManager.getDriver());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 연속재생 리스트의 2번째 독서 클릭
     */
    @When("연속재생 리스트의 {int}번째 독서 클릭")
    public void clickBookOnContinuePlayList(int index) {
        try {
            log.info("연속재생 리스트의 {}번째 독서 클릭", index);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mepubviewer2:id/layoutPlayList", index-1).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 연속재생 로딩 화면 확인
     */
    @When("연속재생 및 오디오북 로딩 화면 확인")
    public void checkLoadingScreenOnContinuePlay() {
        try {
            log.info("연속재생 로딩 화면 확인");
            try {
//                WebElement element = AndroidManager.getWait(2).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("android.widget.ProgressBar")));
//                if (element.isDisplayed()) assertTrue(true);

            } catch (Exception e2) {
                fail("로딩 이미지 및 로딩 문구가 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 북마크 스피너 버튼 클릭
     */
    @When("북마크 스피너 버튼 클릭")
    public void clickBookMarkSpinner() {
        try {
            log.info("북마크 스피너 버튼 클릭");
            AndroidManager.getElementById(Constant.favoriteSpinner_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 북마크 스피너의 즐겨찾기 버튼 클릭
     */
    @When("북마크 스피너의 즐겨찾기 버튼 클릭")
    public void clickFavoriteBookMarkSpinner() {
        try {
            log.info("북마크 스피너의 즐겨찾기 버튼 클릭");
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/spinner_layout", 1).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 화면으로 돌아감 확인
     */
    @When("라이브러리 화면으로 돌아감 확인")
    public void checkGoBackLibraryScreen() {
        try {
            log.info("라이브러리 화면으로 돌아감 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.continuePlayLayout_id);
                if (element.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("라이브러리 화면으로 돌아오지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 기녹음이 있는 경우 확인 버튼 클릭
     */
    @When("기녹음이 있는 경우 확인 버튼 클릭")
    public void clickOKIfRecordIsAlreadyExists() {
        try {
            log.info("기녹음이 있는 경우 확인 버튼 클릭");
            try {
                WebElement element = AndroidManager.getElementByIdUntilDuration(Constant.안내팝업확인_id, 1);
                if (element.isDisplayed()) element.click();
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음모드 화면 확인
     */
    @When("녹음모드 화면 확인")
    public void checkRecordingScreen() {
        try {
            log.info("녹음모드 화면 확인");
            try {
//                WebElement helpText = AndroidManager.getElementById(Constant.ivHelpText_id);
                WebElement startAndStopBtn = AndroidManager.getElementById(Constant.recordStartAndStopBtn_id);
                WebElement closeBtn = AndroidManager.getElementById(Constant.recordCloseBtn_id);
                if (startAndStopBtn.isDisplayed() && closeBtn.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                try {
                    WebElement recordedPlayBtn = AndroidManager.getElementById(Constant.playPauseRecorded_id);
                    if (recordedPlayBtn.isDisplayed()) assertTrue(true);
                } catch (Exception e2) {
                    fail("녹음모드 화면이 아닙니다.");
                }
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음모드 아닌 화면 확인
     */
    @When("녹음모드 아닌 화면 확인")
    public void checkNotRecordScreen() {
        try {
            log.info("녹음모드 아닌 화면 확인");
            try {
                WebElement startAndStopBtn = AndroidManager.getElementById(Constant.recordStartAndStopBtn_id);
                if (startAndStopBtn.isDisplayed()) fail("녹음모드 입니다.");
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 진행 중 확인
     */
    @When("녹음 진행 중 확인")
    public void checkCurrentRecordingNow() {
        try {
            log.info("녹음 진행 중 확인");
            AndroidManager.getElementById(Constant.recordCloseBtn_id).click();
            this.checkToastPopup("녹음 중에는 종료 할 수 없습니다");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭
     */
    @When("해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭")
    public void checkRecordedAlreadyExists() {
        try {
            log.info("해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭");
            try {
                WebElement element = AndroidManager.getElementByIdUntilDuration(Constant.안내팝업확인_id, 2);
                if (element.isDisplayed()) element.click();
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 완료한 페이지 화면 확인
     */
    @When("녹음 완료한 페이지 화면 확인")
    public void checkRecordDonePage() {
        try {
            log.info("녹음 완료한 페이지 화면 확인");
            try {
                WebElement recordedPlayBtn = AndroidManager.getElementById(Constant.playPauseRecorded_id);
                WebElement startAndStopBtn = AndroidManager.getElementById(Constant.recordStartAndStopBtn_id);
                WebElement closeBtn = AndroidManager.getElementById(Constant.recordCloseBtn_id);
                if (recordedPlayBtn.isDisplayed() && startAndStopBtn.isDisplayed() && closeBtn.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("녹음완료 페이지 화면이 아닙니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 재생 버튼 클릭
     */
    @When("녹음 재생 버튼 클릭")
    public void clickPlayRecorded() {
        try {
            log.info("녹음 재생 버튼 클릭");
            AndroidManager.getElementById(Constant.playPauseRecorded_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 재생중 확인
     */
    @When("녹음 재생중 확인")
    public void checkRecordPlaying() {
        try {
            log.info("녹음 재생중 확인");
            AndroidManager.getElementById(Constant.recordCloseBtn_id).click();
            this.checkToastPopup("재생 중에는 종료 할 수 없습니다");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 화면에서 X 버튼 클릭
     */
    @When("녹음 화면에서 X 버튼 클릭")
    public void clickXBtnOnRecordScreen() {
        try {
            log.info("녹음 화면에서 X 버튼 클릭");
            AndroidManager.getElementById(Constant.recordCloseBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 저장 화면 노출 확인
     */
    @When("녹음 저장 화면 노출 확인")
    public void checkSaveRecordScreen() {
        try {
            log.info("녹음 저장 화면 노출 확인");
            try {
                WebElement saveRecordLayout = AndroidManager.getElementById(Constant.saveRecordScreenLayout_id);
                WebElement guideTxt = AndroidManager.getElementById(Constant.guideText_id);
                WebElement bgmLayout = AndroidManager.getElementById(Constant.bgmLayout_id);
                if (saveRecordLayout.isDisplayed() && guideTxt.isDisplayed() && bgmLayout.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("녹음 저장 화면이 아닙니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 첫번째 브금 재생 버튼 클릭
     */
    @When("오디오북 첫번째 브금 재생 버튼 클릭")
    public void clickPlayBtnOnAudioBookBGM() {
        try {
            log.info("오디오북 첫번째 브금 재생 버튼 클릭");
            AndroidManager.getElementByXpath(Constant.firstAudioBgm_xPath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 브금 재생 확인
     */
    @When("오디오북 브금 재생 확인")
    public void checkAudioBGMPlaying() {
        try {
            log.info("오디오북 브금 재생 확인");
            boolean isPlaying = Utils.isAudioBookBGMRunning();
            if (!isPlaying) fail("오디오북 배경음이 재생중이지 않습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 오디오북 만들기 알림 팝업 확인
     */
    @When("오디오북 만들기 알림 팝업 확인")
    public void checkAudioBookCreatePopup() {
        try {
            log.info("오디오북 만들기 알림 팝업 확인");
            WebElement element = AndroidManager.getElementById(Constant.안내팝업메시지_id);
            if (element.isDisplayed() && element.getText().contains("내 목소리를 자랑해보세요")) {
                return;
            }
            fail("오디오북 만들기 알림 팝업이 노출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 종료 화면 노출 확인
     */
    @When("녹음 종료 화면 노출 확인")
    public void checkRecordExitScreen() {
        try {
            log.info("녹음 종료 화면 노출 확인");
            try {
                WebElement element = AndroidManager.getElementById(Constant.exitRecordScreen_id);
                WebElement element2 = AndroidManager.getElementById(Constant.listenRecord_id);
                if (element.isDisplayed() && element2.isDisplayed()) assertTrue(true);
            } catch (Exception e) {
                fail("녹음 종료 화면이 아닙니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 내 녹음 들어보기 버튼 클릭
     */
    @When("내 녹음 들어보기 버튼 클릭")
    public void clickListenMyRecord() {
        try {
            log.info("내 녹음 들어보기 버튼 클릭");
            AndroidManager.getElementById(Constant.listenRecord_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 녹음 나가기 버튼 클릭
     */
    @When("녹음 나가기 버튼 클릭")
    public void clickExitRecordBtn() {
        try {
            log.info("녹음 나가기 버튼 클릭");
            AndroidManager.getElementById(Constant.exitRecordScreen_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 코치마크 노출 시 닫기
     */
    @When("코치마크 노출 시 닫기")
    public boolean checkFirstHelpLayoutScreen() {
        try {
            log.info("코치마크 노출 시 닫기");
            try {
                WebElement helpLayout = AndroidManager.getElementByIdUntilDuration(Constant.helpViewLayout_id, 5);
                if (helpLayout.isDisplayed()) {
                    try {
                        WebElement cartoonHelpXBtn = AndroidManager.getElementByIdUntilDuration(Constant.cartoonHelpLayoutCloseBtn_id, 5);
                        if (cartoonHelpXBtn.isDisplayed()) {
                            cartoonHelpXBtn.click();
                            return true;
                        }
                    } catch (Exception e) {
                        try {
                            WebElement audioBookHelpXBtn = AndroidManager.getElementById(Constant.helpViewXBtn_id);
                            if (audioBookHelpXBtn.isDisplayed()) {
                                audioBookHelpXBtn.click();
                                return true;
                            }
                        } catch (Exception e2) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                return true;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
        return false;
    }

    /**
     * 영어사전 도움말 페이지 노출 시 닫기
     */
    @When("영어사전 도움말 페이지 노출 시 닫기")
    public void checkEnglishDictionaryAndClose() {
        try {
            log.info("영어사전 도움말 페이지 노출 시 닫기");
            try {
                WebElement helpLayout = AndroidManager.getElementByIdUntilDuration(Constant.helpViewLayout_id, 5);
                if (helpLayout.isDisplayed()) {
                    Utils.swipeRightToLeft();
                    TimeUnit.SECONDS.sleep(3);
                    Utils.swipeRightToLeft();
                    TimeUnit.SECONDS.sleep(3);
                    AndroidManager.getElementById(Constant.enHelpLayoutXBtn_id).click();
                }
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
