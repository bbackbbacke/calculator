package calculator;
import java.util.*;

public class App {
    public static void main(String[] args) {
        int list[] = new int[10];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        String exitMessage = "";

        while (!Objects.equals(exitMessage, "exit")) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = Integer.parseInt(sc.nextLine());

            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = Integer.parseInt(sc.nextLine());

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.nextLine().charAt(0);

            int result = 0;
            boolean isError = false;

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        isError = true;
                    } else {
                        result = num1 / num2;
                    }
                }
                default -> {
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    isError = true;
                }
            }
                //기본 boolean isError = false니까 !isError라는 것은 while문이 true이므로 실행될 때를 말함.
                //count == list.length == 배열이 꽉 차다.(10개의 인덱스(0~9)가 다 차 있다.)
                //int i = 1(배열의 두번째 요소(1번째인덱스)부터  각 요소를 자신의 직전 위치로 복사(list[i-1] = list [i])
                //count를 -- 로 조정하여 배열이 꽉차면 마지막위치를 한 칸 앞당겨(원래 0번째 인덱스 애는 사라지는 것) 새로운 요소를 마지막 위치(9번째 인덱스)에 추가할 수 있게 함.
            if (!isError) {
                if (count == list.length) {
                    for (int i = 1; i < list.length; i++) {
                        list[i - 1] = list[i];
                    }
                    count--; // 마지막 요소가 채워질 위치를 다시 여는 작업
                }

                list[count] = result;
                if(count < list.length - 1) {
                    count++;
                }

                System.out.println("결과: " + result);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitMessage = sc.nextLine();
        }
        sc.close();
    }
}
