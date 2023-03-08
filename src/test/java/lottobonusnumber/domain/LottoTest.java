package lottobonusnumber.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    private LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("같은 숫자의 로또는 같은 객체임을 테스트")
    void lotto_SameObject_Test() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("로또에 숫자가 포함되어 있는지 테스트")
    void isContainNumber_Test() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertAll(
                () -> assertThat(lotto.isContainNumber(LottoNumber.from(1))).isTrue(),
                () -> assertThat(lotto.isContainNumber(LottoNumber.from(45))).isFalse()
        );
    }

    @Test
    @DisplayName("다른 로또와 비교해서 매칭되는 개수 테스트")
    void getMatchLottoCount_Test() {
        Lotto lotto = new Lotto(lottoNumbers);

        LottoNumbers otherLottoNumbers = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 7));
        Lotto otherLotto = new Lotto(otherLottoNumbers);

        assertThat(lotto.getMatchLottoCount(otherLotto)).isEqualTo(5);
    }

}