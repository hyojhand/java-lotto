package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult matchLottos(WinLotto winLotto) {
        Map<LottoMatch, Long> lottoResultStore = lottos.stream()
                .map(winLotto::findLottoMatch)
                .collect(Collectors.groupingBy(lottoMatch -> lottoMatch, Collectors.counting()));
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

