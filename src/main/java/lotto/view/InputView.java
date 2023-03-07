package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputBuyMoney() {
        return Integer.parseInt(inputValue("구입금액을 입력해 주세요."));
    }

    public List<Integer> inputWinLottoNumber() {
        String input = inputValue("지난 주 당첨 번호를 입력해 주세요.");
        return changeToNumbers(input);
    }

    private List<Integer> changeToNumbers(String input) {
        String[] splitInput = input.trim().split(",");
        List<Integer> result = new ArrayList<>();

        for (String number : splitInput) {
            result.add(Integer.parseInt(number));
        }

        return result;
    }

    private String inputValue(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }

}
