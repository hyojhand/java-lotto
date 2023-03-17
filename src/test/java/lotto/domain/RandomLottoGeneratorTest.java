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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RandomLottoGeneratorTest {

    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = RandomLottoGenerator.getInstance().generateLotto();
    }

    @Test
    @DisplayName("생성된 랜덤번호들이 1에서 45 사이의 숫자 테스트")
    void makeRandomNumbers_between1And45_True() {
        long matchCount = NUMBERS.stream()
                .filter(number -> lotto.isContainNumber(LottoNumber.from(number)))
                .count();
        assertThat(matchCount).isEqualTo(LOTTO_SIZE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("생성된 랜덤번호들이 1미만 45초과는 False")
    void makeRandomNumbers_under1OrUpper45_False(int number) {
        assertThatThrownBy(() -> lotto.isContainNumber(LottoNumber.from(number)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 숫자입니다");
    }
}