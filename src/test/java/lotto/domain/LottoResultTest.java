package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("같은 결과를 가지면 같은 객체임을 테스트")
    void lottoResult_SameObject_Test() {
        lottoResultStore.put(LottoMatch.FIRST,1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult).isEqualTo(new LottoResult(lottoResultStore));
    }

    @Test
    @DisplayName("로또 결과의 매치되는 개수 테스트")
    void getMatchCount_Test() {
        lottoResultStore.put(LottoMatch.FIRST, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getMatchCount(6, false)).isEqualTo(1L);
    }

    @Test
    @DisplayName("로또 매치 총 금액 테스트")
    void getTotalLottoMoney_Test() {
        lottoResultStore.put(LottoMatch.FOURTH, 1L);
        lottoResultStore.put(LottoMatch.FIFTH, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);
        assertThat(lottoResult.getTotalLottoMoney()).isEqualTo(new Money(55000));
    }
}