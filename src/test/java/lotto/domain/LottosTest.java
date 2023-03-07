package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    private Lottos lottos;
    private EnumMap<LottoMatch, Integer> lottoResultStore;

    @BeforeEach
    void setUp() {
        lottoResultStore = new EnumMap<>(LottoMatch.class);

        Lotto lotto = new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));
        Lotto lotto2 = new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9)));
        lottos = new Lottos(List.of(lotto, lotto2));
    }

    @Test
    @DisplayName("매칭되는 로또번호 개수 결과 테스트")
    void matchLottos_Result_Test() {
        lottoResultStore.put(LottoMatch.THREE, 2);
        LottoResult lottoResult = new LottoResult(lottoResultStore);

        Lotto otherLotto = new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(10), LottoNumber.from(11), LottoNumber.from(12)));

        assertThat(lottos.matchLottos(otherLotto)).isEqualTo(lottoResult);
    }

    @Test
    @DisplayName("로또들의 사이즈 테스트")
    void getLottosSize_Test() {
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }
}