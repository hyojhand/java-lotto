package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("로또 구매가능 개수 테스트")
    void getBuyLottoCount_Test() {
        Money money = new Money(10000);
        assertThat(money.getBuyLottoCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 수익률 테스트")
    void getLottoRate_Test() {
        Money money = new Money(10000);
        assertThat(money.getLottoRate(5000)).isEqualTo(0.50);
    }

    @Test
    @DisplayName("수량만큼 곱하는 계산 테스트")
    void calculateMoney_Test() {
        Money money = new Money(5000);
        assertThat(money.calculateMoney(2)).isEqualTo(10000);
    }

}