package lottobonusnumber.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"SIX,6,false", "BONUS,5,true", "FIVE,5,false", "FOUR,4,false", "THREE,3,false"}, delimiter = ',')
    @DisplayName("매칭되는 로또 결과 테스트")
    void findLottoMatch_Test(LottoMatch expectLottoMatch, int matchCount, boolean isBonus) {
        assertThat(LottoMatch.findLottoMatch(matchCount, isBonus)).isEqualTo(expectLottoMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"SIX,4000000000", "BONUS,60000000", "FIVE,3000000", "FOUR,100000", "THREE,10000", "DEFAULT,0"}, delimiter = ',')
    @DisplayName("개수만큼 곱한 금액 결과 테스트")
    void getMultiplyCountMoney_Test(LottoMatch lottoMatch, long resultMoney) {
        assertThat(lottoMatch.getMultiplyCountMoney(2)).isEqualTo(new Money(resultMoney));
    }

}