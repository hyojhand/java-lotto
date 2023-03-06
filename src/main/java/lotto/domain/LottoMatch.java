package lotto.domain;

import java.util.Arrays;

public enum LottoMatch {
    DEFAULT(0, new Money(0)),
    THREE(3, new Money(5000)),
    FOUR(4, new Money(50000)),
    FIVE(5, new Money(1500000)),
    SIX(6, new Money(2000000000));

    private final int matchCount;
    private final Money money;

    LottoMatch(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoMatch findLottoMatch(int count) {
        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matchCount == count)
                .findFirst()
                .orElse(DEFAULT);
    }

    public long getCalculateMoney(int count) {
        return money.calculateMoney(count);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getMoney() {
        return money;
    }
}
