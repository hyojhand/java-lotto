package lottobonusnumber.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"FIRST,6,false", "SECOND,5,true", "THIRD,5,false", "FOURTH,4,false", "FIFTH,3,false"}, delimiter = ',')
    @DisplayName("매칭되는 로또 결과 테스트")
    void findLottoMatch_Test(LottoMatch expectLottoMatch, int matchCount, boolean isBonus) {
        assertThat(LottoMatch.findLottoMatch(matchCount, isBonus)).isEqualTo(expectLottoMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST,4000000000", "SECOND,60000000", "THIRD,3000000", "FOURTH,100000", "FIFTH,10000", "DEFAULT,0"}, delimiter = ',')
    @DisplayName("개수만큼 곱한 금액 결과 테스트")
    void getMultiplyCountMoney_Test(LottoMatch lottoMatch, long resultMoney) {
        assertThat(lottoMatch.getMultiplyCountMoney(2)).isEqualTo(new Money(resultMoney));
    }

}