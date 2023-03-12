package lotto.domain;

import java.util.Objects;

public class WinLotto extends ForwardingLotto{

    private final LottoNumber bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        super(lotto);

        if (lotto.isContainNumber(LottoNumber.from(bonusNumber))) {
            throw new IllegalArgumentException("보너스 번호는 중복 될 수 업습니다");
        }

        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public LottoMatch findLottoMatch(Lotto anotherLotto) {
        int matchCount = super.getMatchLottoCount(anotherLotto);
        boolean isBonus = matchBonusNumber(anotherLotto);
        return LottoMatch.findLottoMatch(matchCount, isBonus);
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLotto winLotto = (WinLotto) o;
        return Objects.equals(bonusNumber, winLotto.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
