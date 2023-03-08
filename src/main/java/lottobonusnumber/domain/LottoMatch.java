package lottobonusnumber.domain;

import java.util.Arrays;

public enum LottoMatch {
    DEFAULT(0, new Money(0)),
    THREE(3, new Money(5_000)),
    FOUR(4, new Money(50_000)),
    FIVE(5, new Money(1_500_000)),
    BONUS(5, new Money(30_000_000), true),
    SIX(6, new Money(2_000_000_000));

    private static final int CAN_BONUS_MATCH_COUNT = 5;
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
        if (matchCount == CAN_BONUS_MATCH_COUNT && isBonus) {
            return LottoMatch.BONUS;
        }

        return Arrays.stream(LottoMatch.values())
                .filter(lottoMatch -> lottoMatch.matchCount == matchCount && !isBonus)
                .findFirst()
                .orElse(DEFAULT);
    }

    public Money getMultiplyCountMoney(int count) {
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
