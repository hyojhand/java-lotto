package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LIST_POSITION = 1;

    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        if (isOutOfBound(lottoNumber)) {
            throw new IllegalArgumentException("올바르지 않은 숫자입니다");
        }

        return LOTTO_NUMBERS.get(lottoNumber - LIST_POSITION);
    }

    private static boolean isOutOfBound(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
