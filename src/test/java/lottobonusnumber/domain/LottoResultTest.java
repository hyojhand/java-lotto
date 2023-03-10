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

    private Map<LottoMatch, Long> lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new EnumMap<>(LottoMatch.class);
    }

    @Test
    @DisplayName("같은 로또 결과를 가지면 같은 객체임을 테스트")
    void lottoResult_SameObject_Test() {
        lottoResultStore.put(LottoMatch.FIFTH, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult).isEqualTo(new LottoResult(lottoResultStore));
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,6,false", "SECOND,5,true", "THIRD,5,false"}, delimiter = ',')
    @DisplayName("로또 결과 조회 테스트")
    void getMatchResult_Test(LottoMatch lottoMatch, int matchCount, boolean isBonus) {
        lottoResultStore.put(lottoMatch, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getMatchResult(matchCount, isBonus)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 총 당첨금액 결과 테스트")
    void getTotalResultMoney_Test() {
        lottoResultStore.put(LottoMatch.FIFTH, 1L);
        lottoResultStore.put(LottoMatch.FOURTH, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getTotalResultMoney()).isEqualTo(new Money(55000));
    }

}