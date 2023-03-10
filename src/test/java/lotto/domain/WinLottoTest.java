package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinLottoTest {

    @Test
    @DisplayName("당첨 로또 번호와 보너스 번호가 같으면 같은 객체임을 테스트")
    void winLotto_SameObject_Test() {
        WinLotto winLotto = new WinLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winLotto).isEqualTo(new WinLotto(Set.of(1, 2, 3, 4, 5, 6), 7));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "1,1,2,3,4,5"}, delimiter = ',')
    @DisplayName("당첨 로또 번호가 잘못되면 예외 반환")
    void winLotto_DuplicateLottoNumber_Exception(String inputNumbers) {
        Set<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> new WinLotto(numbers, 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된 로또 숫자 입니다");
    }

    @Test
    @DisplayName("당첨로또 번호와 보너스 번호가 중복되면 예외 반환")
    void winLotto_DuplicateBonusNumber_ExceptionTest() {
        assertThatThrownBy(() -> new WinLotto(Set.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 중복 될 수 업습니다");
    }

    @Test
    @DisplayName("당첨로또의 보너스 번호가 로또에 포함하는지 테스트")
    void matchBonusNumber_Test() {
        WinLotto winLotto = new WinLotto(Set.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winLotto.matchBonusNumber(new Lotto(Set.of(7, 8, 9, 10, 11, 12)))).isTrue();
    }

}