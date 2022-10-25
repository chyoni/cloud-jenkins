package stepdefinitions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class GeneralFnctWhenStepDefine {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 웅진 북클럽 진입
     */
    @Given("웅진 북클럽 진입")
    public void 웅진북클럽진입() {
        try {
            log.info("웅진 북클럽 진입");

            //웅진 북클럽과 웅진 스마트올 페이지의 웅진 북클럽 버튼 id가 다름(웅진 스마트올 페이지의 버튼 id 관련 추가)
            try {
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rltBookClub").click();
                return;
            } catch (Exception e) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rltBookClub").click();
                    return;
                } catch (Exception e1) {

                }
            }

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnBookClub").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 메뉴 클릭
     */
    @Given("독서앨범 새소식 메뉴 클릭")
    public void 독서앨범새소식메뉴클릭() {
        try {
            log.info("독서앨범 새소식 메뉴 클릭");
            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_news").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 추가 버튼 클릭
     */
    @When("독서앨범 새소식 추가 버튼 클릭")
    public void 독서앨범새소식추가버튼클릭() {
        try {
            log.info("독서앨범 새소식 추가 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/create_btn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 라이브러리 추가 버튼 클릭
     */
    @When("독서앨범 새소식 라이브러리 추가 버튼 클릭")
    public void 독서앨범새소식라이브러리추가버튼클릭() {
        try {
            log.info("독서앨범 새소식 라이브러리 추가 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_library").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 친구 작품 보기 메뉴 클릭
     */
    @When("독서앨범 친구 작품 보기 메뉴 클릭")
    public void 독서앨범친구작품보기메뉴클릭() {
        try {
            log.info("독서앨범 친구 작품 보기 메뉴 클릭");
            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_friendswork").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 친구 작품 보기 탭 클릭
     */
    @When("독서앨범 친구 작품 보기 {string} 탭 클릭")
    public void 독서앨범친구작품보기탭클릭(String menu) {
        try {
            log.info("독서앨범 친구 작품 보기 {} 탭 클릭", menu);

            String rId = "";
            switch (menu) {
                case "감상문":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_report";
                    break;
                case "사용자 오디오이북":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_useraudio";
                    break;
                case "일기":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_diary";
                    break;
            }

            //해당 element 클릭
            AndroidManager.getElementById(rId).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 친구 작품 보기 탭 콘텐츠 클릭
     */
    @When("독서앨범 친구 작품 보기 탭 콘텐츠 클릭")
    public void 독서앨범친구작품보기탭콘텐츠클릭() {
        try {
            log.info("독서앨범 친구 작품 보기 탭 콘텐츠 클릭");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_data_text").isDisplayed();
                if(noData) return;
            } catch (Exception e) {}

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/recyclerview");
            parent.findElements(By.className("android.widget.FrameLayout")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 메뉴 클릭
     */
    @When("독서앨범 내 작품 보기 메뉴 클릭")
    public void 독서앨범내작품보기메뉴클릭() {
        try {
            log.info("독서앨범 내 작품 보기 메뉴 클릭");
            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_mywork").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 탭 클릭
     */
    @When("독서앨범 내 작품 보기 {string} 탭 클릭")
    public void 독서앨범내작품보기탭클릭(String menu) {
        try {
            log.info("독서앨범 내 작품 보기 {} 탭 클릭", menu);

            String rId = "";
            switch (menu) {
                case "감상문":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_report";
                    break;
                case "사용자 오디오이북":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_useraudio";
                    break;
                case "일기":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_diary";
                    break;
                case "사진":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_photo";
                    break;
                case "동영상":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_video";
                    break;
                case "학습":
                    rId = "com.wjthinkbig.thinkplayground:id/tab_study";
                    break;
            }

            //해당 id 클릭
            AndroidManager.getElementById(rId).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 탭 콘텐츠 클릭
     */
    @When("독서앨범 내 작품 보기 탭 콘텐츠 클릭")
    public void 독서앨범내작품보기탭콘텐츠클릭() {
        try {
            log.info("독서앨범 내 작품 보기 탭 콘텐츠 클릭");

            try {
                //콘텐츠가 있는 경우에만 처리
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_content_view");
                if (element.isDisplayed()) return;
            } catch (Exception e) {
            }

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/gridView");
            parent.findElements(By.className("android.widget.FrameLayout")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 스마트올 백과 연표 아이콘 클릭
     */
    @When("스마트올 백과 연표 아이콘 클릭")
    public void 스마트올백과연표아이콘클릭() {
        try {
            log.info("스마트올 백과 연표 아이콘 클릭");
            AndroidManager.getElementByXpath("//android.widget.Button[@content-desc=\"연표보기\"]").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 동영상 보기 클릭
     */
    @Then("독서앨범 내 작품 보기 동영상 보기 클릭")
    public void 독서앨범내작품보기동영상보기클릭() {
        try {
            log.info("독서앨범 친구 작품 보기 동영상 보기 클릭");

            try {
                //콘텐츠가 있는 경우에만 처리
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_content_view");
                if (element.isDisplayed()) return;
            } catch (Exception e) {
            }

            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_play").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 - {string} 서브메뉴 클릭
     */
    @When("웅진 스마트올 - {string} 서브메뉴 클릭")
    public void 웅진스마트올서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 웅진 스마트올 > 서브메뉴 {} 클릭", menu);

            //서브메뉴 클릭
            String accessibilityId = "";
            switch (menu) {
                case "오늘의 학습":
                    accessibilityId = "오늘의 학습";
                    break;
                case "AI 학습센터":
                    accessibilityId = "AI 학습센터";
                    break;
                case "초등 포털":
                    accessibilityId = "초등 포털";
                    break;
                case "전체과목":
                    accessibilityId = "전체과목";
                    break;
                case "라이브러리":
                    accessibilityId = "라이브러리";
                    break;
                case "스타샵":
                    accessibilityId = "스타샵";
                    break;
                case "올링고 번역":
                    accessibilityId = "올링고 번역";
                    break;
            }
            AndroidManager.getElementByAccessibilityId(accessibilityId).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 {string} 서브메뉴 클릭
     */
    @When("웅진 스마트올 AI 학습센터 {string} 서브메뉴 클릭")
    public void 웅진스마트올AI학습센터서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 웅진 스마트올 > 서브메뉴 {} 클릭", menu);

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/frmBottomLayout");
            parent.findElement(By.id("com.wjthinkbig.mlauncher2:id/llMenu"))
                    .findElement(By.xpath("//*[@text='" + menu + "']"))
                    .click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 진도 학년 클릭
     */
    @When("북클럽 진도 학년 클릭")
    public void 북클럽진도학년클릭() {
        try {
            log.info("북클럽 진도 학년 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_bookclub_2_age_text");
            if (element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 관리자 비밀번호 입력
     */
    @When("관리자 비밀번호 입력")
    public void 관리자비밀번호입력() {
        try {
            log.info("관리자 비밀번호 입력");

            BookClubPlayerStepDefine bpsd = new BookClubPlayerStepDefine();
            bpsd.비밀번호입력();
            bpsd.비밀번호입력확인버튼클릭();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    /**
     * 교과 진도 중등 클릭
     */
    @When("교과 진도 중등 클릭")
    public void 교과진도중등클릭() {
        try {
            log.info("교과 진도 중등 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/btn_child_11");
            if (element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 진도 변경완료 버튼 클릭
     */
    @When("교과 진도 변경완료 버튼 클릭")
    public void 교과진도변경완료버튼클릭() {
        try {
            log.info("교과 진도 변경완료 버튼 클릭");
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/popupBtncomfirm");
            if (element.isDisplayed()) element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 진도 변경 확인 버튼 클릭
     */
    @When("교과 진도 변경 확인 버튼 클릭")
    public void 교과진도변경확인버튼클릭() {
        CommonStepDefine csdf = new CommonStepDefine();
        try {
            WebElement element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/tv_title");
            if (element.isDisplayed()) {
                element = AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/tv_msg");
                if (element.getText().contains("진도를 변경할 경우")) {
                    AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/btn_confirm").click();
                    log.info("120초 대기");
                    TimeUnit.SECONDS.sleep(120);
                    /*log.info("Home으로 이동");
                    AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));*/
                } else if (element.getText().contains("진도변경 사항이 없습니다.")) {
                    AndroidManager.getElementById("com.wjthinkbig.nmmomsclub2:id/btn_confirm").click();
                    log.info("Home으로 이동");
                    AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                }
            } else {
                fail("팝업이 표출되지 않았습니다.");
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 투데이 체험판 클릭
     */
    @And("교과 투데이 체험판 클릭")
    public void 교과투데이체험판클릭() {
        try {
            log.info("교과 투데이 체험판 클릭");

            WebElement element = AndroidManager.getElementByTextAfterSwipe("체험판");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 투데이 동영상 콘텐츠 클릭
     * 체험판 마지막 콘텐츠가 동영상 콘텐츠임
     */
    @When("교과 투데이 동영상 콘텐츠 클릭")
    public void 교과투데이동영상콘텐츠클릭() {
        try {
            log.info("교과 투데이 동영상 콘텐츠 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ibtnCurriculumBook10").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 동영상 종료하기
     */
    @And("독서앨범 동영상 종료하기")
    public void 독서앨범동영상종료하기() {
        try {
            log.info("독서앨범 동영상 종료하기");

            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_cancel").click();

            //뒤로가기 버튼 클릭
            AndroidManager.getElementById(Constant.commonBackButton_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
