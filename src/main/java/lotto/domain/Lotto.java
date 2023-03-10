package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<Integer> numbers) {
        if (!isRightLottoSize(numbers)) {
            throw new IllegalArgumentException("잘못된 로또 숫자 입니다");
        }

        this.lotto = mappingLottoNumber(numbers);
    }

    public int getMatchLottoCount(Lotto otherLotto) {
        return (int) lotto.stream()
                .filter(otherLotto::isContainNumber)
                .count();
    }

    public boolean isContainNumber(LottoNumber number) {
        return lotto.contains(number);
    }

    private boolean isRightLottoSize(Set<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    private Set<LottoNumber> mappingLottoNumber(Set<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }
}
