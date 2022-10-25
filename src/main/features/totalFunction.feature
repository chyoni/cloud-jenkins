Feature: 통합뷰어 전체 기능별 실행 체크(초등 3학년 기준)

#### 초등 3학년 기준 #####

#### [독서] 메뉴 관련

  @pass
  Scenario Outline: [독서 - AI맞춤] 구성 확인 (totalFunction_001)
    Given 독서 버튼 클릭
    When 독서 - "AI맞춤" 서브메뉴 클릭
    Then AI맞춤 투데이 화면구성 "<contents>" 확인

    Examples:
      | contents |
      | 또래친구 책장 속 재미있는 콘텐츠-또래친구들이 좋아하는-나만 못 본 주간베스트-균형있게 읽어요-학교 공부가 쉬워져요 |

  #title이 동적으로 바뀌는 경우 고정 text를 이용할 수 있도록 수정 필요(또래친구들이 좋아하는 ~~~~)
  @pass
  Scenario Outline: [독서 - AI맞춤] 기능 확인 - Outline(totalFunction_002)
    Given 독서 버튼 클릭
    When 독서 - "AI맞춤" 서브메뉴 클릭
    And AI맞춤 "<title>" 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

    Examples:
      | title |
      | 또래친구 책장 속 재미있는 콘텐츠 |
#      | 또래친구들이 좋아하는 |
      | 나만 못 본 주간베스트 |
      | 균형있게 읽어요 |
      | 학교 공부가 쉬워져요 |

  @pass
  Scenario: [독서 - 교과] 구성 확인 (totalFunction_003)
    Given 독서 버튼 클릭
    When 독서 - "교과" 서브메뉴 클릭
    Then 교과 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 교과] 기능 확인 (totalFunction_004)
    Given 독서 버튼 클릭
    When 독서 - "교과" 서브메뉴 클릭
    And 교과 첫번째 과목 클릭
    And 선택 교과 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

  #T583 패드의 경우, 교과 가이드 버튼 미노출
  @pass
  Scenario: [독서 - 교과] 교과 가이드 기능 확인 (totalFunction_005)
    Given 독서 버튼 클릭
    When 독서 - "교과" 서브메뉴 클릭
    And 교과 가이드 버튼 클릭
    Then 교과 가이드 화면구성 확인

  @pass
  Scenario: [독서 - 교과] 지난호 보기 기능 확인 (totalFunction_006)
    Given 독서 버튼 클릭
    When 독서 - "교과" 서브메뉴 클릭
    And 독서 지난호 보기 버튼 클릭
    Then 독서 지난호 보기 화면구성 확인
    When 독서 지난호 보기 1번째 콘텐츠 클릭
    Then 교과 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 주제] 구성 확인 (totalFunction_011)
    Given 독서 버튼 클릭
    When 독서 - "주제" 서브메뉴 클릭
    Then 주제 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 주제] 기능 확인 (totalFunction_012)
    Given 독서 버튼 클릭
    When 독서 - "주제" 서브메뉴 클릭
    And 독서 0번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

  @pass
  Scenario: [독서 - 주제] 지난호 보기 기능 확인 (totalFunction_013)
    Given 독서 버튼 클릭
    When 독서 - "주제" 서브메뉴 클릭
    And 독서 지난호 보기 버튼 클릭
    Then 독서 지난호 보기 화면구성 확인
    When 독서 지난호 보기 0번째 콘텐츠 클릭
    Then 주제 투데이 화면구성 확인

  # 독서-교과 이후, 독서-메인 클릭하면 앱 종료되는 현상 발생(0930)
  # 시나리오 위치를 독서-주제 뒷쪽으로 이동
  @pass
  Scenario: [독서 - 메인] 구성 확인 (totalFunction_007)
    Given 독서 버튼 클릭
    When 독서 - "메인" 서브메뉴 클릭
    And 5초 대기
    Then 메인 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 메인] 기능 확인 (totalFunction_008)
    Given 독서 버튼 클릭
    When 독서 - "메인" 서브메뉴 클릭
    And 독서 0번째 콘텐츠 클릭
    And 10초 대기
    Then 메인 콘텐츠 확인

  @pass
  Scenario: [독서 - 메인] 웅진북클럽 무료체험 참여 기능 확인 (totalFunction_009)
    Given 독서 버튼 클릭
    When 독서 - "메인" 서브메뉴 클릭
    And 웅진북클럽 무료체험 참여 버튼 클릭
    Then 웅진북클럽 무료체험 참여 화면구성 확인

  @pass
  Scenario: [독서 - 메인] 지난호 보기 기능 확인 (totalFunction_010)
    Given 독서 버튼 클릭
    When 독서 - "메인" 서브메뉴 클릭
    And 독서 지난호 보기 버튼 클릭
    Then 독서 지난호 보기 화면구성 확인
    When 독서 지난호 보기 0번째 콘텐츠 클릭
    Then 메인 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 메타버스] 구성 확인 (totalFunction_014)
    Given 독서 버튼 클릭
    When 독서 - "메타버스" 서브메뉴 클릭
    Then 메타버스 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 메타버스] 기능 확인 (totalFunction_015)
    Given 독서 버튼 클릭
    When 독서 - "메타버스" 서브메뉴 클릭
    And 메타버스 콘텐츠 클릭
    And 5초 대기
    Then 메타버스 콘텐츠 확인

  @pass
  Scenario: [독서 - 백과] 구성 확인 (totalFunction_016)
    Given 독서 버튼 클릭
    When 대메뉴 하위 서브메뉴 초기화
    And 독서 - "백과" 서브메뉴 클릭
    And 10초 대기
    Then 백과 투데이 화면구성 확인

  @pass
  Scenario: [독서 - 백과] 기능 확인 (totalFunction_017)
    Given 독서 버튼 클릭
    When 대메뉴 하위 서브메뉴 초기화
    And 독서 - "백과" 서브메뉴 클릭
    And 20초 대기
    And 백과 첫번째 키워드 클릭
    And 15초 대기
    Then 웅진학습백과 실행 확인

