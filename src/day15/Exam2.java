package day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Exam2 {
    public static void main(String[] args) {
        /* 스택(Stack): 후입선출(LIFO: 가장 마지막에 삽입된 자료가 가장 먼저 삭제됨)
            - 예] 브라우저(뒤로가기), CTRL+Z(실행취소) 등
            = Stack 클래스 이용한 구현, push삽입, pop
        */
        Stack<String> stack = new Stack<>();    // 스택 메모리 만든다
        stack.push("네이버메인페이지");
        stack.push("뉴스페이지");
        stack.push("블로그페이지"); // 메인 -> 뉴스 -> 블로그
        while (!stack.isEmpty()) {  // !: 부정문, !변수명.isEmpty(), 비어있으면 반복문 종료
            System.out.println(stack.pop());    // 출력: 3.블로그 -> 2.뉴스 -> 1.메인
        }
        /* 큐(Queue): 선입선출(FIFO: 가장 먼저 삽입된 자료가 가장 먼저 삭제됨)
            - 예] 번호표(웨이팅), 프린터(인쇄) 등
            - LinkedList 클래스 이용한 구현, offer입력, poll출력
        */
        Queue<String> queue = new LinkedList<>();
        queue.offer("1번 손님"); queue.offer("2번 손님"); queue.offer("3번 손님");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        
    }
}
