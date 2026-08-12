package day10;

public class Example2 {
    public static void main(String[] args) {
        Car myCar = new Car();  // 
        System.out.println(myCar);      // @372f7a8d
        Car yourCar = new Car(); // 동일한 클래스로 서로 다른 인스턴스 생성
        System.out.println(yourCar);    // @2f92e0f4

        myCar.tire = new Tire();        // myCar에 tire 대입
        myCar.run(); 
        yourCar.tire = new Tire();
        yourCar.run();
        myCar.tire = new HankookTire(); // myCar에 새로운 tire 대입
        myCar.run(); 
        myCar.tire = new KumhoTire();   // 변수란 하나의 자료만 저장/참조하기때문에 금호타이어가 들어오고 한국타이어가 빠진다.
        myCar.run(); 
        System.out.println( myCar.tire instanceof Tire ); // true   // 금호 --> 일반tire
        System.out.println( myCar.tire instanceof KumhoTire ); // true  // 금호 --> 일반tire
        System.out.println( myCar.tire instanceof HankookTire ); // false   // 금호 --> 일반tire

        // 즉] 인스턴스 1개당 멤버변수(tire) 각 생성
        // 즉] 인스턴스 여러개 하나의 메소드(run()) 공유
      
    } // main
} // class end

class Car{ // 클래스는 인스턴스 만들기 위한 설계도
    Tire tire;      // 멤버변수, 초기값x
    void run() { this.tire.roll(); }    // 메소드, this(해당 메소드 호출한 인스턴스)
}
class Tire{ 
    void roll(){    // 메소드
    System.out.println("[일반] 타이어가 회전");
 }
}
class HankookTire extends Tire{ 
    void roll(){ System.out.println("[한국] 타이어가 회전(업그레이드)"); }
}
class KumhoTire extends Tire{ 
    void roll(){ System.out.println("[금호] 타이어가 회전(업그레이드)"); }
}