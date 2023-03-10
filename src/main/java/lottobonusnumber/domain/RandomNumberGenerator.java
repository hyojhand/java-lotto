package lottobonusnumber.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    private static final RandomNumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();

    private RandomNumberGenerator() {
    }

    public static RandomNumberGenerator getInstance() {
        return RANDOM_NUMBER_GENERATOR;
    }

    public Lotto makeRandomNumbers() {
        Collections.shuffle(NUMBERS);

        Set<Integer> numbers = NUMBERS.stream()
                .limit(6)
                .collect(Collectors.toSet());

        return new Lotto(numbers);
    }
}
