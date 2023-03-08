# 로또 게임 미션 구현

### 기능 구현 요구사항
**로또(자동)**
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- 로또 1장의 가격은 1000원이다.

**로또(2등)**
- 2등을 위해 추가 번호(보너스 번호)를 하나 더 추첨한다.
- 당첨 통계에 2등을 추가한다.

### 기능 구현사항
- 구입금액을 입력받고, 로또 구매 수량과 로또 번호를 출력한다.
  - 금액은 Money 객체로 관리한다.
- 로또 번호(Lotto Number)는 1~45 사이의 랜덤한 숫자 6개로 구성된다.
    - 로또 번호를 Lotto Number 일급 객체로 관리한다.
    - 정적 팩터리 메서드 패턴으로 생성한 인스턴스를 재사용한다. 
- Lotto 객체
  - 6개의 로또 번호를 가지는 LottoNumbers 일급 컬렉션
  - 로또의 가격을 가진다.
- Lottos 객체 
  - 여러개의 Lotto를 가지는 일급 컬렉션
- enum 클래스로 로또 등수를 관리한다.
  - 로또 매칭 개수, 금액, 보너스 번호 매치여부를 가진다.
- 입력받은 당첨 번호와 로또 번호를 비교하여 일치하는 번호의 수를 확인한다.
  - EnumMap을 활용해 enum으로 관리하는 매칭 결과만 key로 가진다.
- 당첨 통계를 표시하고 수익률을 출력한다.

## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)