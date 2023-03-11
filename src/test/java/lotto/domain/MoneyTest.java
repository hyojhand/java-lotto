package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("금액이 같으면 같은 객체임을 테스트")
    void money_SameObject_Test() {
        Money money = new Money(5000);
        assertThat(money).isEqualTo(new Money(5000));
    }

    @Test
    @DisplayName("구매가능 개수 테스트")
    void getBuyCount_Test() {
        Money money = new Money(10000);
        assertThat(money.getBuyCount(1000)).isEqualTo(10);
    }

    @Test
    @DisplayName("수익률 결과 테스트")
    void getProfitRate_Test() {
        Money money = new Money(10000);
        assertThat(money.getProfitRate(new Money(5000))).isEqualTo(0.50);
    }

    @Test
    @DisplayName("금액을 더한 결과 금액 테스트")
    void plusMoney_Test() {
        Money money = new Money(10000);
        assertThat(money.plusMoney(new Money(5000))).isEqualTo(new Money(15000));
    }

    @Test
    @DisplayName("수량만큼 곱한 결과 금액 테스트")
    void multiplyCountMoney_Test() {
        Money money = new Money(5000);
        assertThat(money.multiplyCountMoney(2)).isEqualTo(new Money(10000));
    }

}