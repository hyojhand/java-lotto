package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    private Set<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("같은 숫자의 로또는 같은 객체임을 테스트")
    void lotto_sameNumber_SameObject() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5", "1,1,2,3,4,5"}, delimiter = ',')
    @DisplayName("로또의 개수가 6이 아니거나, 중복된 숫자가 있으면 예외 반환")
    void lotto_NotCorrectNumbers_ExceptionTest(String inputNumbers) {
        Set<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 로또 숫자 입니다");
    }

    @Test
    @DisplayName("로또에 번호가 포함되어있는지 테스트")
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
        Lotto otherLotto = new Lotto(Set.of(1, 2, 3, 7, 8, 9));

        assertThat(lotto.getMatchLottoCount(otherLotto)).isEqualTo(3);
    }
}