package lottobonusnumber.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lotto) {
        this.lottos = lotto;
    }

    public LottoResult matchLottos(Lotto otherLotto, LottoNumber bonusNumber) {
        Map<LottoMatch, Integer> lottoResultStore = new EnumMap<>(LottoMatch.class);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchLottoCount(otherLotto);
            boolean isBonus = lotto.isContainNumber(bonusNumber);

            LottoMatch lottoMatch = LottoMatch.findLottoMatch(matchCount, isBonus);
            lottoResultStore.put(lottoMatch, lottoResultStore.getOrDefault(lottoMatch, 0) + 1);
        }

        return new LottoResult(lottoResultStore);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
