package lottobonusnumber.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    private Set<Integer> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("같은 숫자의 로또는 같은 객체임을 테스트")
    void lotto_SameObject_Test() {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "1,1,2,3,4,5"}, delimiter = ',')
    @DisplayName("로또 개수가 6개가 아니거나, 중복된 숫자가 있을 경우 예외반환 테스트")
    void lottoNumbers_WrongLottoNumbers_ExceptionTest(String inputNumbers) {
        Set<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 숫자가 부족하거나 중복되었습니다");
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

        Set<Integer> otherLottoNumbers = Set.of(1, 2, 3, 4, 5, 7);
        Lotto otherLotto = new Lotto(otherLottoNumbers);

        assertThat(lotto.getMatchLottoCount(otherLotto)).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "44,false", "45,false"}, delimiter = ',')
    @DisplayName("로또 번호를 포함하는지 테스트")
    void isContainNumber_Test(int lottoNumber, boolean expect) {
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.isContainNumber(LottoNumber.from(lottoNumber))).isEqualTo(expect);
    }

}