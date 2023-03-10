package lotto.domain;

import java.util.Set;

public class WinLotto extends Lotto {

    private final LottoNumber bonusNumber;

    public WinLotto(Set<Integer> numbers, int number) {
        super(numbers);

        if (numbers.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 중복 될 수 업습니다");
        }
        this.bonusNumber = LottoNumber.from(number);
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }


}