##### [학습] 메뉴 관련

  @pass
  Scenario: [학습] 구성 확인 (totalFunction_021)
    Given 학습 버튼 클릭
    Then 학습 화면구성 확인

  @pass
  Scenario: [학습] 커리큘럼 기능 확인 (totalFunction_022)
    Given 학습 버튼 클릭
    When 학습 커리큘럼 버튼 클릭
    Then 학습 커리큘럼 콘텐츠 확인
    When 전체 커리큘럼 보기 버튼 클릭
    Then 전체 커리큘럼 콘텐츠 확인

  @pass
  Scenario: [학습] 학습 라이브러리 기능 확인 (totalFunction_023)
    Given 학습 버튼 클릭
    When 학습 라이브러리 버튼 클릭
    And 그리기 권한 허용 설정
    Then 학습 라이브러리 콘텐츠 확인

  @pass
  Scenario: [학습] 학습 배틀 기능 확인 (totalFunction_024)
    Given 학습 버튼 클릭
    When 학습 배틀 버튼 클릭
    And 30초 대기
    Then 학습 배틀 실행 확인

  @pass
  Scenario: [학습] 투게더 수업 기능 확인 (totalFunction_025)
    Given 학습 버튼 클릭
    When 학습 투게더 수업 버튼 클릭
    Then 학습 투게더 수업 기능 확인

  @pass
  Scenario: [학습] 상담하기 기능 확인 (totalFunction_026)
    Given 학습 버튼 클릭
    When 학습 상담하기 버튼 클릭
    And 5초 대기
    Then 학습 상담하기 실행 확인

  @pass
  Scenario Outline: [학습] 학습 체험판 과목별 기능 확인 (totalFunction_027)
    Given 학습 버튼 클릭
    When 학습 체험판 "<subject>" 버튼 클릭
    And 40초 대기
    Then 학습 체험판 "<subject>" 실행 확인

    Examples:
      | subject |
      | AI수학 |
      | AI학습매니저 |
      | AI수학체험 |
      | AI책읽기 |
      | 생각토론 |
      | ARScience |
      | 한자 |
      | 한글깨치기 |
      | 수학깨치기 |
      | 유아국어 |
      | 유아수학 |
      | 투게더 |

  @pass
  Scenario Outline: [학습] 학습 체험판 과목별(단계선택) 기능 확인 (totalFunction_028)
    Given 학습 버튼 클릭
    When 학습 체험판 "<subject>" 버튼 클릭
    And 학습 체험판 "<subject>" 첫단계 선택
    And 40초 대기
    Then 학습 체험판 "<subject>" 실행 확인

    Examples:
      | subject |
      | 국어 |
      | 수학 |
      | 사회과학 |
      | 영어 |
      | 유아영어 |


