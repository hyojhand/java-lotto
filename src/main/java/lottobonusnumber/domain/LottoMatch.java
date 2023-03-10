package lottobonusnumber.domain;

import java.util.Arrays;

public enum LottoMatch {
    DEFAULT(0, new Money(0)),
    FIFTH(3, new Money(5_000)),
    FOURTH(4, new Money(50_000)),
    THIRD(5, new Money(1_500_000)),
    SECOND(5, new Money(30_000_000), true),
    FIRST(6, new Money(2_000_000_000));

    private final int matchCount;
    private final Money money;
    private boolean isBonus = false;

    LottoMatch(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    LottoMatch(int matchCount, Money money, boolean isBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.isBonus = isBonus;
    }

    public static LottoMatch findLottoMatch(int matchCount, boolean isBonus) {
        if (matchCount == LottoMatch.SECOND.matchCount && isBonus) {
            return LottoMatch.SECOND;
        }

        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matchCount == matchCount && !isBonus)
                .findFirst()
                .orElse(DEFAULT);
    }

    public Money getMultiplyCountMoney(long count) {
        return money.multiplyCountMoney(count);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getMoney() {
        return money;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
