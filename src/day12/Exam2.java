package day12;

public class Exam2 {
    public static void main(String[] args) {
        // JDBC란? 자바와 DB연동을 제공하는 인터페이스
        // [준비] 프로젝트내 lib 폴더에 mysql-connector-j-26.7.0.jar 파일 저장
        // [연동] 
        // [1] MYSQL 회사에서 제공하는 Driver 구현체 (동적) 로드
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("연동 성공");
        }catch(ClassNotFoundException e){
            System.out.println("Driver(클래스)가 존재하지 않습니다"+e); // 라이브러리 설치 안함
        }

    }
}
