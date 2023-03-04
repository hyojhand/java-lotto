package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult matchLottos(Lotto otherLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchLottoCount(otherLotto);
            lottoResult.updateResult(matchCount);
        }
        return lottoResult;
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

