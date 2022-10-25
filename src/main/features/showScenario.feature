Feature: showScenario feature

# 해당 도서에서만 수행 가능한 시나리오 (사전 검색 시 어떠한 엘리먼트도 잡아낼 수 없어서 TouchAction으로 x,y offset을 활용)
  Scenario: 사전 검색 동작 확인 - PORTRAIT (showScenario_001)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "홍쌤의 최강 수학" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 하단바에서 펼쳐보기 버튼 클릭
    And 펼쳐보기 리스트의 10번째 페이지로 이동
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 사전 버튼 클릭
    And 5초 대기
    And 사전 검색 X:754 Y:509
    And "선택한 단어를 검색합니다" 문구가 담긴 토스트 팝업 노출 확인
    And 5초 대기
    Then 사전검색 화면 확인
    And 사전검색 화면의 X 버튼 클릭
    Then 사전검색 텍스트 찾기 화면으로 재이동 확인
    And 10자 이상 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인
    And 5초 대기
    And 사전 검색 종료 버튼 클릭
    Then "책 읽기 상태로 변경됩니다" 문구가 담긴 토스트 팝업 노출 확인


  Scenario: 마이 - 오디오이북 연속재생 완료 동작 확인 (showScenario_002)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 14초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 14초 대기
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    And 짝꿍책 선택 레이아웃 노출 시 닫기
    And 검색 결과 화면에서 뒤로가기 버튼
    When 마이 버튼 클릭
    And 마이 - 오디오 이북 클릭
    And 3초 대기
    And 마이 - 오디오 이북에서 읽은순 버튼 클릭
    And 연속재생 버튼 클릭
    And 마이 - 오디오 이북의 연속 재생할 책 1권 선택
    And 연속재생 버튼 클릭
    And 알림팝업 우측 버튼 클릭
    And 5초 대기
    And Next page 5번 실행
    And 15초 대기
    Then 라이브러리 화면으로 돌아감 확인

  Scenario: 제어 전체 동영상 남은 횟수 확인 (showScenario_003)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 제어 설정 시 초기화
    When 검색 "첫생활그림책 늠름 테마송 애니메이션" 재실행
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 동영상 기준 클릭
    Then 20초 대기 후 전체 동영상 남은 횟수 감소 확인
    When 제어 설정 시 초기화

  Scenario: 학습 플레이어 배속설정 동작 확인 (showScenario_004)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    And 학습 화면 표출 안될 때 화면 터치
    When 학습배속설정 버튼 클릭
    When 5초 대기
    And 학습 화면 표출 안될 때 화면 터치
    Then 배속설정 "1.2" 로변경
    When 학습배속설정 버튼 클릭
    When 5초 대기
    And 학습 화면 표출 안될 때 화면 터치
    Then 배속설정 "1.5" 로변경
    When 학습배속설정 버튼 클릭
    When 5초 대기
    And 학습 화면 표출 안될 때 화면 터치
    Then 배속설정 "1.8" 로변경
    When 학습배속설정 버튼 클릭
    When 5초 대기
    And 학습 화면 표출 안될 때 화면 터치
    Then 배속설정 "2" 로변경
    When 학습배속설정 버튼 클릭
    When 5초 대기
    And 학습 화면 표출 안될 때 화면 터치
    Then 배속설정 "0.8" 로변경

  Scenario: 학습 플레이어 짝꿍책 동작 후 감상문 작성 확인 (showScenario_005)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 한글깨치기 버튼 클릭
    When 10초 대기
    When 한글깨치기 단계선택 버튼 클릭
    When 한글깨치기 본학습단계 클릭
    When 한글깨치기 "15-2호 / 낱말 학습|신체 이름 익히기" 클릭
    When 어, 잠깐 클릭
    When 10초 대기
    When 짝꿍책 클릭
    When 10초 대기
    And "읽던 페이지를 이어서 볼까요?" 알람 표출시 취소
    Then 뷰어 화면 진입 확인
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    Then "독서감상문 쓰기로 이동할까요?" 안내 문구 일반 팝업 확인
    And 일반 안내 팝업의 취소 버튼 클릭
    Then 일반 안내 팝업 사라짐 확인
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 3초 대기
    Then 독서감상문 쓰기 화면으로 이동 확인
    And 3초 대기
    And 감상문 3개 모두 작성하기
    Then 감상문 3개 모두 작성한 경우 화면 확인
    And 감상문 3개 모두 작성한 화면에서 임의의 감상문 삭제 버튼 클릭
    Then 독서감상문 쓰기 화면으로 이동 확인

  Scenario: 이어보기 와이파이 녹음 동작 확인 (showScenario_006)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    And 짝꿍책 선택 레이아웃 노출 시 닫기
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 3초 대기
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 녹음 버튼 클릭
    And 기녹음이 있는 경우 확인 버튼 클릭
    And "녹음모드로 전환 중입니다" 문구가 담긴 토스트 팝업 노출 확인
    Then 녹음모드 화면 확인
    And 녹음 시작 버튼 클릭
    And 해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭
    Then 녹음 진행 중 확인
    And 2초 대기
    And 녹음 시작 버튼 클릭
    And 오른쪽에서 왼쪽으로 스와이프
    And 5초 대기
    And 왼쪽에서 오른쪽으로 스와이프
    Then 녹음 완료한 페이지 화면 확인
    And 녹음 시작 버튼 클릭
    Then "이전에 녹음한 이력이 있습니다." 안내 문구 일반 팝업 확인
    And 일반 안내 팝업의 취소 버튼 클릭
    Then 녹음 완료한 페이지 화면 확인
    And 녹음 시작 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then 녹음 진행 중 확인
    And 5초 대기
    And 녹음 시작 버튼 클릭
    And 오른쪽에서 왼쪽으로 스와이프
    And 5초 대기
    And 왼쪽에서 오른쪽으로 스와이프
    And 녹음 재생 버튼 클릭
    Then 녹음 재생중 확인
    And 5초 대기
    And 녹음 재생 버튼 클릭
    And 2초 대기
    And 녹음 화면에서 X 버튼 클릭
    Then "녹음을 종료하고, 책읽기 화면으로 돌아갈까요?" 안내 문구 일반 팝업 확인
    And 일반 안내 팝업의 취소 버튼 클릭
    Then 녹음모드 화면 확인
    And 녹음 화면에서 X 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then 녹음모드 아닌 화면 확인
    And Next page 5번 실행
    And 마지막 페이지 도달 시 노출되는 알림팝업의 종료 버튼 클릭
    And 15초 대기
    And Turn "Off" WiFi
    And 플레이어 내에서 상단바 노출
    And 녹음 버튼 클릭
    And 3초 대기
    And 오디오북 만들기 전 화면에서 배경음 선택 시 3번째 배경음 선택
    And 오디오북 만들기 버튼 클릭
    Then "Wi-Fi를 연결해주세요" 문구가 담긴 토스트 팝업 노출 확인
    Then Turn "On" WiFi