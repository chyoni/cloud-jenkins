package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ReadFnctWhenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 독서 - 서브메뉴 클릭
     *
     * @param menu 독서 메뉴의 하위 메뉴
     */
    @When("독서 - {string} 서브메뉴 클릭")
    public void 독서서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 독서 > 서브메뉴 클릭");

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "AI맞춤":
                    index = 1;
                    break;
                case "교과":
                    index = 2;
                    break;
                case "메인":
                    index = 3;
                    break;
                case "주제":
                    index = 4;
                    break;
                case "메타버스":
                    index = 5;
                    break;
                case "백과":
                    index = 6;
                    break;
                case "타임챌린지":
                    index = 7;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * AI맞춤 콘텐츠 클릭
     *
     * @param title AI맞춤 투데이의 영역 타이틀
     */
    @When("AI맞춤 {string} 콘텐츠 클릭")
    public void AI맞춤콘텐츠클릭(String title) {
        try {
            log.info("AI맞춤 콘텐츠 클릭");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            //해당 타이틀의 Y 위치가 1000보다 클 경우 콘텐츠 영역이 가려지기 때문에, title 기준으로 약간 위로 스크롤 처리
            int titlePositionX = AndroidManager.getElementByTextAfterSwipe(title).getLocation().getX();
            int titlePositionY = AndroidManager.getElementByTextAfterSwipe(title).getLocation().getY();
            TimeUnit.SECONDS.sleep(2);

            if (titlePositionY > 1000) {
                log.info("title Y 위치 = " + titlePositionY);

                Utils.dragSourceToTarget(titlePositionX, titlePositionY, titlePositionX, titlePositionY - 200);
            }

            if (titlePositionY < 350) {
                log.info("title Y 위치 = " + titlePositionY);

                Utils.dragSourceToTarget(titlePositionX, titlePositionY, titlePositionX, titlePositionY + 100);
            }

            //해당 타이틀 클릭
            AndroidManager.getElementByTextAfterSwipe(title).click();
            TimeUnit.SECONDS.sleep(2);

            //선택한 타이틀 영역에 포함된 첫번째 콘텐츠 클릭()
            log.info("AI맞춤 콘텐츠 클릭 --> //*[@text='" + title + "']/following-sibling::android.widget.FrameLayout");
            WebElement target = AndroidManager.getDriver()
                    .findElement(By.xpath("//*[@text='" + title + "']/following-sibling::android.widget.FrameLayout"));
            target.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 플레이어 종료하기
     * 플레이어 종류별 로직 분리
     */
    @When("플레이어 종료하기")
    public void 플레이어종료하기() {
        try {
            log.info("플레이어 종료하기");

            WebElement element;

            //[동영상 플레이어] 닫기
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btnBack");

                if (element.isDisplayed()) {
                    log.info("[동영상 플레이어] 닫기");
                    element.click();
                    AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/btn_confirm").click();
                    return;
                }
            } catch (Exception e) {
            }

            //[북클럽 플레이어] 닫기
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/groupCloseButton");

                if (element.isDisplayed()) {
                    log.info("[북클럽 플레이어] 닫기");
                    element.click();
                    return;
                }
            } catch (Exception e) {
            }

            //[북클럽 플레이어 미리보기] 닫기
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn");

                if (element.isDisplayed()) {
                    log.info("[북클럽 플레이어 미리보기] 닫기");
                    element.click();
                    return;
                }
            } catch (Exception e) {
            }

            //[북클럽 플레이어-멀티 터치북] 닫기
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/today_button_home");

                if (element.isDisplayed()) {
                    log.info("[북클럽 플레이어-멀티 터치북] 닫기");
                    element.click();
                    return;
                }
            } catch (Exception e) {
                try {
                    //멀티 터치북의 경우, 우측하단 썸네일 모음 버튼 클릭해야 상하단 영역 아이템 사용 가능
                    AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/btnBottomThumbnail").click();
                    AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/today_button_home").click();
                } catch (Exception ie) {}
            }

            //닫기버튼이 안보일 경우, viewer 클릭 후 [북클럽 플레이어] 닫기
            Utils.touchCenterInViewer(AndroidManager.getDriver());
            element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/groupCloseButton");
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 첫번째 과목 클릭
     */
    @When("교과 첫번째 과목 클릭")
    public void 교과첫번째과목클릭() {
        try {
            log.info("교과 첫번째 과목 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/curriculumTodayImageFrame").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 선택 교과 첫번째 콘텐츠 클릭
     * 콘텐츠 다운로드 시, 콘텐츠 실행 로직 한번더 처리
     */
    @When("선택 교과 첫번째 콘텐츠 클릭")
    public void 선택교과첫번째콘텐츠클릭() {
        try {
            log.info("선택 교과 첫번째 콘텐츠 클릭");

            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ibtnCurriculumBook1");
            element.click();

            //콘텐츠를 다운로드 하는 경우, 콘텐츠 한번 더 클릭하여 실행하기
            try {
                TimeUnit.SECONDS.sleep(1);

                if (element.findElement(By.id("com.wjthinkbig.mlauncher2:id/pb_download_view")).isDisplayed()) {
                    log.info("선택 교과 첫번째 콘텐츠 다운로드 후 다시 클릭");
                    TimeUnit.SECONDS.sleep(4);
                    element.click();
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
     * 교과 가이드 버튼 클릭
     */
    @When("교과 가이드 버튼 클릭")
    public void 교과가이드버튼클릭() {
        try {
            log.info("선택 교과 첫번째 콘텐츠 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/front_iv").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    /**
     * 독서 지난호 보기 버튼 클릭
     */
    @When("독서 지난호 보기 버튼 클릭")
    public void 독서지난호보기버튼클릭() {
        try {
            log.info("독서 지난호 보기 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnPrev").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 지난호 보기 n번재 콘텐츠 클릭
     */
    @When("독서 지난호 보기 {int}번째 콘텐츠 클릭")
    public void 독서지난호보기n번째콘텐츠클릭(int idx) {
        try {
            log.info("독서 지난호 보기 {}번째 항목 선택", idx);
            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rvPrevTodayList");
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/imgPrevToday")).get(idx).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 n번째 콘텐츠 클릭
     */
    @When("독서 {int}번째 콘텐츠 클릭")
    public void 독서n번째콘텐츠클릭(int idx) {
        try {
            log.info("독서 {}번째 콘텐츠 클릭", idx);

            //n번째 콘텐츠 element
            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/todayContainer");
            WebElement element = parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/selector_view")).get(idx);

            //콘텐츠 이미지가 backView인 경우, 콘텐츠 한번 더 클릭하여 frontView로 만든 후 실행하기
            try {
                WebElement backView = parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/back_view")).get(idx);

                if (backView.isDisplayed()) {
                    log.info("콘텐츠 이미지가 backView인 경우, 한번 클릭하여 frontView가 보여지도록 처리");
                    element.click();
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (Exception e) {
            }

            //콘텐츠 클릭
            element.click();

            //콘텐츠를 다운로드 하는 경우, 콘텐츠 한번 더 클릭하여 실행하기
            try {
                TimeUnit.SECONDS.sleep(1);

                if (parent.findElement(By.id("com.wjthinkbig.mlauncher2:id/pb_download_view")).isDisplayed()) {
                    log.info("선택 메인 첫번째 콘텐츠 다운로드 후 다시 클릭");
                    TimeUnit.SECONDS.sleep(6);
                    element.click();
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
     * 웅진북클럽 무료체험 참여 버튼 클릭
     */
    @When("웅진북클럽 무료체험 참여 버튼 클릭")
    public void 웅진북클럽무료체험참여버튼클릭() {
        try {
            log.info("웅진북클럽 무료체험 참여 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnTrial100").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 메타버스 콘텐츠 클릭
     */
    @When("메타버스 콘텐츠 클릭")
    public void 메타버스콘텐츠클릭() {
        try {
            log.info("메타버스 콘텐츠 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/front_iv").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 백과 콘텐츠 클릭
     */
    @When("백과 {string} 콘텐츠 클릭")
    public void 백과콘텐츠클릭(String contents) {
        try {
            log.info("백과 {} 콘텐츠 클릭", contents);

            AndroidManager.getElementByXpath("//android.view.View[@content-desc='" + contents + "']").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 타임챌린지 콘텐츠 클릭
     */
    @When("타임챌린지 콘텐츠 클릭")
    public void 타임챌린지콘텐츠클릭() {
        try {
            log.info("타임챌린지 콘텐츠 클릭");

            //다시보기 버튼 클릭
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.Button";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 타임챌린지 가이드 버튼 클릭
     */
    @When("타임챌린지 가이드 버튼 클릭")
    public void 타임챌린지가이드버튼클릭() {
        try {
            log.info("타임챌린지 가이드 버튼 클릭");

            //text: 가이드
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 대메뉴 하위 서브메뉴 초기화
     */
    @When("대메뉴 하위 서브메뉴 초기화")
    public void 대메뉴하위서브메뉴초기화() {
        try {
            log.info("대메뉴 하위 서브메뉴 초기화");

            //서브메뉴 클릭
            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[1]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
