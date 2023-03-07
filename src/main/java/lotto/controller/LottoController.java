package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static final RandomNumberGenerator GENERATE_RANDOM_NUMBER = new RandomNumberGenerator();

    public static void main(String[] args) {
        Money buyMoney = new Money(INPUT_VIEW.inputBuyMoney());
        Lottos lottos = buyLottos(buyMoney.getBuyLottoCount());

        OUTPUT_VIEW.printBuyLottoCount(lottos.getLottosSize());
        OUTPUT_VIEW.printLottos(lottos);

        List<Integer> winNumbers = INPUT_VIEW.inputWinLottoNumber();
        Lotto winLotto = changeNumbersToLotto(winNumbers);

        LottoResult lottoResult = lottos.matchLottos(winLotto);
        OUTPUT_VIEW.printLottoResult(lottoResult);
        OUTPUT_VIEW.printLottoRate(buyMoney, lottoResult.getTotalLottoMoney());
    }

    private static Lottos buyLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            List<Integer> randomNumbers = GENERATE_RANDOM_NUMBER.makeRandomNumbers();
            Lotto lotto = changeNumbersToLotto(randomNumbers);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private static Lotto changeNumbersToLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        numbers.forEach((number) -> lottoNumbers.add(LottoNumber.from(number)));
        return new Lotto(lottoNumbers);
    }

}