##### [라이브러리] 메뉴 관련 (실행 체크 부분 보완할지 검토/ 미리보기, 바로보기 등)

  @pass
  Scenario Outline: [라이브러리 - 홈] 구성 확인 (totalFunction_029)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    Then 라이브러리 홈 화면구성 "<contents>" 확인

    Examples:
      | contents |
      | 필독선 라이브러리-추천 도서 세트-투데이 라이브러리-교과 라이브러리-분야 전체-추천 키워드 |

  @pass
  Scenario: [라이브러리 - 홈] 교과서 수록 도서 기능 확인 (totalFunction_030)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 5초 대기
    And 라이브러리 홈 "교과서 수록 도서" 콘텐츠 클릭
    Then 라이브러리 홈 "교과서 수록 도서" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    Then 상세정보 팝업창에서 미리보기(바로보기) 실행 확인

  @pass
  Scenario: [라이브러리 - 홈] 기관 추천 어린이 도서 기능 확인 (totalFunction_030-1)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 "기관 추천 어린이 도서" 콘텐츠 클릭
    Then 라이브러리 홈 "기관 추천 어린이 도서" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    Then 상세정보 팝업창에서 미리보기(바로보기) 실행 확인

  @pass
  Scenario: [라이브러리 - 홈] 기관 추천 청소년 도서 기능 확인 (totalFunction_030-2)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 "기관 추천 청소년 도서" 콘텐츠 클릭
    Then 라이브러리 홈 "기관 추천 청소년 도서" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    Then 상세정보 팝업창에서 미리보기(바로보기) 실행 확인

  @pass
  Scenario: [라이브러리 - 홈] 추천 도서 세트 기능 확인 (totalFunction_031)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 추천 도서 세트 콘텐츠 클릭
    And 5초 대기
    Then 라이브러리 홈 추천 도서 세트 콘텐츠 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    Then 상세정보 팝업창에서 미리보기(바로보기) 실행 확인

  @pass
  Scenario: [라이브러리 - 홈] 투데이 라이브러리 기능 확인 (totalFunction_032)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 투데이 라이브러리-"역사" 콘텐츠 클릭
    Then 라이브러리 홈 투데이 라이브러리-"역사" 콘텐츠 확인
    When 투데이 라이브러리 뒤로가기 버튼 클릭
    And 라이브러리 홈 투데이 라이브러리-"스마트독서" 콘텐츠 클릭
    Then 라이브러리 홈 투데이 라이브러리-"스마트독서" 콘텐츠 확인
    When 투데이 라이브러리 뒤로가기 버튼 클릭
    And 라이브러리 홈 투데이 라이브러리-"토이" 콘텐츠 클릭
    Then 라이브러리 홈 투데이 라이브러리-"토이" 콘텐츠 확인

  @pass
  Scenario: [라이브러리 - 홈] 교과 라이브러리 기능 확인 (totalFunction_033)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 교과 라이브러리 콘텐츠 클릭
    And 5초 대기
    Then 라이브러리 홈 "초등 교과 연계 도서" 리스트 확인
    When 라이브러리 홈 초등 교과 연계 도서 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인
    And 라이브러리 홈 "초등 교과 연계 도서" 리스트 뒤로가기

  @pass
  Scenario Outline: [라이브러리 - 홈] 분야 전체 미리보기 기능 확인 (totalFunction_034)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 분야 전체 "<title>" 클릭
    And 5초 대기
    Then 라이브러리 홈 "<title>" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    And 상세정보 팝업창에서 미리보기 버튼 클릭
    Then 미리보기 실행 확인
    And 플레이어 종료하기
    And 상세정보 팝업창 닫기 버튼 클릭
    And 라이브러리 뒤로가기 버튼 클릭

    Examples:
      | title |
      | 새로나온 콘텐츠 |
      | 교과서 수록 도서 |
      | 기관 추천 어린이 도서 |
      | 기관 추천 청소년 도서 |
      | Storybook |
      | Readers |

  @pass
  Scenario Outline: [라이브러리 - 홈] 분야 전체 인터랙티브북 기능 확인 (totalFunction_035)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 분야 전체 "<title>" 클릭
    And 5초 대기
    Then 라이브러리 홈 "<title>" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    Then 인터랙티브북 상세정보 확인
    And 상세정보 팝업창 닫기 버튼 클릭
    And 라이브러리 뒤로가기 버튼 클릭

    Examples:
      | title |
      | 인터랙티브북 |
      | AR Science |

  @pass
  Scenario Outline: [라이브러리 - 홈] 분야 전체 바로보기 기능 확인 (totalFunction_036)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 분야 전체 "<title>" 클릭
    And 5초 대기
    Then 라이브러리 홈 "<title>" 리스트 확인
    When 라이브러리 홈 첫번째 콘텐츠 클릭
    And 상세정보 팝업창에서 바로보기 버튼 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기
    And 라이브러리 뒤로가기 버튼 클릭

    Examples:
      | title |
      | Animation |
      | 플레이북 |

  @pass
  Scenario Outline: [라이브러리 - 홈] 추천 키워드 기능 확인 (totalFunction_037)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "홈" 서브메뉴 클릭
    And 라이브러리 홈 추천 키워드 "<title>" 클릭
    And 라이브러리 홈 추천 키워드 첫번째 콘텐츠 클릭
    Then 추천 키워드 상세정보 팝업창에서 미리보기(바로보기) 실행 확인

    Examples:
      | title |
      | 인기 |
      | 강추 |
      | 테마 |
      | 가족 |
      | 도시 |
      | 도전 |
      | 도형 |
      | 돈 |

  @pass
  Scenario: [라이브러리 - 마이] 구성 확인 (totalFunction_038)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "낱권" 서브메뉴 클릭
    Then 라이브러리 마이 "낱권" 화면구성 확인
    When 라이브러리 마이 "세트" 서브메뉴 클릭
    Then 라이브러리 마이 "세트" 화면구성 확인

  @pass
  Scenario Outline: [라이브러리 - 마이] 낱권 메뉴별 기능 확인 (totalFunction_039)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "낱권" 서브메뉴 클릭
    And 라이브러리 마이 낱권 "<menu>" 서브메뉴 클릭
    And 라이브러리 마이 낱권 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인
    And 플레이어 종료하기

    Examples:
      | menu |
      | 전체 |
      | 이북 |
      | 오디오 이북 |
      | 동영상 |

  # 멀티 터치북의 경우, 플레이어 닫기 기능이 정상 동작하지 않으므로 별도 시나리오로 분리(닫기 버튼 확인되도록 앱 개선 필요)
  @pass
  Scenario Outline: [라이브러리 - 마이] 낱권 멀티 터치북 기능 확인 (totalFunction_039-1)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "낱권" 서브메뉴 클릭
    And 라이브러리 마이 낱권 "<menu>" 서브메뉴 클릭
    And 라이브러리 마이 낱권 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 멀티 터치북 |

  @pass
  Scenario: [라이브러리 - 마이] 낱권 연속재생 기능 확인 (totalFunction_040)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "낱권" 서브메뉴 클릭
    And 라이브러리 마이 낱권 "오디오 이북" 서브메뉴 클릭
    And 연속재생 버튼 클릭
    And 연속재생 콘텐츠 선택
    And 연속재생 버튼 클릭
    And 선택 항목 재생 알림창에서 확인 버튼 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

  @pass
  Scenario Outline: [라이브러리 - 마이] 세트 메뉴별 기능 확인 (totalFunction_041)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "세트" 서브메뉴 클릭
    And 라이브러리 마이 세트 "<menu>" 메뉴 클릭
    And 라이브러리 마이 세트 첫번째 콘텐츠 클릭
    And 2초 대기
    And 라이브러리 마이 세트 "<menu>" 메뉴 팝업에서 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인
    And 플레이어 종료하기
    And 라이브러리 마이 세트 팝업창 닫기

    Examples:
      | menu |
      | 전체 |
      | 소리동요 |
      | 소리동화 |

  @pass
  Scenario: [라이브러리 - 마이] 우리아이 책장 구성 확인 (totalFunction_042)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 우리아이 책장 버튼 클릭
    Then 라이브러리 우리아이 책장 화면구성 확인

  @pass
  Scenario: [라이브러리 - 마이] 우리아이 책장 읽은 종이책 등록 기능 확인 (totalFunction_043)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 우리아이 책장 버튼 클릭
    And 라이브러리 우리아이 책장 - 읽은 종이책 등록 버튼 클릭
    And 라이브러리 우리아이 책장 - 읽은 종이책 "가방 들어 주는 아이" 등록
    Then "종이책이 등록되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  @pass
  Scenario: [라이브러리 - 마이] 우리아이 책장 편집 기능 확인 (totalFunction_044)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 우리아이 책장 버튼 클릭
    And 라이브러리 우리아이 책장 편집 버튼 클릭
    And 3초 대기
    And 라이브러리 우리아이 책장 첫번째 콘텐츠 클릭
    And 2초 대기
    And 라이브러리 우리아이 책장 삭제하기 버튼 클릭
    And 5초 대기
    And 라이브러리 우리아이 책장 삭제 알림 확인 버튼 클릭
    Then "종이책 삭제가 완료하였습니다." 문구가 담긴 토스트 팝업 노출 확인

  @pass
  Scenario: [라이브러리 - 투데이도서] 구성 확인 (totalFunction_045)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "투데이도서" 서브메뉴 클릭
    And 라이브러리 투데이도서 "투데이" 서브메뉴 클릭
    Then 라이브러리 투데이도서 화면구성 확인

  #종이책 클릭 후 확인되지 않는 파일입니다. toast 메시지 뜨는 경우, return 처리
  #콘텐츠 없는 경우, return 처리
  @pass
  Scenario Outline: [라이브러리 - 투데이도서] 투데이 메뉴별 기능 확인 (totalFunction_046)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "투데이도서" 서브메뉴 클릭
    And 라이브러리 투데이도서 "투데이" 서브메뉴 클릭
    And 라이브러리 투데이도서 투데이 "<menu>" 서브메뉴 클릭
    And 라이브러리 투데이도서 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 전체 |
      | AI맞춤 투데이 |
      | 역사 투데이 |
      | 스페셜 투데이 |
      | 스마트 독서 투데이 |
      | 1–3세 투데이 |
      | 4–6세 투데이 |
      | 7–9세 투데이 |
      | 7–13세 투데이 |
      | 4–6세 융합 |
      | 7–9세 융합 |
      | 7–9세 시즌 |
      | 10–13세 고전/명작 |
      | 토이 투데이 |
      | 누리 투데이 |
      | 교과 투데이 |
      | 중등 투데이 |

  #유형 관련 메뉴에서 콘텐츠 추가 필요
  @pass
  Scenario Outline: [라이브러리 - 투데이도서] 유형 메뉴별 기능 확인 (totalFunction_047)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "투데이도서" 서브메뉴 클릭
    And 라이브러리 투데이도서 "유형" 서브메뉴 클릭
    And 라이브러리 투데이도서 유형 "<menu>" 서브메뉴 클릭
    And 라이브러리 투데이도서 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 전체 |
      | 이북 |
      | 오디오 이북 |
      | 멀티 터치북 |
      | 동영상 |

  @pass
  Scenario: [라이브러리 - 학습연계도서] 구성 확인 (totalFunction_048)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "학습연계도서" 서브메뉴 클릭
    Then 라이브러리 학습연계도서 화면구성 확인

  #학습연계도서 관련 메뉴에서 콘텐츠 추가 필요
  @pass
  Scenario Outline: [라이브러리 - 학습연계도서] 메뉴별 기능 확인 (totalFunction_049)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "학습연계도서" 서브메뉴 클릭
    And 라이브러리 학습연계도서 "<menu>" 서브메뉴 클릭
    And 라이브러리 투데이도서 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 전체 |
      | 이북 |
      | 오디오 이북 |
      | 멀티 터치북 |
      | 동영상 |

  @pass
  Scenario: [라이브러리 - 내가 만든 오디오북] 구성 확인 (totalFunction_050)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "내가 만든 오디오북" 서브메뉴 클릭
    Then 라이브러리 내가 만든 오디오북 화면구성 확인

  #내가 만든 오디오북 관련 메뉴에서 콘텐츠 추가 필요
  @pass
  Scenario Outline: [라이브러리 - 내가 만든 오디오북] 메뉴별 기능 확인 (totalFunction_051)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "내가 만든 오디오북" 서브메뉴 클릭
    And 라이브러리 내가 만든 오디오북 "<menu>" 서브메뉴 클릭
    And 라이브러리 내가 만든 오디오북 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 전체 |
      | 이북 |
      | 오디오 이북 |

  @pass
  Scenario: [라이브러리 - 즐겨찾기] 구성 확인 (totalFunction_052)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "즐겨찾기" 서브메뉴 클릭
    Then 라이브러리 즐겨찾기 화면구성 확인

  #즐겨찾기 관련 메뉴에서 콘텐츠 추가 필요
  @pass
  Scenario Outline: [라이브러리 - 즐겨찾기] 메뉴별 기능 확인 (totalFunction_053)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "즐겨찾기" 서브메뉴 클릭
    And 라이브러리 즐겨찾기 "<menu>" 서브메뉴 클릭
    And 라이브러리 즐겨찾기 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인

    Examples:
      | menu |
      | 전체 |
      | 이북 |
      | 오디오 이북 |
      | 멀티 터치북 |
      | 동영상 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 구성 확인 (totalFunction_054)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 화면구성 "<contents>" 확인

    Examples:
      | contents |
      | 마이 라이브러리-스마트올 5,6세 라이브러리-스마트올 키즈 라이브러리-스마트올 라이브러리-교과 라이브러리-투데이 라이브러리-독서 라이브러리 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 마이 라이브러리 링크 기능 확인 (totalFunction_055)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 마이 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 마이 라이브러리 "<menu>" 서브메뉴로 이동 확인

    Examples:
      | menu |
      | 마이 |
      | 투데이도서 |
      | 학습연계도서 |
      | 내가 만든 오디오북 |
      | 즐겨찾기 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 스마트올 5,6세 라이브러리 링크 기능 확인 (totalFunction_056)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 스마트올 5,6세 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "스마트올 5,6세 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | 얼렁뚱땅 코딩 |
      | 생생 자연관찰 |
      | 몽글몽글 과학 |
      | 뚝딱뚝딱 요리 |
      | 구석구석 탐험 |
      | 두근두근 직업 |
      | 둥글둥글 생활 |
      | 쭈욱쭈욱 체육 |
      | 조심조심 안전 |
      | 스스로 척척 |
      | 스마트올송 |
      | 쓱쓱싹싹 미술 |
      | 룰루랄라 음악 |
      | 책 놀이 |
      | All 도서관 |
      | 추천 키워드 도서 |
      | All 영상 |
      | All 동요 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 스마트올 키즈 라이브러리 링크 기능 확인 (totalFunction_057)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 스마트올 키즈 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "스마트올 키즈 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | English Song |
      | 재미재미 한자 영상 |
      | 얼렁뚱땅 코딩 |
      | 구석구석 탐험 |
      | 두근두근 직업 |
      | 시시콜콜한국사 |
      | 쭈욱쭈욱 체육 |
      | 쓱쓱싹싹 미술 |
      | 룰루랄라 음악 |
      | 자신만만 취미 |
      | 나 홀로 학교에 |
      | 두근두근 학교에 가면 |
      | 스스로 척척 |
      | 말짱 인기짱 프로젝트 |
      | 조심조심 안전 |
      | 생생 자연관찰 |
      | 몽글몽글 과학 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 스마트올 라이브러리 링크 기능 확인 (totalFunction_058)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 스마트올 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "스마트올 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | 초등필독서 |
      | 교과서 수록 도서 |
      | 기관 추천 어린이 도서 |
      | 기관 추천 청소년 도서 |
      | 초등교양서 |
      | 수준별 영어 도서관 |
      | Disney |
      | 영어TV |
      | BBC Kids |
      | nickelodeon |
      | McGraw-Hill |
      | ABDO |
      | BEARPORT |
      | 프리미엄 원서 마스터 |
      | 독해완성 |
      | 시시콜콜한국사 |
      | 몽글몽글 과학 |
      | 룰루랄라예체능 |
      | 슬기로운초등생활 |
      | 자신만만 취미 |
      | 우리끼리랭킹 |
      | 두근두근 직업 |
      | 콩닥콩닥 초등 준비 |
      | VR 한국사 |
      | Song & Toon |
      | 인물별 한국사 |
      | 코딩학습_첫걸음 |
      | 코딩학습_기초 |
      | 코딩학습_응용 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 교과 라이브러리 링크 기능 확인 (totalFunction_059)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 교과 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "교과 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | 누리과정 연계도서 |
      | 초등교과 연계도서 |
      | 중등 필독서 |

  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 투데이 라이브러리 링크 기능 확인 (totalFunction_060)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 투데이 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "투데이 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | 역사 |
      | 스마트독서 |
      | 토이 |


  #권한이 필요한 맘스클럽 메뉴 제외
  @pass
  Scenario Outline: [라이브러리 - 전체메뉴] 독서 라이브러리 링크 기능 확인 (totalFunction_061)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "전체메뉴" 서브메뉴 클릭
    And 라이브러리 전체메뉴 독서 라이브러리 "<menu>" 서브메뉴 클릭
    Then 라이브러리 전체메뉴 "독서 라이브러리" "<menu>" 콘텐츠 확인

    Examples:
      | menu |
      | 추천 키워드 |
      | 분야 전체 |
      | 새로나온 콘텐츠 |
      | 교과서 수록 도서 |
      | 기관 추천 어린이 도서 |
      | 기관 추천 청소년 도서 |
      | 인터랙티브북 |
      | AR Science |
      | Animation |
      | Storybook |
      | Readers |
      | 플레이북 |
      | 그림책 |
      | 문학 |
      | 백과 |
      | 인성•철학 |
      | 과학/수학 |
      | 사회/문화 |
      | 인물 |
      | 역사 |
      | 아트 |
      | 뮤직 |
      | 토이 |
      | 만화 |
      | 중고등 필독서 |
      | 앱 |
      | 투데이 |
      | 생활주제책읽기 |
      | 안전•생활 습관 |
      | 의사소통 |
      | 사회관계 |
      | 자연탐구 |
      | 예술경험 |
      | 신체운동건강 |
      | 초등학습 |
      | 유아학습 |
      | Interactive Book |

