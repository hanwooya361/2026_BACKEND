package day12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
    public static void main(String[] args) {
        // 예외란? 에러발생 시 고치는게 아니라 흐름 제어 vs IF
        // 예외처리: try{예외발생코드}catch(예외클래스명 변수명){처리할 코드}

        // [1] 일반예외: 실행(컴파일)전 예외가 발생할 수 있는 코드에 대해 ***미리*** 예외 처리
        // 1. ClassNotFoundException: 클래스 찾을 수 없다
        try{
            Class.forName("java.lang.String"); // Class.forname("찾을클래스") 동적으로 존재하는 클래스 로드(읽어오기)
        }catch(ClassNotFoundException e){ // 예외발생시 처리되는 코드, e: 변수이면서 예외정보 저장 객체
            System.out.println("존재하지 않은 클래스 입니다" + e);
        } 
        // 2. InterruptedException: 스레드에 문제가 발생하면
        try{
            Thread.sleep(1000); // Thread.sleep(밀리초); 밀리초만큼 일시정지, 스레드란? 컴파일(번역)된 코드들을 읽어드리는 흐름
        }catch(InterruptedException e){ // 예외발생시 처리되는 코드, e: 변수이면서 예외정보 저장 객체
            System.out.println("인터럽트 문제 발생" + e);
        }
        // [2] 실행예외: 실행후 예외가 발생 처리 *경험이 중요* 예측 , 유지보수(로그)
        // 3. NullPointerException: 참조가 없는 참조하는 경우
        try{
            String str1 = null; // 참조값 없음 즉] 인스턴스가 없다
            System.out.println(str1.length()); // .연산자는 참조할 대상의 멤버에 접근
        }catch(NullPointerException 변수){
            System.out.println(변수);
        }
        // 4. NumberFormatException: 숫자타입으로 변환이 불가능한 경우
        try{
            String str2 = "100";
            String str3 = "100a";
            Integer.parseInt(str2); // Integer.parseInt(문자); 문자 -> 정수 변환 함수
            Integer.parseInt(str3); // "100" --> 100 가능 "100a" --> 불가능
        }catch(NumberFormatException e){
            System.out.println(e);
        }
        // 5. ArrayIndexOutOfBoundsException: 배열내 존재하지 않는 인덱스 호출할 경우
        try{
        int[] 배열 = {10, 25};
        System.out.println(배열[0]);
        System.out.println(배열[5]);    // 없는 인덱스 호출/사용
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        // * 여러타입들의 예외들을 하나의 타입으로 Exception (상위)클래스 사용 가능

        // [3] 다중 catch : try에서 다양한 예외들을 다양하게 흐름 제어, catch는 1번
        // [4] finally : 예외가 발생여부 상관없이 무조건 실행되는 구역
        // 6. InputMismatchException: 입력 타입 에외
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("정수입력: ");
            int ch = scan.nextInt();    // nextInt() 입력받은 자료들을 int타입 반환 함수
            Integer.parseInt("abc");
        }catch(InputMismatchException e){
            System.out.println("정수만 입력하세요"+e);
        }catch(NumberFormatException e){
            System.out.println("타입변환오류"+e);
        }catch(Exception e){    // 다중 catch에서 마지막에 Exception 사용해 그외 처리함
            System.out.println("예외발생: 관리자에게문의" + e);
        }finally{
            System.out.println("무조건실행");
        }
        
        // * try{예외발생할것같은코드}catch(예외클래스명 변수명){}catch(예외클래스명 변수명){}finally{}

        // [5] 예외 던지기(떠넘기기) , *예외반환*: 해당 메소드를 호출한 곳으로 예외 반환
        try{method1();}
        catch(Exception e){System.out.println("메소드 예외발생"+e);}
    
    }
    // 7. 예외발생시 발생한 곳에서 예외처리하지 않고 반환
    public static void method1()throws ClassNotFoundException{
        Class.forName("java.lang.Spring");  // 예외발생
    }
    public static void method2(){

    }
}

