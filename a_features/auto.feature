Feature: Default


Scenario: 이어보기 와이파이 녹음 동작 확인 (show_scenario_006)

    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "" 입력
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
    Then "실패 시연" 안내 문구 일반 팝업 확인
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

