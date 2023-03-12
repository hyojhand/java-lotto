package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final Map<LottoMatch, Long> lottoResult;

    public LottoResult(Map<LottoMatch, Long> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public long getMatchCount(int matchCount, boolean isBonus) {
        return lottoResult.getOrDefault(LottoMatch.findLottoMatch(matchCount, isBonus), 0L);
    }

    public Money getTotalLottoMoney() {
        return Arrays.stream(LottoMatch.values())
                .map(value -> value.multiplyCountMoney(lottoResult.getOrDefault(value, 0L)))
                .reduce(new Money(0), Money::plus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottoResult, that.lottoResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoResult);
    }
}
