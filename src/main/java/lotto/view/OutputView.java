package lotto.view;

import lotto.domain.*;

public class OutputView {

    public void printBuyLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
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
            result.append(lottoMatch.getMatchCount()).append("개 일치 (")
                    .append(lottoMatch.getMoney()).append("원)- ")
                    .append(lottoResult.getMatchResult(lottoMatch.getMatchCount()))
                    .append("개").append('\n');
        }
        System.out.println(result);
    }

    public void printLottoRate(Money money, int lottoMoney) {
        StringBuilder result = new StringBuilder();
        result.append("총 수익률은 ");
        result.append(String.format("%.2f", money.getLottoRate(lottoMoney)));
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
