Feature: Viewer feature

  @test
  Scenario: WIFI-OFF 사전 기능 확인 (viewer_001)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "홍쌤의 최강 수학" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    Then Turn "Off" WiFi
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 사전 버튼 클릭
    Then 온라인 상태에서만 사전 검색이 가능하다는 안내 팝업 노출 확인
    And 알림팝업의 확인 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 감상문 쓰기 기능 확인 (viewer_002)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "홍쌤의 최강 수학" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    Then Turn "Off" WiFi
    When 5초 대기
    When 플레이어 내에서 상단바 노출
    When 더보기 버튼 클릭
    When 감상문쓰기 버튼 클릭
    When 알림팝업의 확인 버튼 클릭
    When 5초 대기
    Then Wifi 안내 팝업 노출 확인
    And Wifi 안내 팝업의 확인 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 독후퀴즈 기능 확인 (viewer_003)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "홍쌤의 최강 수학" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    Then Turn "Off" WiFi
    When 5초 대기
    When 플레이어 내에서 상단바 노출
    When 더보기 버튼 클릭
    When 독후퀴즈 버튼 클릭
    When 알림팝업의 확인 버튼 클릭
    When 5초 대기
    Then 네트워크 확인 팝업에서 확인 버튼 클릭
    And 5초 대기
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 감상문보기 기능 확인 (viewer_004)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "홍쌤의 최강 수학" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    Then Turn "Off" WiFi
    When 5초 대기
    When 플레이어 내에서 상단바 노출
    When 더보기 버튼 클릭
    When 감상문 보기 버튼 클릭
    When 알림팝업의 확인 버튼 클릭
    When 5초 대기
    Then 감상문 보기 Wifi 안내 팝업 노출 확인
    And 감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 오디오북 보기 기능 확인 (viewer_005)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "우리 역사의 시작" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 20초 대기
    And 코치마크 노출 시 닫기
    When 속속 캐스트북 확인 버튼 클릭
    When 5초 대기
    Then Turn "Off" WiFi
    When 15초 대기
    When 플레이어 내에서 상단바 노출
    When 더보기 버튼 클릭
    When 오디오북 보기 버튼 클릭
    When 알림팝업의 확인 버튼 클릭
    When 5초 대기
    Then 감상문 보기 Wifi 안내 팝업 노출 확인
    And 감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 짝꿍책 보기 기능 확인 (viewer_006)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "우리 역사의 시작" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    And 코치마크 노출 시 닫기
    When 속속 캐스트북 확인 버튼 클릭
    When 5초 대기
    Then Turn "Off" WiFi
    When 15초 대기
    When 플레이어 내에서 상단바 노출
    When 더보기 버튼 클릭
    When 짝꿍책 버튼 클릭
    When 5초 대기
    When 짝꿍책 리스트 화면에서 0번째 도서 클릭
    When 5초 대기
    Then 짝꿍책 Wifi 안내 팝업 확인
    And 짝꿍책 Wifi 안내 팝업의 취소 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 도서완독 시 기능 확인 (viewer_007)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    When 검색창에서 "세모, 안녕?" 입력
    When 검색창에서 검색 실행 버튼 클릭
    When 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    When 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    When 5초 대기
    Then Turn "Off" WiFi
    When 15초 대기
    And Next page 5번 실행
    Then 감상문 보기 Wifi 안내 팝업 노출 확인
    And 감상문 보기 Wifi 안내 팝업의 확인 버튼 클릭
    Then Turn "On" WiFi

  Scenario: WIFI-OFF 녹음 후 오디오북 만들기 시 기능 확인 (viewer_008)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "세모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 녹음 버튼 클릭
    And 3초 대기
    And 녹음 시작 버튼 클릭
    And 5초 대기
    And 다시 녹음 "Yes"
    And 녹음 시작 버튼 클릭
    And 3초 대기
    And 녹음 종료 버튼 클릭
    And 알림팝업의 확인 버튼 클릭
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

  Scenario: 뷰어 진입 시 로딩화면 확인 (viewer_009)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "세모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 빠르게 독서 검색결과 섹션의 0번째 항목 선택
    Then 로딩 화면 확인
    And Reading continue "No"

  Scenario: 뷰어 진입 시 메뉴바 기능 확인 (viewer_010)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "세모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    Then 5초 후 전체화면모드 전환 확인
    And 플레이어 내에서 상단바 노출
    Then 진입 시 상하단 메뉴바 확인

  Scenario: 도서 재실행 시 안내 팝업 확인 (viewer_011)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And Next page 2번 실행
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 3초 대기
    Then 읽던 페이지를 이어 보기 안내 팝업 노출 확인
    And 읽던 페이지 안내 팝업의 취소 버튼 클릭
    Then 처음 페이지로 진입 확인
    And 5초 대기
    And Next page 2번 실행
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 3초 대기
    Then 읽던 페이지를 이어 보기 안내 팝업 노출 확인
    And 읽던 페이지 안내 팝업의 확인 버튼 클릭
    Then 처음 페이지가 아닌 읽던 페이지로 진입 확인

  Scenario: 뷰어 내 상단 메뉴바 확인 (viewer_012)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    Then 상단바 레이아웃 확인

  Scenario: 뷰어 종료 버튼 클릭 시 동작 확인 (viewer_012-1)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    Then 검색결과 화면으로 이동 확인

  Scenario: 상단 메뉴바 도서 제목의 말줄임표 확인 (viewer_013)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "구봉구는 어쩌다 수학을 좋아하게 되었나" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "Yes"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    Then 뷰어 책 제목의 말줄임표 확인

  Scenario: 전체화면저장 버튼 클릭 시 동작 확인 (viewer_014)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "구봉구는 어쩌다 수학을 좋아하게 되었나" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "Yes"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 전체화면저장 버튼 클릭
    Then 독서 앨범에 현재 화면 저장 팝업 노출 확인
    And 일반 안내 팝업의 취소 버튼 클릭
    And 독서 앨범의 현재 화면 저장 팝업 사라짐 확인
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 전체화면저장 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then "전체 이미지를 저장하였습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 마음대로저장 버튼 클릭 시 동작 확인 (viewer_015)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "구봉구는 어쩌다 수학을 좋아하게 되었나" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "Yes"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 마음대로저장 버튼 클릭
    Then "선을 그어 연결하면 그 안의 그림이 저장됩니다." 문구가 담긴 토스트 팝업 노출 확인
    And 5초 대기
    And Y축 200 드래그 동작
    And 3초 대기
    Then 마음대로 그림 저장 안내 팝업 확인
    And 마음대로 그림 저장 안내 팝업의 취소 버튼 클릭
    Then 마음대로 그림 저장 안내 팝업 사라짐 확인
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 마음대로저장 버튼 클릭
    And 5초 대기
    And Y축 200 드래그 동작
    And 3초 대기
    And 마음대로 그림 저장 안내 팝업의 확인 버튼 클릭
    Then "전체 이미지를 저장하였습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 감상문쓰기 버튼 클릭 시 동작 확인 (viewer_016)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
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

  Scenario: 감상문이 이미 작성된 경우 감상문쓰기 버튼 클릭 시 동작 확인 (viewer_017)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "냠냠 빙수" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 3초 대기
    And 감상문 3개 모두 작성하기
    Then 이미 감상문이 존재할 경우 노출되는 화면 확인

  Scenario: 감상문이 3개 모두 작성된 화면 확인 (viewer_018)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "동그라미, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 3초 대기
    And 감상문 3개 모두 작성하기
    Then 감상문 3개 모두 작성한 경우 화면 확인
    And 감상문 3개 모두 작성한 화면에서 임의의 감상문 삭제 버튼 클릭
    Then 독서감상문 쓰기 화면으로 이동 확인

  Scenario: 감상문 작성 화면 리스트에서 우측 상단 X 버튼 클릭 동작 확인 (viewer_019)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "동그라미, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 3초 대기
    And 감상문 작성 리스트 화면에서 X 버튼 클릭
    And 3초 대기
    And 플레이어 내에서 상단바 노출
    Then 상단바 레이아웃 확인

  Scenario: 독후퀴즈 버튼 클릭 시 동작 확인 (viewer_020)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "6학년 수학 친구" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 독후퀴즈 버튼 클릭
    Then "독후퀴즈를 시작할까요?" 안내 문구 일반 팝업 확인
    And 일반 안내 팝업의 취소 버튼 클릭
    Then 일반 안내 팝업 사라짐 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 독후퀴즈 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 20초 대기
    Then 독후퀴즈 실행 확인

  Scenario: 감상문 보기 버튼 클릭 시 감상문 보기 화면 노출 확인 (viewer_021)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문 보기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then 감상문 보기 화면 노출 확인
    And 감상문 보기 탭 클릭
    Then 내가 쓴 감상문이 있다면 노출되는지 확인
    Then 친구들이 쓴 감상문이 있다면 노출되는지 확인

  Scenario: 내가 쓴 감상문 또는 친구들이 쓴 감상문 클릭 시 독서앨범 상세화면으로 이동 확인 (viewer_022)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문쓰기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    And 3초 대기
    And 감상문 3개 모두 작성하기
    And 감상문 작성 리스트 화면에서 X 버튼 클릭
    And 6초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 감상문 보기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then 감상문 보기 화면 노출 확인
    And 감상문 보기 탭 클릭
    And 내가 쓴 감상문 클릭
    Then 독서앨범으로 이동 확인
    And 일반 뒤로가기 버튼 클릭
    And 친구들이 쓴 감상문 클릭
    Then 독서앨범으로 이동 확인
    And 일반 뒤로가기 버튼 클릭
    And 감상문 보기 팝업에서 X 버튼 클릭
    Then 감상문 보기 팝업 사라짐 확인

  Scenario: 짝꿍책 클릭 시 짝꿍책 페이지 노출 확인 (viewer_023)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 짝꿍책 버튼 클릭
    Then 짝꿍책 페이지 노출 확인
    And 짝꿍책 안내 문구 및 최소 1권은 노출 확인
    And 짝꿍책의 도서장르 - 대상연령 - 썸네일 - 키워드 노출 확인
    And 1번 짝꿍책 클릭
    Then 짝꿍책 클릭 시 해당 도서 실행 확인

  Scenario: 짝꿍책 페이지에서 X 버튼 클릭 시 뷰어 재진입 확인 (viewer_024)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 짝꿍책 버튼 클릭
    Then 짝꿍책 페이지 노출 확인
    And 짝꿍책 페이지에서 X 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then 뷰어 화면 진입 확인

  Scenario: 도움말 버튼 클릭 시 동작 확인 (viewer_025)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 도움말 버튼 클릭
    Then 도움말 페이지 노출 확인
    And 하단 도트마크 표시 확인
    Then 도움말 1페이지는 이전 다음 페이지 이동 정보에 대한 내용 확인

  Scenario: 도움말 1 페이지 확인 (viewer_026)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 도움말 버튼 클릭
    Then 도움말 페이지 노출 확인
    And 하단 도트마크 표시 확인
    Then 도움말 1페이지는 이전 다음 페이지 이동 정보에 대한 내용 확인

  Scenario: 도움말 2 페이지 확인 (viewer_027)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 도움말 버튼 클릭
    Then 도움말 페이지 노출 확인
    And 하단 도트마크 표시 확인
    And 오른쪽에서 왼쪽으로 스와이프
    Then 도움말 2페이지는 전체화면저장 - 마음대로저장 - 감상문 - 독후퀴즈에 대한 내용 설명 확인

  Scenario: 도움말 페이지에서 X 버튼 동작 확인 (viewer_028)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 도움말 버튼 클릭
    Then 도움말 페이지 노출 확인
    And 도움말 화면에서 X 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then 뷰어 화면 진입 확인

  Scenario: 하단 메뉴바 확인 (viewer_029)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    Then 하단바 엘리먼트 확인
    And 하단바에서 펼쳐보기 버튼 클릭
    Then 펼쳐보기 리스트 노출 확인
    And 펼쳐보기 리스트 스와이프 기능 확인
    And 펼쳐보기 리스트 X 버튼 클릭
    Then 펼쳐보기 리스트 닫힘 확인

  Scenario: 하단 메뉴바의 페이지 동작 확인 (viewer_030)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And Next page 5번 실행
    And 플레이어 내에서 상단바 노출
    Then 뷰어 하단바 페이지 카운트 확인

  Scenario: 완독 시 감상문 팝업 닫으면 노출되는 메시지 팝업창 확인 (viewer_031)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "동그라미, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And Next page 6번 실행
    And 감상문 보기 팝업에서 X 버튼 클릭
    Then 바나쿠 캐릭터와 토스트 팝업 확인

  # 이 시나리오는 완독 후 딱 한번만 평가가 가능함, 그래서 테스트를 수행하려면 할 때마다 책을 바꿔줘야 함 (책을 바꾸면 당연히 Next Page 수도 바꿔줘야 할 것)
