package calculator;
import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num1 = Integer.parseInt(sc.nextLine());
        System.out.print("두 번째 숫자를 입력하세요: ");
        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        int num2 = Integer.parseInt(sc.nextLine());
        //Integer.parseInt를 사용해서 sc.nextLine()을 String->int로 형변환해줌!
        //sc.nextLine으로 통합하려고

        System.out.println("num1, num2 = " + num1 + ", " + num2 );


        System.out.print("사칙연산 기호를 입력하세요: ");
        // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
        char operator = sc.nextLine().charAt(0);
        System.out.println(operator);

            }
        }



