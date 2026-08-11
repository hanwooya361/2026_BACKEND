package day10;

public class Exam3 {
    public static void main(String[] args) {
        // 1. 상위객체
        상위클래스 obj1 = new 상위클래스(); // 상위탄생
        obj1.show();

        // 2. 하위객체
        하위클래스 obj2 = new 하위클래스(); // 하위탄생
        obj2.show();

        // 3. 타입변환
        상위클래스 obj3 = obj2; // 하위 메소드가 재정의(오버라이드 우선)
        obj3.show();
    }
}
/*
    오버로딩: 생성자명 or 메소드명 동일하게 여러개 선언 
        조건 : 매개변수 개수,타입,순서 다른 경우
    오버라이딩: 물려받은 메소드 재정의
*/
class 상위클래스{
    int value1 = 10;
    int value2 = 20;
    상위클래스(){System.out.println("상위탄생");}
    void show(){System.out.println("상위메소드 실행");}
}
class 하위클래스 extends 상위클래스{
    int value3 = 30;
    int value4 = 40;
    // 즉] 인스턴스1개당 멤버변수 1개씩 생성
    하위클래스(){System.out.println("하위탄생");}
    // 주의할점: 오버로딩 vs 오버라이딩
    void show(int a){}    // 메소드명은 같지만 매개변수가 다르다 오버로딩

    @Override   // 메소드 위에 @Override 명시 , 빈칸에 컨트롤+spacebar 
    void show(){     // 상위클래스의 메소드 선언부 모두 동일하면 오버라이딩
        System.out.println("하위메소드가 재정의 실행");
    }    
    // 즉] 여러개의 인스턴스가 메소드를 공유
}