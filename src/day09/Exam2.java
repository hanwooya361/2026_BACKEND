package day09;

public class Exam2 {
    public static void main(String[] args) {
        // 싱글톤패턴 : 프로그램내 단 *하나의* 인스턴스(객체)를 갖는 설계 구조
        // 목적 : 1. 다수 인스턴스 생성 방지(프로그램내 인스턴스 여러개 필요없는 경우)
        //        2. 하나 인스턴스 사용해 메모리 공유
        View 인스턴스1 = new View();    System.out.println(인스턴스1);  // day09.View@372f7a8d
        View 인스턴스2 = new View();    System.out.println(인스턴스2);  // day09.View@2f92e0f4
        // 클래스명.getInstance();
        Controller 인스턴스3 = Controller.getInstance();    System.out.println(인스턴스3);  // day09.Controller@5305068a
        Controller 인스턴스4 = Controller.getInstance();    System.out.println(인스턴스4);  // day09.Controller@5305068a
    }
}
class View{}    // 그냥 객체 클래스
class Controller{   // 싱글톤 클래스
    // 1. 생성자를 private 한다.    <다른클래스에서 생성자 사용금지>
    private Controller(){}
    // 2. 클래스 내부에 단 하나의 인스턴스 생성
    private static final Controller instance = new Controller();
    // 3. 클래스 내부에 인스턴스를 간접 사용(공유) 하도록 getter 만든다.
    public static Controller getInstance(){return instance;}
}  
