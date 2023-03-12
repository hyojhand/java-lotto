package lotto.view;

import lotto.domain.*;

public class OutputView {

    public void printBuyLottoCount(int manualLottoCount, int autoLottoCount) {
        StringBuilder result = new StringBuilder();
        result.append("수동으로 ").append(manualLottoCount).append("장, ");
        result.append("자동으로 ").append(autoLottoCount).append("개를 구매했습니다.");
        System.out.println(result);
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        StringBuilder result = new StringBuilder();
        result.append("당첨 통계").append('\n');
        result.append("---------").append('\n');

        for (LottoMatch lottoMatch : LottoMatch.values()) {
            result.append(getMatchResultView(lottoMatch));
            result.append("(").append(lottoMatch.getMoney().getMoney()).append("원)- ")
                    .append(lottoResult.getMatchCount(lottoMatch.getMatchCount(), lottoMatch.isBonus()))
                    .append("개").append('\n');
        }
        System.out.println(result);
    }

    private String getMatchResultView(LottoMatch lottoMatch) {
        StringBuilder result = new StringBuilder();
        result.append(lottoMatch.getMatchCount()).append("개 일치");

        if (lottoMatch.isBonus()) {
            result.append(", 보너스 볼 일치");
        }

        return result.toString();
    }

    public void printLottoRate(ProfitRate profitRate) {
        StringBuilder result = new StringBuilder();
        result.append("총 수익률은 ");
        result.append(profitRate.getRate());
        result.append("입니다.");
        System.out.println(result);
    }

    private void printLotto(Lotto lotto) {
        StringBuilder result = new StringBuilder();
        for (LottoNumber number : lotto.getLotto()) {
            result.append(number.getLottoNumber()).append(", ");
        }

        System.out.print("[");
        System.out.print(result.substring(0, result.toString().length() - 2));
        System.out.println("]");
    }

}
