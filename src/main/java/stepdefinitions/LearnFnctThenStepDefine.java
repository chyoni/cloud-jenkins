package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LearnFnctThenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Then("학습 화면구성 확인")
    public void 학습화면구성확인() {
        try {
            log.info("학습 화면구성 확인");

            //학습중인 과목 타이틀 및 커리큘럼/투게더 수업 버튼 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rbStudy").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnCurriculum").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnTogether").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rvStudyList").isDisplayed();
            assertTrue("학습 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 커리큘럼 콘텐츠 확인
     */
    @Then("학습 커리큘럼 콘텐츠 확인")
    public void 학습커리큘럼콘텐츠확인() {
        try {
            log.info("학습 커리큘럼 콘텐츠 확인");

            boolean isDisplayedContents = AndroidManager.getElementByTextAfterSwipe("내 진도 보기").isDisplayed();
            assertTrue(isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 전체 커리큘럼 콘텐츠 확인
     */
    @Then("전체 커리큘럼 콘텐츠 확인")
    public void 전체커리큘럼콘텐츠확인() {
        try {
            log.info("전체 커리큘럼 콘텐츠 확인");

            String displayedContents = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/txtTitle").getText().trim();
            assertEquals("전체 커리큘럼 콘텐츠가 확인되지 않습니다.", displayedContents, "커리큘럼");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 라이브러리 콘텐츠 확인
     */
    @Then("학습 라이브러리 콘텐츠 확인")
    public void 학습라이브러리콘텐츠확인() {
        try {
            log.info("학습 라이브러리 콘텐츠 확인");

            String displayedContents = AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/txtTitle").getText().trim();
            assertEquals("학습 라이브러리 콘텐츠가 확인되지 않습니다.", displayedContents, "학습 라이브러리");

            //동화/동요/놀이학습/형성평가/짝꿍책 구성 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/btnStory").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/btnMusic").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/btnPlay").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/btnTest").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mstudylibrary:id/btnBook").isDisplayed();
            assertTrue("학습 라이브러리 콘텐츠가 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 배틀 실행 확인
     */
    @Then("학습 배틀 실행 확인")
    public void 학습배틀실행확인() {
        try {
            log.info("학습 배틀 실행 확인");
            String imageName = Utils.takeScreenShot();
            String result = Utils.imageToText(imageName);
            log.info("image to text: {}", result);
            assertTrue("학습 배틀 실행 화면이 아닙니다.", result.contains("닉 네 임"));
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 투게더 수업 기능 확인
     * 회원이 아닌 경우, 알림 메시지 팝업창 확인
     */
    @Then("학습 투게더 수업 기능 확인")
    public void 학습투게더수업기능확인() {
        try {
            log.info("학습 투게더 수업 기능 확인");

            //투게더 회원이 아닌 경우, 알림 메시지 팝업창 오픈됨
            try {
                //알림 팝업 확인
                boolean isDisplayedContents =
                        AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layoutDialog").isDisplayed() &&
                        AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/txtMessage").getText().equals("투게더 회원이 아닙니다.");
                assertTrue(isDisplayedContents);

                //알림 팝업 닫기
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnR").click();
            } catch (Exception e) {
            }

            //투게더 회원인 경우, 기능 추가 필요
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 상담하기 실행 확인
     */
    @Then("학습 상담하기 실행 확인")
    public void 학습상담하기실행확인() {
        try {
            log.info("학습 상담하기 실행 확인");

            //타이틀 및 탭 구성 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/txtTitle").getText().equals("상담하기") &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"웅진씽크빅\"]/android.widget.TextView").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"웅진북클럽\"]/android.widget.TextView").isDisplayed();
            assertTrue(isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 체험판 과목 실행 확인
     */
    @Then("학습 체험판 {string} 실행 확인")
    public void 학습체험판실행확인(String subject) {
        try {
            log.info("학습 체험판 {} 실행 확인", subject);

            //학습 체험판 과목별 실행 확인
            boolean isDisplayedContents = false;
            String imageName = "";
            String result = "";
            switch (subject) {
                case "AI수학":
                    isDisplayedContents =
                            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/container_study_overlay").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_study_lock_button").isDisplayed();
                    break;
                case "AI학습매니저":
                    isDisplayedContents =
                            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/exo_ad_overlay").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/exo_content_frame").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/exo_overlay").isDisplayed();
                    break;
                case "AI수학체험":
                    isDisplayedContents =
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"AI수학 소개\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"AI수학 체험 저학년\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"AI수학 체험 고학년\"]").isDisplayed();
                    break;
                case "AI책읽기":
                    isDisplayedContents =
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"AI책읽기 소개\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"AI책읽기 체험\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.view.View[@content-desc=\"월간 분석지\"]").isDisplayed();
                    break;
                case "국어":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("투 대이 스 터 디");
                    break;
                case "생각토론":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("생 각 톡 톡");
                    break;
                case "수학":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("수 학");
                    break;
                case "ARScience":
                    TimeUnit.SECONDS.sleep(15);

                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("인 터 랙 티 브 북");
                    break;
                case "사회과학":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("사 회 과 학");
                    break;
                case "영어":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName, "eng");
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("Start");
                    break;
                case "한자":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("한 자");
                    break;
                case "한글깨치기":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("한 글 자 학 습");
                    break;
                case "수학깨치기":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("고 아 페 은");
                    break;
                case "유아국어":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("놀2");
                    break;
                case "유아수학":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("놀 이");
                    break;
                case "유아영어":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName, "eng");
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("Guide");
                    break;
                case "투게더":
                    imageName = Utils.takeScreenShot();
                    result = Utils.imageToText(imageName);
                    log.info("image to text: {}", result);
                    isDisplayedContents = result.contains("1 시 간 의 기 적");
                    break;
            }

            assertTrue(isDisplayedContents);
        } catch (
                NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }
}
