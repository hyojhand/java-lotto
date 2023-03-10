package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

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

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.gameStart();
    }

    public void gameStart() {
        Money buyMoney = new Money(inputView.inputBuyMoney());
        Lottos lottos = buyLottos(buyMoney.getBuyCount(Lotto.LOTTO_PRICE));

        outputView.printBuyLottoCount(lottos.getLottosSize());
        outputView.printLottos(lottos);

        Set<Integer> winNumbers = inputView.inputWinLottoNumber();
        int bonusNumber = inputView.inputBonusNumber();
        WinLotto winLotto = new WinLotto(winNumbers, bonusNumber);

        LottoResult lottoResult = lottos.matchLottos(winLotto);
        outputView.printLottoResult(lottoResult);
        outputView.printLottoRate(buyMoney, lottoResult.getTotalLottoMoney());
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
