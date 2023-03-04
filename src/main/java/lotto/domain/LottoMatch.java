package lotto.domain;

public enum LottoMatch {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int money;

    LottoMatch(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMoney() {
        return money;
    }

    public int getCalculateMoney(int count) {
        return money * count;
    }
}
