package lotto.domain;

import java.util.Objects;

public class ProfitRate {

    private final double rate;

    public ProfitRate(double rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfitRate that = (ProfitRate) o;
        return Double.compare(that.rate, rate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate);
    }

    public double getRate() {
        return rate;
    }
}
