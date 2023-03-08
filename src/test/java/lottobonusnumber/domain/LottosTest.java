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
        lotto = new Lotto(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));
        lotto2 = new Lotto(new LottoNumbers(Set.of(1, 2, 3, 7, 8, 9)));
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
        Map<LottoMatch, Integer> lottoResultStore = new EnumMap<>(LottoMatch.class);
        lottoResultStore.put(LottoMatch.THREE, 1);
        lottoResultStore.put(LottoMatch.BONUS, 1);
        LottoResult lottoResult = new LottoResult(lottoResultStore);

        Lotto otherLotto = new Lotto(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 45)));
        LottoNumber bonusNumber = LottoNumber.from(6);

        assertThat(lottos.matchLottos(otherLotto, bonusNumber)).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName("로또들의 개수 테스트")
    void getLottosSize_Test() {
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }
}