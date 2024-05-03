package calculator;
import java.util.*;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    ArrayList<Double> resultList = new ArrayList<>(); // 연산결과저장할 array 선언
    double result; // 클래스 필드로 result 선언

    public void addResult(double result){
        resultList.add(result);
    }

    public boolean removeFirstResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            return true;
        }
        return false;
    }

    public double calculate(double calculatorVar1, double calculatorVar2, char operator) throws ArithmeticException, IllegalArgumentException {
        // result 변수 사용
        switch (operator) {
            case '+' -> result = calculatorVar1 + calculatorVar2;
            case '-' -> result = calculatorVar1 - calculatorVar2;
            case '*' -> result = calculatorVar1 * calculatorVar2;
            case '/' -> {
                if (calculatorVar2 == 0) {
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = calculatorVar1 / calculatorVar2;
                }
            }
            default -> throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        //> 연산 결과 컬렉션에 추가
        resultList.add(result); // switch문 밖에서 실행
        return result; // switch문 밖에서 결과 반환
    }
    public List<Double> getResultLists(){
        return resultList;
    }
}
