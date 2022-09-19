package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class LibraryFnctThenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 라이브러리 홈 화면구성을 주어진 Title로 확인
     *
     * @param contents 화면에 보여지는 Title들을 구분자로 연결한 정보
     */
    @Then("라이브러리 홈 화면구성 {string} 확인")
    public void 라이브러리홈화면구성확인(String contents) {
        try {
            log.info("라이브러리 홈 화면구성 확인");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            String[] titleArr = contents.split("-");

            //화면에 해당 타이틀의 콘텐츠가 보여지는지 확인
            String title;
            for (int i = 0; i < titleArr.length; i++) {
                title = titleArr[i].trim();
                log.info("---> " + i + " 번째 title : " + title);

                boolean isDisplayedContents = AndroidManager.getElementByTextAfterSwipe(title).isDisplayed();
                assertTrue(isDisplayedContents);
            }
        } catch (
                NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 리스트 확인
     *
     * @param title 라이브러리 홈의 특정 영역 타이틀
     */
    @Then("라이브러리 홈 {string} 리스트 확인")
    public void 라이브러리홈리스트확인(String title) {
        try {
            log.info("라이브러리 홈 특정 영역 콘텐츠 리스트 타이틀 {} 확인", title);

            //text 뒤에 trim()으로 제거되지 않는 공백이 있어 contains 이용
            boolean isDisplayedContents = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/titleArea").getText().trim().contains(title);
            assertTrue(isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 상세정보 팝업창에서 미리보기\(바로보기) 실행 확인
     */
    @Then("상세정보 팝업창에서 미리보기\\(바로보기) 실행 확인")
    public void 상세정보팝업창에서미리보기바로보실행확인() {
        try {
            log.info("상세정보 팝업창에서 미리보기(바로보기) 실행 확인");

            LibraryFnctWhenStepDefine lfw = new LibraryFnctWhenStepDefine();
            ReadFnctWhenStepDefine rfw = new ReadFnctWhenStepDefine();
            ReadFnctThenStepDefine rft = new ReadFnctThenStepDefine();

            WebElement element;

            //미리보기 버튼이 있을 경우, 미리보기 기능 실행 확인
            try {
                element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/previewBtn01");

                if (element.isDisplayed()) {
                    lfw.상세정보팝업창에서미리보기버튼클릭();
                    this.미리보기실행확인();
                    rfw.플레이어종료하기();
                    lfw.상세정보팝업창닫기버튼클릭();
                    lfw.추천키워드콘텐츠팝업닫기버튼클릭();
                    return;
                }
            } catch (Exception e) {
            }

            //미리보기 버튼이 없을 경우, 바로보기 기능 실행 확인
            lfw.상세정보팝업창에서바로보기버튼클릭();
            TimeUnit.SECONDS.sleep(3);
            rft.플레이어실행확인();
            rfw.플레이어종료하기();
            lfw.추천키워드콘텐츠팝업닫기버튼클릭();

        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 추천 도서 세트 콘텐츠 확인
     */
    @Then("라이브러리 홈 추천 도서 세트 콘텐츠 확인")
    public void 라이브러리홈추천도서세트콘텐츠확인() {
        try {
            log.info("라이브러리 홈 추천 도서 세트 콘텐츠 확인");

            //전체레이아웃/구성 버튼 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/compositionBtn").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/libraryFragment").isDisplayed();
            assertTrue("미리보기 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 투데이 라이브러리 콘텐츠 확인
     */
    @Then("라이브러리 홈 투데이 라이브러리-{string} 콘텐츠 확인")
    public void 라이브러리홈투데이라이브러리콘텐츠확인(String title) {
        try {
            log.info("라이브러리 홈 투데이 라이브러리 콘텐츠 타이틀 {} 확인", title);

            assertEquals(AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_top_title").getText().trim(), title);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    /**
     * 미리보기 실행 확인
     */
    @Then("미리보기 실행 확인")
    public void 미리보기실행확인() {
        try {
            log.info("미리보기 실행 확인");

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/titleArea").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/viewPager").isDisplayed();
            assertTrue("미리보기 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 인터랙티브북 상세정보 확인
     */
    @When("인터랙티브북 상세정보 확인")
    public void 인터랙티브북상세정보확인() {
        try {
            log.info("인터랙티브북 상세정보 확인");

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bookThumbnail").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/contentsInfo").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bookTitle").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/authorText").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/interactiveArea").isDisplayed();
            assertTrue("인터랙티브북 상세정보가 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 화면구성 확인
     */
    @Then("라이브러리 마이 {string} 화면구성 확인")
    public void 라이브러리마이화면구성확인(String menu) {
        try {
            log.info("라이브러리 마이 화면구성 확인");

            boolean isDisplayedContents = false;
            switch (menu) {
                case "낱권":
                    //메뉴스크롤뷰/책권수/조회조건(2가지)/삭제하기/정렬조건 확인
                    isDisplayedContents =
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bookmark_spinner").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/delete_btn").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();
                    break;
                case "세트":
                    //책권수/정렬조건 확인
                    isDisplayedContents =
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();
                    break;
            }

            assertTrue("라이브러리 마이 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 화면구성 확인
     */
    @Then("라이브러리 우리아이 책장 화면구성 확인")
    public void 라이브러리우리아이책장화면구성확인() {
        try {
            log.info("라이브러리 우리아이 책장 화면구성 확인");

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.bookcase:id/common_app_title").getText().equals("우리아이 책장") &&
                    AndroidManager.getElementById("com.wjthinkbig.bookcase:id/layout_tab").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_edit").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_book_register").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.bookcase:id/spinner_layout").isDisplayed();

            assertTrue(  "라이브러리 우리아이 책장 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 투데이도서 화면구성 확인
     */
    @Then("라이브러리 투데이도서 화면구성 확인")
    public void 라이브러리투데이도서화면구성확인() {
        try {
            log.info("라이브러리 투데이도서 화면구성 확인");

            //책권수/조회조건/삭제하기/정렬조건 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/delete_btn").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();

            assertTrue(  "라이브러리 투데이도서 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 학습연계도서 화면구성 확인
     */
    @Then("라이브러리 학습연계도서 화면구성 확인")
    public void 라이브러리학습연계도서화면구성확인() {
        try {
            log.info("라이브러리 학습연계도서 화면구성 확인");

            //책권수/조회조건/삭제하기/정렬조건 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/delete_btn").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();

            assertTrue(  "라이브러리 학습연계도서 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 내가 만든 오디오북 화면구성 확인
     */
    @Then("라이브러리 내가 만든 오디오북 화면구성 확인")
    public void 라이브러리내가만든오디오북화면구성확인() {
        try {
            log.info("라이브러리 내가 만든 오디오북 화면구성 확인");

            //책권수/조회조건/삭제하기/정렬조건 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/delete_btn").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();

            assertTrue(  "라이브러리 내가 만든 오디오북 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 즐겨찾기 화면구성 확인
     */
    @Then("라이브러리 즐겨찾기 화면구성 확인")
    public void 라이브러리즐겨찾기화면구성확인() {
        try {
            log.info("라이브러리 즐겨찾기 화면구성 확인");

            //책권수/조회조건/정렬조건 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/book_count").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/read_state_spinner").isDisplayed() &&
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/filter_radio_group").isDisplayed();

            assertTrue(  "라이브러리 즐겨찾기 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 화면구성 확인
     */
    @Then("라이브러리 전체메뉴 화면구성 확인")
    public void 라이브러리전체메뉴화면구성확인() {
        //com.wjthinkbig.mlauncher2:id/sub_title 의 text가 아래와 같이 구성되어 있는지 확인
        //마이 라이브러리, 스마트올 5,6세 라이브러리, 스마트올 키즈 라이브러리, 스마트올 라이브러리, 교과 라이브러리, 투데이 라이브러리, 독서 라이브러리
        try {
            log.info("라이브러리 전체메뉴 화면구성 확인");

            String contents = "마이 라이브러리, 스마트올 5,6세 라이브러리, 스마트올 키즈 라이브러리, 스마트올 라이브러리, 교과 라이브러리, 투데이 라이브러리, 독서 라이브러리";

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            String[] titleArr = contents.split("-");

            //화면에 해당 타이틀의 콘텐츠가 보여지는지 확인
            String title;
            for (int i = 0; i < titleArr.length; i++) {
                title = titleArr[i].trim();
                log.info("---> " + i + " 번째 title : " + title);

                boolean isDisplayedContents = AndroidManager.getElementByTextAfterSwipe(title).isDisplayed();
                assertTrue(isDisplayedContents);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
