package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("같은 숫자의 로또는 같은 객체임을 테스트")
    void lotto_sameNumber_SameObject() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또의 개수가 6개가 아니면 예외 반환")
    void lotto_sizeNotSix_False() {
        assertThatThrownBy(() -> new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자는 6개 입니다");
    }

    @Test
    @DisplayName("다른 로또와 비교해서 매칭되는 개수 테스트")
    void getMatchLottoCount_matchTree_Test() {
        List<LottoNumber> lottoNumbers = List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);

        Lotto otherLotto = new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9)));

        assertThat(lotto.getMatchLottoCount(otherLotto)).isEqualTo(3);
    }
}