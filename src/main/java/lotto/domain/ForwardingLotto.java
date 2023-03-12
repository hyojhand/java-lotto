package lotto.domain;

public class ForwardingLotto {

    private final Lotto lotto;

    public ForwardingLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public int getMatchLottoCount(Lotto anotherLotto) {
        return lotto.getMatchLottoCount(anotherLotto);
    }

}
