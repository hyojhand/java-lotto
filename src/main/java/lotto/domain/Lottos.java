package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult matchLottos(Lotto otherLotto) {
        EnumMap<LottoMatch, Integer> lottoResultStore = new EnumMap<>(LottoMatch.class);
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchLottoCount(otherLotto);
            LottoMatch lottoMatch = LottoMatch.findLottoMatch(matchCount);
            lottoResultStore.put(lottoMatch, lottoResultStore.getOrDefault(lottoMatch, 0) + 1);
        }
        return new LottoResult(lottoResultStore);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

