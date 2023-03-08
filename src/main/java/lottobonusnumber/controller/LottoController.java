package lottobonusnumber.controller;

import lottobonusnumber.domain.*;
import lottobonusnumber.view.InputView;
import lottobonusnumber.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final RandomNumberGenerator GENERATE_RANDOM_NUMBER = new RandomNumberGenerator();

    public static void main(String[] args) {
        Money buyMoney = new Money(INPUT_VIEW.inputBuyMoney());
        Lottos lottos = buyLottos(buyMoney.getBuyLottoCount());

        OUTPUT_VIEW.printBuyLottoCount(lottos.getLottosSize());
        OUTPUT_VIEW.printLottos(lottos);

        Set<Integer> winNumbers = INPUT_VIEW.inputWinLottoNumber();
        Lotto winLotto = new Lotto(new LottoNumbers(winNumbers));

        LottoNumber bonusNumber = LottoNumber.from(INPUT_VIEW.inputBonusNumber());

        if (winLotto.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 중복될 수 없습니다");
        }

        LottoResult lottoResult = lottos.matchLottos(winLotto, bonusNumber);
        OUTPUT_VIEW.printLottoResult(lottoResult);
        OUTPUT_VIEW.printLottoRate(buyMoney, lottoResult.getTotalResultMoney());
    }

    private static Lottos buyLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            LottoNumbers randomNumbers = GENERATE_RANDOM_NUMBER.makeRandomNumbers();
            Lotto lotto = new Lotto(randomNumbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
