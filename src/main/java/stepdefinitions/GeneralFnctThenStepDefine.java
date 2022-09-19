package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.AndroidManager;
import utils.Utils;

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

            assertTrue(  "독서앨범 화면구성이 확인되지 않습니다.", isDisplayedContents);
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
            } catch (Exception e) {}

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

            assertTrue(  "독서앨범 새소식 추가 화면구성이 확인되지 않습니다.", isDisplayedContents);
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

            assertTrue(  "독서앨범 화면구성이 확인되지 않습니다.", isDisplayedContents);
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

            boolean isDisplayedContents =
                    AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/detail_area").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/friend_another_works").isDisplayed() &&
                            AndroidManager.getElementById("com.wjthinkbig.thinkplayground:id/friend_another_gridview").isDisplayed();

            assertTrue(  "독서앨범 화면구성이 확인되지 않습니다.", isDisplayedContents);
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("독서앨범 내 작품 보기 화면구성 확인")
    public void 독서앨범내작품보기화면구성확인() {
        //화면 영역 확인
        //com.wjthinkbig.thinkplayground:id/my_info_area
        //com.wjthinkbig.thinkplayground:id/my_works_area
        //com.wjthinkbig.thinkplayground:id/child_fragment_container

        //작품 종류별 탭 구성 확인(감상문/사용자 오디오북/일기/사진/동영상/학습)
        //com.wjthinkbig.thinkplayground:id/tab_report
        //com.wjthinkbig.thinkplayground:id/tab_useraudio
        //com.wjthinkbig.thinkplayground:id/tab_diary
        //com.wjthinkbig.thinkplayground:id/tab_photo
        //com.wjthinkbig.thinkplayground:id/tab_video
        //com.wjthinkbig.thinkplayground:id/tab_study
    }

    @Then("독서앨범 내 작품 보기 탭 화면구성 확인")
    public void 독서앨범내작품보기탭화면구성확인() {
        //com.wjthinkbig.thinkplayground:id/content_panel
        //com.wjthinkbig.thinkplayground:id/right_area
    }

    @Then("검색 화면구성 확인")
    public void 검색화면구성확인() {
        //com.wjthinkbig.dictionary:id/txt_title_recently_keyword
        //com.wjthinkbig.dictionary:id/block_popular_keyword
    }

    /**
     * 스마트올 백과 실행 확인
     * */
    @Then("스마트올 백과 실행 확인")
    public void 스마트올백과실행확인() {
        try {
            log.info("스마트올 백과 실행 확인");
            String imageName = Utils.takeScreenShot();
            String result = Utils.imageToText(imageName);
            log.info("image to text: {}", result);
            assertTrue("스마트올 백과 실행 화면이 아닙니다.", result.contains("스마트올 백과"));
        } catch (NoSuchElementException e) {
            fail("Element you found not shown");
        } catch (Exception e) {
            fail(e.getMessage());
            System.exit(0);
        }
    }

    @Then("스마트올 백과 연표 실행 확인")
    public void 스마트올백과연표실행확인() {
        //accessibility id = 웅진학습백과 연표
        //id = timeline-inner
    }

    @Then("설정 화면구성 확인")
    public void 설정화면구성확인() {
        //배터리/Wi-Fi/밝기/음량/공지이벤트/고객센터/약관및정책/기기설정/멤버십관련 구성 확인
        //com.wjthinkbig.mlauncher2:id/tv_battery_title
        //com.wjthinkbig.mlauncher2:id/tv_wifi_title
        //com.wjthinkbig.mlauncher2:id/tv_light_title
        //com.wjthinkbig.mlauncher2:id/tv_volume_title
        //com.wjthinkbig.mlauncher2:id/rl_event_area
        //com.wjthinkbig.mlauncher2:id/rl_customer_area
        //com.wjthinkbig.mlauncher2:id/rl_provision_area
        //com.wjthinkbig.mlauncher2:id/rc_device_list
        //com.wjthinkbig.mlauncher2:id/rc_mom_list
    }

    @Then("웅진 스마트올 메뉴구성 확인")
    public void 웅진스마트올메뉴구성확인() {
        //웅진 스마트올 화면구성 확인
        //accessibility id = 오늘의 학습
        //accessibility id = AI 학습센터
        //accessibility id = 초등 포털
        //accessibility id = 전체과목
        //accessibility id = 라이브러리
        //accessibility id = 스타샵
        //accessibility id = 검색
        //accessibility id = 올링고 번역
    }

    @Then("웅진 스마트올 오늘의 학습 실행 확인")
    public void 웅진스마트올오늘의학습실행확인() {
        //오늘의 학습 화면구성을 통해 실행 확인
        //com.wjthinkbig.mlauncher2:id/llWeek => 주간영역
        //com.wjthinkbig.mlauncher2:id/lnaGoalPointLayout => 목표 관련
        //com.wjthinkbig.mlauncher2:id/llappShortcut => 주요 아이콘
        //com.wjthinkbig.mlauncher2:id/llRecommand => 추천 학습관
    }

    @Then("웅진 스마트올 AI 학습센터 AI 학습센터 실행 확인")
    public void 웅진스마트올AI학습센터AI학습센터실행확인() {
        //학습 완료율 영역 확인
        //com.wjthinkbig.mlauncher2:id/complete_rate_area_vg

        //오늘의 추천학습 영역 확인
        //com.wjthinkbig.mlauncher2:id/todayArea_vg

        //단원평가 점수 영역 확인
        //com.wjthinkbig.mlauncher2:id/unit_score_empty_vg

        //받은 상 영역 확인
        //com.wjthinkbig.mlauncher2:id/award_area_vg
    }

    @Then("웅진 스마트올 AI 학습센터 방학 특강 실행 확인")
    public void 웅진스마트올AI학습센터방학특강실행확인() {
        //코스 리스트 영역 확인
        //com.wjthinkbig.mlauncher2:id/ll_course_list

        //코스 콘텐츠 영역 확인
        //com.wjthinkbig.mlauncher2:id/ll_content_area
    }

    @Then("웅진 스마트올 AI 학습센터 영어 실행 확인")
    public void 웅진스마트올AI학습센터영어실행확인() {
        //AI 학습하기 버튼 확인
        //com.wjthinkbig.mlauncher2:id/btn_aicenter_eng_words_study

        //Word Score 영역 확인
        //com.wjthinkbig.mlauncher2:id/bg_words

        //통합영어 목록보기 버튼 확인
        //com.wjthinkbig.mlauncher2:id/btn_aicenter_entt_list

        //학습하기 영역 확인
        //com.wjthinkbig.mlauncher2:id/txt_aicenter_entt_chap_name
    }

    @Then("웅진 스마트올 AI 학습센터 AI 연산 실행 확인")
    public void 웅진스마트올AI학습센터AI연산실행확인() {
        //앱 메인화면 확인
        //id : app_main

    }

    @Then("웅진 스마트올 AI 학습센터 독서 실행 확인")
    public void 웅진스마트올AI학습센터독서실행확인() {
        //추천도서 영역 확인
        //com.wjthinkbig.mlauncher2:id/suggestionArea_vg

        //필독서 영역 확인
        //com.wjthinkbig.mlauncher2:id/mustReadArea_vg

        //프리미엄 영역 확인
        //com.wjthinkbig.mlauncher2:id/premiumArea_vg
    }

    @Then("웅진 스마트올 AI 학습센터 공부지원게임 실행 확인")
    public void 웅진스마트올AI학습센터공부지원게임실행확인() {
        //학교공부 도와줘 영역 확인
        //com.wjthinkbig.mlauncher2:id/sa_aicenter_support_aischool_list

        //패턴 게임 영역 확인
        //com.wjthinkbig.mlauncher2:id/sa_aicenter_support_aipattern_list
    }

    @Then("웅진 스마트올 초등 포털 실행 확인")
    public void 웅진스마트올초등포털실행확인() {
        //메인 영역 확인
        //com.wjthinkbig.mlauncher2:id/layoutPopular

        //사자성어 퀴즈 영역 확인
        //com.wjthinkbig.mlauncher2:id/layoutQuiz

        //English TV 영역 확인
        //com.wjthinkbig.mlauncher2:id/ivEnglishTv

        //3분 회화 영역 확인
        //com.wjthinkbig.mlauncher2:id/layoutEnglish1Min

        //투표 영역 확인
        //com.wjthinkbig.mlauncher2:id/layoutVoting
    }

    @Then("웅진 스마트올 전체과목 실행 확인")
    public void 웅진스마트올전체과목실행확인() {
        //학년 영역 확인
        //com.wjthinkbig.mlauncher2:id/rv_grade

        //내용 영역 확인
        //com.wjthinkbig.mlauncher2:id/container_fragment
    }

    @Then("웅진 스마트올 라이브러리 실행 확인")
    public void 웅진스마트올라이브러리실행확인() {
        
    }

    @Then("웅진 스마트올 스타샵 실행 확인")
    public void 웅진스마트올스타샵실행확인() {
        //탭 확인
        //tab1 , text = 내 별 현황
        //tab2 , text = 나의 목표
        //tab3 , text = 무엇을 바꿔볼까?
    }

    @Then("웅진 스마트올 올링고 번역 실행 확인")
    public void 웅진스마트올올링고번역실행확인() {
        //카드뷰 확인
        //com.wjthinkbig.nfalllingo:id/cardView

        //올링고 타이틀 이미지 확인
        //com.wjthinkbig.nfalllingo:id/imgAllLingo
    }
}