##### [일반] 메뉴 관련 (독서앨범, 스마트올 백과 등)

  @pass
  Scenario: [독서앨범] 구성 확인 (totalFunction_062)
    Given 독서앨범 버튼 클릭
    Then 독서앨범 화면구성 확인

  @pass
  Scenario: [독서앨범 - 새소식] 기능 확인 (totalFunction_063)
    Given 독서앨범 버튼 클릭
    When 독서앨범 새소식 메뉴 클릭
    Then 독서앨범 새소식 콘텐츠 확인
    When 독서앨범 새소식 추가 버튼 클릭
    Then 독서앨범 새소식 추가 화면구성 확인
    When 독서앨범 새소식 라이브러리 추가 버튼 클릭
    Then 라이브러리 메뉴 이동 확인

  @pass
  Scenario: [독서앨범 - 친구 작품 보기] 기능 확인 (totalFunction_064)
    Given 독서앨범 버튼 클릭
    When 독서앨범 친구 작품 보기 메뉴 클릭
    Then 독서앨범 친구 작품 보기 화면구성 확인
    When 독서앨범 친구 작품 보기 "감상문" 탭 클릭
    And 독서앨범 친구 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 친구 작품 보기 탭 화면구성 확인
    When 일반 뒤로가기 버튼 클릭
    And 독서앨범 친구 작품 보기 "사용자 오디오이북" 탭 클릭
    And 독서앨범 친구 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 친구 작품 보기 탭 화면구성 확인
    When 일반 뒤로가기 버튼 클릭
    And 독서앨범 친구 작품 보기 "일기" 탭 클릭
    And 독서앨범 친구 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 친구 작품 보기 탭 화면구성 확인

  #해당 콘텐츠가 있는 경우에만 확인됨
  @pass
  Scenario: [독서앨범 - 내 작품 보기] 기능 확인 (totalFunction_065)
    Given 독서앨범 버튼 클릭
    When 독서앨범 내 작품 보기 메뉴 클릭
    Then 독서앨범 내 작품 보기 화면구성 확인
    When 독서앨범 내 작품 보기 "감상문" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인
    When 독서앨범 내 작품 보기 "사용자 오디오이북" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인
    When 독서앨범 내 작품 보기 "일기" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인
    When 독서앨범 내 작품 보기 "사진" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인
    When 독서앨범 내 작품 보기 "동영상" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인
    When 독서앨범 내 작품 보기 "학습" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    Then 독서앨범 내 작품 보기 탭 화면구성 확인

  @pass
  Scenario: [검색] 구성 확인 (totalFunction_066)
    Given 검색 버튼 클릭
    Then 검색 화면구성 확인

  @pass
  Scenario: [스마트올 백과] 실행 확인 (totalFunction_067)
    Given 스마트올 백과 버튼 클릭
    When 5초 대기
    Then 스마트올 백과 실행 확인

  @pass
  Scenario: [스마트올 백과 - 연표] 실행 확인 (totalFunction_068)
    Given 스마트올 백과 버튼 클릭
    When 5초 대기
    And 스마트올 백과 연표 아이콘 클릭
    And 5초 대기
    Then 스마트올 백과 연표 실행 확인

  @pass
  Scenario: [설정] 구성 확인 (totalFunction_069)
    Given 설정 버튼 클릭
    Then 설정 화면구성 확인

  @pass
  Scenario: [웅진 스마트올] 구성 확인 (totalFunction_070)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    Then 웅진 스마트올 메뉴구성 확인

  @pass
  Scenario: [웅진 스마트올 - 오늘의 학습] 기능 확인 (totalFunction_071)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "오늘의 학습" 서브메뉴 클릭
    Then 웅진 스마트올 오늘의 학습 실행 확인

  @pass
  Scenario: [웅진 스마트올 - AI 학습센터] AI 학습센터 기능 확인 (totalFunction_072)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "AI 학습센터" 서브메뉴 클릭
    And 웅진 스마트올 AI 학습센터 "AI 학습센터" 서브메뉴 클릭
    Then 웅진 스마트올 AI 학습센터 AI 학습센터 실행 확인

  @pass
  Scenario: [웅진 스마트올 - AI 학습센터] 영어 기능 확인 (totalFunction_074)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "AI 학습센터" 서브메뉴 클릭
    And 웅진 스마트올 AI 학습센터 "영어" 서브메뉴 클릭
    Then 웅진 스마트올 AI 학습센터 영어 실행 확인

  @pass
  Scenario: [웅진 스마트올 - AI 학습센터] AI 연산 기능 확인 (totalFunction_075)
    Given 웅진 스마트올 버튼 클릭
    And 5초 대기
    When 웅진 스마트올 - "AI 학습센터" 서브메뉴 클릭
    And 웅진 스마트올 AI 학습센터 "AI 연산" 서브메뉴 클릭
    Then 웅진 스마트올 AI 학습센터 AI 연산 실행 확인

  @pass
  Scenario: [웅진 스마트올 - AI 학습센터] 독서 기능 확인 (totalFunction_076)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "AI 학습센터" 서브메뉴 클릭
    And 웅진 스마트올 AI 학습센터 "독서" 서브메뉴 클릭
    Then 웅진 스마트올 AI 학습센터 독서 실행 확인

  @pass
  Scenario: [웅진 스마트올 - AI 학습센터] 공부지원게임 기능 확인 (totalFunction_077)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "AI 학습센터" 서브메뉴 클릭
    And 웅진 스마트올 AI 학습센터 "공부지원/게임" 서브메뉴 클릭
    Then 웅진 스마트올 AI 학습센터 공부지원게임 실행 확인

  @pass
  Scenario: [웅진 스마트올 - 초등 포털] 기능 확인 (totalFunction_078)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "초등 포털" 서브메뉴 클릭
    Then 웅진 스마트올 초등 포털 실행 확인

  @pass
  Scenario: [웅진 스마트올 - 전체과목] 기능 확인 (totalFunction_079)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "전체과목" 서브메뉴 클릭
    Then 웅진 스마트올 전체과목 실행 확인

  @pass
  Scenario: [웅진 스마트올 - 라이브러리] 기능 확인 (totalFunction_080)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "라이브러리" 서브메뉴 클릭
    Then 라이브러리 홈 화면구성 "필독선 라이브러리" 확인

  @pass
  Scenario: [웅진 스마트올 - 스타샵] 기능 확인 (totalFunction_081)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "스타샵" 서브메뉴 클릭
    Then 웅진 스마트올 스타샵 실행 확인

  @pass
  Scenario: [웅진 스마트올 - 올링고 번역] 기능 확인 (totalFunction_082)
    Given 웅진 스마트올 버튼 클릭
    When 5초 대기
    And 웅진 스마트올 - "올링고 번역" 서브메뉴 클릭
    Then 웅진 스마트올 올링고 번역 실행 확인
    And 웅진 북클럽 진입


  ##### 동영상 플레이어 실행 확인 (밤에 가동하려면 북킄럽매니저에서 콘텐츠 제어 설정 필요)
  @pass
  Scenario: [앱 라이브러리] 동영상 플레이어 실행 확인 (totalFunction_083)
    Given 라이브러리 버튼 클릭
    When 라이브러리 - "마이" 서브메뉴 클릭
    And 라이브러리 마이 "낱권" 서브메뉴 클릭
    And 라이브러리 마이 낱권 "동영상" 서브메뉴 클릭
    And 라이브러리 마이 낱권 첫번째 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    And 앱 라이브러리 첫번째 동영상 클릭
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 한글깨치기] 동영상 플레이어 실행 확인 (totalFunction_084)
    Given 학습 버튼 클릭
    When "한글깨치기" 과목 클릭
    And 5초 대기
    And "한글깨치기" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 본학습단계 클릭
    And "한글깨치기" 과목 "15-1호" 단계 클릭
    And 2초 대기
    And 책이랑 글자랑 영역 콘텐츠 클릭
    And 5초 대기
    And Reading continue "No"
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 개정수학] 동영상 플레이어 실행 확인 (totalFunction_085)
    Given 학습 버튼 클릭
    When "개정수학" 과목 클릭
    And 5초 대기
    And "개정수학" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 개정수학 D단계 클릭
    And "개정수학" 과목 "5호" 단계 클릭
    And 2초 대기
    And 개념이 쏙쏙1 영역 콘텐츠 클릭
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 초고수학] 동영상 플레이어 실행 확인 (totalFunction_086)
    Given 학습 버튼 클릭
    When "초고수학" 과목 클릭
    And 5초 대기
    And "초고수학" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 초고수학 G단계 클릭
    And "초고수학" 과목 "1호" 단계 클릭
    And 2초 대기
    And 투데이 스터디1 영역 콘텐츠 클릭
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 국어] 동영상 플레이어 실행 확인 (totalFunction_087)
    Given 학습 버튼 클릭
    When "국어" 과목 클릭
    And 5초 대기
    And "국어" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 국어 F단계 클릭
    And "국어" 과목 "1호" 단계 클릭
    And 2초 대기
    And 투데이 스터디1 영역 콘텐츠 클릭
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 사회] 동영상 플레이어 실행 확인 (totalFunction_088)
    Given 학습 버튼 클릭
    When "사회" 과목 클릭
    And 5초 대기
    And "사회" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 사회 E단계 클릭
    And "사회" 과목 "1호" 단계 클릭
    And 2초 대기
    And 개념쏙속1 영역 콘텐츠 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 과학] 동영상 플레이어 실행 확인 (totalFunction_089)
    Given 학습 버튼 클릭
    When "과학" 과목 클릭
    And 5초 대기
    And "과학" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 과학 E단계 클릭
    And "과학" 과목 "1호" 단계 클릭
    And 2초 대기
    And 개념쏙속1 영역 콘텐츠 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - Vacabulary Master] 동영상 플레이어 실행 확인 (totalFunction_090)
    Given 학습 버튼 클릭
    When "Vacabulary Master" 과목 클릭
    And 5초 대기
    And "Vacabulary Master" 학습단계 확인 버튼 클릭
    And 2초 대기
    And Vacabulary Master 2단계 클릭
    And "Vacabulary Master" 과목 "1호" 단계 클릭
    And 2초 대기
    And Chant 영역 콘텐츠 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 생각토론] 동영상 플레이어 실행 확인 (totalFunction_091)
    Given 학습 버튼 클릭
    When "생각토론" 과목 클릭
    And 5초 대기
    And "생각토론" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 생각토론 C단계 클릭
    And "생각토론" 과목 "1호" 단계 클릭
    And 2초 대기
    And 꼬물꼬물 이야기 극장 영역 콘텐츠 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [학습 - 테마논술] 동영상 플레이어 실행 확인 (totalFunction_092)
    Given 학습 버튼 클릭
    When "테마논술" 과목 클릭
    And 5초 대기
    And "테마논술" 학습단계 확인 버튼 클릭
    And 2초 대기
    And 테마논술 C단계 클릭
    And "테마논술" 과목 "10호" 단계 클릭
    And 2초 대기
    And 꼬물꼬물 이야기 극장 영역 콘텐츠 클릭
    And 5초 대기
    Then 플레이어 실행 확인
    And 플레이어 종료하기

  @pass
  Scenario: [독서앨범] 동영상 플레이어 실행 확인 (totalFunction_093)
    Given 독서앨범 버튼 클릭
    When 독서앨범 내 작품 보기 메뉴 클릭
    And 독서앨범 내 작품 보기 "동영상" 탭 클릭
    And 독서앨범 내 작품 보기 탭 콘텐츠 클릭
    And 독서앨범 내 작품 보기 동영상 보기 클릭
    Then 독서앨범 동영상 실행 확인
    And 독서앨범 동영상 종료하기

  @pass
  Scenario: [학습 - 수학마스터] 동영상 플레이어 실행 확인 (totalFunction_094)
    Given 학습 버튼 클릭
    When "수학마스터" 과목 클릭
    And 10초 대기
    And 수학마스터 동영상 강의 영역 콘텐츠 클릭
    And 수학마스터 학습단계 선택 리스트 클릭
    And 2초 대기
    And 수학마스터 1-1 단계 클릭
    And 수학마스터 "[동영상] 1. 소인수분해" 단계 클릭
    And 수학마스터 첫번째 강의 클릭
    Then 플레이어 실행 확인
    And 플레이어 종료하기