package lottobonusnumber.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 6개가 같다면 같은 객체임을 테스트")
    void lottoNumbers_SameObject_Test() {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "1,1,2,3,4,5"}, delimiter = ',')
    @DisplayName("로또 개수가 6개가 아니거나, 중복된 숫자가 있을 경우 예외반환 테스트")
    void lottoNumbers_WrongLottoNumbers_ExceptionTest(String inputNumbers) {
        Set<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> new LottoNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자가 부족하거나 중복되었습니다");
    }

    @Test
    @DisplayName("다른 로또와 매치되는 개수 테스트")
    void matchLotto_NumberCount_Test() {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        Lotto otherLotto = new Lotto(new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers.matchLotto(otherLotto)).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "44,false", "45,false"}, delimiter = ',')
    @DisplayName("로또 번호를 포함하는지 테스트")
    void isContainNumber_Test(int lottoNumber, boolean expect) {
        LottoNumbers lottoNumbers = new LottoNumbers(Set.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.isContainNumber(LottoNumber.from(lottoNumber))).isEqualTo(expect);
    }
}