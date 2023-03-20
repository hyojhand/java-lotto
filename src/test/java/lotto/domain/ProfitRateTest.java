package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitRateTest {

    @Test
    @DisplayName("같은 비율의 수익률은 같은 객체임을 테스트")
    void profitRate_SameObject_Test() {
        ProfitRate profitRate = new ProfitRate(2.2);
        assertThat(profitRate).isEqualTo(new ProfitRate(2.2));
    }
}