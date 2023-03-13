package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private Lotto lotto;
    private Lotto otherLotto;
    private Lottos lottos;
    private Map<LottoMatch, Long> lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new EnumMap<>(LottoMatch.class);

        lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        otherLotto = new Lotto(Set.of(1, 2, 3, 7, 8, 9));
        lottos = new Lottos(List.of(lotto, otherLotto));
    }

    @Test
    @DisplayName("같은 로또들을 가지는 객체는 같음을 테스트")
    void lottos_SameObject_Test() {
        assertThat(lottos).isEqualTo(new Lottos(List.of(lotto, otherLotto)));
    }

    @Test
    @DisplayName("매칭되는 로또번호 개수 결과 테스트")
    void matchLottos_Result_Test() {
        lottoResultStore.put(LottoMatch.FIFTH, 1L);
        lottoResultStore.put(LottoMatch.SECOND, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);

        WinLotto winLotto = new WinLotto(Set.of(1, 2, 3, 4, 5, 10), 6);
        assertThat(lottos.matchLottos(winLotto)).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName("로또들의 사이즈 테스트")
    void getLottosSize_Test() {
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }
}