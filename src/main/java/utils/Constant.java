package utils;

/**
 * 상수 정의 클래스
 * */
public class Constant {

    //! ------------------------- Xpath ------------------------- //
    public static final String 독서_xPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"독서\"]/android.view.ViewGroup/android.widget.TextView";
    public static final String 학습_xPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"학습\"]/android.view.ViewGroup/android.widget.TextView";
    public static final String 라이브러리_xPath = "//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"라이브러리\"]/android.view.ViewGroup/android.widget.TextView";
    public static final String toast_xPath = "/hierarchy/android.widget.Toast";
    /**
     * 작성한 감상문이 이미 있는 경우, 3개까지 작성 가능한 감상문 화면이 나오면서 맨 위에 "감상문을 작성하세요" 라는 문구 또는
     * 감상문을 3개 다 작성했을경우, "도서 당 작성 감상문 수는 3개 입니다." 라는 문구
     * */
    public static final String writeFeelingAlreadyExist_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static final String randomDrawingTemplate_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]";
    public static final String firstPairBook_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout";
    public static final String firstPairBookGenre_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[1]";
    public static final String firstPairBookAge_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[2]";
    public static final String firstPairBookKeywords_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.TextView[3]";
    public static final String pairBookGuidance_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView[1]";
    public static final String secondPairBook_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[1]";
    public static final String thirdPairBook_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.ImageView[1]";
    public static final String dictionarySearchWord_xPath = "//android.webkit.WebView[@content-desc=\"스마트올 백과\"]/android.view.View[4]/android.view.View[1]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.widget.EditText";
    public static final String dictionaryTitle_xPath = "//android.view.View[@content-desc=\"스마트올 백과\"]";
    public static final String dictionaryXBtn_xPath = "//android.webkit.WebView[@content-desc=\"스마트올 백과\"]/android.view.View[2]";
    public static final String myAudioPlayBtn_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.Button[1]";
    public static final String myAudioLikeBtn_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.Button[2]";
    public static final String myAudioPlayCount_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]";
    public static final String myAudioLikeCount_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[2]";
    public static final String friendsAudioPlayBtn_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.support.v4.view.ViewPager/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.Button[1]";
    public static final String friendsAudioPlayCount_id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.support.v4.view.ViewPager/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[1]";
    public static final String friendsAudioLikeBtn_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.support.v4.view.ViewPager/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.Button[2]";
    public static final String friendsAudioLikeCount_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.support.v4.view.ViewPager/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[2]";
    public static final String fillViewLayout_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.AdapterView";
    public static final String myButton_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[2]/android.view.ViewGroup/android.widget.TextView";
    public static final String audioEBookBtnOnMyView_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.CheckedTextView";
    public static final String firstAudioBgm_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button";
    public static final String progressBar_xPath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.AdapterView/android.view.ViewGroup/android.widget.ProgressBar";



    //! ------------------------- ID -------------------------- //
    public static final String 검색_id = "com.wjthinkbig.mlauncher2:id/btnSearch";
    public static final String 검색창_id = "com.wjthinkbig.dictionary:id/input_txt";
    public static final String 검색실행_id = "com.wjthinkbig.dictionary:id/search";
    public static final String 사전_id = "com.wjthinkbig.mepubviewer2:id/btn_right_dictionary";
    public static final String 더보기_id = "com.wjthinkbig.mepubviewer2:id/btnShowButtons";
    public static final String 안내팝업메시지_id = "com.wjthinkbig.mepubviewer2:id/text_confirm_sub";
    public static final String 안내팝업확인_id = "com.wjthinkbig.mepubviewer2:id/btn_ok";
    public static final String 안내팝업취소_id = "com.wjthinkbig.mepubviewer2:id/btn_cancel";
    public static final String 감상문쓰기_id = "com.wjthinkbig.mepubviewer2:id/btn_right_write_feeling";

    /**
     * Wifi Off 시 감상문 쓰기 버튼 클릭 후 노출되는 확인 팝업 누를 때 나오는 팝업의 타이틀
     * */
    public static final String mBookPopupTitle_id = "com.wjthinkbig.mbookdiaryactivitytool:id/tv_Title";
    /**
     * Wifi Off 시 감상문 쓰기 버튼 클릭 후 노출되는 확인 팝업 누를 때 나오는 팝업의 확인 버튼
     * */
    public static final String mBookPopupOk_id = "com.wjthinkbig.mbookdiaryactivitytool:id/bt_offline";
    /**
     * Wifi Off 시 감상문 보기 버튼 클릭 후 노출되는 확인 팝업 누를 때 나오는 팝업의 타이틀
     * */
    public static final String thinkPlaygroundTitle_id = "com.wjthinkbig.thinkplayground:id/tv_Title";
    /**
     * Wifi Off 시 감상문 보기 버튼 클릭 후 노출되는 확인 팝업 누를 때 나오는 팝업의 확인 버튼
     * */
    public static final String thinkPlaygroundOk_id = "com.wjthinkbig.thinkplayground:id/bt_offline";

    public static final String 독후퀴즈_id = "com.wjthinkbig.mepubviewer2:id/btn_right_reading_quiz";
    public static final String 감상문보기_id = "com.wjthinkbig.mepubviewer2:id/btn_right_read_feeling";
    public static final String 오디오북보기_id = "com.wjthinkbig.mepubviewer2:id/btn_right_see_audiobook";
    public static final String 짝꿍책_id = "com.wjthinkbig.mepubviewer2:id/btn_right_pairbook";
    public static final String 녹음_id = "com.wjthinkbig.mepubviewer2:id/btnRecord";
    public static final String 녹음시작_id = "com.wjthinkbig.mepubviewer2:id/BT_UCC_REC_START_PAUSE";
    public static final String 녹음종료_id = "com.wjthinkbig.mepubviewer2:id/BT_record_close";
    public static final String 독서앨범_id = "com.wjthinkbig.mlauncher2:id/btnAlbum";
    public static final String 스마트올백과_id = "com.wjthinkbig.mlauncher2:id/btnDictionary";

    public static final String 웅진스마트올_id = "com.wjthinkbig.mlauncher2:id/btnSmartAll";

    public static final String 프로필_id = "com.wjthinkbig.mlauncher2:id/btnProfile";

    /**
     * 책을 마지막 페이지까지 읽으면 노출되는 오디오북 보기/감상문 보기 팝업의 X 버튼
     * */
    public static final String thinkPlaygroundClose_id = "com.wjthinkbig.thinkplayground:id/btn_close";
    public static final String createAudioBookBtn_id = "com.wjthinkbig.mepubviewer2:id/BT_ucc_Create";

    public static final String loadingImage_id = "com.wjthinkbig.mlauncher2:id/vLottie";
    public static final String loadingText_id = "com.wjthinkbig.mlauncher2:id/txtProgressPercent";
    public static final String viewerClose_id = "com.wjthinkbig.mepubviewer2:id/btnFirst";
    public static final String currentPageIndex_id = "com.wjthinkbig.mepubviewer2:id/txtCurrentPageIndex";
    public static final String viewerBookTitle_id = "com.wjthinkbig.mepubviewer2:id/txtPieceHeadTitle";
    public static final String captureAllScreen_id = "com.wjthinkbig.mepubviewer2:id/btn_right_capture_all";
    public static final String captureRandomScreen_id = "com.wjthinkbig.mepubviewer2:id/btn_right_capture_random";

    /**
     * 마음대로저장 버튼 눌러서 영역 그렸을 때 노출되는 팝업의 알림 문구
     * */
    public static final String txtContent_id = "com.wjthinkbig.mepubviewer2:id/txtContent";
    /**
     * 마음대로저장 버튼 눌러서 영역 그렸을 때 노출되는 팝업의 그림 문구
     * */
    public static final String imageViewCapture_id = "com.wjthinkbig.mepubviewer2:id/imageviewCapture";
    /**
     * 마음대로저장 버튼 눌러서 영역 그렸을 때 노출되는 팝업의 취소 버튼
     * */
    public static final String imageCaptureClose_id = "com.wjthinkbig.mepubviewer2:id/btnCloseImage";
    /**
     * 마음대로저장 버튼 눌러서 영역 그렸을 때 노출되는 팝업의 확인 버튼
     * */
    public static final String imageCaptureSave_id = "com.wjthinkbig.mepubviewer2:id/btnSaveImage";
    /**
     * 감상문쓰기 버튼 클릭 시 노출되는 템플릿 선택 화면의 Title
     * */
    public static final String templateTitle_id = "com.wjthinkbig.mbookdiaryactivitytool:id/iv_template_title";
    /**
     * 이미 감상문이 존재할 때 보여지는 화면의 첫번째 감상문
     * */
    public static final String firstWriteFeelingThumbnail_id = "com.wjthinkbig.mbookdiaryactivitytool:id/ivReport0";
    public static final String secondWriteFeelingThumbnail_id = "com.wjthinkbig.mbookdiaryactivitytool:id/ivReport1";
    public static final String selectTemplateOK_id = "com.wjthinkbig.mbookdiaryactivitytool:id/btnOk";
    public static final String drawingMode_id = "com.wjthinkbig.mbookdiaryactivitytool:id/btnPenOnOff";
    public static final String drawingSave_id = "com.wjthinkbig.mbookdiaryactivitytool:id/btnSave";
    public static final String writeFeelingAlreadyScreenCloseBtn_id = "com.wjthinkbig.mbookdiaryactivitytool:id/btn_number_close";
    public static final String tapForSeeFeeling_id = "com.wjthinkbig.thinkplayground:id/tv_book_tap";
    public static final String seeMyFeelingThumbnail_id = "com.wjthinkbig.thinkplayground:id/report_thumb01";
    public static final String noMyReport_id = "com.wjthinkbig.thinkplayground:id/no_my_report";
    public static final String noFriendsReport_id = "com.wjthinkbig.thinkplayground:id/no_friends_report";
    public static final String friendsReportArea_id = "com.wjthinkbig.thinkplayground:id/friends_report_area";
    public static final String appTitle_id = "com.wjthinkbig.thinkplayground:id/app_title";
    public static final String commonBackButton_id = "com.wjthinkbig.thinkplayground:id/common_back_button";
    public static final String pairBookListBody_id = "com.wjthinkbig.mepubviewer2:id/linear_nextbook_body";
    public static final String pairBookXBtn_id = "com.wjthinkbig.mepubviewer2:id/btn_nextbook_close";
    public static final String helpBtn_id = "com.wjthinkbig.mepubviewer2:id/btn_right_help";
    public static final String helpViewLayout_id = "com.wjthinkbig.mepubviewer2:id/layout_help";
    public static final String bottomIndicatorOnHelpView_id = "com.wjthinkbig.mepubviewer2:id/indicator";
    public static final String helpViewXBtn_id = "com.wjthinkbig.mepubviewer2:id/button_help_close";
    public static final String bottomThumbnailBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomThumbnail";
    public static final String bottomScrollThumbnailLayout_id = "com.wjthinkbig.mepubviewer2:id/scroll_thumb";
    public static final String thumbCloseBtn_id = "com.wjthinkbig.mepubviewer2:id/btn_thumb_close";
    /**
     * 책 다 읽고 감상문 보기 팝업 노출되면 그 팝업 닫을 때 보여지는 우측 하단 메시지 팝업창
     * */
    public static final String banaText_id = "com.wjthinkbig.mepubviewer2:id/imageBoxBackground";

    /**
     * 책을 완독하고 뷰어를 종료하면 보여지는 평가 화면
     * */
    public static final String feelPointLayout_id = "com.wjthinkbig.mepubviewer2:id/linear_feelPointLayer";
    public static final String goodEmoji_id = "com.wjthinkbig.mepubviewer2:id/radio_rating_emotion01";
    public static final String badEmoji_id = "com.wjthinkbig.mepubviewer2:id/radio_rating_emotion02";
    public static final String ratingOKBtn_id = "com.wjthinkbig.mepubviewer2:id/button_rating_ok";
    public static final String rotationBtn_id = "com.wjthinkbig.mepubviewer2:id/btn_right_rotation";
    public static final String dictionaryRunningPage_id = "com.wjthinkbig.mepubviewer2:id/LL_dictionary_parent";
    public static final String dictionaryCloseBtn_id = "com.wjthinkbig.mepubviewer2:id/BT_dictionary_close";
    public static final String audioTap_id = "com.wjthinkbig.thinkplayground:id/tv_audio_tap";
    public static final String noMyAudio_id = "com.wjthinkbig.thinkplayground:id/no_my_audio";
    public static final String myAudio_id = "com.wjthinkbig.thinkplayground:id/my_audio_area";
    public static final String noFriendsAudio_id = "com.wjthinkbig.thinkplayground:id/no_friends_audio";
    public static final String friendsAudio_id = "com.wjthinkbig.thinkplayground:id/friends_audio_area";
    public static final String seeTypeBtn_id = "com.wjthinkbig.mepubviewer2:id/btnSeeType";
    public static final String fillViewBtn_id = "com.wjthinkbig.mepubviewer2:id/viewFill";
    public static final String singleViewBtn_id = "com.wjthinkbig.mepubviewer2:id/viewSingle";
    public static final String basicViewBtn_id = "com.wjthinkbig.mepubviewer2:id/viewBasic";
    public static final String banaToastMessage_id = "com.wjthinkbig.mepubviewer2:id/textMessage";
    public static final String playOrPauseBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomPlayAndPause";
    public static final String viewerProgressBar_id = "com.wjthinkbig.mepubviewer2:id/progressCurrent";
    public static final String bottomPrevBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomPrev";
    public static final String bottomNextBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomNext";
    public static final String spentTimeText_id = "com.wjthinkbig.mepubviewer2:id/txtTimeShow";
    public static final String bottomSpeedBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomSpeed";
    public static final String bottomLockBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomLock";
    public static final String bottomRepeatBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomRepeat";
    public static final String seeRightNowBtn_id = "com.wjthinkbig.mlauncher2:id/downBtn";
    public static final String autoPlayBtn_id = "com.wjthinkbig.mepubviewer2:id/btnBottomAutoplay";
    public static final String lockScreenBtn_id = "com.wjthinkbig.mepubviewer2:id/lock_screen";
    public static final String continuePlayBtn_id = "com.wjthinkbig.mlauncher2:id/continuePlayBtn";
    public static final String rightBtn_id = "com.wjthinkbig.mlauncher2:id/btnR";
    public static final String moreViewLayout_id = "com.wjthinkbig.mepubviewer2:id/layoutRightButtons";
    public static final String ivLoadingImage_id = "com.wjthinkbig.mepubviewer2:id/iv_loading";
    public static final String tvLoadingText_id = "com.wjthinkbig.mepubviewer2:id/tv_loading_txt";
    public static final String favoriteSpinner_id = "com.wjthinkbig.mlauncher2:id/bookmark_spinner";
    public static final String continuePlayLayout_id = "com.wjthinkbig.mlauncher2:id/contents_recyclerview";
    public static final String ivHelpText_id = "com.wjthinkbig.mepubviewer2:id/IV_HELP_STEP";
    public static final String recordStartAndStopBtn_id = "com.wjthinkbig.mepubviewer2:id/BT_UCC_REC_START_PAUSE";
    public static final String recordCloseBtn_id = "com.wjthinkbig.mepubviewer2:id/BT_record_close";
    public static final String playPauseRecorded_id = "com.wjthinkbig.mepubviewer2:id/BT_UCC_PLAY_PAUSE";
    public static final String saveRecordScreenLayout_id = "com.wjthinkbig.mepubviewer2:id/LL_ucc_Create_P";
    public static final String guideText_id = "com.wjthinkbig.mepubviewer2:id/guide_textview";
    public static final String bgmLayout_id = "com.wjthinkbig.mepubviewer2:id/bgm_layout";
    public static final String exitRecordScreen_id = "com.wjthinkbig.mepubviewer2:id/BT_UCC_MODE_EXIT";
    public static final String listenRecord_id = "com.wjthinkbig.mepubviewer2:id/BT_UCC_MODE_LISTEN";
    public static final String enDictionarySearchGoBtn_id = "com.wjthinkbig.mepubviewer2:id/BT_dictionary_en_call";
    public static final String cartoonHelpLayoutCloseBtn_id = "com.wjthinkbig.mepubviewer2:id/button_help_close_by_cartoon";
    public static final String enHelpLayoutXBtn_id = "com.wjthinkbig.mepubviewer2:id/button_help_en_close";
    public static final String backOnSearchScreen_id = "com.wjthinkbig.dictionary:id/close";
    public static final String orderDateBtn_id = "com.wjthinkbig.mlauncher2:id/read_date_order";
}
