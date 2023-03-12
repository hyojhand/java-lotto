package lotto.view;

import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputBuyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(inputValue());
    }

    public int inputBuyManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(inputValue());
    }

    public List<Lotto> inputManualLottoNumbers(int buyCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> lottoStore = new ArrayList<>();
        for(int i = 0; i < buyCount; i++) {
            String input = inputValue();
            Set<Integer> numbers = changeToNumbers(input);
            lottoStore.add(new Lotto(numbers));
        }

        return lottoStore;
    }

    public Set<Integer> inputWinLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = inputValue();
        return changeToNumbers(input);
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(inputValue());
    }

    private Set<Integer> changeToNumbers(String input) {
        String[] splitInput = input.trim().split(",");

        return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    private String inputValue() {
        return Optional.of(SCANNER.nextLine())
                .orElseThrow(() -> new IllegalArgumentException("공백을 입력했습니다. 값을 입력해 주세요."));
    }

}
