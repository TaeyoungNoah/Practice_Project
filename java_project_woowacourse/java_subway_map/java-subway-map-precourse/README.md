# 지하철 노선도 미션
**< TodoList>**

1. 기본값 설정
2. StationManagement

> 2글자 이상만 가능 구현
>
> 노선에 등록된 역은 삭제 불가 구현

3. LineManagement

> 2글자 이상만 가능 구현
>
> 등록시 상행 종점역 하행 종점역 받아야함





**<해결하지 못한 의문>**

1. 노선에 등록된 역은 삭제 불가

> 그런데 구간이라는건 노선의 일부가 아닌가? 이해를 잘못했는지 다시 생각해 봐야할 부분



**<아이디어>**

1. Line을 ArrayList가 아니라 Map 으로 관리하면 더 좋지 않을까?

```java
Map<Line,Station[]> = new new HashMap<Line,Station[]>(); 
```

