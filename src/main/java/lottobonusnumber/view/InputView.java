package lottobonusnumber.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputBuyMoney() {
        return Integer.parseInt(inputValue("구입금액을 입력해 주세요."));
    }

    public Set<Integer> inputWinLottoNumber() {
        String input = inputValue("지난 주 당첨 번호를 입력해 주세요.");
        return changeToNumbers(input);
    }

    public int inputBonusNumber() {
        String input = inputValue("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(input);
    }

    private Set<Integer> changeToNumbers(String input) {
        String[] splitInput = input.trim().split(",");

        return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    private String inputValue(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

}
