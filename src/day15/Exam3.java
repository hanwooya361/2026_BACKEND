package day15;

import java.awt.*;  // java내 ui 제공 

public class Exam3 {
    public static void main(String[] args) {
        /*  프로그램: 실행가능한 코드들의 집합
            프로세스: 실행중인 프로그램
            멀티 태스킹: 두 가지 이상의 작업을 동시에 처리 
                - 멀티 프로세스: 운영체제가 여러개 프로세서를 동시에 실행하는 구조
                - * 멀티 스레드: 하나의 프로세스내 여러개 흐름 작업 실행하는 구조 
            스레드란? 하나의 프로세스내 최소 작업 단위 또는 실행 흐름 단위
                - CPU(HW)가 (<--운영체제-->) 프로세스(SW)내 스레드를 통해 코드를 순차적으로 처리
            main함수란? JAVA 내 단일 스레드 환경 main메소드가 제공함 
        */
        // [1] 단일(싱글)스레드: (컴파일된) 코드들을 실행 흐름 단위 1개일 때
        // -> main메소드가 main스레드 제공한다 (프로그램 당 1개 이상 존재)
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // 1) 1초에 한번씩 소리 발생
        for(int i=0; i<5; i++){
            toolkit.beep(); // 소리 출력 함수
            // 현재 스레드(코드 실행하는 흐름단위) 일시정지(밀리초) 
            try{Thread.sleep(1000);}catch(Exception e){}  
        }
        // 2) 1초에 한번씩 '띵' 출력 발생? (병행처리)
        for(int i=0; i<5; i++){
            System.out.println("띵");
            try{Thread.sleep(1000);}catch(Exception e){}
        }

        // [2] 멀티스레드 방법1: 익명구현체, new 인터페이스타입(){오버라이딩};
        // Runnable runnable = new Runnable() {};
        Runnable runnable = new Runnable() {
            // 새로운 스레드가 처리할 메소드 = run() 오버라이딩(재정의)
            @Override public void run() {   
                for(int i=1; i<=5; i++){
                    System.out.println("새로운 첫번째 스레드"+i);
                    try{Thread.sleep(1000);}catch(Exception e){}
                }             
            }
        };  // 익명구현체 구현끝
        Thread thread1 = new Thread(runnable);  // new Thread(익명구현체);
        thread1.start();    // 새로운 스레드가 run() 메소드 호출 = start(), MAIN / TASK1 (2)

        // [3] 멀티스레드 방법2: 구현체
        작업스레드2 작업스레드2 = new 작업스레드2();
        Thread thread2 = new Thread(작업스레드2);
        thread2.start();    // MAIN / TASK1 / TASK2 (3개)

        // [4] 멀티스레드 방법3: 상속
        작업스레드3 thread3 = new 작업스레드3();
        thread3.start();    // MAIN / TASK1 / TASK2 / TASK3 (4개) = 병렬처리(처리 순서 보장 없다.)

    }
}

class 작업스레드2 implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            System.out.println("두번째 새로운 스레드"+i);
            try{Thread.sleep(1000);}catch(Exception e){}
        }
    }
}

class 작업스레드3 extends Thread{
    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            System.out.println("세번째 새로운 스레드"+i);
            try{Thread.sleep(1000);}catch(Exception e){}
        }
    }
}