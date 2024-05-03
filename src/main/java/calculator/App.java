package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();
        boolean isError = false;
        double result = 0;

        String exitMessage = "";

        while (!Objects.equals(exitMessage, "exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            double calculatorVar1 = Double.parseDouble(sc.nextLine());

            System.out.print("두 번째 숫자를 입력하세요: ");
            double calculatorVar2 = Double.parseDouble(sc.nextLine());

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0);

            try {
                result = calculator.calculate(calculatorVar1, calculatorVar2, operator);
                isError = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                isError = true;
            }

            if (!isError) {
                System.out.println("결과: " + result);
                System.out.println("가장 먼저 연산된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if (Objects.equals(sc.nextLine(), "remove")) {
                    if (calculator.removeFirstResult()) {
                        System.out.println("첫 번째 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if (Objects.equals(sc.nextLine(), "inquiry")) {
                    for (Double resultItem : calculator.getResultLists()) {
                        System.out.println(resultItem);
                    }
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitMessage = sc.nextLine();
        }
    }
}
