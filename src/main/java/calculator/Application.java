package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);

        System.out.println(result);
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) throw new IllegalArgumentException();

        String delimiter = ",|:";

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String n : numbers) {
            int num = Integer.parseInt(n);
            if (num < 0) throw new IllegalArgumentException();
            sum += num;
        }

        return sum;
    }
}
