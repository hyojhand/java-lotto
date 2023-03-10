package lottobonusnumber.domain;

import java.util.Objects;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public Money multiplyCountMoney(int count) {
        return new Money(money * count);
    }

    public Money plusMoney(Money otherMoney) {
        return new Money(money + otherMoney.money);
    }

    public int getBuyLottoCount() {
        return (int) money / Lotto.LOTTO_PRICE;
    }

    public double getLottoRate(Money resultMoney) {
        return (double) resultMoney.money / money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

    public long getMoney() {
        return money;
    }
}