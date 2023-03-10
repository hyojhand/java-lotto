package lottobonusnumber.controller;

import lottobonusnumber.domain.*;
import lottobonusnumber.view.InputView;
import lottobonusnumber.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Money buyMoney = new Money(inputView.inputBuyMoney());
        Lottos lottos = buyLottos(buyMoney.getBuyCount(Lotto.LOTTO_PRICE));

        outputView.printBuyLottoCount(lottos.getLottosSize());
        outputView.printLottos(lottos);

        Set<Integer> winNumbers = inputView.inputWinLottoNumber();
        int bonusNumber = inputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        LottoResult lottoResult = lottos.matchLottos(winLotto);
        outputView.printLottoResult(lottoResult);
        outputView.printLottoRate(buyMoney, lottoResult.getTotalResultMoney());
    }

    private Lottos buyLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = RandomNumberGenerator.getInstance().makeRandomNumbers();
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }
}
