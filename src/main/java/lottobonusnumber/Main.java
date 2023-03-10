package lottobonusnumber;

import lottobonusnumber.controller.LottoController;
import lottobonusnumber.view.InputView;
import lottobonusnumber.view.OutputView;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView());
        lottoController.start();
    }
}
