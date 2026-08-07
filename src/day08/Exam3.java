package day08;

public class Exam3 {
    public static void main(String[] args) {
        // [1] final
        D 변수 = new D();
        // 변수.고정변수 = 20; 수정 오류

        // [2] static : 클래스명.(클래스마다)정적변수
        D.정적변수 = 20;
        D.정적변수 = 30;        // 총 메모리 1개
        // VS 멤버변수 : 객체명.(인스턴스마다)멤버변수
        D 변수1 = new D();
        변수1.멤버변수 = 20;
        D 변수2 = new D();
        변수2.멤버변수 = 30;    // 총 메모리 2개

        // [3] 상수 : 클래스명.상수명
        System.out.println(D.상수); 
    }
}

class D{
    // - final 키워드 : 초기값(필수) 이후에 수정 불가능
    public final int 고정변수 = 10;
    // - static 키워드 : (정적) 우선(프로그램 실행시) 할당 변수
    public static int 정적변수 = 10;    // 클래스/정적 변수
    public int 멤버변수 = 10;
    // * static 프로그램 시작시 할당되고 프로그램 종료시 사라짐 *
    // - public static final : 상수
    public static final int 상수 = 30;
    // -- 주의할점 : static 가진 메소드에서 static 아닌 변수/메소드 접근
    // --> 해결방안 : 인스턴스(new)/객체(추상) 통해 멤버변수/메소드 사용
}
