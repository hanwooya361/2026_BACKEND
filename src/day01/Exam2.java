package day01;      // 클래스가 속한 폴더명/패키지
public class Exam2 {    // 클래스 시작
    // [1] m+enter : main함수 작성
    public static void main(String[] args) {    // main함수 시작
        // [2] 리터럴 : 상수 , 미리 상수로 구성한 자료들
        // 3 , 'a' , true
        System.out.println(3);    // so+enter
        System.out.println(3.14);
        System.out.println('유'); // 작음따옴표 : 문자(한글자)
        System.out.println("유재석"); // 큰따옴표 : 문자열(글자)
        System.out.println(true); 
        // [3] 자료타입 / 자료형 : 자료(데이터) 효율적으로 분류하는 방법
        // * 효율이란? 자료 크기에 따라 적당한 타입(크기) 선정해 빈공간(여백) 줄이기
        // C/JAVA 정적(직접)타입 VS PY/JS 동적(자동으로)타입

        // 1) boolean : true or false 저장하는 타입, 1byte(1bit -> 8bit -> 1byte)
        boolean bool1 = true;   // let/const --> boolean
        System.out.println(bool1);

        // 2) char : ''작은따옴표로 감싼 문자 1개 저장하는 타입, 2byte, 유니코드
        char ch1 = 'A';
        System.out.println(ch1);
        
        // 3) String : ""큰따옴표로 감싼 문자 n개 저장하는 타입, n*2byte , 객체(문자열)
        String str1 = "ABC";
        System.out.println(str1);

        // == 정수 ==
        // 4) byte : -128 ~ 127 저장하는 타입 , 1byte
        byte b1 = 100;
        System.out.println(b1);

        // 5) short : +-3만정도 , 2byte
        short sh1 = 30000;
        System.out.println(sh1);

        // 6) int : +-21억정도, 4byte , ****(정수)리터럴 타입****
        int i1 = 200000000;
        System.out.println(i1);
        
        // 7) long : +-21억이상 , 8byte , ***키보드로부터 입력한 정수는 int이므로 뒤에 L/l 붙인다.***
        long l1 = 20000000000l;
        System.out.println(l1);

        // == 실수 : 부동소수점 이용한 소수점 표현은 오차가 있으므로 정교한 소수점/계산은 라이브러리를 이용 ==
        // 8) float : 소수점 8자리 표현, 4byte, *키보드로부터 입력한 실수는 double이므로 F/f 붙인다
        float f1 = 0.123456789123456789f;
        System.out.println(f1);

        // 9) double : 소수점 17자리 표현, 8byte *(실수)리터럴 타입*
        double d1 = 0.123456789123456789;
        System.out.println(d1);

        // 8가지 타입(기본타입, 리터럴 저장)
        // vs 그외(String) 타입(참조타입, 클래스/객체/베열/인터페이스 등등)

    }   // main함수 끝
}   // 클래스 끝
