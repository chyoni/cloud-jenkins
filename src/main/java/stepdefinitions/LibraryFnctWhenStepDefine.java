package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;
import utils.Utils;

import java.util.concurrent.TimeUnit;

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
            log.info("홈 > 라이브러리 > 서브메뉴 {} 클릭", menu);

            //서브메뉴 클릭
            int index = 0;
            String rId = "";
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
                    rId = "com.wjthinkbig.mlauncher2:id/imgMenuAll";
                    break;
            }

            if(index == 7) {
                AndroidManager.getElementById(rId).click();
                //[버그인듯함]즐겨찾기가 선택되어 있으면, 전체메뉴 다시 한번 선택
                if(AndroidManager.getElementByXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[6]").isSelected()) {
                    log.info("[버그인듯함]즐겨찾기가 선택되어 있으면, 전체메뉴 다시 한번 선택");
                    AndroidManager.getElementById(rId).click();
                }
            } else {
                String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[" + index + "]";
                AndroidManager.getElementByXpath(xpath).click();
            }
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
            log.info("라이브러리 홈 {} 콘텐츠 클릭", title);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(5);

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
            log.info("라이브러리 홈 투데이 라이브러리 {} 콘텐츠 클릭", title);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

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
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

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
            log.info("라이브러리 홈 분야 전체 콘텐츠 클릭, {}", title);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

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
                    break;
                case "Animation":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg07";
                    break;
                case "Storybook":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg08";
                    break;
                case "Readers":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg09";
                    break;
                case "플레이북":
                    rId = "com.wjthinkbig.mlauncher2:id/categoryImg10";
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
            log.info("라이브러리 홈 추천 키워드 {} 콘텐츠 클릭", type);

            //화면 하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

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
            log.info("라이브러리 마이 서브메뉴 {} 클릭", menu);

            AndroidManager.getDriver()
                    .findElement(By.xpath("//*[@text='" + menu + "']/following-sibling::android.widget.ImageView"))
                    .click();
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
            log.info("라이브러리 마이 낱권 서브메뉴 {} 클릭", menu);

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

            String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
            String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, 0).click();
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, 1).click();
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
            log.info("라이브러리 마이 세트의 서브 메뉴 {} 클릭", menu);

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

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if (noData) return;
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
            String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
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
     * 라이브러리 마이 세트 특정 메뉴 팝업에서 첫번째 콘텐츠 클릭
     */
    @When("라이브러리 마이 세트 {string} 메뉴 팝업에서 첫번째 콘텐츠 클릭")
    public void 라이브러리마이세트팝업에서첫번째콘텐츠클릭(String menu) {
        try {
            log.info("라이브러리 마이 세트 {} 메뉴 팝업에서 첫번째 콘텐츠 클릭", menu);

            //첫번째 콘텐츠 element
            switch (menu) {
                case "전체":
                    AndroidManager.getElementsByIdsAndIndex("com.wjthinkbig.mlauncher2:id/setdialog_contents_recyclerview", "com.wjthinkbig.mlauncher2:id/contentsImg", 0)
                            .click();
                    break;
                case "소리동요":
                    //전체듣기 버튼 클릭 -> 전체선택 체크 -> 듣기 버튼 클릭
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btn_all_download").click();
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/numberAllCheckImg").click();
                    TimeUnit.SECONDS.sleep(3);
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btn_all_download").click();
                    break;
                case "소리동화":
                    //콘텐츠 확인 필요
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
     * 라이브러리 마이 세트 팝업창 닫기
     */
    @When("라이브러리 마이 세트 팝업창 닫기")
    public void 라이브러리마이세트팝업창닫기() {
        try {
            log.info("라이브러리 마이 세트 팝업창 닫기");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if(noData) return;
            } catch (Exception e) {}

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
            log.info("라이브러리 우리아이 책장 - 읽은 종이책 {} 등록", title);

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

            String parentId = "com.wjthinkbig.bookcase:id/bookcase_recycler_view";
            String childId = "com.wjthinkbig.bookcase:id/bookcase_item_area";
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

            //".*:id/recyclerView" 영역에서 swipe 처리
            AndroidManager.getElementByTextContainsAfterSwipe(".*:id/recyclerView", menu).click();
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
            log.info("라이브러리 투데이도서 투데이 서브메뉴 {} 클릭", menu);

            //메뉴 개행문자 추가
            int menuHeight = 90;
            switch (menu) {
                case "스마트 독서 투데이":
                    menu = menu.replace(menu, "스마트 독서\n투데이");
                    break;
                case "10–13세 고전/명작":
                    //menu = menu.replace(menu, "10-13세\n고전/명작");
                    menu = menu.replace(menu, "10–13세\n고전/명작");
                    break;
            }

            //".*:id/recyclerView" 영역에서 swipe 처리
            AndroidManager.getElementByTextContainsAfterSwipe(".*:id/recyclerView", menu).click();
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
                if (noData) return;
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
            String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
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
     * 라이브러리 투데이도서 유형 서브메뉴 클릭
     */
    @When("라이브러리 투데이도서 유형 {string} 서브메뉴 클릭")
    public void 라이브러리투데이도서유형서브메뉴클릭(String menu) {
        try {
            log.info("라이브러리 투데이도서 유형 {} 서브메뉴 클릭", menu);

            //".*:id/recyclerView" 영역에서 swipe 처리
            AndroidManager.getElementByTextContainsAfterSwipe(".*:id/recyclerView", menu).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 학습연계도서 서브메뉴 클릭
     */
    @When("라이브러리 학습연계도서 {string} 서브메뉴 클릭")
    public void 라이브러리학습연계도서서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 학습연계도서 서브메뉴 {} 클릭", menu);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 0;
                    break;
                case "이북":
                    index = 1;
                    break;
                case "오디오 이북":
                    index = 2;
                    break;
                case "멀티 터치북":
                    index = 3;
                    break;
                case "동영상":
                    index = 4;
                    break;
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/recyclerView";
            String childId = "com.wjthinkbig.mlauncher2:id/title";
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
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
            log.info("홈 > 라이브러리 > 학습연계도서 서브메뉴 {} 클릭", menu);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 0;
                    break;
                case "이북":
                    index = 1;
                    break;
                case "오디오 이북":
                    index = 2;
                    break;
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/recyclerView";
            String childId = "com.wjthinkbig.mlauncher2:id/title";
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
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
        try {
            log.info("라이브러리 내가 만든 오디오북 첫번째 콘텐츠 클릭");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if (noData) return;
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
            String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
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
     * 라이브러리 즐겨찾기 서브메뉴 클릭
     */
    @When("라이브러리 즐겨찾기 {string} 서브메뉴 클릭")
    public void 라이브러리즐겨찾기서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 즐겨찾기 서브메뉴 {} 클릭", menu);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "전체":
                    index = 0;
                    break;
                case "이북":
                    index = 1;
                    break;
                case "오디오 이북":
                    index = 2;
                    break;
                case "멀티 터치북":
                    index = 3;
                    break;
                case "동영상":
                    index = 4;
                    break;
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/recyclerView";
            String childId = "com.wjthinkbig.mlauncher2:id/title";
            AndroidManager.getElementsByIdsAndIndex(parentId, childId, index).click();
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
        try {
            log.info("라이브러리 즐겨찾기 첫번째 콘텐츠 클릭");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/no_data").isDisplayed();
                if (noData) return;
            } catch (Exception e) {
            }

            String parentId = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
            String childId = "com.wjthinkbig.mlauncher2:id/contentsImg";
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
     * 앱 라이브러리 첫번째 동영상 클릭
     */
    @When("앱 라이브러리 첫번째 동영상 클릭")
    public void 앱라이브러리첫번째동영상클릭() {
        try {
            log.info("앱 라이브러리 첫번째 동영상 클릭");

            WebElement parent = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/liContents");
            parent.findElements(By.className("android.widget.LinearLayout")).get(0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 마이 라이브러리 서브메뉴 클릭
     */
    @When("라이브러리 전체메뉴 마이 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴마이라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 마이 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(2);

            //서브메뉴 클릭
            String rId = "";
            switch (menu) {
                case "마이":
                    rId = "com.wjthinkbig.mlauncher2:id/img01";
                    break;
                case "투데이도서":
                    rId = "com.wjthinkbig.mlauncher2:id/img02";
                    break;
                case "학습연계도서":
                    rId = "com.wjthinkbig.mlauncher2:id/img03";
                    break;
                case "내가 만든 오디오북":
                    rId = "com.wjthinkbig.mlauncher2:id/img04";
                    break;
                case "즐겨찾기":
                    rId = "com.wjthinkbig.mlauncher2:id/img05";
                    break;
            }

            AndroidManager.getElementsByIdAndIndex(rId, 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 스마트올 5,6세 라이브러리 서브메뉴 클릭
     */
    @When("라이브러리 전체메뉴 스마트올 5,6세 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴스마트올세라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 스마트올 5,6세 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "얼렁뚱땅 코딩":
                    index = 0;
                    break;
                case "생생 자연관찰":
                    index = 1;
                    break;
                case "몽글몽글 과학":
                    index = 2;
                    break;
                case "뚝딱뚝딱 요리":
                    index = 3;
                    break;
                case "구석구석 탐험":
                    index = 4;
                    break;
                case "두근두근 직업":
                    index = 5;
                    break;
                case "둥글둥글 생활":
                    index = 6;
                    break;
                case "쭈욱쭈욱 체육":
                    index = 7;
                    break;
                case "조심조심 안전":
                    index = 8;
                    break;
                case "스스로 척척":
                    index = 9;
                    break;
                case "스마트올송":
                    index = 10;
                    break;
                case "쓱쓱싹싹 미술":
                    index = 11;
                    break;
                case "룰루랄라 음악":
                    index = 12;
                    break;
                case "책 놀이":
                    index = 13;
                    break;
                case "All 도서관":
                    index = 14;
                    break;
                case "추천 키워드 도서":
                    index = 15;
                    break;
                case "All 영상":
                    index = 16;
                    break;
                case "All 동요":
                    index = 17;
                    break;
            }

            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/smartAllLibraryRecyclerView");
            element.findElements(By.id("com.wjthinkbig.mlauncher2:id/sub_img")).get(index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 스마트올 키즈 라이브러리 서브메뉴 클릭
     */
    @When("라이브러리 전체메뉴 스마트올 키즈 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴스마트올키즈라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 스마트올 키즈 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

            //해당 영역으로 위치 이동
            Utils.dragSourceToTarget(870, 1100, 870, 350);
            TimeUnit.SECONDS.sleep(1);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "English Song":
                    index = 0;
                    break;
                case "재미재미 한자 영상":
                    index = 1;
                    break;
                case "얼렁뚱땅 코딩":
                    index = 2;
                    break;
                case "구석구석 탐험":
                    index = 3;
                    break;
                case "두근두근 직업":
                    index = 4;
                    break;
                case "시시콜콜한국사":
                    index = 5;
                    break;
                case "쭈욱쭈욱 체육":
                    index = 6;
                    break;
                case "쓱쓱싹싹 미술":
                    index = 7;
                    break;
                case "룰루랄라 음악":
                    index = 8;
                    break;
                case "자신만만 취미":
                    index = 9;
                    break;
                case "나 홀로 학교에":
                    index = 10;
                    break;
                case "두근두근 학교에 가면":
                    index = 11;
                    break;
                case "스스로 척척":
                    index = 12;
                    break;
                case "말짱 인기짱 프로젝트":
                    index = 13;
                    break;
                case "조심조심 안전":
                    index = 14;
                    break;
                case "생생 자연관찰":
                    index = 15;
                    break;
                case "몽글몽글 과학":
                    index = 16;
                    break;
            }

            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/smartAllLibraryRecyclerView");
            element.findElements(By.id("com.wjthinkbig.mlauncher2:id/sub_img")).get(index).click();

//            String xpath = "//*[contains(@class, 'androidx.recyclerview.widget.RecyclerView')]/preceding-sibling::*[@text='스마트올 키즈 라이브러리']";
//            WebElement element = AndroidManager.getDriver().findElement(By.xpath(xpath));
//            element.findElements(By.id("com.wjthinkbig.mlauncher2:id/sub_img")).get(index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 스마트올 라이브러리 서브메뉴 클릭
     */
    @And("라이브러리 전체메뉴 스마트올 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴스마트올라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 스마트올 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최상단으로 이동
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.DOWN);
            TimeUnit.SECONDS.sleep(1);

            //해당 영역으로 위치 이동
            Utils.dragSourceToTarget(870, 1100, 870, 350);
            TimeUnit.SECONDS.sleep(1);
            Utils.dragSourceToTarget(870, 900, 870, 450);
            TimeUnit.SECONDS.sleep(1);

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "초등필독서":
                    index = 0;
                    break;
                case "교과서 수록 도서":
                    index = 1;
                    break;
                case "기관 추천 어린이 도서":
                    index = 2;
                    break;
                case "기관 추천 청소년 도서":
                    index = 3;
                    break;
                case "초등교양서":
                    index = 4;
                    break;
                case "수준별 영어 도서관":
                    index = 5;
                    break;
                case "Disney":
                    index = 6;
                    break;
                case "영어TV":
                    index = 7;
                    break;
                case "BBC Kids":
                    index = 8;
                    break;
                case "nickelodeon":
                    index = 9;
                    break;
                case "McGraw-Hill":
                    index = 10;
                    break;
                case "ABDO":
                    index = 11;
                    break;
                case "BEARPORT":
                    index = 12;
                    break;
                case "프리미엄 원서 마스터":
                    index = 13;
                    break;
                case "독해완성":
                    index = 14;
                    break;
                case "시시콜콜한국사":
                    index = 15;
                    break;
                case "몽글몽글 과학":
                    index = 16;
                    break;
                case "룰루랄라예체능":
                    index = 17;
                    break;
                case "슬기로운초등생활":
                    index = 18;
                    break;
                case "자신만만 취미":
                    index = 19;
                    break;
                case "우리끼리랭킹":
                    index = 20;
                    break;
                case "두근두근 직업":
                    index = 21;
                    break;
                case "콩닥콩닥 초등 준비":
                    index = 22;
                    break;
                case "VR 한국사":
                    index = 23;
                    break;
                case "Song & Toon":
                    index = 24;
                    break;
                case "인물별 한국사":
                    index = 25;
                    break;
                case "코딩학습_첫걸음":
                    index = 26;
                    break;
                case "코딩학습_기초":
                    index = 27;
                    break;
                case "코딩학습_응용":
                    index = 28;
                    break;
            }

            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/smartAllLibraryRecyclerView");
            element.findElements(By.id("com.wjthinkbig.mlauncher2:id/sub_img")).get(index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 교과 라이브러리 서브메뉴 클릭
     */
    @And("라이브러리 전체메뉴 교과 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴교과라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 교과 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

            //해당 영역으로 위치 이동
            Utils.dragSourceToTarget(870, 350, 870, 900);
            TimeUnit.SECONDS.sleep(1);

            //서브메뉴 클릭
            String rId = "";
            switch (menu) {
                case "누리과정 연계도서":
                    rId = "com.wjthinkbig.mlauncher2:id/img01";
                    break;
                case "초등교과 연계도서":
                    rId = "com.wjthinkbig.mlauncher2:id/img02";
                    break;
                case "중등 필독서":
                    rId = "com.wjthinkbig.mlauncher2:id/img03";
                    break;
            }

            AndroidManager.getElementsByIdAndIndex(rId, 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 투데이 라이브러리 서브메뉴 클릭
     */
    @And("라이브러리 전체메뉴 투데이 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴투데이라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 투데이 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

            //해당 영역으로 위치 이동
            Utils.dragSourceToTarget(870, 350, 870, 730);
            TimeUnit.SECONDS.sleep(1);

            //서브메뉴 클릭
            String rId = "";
            switch (menu) {
                case "역사":
                    rId = "com.wjthinkbig.mlauncher2:id/img01";
                    break;
                case "스마트독서":
                    rId = "com.wjthinkbig.mlauncher2:id/img02";
                    break;
                case "토이":
                    rId = "com.wjthinkbig.mlauncher2:id/img03";
                    break;
            }

            AndroidManager.getElementsByIdAndIndex(rId, 0).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 전체메뉴 독서 라이브러리 서브메뉴 클릭
     */
    @And("라이브러리 전체메뉴 독서 라이브러리 {string} 서브메뉴 클릭")
    public void 라이브러리전체메뉴독서라이브러리서브메뉴클릭(String menu) {
        try {
            log.info("홈 > 라이브러리 > 전체메뉴 독서 라이브러리 서브메뉴 {} 클릭", menu);

            //화면 최하단으로 이동
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);
            Utils.swipeScreen(Utils.Direction.UP);
            TimeUnit.SECONDS.sleep(1);

            //해당 영역으로 위치 이동
            if(!menu.equals("유아학습") && !menu.equals("Interactive Book")) {
                Utils.dragSourceToTarget(870, 350, 870, 550);
                TimeUnit.SECONDS.sleep(1);
            }

            //서브메뉴 클릭
            int index = 0;
            switch (menu) {
                case "추천 키워드":
                    index = 0;
                    break;
                case "분야 전체":
                    index = 1;
                    break;
                case "새로나온 콘텐츠":
                    index = 2;
                    break;
                case "교과서 수록 도서":
                    index = 3;
                    break;
                case "기관 추천 어린이 도서":
                    index = 4;
                    break;
                case "기관 추천 청소년 도서":
                    index = 5;
                    break;
                case "인터랙티브북":
                    index = 6;
                    break;
                case "AR Science":
                    index = 7;
                    break;
                case "Animation":
                    index = 8;
                    break;
                case "Storybook":
                    index = 9;
                    break;
                case "Readers":
                    index = 10;
                    break;
                case "플레이북":
                    index = 11;
                    break;
                case "그림책":
                    index = 12;
                    break;
                case "문학":
                    index = 13;
                    break;
                case "백과":
                    index = 14;
                    break;
                case "인성•철학":
                    index = 15;
                    break;
                case "과학/수학":
                    index = 16;
                    break;
                case "사회/문화":
                    index = 17;
                    break;
                case "인물":
                    index = 18;
                    break;
                case "역사":
                    index = 19;
                    break;
                case "아트":
                    index = 20;
                    break;
                case "뮤직":
                    index = 21;
                    break;
                case "토이":
                    index = 22;
                    break;
                case "만화":
                    index = 23;
                    break;
                case "중고등 필독서":
                    index = 24;
                    break;
                case "앱":
                    index = 25;
                    break;
                case "투데이":
                    index = 26;
                    break;
                case "생활주제책읽기":
                    index = 27;
                    break;
                case "안전•생활 습관":
                    index = 28;
                    break;
                case "의사소통":
                    index = 29;
                    break;
                case "사회관계":
                    index = 30;
                    break;
                case "자연탐구":
                    index = 31;
                    break;
                case "예술경험":
                    index = 32;
                    break;
                case "신체운동건강":
                    index = 33;
                    break;
                case "맘스클럽":
                    index = 34;
                    break;
                case "초등학습":
                    index = 35;
                    break;
                case "유아학습":
                    index = 30;
                    break;
                case "Interactive Book":
                    index = 31;
                    break;
            }

            WebElement element = AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/readingLibraryRecyclerView");
            element.findElements(By.id("com.wjthinkbig.mlauncher2:id/sub_img")).get(index).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
