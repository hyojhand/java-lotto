package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private List<Integer> randomNumbers;

    @BeforeEach
    void setUp() {
        RandomNumberGenerator generateRandomNumber = new RandomNumberGenerator();
        randomNumbers = generateRandomNumber.makeRandomNumbers();
    }

    @Test
    @DisplayName("생성된 랜덤번호들이 1에서 45 사이의 숫자 테스트")
    void makeRandomNumbers_between1And45_True() {
        randomNumbers.forEach((number) -> assertThat(NUMBERS.contains(number)).isTrue());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("생성된 랜덤번호들이 1미만 45초과는 False")
    void makeRandomNumbers_under1OrUpper45_False(int number) {
        assertThat(randomNumbers.contains(number)).isFalse();
    }

    @Test
    @DisplayName("생성된 랜덤리스트의 크기는 6 테스트")
    void makeRandomNumbers_sizeSix_True() {
        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}