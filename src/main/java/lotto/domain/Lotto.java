package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    protected static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if (!isRightLottoSize(lotto.size())) {
            throw new IllegalArgumentException("로또의 숫자는 6개 입니다");
        }

        if (isDuplicate(lotto)) {
            throw new IllegalArgumentException("로또의 숫자는 중복되면 안됩니다");
        }

        this.lotto = lotto;
    }

    public int getMatchLottoCount(Lotto otherLotto) {
        return (int) lotto.stream()
                .filter(otherLotto::isContain)
                .count();
    }

    private boolean isContain(LottoNumber number) {
        return lotto.contains(number);
    }

    private boolean isRightLottoSize(int size) {
        return size == LOTTO_NUMBER_SIZE;
    }

    private boolean isDuplicate(List<LottoNumber> lotto) {
        Set<LottoNumber> numbers = new HashSet<>(lotto);
        return numbers.size() != LOTTO_NUMBER_SIZE;
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

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
