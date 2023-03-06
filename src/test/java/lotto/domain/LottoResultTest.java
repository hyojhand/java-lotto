package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    private EnumMap<LottoMatch, Integer> lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new EnumMap<>(LottoMatch.class);
    }

    @Test
    @DisplayName("로또 매치 개수가 3개인 로또 테스트")
    void getMatchResult_Three_Test() {
        lottoResultStore.put(LottoMatch.THREE, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertAll(
                () -> assertThat(lottoResult.getMatchResult(3)).isEqualTo(1),
                () -> assertThat(lottoResult.getMatchResult(4)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("로또 매치 총 금액 테스트")
    void getTotalLottoMoney_Test() {
        lottoResultStore.put(LottoMatch.THREE, 1);
        lottoResultStore.put(LottoMatch.FOUR, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getTotalLottoMoney()).isEqualTo(55000);
    }
}