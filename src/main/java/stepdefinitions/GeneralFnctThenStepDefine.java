package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Constant;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class GeneralFnctThenStepDefine {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 독서앨범 화면구성 확인
     */
    @Then("독서앨범 화면구성 확인")
    public void 독서앨범화면구성확인() {
        try {
            log.info("독서앨범 화면구성 확인");

            //새소식/친구 작품 보기/내 작품 보기 탭 구성 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_news").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_friendswork").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/btn_tab_mywork").isDisplayed();

            assertTrue("독서앨범 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 콘텐츠 확인
     */
    @Then("독서앨범 새소식 콘텐츠 확인")
    public void 독서앨범새소식콘텐츠확인() {
        try {
            log.info("독서앨범 새소식 콘텐츠 확인");

            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_news_img");
                if (element.isDisplayed()) return;
            } catch (Exception e) {
            }

            //콘텐츠 확인 로직
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 추가 화면구성 확인
     */
    @Then("독서앨범 새소식 추가 화면구성 확인")
    public void 독서앨범새소식추가화면구성확인() {
        try {
            log.info("독서앨범 새소식 추가 화면구성 확인");

            //라이브러리/일기쓰기/카메라/학습투데이 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/menu_library").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/menu_diary").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/menu_camera").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/menu_study").isDisplayed();

            assertTrue("독서앨범 새소식 추가 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 라이브러리 메뉴 이동 확인
     */
    @Then("라이브러리 메뉴 이동 확인")
    public void 라이브러리메뉴이동확인() {
        try {
            log.info("라이브러리 메뉴 이동 확인");
            boolean isDisplayedContents =
                    AndroidManager.getElementByXpath(Constant.라이브러리_xPath).isSelected();
            assertTrue("라이브러리 메뉴가 선택되지 않았습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 새소식 추가 화면구성 확인
     */
    @Then("독서앨범 친구 작품 보기 화면구성 확인")
    public void 독서앨범친구작품보기화면구성확인() {
        try {
            log.info("독서앨범 친구 작품 보기 화면구성 확인");

            //감상문/사용자 오디오북/일기 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_report").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_useraudio").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_diary").isDisplayed();

            assertTrue("독서앨범 친구 작품 보기 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 친구 작품 보기 탭 화면구성 확인
     */
    @Then("독서앨범 친구 작품 보기 탭 화면구성 확인")
    public void 독서앨범친구작품보기탭화면구성확인() {
        try {
            log.info("독서앨범 친구 작품 보기 탭 화면구성 확인");

            //콘텐츠가 없는 경우, return
            try {
                boolean noData = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_data_text").isDisplayed();
                if(noData) return;
            } catch (Exception e) {}

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/detail_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/friend_another_works").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/friend_another_gridview").isDisplayed();

            assertTrue("독서앨범 친구 작품 보기 탭 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 화면구성 확인
     */
    @Then("독서앨범 내 작품 보기 화면구성 확인")
    public void 독서앨범내작품보기화면구성확인() {
        try {
            log.info("독서앨범 내 작품 보기 화면구성 확인");

            //화면 영역 확인
            boolean isDisplayedContents1 =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/my_info_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/my_works_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/child_fragment_container").isDisplayed();

            //작품 종류별 탭 구성 확인(감상문/사용자 오디오북/일기/사진/동영상/학습)
            boolean isDisplayedContents2 =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_report").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_useraudio").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_diary").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_photo").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_video").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/tab_study").isDisplayed();

            assertTrue("독서앨범 화면 영역이 확인되지 않습니다.", isDisplayedContents1);
            assertTrue("독서앨범 작품 종류별 탭 구성이 확인되지 않습니다.", isDisplayedContents2);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 내 작품 보기 탭 화면구성 확인
     */
    @Then("독서앨범 내 작품 보기 탭 화면구성 확인")
    public void 독서앨범내작품보기탭화면구성확인() {
        try {
            log.info("독서앨범 내 작품 보기 탭 화면구성 확인");

            try {
                //콘텐츠가 있는 경우에만 처리
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/no_content_view");
                if (element.isDisplayed()) return;
            } catch (Exception e) {
            }

            //동영상 탭의 경우
            try {
                boolean isDisplayedContents =
                        AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/titlebar").isDisplayed() &&
                                AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/content_viewpager").isDisplayed();

                assertTrue("독서앨범 내 작품 보기 탭 화면구성이 확인되지 않습니다.", isDisplayedContents);

                //뒤로가기 버튼 클릭
                AndroidManager.getElementById(Constant.commonBackButton_id).click();
            } catch (Exception e) {
            }

            try {
                boolean isDisplayedContents =
                        AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/content_panel").isDisplayed() &&
                                AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/right_area").isDisplayed();

                assertTrue("독서앨범 내 작품 보기 탭 화면구성이 확인되지 않습니다.", isDisplayedContents);

                //뒤로가기 버튼 클릭
                AndroidManager.getElementById(Constant.commonBackButton_id).click();
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
     * 검색 화면구성 확인
     */
    @Then("검색 화면구성 확인")
    public void 검색화면구성확인() {
        try {
            log.info("검색 화면구성 확인");

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.dictionary:id/txt_title_recently_keyword").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.dictionary:id/block_popular_keyword").isDisplayed();

            assertTrue("검색 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 스마트올 백과 실행 확인
     */
    @Then("스마트올 백과 실행 확인")
    public void 스마트올백과실행확인() {
        try {
            log.info("스마트올 백과 실행 확인");

            boolean isDisplayedContents = AndroidManager.getElementByXpath("//android.webkit.WebView[@content-desc=\"스마트올 백과\"]").isDisplayed();
            assertTrue("스마트올 백과 실행 화면이 아닙니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 스마트올 백과 연표 실행 확인
     */
    @Then("스마트올 백과 연표 실행 확인")
    public void 스마트올백과연표실행확인() {
        try {
            log.info("스마트올 백과 연표 실행 확인");

            String xpath = "//android.webkit.WebView[@content-desc=\"스마트올 백과\"]/android.view.View[1]/android.view.View[2]/android.view.View";
            boolean isDisplayedContents =
                    AndroidManager.getElementByXpath(xpath).isDisplayed();

            assertTrue("스마트올 백과 연표 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    /**
     * 설정 화면구성 확인
     */
    @Then("설정 화면구성 확인")
    public void 설정화면구성확인() {
        try {
            log.info("설정 화면구성 확인");

            //배터리/Wi-Fi/밝기/음량/공지이벤트/고객센터/약관및정책/기기설정/멤버십관련 구성 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_battery_title").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_wifi_title").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_light_title").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/tv_volume_title").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rl_event_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rl_customer_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rl_provision_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rc_device_list").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rc_mom_list").isDisplayed();

            assertTrue("설정 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 메뉴구성 확인
     */
    @Then("웅진 스마트올 메뉴구성 확인")
    public void 웅진스마트올메뉴구성확인() {
        try {
            log.info("웅진 스마트올 메뉴구성 확인");

            //업데이트 알림 창 뜨는 경우 닫기 처리
            try {
                WebElement element = AndroidManager.getElementById("com.wjthinkbig.minstaller2m:id/textview_app_update_noti");
                if (element.isDisplayed())
                    AndroidManager.getElementById("com.wjthinkbig.minstaller2m:id/imageview_clode").click();
            } catch (Exception e) {
            }

            //웅진 스마트올 화면구성 확인(accessibility id)
            boolean isDisplayedContents =
                    AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"오늘의 학습\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"AI 학습센터\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"초등 포털\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"전체과목\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"라이브러리\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"스타샵\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"검색\"]").isDisplayed() &&
                            AndroidManager.getElementByXpath("//android.widget.LinearLayout[@content-desc=\"올링고 번역\"]").isDisplayed();

            assertTrue("웅진 스마트올 메뉴구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 오늘의 학습 실행 확인
     */
    @Then("웅진 스마트올 오늘의 학습 실행 확인")
    public void 웅진스마트올오늘의학습실행확인() {
        try {
            log.info("웅진 스마트올 오늘의 학습 실행 확인");

            //오늘의 학습 화면구성을 통해 실행 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/llWeek").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/lnaGoalPointLayout").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/llappShortcut").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/llRecommand").isDisplayed();

            assertTrue("웅진 스마트올 오늘의 학습 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 AI 학습센터 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 AI 학습센터 실행 확인")
    public void 웅진스마트올AI학습센터AI학습센터실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 AI 학습센터 실행 확인");

            //학습 완료율 영역/오늘의 추천학습 영역/단원평가 점수 영역/받은 상 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/complete_rate_area_vg").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/todayArea_vg").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/unit_score_empty_vg").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/award_area_vg").isDisplayed();

            assertTrue("웅진 스마트올 AI 학습센터 AI 학습센터 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 방학 특강 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 방학 특강 실행 확인")
    public void 웅진스마트올AI학습센터방학특강실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 방학 특강 실행 확인");

            //코스 리스트 영역/코스 콘텐츠 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ll_course_list").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ll_content_area").isDisplayed();

            assertTrue("웅진 스마트올 AI 학습센터  방학 특강 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 영어 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 영어 실행 확인")
    public void 웅진스마트올AI학습센터영어실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 영어 실행 확인");

            //AI 학습하기 버튼/Word Score 영역/통합영어 목록보기 버튼/학습하기 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btn_aicenter_eng_words_study").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/bg_words").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/btn_aicenter_entt_list").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/txt_aicenter_entt_chap_name").isDisplayed();

            assertTrue("웅진 스마트올 AI 학습센터 영어 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 AI 연산 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 AI 연산 실행 확인")
    public void 웅진스마트올AI학습센터AI연산실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 AI 연산 실행 확인");

            //별도 앱이 오픈되는 경우, 메인화면 확인
            try {
                boolean isDisplayedContents =
                        AndroidManager.getElementByXpath("//*[@resource-id='app_main']").isDisplayed();
                assertTrue("웅진 스마트올 AI 학습센터 AI 연산 실행이 확인되지 않습니다.", isDisplayedContents);
                return;
            } catch (Exception e) {
            }

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ll_math_use").isDisplayed();
            assertTrue("웅진 스마트올 AI 학습센터 AI 연산 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }

    }

    /**
     * 웅진 스마트올 AI 학습센터 독서 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 독서 실행 확인")
    public void 웅진스마트올AI학습센터독서실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 독서 실행 확인");

            //추천도서 영역/필독서 영역/프리미엄 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/suggestionArea_vg").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/mustReadArea_vg").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/premiumArea_vg").isDisplayed();

            assertTrue("웅진 스마트올 AI 학습센터 독서 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 AI 학습센터 공부지원게임 실행 확인
     */
    @Then("웅진 스마트올 AI 학습센터 공부지원게임 실행 확인")
    public void 웅진스마트올AI학습센터공부지원게임실행확인() {
        try {
            log.info("웅진 스마트올 AI 학습센터 공부지원게임 실행 확인");

            //학교공부 도와줘 영역/패턴 게임 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/sa_aicenter_support_aischool_list").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/sa_aicenter_support_aipattern_list").isDisplayed();

            assertTrue("웅진 스마트올 AI 학습센터 공부지원게임 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 초등 포털 실행 확인
     */
    @Then("웅진 스마트올 초등 포털 실행 확인")
    public void 웅진스마트올초등포털실행확인() {
        try {
            log.info("웅진 스마트올 초등 포털 실행 확인");

            //메인 영역/사자성어 퀴즈 영역/English TV 영역/3분 회화 영역/투표 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layoutPopular").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layoutQuiz").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/ivEnglishTv").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layoutEnglish1Min").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/layoutVoting").isDisplayed();

            assertTrue("웅진 스마트올 초등 포털 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 전체과목 실행 확인
     */
    @Then("웅진 스마트올 전체과목 실행 확인")
    public void 웅진스마트올전체과목실행확인() {
        try {
            log.info("웅진 스마트올 전체과목 실행 확인");

            //학년 영역/내용 영역 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/rv_grade").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/container_fragment").isDisplayed();

            assertTrue("웅진 스마트올 전체과목 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 스타샵 실행 확인
     */
    @Then("웅진 스마트올 스타샵 실행 확인")
    public void 웅진스마트올스타샵실행확인() {
        try {
            log.info("웅진 스마트올 스타샵 실행 확인");

            //백그라운드 이미지로 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.mlauncher2:id/view_cloud_bg").isDisplayed();

            assertTrue("웅진 스마트올 스타샵 실행이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 웅진 스마트올 올링고 번역 실행 확인
     */
    @Then("웅진 스마트올 올링고 번역 실행 확인")
    public void 웅진스마트올올링고번역실행확인() {
        try {
            log.info("웅진 스마트올 올링고 번역 실행 확인");

            //카드뷰/올링고 타이틀 이미지 확인
            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.nfalllingo:id/cardView").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.nfalllingo:id/imgAllLingo").isDisplayed();

            assertTrue("웅진 스마트올 올링고 번역 실행이 확인되지 않습니다.", isDisplayedContents);

            //올링고 번역 창 닫기
            AndroidManager.getElementById("com.wjthinkbig.nfalllingo:id/btnExit").click();
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * 독서앨범 동영상 실행 확인
     */
    @Then("독서앨범 동영상 실행 확인")
    public void 독서앨범동영상실행확인() {
        try {
            log.info("독서앨범 동영상 실행 확인");

            boolean isDisplayed = AndroidManager.getElementById("com.wjthinkbig.mvideo2:id/player_view").isDisplayed();
            assertTrue("동영상이 정상적으로 실행되지 않았습니다.", isDisplayed);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }
}
