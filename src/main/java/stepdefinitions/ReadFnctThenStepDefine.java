package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ReadFnctThenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * AI맞춤 투데이 화면구성을 주어진 Title로 확인
     *
     * @param contents 화면에 보여지는 Title들을 구분자로 연결한 정보
     */
    @Then("AI맞춤 투데이 화면구성 {string} 확인")
    public void ai맞춤투데이화면구성확인(String contents) {
        try {
            log.info("AI맞춤 투데이 화면구성 확인, {}", contents);

            String[] titleArr = contents.split("-");

            //화면에 해당 타이틀의 콘텐츠가 보여지는지 확인
            String title;
            for (int i = 0; i < titleArr.length; i++) {
                title = titleArr[i].trim();
                log.info("---> " + i + " 번째 title : " + title);

                //콘텐츠가 포함되어 있는 특정 영역(".*:id/recyclerView" 영역)에서 swipe 처리
                boolean isDisplayedContents = AndroidManager.getElementByTextContainsAfterSwipe(".*:id/recyclerView", title).isDisplayed();
                assertTrue(isDisplayedContents);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 플레이어 실행 확인(플레이어 종류별 대표 아이템 노출 여부로 실행 확인)
     */
    @Then("플레이어 실행 확인")
    public void 플레이어실행확인() {
        try {
            log.info("플레이어 실행 확인");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if(noData) return;
            } catch (Exception e) {}

            //확인되지 않는 파일입니다. 메시지 보이는 경우, return
            try {
                String msg = "확인되지 않는 파일입니다.";
                String result = AndroidManager.getToastMessageByXpath(Constant.toast_xPath);
                if(result.contains(msg)) return;
            } catch (Exception e) {}

            //플레이어 실행 전, 가이드 화면이 보여지면 닫기
            WebElement element;
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/layout_help");

                if (element.isDisplayed()) {
                    log.info("플레이어 실행 전, 가이드 화면이 보여지면 닫기");
                    AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/button_help_close").click();
                    return;
                }
            } catch (Exception e) {
            }

            //플레이어 실행 전, 알림 메시지 팝업창이 보여지면 닫기
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/text_confirm_title");

                if (element.isDisplayed()) {
                    log.info("플레이어 실행 전, 알림 메시지 팝업창이 보여지면 닫기");
                    AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/btn_ok").click();
                    return;
                }
            } catch (Exception e) {
            }

            //[라이브러리-투데이도서] 플레이어 화면이 안뜨는 경우, "확인되지 않는 파일입니다." 메시지 확인 후, return
            try {
                //책권수/조회조건/삭제하기/정렬조건 확인
                boolean isDisplayedContents =
                        AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/delete_btn").isDisplayed() &&
                                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();

                //라이브러리 투데이도서 화면인 경우
                if (isDisplayedContents) {
                    //첫번째 콘텐츠 클릭
                    String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
                    String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
                    int index = 0;
                    AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();

                    //toast message 확인
                    String msg = "확인되지 않는 파일입니다.";
                    String result = AndroidManager.getToastMessageByXpath(Constant.toast_xPath);
                    if (result.contains(msg)) return;
                }
            } catch (Exception e) {}

            //[동영상 플레이어] 특정 레이아웃 노출 여부로 실행 확인
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_view");

                if (element.isDisplayed()) {
                    log.info("[동영상 플레이어] 확인 완료");
                    assertTrue("플레이어가 확인되지 않습니다.", true);
                    return;
                }
            } catch (Exception e) {
            }

            //[북클럽 플레이어] 특정 레이아웃 노출 여부로 실행 확인
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/layoutForRelationBookParent");

                if (element.isDisplayed()) {
                    log.info("[북클럽 플레이어] 확인 완료");
                    assertTrue("플레이어가 확인되지 않습니다.", true);
                    return;
                }
            } catch (Exception e) {
            }

            //[북클럽 플레이어-교과] 특정 레이아웃 노출 여부로 실행 확인
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/epubMainFrame");

                if (element.isDisplayed()) {
                    log.info("[북클럽 플레이어-교과] 확인 완료");
                    assertTrue("플레이어가 확인되지 않습니다.", true);
                    return;
                }
            } catch (Exception e) {
            }

            //[일반 플레이어-학습] 특정 레이아웃 노출 여부로 실행 확인
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.questionviewer:id/layoutMain");

                if (element.isDisplayed()) {
                    log.info("[일반 플레이어-학습] 확인 완료");
                    assertTrue("플레이어가 확인되지 않습니다.", true);
                    return;
                }
            } catch (Exception e) {
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            try {
                AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layout_setdialog_close").click();
            } catch (Exception ie) {
            }
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 투데이 화면구성 확인
     */
    @Then("교과 투데이 화면구성 확인")
    public void 교과투데이화면구성확인() {
        try {
            log.info("교과 투데이 화면구성 확인");

            //4개 과목(국어/수학/사회/과학) 배치 및 특정과목 콘텐츠 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/curriculumTodayImageFrame").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/curriculumTodayImageFrame2").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/curriculumTodayImageFrame3").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/curriculumTodayImageFrame4").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/vpCurriculumBook").isDisplayed(); //특정 과목 콘텐츠
            assertTrue("교과 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 교과 가이드 기능 확인
     */
    @Then("교과 가이드 화면구성 확인")
    public void 교과가이드화면구성확인() {
        try {
            log.info("교과 가이드 화면구성 확인");

            //화면 상단 아이템 노출 여부로 실행 확인
            WebElement element1;
            WebElement element2;
            try {
                element1 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/groupCloseButton");
                element2 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/txtPieceHeadTitle");

                if (element1.isDisplayed() && element2.isDisplayed()) {
                    log.info("교과 가이드 확인 완료");
                    assertTrue("교과 가이드가 확인되지 않습니다.", true);
                    return;
                }
            } catch (Exception e) {
            }

            //화면 상단 아이템이 노출되지 않을 경우, 콘텐츠 영역 터치 후 재확인
            log.info("콘텐츠 영역 터치 후, 상단영역 아이템 재확인");
            Utils.touchCenterInViewer(AndroidManager.getDriver());
            element1 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/groupCloseButton");
            element2 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/txtPieceHeadTitle");
            assertTrue("교과 가이드 화면구성이 확인되지 않습니다.", element1.isDisplayed() && element2.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서 지난호 보기 화면구성 확인
     */
    @Then("독서 지난호 보기 화면구성 확인")
    public void 독서지난호보기화면구성확인() {
        try {
            log.info("독서 지난호 보기 화면구성 확인");

            //팝업창 타이틀/닫기/지난호리스트 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/topTitle").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/closeBtn").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rvPrevTodayList").isDisplayed();
            assertTrue("독서 지난호 보기 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 메인 투데이 화면구성 확인
     */
    @Then("메인 투데이 화면구성 확인")
    public void 메인투데이화면구성확인() {
        try {
            log.info("메인 투데이 화면구성 확인");

            //연령/타이틀/무료체험참여버튼/지난호보기버튼 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tvAgeRange").isDisplayed()  &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tvTitle").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnTrial100").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnPrev").isDisplayed();
            assertTrue("메인 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 메인 콘텐츠 확인
     */
    @Then("메인 콘텐츠 확인")
    public void 메인콘텐츠확인() {
        try {
            WebElement element1 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/layout_today");
            WebElement element2 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/viewer");
            WebElement element3 = AndroidManager.getElementById("com.wjthinkbig.mepubviewer2:id/layout_thumbnail_container");

            //특정 레이아웃 노출 여부로 실행 확인
            try {
                if (element1.isDisplayed() & element2.isDisplayed() & element3.isDisplayed()) {
                    log.info("메인 콘텐츠 확인 완료");
                    assertTrue(true);
                    return;
                }
            } catch (Exception e) {
            }

            //위 조건들에 해당되지 않을 경우, 콘텐츠 영역 터치 후 실행 확인
            log.info("콘텐츠 영역 터치 후, 실행 확인");
            Utils.touchCenterInViewer(AndroidManager.getDriver());
            assertTrue("메인 콘텐츠가 확인되지 않습니다.", element1.isDisplayed() & element2.isDisplayed() & element3.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진북클럽 무료체험 참여 화면구성 확인
     */
    @Then("웅진북클럽 무료체험 참여 화면구성 확인")
    public void 웅진북클럽무료체험참여화면구성확인() {
        try {
            log.info("웅진북클럽 무료체험 참여 화면구성 확인");

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mbookstart:id/popup_title_textview").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mbookstart:id/linear_dialog_parent").isDisplayed();
            assertTrue("웅진북클럽 무료체험 참여 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 주제 투데이 화면구성 확인
     */
    @Then("주제 투데이 화면구성 확인")
    public void 주제투데이화면구성확인() {
        try {
            log.info("주제 투데이 화면구성 확인");

            //연령/타이틀/지난호보기버튼 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tvAgeRange").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tvTitle").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnPrev").isDisplayed();
            assertTrue("주제 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 메타버스 투데이 화면구성 확인
     */
    @Then("메타버스 투데이 화면구성 확인")
    public void 메타버스투데이화면구성확인() {
        try {
            log.info("메타버스 투데이 화면구성 확인");

            //타이틀/콘텐츠 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tvTitle").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/front_iv").isDisplayed();
            assertTrue("메타버스 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 메타버스 콘텐츠 확인
     */
    @Then("메타버스 콘텐츠 확인")
    public void 메타버스콘텐츠확인() {
        try {
            log.info("메타버스 콘텐츠 확인");

            boolean isDisplayedContents = AndroidManager.getElementById("com.wjthinkbig.virtualclass:id/unitySurfaceView").isDisplayed();
            assertTrue("메타버스 콘텐츠가 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 백과 투데이 화면구성 확인
     */
    @Then("백과 투데이 화면구성 확인")
    public void 백과투데이화면구성확인() {
        try {
            log.info("백과 투데이 화면구성 확인");

            boolean isDisplayedContents = AndroidManager.getElementByXpath("//android.view.View[@resource-id=\"wrap\"]").isDisplayed();
            assertTrue("백과 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진학습백과 실행 확인
     */
    @Then("웅진학습백과 실행 확인")
    public void 웅진학습백과실행확인() {
        try {
            log.info("웅진학습백과 실행 확인");

            boolean isDisplayedContents = AndroidManager.getElementByXpath("//android.view.View[@resource-id=\"bookDetail\"]").isDisplayed();
            assertTrue("웅진학습백과 실행 화면이 아닙니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 타임챌린지 투데이 화면구성 확인
     */
    @Then("타임챌린지 투데이 화면구성 확인")
    public void 타임챌린지투데이화면구성확인() {
        try {
            log.info("백과 투데이 화면구성 확인");

            //text="타임챌린지" 확인
            boolean isDisplayedContents = AndroidManager.getDriver().findElement(By.name("타임챌린지")).isDisplayed();
            assertTrue("타임챌린지 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 타임챌린지 콘텐츠 확인
     */
    @Then("타임챌린지 콘텐츠 확인")
    public void 타임챌린지콘텐츠확인() {
        try {
            log.info("타임챌린지 콘텐츠 확인");

            TimeUnit.SECONDS.sleep(5);

            //intro 확인
            boolean isDisplayedIntro =
                    AndroidManager.getElementById("intro0").isDisplayed() &&
                            AndroidManager.getElementById("intro1").isDisplayed() &&
                            AndroidManager.getElementById("intro2").isDisplayed();
            assertTrue("타임챌린지 intro가 확인되지 않습니다.", isDisplayedIntro);

            //팝업 닫기
            AndroidManager.getElementById("popupclose").click();

            //타임챌린지 콘텐츠 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("scrollGuide").isDisplayed() &&
                            AndroidManager.getElementById("intro1").isDisplayed() &&
                            AndroidManager.getElementById("intro2").isDisplayed();
            assertTrue("타임챌린지 콘텐츠가 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 타임챌린지 가이드 콘텐츠 확인
     */
    @Then("타임챌린지 가이드 콘텐츠 확인")
    public void 타임챌린지가이드콘텐츠확인() {
        //id : wrap
        try {
            log.info("타임챌린지 가이드 콘텐츠 확인");

            boolean isDisplayedContents = AndroidManager.getElementById("wrap").isDisplayed();
            assertTrue("타임챌린지 투데이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
