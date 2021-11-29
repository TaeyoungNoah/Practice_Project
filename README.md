### java-project 

>  2020 우테코 프리코스 문제 혼자 풀어보기 

- java-baseball-precourse https://github.com/woowacourse/java-baseball-precourse (기능 구현 완료, 구조나 효율성 측면 개선 필요..)
- java-racingcar-precourse https://github.com/woowacourse/java-racingcar-precourse (기능 구현 완료, 구조나 효율성 측면 개선 필요..)
- java-subway-map-precourse https://github.com/woowacourse/java-subway-map-precourse (기능 구현 실패, 구조 짜는 부분에서 부족함 느껴 조금 더 공부 후 재도전)







### Spring_project_Lecture

> 인프런 김영한 - 스프링입문 강의

진행률: 100% 완강🥳 (다음은 스프링 웹 MVC)

https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/dashboard







### Spring_project_Todo

> 강의를 통해 배운걸 복습하며 간단한 TodoList 만들기

#### 기능

- 홈 화면에서 `일정 추가` or `일정 확인` 두가지 작업을 할 수 있다.

  > 일정 추가시, 동일한 이름의 일정은 등록할 수 없다

- 일정 추가

  - `할 일` & `마감 기한` 을 입력할 수 있다.

- 일정 확인

  - 지금까지 등록한 일정을 확인할 수 있다.

  - 등록한 일정을 삭제할 수 있다.

    > 존재하지 않는 일정은 삭제할 수 없다.



#### 개발 계획

- 아직 DB를 이용하는 방법에 익숙치 않으므로 메모리를 이용해 기능을 모두 구현한 뒤 DB에 연결하는 방식으로 설계 



#### Commit

1. Build_basic_Structure

   > Controller, Service, Repository, Domain 구조를 기본적으로 만듦

2. domain, repository 기능구현&테스트

   > 계획에서 말했듯이 우선 메모리 repository에 데이터를 저장하고 관리하는 구조 설계 후 테스트 완료

3. service 기능구현&테스트

   > 일정 추가 (중복 일정 추가에 대한 예외 처리), 일정 삭제 (없는 일정 삭제에 대한 예외 처리), 전체 일정 확인 구조 설계 후 테스트 완료

4. controller,view 기능구현 & Spring MVC구조 정리

   > 메모리를 이용하여 웹에 기능을 구현하는 부분까지 완료

5. DB와 연결 (실패,,)

   > 아직 DB와의 연결이 미숙하여 Test케이스에서 에러 발생 원인 아직 찾지 못함