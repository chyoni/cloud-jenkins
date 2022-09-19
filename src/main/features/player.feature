

  Feature: player feature

  Scenario: 나가기 후 취소 동영상 재생 확인 (player_001)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 취소 버튼 클릭
    Then 동영상 재생 확인

  Scenario: 나가기 후 확인 버튼 동작 확인 (player_002)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 나가기 버튼 클릭
    Then 동영상 일시 정지
    When 확인 버튼 클릭
    Then "검색" 화면으로 이동

  Scenario: 동영상 음악 버튼 동작 확인 (player_003)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    Then 동영상 재생 확인

  Scenario: 제어 버튼 동작 확인 (player_004)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 시계 버튼 클릭
    Then "비밀번호 입력" 창 표출

  Scenario: 잠금 버튼 동작 확인 (player_005)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 잠금 버튼 클릭
    Then 전체화면으로 변경
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인
    And 2초 대기
    When 화면 1번 터치
    When 잠금해제 버튼 클릭
    Then 일반화면으로 변경
    Then "잠금이 해제되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 2초 대기


  Scenario: 동영상 이름 확인 (player_006)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When "첫생활그림책 늠름 테마송 애니메이션" 이름 확인


  Scenario: 동영상 전체화면 버튼 확인 (player_007)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 전체화면 버튼 클릭
    Then 전체화면으로 변경
    When 5초 대기
    And 동영상 재생 확인
    When 화면 1번 터치
    Then 일반화면으로 변경
    When 2초 대기
    And 동영상 재생 확인

  Scenario: 동영상 화면선택 전체화면 확인 (player_008)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 화면 1번 터치
    Then 전체화면으로 변경
    When 2초 대기
    And 동영상 재생 확인
    When 화면 1번 터치
    Then 일반화면으로 변경
    When 2초 대기
    And 동영상 재생 확인

  Scenario: 동영상 이전, 다음 버튼 확인 (player_009)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 이전 버튼 클릭
    When 4초 대기
    Then 동영상 재생 확인
    And "아주 아주 차가운 얼음" 동영상 이름 확인
    When 다음 버튼 클릭
    When 4초 대기
    Then 동영상 재생 확인
    And "첫생활그림책 늠름 테마송 애니메이션" 동영상 이름 확인




  Scenario: 동영상 재생, 일시정지 버튼 확인 (player_010)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    When 일시정지_재생 버튼 클릭
    When 3초 대기
    Then 동영상 일시 정지
    When 일시정지_재생 버튼 클릭
    When 3초 대기
    Then 동영상 재생 확인

  Scenario: 제어 버튼 취소 (player_011)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 2초 대기
    When 비밀번호 입력 취소 버튼 클릭
    Then "첫생활그림책 늠름 테마송 애니메이션" 동영상 이름 확인

  Scenario: 제어 전체 동영상 남은 횟수 확인 (player_012)
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

  Scenario: 제어 동일 동영상 남은 횟수 확인 (player_013)
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
    When 동일 동영상 기준 클릭
    Then 20초 대기 후 동일 동영상 남은 횟수 감소 확인
    When 제어 설정 시 초기화

    Scenario: 제어 남은 시간 확인 (player_014)
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
    When 전체 시청 시간 클릭
    Then 15초 대기 후 전체 시청 시간 감소 확인
    When 제어 설정 시 초기화

  Scenario: 재생목록 영상 재생 (player_015)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 재생목록에서 0번째 항목 선택
    Then 동영상 재생 확인
    When 재생목록에서 1번째 항목 선택
    Then 동영상 재생 확인

  Scenario: 생각 라이브러리 이동 취소 확인 (player_016)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 생각 라이브러리 버튼 클릭
    Then 동영상 일시 정지
    When 2초 대기
    Then "라이브러리로 이동하시겠습니까?" 팝업 표출
    When 아니오 선택
    Then 동영상 재생 확인

  Scenario: 생각 라이브러리 이동 확인 (player_017)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 생각 라이브러리 버튼 클릭
    When 2초 대기
    Then "라이브러리로 이동하시겠습니까?" 팝업 표출
    When 예 선택
    When 2초 대기
    Then 홈 화면으로 이동 확인

  Scenario: 생각 라이브러리 재생목록 편집 확인 (player_018)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 표출
    And  재생목록 이미지 휴지통으로 변경
    And  취소 버튼 표출

  Scenario: 생각 라이브러리 재생중인 재생목록 삭제 확인 (player_019)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 1번째 항목 삭제
    Then "현재 재생중인 영상은 삭제할 수 없습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 생각 라이브러리 재생목록 삭제 확인 (player_020)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 0번째 항목 삭제
    Then "1개의 목록이 삭제되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 생각 라이브러리 재생목록 전체 삭제 취소 (player_021)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    When 재생목록 편집 버튼 클릭
    When 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 확인
    When 아니오 선택
    Then 동영상 재생 확인

  Scenario: 생각 라이브러리 재생목록 전체 삭제 확인 (player_022)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 편집 버튼 클릭
    When 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 확인
    When 예 선택
    When 2초 대기
    And  재생영역에 아무것도 없음 확인
    And  라이브러리 바로가기 버튼 클릭
    And 2초 대기
    And  홈 화면으로 이동 확인

  Scenario: 학습 플레이어 메뉴 표시 확인 (player_023)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    And 화면 1번 터치
    And 학습 플레이어 메뉴 확인

  Scenario: 학습 플레이어 나가기 버튼 동작 확인 (player_024)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    When 동영상 재생 확인
    And 화면 1번 터치
    When 학습 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 취소 버튼 클릭
    When 10초 대기
    When 동영상 재생 확인
    And 화면 1번 터치
    When 학습 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 확인 버튼 클릭
    When 3초 대기
    Then "사 회" 화면으로 이동

  Scenario: 학습 플레이어 재생 일시정지 동작 확인 (player_025)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    And 화면 1번 터치
    When 학습 플레이어 재생_일시정지 버튼 클릭
    Then 동영상 일시 정지
    When 3초 대기
    When 학습 플레이어 재생_일시정지 버튼 클릭
    Then 동영상 재생 확인

  Scenario: 학습 플레이어 잠금버튼 동작 확인 (player_026)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    And 화면 1번 터치
    When 학습잠금 버튼 클릭
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인
    And 2초 대기
    When 학습잠금 버튼 클릭
    Then "잠금이 해제되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 학습 플레이어 배속설정 동작 확인 (player_027)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    And 화면 1번 터치
    When 학습배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.2" 로변경
    When 학습배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.5" 로변경
    When 학습배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.8" 로변경
    When 학습배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "2" 로변경
    When 학습배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "0.8" 로변경

  Scenario: 배속설정 동작 확인 (player_028)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.2" 로변경
    When 배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.5" 로변경
    When 배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "1.8" 로변경
    When 배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "2" 로변경
    When 배속설정 버튼 클릭
    When 2초 대기
    Then 배속설정 "0.8" 로변경

  Scenario: 학습 플레이어 자막버튼 표출 확인 (player_085)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When Reading Master 버튼 클릭
    When 10초 대기
    When 리딩마스터 영상 버튼 클릭
    When 10초 대기
    And 화면 표줄 안될 때 화면 1번 터치
    Then 자막버튼 표출 확인



  Scenario: 학습 플레이어 짝꿍책 동작 확인 (player_029)
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

  Scenario: 학습 플레이어 핵심용어 버튼 확인 (player_030)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 사회 버튼 클릭
    When 좌측 상단 단계선택 버튼 클릭
    When F단계 클릭
    When 1호 클릭
    When 개념쏙쏙1 클릭
    When 10초 대기
    And 화면 1번 터치
    Then 일시정지 후 핵심용어 버튼 표출 확인

  Scenario: 음악 플레이어 잠금 후 동작 확인 (player_031)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 잠금 버튼 클릭
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인
    And 2초 대기
    When 일시정지_재생 버튼 클릭
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 음악 플레이어 음악명 확인 (player_046)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 전체 삭제 동작
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    Then 플레이리스트 0번째와 이름 확인

  Scenario: 음악 플레이어 가사 없음 확인 (player_047)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When "등록된 가사가 없습니다." 텍스트 확인

  Scenario: 음악 플레이어 가사 있음 확인 (player_048)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 세트 목록보기에 1페이지 4번 째 컨텐츠 클릭
    When 10초 대기
    When 컨텐츠 리스트중 "새근새근 잠자리 동요" 클릭
    When 5초 대기
    When 일시정지_재생 좌표 클릭
    Then "반짝반짝 작은 별 아름답게 비치네" 가사 확인

  Scenario: 음악 플레이어 자동 꺼짐 설정 버튼 확인 (player_032)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 자동 꺼짐 설정 버튼 클릭
    Then "자동 꺼짐 설정" 시간 설정 팝업 표출
    When 시간 변경 동작 확인

  Scenario: 음악 플레이어 자동 꺼짐 설정 동작 확인 (player_033)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 자동 꺼짐 설정 버튼 클릭
    Then "자동 꺼짐 설정" 시간 설정 팝업 표출
    And 자동 꺼짐 설정 확인 버튼 클릭
    And 20초 대기 후 자동 꺼짐 시간 변경 확인

  Scenario: 음악 플레이어 재생목록 동작 확인 (player_034)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 전체 삭제 동작
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    When 음악재생목록에서 2번째 항목 선택
    When 5초 대기
    Then 동영상 재생 확인
    When 음악재생목록에서 3번째 항목 선택
    When 5초 대기
    Then 동영상 재생 확인
    When 음악재생목록에서 1번째 항목 선택
    When 5초 대기
    Then 동영상 재생 확인

  Scenario: 음악 플레이어 재생목록 편집 버튼 확인 (player_035)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 표출
    And  음악 재생목록 이미지 휴지통으로 변경
    And  취소 버튼 표출

  Scenario: 음악 플레이어 현재 재생중인 음원 삭제 확인 (player_036)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 전체 삭제 동작
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 0번째 항목 휴지통 선택
    Then "현재 재생중인 음원은 삭제할 수 없습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 음악 플레이어 음원 삭제 확인 (player_037)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 전체 삭제 동작
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 2번째 항목 휴지통 선택
    Then "1개의 목록이 삭제되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 음악 플레이어 전체 삭제 확인 (player_038)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    And "전체 재생목록이 삭제됩니다." 팝업 표출
    And 취소 버튼 클릭

  Scenario: 음악 플레이어 전체 삭제 동작 확인 (player_039)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    And "전체 재생목록이 삭제됩니다." 팝업 표출
    And 확인 버튼 클릭
    And "개의 목록이 삭제되었습니다" 문구가 담긴 토스트 팝업 노출 확인
    And  재생영역에 아무것도 없음 확인
    And  라이브러리 바로가기 버튼 클릭
    And 2초 대기
    And  홈 화면으로 이동 확인

  Scenario: 초고 플레이어 재생 확인 (player_040)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    When 화면 표줄 안될 때 화면 1번 터치
    And 학습 플레이어 메뉴 확인

  Scenario: 초고 플레이어 나가기 버튼 동작 확인 (player_041)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    When 화면 표줄 안될 때 화면 1번 터치
    When 학습 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 취소 버튼 클릭
    Then 동영상 재생 확인
    When 화면 표줄 안될 때 화면 1번 터치
    When 학습 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 확인 버튼 클릭
    Then "수학" 화면으로 이동

  Scenario: 초고 플레이어 재생 일시정지 동작 확인 (player_042)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    And 화면 1번 터치
    When 학습 플레이어 재생_일시정지 버튼 클릭
    Then 동영상 일시 정지
    When 3초 대기
    When 학습 플레이어 재생_일시정지 버튼 클릭
    Then 동영상 재생 확인

  Scenario: 초고 플레이어 영상 완료 후 다시보기 확인 (player_043)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    And 화면 1번 터치
    When 영상 마지막 부분으로 이동
    When 5초 대기
    Then "동영상이 종료되었습니다." 팝업 표출
    When 다시보기 버튼 클릭
    When 5초 대기
    Then 동영상 재생 확인

  Scenario: 초고 플레이어 영상 완료 후 나가기 확인 (player_044)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    And 화면 1번 터치
    When 영상 마지막 부분으로 이동
    When 5초 대기
    Then "동영상이 종료되었습니다." 팝업 표출
    When 취소 버튼 클릭
    Then "수학" 화면으로 이동

  Scenario: 초고 플레이어 선생님 영상보기 확인 (player_045)
    Given 라이브러리 버튼 클릭
    When 학습 버튼 클릭
    When 3초 대기
    When 수학2 버튼 클릭
    When 5초 대기
    When 수학 좌측 상단 단계선택 버튼 클릭
    When 수학 "F단계" 클릭
    When 수학 1호 클릭
    When 개념강의1 클릭
    When 5초 대기
    Then 동영상 재생 확인
    And 5초 대기
    And 화면 1번 터치
    And 선생님 영상보기 버튼 클릭
    And 5초 대기
    Then 동영상 재생 확인

  Scenario: 일시 정지 후 나가기 확인 (player_049)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 일시정지_재생 버튼 클릭
    And 동영상 일시 정지
    When 나가기 버튼 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭

  Scenario: 재생목록 편집 후 동영상 재생 확인 (player_050)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션,바나나 댄스" 재생목록에 추가 동작
    When 4초 대기
    And 영상 마지막으로 이동
    When 4초 대기
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 0번째 항목 삭제
    Then "1개의 목록이 삭제되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 재생목록 편집 취소 버튼 클릭
    And 4초 대기
    And 일시정지_재생 버튼 클릭
    And 4초 대기
    When 동영상 재생 확인

  Scenario: 재생목록 이동 후 나가기 동작 확인 (player_051)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션,바나나 댄스" 재생목록에 추가 동작
    When 4초 대기
    When 동영상 재생 확인
    When 재생목록에서 0번째 항목 선택
    When 1초 대기
    When 동영상 재생 확인
    When 나가기 버튼 클릭
    Then 동영상 일시 정지
    Then "동영상이 종료됩니다." 팝업 표출

  Scenario: 재생목록 전체삭제 후 음악으로 이동 확인 (player_052)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 표출
    And 확인 버튼 클릭
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭
    And 동영상 플레이어의 상단영역 표출 확인

  Scenario: 시청 제한 후 전체화면 동작 확인 (player_053)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When 제어 설정 시 초기화
    When "Andy and the Bowerbird,Andy and the Coati" 재생목록에 추가 동작
    When 4초 대기
    When 동영상 재생 확인
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 시청 시간 15분으로 설정
    Then 동영상 시청 제한 확인 버튼 클릭
    And 재생목록에서 0번째 항목 선택
    When 900초 대기
    Then "오늘은 이제 그만" 팝업 표출
    And 확인 버튼 클릭
    And 제어 설정 시 초기화

  Scenario: 재생목록 전체 삭제 후 잠금버튼 확인 (player_054)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 표출
    When 팝업 예 버튼 클릭
    Then 잠금 버튼 확인

  Scenario: 재생목록 전체 삭제 후 화면 동작 확인 (player_055)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 표출
    When 팝업 예 버튼 클릭
    When 2초 대기
    Then 화면 288 365 지점 터치
    Then 화면 1605 303 지점 터치
    Then 화면 311 902 지점 터치
    Then 화면 1605 933 지점 터치

  Scenario: 재생목록 다음버튼 선택 후 나가기 동작 확인 (player_056)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 4초 대기
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 4초 대기
    When 재생목록에서 0번째 항목 선택
    When 동영상 재생 확인
    When 다음 버튼 클릭
    When 1초 대기
    When 나가기 버튼 클릭
    Then 동영상 일시 정지
    Then "동영상이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭

  Scenario: 시청 제한 후 동영상 재생 확인 (player_057)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 제어 설정 시 초기화
    When 검색 "첫생활그림책 늠름 테마송 애니메이션" 재실행
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 동일 동영상 기준 클릭
    When 동영상 시청 제한 확인 버튼 클릭
    When 20초 대기
    Then 동일 동영상 횟수 0으로 변경
    When 나가기 버튼 클릭
    Then 동영상 일시 정지
    Then "동영상이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭
    When 검색 "첫생활그림책 늠름 테마송 애니메이션" 재실행
    Then "오늘은 이제 그만~ 내일 또 만나요!" 팝업 표출
    And 확인 버튼 클릭
    And "검색" 화면으로 이동
    And 제어 설정 시 초기화

  Scenario: 재생목록 전체 삭제 후 화면 상단 확인 (player_058)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    When 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 확인
    And  팝업 예 버튼 클릭
    And  재생영역에 아무것도 없음 확인
    And  라이브러리 바로가기 버튼 표출
    And 동영상 플레이어의 상단영역 표출 확인

  Scenario: 제어 후 동영상 재생 확인 (player_059)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    When 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    Then 전체 동영상 기준 클릭
    Then 20초 대기 후 전체 동영상 남은 횟수 감소 확인
    And 나가기 버튼 클릭
    And 확인 버튼 클릭
    When 검색 "Andy and the Bowerbird" 재실행
    When 5초 대기
    And 동영상 재생 확인
    And 음악_동영상 탭 클릭
    And 확인 버튼 클릭
    And 음악_동영상 탭 클릭
    And 확인 버튼 클릭
    And 동영상 재생 확인
    And 제어 설정 시 초기화

  Scenario: 전체삭제 후 탭이동 후 동영상 화면 확인 (player_060)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 표출
    And 팝업 예 버튼 클릭
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭
    And  재생영역에 아무것도 없음 확인
    And  라이브러리 바로가기 버튼 표출

  Scenario: 중복음원 재생 확인 (player_061)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 세트 목록보기에 4페이지 3번 째 컨텐츠 클릭
    When 10초 대기
    When 컨텐츠 리스트중 "두뇌 발달 클래식 1" 클릭
    When 5초 대기
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    When 4페이지 6번째 "귀로 듣는 모차르트" 재생목록에 재 추가
    When 5초 대기
    When 재생목록 전체 삭제 동작
    When 5페이지 1번째 "귀로 듣는 오페라" 재생목록에 재 추가
    When 5초 대기
    And 동영상 재생 확인

  Scenario: 영어 동영상 재생 확인 (player_062)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 동영상 재생 확인
    When 재생목록 전체 삭제 동작
    And 전체메뉴 [English] Animation 클릭
    When 5초 대기
    And "Andy and the Chipmunk" 영상 선택
    When 10초 대기
    And "Andy and the Chipmunk" 동영상 이름 확인
    And 동영상 재생 확인

  Scenario: 전체 동영상 남은 횟수 감소 확인 (player_063)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 시계 버튼 클릭
    Then 비밀번호 입력 창 표출
    When 비밀번호 입력
    And 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시
    When 전체 동영상 기준 클릭
    Then 전체 동영상 설정 후 남은시간 감소 확인
    And 제어 설정 시 초기화

  Scenario: 재생목록 2개 영상 재생 확인 (player_064)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 동영상 재생 확인
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    Then "전체 재생목록이 삭제됩니다." 팝업 표출
    And 팝업 예 버튼 클릭
    When "첫생활그림책 늠름 테마송 애니메이션,아주 아주 차가운 얼음" 재생목록에 추가 동작
    When 재생목록에서 0번째 항목 선택
    Then 120초 대기
    When 재생목록에서 0번째 항목 선택
    And "첫생활그림책 늠름 테마송 애니메이션" 동영상 이름 확인
    And 동영상 재생 확인

  Scenario: 디바이스 매니저 확인 (player_065)
    Given 라이브러리 버튼 클릭
    When 설정 버튼 클릭
    When 디바이스 매니저 클릭
    Then 5초 대기
    Then 동영상 시청 제어 화면 확인
    When 시청제어 설정 버튼 클릭
    Then 비밀번호 입력 창 표출
    And 비밀번호 입력
    And 비밀번호 입력 확인 버튼 클릭
    Then 동영상 시청 제한 설정 팝업 표시

  Scenario: 북클럽 중등 동영상 재실행 확인 (player_066)
    Given 라이브러리 버튼 클릭
    When 프로필 버튼 클릭
    When 북클럽 진도 학년 클릭
    And 비밀번호 입력 창 표출
    And 비밀번호 입력
    And 비밀번호 입력 확인 버튼 클릭
    And 교과 진도 중등 클릭
    And 교과 진도 변경완료 버튼 클릭
    And 교과 진도 변경 확인 버튼 클릭
    And 20초 대기
    And 독서 버튼 클릭
    And 교과 투데이 버튼 클릭
    And 5초 대기
    And 독서 지난호 보기 버튼 클릭
    And 교과 투데이 체험판 클릭
    And 교과 투데이 동영상 콘텐츠 클릭
    And 동영상 재생 확인
    And 나가기 버튼 클릭
    And 확인 버튼 클릭
    When 교과 투데이 동영상 콘텐츠 클릭
    Then 2초 대기
    And 동영상 재생 확인


  Scenario: 영상 마지막으로 이동 후 다음영상 확인 (player_067)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 동영상 재생 확인
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 재생목록에서 0번째 항목 선택
    When 2초 대기
    Then 영상 마지막으로 이동
    When 10초 대기
    And 동영상 재생 확인


  Scenario: 음악_동영상 탭 이동 5회 확인 (player_068)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭
    When 2초 대기
    When 음악_동영상 탭 클릭
    Then "음원이 종료됩니다." 팝업 표출
    When 확인 버튼 클릭

  Scenario: 북클럽 중등 동영상 재실행 확인 (player_069)
    Given 라이브러리 버튼 클릭
    When 프로필 버튼 클릭
    When 북클럽 진도 학년 클릭
    And 비밀번호 입력 창 표출
    And 비밀번호 입력
    And 비밀번호 입력 확인 버튼 클릭
    And 교과 진도 중등 클릭
    And 교과 진도 변경완료 버튼 클릭
    And 교과 진도 변경 확인 버튼 클릭
    And 20초 대기
    And 독서 버튼 클릭
    And 교과 투데이 버튼 클릭
    And 5초 대기
    And 독서 지난호 보기 버튼 클릭
    And 교과 투데이 체험판 클릭
    And 교과 투데이 동영상 콘텐츠 클릭
    And 동영상 재생 확인
    And 이전 버튼 클릭
    Then 10초 대기
    And 이전 버튼 클릭
    And 일시정지_재생 버튼 클릭
    And 동영상 재생 시간 "0:00" 확인

  Scenario: 재생 일시정지 5회 확인 (player_070)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 일시 정지
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 재생 확인
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 일시 정지
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 재생 확인
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 일시 정지
    When 일시정지_재생 버튼 클릭
    When 2초 대기
    Then 동영상 재생 확인

  Scenario: 이전 다음 버튼 5회 확인 (player_071)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 5초 대기
    When 동영상 재생 확인
    When 재생목록 전체 삭제 동작
    When "아주 아주 차가운 얼음,첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 5초 대기
    When 이전 버튼 클릭
    Then 동영상 플레이리스트 0번째와 이름 확인
    When 2초 대기
    When 다음 버튼 클릭
    Then 동영상 플레이리스트 1번째와 이름 확인
    When 2초 대기
    When 이전 버튼 클릭
    Then 동영상 플레이리스트 0번째와 이름 확인
    When 2초 대기
    When 다음 버튼 클릭
    Then 동영상 플레이리스트 1번째와 이름 확인
    When 2초 대기
    When 이전 버튼 클릭
    Then 동영상 플레이리스트 0번째와 이름 확인
    When 2초 대기
    When 다음 버튼 클릭
    Then 동영상 플레이리스트 1번째와 이름 확인

  Scenario: 재생바 위치 3회 변경 확인 (player_072)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "첫생활그림책 늠름 테마송 애니메이션" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    Then 화면 480 979 지점 터치
    Then 동영상 재생 확인
    When 2초 대기
    Then 화면 1041 979 지점 터치
    Then 동영상 재생 확인
    When 2초 대기
    Then 화면 1321 979 지점 터치
    Then 동영상 재생 확인

  Scenario: 자막 버튼 표시 확인 (player_073)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "Andy and the Bowerbird" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 2초 대기
    When 재생목록 전체 삭제 동작
    When "첫생활그림책 늠름 테마송 애니메이션,Andy and the Bowerbird" 재생목록에 추가 동작
    Then 자막 버튼 표시 여부 확인
    When 재생목록에서 0번째 항목 선택
    When 2초 대기
    Then 자막 버튼 표시 여부 확인
    When 재생목록에서 1번째 항목 선택
    When 2초 대기
    Then 자막 버튼 표시 여부 확인

  Scenario: 음악 플레이어 공백 동작 확인 (player_074)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 전체 삭제 동작
    And  재생영역에 아무것도 없음 확인
    Then 화면 273 265 지점 터치
    Then 화면 1480 265 지점 터치
    Then 화면 1480 930 지점 터치
    Then 화면 273 930 지점 터치

  Scenario: 음악 플레이어 셔플 후 이전 다음버튼 동작 후 재생 확인 (player_075)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 셔플 버튼 클릭
    When 이전_다음버튼 10회 동작
    Then 30초 대기
    And 동영상 재생 확인

  Scenario: 음악 플레이어 다른 곡 셔플 후 재생 확인 (player_076)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 음악재생목록에서 2번째 항목 선택
    When 2초 대기
    When 셔플 버튼 클릭
    When 다음 버튼 클릭
    When 2초 대기
    Then 동영상 재생 확인

  #Scenario: 음악 플레이어 자동꺼짐 후 잠금 동작 확인 (player_077)
   # Given 라이브러리 버튼 클릭
   # And 전체메뉴 버튼 클릭
   # And 뮤직 버튼 클릭
   # And 귀로 듣는 오페라 클릭
   # And 전체 듣기 버튼 클릭
   # When 2초 대기
   # When 자동 꺼짐 설정 버튼 클릭
   # Then 자동 꺼짐 설정 팝업 표출
   # And 설정 버튼 클릭
   # And 잠금 버튼 클릭
   # And "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인
   # When 310초 대기
   # Then "자동꺼짐 시간이 되었습니다." 문구가 담긴 토스트 팝업 노출 확인
   # And 확인 버튼 클릭

  Scenario: 음악 플레이어 재생목록 편집 버튼 활성화 후 잠금버튼 동작 확인 (player_078)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 재생목록 편집 버튼 클릭
    And 잠금 버튼 클릭
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인
    When 나가기 버튼 클릭
    Then "잠금상태 입니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 음악 플레이어 자동꺼짐 설정 후 동영상 플레이어 재생 확인 (player_079)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When "첫생활그림책 늠름 테마송 애니메이션" 재생목록에 추가 동작
    When 5초 대기
    When 음악_동영상 탭 클릭
    Then "동영상이 종료됩니다." 팝업 표출
    Then 동영상 일시 정지
    When 확인 버튼 클릭
    When 3초 대기
    When 자동 꺼짐 설정 버튼 클릭
    Then "자동 꺼짐 설정" 시간 설정 팝업 표출
    And 자동 꺼짐 설정 확인 버튼 클릭
    When 5초 대기
    When 음악_동영상 탭 클릭
    And "음원이 종료됩니다." 팝업 표출
    And 확인 버튼 클릭
    When 2초 대기
    And 동영상 재생 확인

  Scenario: 음악 플레이어 재생목록 음원 선택 후 삭제 확인 (player_080)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 음악재생목록에서 2번째 항목 선택
    When 2초 대기
    When 재생목록 편집 버튼 클릭
    When 재생목록에서 0번째 항목 휴지통 선택
    Then "1개의 목록이 삭제되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    When 2초 대기
    Then 재생목록에서 0번째 항목 휴지통 선택
    And  "현재 재생중인 음원은 삭제할 수 없습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 음악 플레이어 반복재생 후 다음 버튼 동작 확인 (player_081)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 반복 재생 버튼 클릭
    When 5초 대기
    When 다음 버튼 클릭
    When 2초 대기
    Then 동영상 재생 확인
    And 플레이리스트 2번째와 이름 확인
    When 2초 대기
    Then 동영상 재생 확인
    When 2초 대기
    When 다음 버튼 클릭
    When 2초 대기
    And 플레이리스트 3번째와 이름 확인

  Scenario: 음악 플레이어 자동꺼짐 버튼 연속 동작 확인 (player_082)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 자동 꺼짐 버튼 클릭 취소 3회 반복

  Scenario: 음악 플레이어 자동꺼짐 설정 후 일시정지 확인 (player_083)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 자동 꺼짐 설정 버튼 클릭
    Then "자동 꺼짐 설정" 시간 설정 팝업 표출
    And 자동 꺼짐 설정 확인 버튼 클릭
    Then 2초 후 일시정지, 30초 재생 후 일시정지 시간 비교

  Scenario: 음악 플레이어 전체 삭제 버튼 동작 시 일시정지 확인 (player_084)
    Given 라이브러리 버튼 클릭
    When 전체메뉴 버튼 클릭
    When 3초 대기
    When 전체메뉴 뮤직버튼 클릭
    When 3초 대기
    When 12회 스와이프 액션
    When 컨텐츠 리스트중 "귀로 듣는 오페라" 클릭
    When 5초 대기
    When 일시정지_재생 버튼 클릭
    Then 동영상 일시 정지
    When 재생목록 편집 버튼 클릭
    Then 전체 삭제 버튼 클릭
    And "전체 재생목록이 삭제됩니다." 팝업 표출 
    And 취소 버튼 클릭
    Then 동영상 일시 정지




    







































