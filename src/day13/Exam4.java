package day13;

import java.util.Random;
import java.util.UUID;

public class Exam4 {
    public static void main(String[] args) {
        
        // [1] Random, 난수 클래스, 활용처: 인증번호 
        // 1. 랜덤 객체
        Random random = new Random();
        // 2. 랜덤 생성, .nextxxx()
        int value1 = random.nextInt();  System.out.println(value1); // -787862750
        int value2 = random.nextInt(10);  System.out.println(value2);   // 0~9(10) 사이 난수
        int value3 = random.nextInt(10)+1;  System.out.println(value3);   // 1~10 사이 난수
        boolean value4 = random.nextBoolean();  System.out.println(value4);     // true/false 난수

        // [2] UUID, 범용 고유 식별자, 절대 중복없는 난수 생성, 활용처: 회원번호/파일식별
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
