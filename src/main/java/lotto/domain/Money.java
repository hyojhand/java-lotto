package lotto.domain;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getBuyLottoCount() {
        return money / LOTTO_PRICE;
    }

    public double getLottoRate(int lottoMoney) {
        return (double) lottoMoney / money;
    }
}
