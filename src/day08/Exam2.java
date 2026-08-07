package day08;

public class Exam2 {
    public static void main(String[] args) {

        // [1] setter and getter 이용한 간접접근 차단
        User u1 = new User();
        // u1.name = "유재석";  직접접근 불가능
        u1.setname("유재석");   // 간접접근 허용
        // System.out.println(u1.name); 불가능
        System.out.println(u1.getname());   // 가능

        // [2] 객체 출력하면 객체주소값 반환?
        System.out.println(u1); // day08.User@372f7a8d
        // toString 메소드가 존재하는 객체는 주소값 대신에 


    }
}

class User{ // 클래스란? 객체 설계도/종이    
    // 1. 멤버변수 = 상태 = private 사용(관례적으로)
    private String name;
    private int age;
    // 2. 생성자 = 초기화 
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // 3. 메소드 = 행위
    // - private 메소드에 대한 간접접근 메소드
    // setter , getter , set멤버변수 , get멤버변수
    // getter 존재하면 V(value)O(object) 읽기모드
    // setter/getter 존재하면 D(data)T(transfer)O(object) 읽기/쓰기모드

    public void setname(String name){
        // 추후 유효성검사를 통해 원하는 데이터 저장
        this.name = name;
    }
    public String getname(){
        return this.name;
    }

    // 우클릭 시
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // 3. toString : 객체 호출시 주소값 대신에 문자열 반환
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }
    // DTO : 데이터베이스에 있는 자료 --이동DTO--> 프론트엔드
    //       1. 관례적으로 멤버변수 모두 private
    //       2. setter/getter 제공   
    //       3. toString 제공   
    //       4. 생성자에 기본생성자1개 , 전체매개변수1개 => 2개
    // MVC패턴 : 소규모가아닌 체계적인 (약속) 규모가 필요할 때 클래스 역할 나누기
    /*  V : VIEW 입출력담당                 HTML/CSS/JS/REACT/FLUTTER
        C : Controller 제어(백/프) 중계     JAVA/PYTHON/NODE.JS
        M : Model 데이터 담당               DTO,VO (CONTROLLER - 외부에DB/클라우드)
        1인 식당 운영 : 사장이 서빙, 요리, 정리, 재료관리
        N인 식당 운영 : 서빙담당, 요리담당, 정리담당, 재료관리담당
    */
}
