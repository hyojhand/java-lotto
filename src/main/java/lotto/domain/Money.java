package lotto.domain;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getBuyLottoCount() {
        return money / Lotto.LOTTO_PRICE;
    }

    public double getLottoRate(long lottoMoney) {
        return (double) lottoMoney / money;
    }

    public long calculateMoney(int count) {
        return (long) money * count;
    }

    public int getMoney() {
        return money;
    }
}
