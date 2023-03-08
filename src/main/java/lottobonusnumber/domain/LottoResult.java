package lottobonusnumber.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final Map<LottoMatch, Integer> lottoResult;

    public LottoResult(Map<LottoMatch, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int getMatchResult(int matchCount, boolean isBonus) {
        return lottoResult.getOrDefault(LottoMatch.findLottoMatch(matchCount, isBonus), 0);
    }

    public Money getTotalResultMoney() {
        return Arrays.stream(LottoMatch.values())
                .map(value -> value.getMultiplyCountMoney(lottoResult.getOrDefault(value, 0)))
                .reduce(new Money(0), Money::plusMoney);
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