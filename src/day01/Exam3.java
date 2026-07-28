package day01;

import java.util.Scanner;

public class Exam3 {
    public static void main(String[] args) {
        // [1] 출력함수 
        // System(클래스).out(출력객체).print(출력함수)
        // 1. System.out.println(); 출력 후 자동 줄바꿈
        System.out.println("자바안녕1");   // so+엔터
        // 2. System.out.print(); 출력
        System.out.print("자바안녕2");

        // [2] 이스케이프/제어 문자 : \백슬래시 이용한 특수기능
        // \n 줄바꿈, \t 들여쓰기, \', \", \\
        System.out.println("\n자바안녕3\t자바안녕4\"\'\\");
        
        // 3. System.out.printf("형식" , "자료"); 
        // %s : 문자열이 들어갈 자리    %c : 문자가 들어갈 자리
        // %d : 정수가 들어갈 자리      %f : 실수가 들어갈 자리
            // %자릿수d : 자릿수만큼 자리를 차지하고, 만일 비어있으면 공백, 오른쪽정렬
            // %-자릿수d : 자릿수만큼 자리를 차지하고, 만일 비어있으면 공백, 왼쪽정렬
            // %0자릿수d : 자릿수만큼 자리를 차지하고, 만일 비어있으면 0채움
            // %전체자릿수.소수자릿수f
        System.out.printf("저는 %s이고 나이는 %d입니다", "유재석", 40); // %s에는 유재석이 %d에는 40이 매칭됨
        System.out.printf("\n저는 %s이고 나이는 %6d입니다\n", "유재석", 40);
        System.out.printf("저는 %s이고 나이는 %-6d입니다\n", "유재석", 40);
        System.out.printf("저는 %s이고 나이는 %06d입니다\n", "유재석", 40);
        System.out.printf("저는 %-6s이고 점수는 %5.2f입니다\n", "유재석", 123.456789);
    
        // [3] 입력객체/함수
        // [입력객체]
        // 1. Scanner : 입력관련클래스, Sc + 엔터, * 코드파일 상단의 import java.util.Scanner; 자동추가 확인* (해당 폴더에서 클래스 가져옵니다)
        // 2. Scanner : 아무거나, 카멜표기법, 관례적으로 (클래스명은 대문자) 클래스명의 소문자로 변수명 설정
        // 3. new : 인스턴스화, 해당 클래스로 객체를 만든다
        // 4. Scanner(System.in) : 생성자(클래스명동일)안에 시스템입력(System.in)객체
        // * 클래스/생성자/인스턴스 수업전까지 해당하는 한줄의 코드 복붙하기
        Scanner scanner = new Scanner(System.in);

        // [입력함수] , scanner.nextxxx() , 주로 입력받은 함수 결과는 변수에 저장한다.
        // 5. scanner.next();   : 터미널에서 입력받은 자료를 문자열로 반환
        System.out.print("1) 문자열 입력: ");
        String str = scanner.next(); // 터미널 창에서 아무거나 입력후 엔터 기준으로 입력 마침
        // *** 문자열타입 변수명 = 문자열 반환
        System.out.printf("입력받은 자료: %s \n", str);

        // 6. scanner.nextInt(); : 터미널에서 입력받은 자료를 정수로 반환 
        System.out.print("2) 정수 입력: ");
        int i = scanner.nextInt();
        System.out.printf("입력받은 자료: %d \n", i);

    }
}
