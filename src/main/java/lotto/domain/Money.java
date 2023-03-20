package lotto.domain;

import java.util.Objects;

public class Money {

    private final long money;

    public Money(long money) {
        this.money = money;
    }

    public double divide(int number) {
        return Math.floor((double) money / number * 100) / 100;
    }

    public Money plus(Money otherMoney) {
        return new Money(money + otherMoney.money);
    }

    public Money multiply(long count) {
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
