package day11;

public class Exam3 {
    public static void main(String[] args) {
        // 1.
        Car myCar = new Car();
        // myCar.run(); // 오류 타이어가 없으니까 
        // 2. 오류 인터페이스는 인스턴스 생성 불가
        // myCar.tire = new Tire();
        // 3.
        myCar.tire = new 한국타이어();
        myCar.run();
        // 4.
        myCar.tire = new 금호타이어();
        myCar.run();
        // 5.
        System.out.println(myCar.tire instanceof Tire); // true
        System.out.println(myCar.tire instanceof 금호타이어); // true
        System.out.println(myCar.tire instanceof 한국타이어); // false
        // [*] 익명(클래스없이)구현체 = 일회성 사용하는 인터페이스 구현체
        // 자체적으로 추상메소드 오버라이딩
        // new 인터페이스명(){오버라이딩}
        myCar.tire = new Tire() {
            @Override
            public void roll() { 
                System.out.println("일회성타이어 회전");
            }
        };
        myCar.run();

    }
}
class Car{
    Tire tire;
    void run(){this.tire.roll();}
}
interface Tire{
    void roll();
}
// 구현체
class 한국타이어 implements Tire{
    // 추상메소드 {} 구현 (재정의)
    @Override
    public void roll(){System.out.println("한국타이어가 회전");}
}
class 금호타이어 implements Tire{
    // 추상메소드 {} 구현 (재정의)
    @Override
    public void roll(){System.out.println("금호타이어가 회전");}
}