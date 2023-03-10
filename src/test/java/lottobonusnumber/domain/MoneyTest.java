package lottobonusnumber.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("같은 금액이면 같은 객체임을 테스트")
    void money_SameObject_Test() {
        Money money = new Money(10000);
        assertThat(money).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("개수만큼 곱한 금액 계산 테스트")
    void multiplyCountMoney_Test() {
        Money money = new Money(5000);
        assertThat(money.multiplyCountMoney(2)).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("금액 더하기 테스트")
    void plusMoney_Test() {
        Money money = new Money(5000);
        Money otherMoney = new Money(10000);
        assertThat(money.plusMoney(otherMoney)).isEqualTo(new Money(15000));
    }

    @Test
    @DisplayName("구매한 로또 개수 테스트")
    void getBuyLottoCount_Test() {
        Money money = new Money(5000);
        assertThat(money.getBuyCount(Lotto.LOTTO_PRICE)).isEqualTo(5);
    }

    @Test
    @DisplayName("수익률 구하는 테스트")
    void getLottoRate_Test() {
        Money money = new Money(10000);
        assertThat(money.getProfitRate(new Money(5000))).isEqualTo(0.50);
    }


}