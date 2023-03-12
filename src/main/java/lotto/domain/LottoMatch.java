package lotto.domain;

import java.util.Arrays;

public enum LottoMatch {
    DEFAULT(0, new Money(0)),
    FIFTH(3, new Money(5000)),
    FOURTH(4, new Money(50000)),
    THIRD(5, new Money(1500000)),
    SECOND(5, new Money(30000000), true),
    FIRST(6, new Money(2000000000));

    private final int matchCount;
    private final Money money;
    private boolean isBonus = false;

    LottoMatch(int matchCount, Money money, boolean isBonus) {
        this.matchCount = matchCount;
        this.money = money;
        this.isBonus = isBonus;
    }

    LottoMatch(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static LottoMatch findLottoMatch(int count, boolean isBonus) {
        if (count == LottoMatch.SECOND.matchCount && isBonus) {
            return LottoMatch.SECOND;
        }

        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matchCount == count)
                .findFirst()
                .orElse(DEFAULT);
    }

    public Money multiplyCountMoney(long count) {
        return money.multiply(count);
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
