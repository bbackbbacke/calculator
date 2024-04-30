package calculator;
import java.util.*;
public class App {
    public static void main(String[] args) {
        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        int list[] = new int[10];
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언  = count를 할 수 있는 변수를 선언해라*/
        int count =0;
        Scanner sc = new Scanner(System.in);

        /* 반복문 사용 해서 연산을 반복 */
        /* exit을 입력 받으면 반복 종료 */
        String exitMessage = "";
        //exitMessage의 초기값은 null이므로 while 조건문에서 비교한 결과가 false이며, not 연산자(!)를 이용하여 true로 변경 후 while문 진입
        while(!Objects.equals(exitMessage, "exit")){
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
           int num1 = Integer.parseInt(sc.nextLine());

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
           int num2 = Integer.parseInt(sc.nextLine());
            //Integer.parseInt를 사용해서 sc.nextLine()을 String->int로 형변환해줌!
            //sc.nextLine으로 통합하려고

            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
           char operator = sc.nextLine().charAt(0);

           int result = 0;
           boolean isError = false; // 오류 발생 여부를 체크하기 위한 변수 추가

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> {
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        isError = true; // 오류 발생을 표시
                    } else {
                        result = (int) num1 / num2;
                    }
                }
                default -> {
                    System.out.println("올바른 사칙연산 기호를 입력하세요.");
                    isError = true; // 잘못된 연산자 입력으로 오류 발생을 표시
                }
            }
            list[count]=result;
            if(count<list.length-1){
            count++;
            }
            else{
                break;
            }


            System.out.println("결과: " + result); // 오류가 발생하지 않았을 때 결과 출력
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitMessage = sc.nextLine();
        }


    }
}


