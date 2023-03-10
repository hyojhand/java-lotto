package lottobonusnumber.domain;

import java.util.Set;

public class WinLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinLotto(Set<Integer> numbers, int bonusNumber) {
        super(numbers);

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다");
        }

        this.bonusNumber = LottoNumber.from(bonusNumber);
    }

    public boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }
}
