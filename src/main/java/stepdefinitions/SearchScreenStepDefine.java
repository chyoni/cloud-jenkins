package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * 검색창, 검색결과 화면 내에서 이루어지는 작업에 대한 클래스
 * */
public class SearchScreenStepDefine {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 검색 화면 진입 > 검색창에 검색어 입력
     * @param searchText 검색어
     */
    @When("검색창에서 {string} 입력")
    public void enterSearchTextOnSearchBar(String searchText) {
        try {
            log.info("검색창에 {} 입력", searchText);
            WebElement inputText = AndroidManager.getElementById(Constant.검색창_id);
            inputText.sendKeys(searchText);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 검색 화면 진입 > 검색창의 검색 실행 버튼 클릭
     */
    @When("검색창에서 검색 실행 버튼 클릭")
    public void clickStartSearchBtn() {
        try {
            log.info("검색창에서 검색 실행 버튼 클릭");
            AndroidManager.getElementById(Constant.검색실행_id).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 검색결과 화면에서 독서 검색결과 섹션의 1번째 항목 선택
     * @param order 검색결과의 N번째 아이템
     */
    @When("검색결과 화면에서 독서 검색결과 섹션의 {int}번째 항목 선택")
    public void clickResultSearchItem(int order) {
        try {
            log.info("검색결과 화면에서 독서 검색결과 섹션의 {}번째 항목 선택", order);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.dictionary:id/root", order).click();
            TimeUnit.SECONDS.sleep(3);
            try {
                WebElement isFirstView = AndroidManager.getElementByIdUntilDuration(Constant.seeRightNowBtn_id, 4);
                if (isFirstView.isDisplayed()) isFirstView.click();

                WebElement isFirstOpen = AndroidManager.getElementById(Constant.helpViewLayout_id);
                if (isFirstOpen.isDisplayed()) AndroidManager.getElementById(Constant.helpViewXBtn_id).click();
            } catch (Exception e) {
                assertTrue(true);
            }
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 빠르게 독서 검색결과 섹션의 0번째 항목 선택
     */
    @When("빠르게 독서 검색결과 섹션의 {int}번째 항목 선택")
    public void clickFirstBookQuickly(int order) {
        try {
            log.info("빠르게 독서 검색결과 섹션의 0번째 항목 선택");
            log.info("검색결과 화면에서 독서 검색결과 섹션의 {}번째 항목 선택", order);
            AndroidManager.getElementsByIdAndIndex("com.wjthinkbig.dictionary:id/root", order).click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 검색결과 화면으로 이동 확인
     */
    @When("검색결과 화면으로 이동 확인")
    public void checkGoToSearchResultScreen() {
        try {
            log.info("검색결과 화면으로 이동 확인");
            WebElement searchBar = AndroidManager.getElementById(Constant.검색창_id);
            WebElement goSearchBtn = AndroidManager.getElementById(Constant.검색실행_id);

            if (searchBar.isDisplayed() && goSearchBtn.isDisplayed()) return;
            fail("검색화면으로 이동되지 않았습니다.");
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
