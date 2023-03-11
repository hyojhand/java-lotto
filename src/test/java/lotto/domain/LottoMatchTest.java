package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,false,FOURTH", "3,false,FIFTH"}, delimiter = ',')
    @DisplayName("매칭되는 로또 결과 테스트")
    public void findLottoMatch_Test(int matchCount, boolean isBonus, LottoMatch expectLottoMatch) {
        assertThat(LottoMatch.findLottoMatch(matchCount, isBonus)).isEqualTo(expectLottoMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,4000000000", "SECOND,60000000", "THIRD,3000000", "FOURTH,100000", "FIFTH,10000", "DEFAULT,0"}, delimiter = ',')
    @DisplayName("결과금액 값 계산 테스트")
    public void getCalculateMoney_Test(LottoMatch lottoMatch, long calculateMoney) {
        assertThat(lottoMatch.multiplyCountMoney(2)).isEqualTo(new Money(calculateMoney));
    }


}