package stepdefinitions;

import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;
import utils.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LibraryFnctWhenStepDefine {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 라이브러리 - 서브메뉴 클릭
     *
     * @param menu 라이브러리 메뉴의 하위 메뉴
     */
    @When("라이브러리 - {string} 서브메뉴 클릭")
    public void 라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 서브메뉴 클릭");

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "홈":
                    index = 1;
                    break;
                case "마이":
                    index = 2;
                    break;
                case "투데이도서":
                    index = 3;
                    break;
                case "학습연계도서":
                    index = 4;
                    break;
                case "내가 만든 오디오북":
                    index = 5;
                    break;
                case "즐겨찾기":
                    index = 6;
                    break;
                case "전체메뉴":
                    index = 7;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }


    /**
     * 라이브러리 홈 콘텐츠 클릭
     *
     * @param title 라이브러리 홈의 특정 영역 타이틀
     */
    @When("라이브러리 홈 {string} 콘텐츠 클릭")
    public void 라이브러리홈콘텐츠클릭(String title) {
        try {
            log.info("라이브러리 홈 콘텐츠 클릭");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            String rId = "";
            switch (title) {
                case "교과서 수록 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/reading_01_IV_OFF";
                    break;
                case "기관 추천 어린이 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/reading_02_IV_OFF";
                    break;
                case "기관 추천 청소년 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/reading_03_IV_OFF";
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
     * 뒤로가기 버튼 클릭
     */
    @When("투데이 라이브러리 뒤로가기 버튼 클릭")
    public void 투데이라이브러리뒤로가기버튼클릭() {
        try {
            log.info("투데이 라이브러리 뒤로가기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/close_btn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 추천 도서 세트 콘텐츠 클릭
     */
    @When("라이브러리 홈 추천 도서 세트 콘텐츠 클릭")
    public void 라이브러리홈추천도서세트콘텐츠클릭() {
        try {
            log.info("라이브러리 홈 추천 도서 세트 콘텐츠 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bannerImg01").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 투데이 라이브러리 콘텐츠 클릭
     */
    @When("라이브러리 홈 투데이 라이브러리-{string} 콘텐츠 클릭")
    public void 라이브러리홈투데이라이브러리역사콘텐츠클릭(String title) {
        try {
            log.info("라이브러리 홈 투데이 라이브러리 콘텐츠 클릭");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);

            String rId = "";
            switch (title) {
                case "역사":
                    rId = "com.wjthinkbig.mlauncher2:id/today_history";
                    break;
                case "스마트독서":
                    rId = "com.wjthinkbig.mlauncher2:id/today_smart";
                    break;
                case "토이":
                    rId = "com.wjthinkbig.mlauncher2:id/today_toy";
                    break;
            }

            //해당 id 클릭
            AndroidManager.getElementById(rId).click();

            //북클럽 메시지 팝업 뜨는 경우, 닫고 다시한번 콘텐츠 클릭
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.genie:id/lt_character");

                if (element.isDisplayed()) {
                    log.info("북클럽 메시지 팝업 닫은 후 해당 콘텐츠 재클릭");
                    AndroidManager.getElementById("com.wjthinkbig.genie:id/btn_close").click();

                    //해당 콘텐츠 클릭
                    AndroidManager.getElementById(rId).click();
                    return;
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
     * 라이브러리 홈 교과 라이브러리 콘텐츠 클릭
     */
    @When("라이브러리 홈 교과 라이브러리 콘텐츠 클릭")
    public void 라이브러리홈교과라이브러리콘텐츠클릭() {
        try {
            log.info("라이브러리 홈 교과 라이브러리 콘텐츠 클릭");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);

            //해당 콘텐츠 클릭
            AndroidManager.getDriver().findElements(By.id("com.wjthinkbig.mlauncher2:id/rv")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 초등 교과 연계 도서 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 홈 초등 교과 연계 도서 첫번째 콘텐츠 클릭")
    public void 라이브러리홈초등교과연계도서첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 홈 초등 교과 연계 도서 첫번째 콘텐츠 클릭");

            //첫번째 콘텐츠 element
            WebElement parent = AndroidManager.getDriver().findElements(By.id("com.wjthinkbig.mlauncher2:id/recyclerView")).get(0);
            WebElement element = parent.findElement(By.id("com.wjthinkbig.mlauncher2:id/rView"))
                    .findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(0);

            //해당 콘텐츠 클릭
            element.click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 분야 전체 콘텐츠 클릭
     */
    @When("라이브러리 홈 분야 전체 {string} 클릭")
    public void 라이브러리홈분야전체클릭(String title) {
        try {
            log.info("라이브러리 홈 분야 전체 콘텐츠 클릭");

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);
            Utils.swipeScreen(Utils.Direction.DOWN);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);

            String rId = "";
            switch (title) {
                case "새로나온 콘텐츠":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg01";
                    break;
                case "교과서 수록 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg02";
                    break;
                case "기관 추천 어린이 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg03";
                    break;
                case "기관 추천 청소년 도서":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg04";
                    break;
                case "인터랙티브북":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg05";
                    break;
                case "AR Science":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg06";

                    //화면 하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
                    break;
                case "Animation":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg07";

                    //화면 하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
                    break;
                case "Storybook":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg08";

                    //화면 하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
                    break;
                case "Readers":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg09";

                    //화면 하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
                    break;
                case "플레이북":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg10";

                    //화면 하단으로 이동
                    Utils.swipeScreen(Utils.Direction.UP);
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
     * 라이브러리 홈 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 홈 첫번째 콘텐츠 클릭")
    public void 라이브러리홈분야전체첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 홈 첫번째 콘텐츠 클릭");

            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.mlauncher2:id/contentsImg", 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 상세정보 팝업창에서 미리보기 버튼 클릭
     */
    @When("상세정보 팝업창에서 미리보기 버튼 클릭")
    public void 상세정보팝업창에서미리보기버튼클릭() {
        try {
            log.info("상세정보 팝업창에서 미리보기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/previewBtn01").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 뒤로가기 버튼 클릭
     */
    @When("라이브러리 뒤로가기 버튼 클릭")
    public void 라이브러리뒤로가기버튼클릭() {
        try {
            log.info("라이브러리 뒤로가기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/back_btn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 상세정보 팝업창 닫기 버튼 클릭
     */
    @When("상세정보 팝업창 닫기 버튼 클릭")
    public void 상세정보팝업창닫기버튼클릭() {
        try {
            log.info("상세정보 팝업창 닫기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/closeBtn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 상세정보 팝업창에서 책 썸네일 클릭
     */
    @When("상세정보 팝업창에서 책 썸네일 클릭")
    public void 상세정보팝업창에서책썸네일클릭() {
        try {
            log.info("상세정보 팝업창에서 책 썸네일 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bookThumbnail").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 상세정보 팝업창에서 바로보기 버튼 클릭
     */
    @When("상세정보 팝업창에서 바로보기 버튼 클릭")
    public void 상세정보팝업창에서바로보기버튼클릭() {
        try {
            log.info("상세정보 팝업창에서 바로보기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/downBtn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 홈 추천 키워드 콘텐츠 클릭
     */
    @When("라이브러리 홈 추천 키워드 {string} 클릭")
    public void 라이브러리홈추천키워드콘텐츠클릭(String type) {
        try {
            log.info("라이브러리 홈 추천 키워드 콘텐츠 클릭");

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);
            Utils.swipeScreen(Utils.Direction.UP);

            String rId = "";
            switch (type) {
                case "인기":
                    rId = "com.wjthinkbig.mlauncher2:id/best_img";
                    break;
                case "강추":
                    rId = "com.wjthinkbig.mlauncher2:id/recommend_img";
                    break;
                case "테마":
                    rId = "com.wjthinkbig.mlauncher2:id/theme_img";
                    break;
                case "가족":
                    rId = "com.wjthinkbig.mlauncher2:id/keyword_img01";
                    break;
                case "도시":
                    rId = "com.wjthinkbig.mlauncher2:id/keyword_img02";
                    break;
                case "도전":
                    rId = "com.wjthinkbig.mlauncher2:id/keyword_img03";
                    break;
                case "도형":
                    rId = "com.wjthinkbig.mlauncher2:id/keyword_img04";
                    break;
                case "돈":
                    rId = "com.wjthinkbig.mlauncher2:id/keyword_img05";
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
     * 라이브러리 홈 추천 키워드 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 홈 추천 키워드 첫번째 콘텐츠 클릭")
    public void 라이브러리홈추천키워드첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 홈 추천 키워드 첫번째 콘텐츠 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/keyword_img01").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 추천 키워드 콘텐츠 팝업 닫기 버튼 클릭
     */
    @When("추천 키워드 콘텐츠 팝업 닫기 버튼 클릭")
    public void 추천키워드콘텐츠팝업닫기버튼클릭() {
        try {
            log.info("추천 키워드 콘텐츠 팝업 닫기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/close_btn").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 서브메뉴 클릭
     */
    @When("라이브러리 마이 {string} 서브메뉴 클릭")
    public void 라이브러리마이서브메뉴클릭(String menu) {
        try {
            log.info("라이브러리 마이 서브메뉴 클릭");

            AndroidManager.getDriver()
                    .findElement(By.xpath("//*[@text='" + menu + "']/following-sibling::android.widget.ImageView"))
                    .click();

/*           int index = 0;
            switch (menu) {
                case "낱권":
                    index = 1;
                    break;
                case "세트":
                    //낱권의 서브메뉴가 모두 보여질 경우, 세트의 index = 7
                    WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]");
                    if (element.isDisplayed()) {
                        index = 7;
                    } else {
                        index = 2;
                    }
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
 */
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 낱권 서브메뉴 클릭
     */
    @When("라이브러리 마이 낱권 {string} 서브메뉴 클릭")
    public void 라이브러리마이낱권서브메뉴클릭(String menu) {
        try {
            log.info("라이브러리 마이 낱권 서브메뉴 클릭");

            int index = 0;
            switch (menu) {
                case "전체":
                    index = 2;
                    break;
                case "이북":
                    index = 3;
                    break;
                case "오디오 이북":
                    index = 4;
                    break;
                case "멀티 터치북":
                    index = 5;
                    break;
                case "동영상":
                    index = 6;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 낱권 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 마이 낱권 첫번째 콘텐츠 클릭")
    public void 라이브러리마이낱권첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 마이 낱권 첫번째 콘텐츠 클릭");

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 연속재생 버튼 클릭
     */
    @When("연속재생 버튼 클릭")
    public void 연속재생버튼클릭() {
        try {
            log.info("연속재생 버튼 클릭");
            AndroidManager.getElementById(Constant.continuePlayBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 알림팝업 우측 버튼 클릭
     */
    @When("알림팝업 우측 버튼 클릭")
    public void clickRBtnOnAlertPopup() {
        try {
            log.info("알림팝업 우측 버튼 클릭");
            AndroidManager.getElementById(Constant.rightBtn_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 연속재생 콘텐츠 선택
     */
    @When("연속재생 콘텐츠 선택")
    public void 연속재생콘텐츠선택() {
         try {
            log.info("연속재생 콘텐츠 선택");

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/contents_recyclerview");
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(0).click();
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(1).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 선택 항목 재생 알림창에서 확인 버튼 클릭
     */
    @When("선택 항목 재생 알림창에서 확인 버튼 클릭")
    public void 선택항목재생알림창에서확인버튼클릭() {
        try {
            log.info("선택 항목 재생 알림창에서 확인 버튼 클릭");
            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btnR").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 세트 메뉴 클릭
     */
    @When("라이브러리 마이 세트 {string} 메뉴 클릭")
    public void 라이브러리마이세트메뉴클릭(String menu) {
        try {
            log.info("라이브러리 마이 세트의 서브 메뉴 클릭");

            int index = 0;
            switch (menu) {
                case "전체":
                    index = 3;
                    break;
                case "소리동요":
                    index = 4;
                    break;
                case "소리동화":
                    index = 5;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 세트 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 마이 세트 첫번째 콘텐츠 클릭")
    public void 라이브러리마이세트첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 마이 세트 첫번째 콘텐츠 클릭");

            //첫번째 콘텐츠 element
            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/contents_recyclerview");
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 세트 팝업에서 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 마이 세트 팝업에서 첫번째 콘텐츠 클릭")
    public void 라이브러리마이세트팝업에서첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 마이 세트 팝업에서 첫번째 콘텐츠 클릭");

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/setdialog_contents_recyclerview");
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 마이 세트 팝업창 닫기
     */
    @When("라이브러리 마이 세트 팝업창 닫기")
    public void 라이브러리마이세트팝업창닫기() {
        try {
            log.info("라이브러리 마이 세트 팝업창 닫기");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layout_setdialog_close").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 버튼 클릭
     */
    @When("라이브러리 우리아이 책장 버튼 클릭")
    public void 라이브러리우리아이책장버튼클릭() {
        try {
            log.info("라이브러리 우리아이 책장 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/recyclerViewBanner").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 - 읽은 종이책 등록 버튼 클릭
     */
    @When("라이브러리 우리아이 책장 - 읽은 종이책 등록 버튼 클릭")
    public void 라이브러리우리아이책장읽은종이책등록버튼클릭() {
        try {
            log.info("라이브러리 우리아이 책장 - 읽은 종이책 등록 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_book_register").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 편집 버튼 클릭
     */
    @When("라이브러리 우리아이 책장 편집 버튼 클릭")
    public void 라이브러리우리아이책장편집버튼클릭() {
        try {
            log.info("라이브러리 우리아이 책장 편집 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_edit").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 - 읽은 종이책 등록
     */
    @When("라이브러리 우리아이 책장 - 읽은 종이책 {string} 등록")
    public void 라이브러리우리아이책장읽은종이책등록(String title) {
        try {
            log.info("라이브러리 우리아이 책장 - 읽은 종이책 등록");

            //직접입력하기 - 책제목 입력
            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/edittext_add_book_title").sendKeys(title);

            //검색한 책 선택
            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/check_auto_complete").click();

            //직접입력하기 - 등록 버튼 클릭
            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_add_offbook").click();

            //직접입력하기 - 등록 확인
            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_confirm").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 우리아이 책장 첫번째 콘텐츠 클릭")
    public void 라이브러리우리아이책장첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 우리아이 책장 첫번째 콘텐츠 클릭");

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.bookcase:id/bookcase_recycler_view");
            parent.findElements(By.id("com.wjthinkbig.bookcase:id/bookcase_item_area")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 삭제하기 버튼 클릭
     */
    @When("라이브러리 우리아이 책장 삭제하기 버튼 클릭")
    public void 라이브러리우리아이책장삭제하기버튼클릭() {
        try {
            log.info("라이브러리 우리아이 책장 삭제하기 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_delete").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 우리아이 책장 삭제 알림 확인 버튼 클릭
     */
    @When("라이브러리 우리아이 책장 삭제 알림 확인 버튼 클릭")
    public void 라이브러리우리아이책장삭제알림확인버튼클릭() {
        try {
            log.info("라이브러리 우리아이 책장 삭제 알림 확인 버튼 클릭");

            AndroidManager.getElementById("com.wjthinkbig.bookcase:id/btn_positive").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 투데이도서 서브메뉴 클릭
     * 투데이/유형
     */
    @When("라이브러리 투데이도서 {string} 서브메뉴 클릭")
    public void 라이브러리투데이도서서브메뉴클릭(String menu) {
        try {
            log.info("라이브러리 투데이도서 {} 서브메뉴 클릭", menu);

            //라이브러리 투데이도서 좌측 메뉴 영역 위치(리스트 초기화하거나 Next Memu으로 Swipe할 때 사용)
            WebElement source = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/recyclerView");
            int pointX = source.getLocation().x;
            int pointY = source.getLocation().y;
            log.info("라이브러리 좌측 메뉴 영역 위치 X : {}, Y : {}", pointX, pointY);

            Utils.dragSourceToTarget(pointX, pointY, pointX, pointY+900);

            AndroidManager.getDriver()
                    .findElement(By.xpath("//*[@text='" + menu + "']/following-sibling::android.widget.ImageView"))
                    .click();


 /*           int index = 0;
            switch (menu) {
                case "투데이":
                    index = 1;
                    break;
                case "유형":
                    //메뉴 최대 스크롤 필요 (text=menu 기준으로 스크롤하여 찾아갈지 추후 검토)

                    //투데이의 서브메뉴가 모두 보여질 경우, 유형 메뉴의 index = 11
                    WebElement element = AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[10]");
                    if (element.isDisplayed()) {
                        index = 11;
                    } else {
                        index = 2;
                    }
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();

  */
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 투데이도서 투데이 서브메뉴 클릭
     */
    @When("라이브러리 투데이도서 투데이 {string} 서브메뉴 클릭")
    public void 라이브러리투데이도서투데이서브메뉴클릭(String menu) {
        try {
            //메뉴 개행문자 제거
            String rMemu = menu;
            switch (menu) {
                case "스마트 독서 투데이":
                    rMemu = menu.replace(menu, "스마트 독서\n투데이");
                    break;
                case "10-13세 고전/명작":
                    rMemu = menu.replace(menu, "10-13세\n고전/명작");
                    break;
            }

            AndroidManager.getElementByTextAfterSwipe(rMemu).click();
/*
            int index = 0;
        switch (menu) {
            case "전체":
                index = 2;
                break;
            case "AI맞춤 투데이":
                index = 3;
                break;
            case "역사 투데이":
                index = 4;
                break;
            case "스페셜 투데이":
                index = 5;
                break;
            case "스마트 독서 투데이":
                index = 6;
                break;
            case "1-3세 투데이":
                index = 7;
                break;
            case "4-6세 투데이":
                index = 8;
                break;
            case "7-9세 투데이":
                index = 9;
                break;
            case "7-13세 투데이":
                index = 10;
                break;
            case "4-6세 융합":
                //메뉴 최대 스크롤 필요

                index = 3;
                break;
            case "7-9세 융합":
                //메뉴 최대 스크롤 필요

                index = 4;
                break;
            case "7-9세 시즌":
                //메뉴 최대 스크롤 필요

                index = 5;
                break;
            case "10-13세 고전/명작":
                //메뉴 최대 스크롤 필요

                index = 6;
                break;
            case "토이 투데이":
                //메뉴 최대 스크롤 필요

                index = 7;
                break;
            case "누리 투데이":
                //메뉴 최대 스크롤 필요

                index = 8;
                break;
            case "교과 투데이":
                //메뉴 최대 스크롤 필요

                index = 9;
                break;
            case "중등 투데이":
                //메뉴 최대 스크롤 필요

                index = 10;
                break;
        }

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
        AndroidManager.getElementByXpath(xpath).click();

 */
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 투데이도서 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 투데이도서 첫번째 콘텐츠 클릭")
    public void 라이브러리투데이도서첫번째콘텐츠클릭() {
        try {
            log.info("라이브러리 투데이도서 첫번째 콘텐츠 클릭");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if(noData) return;
            } catch (Exception e) {}

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/contents_recyclerview");
            parent.findElements(By.id("com.wjthinkbig.mlauncher2:id/contentsImg")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 투데이도서 유형 서브메뉴 클릭
     */
    @When("라이브러리 투데이도서 유형 {string} 서브메뉴 클릭")
    public void 라이브러리투데이도서유형서브메뉴클릭(String menu) {
        int index = 0;
        switch (menu) {
            case "전체":
                index = 3;
                break;
            case "이북":
                index = 4;
                break;
            case "오디오 이북":
                index = 5;
                break;
            case "멀티 터치북":
                index = 6;
                break;
            case "동영상":
                index = 7;
                break;
        }

        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
        AndroidManager.getElementByXpath(xpath).click();
    }

    /**
     * 라이브러리 학습연계도서 서브메뉴 클릭
     */
    @When("라이브러리 학습연계도서 {string} 서브메뉴 클릭")
    public void 라이브러리학습연계도서서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 학습연계도서 서브메뉴 클릭");

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 1;
                    break;
                case "이북":
                    index = 2;
                    break;
                case "오디오 이북":
                    index = 3;
                    break;
                case "멀티 터치북":
                    index = 4;
                    break;
                case "동영상":
                    index = 5;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 내가 만든 오디오북 서브메뉴 클릭
     */
    @When("라이브러리 내가 만든 오디오북 {string} 서브메뉴 클릭")
    public void 라이브러리내가만든오디오북서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 학습연계도서 서브메뉴 클릭");

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 1;
                    break;
                case "이북":
                    index = 2;
                    break;
                case "오디오 이북":
                    index = 3;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 내가 만든 오디오북 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 내가 만든 오디오북 첫번째 콘텐츠 클릭")
    public void 라이브러리내가만든오디오북첫번째콘텐츠클릭() {
        //com.wjthinkbig.mlauncher2:id/contents_recyclerview 의 첫번째 아이템 클릭하거나 아래 xpath 이용, 또는 com.wjthinkbig.mlauncher2:id/contentsImg 의 0번째
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]
    }

    /**
     * 라이브러리 즐겨찾기 서브메뉴 클릭
     */
    @When("라이브러리 즐겨찾기 {string} 서브메뉴 클릭")
    public void 라이브러리즐겨찾기서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 즐겨찾기 서브메뉴 클릭");

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 1;
                    break;
                case "이북":
                    index = 2;
                    break;
                case "오디오 이북":
                    index = 3;
                    break;
                case "멀티 터치북":
                    index = 4;
                    break;
                case "동영상":
                    index = 5;
                    break;
            }

            String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[" + index + "]";
            AndroidManager.getElementByXpath(xpath).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 즐겨찾기 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 즐겨찾기 첫번째 콘텐츠 클릭")
    public void 라이브러리즐겨찾기첫번째콘텐츠클릭() {
        //com.wjthinkbig.mlauncher2:id/contents_recyclerview 의 첫번째 아이템 클릭하거나 아래 xpath 이용, 또는 com.wjthinkbig.mlauncher2:id/contentsImg 의 0번째
        //xpath : /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]

    }

    /**
     * 라이브러리 첫번째 동영상 클릭
     */
    @When("라이브러리 첫번째 동영상 클릭")
    public void 라이브러리첫번째동영상클릭() {
        //com.wjthinkbig.mvideo2:id/liContents 의 index=0 클릭
    }

}
