package lottobonusnumber.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("같은 숫자의 로또번호는 같은 객체임을 테스트")
    void lottoNumber_sameNumber_SameObject() {
        LottoNumber lottoNumber = LottoNumber.from(1);
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("숫자 1에서 45 사이가 아니면 예외 반환 테스트")
    void lottoNumber_notBetween1And45_Exception(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 숫자입니다");
    }

}