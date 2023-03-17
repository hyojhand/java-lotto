package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static final RandomLottoGenerator RANDOM_NUMBER_GENERATOR = new RandomLottoGenerator();

    private RandomLottoGenerator() {
    }

    public static RandomLottoGenerator getInstance() {
        return RANDOM_NUMBER_GENERATOR;
    }

    @Override
    public Lotto generateLotto() {
        Collections.shuffle(NUMBERS);

        Set<Integer> numbers = NUMBERS.stream()
                .limit(6)
                .collect(Collectors.toSet());

        return new Lotto(numbers);
    }
}
