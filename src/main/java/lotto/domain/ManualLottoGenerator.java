package lotto.domain;

import java.util.Set;

public class ManualLottoGenerator implements LottoGenerator{

    private final Set<Integer> numbers;

    public ManualLottoGenerator(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(numbers);
    }
}
