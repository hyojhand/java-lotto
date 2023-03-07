package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6));
    }

    @Test
    @DisplayName("같은 숫자의 로또는 같은 객체임을 테스트")
    void lotto_sameNumber_SameObject() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또의 개수가 6개가 아니면 예외 반환")
    void lotto_sizeNotSix_False() {
        assertThatThrownBy(() -> new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자는 6개 입니다");
    }

    @Test
    @DisplayName("로또의 숫자가 중복되면 예외 반환")
    void lotto_duplicateNumber_ExceptionTest() {
        assertThatThrownBy(() -> new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자는 중복되면 안됩니다");
    }

    @Test
    @DisplayName("다른 로또와 비교해서 매칭되는 개수 테스트")
    void getMatchLottoCount_matchTree_Test() {
        Lotto lotto = new Lotto(lottoNumbers);

        Lotto otherLotto = new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(7), LottoNumber.from(8), LottoNumber.from(9)));

        assertThat(lotto.getMatchLottoCount(otherLotto)).isEqualTo(3);
    }
}