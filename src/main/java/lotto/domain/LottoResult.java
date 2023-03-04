package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static final int MIN_MATCH_COUNT = 3;
    private final Map<Integer, Integer> lottoResult = new HashMap<>();

    public void updateResult(int matchCount) {
        if (matchCount < MIN_MATCH_COUNT) {
            return;
        }

        lottoResult.put(matchCount, lottoResult.getOrDefault(matchCount, 0) + 1);
    }

    public int getMatchResult(int matchCount) {
        return lottoResult.getOrDefault(matchCount, 0);
    }

    public int getTotalLottoMoney() {
        return Arrays.stream(LottoMatch.values())
                .mapToInt(value -> value.getCalculateMoney(lottoResult.getOrDefault(value.getMatchCount(), 0)))
                .sum();
    }
}
