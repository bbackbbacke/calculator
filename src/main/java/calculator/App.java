package calculator;
import java.util.*;
//<1-8>
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 변수 선언
        ArrayList<Integer> resultList = new ArrayList<>(); // 연산결과저장할 array 선언

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
            //43line에서 result부분에 오류가 떴던 이유는 result가 int값이었는데 나는 homework2보고 하느냐고 ArrayList를 String으로 선언해줬음(7 line)
            if (!isError) {
               resultList.add(result); // ArrayList에 연산결과 추가

                System.out.println("결과: " + result);
                System.out.println("가장 먼저 연산된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)"); //remove입력 시 삭제
                if (Objects.equals(sc.nextLine(), "remove")){
                    if(resultList.size()>0){
                        resultList.remove(0);} // 첫번째 결과 삭제

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)"); //향상된 for문(foreach)
                if (Objects.equals(sc.nextLine(), "inquiry")){
                    for (Integer resultItem : resultList){
                        System.out.println(resultItem);
                    }

                    }

                }
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitMessage = sc.nextLine();
        } // while문 끝





    }
        }
