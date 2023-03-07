package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:SIX", "1,2,3,4,5,7:FIVE", "1,2,3,4,7,8:FOUR",
            "1,2,3,7,8,9:THREE", "1,2,7,8,9,10:DEFAULT"}, delimiter = ':')
    @DisplayName("매칭되는 로또 결과 테스트")
    public void findLottoMatch_Test(String inputNumbers, LottoMatch lottoMatch) {
        Lotto lotto = new Lotto(List.of(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5), LottoNumber.from(6)));

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String inputNumber : inputNumbers.split(",")) {
            lottoNumbers.add(LottoNumber.from(Integer.parseInt(inputNumber)));
        }
        Lotto otherLotto = new Lotto(lottoNumbers);

        int matchLottoCount = lotto.getMatchLottoCount(otherLotto);
        assertThat(LottoMatch.findLottoMatch(matchLottoCount)).isEqualTo(lottoMatch);
    }

    @ParameterizedTest
    @CsvSource(value = {"SIX,4000000000", "FIVE,3000000", "FOUR,100000", "THREE,10000", "DEFAULT,0"}, delimiter = ',')
    @DisplayName("결과금액 값 계산 테스트")
    public void getCalculateMoney_Test(LottoMatch lottoMatch, long calculateMoney) {
        assertThat(lottoMatch.getCalculateMoney(2)).isEqualTo(calculateMoney);

    }


}