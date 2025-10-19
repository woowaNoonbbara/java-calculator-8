package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = calculate(input);

        System.out.println("결과 : " + result);
    }

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) throw new IllegalArgumentException();
        input = input.replace("\\n", "\n");

        String delimiter;
        int sum = 0;

        /**
         * 커스텀 구분자
         */
        if(input.startsWith("//")){
            delimiter = String.valueOf(input.charAt(2)); // 2번 인덱스에 위치한 문자를 구분자로 사용

            String[] numbers = input.substring(input.indexOf("\n") + 1).split(delimiter);
            int nn = input.indexOf("\n") + 1;
            for (String n : numbers) {
                int num = Integer.parseInt(n);
                if (num <= 0) throw new IllegalArgumentException();
                sum += num;
            }

            return sum;
        }

        /**
         * 기본 구분자
         */
        delimiter = ",|:";

        String[] numbers = input.split(delimiter);
        for (String n : numbers) {
            int num = Integer.parseInt(n);
            if (num <= 0) throw new IllegalArgumentException();
            sum += num;
        }

        return sum;
    }
}
