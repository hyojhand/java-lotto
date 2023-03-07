package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Integer> makeRandomNumbers() {
        Collections.shuffle(NUMBERS);

        return NUMBERS.stream()
                .limit(6)
                .collect(Collectors.toList());
    }
}
