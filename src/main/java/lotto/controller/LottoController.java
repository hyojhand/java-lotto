package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStart() {
        int inputMoney = inputView.inputBuyMoney();
        Money buyMoney = new Money(inputMoney);

        int manualLottoCount = inputView.inputBuyManualLottoCount();
        int autoLottoCount = (int) buyMoney.divide(Lotto.LOTTO_PRICE) - manualLottoCount;

        List<Set<Integer>> manualLottoNumbers = inputView.inputManualLottoNumbers(manualLottoCount);
        List<Lotto> manualLottos = generateManualLottos(manualLottoNumbers);
        List<Lotto> autoLottos = generateAutoLottos(RandomLottoGenerator.getInstance(), autoLottoCount);
        Lottos lottos = mappingLottos(autoLottos, manualLottos);

        outputView.printBuyLottoCount(manualLottoCount, autoLottoCount);
        outputView.printLottos(lottos);

        WinLotto winLotto = getWinLotto();

        LottoResult lottoResult = lottos.matchLottos(winLotto);
        outputView.printLottoResult(lottoResult);
        outputView.printLottoRate(new ProfitRate(lottoResult.getTotalLottoMoney().divide(inputMoney)));
    }

    private List<Lotto> generateManualLottos(List<Set<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> new ManualLottoGenerator(numbers).generateLotto())
                .collect(Collectors.toList());
    }

    private List<Lotto> generateAutoLottos(LottoGenerator lottoGenerator, int count) {
        return Stream.generate(lottoGenerator::generateLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    private Lottos mappingLottos(List<Lotto> lottos, List<Lotto> otherLottos) {
        lottos.addAll(otherLottos);
        return new Lottos(lottos);
    }

    private WinLotto getWinLotto() {
        Set<Integer> winNumbers = inputView.inputWinLottoNumber();
        int bonusNumber = inputView.inputBonusNumber();
        return new WinLotto(winNumbers, bonusNumber);
    }
}
