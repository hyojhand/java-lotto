package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        Money buyMoney = new Money(inputView.inputBuyMoney());

        int manualLottoCount = inputView.inputBuyManualLottoCount();
        int autoLottoCount = (int) buyMoney.divide(new Money(Lotto.LOTTO_PRICE)) - manualLottoCount;

        List<Lotto> manualLottos = inputView.inputManualLottoNumbers(manualLottoCount);
        List<Lotto> buyLottos = buyAutoLottos(manualLottos, autoLottoCount);
        Lottos lottos = new Lottos(buyLottos);

        outputView.printBuyLottoCount(manualLottoCount, autoLottoCount);
        outputView.printLottos(lottos);

        WinLotto winLotto = getWinLotto();

        LottoResult lottoResult = lottos.matchLottos(winLotto);
        outputView.printLottoResult(lottoResult);
        outputView.printLottoRate(new ProfitRate(lottoResult.getTotalLottoMoney().divide(buyMoney)));
    }

    private WinLotto getWinLotto() {
        Set<Integer> winNumbers = inputView.inputWinLottoNumber();
        int bonusNumber = inputView.inputBonusNumber();
        return new WinLotto(winNumbers, bonusNumber);
    }

    private List<Lotto> buyAutoLottos(List<Lotto> buyLottos, int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = RandomNumberGenerator.getInstance().makeRandomNumbers();
            buyLottos.add(lotto);
        }

        return buyLottos;
    }

}
