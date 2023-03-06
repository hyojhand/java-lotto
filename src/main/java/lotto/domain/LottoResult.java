package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Objects;

public class LottoResult {

    private final EnumMap<LottoMatch, Integer> lottoResult;

    public LottoResult(EnumMap<LottoMatch, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int getMatchResult(int matchCount) {
        return lottoResult.getOrDefault(LottoMatch.findLottoMatch(matchCount), 0);
    }

    public long getTotalLottoMoney() {
        return Arrays.stream(LottoMatch.values())
                .mapToLong(value -> value.getCalculateMoney(lottoResult.getOrDefault(value, 0)))
                .sum();
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
