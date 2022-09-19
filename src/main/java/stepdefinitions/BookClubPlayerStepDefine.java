package stepdefinitions;

import com.beust.ah.A;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;
import utils.Utils;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BookClubPlayerStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 동영상 재생 확인
     * 재생중 -> false
     * 멈충 -> true
     */
    @When("동영상 재생 확인")
    public void 동영상재생확인() {
        try {
            try{
                log.info("동영상 재생 확인");
                boolean vdoPlayYN = Utils.isVideoPlayerRunning();
                if (vdoPlayYN) {
                    return;
                }
            }catch (Exception e) {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tv_msg");
                if (element.isDisplayed() && element.getText().contains("오늘은 이제 그만~ 내일 또 만나요!")) {
                    log.info("재생 횟수 0으로 제어 설정 초기화 실행");
                    AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
                    제어설정시초기화();
                    동영상재실행("첫생활그림책 늠름 테마송 애니메이션");
                }
                log.info("동영상이 재생중이지 않습니다.");
            }
        } catch (Exception e) {
            fail("Element you found not shown");
        }
    }

    /**
     * 나가기 버튼 클릭 액션
     */
    @When("나가기 버튼 클릭")
    public void 나가기버튼클릭() {
        try {
            log.info("나가기 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnBack").click();
        } catch (Exception e) {
            fail("Element you found not shown");
        }
    }


    /**
     * 입력받은 String과 같은 텍스트 존재 시 패스
     */
    @Then("{string} 팝업 표출")
    public void 팝업표출(String text) {
        try {
            log.info("{} 안내 문구 일반 팝업 확인", text);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tv_msg");
            log.info("{} 안내 문구 일반 팝업 확인", element.getText());
            if (element.getText().contains(text)) return;
            else {
                fail(text + " 라는 문구가 담긴 안내 팝업이 노출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 동영상 일시정지 여부 확인
     */
    @Then("동영상 일시 정지")
    public void 동영상일시정지() {
        try {
            log.info("동영상일시정지");
            boolean vdoPlayYN = Utils.isVideoPlayerRunning();
            if (!vdoPlayYN) {
                return;
            }
            fail("동영상이 재생중입니다.");
        } catch (Exception e) {
            fail("Element you found not shown");
        }
    }

    @When("취소 버튼 클릭")
    public void 취소버튼클릭() {
        try {
            log.info("취소버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_cancel").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    /*public void 확인버튼클릭() {
        try {
            log.info("확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }*/

    @Then("{string} 화면으로 이동")
    public void 화면으로이동(String text) {
        try {
            log.info("{} 화면으로 이동", text);
            WebElement element = null;
            if (text.equals("검색")) element = AndroidManager.getElementById("com.wjthinkbig.dictionary:id/btnTest");
            if (text.equals("사 회")) element = AndroidManager.getElementById("com.wjthinkbig.integratedquration.main:id/txt_subject_name");
            if (text.equals("수학")) element = AndroidManager.getElementById("com.wjthinkbig.school1.main:id/top_txt_subject");
            if (element.isDisplayed() && element.getText().contains(text)) return;
            fail(text + " 화면으로 돌아가지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("음악_동영상 탭 클릭")
    public void 음악_동영상탭클릭() {
        try {
            log.info("음악_동영상탭클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnVideoAudioChange").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("시계 버튼 클릭")
    public void 시계버튼클릭() {
        try {
            log.info("시계 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/ivRemain").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    @Then("{string} 창 표출")
    public void 창표출(String text) {
        try {
            log.info("{} 창 표출", text);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/title");
            if (element.isDisplayed() && element.getText().contains(text)) return;
            fail(text + " 창이 나타나지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("잠금 버튼 클릭")
    public void 잠금버튼클릭() {
        try {
            log.info("시계 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnLock").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("잠금해제 버튼 클릭")
    public void 잠금해제버튼클릭() {
        try {
            log.info("잠금해제버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnLockForFull").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("전체화면으로 변경")
    public void 전체화면으로변경() {
        try {
            log.info("전체화면으로 변경");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/exo_overlay");
            Point location = element.getLocation();
            String result = location.toString();
            if ("(0, 0)".equals(result)) return;
            fail("전체화면으로 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("일반화면으로 변경")
    public void 일반화면으로변경() {
        try {
            log.info("일반화면으로변경");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/exo_subtitles");
            Point location = element.getLocation();
            String result = location.toString();
            if (!"(0, 0)".equals(result)) return;
            fail("일반화면으로 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("화면 1번 터치")
    public void showUpperBar() {
        try {
            log.info("화면 1번 터치");
            Utils.touchCenterInViewer(AndroidManager.getDriver());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{string} 이름 확인")
    public void 이름확인(String text) {
        try {
            log.info("{} 동영상 이름 확인", text);
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
            if (element.isDisplayed() && element.getText().contains(text)) return;
            fail(text + "동영상 이름이 다릅니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체화면 버튼 클릭")
    public void 전체화면버튼클릭() {
        try {
            log.info("전체화면버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_fullscreen").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("이전 버튼 클릭")
    public void 이전버튼클릭() {
        try {
            log.info("이전버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_prev").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("배속설정 버튼 클릭")
    public void 배속설정버튼클릭() {
        try {
            log.info("배속설정버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_speed_rate").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("배속설정 {string} 로변경")
    public void 배속설정변경(String text) {
        String result = Utils.currentVideoPlayerSpeed().trim();
        try {
            log.info("{} 로 배속설정 변경", text);
            if (text.equals("1.2")) {
                if (result.equals("1.10")) {
                    return;
                }
            } else if (text.equals("1.5")) {
                if (result.equals("1.20")) {
                    return;
                }
            } else if (text.equals("1.8")) {
                if (result.equals("1.40")) {
                    return;
                }
            } else if (text.equals("2")) {
                if (result.equals("1.60")) {
                    return;
                }
            } else if (text.equals("0.8")) {
                if (result.equals("0.80")) {
                    return;
                }
            }
            fail(text + " 로 배속설정이 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("재생목록 편집 버튼 클릭")
    public void 재생목록편집버튼클릭() {
        try {
            log.info("재생목록편집버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnPlayList").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체 삭제 버튼 클릭")
    public void 전체삭제버튼클릭() {
        try {
            log.info("전체삭제버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnDeleteAll").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{string} 팝업 확인")
    public void 팝업확인(String toastText) {
        try {
            log.info("{} 문구의 팝업을 확인합니다.", toastText);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tv_msg");
            String result = element.getText();
            assertTrue("예상한 팝업이 노출되지 않았습니다. 실제결과: " + result + " expected contains text: " + toastText, result.contains(toastText));

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("팝업 예 버튼 클릭")
    @When("확인 버튼 클릭")
    @When("예 선택")
    @When("다시보기 버튼 클릭")
    public void 예버튼클릭() {
        try {
            log.info("팝업 예 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("{string} 동영상 이름 확인")
    public void 동영상이름확인(String vdoName) {
        try {
            log.info("{} 동영상 이름 확인", vdoName);
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
            String result = element.getText();
            assertTrue("예상한 동영상 이름이 노출되지 않았습니다. 실제결과: " + result + " expected contains text: " + vdoName, result.contains(vdoName));

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("다음 버튼 클릭")
    public void 다음버튼클릭() {
        try {
            log.info("다음버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_next").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("일시정지_재생 버튼 클릭")
    public void 일시정지_재생버튼클릭() {
        try {
            log.info("일시정지_재생버튼클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_play");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("비밀번호 입력 창 표출")
    public void 비밀번호입력창표출() {
        try {
            log.info("비밀번호 입력 문구의 팝업을 확인합니다.");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/title");
            String result = element.getText();
            if (result.equals("비밀번호 입력")) return;
            fail("비밀번호 입력 창이 나타나지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("비밀번호 입력 취소 버튼 클릭")
    public void 비밀번호입력취소버튼클릭() {
        try {
            log.info("일시정지_재생버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/popup_btn_cancel").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("비밀번호 입력")
    public void 비밀번호입력() {
        try {
            log.info("비밀번호 1111입력");
            WebElement inputText1 = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/password01");
            WebElement inputText2 = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/password02");
            WebElement inputText3 = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/password03");
            WebElement inputText4 = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/password04");
            inputText1.sendKeys("1");
            inputText2.sendKeys("1");
            inputText3.sendKeys("1");
            inputText4.sendKeys("1");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("비밀번호 입력 확인 버튼 클릭")
    public void 비밀번호입력확인버튼클릭() {
        try {
            log.info("비밀번호입력확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/popup_btn_comfirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("동영상 시청 제한 설정 팝업 표시")
    public void 동영상시청제한설정팝업표시() {
        try {
            log.info("동영상 시청 제한 설정 팝업 표시");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/tv_custom_popup_subtitle");
            String result = element.getText();
            if (result.equals("동영상 시청 제한 설정")) return;
            fail("동영상 시청 제한 설정 팝업이 나타나지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체 동영상 기준 클릭")
    public void 전체동영상기준클릭() {
        try {
            log.info("전체동영상기준클릭");
            AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"증가\"])[1]").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("동영상 시청 제한 확인 버튼 클릭")
    public void 동영상시청제한확인버튼클릭() {
        try {
            log.info("동영상시청제한확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOK").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{int}초 대기 후 전체 동영상 남은 횟수 감소 확인")
    public void 초대기후남은횟수감소확인(int seconds) {
        try {
            //전체 동영상 기준 선택 시 횟수 가져오기
            log.info("count 확인하기");
            WebElement count = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
            //int로 형변환
            int countNum = Integer.parseInt(count.getText());
            log.info("동영상시청제한확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOK").click();
            log.info("{}초 대기", seconds - 15);
            TimeUnit.SECONDS.sleep(seconds - 15);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
            String result = element.getText();
            int index = result.length();
            result = result.substring(0, index - 1);
            int resultNum = Integer.parseInt(result);
            log.info("남은 횟수 {}회", resultNum);
            if (resultNum == countNum) {
                log.info("{}초 대기", seconds);
                TimeUnit.SECONDS.sleep(seconds);
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
                result = element.getText();
                index = result.length();
                result = result.substring(0, index - 1);
                resultNum = Integer.parseInt(result);
                log.info("남은 횟수 {}회", resultNum);
                if (resultNum == countNum - 1) return;
            }
            fail("남은횟수 감소 확인이 되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("검색 {string} 재실행")
    public void 동영상재실행(String str) {
        try {
            WebElement element;
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAppName");
                if (element.isDisplayed()) {
                    String player = element.getText();
                    if (player.equals("통합 플레이어")) return;
                }
            } catch (Exception e) {
                log.info("검색 실행 후 {}번 째 재생", 0);
                HomeScreenStepDefine hssd = new HomeScreenStepDefine();

                log.info("Home으로 이동");
                AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));


                hssd.clickLibraryBtn();

                hssd.clickSearchBtn();
                SearchScreenStepDefine sssd = new SearchScreenStepDefine();

                sssd.enterSearchTextOnSearchBar(str);

                sssd.clickStartSearchBtn();

                sssd.clickResultSearchItem(0);
                log.info("{}초 대기", 5);
                TimeUnit.SECONDS.sleep(5);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("제어 설정 시 초기화")
    public void 제어설정시초기화() {
        try {
            log.info("제어설정시초기화");
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
                String result = element.getText();
                if (result.equals("OFF")) {
                    return;
                } else {
                    log.info("Home으로 이동");
                    AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                    TimeUnit.SECONDS.sleep(15);
                    //설정 버튼 클릭
                    log.info("설정 버튼 클릭");
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnSetting").click();
                    //디바이스 매니저 클릭
                    log.info("디바이스 매니저 클릭");
                    AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
                    //온오프 버튼 클릭
                    log.info("온오프 버튼 클릭");
                    AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOnOff").click();
                    비밀번호입력();
                    비밀번호입력확인버튼클릭();
                    TimeUnit.SECONDS.sleep(3);
                    log.info("Home으로 이동");
                    AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                    TimeUnit.SECONDS.sleep(15);
                }
            }catch (Exception e){
                log.info("Home으로 이동");
                AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                TimeUnit.SECONDS.sleep(15);
                //설정 버튼 클릭
                log.info("설정 버튼 클릭");
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnSetting").click();
                //디바이스 매니저 클릭
                log.info("디바이스 매니저 클릭");
                AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
                //온오프 버튼 클릭
                log.info("온오프 버튼 클릭");
                AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOnOff").click();
                비밀번호입력();
                비밀번호입력확인버튼클릭();
                TimeUnit.SECONDS.sleep(3);
                log.info("Home으로 이동");
                AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                TimeUnit.SECONDS.sleep(15);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    @When("동일 동영상 기준 클릭")
    public void 동일동영상기준클릭() {
        try {
            log.info("동일동영상기준클릭");
            WebElement element = null;
            WebElement count = null;
            int countInt = 0;
            while(true){
                element = AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"감소\"])[2]");
                element.click();
                count = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
                countInt = Integer.parseInt(count.getText());
                if (countInt == 1) break;
            }

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{int}초 대기 후 동일 동영상 남은 횟수 감소 확인")
    public void 초대기후동일동영상남은횟수감소확인(int seconds) {
        try {
            //전체 동영상 기준 선택 시 횟수 가져오기
            log.info("count 확인하기");
            WebElement count = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.EditText");
            //int로 형변환
            int countNum = Integer.parseInt(count.getText());
            if (countNum == 1) {
                log.info("1회 재생 시 동일동영상 한 번 더 클릭");
                AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"증가\"])[2]").click();
            }
            countNum = Integer.parseInt(count.getText());
            log.info("동영상시청제한확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOK").click();
            log.info("{}초 대기", seconds - 15);
            TimeUnit.SECONDS.sleep(seconds - 15);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
            String result = element.getText();
            int index = result.length();
            result = result.substring(0, index - 1);
            int resultNum = Integer.parseInt(result);
            log.info("남은 횟수 {}회", resultNum);
            if (resultNum == countNum) {
                log.info("{}초 대기", seconds);
                TimeUnit.SECONDS.sleep(seconds);
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
                result = element.getText();
                index = result.length();
                result = result.substring(0, index - 1);
                resultNum = Integer.parseInt(result);
                log.info("남은 횟수 {}회", resultNum);
                if (resultNum == countNum - 1) return;
            }
            fail("남은횟수 감소 확인이 되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체 시청 시간 클릭")
    public void 전체시청시간클릭() {
        try {
            log.info("전체시청시간클릭");
            AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"증가\"])[3]").click();
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText");
            int time = Integer.parseInt(element.getText());
            if (time == 0) {
                AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"증가\"])[3]").click();
            }
            log.info("{}초 대기", 2);
            TimeUnit.SECONDS.sleep(2);
            log.info("동영상시청제한확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOK").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{int}초 대기 후 전체 시청 시간 감소 확인")
    public void 초대기후전체시청시간감소확인(int seconds) {
        try {
            log.info("{}초 대기 후 전체 시청 시간 감소 확인", seconds);
            log.info("{}초 대기", seconds - 10);
            TimeUnit.SECONDS.sleep(seconds - 10);
            WebElement time = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainCountLabel");
            String timeStr = time.getText();
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
            String str = element.getText();
            log.info("{}으로 텍스트 변경 확인", timeStr);
            log.info("{}초 대기", seconds - 10);
            TimeUnit.SECONDS.sleep(seconds - 10);
            if (timeStr.equals("남은 시간")) {
                log.info("{} 시간 표시 확인", str);
                log.info("{}초 대기", seconds - 10);
                TimeUnit.SECONDS.sleep(seconds - 10);
                if (!str.equals("OFF")) return;
            } else {
                fail("남은 시간 감소 진행이 확인되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("재생목록 전체 삭제 동작")
    public void 재생목록전체삭제동작() {
        try {
            log.info("재생목록 전체 삭제 동작");
            재생목록편집버튼클릭();
            전체삭제버튼클릭();
            팝업확인("전체 재생목록이 삭제됩니다.");
            log.info("{}초 대기", 4);
            TimeUnit.SECONDS.sleep(4);
            예버튼클릭();
        } catch (NoSuchElementException e) {
            fail("재생목록 전체 삭제 동작이 실행되지 않았습니다.");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{string} 재생목록에 추가 동작")
    public void 재생목록에추가동작(String forPlayListStr) {
        try {
            log.info("{} 재생목록에 추가 동작", forPlayListStr);
            String[] playList = forPlayListStr.split(",");
            HomeScreenStepDefine hssd = new HomeScreenStepDefine();
            SearchScreenStepDefine sssd = new SearchScreenStepDefine();
            for (int i = 0; i < playList.length; i++) {
                log.info("Home으로 이동");
                AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                TimeUnit.SECONDS.sleep(10);
                //검색 버튼 클릭
                hssd.clickSearchBtn();
                //검색어 입력
                sssd.enterSearchTextOnSearchBar(playList[i]);
                //검색 확인 버튼 클릭
                sssd.clickStartSearchBtn();
                //검색 리스트에 0번째 컨텐츠 클릭
                sssd.clickResultSearchItem(0);
                log.info("{}초 대기", 4);
                TimeUnit.SECONDS.sleep(4);
            }
        } catch (NoSuchElementException e) {
            fail("재생목록에 동영상이 추가되지 않았습니다.");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("재생목록에서 {int}번째 항목 선택")
    public void 재생목록에서번째항목선택(int index) {
        try {
            log.info("재생목록에서 {}번째 항목 선택", index);
            //index 항목의 동영상 이름 가져오기
            String videoName = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/tvTitle", index).getText();
            log.info("재생목록에서 {}번째 항목 {} 선택", index, videoName);
            //index 번째 동영상 클릭
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/imgContent", index);
            element.click();
            log.info("{}초 대기", 4);
            TimeUnit.SECONDS.sleep(4);
            //동영상 이름 매칭 시 pass
            String playVideoName = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView").getText();
            log.info("{} 동영상 이름과 {} 동영상 이름 매칭 시 pass", videoName, playVideoName);
            if (playVideoName.equals(videoName)) return;
            else {
                fail("선택한 동영상이 재생되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("생각 라이브러리 버튼 클릭")
    public void 생각라이브러리버튼클릭() {
        try {
            log.info("생각라이브러리버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnThinkLibrary").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("아니오 선택")
    public void 아니오선택() {
        try {
            log.info("아니오 선택");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_cancel").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    /*public void 예선택() {
        try {
            log.info("예 선택");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }*/


    @Then("홈 화면으로 이동 확인")
    public void 홈화면으로이동확인() {
        try {
            log.info("홈화면으로이동확인");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnBookClub");
            if (element.isDisplayed()) return;
            fail("화면이 제대로 이동되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("전체 삭제 버튼 표출")
    public void 전체삭제버튼표출() {
        try {
            log.info("전체삭제버튼표출");
            //WebElement libraryElement = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnThinkLibrary");
            WebElement deleteElement = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnDeleteAll");
            log.info("전체삭제 버튼 표출 확인");
            if (deleteElement.isDisplayed()) return;
            fail("전체삭제 버튼이 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("재생목록 이미지 휴지통으로 변경")
    public void 재생목록이미지휴지통으로변경() {
        try {
            log.info("재생목록이미지휴지통으로변경");
            WebElement trashButton = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView[2]");
            if (trashButton.isDisplayed()) return;
            fail("이미지가 휴지통으로 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("취소 버튼 표출")
    public void 취소버튼표출() {
        try {
            log.info("취소버튼표출");
            //WebElement listElement = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnPlayList");
            WebElement cancelButton = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnRemoveCancel");
            if (cancelButton.isDisplayed()) return;
            fail("취소버튼으로 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("재생목록에서 {int}번째 항목 삭제")
    public void 재생목록에서번째항목삭제(int index) {
        try {
            log.info("재생목록에서 {}번째 항목 선택", index);
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/imgContent", index);
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("재생영역에 아무것도 없음 확인")
    public void 재생영역에아무것도없음확인() {
        try {
            log.info("재생영역에아무것도없음확인");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/rlNoPlayList");
            if (element.isDisplayed()) return;
            fail("재생목록에 플레이 리스트가 존재합니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("라이브러리 바로가기 버튼 클릭")
    public void 라이브러리바로가기버튼클릭() {
        try {
            log.info("라이브러리 바로가기 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnNoPlayList");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("사회 버튼 클릭")
    public void 사회버튼클릭() {
        try {
            log.info("사회 버튼 클릭");
            Utils.dragSourceToTarget(964, 1164, 964, 50);
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.ImageView[2]");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("좌측 상단 단계선택 버튼 클릭")
    public void 좌측상단단계선택버튼클릭() {
        try {
            log.info("좌측 상단 단계선택 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.integratedquration.main:id/txt_current_ho");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("F단계 클릭")
    public void f단계클릭() {
        try {
            log.info("F단계 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.TextView");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("1호 클릭")
    public void _1호클릭() {
        try {
            log.info("1호 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.ImageView");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("개념쏙쏙1 클릭")
    public void 개념쏙쏙1클릭() {
        try {
            log.info("개념쏙쏙1 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("학습 플레이어 메뉴 확인")
    public void 학습플레이어메뉴확인() {
        try {
            log.info("학습 플레이어 메뉴 확인");
            WebElement outButton = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_study_back_button");
            WebElement playButton = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_play_study");
            WebElement playBar = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_seekbar_study");
            if (outButton.isDisplayed() && playButton.isDisplayed() && playBar.isDisplayed()) return;
            fail("학습 플레이어 메뉴가 정상적으로 표출되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("학습 나가기 버튼 클릭")
    public void 학습나가기버튼클릭() {
        try {
            log.info("학습 나가기 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_study_back_button");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("학습 플레이어 재생_일시정지 버튼 클릭")
    public void 학습플레이어재생_일시정지버튼클릭() {
        try {
            log.info("학습 플레이어 재생_일시정지 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_play_study");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("학습잠금 버튼 클릭")
    public void 학습잠금버튼클릭() {
        try {
            log.info("학습잠금 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_study_lock_button");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("학습배속설정 버튼 클릭")
    public void 학습배속설정버튼클릭() {
        try {
            log.info("학습배속설정 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_speed_rate_study");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("Reading Master 버튼 클릭")
    public void readingMaster버튼클릭() {
        try {
            log.info("Reading Master 버튼 클릭");
            Utils.dragSourceToTarget(964, 1164, 964, 50);
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.RelativeLayout/android.widget.ImageView[2]");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("리딩마스터 영상 버튼 클릭")
    public void 영상버튼클릭() {
        try {
            log.info("영상 버튼 클릭");
            Utils.touchSpecificCoordinates(1732, 411);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("자막버튼 표출 확인")
    public void 자막버튼표출확인() {
        try {
            log.info("자막버튼 표출 확인");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_tracks_study");
            if (element.isDisplayed()) return;
            fail("자막버튼이 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("한글깨치기 버튼 클릭")
    public void 한글깨치기버튼클릭() {
        try {
            log.info("한글깨치기 버튼 클릭");
            Utils.dragSourceToTarget(964, 1164, 964, 50);
            Utils.dragSourceToTarget(964, 1164, 964, 400);
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.ImageView[2]");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("한글깨치기 단계선택 버튼 클릭")
    public void 한글깨치기단계선택버튼클릭() {
        try {
            log.info("한글깨치기 단계선택 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.babyintg:id/stage_img_toggle");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("한글깨치기 본학습단계 클릭")
    public void 한글꺠치기본학습단계클릭() {
        try {
            log.info("한글 꺠치기 본학습단계 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("한글깨치기 {string} 클릭")
    public void 한글깨치기클릭(String str) {
        try {
            log.info("한글깨치기 {} 클릭", str);
            WebElement element = AndroidManager.getElementByTextAfterSwipe(str);
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("어, 잠깐 클릭")
    public void 어잠깐클릭() {
        try {
            log.info("어, 잠깐 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.support.v4.view.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView[2]");
            element.click();
            log.info("{}초 대기", 2);
            TimeUnit.SECONDS.sleep(2);
            if (element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("짝꿍책 클릭")
    public void 짝꿍책클릭() {
        try {
            log.info("짝꿍책 클릭");
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/imgContent", 0);
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("일시정지 후 핵심용어 버튼 표출 확인")
    public void 핵심용어버튼표출확인() {
        try {
            WebElement playButton = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_play_study");
            playButton.click();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            Utils.touchSpecificCoordinates(1855, 876);
            if (playButton.isDisplayed()) return;
            fail("핵심용어 버튼이 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("{string} 알람 표출시 취소")
    public void 알람표출시취소(String str) {
        try {
            try {
                WebElement popup = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/text_confirm_title");
                if(popup.isDisplayed()){
                    popup =AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/text_confirm_sub");
                    if(popup.getText().equals(str)){
                        popup = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/btn_cancel");
                        popup.click();
                    }
                }
            }catch(Exception e){
                log.info("화면 1번 터치");
                Utils.touchCenterInViewer(AndroidManager.getDriver());
                return;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    @When("전체메뉴 뮤직버튼 클릭")
    public void 전체메뉴뮤직버튼클릭() {
        Utils.dragSourceToTarget(945, 1133, 945, 370);
        Utils.dragSourceToTarget(945, 1133, 945, 370);
        Utils.dragSourceToTarget(945, 1133, 945, 370);
        Utils.dragSourceToTarget(945, 1133, 945, 370);
        try {
            log.info("전체메뉴 뮤직버튼 클릭");
            WebElement musicButton = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/sub_img", 15);
            musicButton.click();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            try {
                WebElement title = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/titleArea");
                if(title.isDisplayed()&&title.getText().equals("뮤직")){
                    return;
                }else {
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").click();
                    log.info("{}초 대기", 3);
                    TimeUnit.SECONDS.sleep(3);
                    전체메뉴뮤직버튼클릭();
                }
            }catch (Exception e){
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").click();
                log.info("{}초 대기", 3);
                TimeUnit.SECONDS.sleep(3);
                전체메뉴뮤직버튼클릭();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체메뉴 버튼 클릭")
    public void 전체메뉴버튼클릭() {
        try {
            log.info("전체메뉴 버튼 클릭");
            WebElement allMenuButton = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/imgMenuAll");
            allMenuButton.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("컨텐츠 리스트중 {string} 클릭")
    public void 컨텐츠리스트중클릭(String str) {
        try {
            log.info("컨텐츠 리스트중 {} 클릭", str);
            WebElement earOperaButton = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/set_img", 0);
            if(earOperaButton.isDisplayed()) {
                earOperaButton.click();
                earOperaButton = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/set_title_text");
                if(earOperaButton.getText().equals(str)){

                    WebElement allListenButton = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/all_download_btn");
                    switch (allListenButton.getText()) {
                        case "전체 듣기":
                            allListenButton.click();
                            break;
                        case "전체 다운로드":
                            allListenButton.click();
                            try {
                                log.info("대기 후 다운로드 완료 시 동작 (최대 120초)");
                                allListenButton = AndroidManager.getElementByIdUntilDuration("com.wjthinkbig.mlauncher2:id/all_download_btn", 120);
                                if(allListenButton.isDisplayed() && allListenButton.getText().equals("전체 듣기")){
                                    allListenButton.click();
                                }
                            }catch (Exception e){
                                log.info("대기 후 다운로드 완료 시 동작 (최대 120초)");
                                allListenButton = AndroidManager.getElementByIdUntilDuration("com.wjthinkbig.mlauncher2:id/all_download_btn", 120);
                                if(allListenButton.isDisplayed() && allListenButton.getText().equals("전체 듣기")){
                                    allListenButton.click();
                                }else{fail("음원 다운로드가 완료되지 않았습니다.");}
                            }
                            break;
                    }

                }else{fail("선택한 음악 리스트가 다릅니다.");}
            }
            else{fail("선택한 음악이 클릭 되지 않았습니다.");}
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("플레이리스트 {int}번째와 이름 확인")
    public void 플레이리스트번째와이름확인(int index) {
        try {
            log.info("플레이리스트 {}번째와 이름 확인", index);
            WebElement musicNameElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]");
            String musicName = musicNameElement.getText();
            WebElement playListElement = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/tvTitle", index);
            String playListMusicName = playListElement.getText();
            log.info("플레이리스트 {}번째와 이름 확인 동영상 이름 /{}/, 플레이리스트 이름 /{}/", index, musicName, playListMusicName);
            if(musicName.equals(playListMusicName)) return;
            fail("음악 이름이 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("동영상 플레이리스트 {int}번째와 이름 확인")
    public void 동영상플레이리스트번째와이름확인(int index) {
        try {
            log.info("플레이리스트 {}번째와 이름 확인", index);
            WebElement musicNameElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
            String musicName = musicNameElement.getText();
            WebElement playListElement = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/tvTitle", index);
            String playListMusicName = playListElement.getText();

            if(musicName.equals(playListMusicName)) return;
            fail("음악 이름이 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{string} 텍스트 확인")
    public void 텍스트확인(String str){
        try {
            log.info("{} 확인", str);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvlyricNo");
            String elementText = element.getText();
            if (elementText.equals(str)) return;
            fail("등록된 가사가 있습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{int}회 스와이프 액션")
    public void 스와이프액션(int index) {
        try {
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/set_title_text");
            if (element.isDisplayed()&&element.getText().equals("귀로 듣는 오페라")){
                log.info("Swipe 2회 실행");
                for(int i = 0; i <2; i++){
                    Utils.dragSourceToTarget(211, 1033, 211, 211);
                }
                return;
            }else {
                log.info("Swipe 12회 실행");
                for(int i = 0; i <index; i++){
                    Utils.dragSourceToTarget(211, 1033, 211, 211);
                }
            }
        }catch (Exception e){
            log.info("Swipe 12회 실행");
            for(int i = 0; i <index; i++){
                Utils.dragSourceToTarget(211, 1033, 211, 211);
            }
        }

    }

    @When("세트 목록보기에 {int}페이지 {int}번 째 컨텐츠 클릭")
    public void 세트목록보기에페이지번째컨텐츠클릭(int page, int index) {
        try {
            log.info("{}페이지 {}번 째 컨텐츠 클릭", page, index);
            try{
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/setlistBtn");
                element.click();
                element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/topTitle");
                if(element.isDisplayed() && element.getText().equals("뮤직")){
                    if (page==1){
                        AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").click();
                        element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/view_background", index);
                        element.click();
                    }else{
                        AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").click();
                        for(int i=1;i<page;i++){
                            element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rightArrow");
                            element.click();
                        }
                        element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/view_background", index);
                        element.click();
                    }
                }else {fail("컨텐츠를 정상적으로 선택하지 못했습니다.");}
            }catch (Exception e){
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/closeBtn").click();
                스와이프액션(12);
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/setlistBtn");
                element.click();
                element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/topTitle");
                if(element.isDisplayed() && element.getText().equals("뮤직")){
                    if (page==1){
                        AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").click();
                        element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/view_background", index);
                        element.click();
                    }else{
                        AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]").click();
                        for(int i=1;i<page;i++){
                            element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rightArrow");
                            element.click();
                        }
                        element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/view_background", index);
                        element.click();
                    }
                }else {fail("컨텐츠를 정상적으로 선택하지 못했습니다.");}
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{string} 가사 확인")
    public void 가사확인(String str) {
        try {
            log.info("{} 가사 확인", str);
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/tvlyric", 0);
            String lyric = element.getText();
            if(element.isDisplayed()&&lyric.equals(str)) return;
            fail("가사가 확인되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{int}페이지 {int}번째 {string} 재생목록에 재 추가")
    public void 재생목록에재추가(int page, int index, String str) {
        try {
            log.info("Home으로 이동");
            AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
            TimeUnit.SECONDS.sleep(10);
            HomeScreenStepDefine hssd = new HomeScreenStepDefine();
            SearchScreenStepDefine sssd = new SearchScreenStepDefine();
            hssd.clickLibraryBtn();
            전체메뉴버튼클릭();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            전체메뉴뮤직버튼클릭();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            스와이프액션(12);
            세트목록보기에페이지번째컨텐츠클릭(page, index);
            컨텐츠리스트중클릭(str);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("자동 꺼짐 설정 버튼 클릭")
    public void 자동꺼짐설정버튼클릭() {
        try {
            log.info("자동 꺼짐 설정 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/ivOff");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{string} 시간 설정 팝업 표출")
    public void 시간설정팝업표출(String str) {
        try {
            log.info("{} 팝업 표출", str);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tv_custom_popup_subtitle");
            if(element.getText().equals(str)) return;
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("일시정지_재생 좌표 클릭")
    public void 일시정지_재생좌표클릭() {
        try {
            log.info("일시정지_재생 좌표 클릭");
            Utils.touchSpecificCoordinates(684, 1110);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("시간 변경 동작 확인")
    public void 시간변경동작확인() {
        try {
            log.info("시간 변경 동작 확인");
            WebElement timeDownButton = AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"감소\"])[1]");
            timeDownButton.click();
            WebElement timeTextElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText");
            String timeText = timeTextElement.getText();
            int timeInt = Integer.parseInt(timeText);
            if (timeInt == 12) {
                timeDownButton = AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"감소\"])[2]");
                timeDownButton.click();
                timeTextElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText");
                timeText = timeTextElement.getText();
                timeInt = Integer.parseInt(timeText);
                if (timeInt == 4) return;
            }else {fail("시간 변경이 정상적으로 동작하지 않았습니다.");}
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("자동 꺼짐 설정 확인 버튼 클릭")
    public void 자동꺼짐설정확인버튼클릭() {
        try {
            log.info("자동 꺼짐 설정 확인 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnOK");
            if(element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("{int}초 대기 후 자동 꺼짐 시간 변경 확인")
    public void 초대기후자동꺼짐시간변경확인(int seconds) {
        try {
            log.info("{}초 대기 후 자동 꺼짐 시간 변경 확인", seconds);
            log.info("{}초 대기", seconds - 10);
            TimeUnit.SECONDS.sleep(seconds - 10);
            WebElement time = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAutoOff");
            String timeStr = time.getText();
            if(timeStr.equals("OFF")){
                fail("자동 꺼짐 시간 설정이 정상적으로 동작하지 않았습니다.");
            }else{return;}
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    @When("음악재생목록에서 {int}번째 항목 선택")
    public void 음악재생목록에서번째항목선택(int index) {
        try {
            log.info("재생목록에서 {}번째 항목 선택", index);
            //index 항목의 동영상 이름 가져오기
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/tvTitle", index);
            String videoName = element.getText();
            element.click();
            log.info("{}초 대기", 4);
            TimeUnit.SECONDS.sleep(4);
            //동영상 이름 매칭 시 pass
            String playVideoName = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText();
            log.info("{} 동영상 이름과 {} 동영상 이름 매칭 시 pass", videoName, playVideoName);
            if (playVideoName.equals(videoName)) return;
            else {
                fail("선택한 동영상이 재생되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    @And("음악 재생목록 이미지 휴지통으로 변경")
    public void 음악재생목록이미지휴지통으로변경() {
        try {
            log.info("재생목록이미지휴지통으로변경");
            WebElement trashButton = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/ivCheckBox", 0);
            if (trashButton.isDisplayed()) return;
            fail("이미지가 휴지통으로 변경되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    @When("재생목록에서 {int}번째 항목 휴지통 선택")
    public void 재생목록에서번째항목휴지통선택(int index) {
        try {
            log.info("재생목록에서 {}번째 항목 휴지통 선택", index);
            WebElement trashButton = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mvideo2:id/ivCheckBox", index);
            if (trashButton.isDisplayed()) trashButton.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("수학2 버튼 클릭")
    public void 수학버튼클릭() {
        try {
            log.info("학습 수학2 클릭");
            WebElement math2 = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.RelativeLayout/android.widget.ImageView[2]");
            if (math2.isDisplayed()) math2.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("수학 좌측 상단 단계선택 버튼 클릭")
    public void 수학좌측상단단계선택버튼클릭() {
        try {
            log.info("수학 좌측 상단 단계선택 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.school1.main:id/stage_rel_btn_ho");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    @When("수학 {string} 클릭")
    public void 수학클릭(String str) {
        try {
            log.info("수학 {} 클릭", str);
            WebElement element = AndroidManager.getElementByTextAfterSwipe(str);
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("수학 1호 클릭")
    public void 수학1호클릭() {
        try {
            log.info("수학 1호 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[2]/android.widget.RelativeLayout[1]/android.widget.LinearLayout");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("개념강의1 클릭")
    public void 개념강의클릭() {
        try {
            log.info("개념강의1 클릭");
            WebElement element = null;
            try{
                element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView[2]");
                element.click();
                log.info("{}초 대기", 1);
                TimeUnit.SECONDS.sleep(1);
                element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView[1]");
                if (element.isDisplayed()) element.click();
            }catch (Exception e){
                element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView[1]");
                element.click();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("영상 마지막 부분으로 이동")
    public void 영상마지막부분으로이동() {
        try {
            log.info("영상 마지막 부분으로 이동");
            Utils.touchSpecificCoordinates(1885, 1068);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    /*public void 다시보기버튼클릭() {
        try {
            log.info("다시보기 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }*/

    @And("선생님 영상보기 버튼 클릭")
    public void 선생님영상보기버튼클릭() {
        try {
            log.info("선생님 영상보기 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnNextPlay").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("영상 마지막으로 이동")
    public void 영상마지막으로이동() {
        try {
            log.info("영상 마지막 부분으로 이동");
            Utils.touchSpecificCoordinates(1386, 941);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("재생목록 편집 취소 버튼 클릭")
    public void 재생목록편집취소버튼클릭() {
        try {
            log.info("재생목록 편집 취소 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnRemoveCancel");
            if(element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("전체 시청 시간 {int}분으로 설정")
    public void 전체시청시간분으로설정(int index) {
        try {
            log.info("전체 시청 시간 {}분으로 설정", index);
            WebElement timeElement = null;
            int time = 0;
            WebElement minuteElement = null;
            int minute = 0;
            WebElement element = null;
            while (true){
                element = AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"감소\"])[3]");
                element.click();
                timeElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText");
                time = Integer.parseInt(timeElement.getText());
                if(time == 0) break;
            }
            while (true){
                element = AndroidManager.getElementByXpath("(//android.widget.ImageButton[@content-desc=\"감소\"])[4]");
                element.click();
                minuteElement = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.EditText");
                minute = Integer.parseInt(minuteElement.getText());
                if(minute == 15) break;
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("잠금 버튼 확인")
    public void 잠금버튼확인() {
        try {
            log.info("잠금 버튼 확인");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnLock");
            if(element.isDisplayed()) return;
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("화면 {int} {int} 지점 터치")
    public void 화면지점터치(int xX, int yY) {
        try {
            log.info("화면 x:{}, y:{} 지점 터치", xX, yY);
            Utils.touchSpecificCoordinates(xX, yY);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("동일 동영상 횟수 {int}으로 변경")
    public void 동일동영상횟수으로변경(int arg) {
        try {
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
            String result = element.getText();
            int index = result.length();
            result = result.substring(0, index - 1);
            int resultNum = Integer.parseInt(result);
            log.info("남은 횟수 {}회", resultNum);
            if (resultNum == arg) {
                return;
            }
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }

    }

    @And("라이브러리 바로가기 버튼 표출")
    public void 라이브러리바로가기버튼표출() {
        try {
            log.info("라이브러리 바로가기 버튼 표출");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnNoPlayList");
            if (element.isDisplayed()) return;
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("동영상 플레이어의 상단영역 표출 확인")
    public void 동영상플레이어의상단영역표출확인() {
        try {
            log.info("동영상 플레이어의 상단영역 표출 확인");
            WebElement mainName = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAppName");
            WebElement vdoMusicChangeBtn = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnVideoAudioChange");
            WebElement lockBtn = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnLock");
            if (mainName.isDisplayed() && vdoMusicChangeBtn.isDisplayed() && lockBtn.isDisplayed()) return;
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }


    @And("전체메뉴 [English] Animation 클릭")
    public void 전체메뉴EnglishAnimation클릭() {
        try {
            log.info("전체메뉴 [English] Animation 클릭");
            log.info("Home으로 이동");
            AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
            TimeUnit.SECONDS.sleep(10);
            HomeScreenStepDefine hssd = new HomeScreenStepDefine();
            SearchScreenStepDefine sssd = new SearchScreenStepDefine();
            hssd.clickLibraryBtn();
            전체메뉴버튼클릭();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            Utils.dragSourceToTarget(945, 1133, 945, 370);
            Utils.dragSourceToTarget(945, 1133, 945, 370);
            Utils.dragSourceToTarget(945, 1133, 945, 370);
            Utils.dragSourceToTarget(945, 1133, 945, 370);
            WebElement element = AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/sub_img", 2);
            element.click();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            try {
                WebElement title = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/titleArea");
                if(title.isDisplayed()&&title.getText().contains("Animation")){
                    return;
                }else {
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").click();
                    log.info("{}초 대기", 3);
                    TimeUnit.SECONDS.sleep(3);
                    전체메뉴EnglishAnimation클릭();
                }
            }catch (Exception e){
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").click();
                log.info("{}초 대기", 3);
                TimeUnit.SECONDS.sleep(3);
                전체메뉴EnglishAnimation클릭();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("{string} 영상 선택")
    public void 영상선택(String arg0) {
        try {
            log.info("{} 영상 선택", arg0);
            AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.ImageView[1]").click();
            log.info("{}초 대기", 3);
            TimeUnit.SECONDS.sleep(3);
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/topTitle");
                if(element.isDisplayed()) AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/downBtn").click();
            }catch (Exception e){
                fail("동영상이 정상적으로 실행되지 않았습니다.");
            }
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("전체 동영상 설정 후 남은시간 감소 확인")
    public void 전체동영상설정후남은시간감소확인() {
        try {
            log.info("count 확인하기");
            WebElement count = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText");
            //int로 형변환
            int countNum = Integer.parseInt(count.getText());
            log.info("동영상시청제한확인버튼클릭");
            AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnOK").click();
            log.info("{}초 대기", 2);
            TimeUnit.SECONDS.sleep(2);
            재생목록에추가동작("첫생활그림책 늠름 테마송 애니메이션");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvRemainSetting");
            String result = element.getText();
            int index = result.length();
            result = result.substring(0, index - 1);
            int resultNum = Integer.parseInt(result);
            log.info("남은 횟수 {}회", resultNum);
            if (countNum==resultNum) return;
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("디바이스 매니저 클릭")
    public void 디바이스매니저클릭() {
        try {
            log.info("디바이스 매니저 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/androidx.recyclerview.widget.RecyclerView[1]/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.TextView[1]");
            if (element.isDisplayed()) element.click();
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("동영상 시청 제어 화면 확인")
    public void 동영상시청제어화면확인() {
        try {
            log.info("동영상 시청 제어 화면 확인");
            WebElement all = AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/rlAll");
            WebElement same = AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/rlSame");
            WebElement time = AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/rlTime");

            if(all.isDisplayed()&&same.isDisplayed()&&time.isDisplayed()) return;

        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("시청제어 설정 버튼 클릭")
    public void 시청제어설정버튼클릭() {
        try {
            log.info("시청제어 설정 버튼 클릭");
            WebElement setting = AndroidManager.getElementById("com.wjthinkbig.mbookwifi2:id/btnSetting");

           if(setting.isDisplayed()) setting.click();

        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("교과 투데이 버튼 클릭")
    public void 교과투데이버튼클릭() {
        try {
            log.info("교과 투데이 버튼 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[2]");

            if(element.isDisplayed()) element.click();

        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @And("동영상 재생 시간 {string} 확인")
    public void 동영상재생시간확인(String arg0) {
        try {
            log.info("동영상 재생 시간 {} 확인", arg0);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_overlay_time");
            if(element.getText().equals(arg0)) return;
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("자막 버튼 표시 여부 확인")
    public void 자막버튼표시여부확인() {
        try {
            log.info("자막 버튼 표시 여부 확인");
            Pattern patternEng = Pattern.compile("^([a-zA-Z0-9\\s]*)$");
            Pattern patternKor = Pattern.compile("^([가-힣0-9\\s]*)$");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView");
            String str = element.getText();
            if(patternEng.matcher(element.getText()).matches()){
                log.info("자막 버튼 표시됩니다.");
                return;
            }
            if(patternKor.matcher(element.getText()).matches()){
                log.info("자막 버튼 표시되지 않습니다.");
                return;
            }
            fail("실패");
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("셔플 버튼 클릭")
    public void 셔플버튼클릭() {
        try {
            log.info("셔플 버튼 클릭");
            WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout[4]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.ImageView[3]");
            if(element.isDisplayed()) element.click();
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("이전_다음버튼 {int}회 동작")
    public void 이전_다음버튼회동작(int arg0) {
        try {
            log.info("셔플 버튼 클릭");
            for(int i = 0; i < arg0; i++){
                다음버튼클릭();
                log.info("3초 대기");
                TimeUnit.SECONDS.sleep(3);
                이전버튼클릭();
                log.info("3초 대기");
                TimeUnit.SECONDS.sleep(3);
            }
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("반복 재생 버튼 클릭")
    public void 반복재생버튼클릭() {
        try {
            log.info("반복 재생 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/audio_repeat_type");
            if(element.isDisplayed()) element.click();
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("자동 꺼짐 버튼 클릭 취소 {int}회 반복")
    public void 자동꺼짐버튼클릭취소회반복(int arg0) {
        try {
            log.info("자동 꺼짐 버튼 클릭 취소 {}회 반복", arg0);
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/ivOff");
            for(int i=0;i<arg0;i++){
                element.click();
                log.info("자동꺼짐 버튼 클릭");
                log.info("{}초 대기", 2);
                TimeUnit.SECONDS.sleep(2);
                WebElement cancelBtn = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnCancel");
                cancelBtn.click();
                log.info("취소 버튼 클릭");
                log.info("{}초 대기", 2);
                TimeUnit.SECONDS.sleep(2);
            }
        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("{int}초 후 일시정지, {int}초 재생 후 일시정지 시간 비교")
    public void 초후일시정지초재생후일시정지시간비교(int arg0, int arg1) {
        try {
            log.info("{}초 후 일시정지, {}초 재생 후 일시정지 시간 비교", arg0, arg1);
            log.info("{}초 대기", arg0);
            TimeUnit.SECONDS.sleep(arg0);
            일시정지_재생버튼클릭();
            WebElement element;
            element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAutoOff");
            String beforeTime = element.getText();
            log.info("{}초 대기", 10);
            TimeUnit.SECONDS.sleep(10);
            element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAutoOff");
            String afterTime = element.getText();

            if (beforeTime.equals(afterTime)) {
                일시정지_재생버튼클릭();
                log.info("{}초 대기", arg1);
                TimeUnit.SECONDS.sleep(arg1);
                일시정지_재생버튼클릭();
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAutoOff");
                beforeTime = element.getText();
                log.info("{}초 대기", 10);
                TimeUnit.SECONDS.sleep(10);
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/tvAutoOff");
                afterTime = element.getText();
                if(beforeTime.equals(afterTime)){
                    return;
                }else {fail("일시정지 이후에 자동 꺼짐 시간이 변경되었습니다.");}
            }else {fail("일시정지 이후에 자동 꺼짐 시간이 변경되었습니다.");}

        }catch(NoSuchElementException e){
            fail("Element you found not shown");
        } catch(Exception e){
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("화면 표줄 안될 때 화면 1번 터치")
    public void 화면표줄안될때화면번터치() {
        try {
            log.info("화면 표줄 안될 때 화면 1번 터치");
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_study_back_button");
                if (element.isDisplayed()) return;
            }catch (Exception e){
                Utils.touchCenterInViewer(AndroidManager.getDriver());
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}