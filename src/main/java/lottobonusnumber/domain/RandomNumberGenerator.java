package lottobonusnumber.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerator {

    private static final List<Integer> NUMBERS = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public LottoNumbers makeRandomNumbers() {
        Collections.shuffle(NUMBERS);

        Set<Integer> numbers = NUMBERS.stream()
                .limit(6)
                .collect(Collectors.toSet());

        return new LottoNumbers(numbers);
    }
}
