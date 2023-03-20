package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoneyTest {

    @Test
    @DisplayName("금액이 같으면 같은 객체임을 테스트")
    void money_SameObject_Test() {
        Money money = new Money(5000);
        assertThat(money).isEqualTo(new Money(5000));
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide_Test() {
        Money money = new Money(10000);
        assertAll(
                () -> assertThat(money.divide(1000)).isEqualTo(10),
                () -> assertThat(money.divide(30000)).isEqualTo(0.33)
        );
    }

    @Test
    @DisplayName("금액을 더한 결과 금액 테스트")
    void plus_Test() {
        Money money = new Money(10000);
        assertThat(money.plus(new Money(5000))).isEqualTo(new Money(15000));
    }

    @Test
    @DisplayName("수량만큼 곱한 결과 금액 테스트")
    void multiply_Test() {
        Money money = new Money(5000);
        assertThat(money.multiply(2)).isEqualTo(new Money(10000));
    }

}