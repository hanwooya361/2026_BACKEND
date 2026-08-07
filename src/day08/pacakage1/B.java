package day08.pacakage1;

public class B {
    public void 메소드(){
        A a = new A();
        a.공개변수 = 3;
        // a.비공개변수 = 3;
        a.일반변수 = 3; // 같은 패키지라 가능
    }
    private B(){    // 비공개 생성자 : 외부에서 객체생성 금지

    }
}
