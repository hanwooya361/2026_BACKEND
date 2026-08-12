package day11;

/*
    기본타입(리터럴) :(8) byte short int long float double char boolean
    참조타입(객체) : []배열, 인스턴스(String,Dto,Scanner 등), 인터페이스
*/
// 1. 인터페이스 만들기, interface 인터페이스명{}
// 2. 인터페이스 주요멤버 : 상수(public static final), 추상메소드(public abstract)
// 3. 추상메소드를 구현할 클래스 필요<구현객체>, class 클래스명 implements 인터페이스명, 인터페이스명
interface ExamInterface{
    int a = 10; // 상수, 인터페이스에서는 public static final 생략해도 상수이다.
    public static final int b = 20; // 상수
    // * 생성자 없음 즉] new 없다 --> 인스턴스 불가능, 목적 : 여러 인스턴스 호환/관리
    // ** 추상메소드: 선언부만 존재하고 { } 구현부가 없는 메소드
    void method1(int x);
    public abstract int method2(int x, int y);
    // 키보드 a키?
}
class ExamClass implements ExamInterface{   // 해당 클래스가 지정한 인터페이스 구현
    // * 상속은 오버라이딩(선택) vs 구현은 오버라이딩(필수)
    // 추상메소드에 대한 구현을 모두 마치면 오류 사라짐
    // 자동완성 오버라이드
    @Override
    public void method1(int x){System.out.println(x);}
    @Override
    public int method2(int x, int y){return x+y;}
}
public class Exam1 { 
    public static void main(String[] args) {
        // [1] 인터페이스는 인스턴스 생성 불가능
        // 생성자가 없어서
        // ExamInterface ei = new ExamInterface();
    
        // [2] inplements 구현한 객체
        ExamClass ec = new ExamClass();
        ec.method1(10); // 가능
        ec.method2(5, 5); // 가능

        // [3] 업캐스팅
        ExamInterface ei = new ExamClass();
        // 인터페이스 타입이어도 오버라이딩 우선임
        ei.method1(10); // 가능
        ei.method2(10,20);  // 가능
    }
}
