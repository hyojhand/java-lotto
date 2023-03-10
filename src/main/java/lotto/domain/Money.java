package lotto.domain;

import java.util.Objects;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public int getBuyCount(int price) {
        return (int) (money / price);
    }

    public double getProfitRate(Money resultMoney) {
        return (double) resultMoney.money / money;
    }

    public Money plusMoney(Money otherMoney) {
        return new Money(money + otherMoney.money);
    }

    public Money multiplyCountMoney(long count) {
        return new Money(money * count);
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
