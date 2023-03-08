package lottobonusnumber.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private Map<LottoMatch, Integer> lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new EnumMap<>(LottoMatch.class);
    }

    @Test
    @DisplayName("같은 로또 결과를 가지면 같은 객체임을 테스트")
    void lottoResult_SameObject_Test() {
        lottoResultStore.put(LottoMatch.THREE, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult).isEqualTo(new LottoResult(lottoResultStore));
    }

    @ParameterizedTest
    @CsvSource(value = {"SIX,6,false", "BONUS,5,true", "FIVE,5,false"}, delimiter = ',')
    @DisplayName("로또 결과 조회 테스트")
    void getMatchResult_Test(LottoMatch lottoMatch, int matchCount, boolean isBonus) {
        lottoResultStore.put(lottoMatch, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getMatchResult(matchCount, isBonus)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 총 당첨금액 결과 테스트")
    void getTotalResultMoney_Test() {
        lottoResultStore.put(LottoMatch.THREE, 1);
        lottoResultStore.put(LottoMatch.FOUR, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getTotalResultMoney()).isEqualTo(new Money(55000));
    }

}