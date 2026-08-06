package day07;

public class Exam1 {
    public static void main(String[] args) {
        /*
            - 함수란? 기능을 수행하는 코드집합
            - 메소드란? 자바에서는 메소드라고 부른다
                메소드
                    1) 클래스 내부 선언
                    2) 목적 : 재사용, 인수에 따른 서로 다른 결과물/
                    3) 선언
                        반환타입 메소드명(타입 매개변수){
                            return 반환값
                        }
                        - 반환타입 : 반환값의 타입/자료형 일치!! , void(없다 뜻)
                        - 메소드명 : 소문자 시작하는 카멜표기법
                        - 타입 매개변수 : 함수호출하는 곳으로부터 전달받는 값 타입 일치!
                        - { } : 함수호출시 실행할 코드
                        - return : 함수 종료시 반환되는 값
                    4) 호출 : 다양한 기준
                        1. 서로 다른 클래스에서 메소드 호출시 인스턴스(객체) 필요
                            주체 : this(특정 메소드/생성자 호출한 객체)
                            객체변수명.메소드명();
                        2. 동일 클래스내 메소드 호출시 인스턴스(객체) 필요없음
                            메소드명();
                    *) 매개변수는 지역변수이다.
                        지역변수란? 특정 함수/if/for{} 에서 선언된 변수는
                            종료되면 사라진다. {}밖에서 호출이 안됨

        */
        계산기 나만의계산기 = new 계산기();
        // 1) 매개변수가 있고 반환이 있는 경우
        double pi = 나만의계산기.getPI();
        // 2) 
        나만의계산기.powerOn();
        // 3)
        나만의계산기.printSum(10, 5);
        // 4)
        int result = 나만의계산기.add(10, 5);

        // *** 주의할 점 *** : this(주체) 인스턴스 식별!
        // 1. 강호동, 유재석
        사람타입 p1 = new 사람타입("강호동");
        사람타입 p2 = new 사람타입("유재석");
        // 2. 강호동 취업성공
        p1.취업성공("개발자");
        // 3. 확인
        System.out.println(p1.job); // 개발자
        System.out.println(p2.job); // null
        
    }
}

class 계산기{
    // 1. 멤버변수
    // 2. 생성자
    // 3. 메소드/함수
    // 1) 매개변수 x 반환값 o
    double getPI(){
        return 3.14;
    }
    // 2) 매개변수 x 반환값 x
    void powerOn(){
        System.out.println("On");
        return; // 리턴값 생략
    }
    // 3) 매개변수 o 반환값 x
    void printSum(int x, int y){
        System.out.println(x+y);
    }
    // 4) 매개변수 o 반환값 o
    int add(int x , int y){
        // 동일한 클래스내 다른 메소드호출
        printSum(x, y);
        return x + y;
    }
}

class 사람타입{
    // 사람이 가져야할 상태 설계 = 멤버변수
    String name;
    int age;
    String job;
    
    // 사람이 태어날때 초기로 가져야할 설계 = 생성자
    사람타입(String name) {
        this.name = name;
        this.age = 1;
    }

    // 취업/행위/상태변경 설계 = 메소드
    void 취업성공(String 취업한직업){
        this.job = 취업한직업;
        return;
    }
}