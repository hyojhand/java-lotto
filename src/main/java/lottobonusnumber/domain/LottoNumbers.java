package lottobonusnumber.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(Set<Integer> numbers) {
        if (!isRightLottoSize(numbers)) {
            throw new IllegalArgumentException("로또의 숫자가 부족하거나 중복되었습니다");
        }

        this.lottoNumbers = mappingLottoNumber(numbers);
    }

    public int matchLotto(Lotto otherLotto) {
        return (int) lottoNumbers.stream()
                .filter(otherLotto::isContainNumber)
                .count();
    }

    public boolean isContainNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    private Set<LottoNumber> mappingLottoNumber(Set<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    private boolean isRightLottoSize(Set<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_SIZE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}