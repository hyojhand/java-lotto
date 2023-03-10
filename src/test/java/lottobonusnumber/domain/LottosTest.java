package lottobonusnumber.domain;

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
    private Lotto lotto2;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        lotto2 = new Lotto(Set.of(1, 2, 3, 7, 8, 9));
        lottos = new Lottos(List.of(lotto, lotto2));
    }

    @Test
    @DisplayName("같은 번호들의 로또들은 같은 객체임을 테스트")
    void lottos_SameObject_Test() {
        assertThat(lottos).isEqualTo(new Lottos(List.of(lotto, lotto2)));
    }

    @Test
    @DisplayName("로또 번호를 매치하는 테스트")
    void matchLottos_Test() {
        Map<LottoMatch, Long> lottoResultStore = new EnumMap<>(LottoMatch.class);
        lottoResultStore.put(LottoMatch.FIFTH, 1L);
        lottoResultStore.put(LottoMatch.SECOND, 1L);
        LottoResult lottoResult = new LottoResult(lottoResultStore);

        WinLotto winLotto = new WinLotto(Set.of(1, 2, 3, 4, 5, 45), 6);
        assertThat(lottos.matchLottos(winLotto)).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName("로또들의 개수 테스트")
    void getLottosSize_Test() {
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }
}