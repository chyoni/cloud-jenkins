Feature: playerIntegratedScenario feature

  Scenario: 통합 플레이어 재생중 이전, 다음 버튼 동작과 일시정지중 이전, 다음 버튼 동작 확인 (playerIntegratedScenario_001)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 4초 대기
    When 동영상 재생 확인
    When 이전 버튼 클릭
    When 2초 대기
    When 동영상 재생 확인
    When 다음 버튼 클릭
    When 2초 대기
    When 동영상 재생 확인
    When 일시정지_재생 버튼 클릭
    When 이전 버튼 클릭
    When 2초 대기
    When 동영상 재생 확인
    When 일시정지_재생 버튼 클릭
    When 다음 버튼 클릭
    When 2초 대기
    When 동영상 재생 확인

  Scenario: 통합 플레이어 제어 시간 선택 후 동일 동영상 선택으로 변경 확인 (playerIntegratedScenario_002)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    And 제어 설정 시 초기화
    When 검색 "첫생활그림책 늠름 테마송 애니메이션" 재실행
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 시청 시간 15분으로 설정
    Then 동영상 시청 제한 확인 버튼 클릭
    When 4초 대기
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 동영상 기준 클릭
    Then 20초 대기 후 전체 동영상 남은 횟수 감소 확인
    When 제어 설정 시 초기화

  Scenario: 통합 플레이어 전체 동영상 횟수 제어 음악으로 이동 후 동작 확인 (playerIntegratedScenario_003)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    And 제어 설정 시 초기화
    When 검색 "첫생활그림책 늠름 테마송 애니메이션" 재실행
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 동영상 기준 클릭
    Then 동영상 시청 제한 확인 버튼 클릭
    Then 20초 대기 후 전체 동영상 남은 횟수 감소 확인
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 5초 대기
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 5초 대기
    Then 20초 대기 후 전체 동영상 남은 횟수 감소 확인
    When 제어 설정 시 초기화