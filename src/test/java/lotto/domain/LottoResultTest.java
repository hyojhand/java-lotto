package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("로또 매치 개수가 3개인 로또 테스트")
    void getMatchResult_Three_Test() {
        lottoResult.updateResult(3);
        assertAll(
                () -> assertThat(lottoResult.getMatchResult(3)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchResult(4)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("로또 매치 총 금액 테스트")
    void getTotalLottoMoney_Test() {
        lottoResult.updateResult(3);
        lottoResult.updateResult(4);
        assertThat(lottoResult.getTotalLottoMoney()).isEqualTo(55000);
    }
}