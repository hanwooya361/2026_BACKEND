package day12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam2 {
    public static void main(String[] args) {
        // JDBC란? 자바와 DB연동을 제공하는 인터페이스
        // [준비] 프로젝트내 lib 폴더에 mysql-connector-j-26.7.0.jar 파일 저장
        // [연동] 
        // [1] MYSQL 회사에서 제공하는 Driver 구현체 (동적) 로드
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("연동 성공");
            // [2] DB서버 연동 *예외처리 필수*
            // DriverManager.getConnection("jdbc:mysql://ip번호:3306/데이터베이스명", "계정명", "비밀번호")
            String url = "jdbc:mysql://127.0.0.1:3306/mydb0813";
            String user = "root";
            String password = "qlqjsdms1234";
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("DB 연동 성공");
            // [3] DB내 DML(INSERT, SELECT, UPDATE, DELETE) 조작
            // 1. INSERT 하기
            String sql = "insert into test(name) values('유재석')"; // 자바 문자열에 sql 작성(자동완성 안됨)
            PreparedStatement ps = conn.prepareStatement(sql); 
            // conn(연동된 인터페이스).prepareStatement(기재할sql); , 기재된 인터페이스 반환
            // PreparedStatement sql이 기재된 인터페이스
            int result = ps.executeUpdate(); // ps.executeUpdate(); (sql이 기재된 인터페이스에서 sql 실행) , 실행한 레코드 수 반환
            System.out.println(result); // 1. 성공 0. 실패
            System.out.println("레코드 등록 성공");

            // 2. select 하기, select 필드명 from 테이블명;
            String sql2 = "select * from test";
            PreparedStatement ps2 = conn.prepareStatement(sql2);    // 작성한 sql 기재
            ResultSet rs = ps2.executeQuery(); // 기재된 sql 실행, 결과 rs 인터페이스 대입
            rs.next();  // 조회결과 다음 레코드 이동
            System.out.println(rs.getInt("no"));    // rs.get타입("속성명")
            System.out.println(rs.getString("name"));   // rs.get타입("속성명")
            System.out.println("레코드 조회 성공");

        }catch(ClassNotFoundException e){
            System.out.println("Driver(클래스)가 존재하지 않습니다"+e); // 라이브러리 설치 안함
        }catch(SQLException e){
            System.out.println("DB 연동 실패"+e);
        }


    }
}
