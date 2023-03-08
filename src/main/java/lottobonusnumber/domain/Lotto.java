package lottobonusnumber.domain;

import java.util.Objects;

public class Lotto {

    protected static final int LOTTO_PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int getMatchLottoCount(Lotto otherLotto) {
        return lottoNumbers.matchLotto(otherLotto);
    }

    public boolean isContainNumber(LottoNumber lottoNumber) {
        return lottoNumbers.isContainNumber(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
