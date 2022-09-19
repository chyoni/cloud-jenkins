Feature: Sample Feature

  @sample
  Scenario: 설정 버튼 클릭
    Given 학습 버튼 클릭
    When 설정 버튼 클릭
    When 공지 - 이벤트 클릭
    Then 공지사항 버튼 클릭

  @sample
  Scenario: Vertical swipe test
    Given 스크롤 후 "학습 체험판" 버튼 클릭