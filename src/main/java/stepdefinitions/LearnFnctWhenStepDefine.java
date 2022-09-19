package stepdefinitions;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

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

            String xpath = "//android.view.View[@content-desc=\" 전체 커리큘럼 보기\"]";
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
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
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
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);

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
            log.info("학습 체험판 과목 첫단계 선택");
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/txtStage", 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @When("{string} 과목 클릭")
    public void 학습과목클릭(String subject) {
        switch (subject) {
            case "한글깨치기":
                //스크롤해서 해당 아이템 클릭
                //com.wjthinkbig.mlauncher2:id/imgOrder_baby 클릭
                break;
            case "유아수학":
                //com.wjthinkbig.mlauncher2:id/rvStudyList 의 index=4 아이템
                //xpath :  /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]
                break;
            case "개정수학":
                //com.wjthinkbig.mlauncher2:id/rvStudyList 의 index=5 아이템
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]
                break;
            case "국어":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=1 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]
                break;
            case "사회":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=4 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]
                break;
            case "과학":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=5 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]
                break;
            case "Vacabulary Master":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=6 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]
                break;
            case "생각토론":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=2 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]
                break;
            case "테마논술":
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=3 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]
                break;
            case "수학마스터":
                //화면 스크롤 필요
                //com.wjthinkbig.mlauncher2:id/rvStudyList index=5 또는 xpath
                //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]
                break;
        }

    }

    @When("책이랑 글자랑 영역 콘텐츠 클릭")
    public void 책이랑글자랑영역콘텐츠클릭() {
        //책이랑 글자랑 콘텐츠 클릭
        //com.wjthinkbig.babyintg:id/todaybfragment_framely_5
    }

    @When("{string} 학습단계 확인 버튼 클릭")
    public void 과목별학습단계확인버튼클릭(String subject) {
        switch (subject) {
            case "한글깨치기":
                //학습단계 확장 토글 버튼 클릭
                //com.wjthinkbig.babyintg:id/stage_img_toggle
                break;
            case "유아수학":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "개정수학":
                //com.wjthinkbig.school1.main:id/stage_rel_btn_ho
                break;
            case "국어":
                //com.wjthinkbig.school1.main:id/stage_rel_btn_ho
                break;
            case "사회":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "과학":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "Vacabulary Master":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "생각토론":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "테마논술":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
            case "수학마스터":
                //com.wjthinkbig.integratedquration.main:id/txt_current_ho
                break;
        }
    }

    @When("본학습단계 클릭")
    public void 본학습단계클릭() {
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]";
    }

    @When("{string} 단계 클릭")
    public void 단계클릭(String step) {
        //해당 step이 보여질때까지 스크롤 필요
        //resource-id : com.wjthinkbig.babyintg:id/stage_list2_txt_honame, text : step
    }


    @When("유아수학 D단계 클릭")
    public void 유아수학D단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist 의 index=0 또는 아래 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]
    }

    @When("개정수학 G단계 클릭")
    public void 개정수학G단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist 의 index=0 또는 아래 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]
    }

    @When("개념이 쏙쏙1 영역 콘텐츠 클릭")
    public void 개념이쏙쏙영역콘텐츠클릭() {
        //xpath: /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.GridView/android.widget.RelativeLayout[1]
    }


    @When("국어 F단계 클릭")
    public void 국어F단계클릭() {
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]
    }

    @When("읽기 도입 영역 콘텐츠 클릭")
    public void 읽기도입영역콘텐츠클릭() {
        //com.wjthinkbig.school1.main:id/todaybfragment_framely_2
    }


    @When("사회 E단계 클릭")
    public void 사회E단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist index=1 또는 아래 이용
        //com.wjthinkbig.integratedquration.main:id/stage_list1_txt_stagename 의 text = E단계 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]
    }

    @When("개념쏙속1 영역 콘텐츠 클릭")
    public void 개념쏙속1영역콘텐츠클릭() {
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.GridView/android.widget.RelativeLayout[1]
    }


    @When("과학 E단계 클릭")
    public void 과학E단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist index=0 또는 아래 이용
        //com.wjthinkbig.integratedquration.main:id/stage_list1_txt_stagename 의 text = E단계 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]
    }


    @When("Vacabulary Master 2단계 클릭")
    public void vacabularyMaster2단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist index=1 또는 아래 이용
        //com.wjthinkbig.integratedquration.main:id/stage_list1_txt_stagename 의 text = 2단계 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[2]
    }

    @When("Chant 영역 콘텐츠 클릭")
    public void chant영역콘텐츠클릭() {
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.GridView/android.widget.RelativeLayout[2]
    }


    @When("생각토론 C단계 클릭")
    public void 생각토론C단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist index=0 또는 아래 이용
        //com.wjthinkbig.integratedquration.main:id/stage_list1_txt_stagename 의 text = C단계 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]
    }

    @When("꼬물꼬물 이야기 극장 영역 콘텐츠 클릭")
    public void 꼬물꼬물이야기극장영역콘텐츠클릭() {
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ExpandableListView/android.widget.LinearLayout[1]/android.widget.GridView/android.widget.RelativeLayout[5]
    }

    @When("테마논술 C단계 클릭")
    public void 테마논술C단계클릭() {
        //com.wjthinkbig.integratedquration.main:id/backinfopop_lv_stagelist index=0 또는 아래 이용
        //com.wjthinkbig.integratedquration.main:id/stage_list1_txt_stagename 의 text = C단계 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]
    }

    @When("수학마스터 동영상 강의 영역 콘텐츠 클릭")
    public void 수학마스터동영상강의영역콘텐츠클릭() {
        //com.wjthinkbig.mid.master:id/imgTile1
    }

    @When("수학마스터 학습단계 선택 리스트 클릭")
    public void 수학마스터학습단계선택리스트클릭() {
        //com.wjthinkbig.mid.master:id/viewUnitBox
    }

    @When("수학마스터 1-1 단계 클릭")
    public void 수학마스터1단계클릭() {
        //com.wjthinkbig.mid.master:id/listViewGrade 의 index=0 또는 xpath 이용
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ListView[1]/android.view.ViewGroup[1]
    }

    @When("수학마스터 {string} 단계 클릭")
    public void 수학마스터단계클릭(String step) {
        //com.wjthinkbig.mid.master:id/listViewLecture 의 index=0 또는 아래 id 이용
        //resource-id : com.wjthinkbig.mid.master:id/tvLecture, text : step
    }

    @When("수학마스터 첫번째 강의 클릭")
    public void 수학마스터첫번째강의클릭() {
        //com.wjthinkbig.mid.master:id/tvNo text=1
    }

}
