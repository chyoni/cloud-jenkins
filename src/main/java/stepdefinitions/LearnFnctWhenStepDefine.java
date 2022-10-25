package stepdefinitions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LearnFnctWhenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 학습 커리큘럼 버튼 클릭
     */
    @When("학습 커리큘럼 버튼 클릭")
    public void 학습커리큘럼버튼클릭() {
        try {
            log.info("학습 커리큘럼 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnCurriculum").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 전체 커리큘럼 보기 버튼 클릭
     */
    @When("전체 커리큘럼 보기 버튼 클릭")
    public void 전체커리큘럼보기버튼클릭() {
        try {
            log.info("전체 커리큘럼 보기 버튼 클릭");

            String xpath = "//android.view.View[@text=\" 전체 커리큘럼 보기\"]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 라이브러리 버튼 클릭
     */
    @When("학습 라이브러리 버튼 클릭")
    public void 학습라이브러리버튼클릭() {
        try {
            log.info("학습 라이브러리 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnStudyLib").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 그리기 권한 허용 설정
     */
    @When("그리기 권한 허용 설정")
    public void 그리기권한허용설정() {
        try {
            log.info("그리기 권한 허용 설정");

            try {
                String displayedContents = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/txtTitle").getText();
                if (displayedContents.equals("권한 안내")) {
                    //권한 허용 확인 버튼 클릭
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnSettingOk").click();

                    //권한 허용 설정
                    AndroidManager.getElementById("android:id/switch_widget").click();

                    //HOME 버튼 클릭
                    AndroidManager.getDriver().pressKey(new KeyEvent(AndroidKey.HOME));
                }
            } catch (Exception e) {
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 배틀 버튼 클릭
     */
    @When("학습 배틀 버튼 클릭")
    public void 학습배틀버튼클릭() {
        try {
            log.info("학습 배틀 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnStudyBattle").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 투게더 수업 버튼 클릭
     */
    @When("학습 투게더 수업 버튼 클릭")
    public void 학습투게더수업버튼클릭() {
        try {
            log.info("학습 투게더 수업 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnTogether").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 상담하기 버튼 클릭
     */
    @When("학습 상담하기 버튼 클릭")
    public void 학습상담하기버튼클릭() {
        try {
            log.info("학습 상담하기 버튼 클릭");

            //화면 최하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnCounsel").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 체험판 과목 버튼 클릭
     */
    @When("학습 체험판 {string} 버튼 클릭")
    public void 학습체험판버튼클릭(String subject) {
        try {
            log.info("학습 체험판 {} 버튼 클릭", subject);

            //화면 최하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

            //학습 체험판 과목 리스트 영역 위치(과목 리스트 초기화하거나 Next Step으로 Swipe할 때 사용)
            WebElement source = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rvTrialList");
            int pointX = source.getLocation().x;
            int pointY = source.getLocation().y;

            //학습 체험판 과목 리스트 순서 초기화
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/viewArrowLeft");

                if (element.isDisplayed()) {
                    log.info("학습 체험판 과목 리스트 순서 초기화");
                    Utils.dragSourceToTarget(pointX, pointY, pointX + 1350, pointY);
                }
            } catch (Exception e) {
            }

            //학습 체험판 과목별 아이콘 선택
            int index = 0;
            switch (subject) {
                case "AI수학":
                    index = 0;
                    break;
                case "AI학습매니저":
                    index = 1;
                    break;
                case "AI수학체험":
                    index = 2;
                    break;
                case "AI책읽기":
                    index = 3;
                    break;
                case "국어":
                    index = 4;
                    break;
                case "생각토론":
                    index = 5;
                    break;
                case "수학":
                    index = 6;
                    break;
                case "ARScience":
                    index = 7;
                    break;
                case "사회과학":
                    index = 8;
                    break;
                case "영어":
                    index = 1;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "한자":
                    index = 2;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "한글깨치기":
                    index = 3;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "수학깨치기":
                    index = 4;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "유아국어":
                    index = 5;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "유아수학":
                    index = 6;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "유아영어":
                    index = 7;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
                case "투게더":
                    index = 8;

                    //과목 리스트의 next 단계로 swipe 처리
                    Utils.dragSourceToTarget(pointX + 1350, pointY, pointX, pointY);
                    break;
            }

            //해당 과목 버튼 클릭
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rvTrialList")
                    .findElements(By.id("com.wjthinkbig.mlauncher2:id/imgTrial")).get(index).click();
        } catch (
                NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 체험판 과목 첫단계 선택
     * 국어/수학/사회과학/영어 과목의 경우 단계 선택 필요함
     */
    @When("학습 체험판 {string} 첫단계 선택")
    public void 학습체험판첫단계선택(String subject) {
        try {
            log.info("학습 체험판 {} 과목 첫단계 선택", subject);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/txtStage", 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 학습 과목 클릭
     */
    @When("{string} 과목 클릭")
    public void 학습과목클릭(String subject) {
        try {
            log.info("학습 과목 {} 클릭", subject);

            Dimension dims = AndroidManager.getDriver().manage().window().getSize();
            int pointX = dims.width / 2;
            int pointY = dims.height / 2;

            String rId = "";
            int index = 0;
            switch (subject) {
                case "국어":
                    index = 0;
                    break;
                case "생각토론":
                    index = 1;
                    break;
                case "테마논술":
                    index = 2;
                    break;
                case "개정수학":
                    index = 3;
                    break;
                case "초고수학":
                    index = 4;
                    break;
                case "서술형수학":
                    index = 5;
                    break;
                case "사회":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.dragSourceToTarget(pointX, pointY, pointX, pointY+450);
                    TimeUnit.SECONDS.sleep(1);

                    index = 0;
                    break;
                case "과학":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.dragSourceToTarget(pointX, pointY, pointX, pointY+450);
                    TimeUnit.SECONDS.sleep(1);

                    index = 1;
                    break;
                case "Vacabulary Master":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.dragSourceToTarget(pointX, pointY, pointX, pointY+450);
                    TimeUnit.SECONDS.sleep(1);

                    index = 2;
                    break;
                case "Reading Master":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.dragSourceToTarget(pointX, pointY, pointX, pointY+450);
                    TimeUnit.SECONDS.sleep(1);

                    index = 3;
                    break;
                case "수학마스터":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);

                    index = 0;
                    break;
                case "무한수강":
                    //해당 과목 위치로 swipe 처리
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);

                    index = 1;
                    break;
                case "한글깨치기":
                    //화면 최하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);
                    Utils.swipeScreen(Utils.Direction.UP);
                    TimeUnit.SECONDS.sleep(1);

                    rId = "com.wjthinkbig.mlauncher2:id/imgOrder_baby";
                    break;
            }

            if (!rId.equals("")) {
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/imgOrder_baby").click();
            } else {
                String parentId = "com.wjthinkbig.mlauncher2:id/rvStudyList";
                String childId = "com.wjthinkbig.mlauncher2:id/imgOrder_elem";
                AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 책이랑 글자랑 영역 콘텐츠 클릭
     */
    @When("책이랑 글자랑 영역 콘텐츠 클릭")
    public void 책이랑글자랑영역콘텐츠클릭() {
        try {
            log.info("책이랑 글자랑 영역 콘텐츠 클릭");
            AndroidManager.getElementById("com.wjthinkbig.babyintg:id/todaybfragment_framely_5").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 과목별 학습단계 확인 버튼 클릭
     */
    @When("{string} 학습단계 확인 버튼 클릭")
    public void 과목별학습단계확인버튼클릭(String subject) {
        try {
            log.info("과목별 학습단계 확인 버튼 클릭, {}", subject);

            String rId = "";
            switch (subject) {
                case "한글깨치기":
                    rId = "com.wjthinkbig.babyintg:id/stage_rel_btn_ho";
                    break;
                case "개정수학":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "초고수학":
                    rId = "com.wjthinkbig.school1.main:id/stage_rel_btn_ho";
                    break;
                case "국어":
                    rId = "com.wjthinkbig.school1.main:id/stage_rel_btn_ho";
                    break;
                case "사회":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "과학":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "Vacabulary Master":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "생각토론":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "테마논술":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
                case "수학마스터":
                    rId = "com.wjthinkbig.integratedquration.main:id/txt_current_ho";
                    break;
            }

            AndroidManager.getElementById(rId).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 본학습단계 클릭
     */
    @When("본학습단계 클릭")
    public void 본학습단계클릭() {
        try {
            log.info("본학습단계 클릭");

            String parentId = "com.wjthinkbig.babyintg:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.babyintg:id/stage_list1_linearly";
            int index = 1;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 세부 단계 클릭
     */
    @When("{string} 과목 {string} 단계 클릭")
    public void 단계클릭(String subject, String step) {
        try {
            log.info("{} 과목 {} 단계 클릭", subject, step);

            //step명에 " "가 붙어 있어서 변환 처리
            String tStep = "";
            if(subject.equals("개정수학") || subject.equals("사회") || subject.equals("과학") || subject.equals("Vacabulary Master")
                    || subject.equals("생각토론") || subject.equals("테마논술")) {
                for (int i = 0; i < step.length(); i++) {
                    tStep += step.substring(i, i + 1) + " ";
                }
                step = tStep;
            }

            AndroidManager.getElementByTextContainsAfterSwipe(".*:id/backinfopop_lv_holist", step).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 투데이 스터디1 영역 콘텐츠 클릭
     */
    @When("투데이 스터디1 영역 콘텐츠 클릭")
    public void 투데이스터디1영역콘텐츠클릭() {
        try {
            log.info("투데이 스터디1 영역 콘텐츠 클릭");
            AndroidManager.getElementById("com.wjthinkbig.school1.main:id/todaybfragment_framely_2").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 개정수학 D단계 클릭
     */
    @When("개정수학 D단계 클릭")
    public void 개정수학D단계클릭() {
        try {
            log.info("개정수학 D단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 개념이 쏙쏙1 영역 콘텐츠 클릭
     */
    @When("개념이 쏙쏙1 영역 콘텐츠 클릭")
    public void 개념이쏙쏙영역콘텐츠클릭() {
        try {
            log.info("개념이 쏙쏙1 영역 콘텐츠 클릭");

            //콘텐츠 이미지가 backView인 경우, 콘텐츠 한번 더 클릭하여 frontView로 만든 후 실행하기
            try {
                WebElement backView = AndroidManager.getElementById("com.wjthinkbig.integratedquration.main:id/back_thumb");

                if (backView.isDisplayed()) {
                    log.info("콘텐츠 이미지가 backView인 경우, 한번 클릭하여 frontView가 보여지도록 처리");
                    backView.click();
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.integratedquration.main:id/gridExpandable";
            String childId = "com.wjthinkbig.integratedquration.main:id/ib_module";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 초고수학 G단계 클릭
     */
    @When("초고수학 G단계 클릭")
    public void 초고수학G단계클릭() {
        try {
            log.info("초고수학 G단계 클릭");

            String parentId = "com.wjthinkbig.school1.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.school1.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 국어 F단계 클릭
     */
    @When("국어 F단계 클릭")
    public void 국어F단계클릭() {
        try {
            log.info("국어 F단계 클릭");

            String parentId = "com.wjthinkbig.school1.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.school1.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 사회 E단계 클릭
     */
    @When("사회 E단계 클릭")
    public void 사회E단계클릭() {
        try {
            log.info("사회 E단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 1;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 개념쏙속1 영역 콘텐츠 클릭
     */
    @When("개념쏙속1 영역 콘텐츠 클릭")
    public void 개념쏙속1영역콘텐츠클릭() {
        try {
            log.info("개념쏙속1 영역 콘텐츠 클릭");

            //콘텐츠 이미지가 backView인 경우, 콘텐츠 한번 더 클릭하여 frontView로 만든 후 실행하기
            try {
                WebElement backView = AndroidManager.getElementById("com.wjthinkbig.integratedquration.main:id/back_thumb");

                if (backView.isDisplayed()) {
                    log.info("콘텐츠 이미지가 backView인 경우, 한번 클릭하여 frontView가 보여지도록 처리");
                    backView.click();
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.integratedquration.main:id/gridExpandable";
            String childId = "com.wjthinkbig.integratedquration.main:id/ib_module";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 과학 E단계 클릭
     */
    @When("과학 E단계 클릭")
    public void 과학E단계클릭() {
        try {
            log.info("과학 E단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Vacabulary Master 2단계 클릭
     */
    @When("Vacabulary Master 2단계 클릭")
    public void vacabularyMaster2단계클릭() {
        try {
            log.info("Vacabulary Master 2단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 1;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Learn - Chant 영역 콘텐츠 클릭
     */
    @When("Chant 영역 콘텐츠 클릭")
    public void chant영역콘텐츠클릭() {
        try {
            log.info("Learn - Chant 영역 콘텐츠 클릭");

            //콘텐츠 이미지가 backView인 경우, 콘텐츠 한번 더 클릭하여 frontView로 만든 후 실행하기
            try {
                WebElement backView = AndroidManager.getElementById("com.wjthinkbig.integratedquration.main:id/back_thumb");

                if (backView.isDisplayed()) {
                    log.info("콘텐츠 이미지가 backView인 경우, 한번 클릭하여 frontView가 보여지도록 처리");
                    backView.click();
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.integratedquration.main:id/gridExpandable";
            String childId = "com.wjthinkbig.integratedquration.main:id/ib_module";
            int index = 1;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 생각토론 C단계 클릭
     */
    @When("생각토론 C단계 클릭")
    public void 생각토론C단계클릭() {
        try {
            log.info("생각토론 C단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 꼬물꼬물 이야기 극장 영역 콘텐츠 클릭
     */
    @When("꼬물꼬물 이야기 극장 영역 콘텐츠 클릭")
    public void 꼬물꼬물이야기극장영역콘텐츠클릭() {
        try {
            log.info("꼬물꼬물 이야기 극장 영역 콘텐츠 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/gridExpandable";
            String childId = "com.wjthinkbig.integratedquration.main:id/ib_module";
            int index = 4;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 테마논술 C단계 클릭
     */
    @When("테마논술 C단계 클릭")
    public void 테마논술C단계클릭() {
        try {
            log.info("테마논술 C단계 클릭");

            String parentId = "com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist";
            String childId = "com.wjthinkbig.integratedquration.main:id/stage_list1_linearly";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수학마스터 동영상 강의 영역 콘텐츠 클릭
     */
    @When("수학마스터 동영상 강의 영역 콘텐츠 클릭")
    public void 수학마스터동영상강의영역콘텐츠클릭() {
        try {
            log.info("수학마스터 동영상 강의 영역 콘텐츠 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mid.master:id/imgTile1").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수학마스터 학습단계 선택 리스트 클릭
     */
    @When("수학마스터 학습단계 선택 리스트 클릭")
    public void 수학마스터학습단계선택리스트클릭() {
        try {
            log.info("수학마스터 학습단계 선택 리스트 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mid.master:id/viewUnitBox").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수학마스터 1-1 단계 클릭
     */
    @When("수학마스터 1-1 단계 클릭")
    public void 수학마스터1단계클릭() {
        try {
            log.info("수학마스터 1-1 단계 클릭");

            String parentId = "com.wjthinkbig.mid.master:id/listViewGrade";
            String childId = "com.wjthinkbig.mid.master:id/tvGrade";
            int index = 0;
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수학마스터 {string} 단계 클릭
     */
    @When("수학마스터 {string} 단계 클릭")
    public void 수학마스터단계클릭(String step) {
        try {
            log.info("수학마스터 {} 단계 클릭", step);

            AndroidManager.getElementByTextContainsAfterSwipe(".*:id/listViewLecture", step).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 수학마스터 첫번째 강의 클릭
     */
    @When("수학마스터 첫번째 강의 클릭")
    public void 수학마스터첫번째강의클릭() {
        try {
            log.info("수학마스터 첫번째 강의 클릭");

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mid.master:id/rvMovie");
            parent.findElements(By.className("android.view.ViewGroup")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
