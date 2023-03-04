package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        Lotto lotto2 = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));
        lottos = new Lottos(List.of(lotto, lotto2));
    }

    @Test
    @DisplayName("로또들의 사이즈 테스트")
    void getLottosSize_Test() {
        assertThat(lottos.getLottosSize()).isEqualTo(2);
    }
}