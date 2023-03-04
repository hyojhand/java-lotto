package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (isOutOfBound(lottoNumber)) {
            throw new IllegalArgumentException("올바르지 않은 숫자입니다");
        }

        this.lottoNumber = lottoNumber;
    }

    private boolean isOutOfBound(int number) {
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
