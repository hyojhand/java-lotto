package lottobonusnumber.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomNumberGeneratorTest {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private LottoNumbers randomNumbers;

    @BeforeEach
    void setUp() {
        RandomNumberGenerator generateRandomNumber = new RandomNumberGenerator();
        randomNumbers = generateRandomNumber.makeRandomNumbers();
    }

    @Test
    @DisplayName("생성된 랜덤번호들이 1에서 45 사이의 숫자 테스트")
    void makeRandomNumbers_between1And45_True() {
        int matchCount = (int) NUMBERS.stream()
                .filter(number -> randomNumbers.isContainNumber(LottoNumber.from(number)))
                .count();

        assertThat(matchCount).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("생성된 랜덤번호들이 1미만 45초과는 예외 반환 테스트")
    void makeRandomNumbers_under1OrUpper45_ExceptionTest(int number) {
        assertThatThrownBy(() -> randomNumbers.isContainNumber(LottoNumber.from(number)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 숫자입니다");
    }
}