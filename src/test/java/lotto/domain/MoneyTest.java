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
    void getLottoRate() {
        Money money = new Money(10000);
        assertThat(money.getLottoRate(5000)).isEqualTo(0.50);
    }
}