#  @Not
  Scenario: 완독 후 뷰어 종료 시 평가 화면 노출 확인 (viewer_032)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네, 네!" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And Next page 14번 실행
    And 감상문 보기 팝업에서 X 버튼 클릭
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    Then 평가 화면 노출 확인
    And 평가 항목 좋아요 클릭
    Then 평가완료 버튼 노출 확인

  # 이 시나리오는 완독 후 딱 한번만 평가가 가능함, 그래서 테스트를 수행하려면 할 때마다 책을 바꿔줘야 함 (책을 바꾸면 당연히 Next Page 수도 바꿔줘야 할 것)
#  @Not
  Scenario: 완독 후 뷰어 종료 시 평가 화면에서 평가완료 버튼 클릭 시 동작 확인 (viewer_033)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "알록달록 그림이 좋아!" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And Next page 16번 실행
    And 감상문 보기 팝업에서 X 버튼 클릭
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 뷰어 종료
    Then 평가 화면 노출 확인
    And 평가 항목 좋아요 클릭
    And 평가완료 버튼 클릭
    Then 검색결과 화면으로 이동 확인

  Scenario: PDF 도서 경우 세로모드로 전환되어 노출 확인 (viewer_034)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "Why? 발표력" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    Then Orientation is "PORTRAIT"

  Scenario: 회전잠금 버튼 클릭 시 토스트 팝업 노출 확인 (viewer_035)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 회전잠금 또는 자동회전 버튼 클릭
    Then "화면 잠금이 설정되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 자동회전 버튼 클릭 시 토스트 팝업 노출 확인 (viewer_037)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "아기랑 감각놀이" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 회전잠금 또는 자동회전 버튼 클릭
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 회전잠금 또는 자동회전 버튼 클릭
    Then "화면 잠금이 해제되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 사전 선택 시 토스트 문구 팝업 확인 (viewer_038)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "홍쌤의 최강 수학" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    Then 사전 버튼 클릭
    And 사전 검색 종료 버튼 클릭
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    Then 사전 버튼 클릭 코치마크 미확인
    Then "검색할 단어를 선택해 주세요." 문구가 담긴 토스트 팝업 노출 확인

  # 해당 도서에서만 수행 가능한 시나리오 (사전 검색 시 어떠한 엘리먼트도 잡아낼 수 없어서 TouchAction으로 x,y offset을 활용)
  Scenario: 사전 검색 동작 확인 - PORTRAIT (viewer_039)
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

  Scenario: 오디오북 동작 확인 (viewer_040)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 오디오북 보기 버튼 클릭
    And 일반 안내 팝업의 확인 버튼 클릭
    Then 오디오북 보기 화면 노출 확인
    And 내가 녹음한 오디오북이 없다면 안내 문구 노출 확인
    And 친구가 녹음한 오디오북이 없다면 안내 문구 노출 확인
    And 감상문 보기 팝업에서 X 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then 뷰어 화면 진입 확인

  Scenario: 보기 버튼 동작 확인 (viewer_041)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "동그라미 짝꿍" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 보기타입 버튼 클릭
    Then 보기 버튼들 노출 확인
    And 단면보기 버튼 클릭
    Then "단면 보기가 설정되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 보기타입 버튼 클릭
    And 단면보기 버튼 클릭
    Then "양면 보기가 설정되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 보기타입 버튼 클릭
    And 채워보기 버튼 클릭
    Then "채워 보기가 설정되었습니다." 문구가 담긴 토스트 팝업 노출 확인
    Then 채워보기 시 스크롤 가능 여부 확인
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 보기타입 버튼 클릭
    And 기본보기 버튼 클릭
    Then "최초 보기모드로 설정되었습니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오북 뷰어 진입 시 친구가 녹음한 오디오북이 존재하면 진입 시 바나캐릭터 토스트 팝업 노출 확인 (viewer_042)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "네모, 안녕?" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 10초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    Then "이 책은 친구 목소리로 들어볼까?" 바나 캐릭터 토스트 팝업 노출 확인
    And 친구 녹음 오디오북 토스트 팝업 클릭
    And 3초 대기
    Then 뷰어 화면 진입 확인

  Scenario: 오디오이북에서 독후퀴즈 실행 안내 팝업을 취소하면 음원 자동 재생 확인 (viewer_043)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "우리 집에 벌레가 살아요" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 독후퀴즈 버튼 클릭
    And 일반 안내 팝업의 취소 버튼 클릭
    And 음원 재생 - 정지 버튼 클릭
    Then "음원 재생을 일시 정지합니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오이북 짝꿍책 클릭 시 짝꿍책 페이지 노출 확인 (viewer_044)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 짝꿍책 버튼 클릭
    Then 짝꿍책 페이지 노출 확인
    And 짝꿍책 안내 문구 및 최소 1권은 노출 확인
    And 짝꿍책의 도서장르 - 대상연령 - 썸네일 - 키워드 노출 확인
    And 1번 짝꿍책 클릭
    Then 짝꿍책 클릭 시 해당 도서 실행 확인

  Scenario: 오디오이북 짝꿍책 페이지에서 나가면 음원 자동 재생 확인 (viewer_045)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 짝꿍책 버튼 클릭
    Then 짝꿍책 페이지 노출 확인
    And 짝꿍책 페이지에서 X 버튼 클릭
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 음원 재생 - 정지 버튼 클릭
    Then "음원 재생을 일시 정지합니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오이북 도움말 페이지 확인 (viewer_046)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 도움말 버튼 클릭
    Then 도움말 페이지 노출 확인
    And 하단 도트마크 표시 확인
    And 오른쪽에서 왼쪽으로 스와이프
    Then 오디오이북 도움말 2페이지는 보기 타입 - 잠금 기능 대한 내용 설명 확인
    And 오른쪽에서 왼쪽으로 스와이프
    Then 오디오이북 도움말 3페이지는 저장 - 감상문쓰기 - 독후퀴즈 - 짝꿍책 대한 내용 설명 확인
    And 오른쪽에서 왼쪽으로 스와이프
    Then 오디오이북 도움말 4페이지는 사전 - 감상문보기 - 오디오북 보기 대한 내용 설명 확인
    And 도움말 화면에서 X 버튼 클릭
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    Then 뷰어 화면 진입 확인

  Scenario: 오디오이북 하단 메뉴바 확인 (viewer_047)
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
    Then 하단 메뉴바의 엘리먼트 확인

  Scenario: 오디오이북 하단 메뉴바 버튼 동작 확인 (viewer_048)
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
    And 음원 재생 - 정지 버튼 클릭
    Then "음원 재생을 일시 정지합니다." 문구가 담긴 토스트 팝업 노출 확인
    And 현재 페이지 정보 습득
    And >> 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 다음 페이지로 이동 후 페이지 정보 확인
    And << 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then 이전 페이지로 이동 후 페이지 정보 확인
    And 음원 재생 - 정지 버튼 클릭
    Then "음원을 재생합니다." 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오이북 속속캐스트북의 경우 자동 수동 버튼 동작 확인 (viewer_049)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 하단바에서 펼쳐보기 버튼 클릭
    Then "페이지넘김 자동모드에서는" 문구가 담긴 토스트 팝업 노출 확인
    And 10초 대기
    And 플레이어 내에서 상단바 노출
    And 수동 - 자동 버튼 클릭
    And >> 버튼 클릭
    Then 독서 "play" 확인
    And 수동 - 자동 버튼 클릭
    Then "음원에 맞춰 페이지가 자동으로 넘어갑니다" 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오이북 반복 버튼 동작 확인 (viewer_050)
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
    And 하단바 반복 버튼 클릭
    Then "현재 음원을 1회 반복합니다" 문구가 담긴 토스트 팝업 노출 확인
    And Next page 5번 실행
    Then 반복 실행 수행 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 하단바 반복 버튼 클릭
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 하단바 반복 버튼 클릭
    Then "현재 음원을 계속 반복합니다" 문구가 담긴 토스트 팝업 노출 확인
    And Next page 20번 실행
    Then 반복 실행 수행 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 하단바 반복 버튼 클릭
    Then "음원 반복을 해제합니다" 문구가 담긴 토스트 팝업 노출 확인
    And Next page 7번 실행
    And 5초 대기
    Then 반복 실행 수행 되지 않음 확인

  Scenario: 오디오이북 배속 버튼 동작 확인 (viewer_051)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 배속 버튼 클릭
    Then 디폴트는 보통 빠르기임을 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 배속 버튼 클릭
    Then "보통 속도로 재생합니다" 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 오디오이북 잠금 버튼 동작 확인 (viewer_052)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "변신 이야기" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 화면잠금 버튼 클릭
    Then 잠금 버튼은 디폴트로 해제 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then "현재 화면이 잠겨 있습니다" 문구가 담긴 토스트 팝업 노출 확인
    And 5초 대기
    Then 화면 잠금 설정 표시 버튼 노출 확인
    And 화면 잠금 설정 표시 버튼 클릭
    Then "화면 잠금이 해제되었습니다" 문구가 담긴 토스트 팝업 노출 확인
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    Then 상단바 레이아웃 확인

  Scenario: 마이 - 오디오이북 연속재생 동작 확인 (viewer_053)
    Given 라이브러리 버튼 클릭
    When 마이 버튼 클릭
    And 마이 - 오디오 이북 클릭
    And 연속재생 버튼 클릭
    And 마이 - 오디오 이북의 연속 재생할 책 5권 선택
    And 연속재생 버튼 클릭
    And 알림팝업 우측 버튼 클릭
    And 5초 대기
    Then 상단바 레이아웃 확인
    And 더보기 버튼 클릭
    Then 더보기 리스트 노출 확인
    And 3초 대기
    And 연속재생 리스트 노출 시 딤 부분 클릭
    Then 더보기 리스트 미노출 확인
    And 더보기 버튼 클릭
    And 연속재생 리스트의 4번째 독서 클릭
    Then 연속재생 및 오디오북 로딩 화면 확인

  Scenario: 마이 - 오디오이북 연속재생 완료 동작 확인 (viewer_054)
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

  Scenario: 녹음 동작 확인 (viewer_055)
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
    And 2초 대기
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

  Scenario: 녹음 저장 동작 확인 (viewer_056)
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
    And 녹음 버튼 클릭
    And 기녹음이 있는 경우 확인 버튼 클릭
    And "녹음모드로 전환 중입니다" 문구가 담긴 토스트 팝업 노출 확인
    Then 녹음모드 화면 확인
    And 녹음 시작 버튼 클릭
    And 해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭
    Then 녹음 진행 중 확인
    And 5초 대기
    And 녹음 시작 버튼 클릭
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    Then 녹음 저장 화면 노출 확인
    And 왼쪽에서 오른쪽으로 스와이프
    Then 녹음모드 화면 확인
    And 오른쪽에서 왼쪽으로 스와이프
    And 오디오북 만들기 버튼 클릭
    Then "배경음을 선택해 주세요" 문구가 담긴 토스트 팝업 노출 확인
    And 오디오북 첫번째 브금 재생 버튼 클릭
    And 5초 대기
    Then 오디오북 브금 재생 확인
    And 오디오북 만들기 버튼 클릭
    Then 오디오북 만들기 알림 팝업 확인
    And 일반 안내 팝업의 확인 버튼 클릭
    Then "사용자 오디오북을 만들고 있습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 연속재생 및 오디오북 로딩 화면 확인
    And 20초 대기
    Then 녹음 종료 화면 노출 확인
    And 내 녹음 들어보기 버튼 클릭
    And 2초 대기
    Then 독서 "play" 확인

  Scenario: 녹음 종료 후 나가기 버튼 동작 확인 (viewer_057)
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
    And 녹음 버튼 클릭
    And 기녹음이 있는 경우 확인 버튼 클릭
    And "녹음모드로 전환 중입니다" 문구가 담긴 토스트 팝업 노출 확인
    Then 녹음모드 화면 확인
    And 녹음 시작 버튼 클릭
    And 해당 페이지에서 녹음 이력 있는경우 재녹음 버튼 클릭
    Then 녹음 진행 중 확인
    And 5초 대기
    And 녹음 시작 버튼 클릭
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    And 오른쪽에서 왼쪽으로 스와이프
    Then 녹음 저장 화면 노출 확인
    And 왼쪽에서 오른쪽으로 스와이프
    Then 녹음모드 화면 확인
    And 오른쪽에서 왼쪽으로 스와이프
    And 오디오북 만들기 버튼 클릭
    Then "배경음을 선택해 주세요" 문구가 담긴 토스트 팝업 노출 확인
    And 오디오북 첫번째 브금 재생 버튼 클릭
    And 5초 대기
    Then 오디오북 브금 재생 확인
    And 오디오북 만들기 버튼 클릭
    Then 오디오북 만들기 알림 팝업 확인
    And 일반 안내 팝업의 확인 버튼 클릭
    Then "사용자 오디오북을 만들고 있습니다." 문구가 담긴 토스트 팝업 노출 확인
    And 연속재생 및 오디오북 로딩 화면 확인
    And 20초 대기
    Then 녹음 종료 화면 노출 확인
    And 녹음 나가기 버튼 클릭
    And 플레이어 내에서 상단바 노출
    Then 상단바 레이아웃 확인

  Scenario: 영한 사전 기능 동작 확인 (viewer_058)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "Loss of Biodiversity 1" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 음원 재생 - 정지 버튼 클릭
    And 하단바에서 펼쳐보기 버튼 클릭
    And 펼쳐보기 리스트의 16번째 페이지로 이동
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 사전 버튼 클릭
    And 영어사전 도움말 페이지 노출 시 닫기
    And 5초 대기
    And 사전 검색 X:603 Y:756
    And 3초 대기
    And 사전 검색 X:607 Y:691
    And "선택한 단어를 검색합니다" 문구가 담긴 토스트 팝업 노출 확인
    And 10초 대기
    Then 사전검색 화면 확인
    And 사전검색 화면의 X 버튼 클릭
    Then 사전검색 텍스트 찾기 화면으로 재이동 확인
    Then 10자 이상 영어 사전 검색 시 선택 가능 글자수 초과 토스트 팝업 노출 확인
    And 2초 대기
    And 사전 검색 종료 버튼 클릭
    Then "책 읽기 상태로 변경됩니다" 문구가 담긴 토스트 팝업 노출 확인

  Scenario: 영한 사전 우측 상단 검색 버튼 기능 동작 확인 (viewer_059)
    Given 라이브러리 버튼 클릭
    When 검색 버튼 클릭
    And 검색창에서 "Loss of Biodiversity 1" 입력
    And 검색창에서 검색 실행 버튼 클릭
    And 검색결과 화면에서 독서 검색결과 섹션의 0번째 항목 선택
    And 속속 캐스트북 확인 버튼 클릭
    And 15초 대기
    And 코치마크 노출 시 닫기
    And Reading continue "No"
    And 15초 대기
    And 플레이어 내에서 상단바 노출
    And 음원 재생 - 정지 버튼 클릭
    And 하단바에서 펼쳐보기 버튼 클릭
    And 펼쳐보기 리스트의 16번째 페이지로 이동
    And 5초 대기
    And 플레이어 내에서 상단바 노출
    And 더보기 버튼 클릭
    And 사전 버튼 클릭
    And 5초 대기
    And 영어사전 도움말 페이지 노출 시 닫기
    And 사전 검색 X:603 Y:756
    And 2초 대기
    And 영한사전 우측 상단 검색 버튼 클릭
    And 10초 대기
    Then 사전검색 화면 확인

