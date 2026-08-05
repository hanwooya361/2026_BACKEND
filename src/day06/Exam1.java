package day06;

public class Exam1 {
    public static void main(String[] args) {
        /*
            생성자 : 인스턴스(객체) 생성할 때 사용되는 키워드
            선언하는 방법 
                1) 클래스 내부
                2) 클래스명과 동일, 만일 다르면 메소드 취급 
                3) 오버로딩 지원 : 동일한 이름으로 여러개 선언, 조건
            목적 : 1) 빠른 초기화 2) 객체생성 규칙/유효성검사
            종류 : 1) 기본생성자(매개변수가없는) 2) 매개변수가있는생성자

            선언되는 변수 위치에 따라 이름이 다르다.
            지역변수 : if/for/func(함수){} 안에서 선언된 변수
            
            매개변수 : 생성자/메소드 호출하면서 인자/인자값들을 저장하는 변수
            
            멤버변수 : class{} 안에서 선언되고 new 인스턴스로 생성된 객체(인스턴스)내 변수
                        this : 해당 생성자/메소드 호출한 객체(인스턴스) 가리킴
        */
        // [1] 기본생성자로 객체 생성 , new 생성자명()
        Phone p1 = new Phone();
        p1.model = "갤럭시";     // 객체내 멤버변수 값 대입

        // [2] 정의생성자로 객체 생성, new 생성자명(값1, 값2);
        Phone p2 = new Phone("아이폰", "파랑");

        // [3] 정의생성자로 갹체 생성
        Phone p3 = new Phone("갤럭시탭", "흰색", 300000);


    }
}

class Phone{
    // *** 클래스 가족(멤버들) ***
    // 1.멤버변수
    String model;
    String color;
    int price;
    // 2.생성자
    // * 생성자가 1개도 없으면 자동으로 기본생성자가 생성됨
    // * 생성자명은 중복이 안된다. 
    // -> 오버로딩(매개변수 개수/타입/순서 다르면 중복 가능)
    // * this란? 즉) 멤버변수 식별 키워드
    // -> 매개변수명과 멤버변수명이 같을 경우 멤버변수명 앞에 this
    // * 매개변수와 인자값의 타입/개수 일치!!
    // 1) 기본생성자 : 매개변수가 없는 
    Phone(){}   // 기본생성자
    // 2) 정의생성자 : 매개변수가 있는
    Phone(String model, String color){
        this.model = model;
        this.color = color;
    }
    Phone(String model, String color, int 가격){
        this.model = model;
        this.color = color;
        price = 가격;
    }
    // 3.메소드/함수

}