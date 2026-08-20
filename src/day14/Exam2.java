package day14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        
        // 제네릭: 클래스내 타입들을 인스턴스 생성시 정한다
        /*
            컬렉션(수집)프레임(틀)워크(일)
                - 정의: 데이터 수집하는 자료구조(방법) 미리 만들어둔 인터페이스/클래스들
                - 목적: 복잡한 자료들을 편리하게 제공받아 사용
                - 종류
                    List 인터페이스:    구현체: ArrayList, Vector, LinkedList, Stack 등
                    Set 인터페이스:     구현체: HashSet, TreeSet 등
                    Map 인터페이스:     구현체: HashMap, HashTable, TreeMap 등
                * 인터페이스란? 서로다른 클래스들을 하나의 타입으로 조작
                * 구현체란? 인터페이스내 추상메소드 구현한 클래스들을 
                * 다형성이란? (캐스팅) 하나의 자료가 서로 다른 타입으로 변환
        */
         // [1] List 인터페이스 
        ArrayList<String> list1 = new ArrayList<>();
        // list1 = new LinkedList();     불가능, 형제끼리 타입변환 불가능
        List<String> list2 = new ArrayList<>();
        list2 = new LinkedList<>();  // 다형성
        // [2] List 인터페이스 타입으로 구현체 메소드 사용가능 <day09 exam1>, 오버라이딩
        list2.add("유재석");
        System.out.println(list2.get(0)); 
        list2.add("강호동");
        // [3] 리스트/배열 과 반복문 관계   // 리스트(목록)내 항목(값)들을 한번에 못 꺼내고 하나씩(순회/반복) 꺼낸다
        // 1. 일반for문, index필요시
        for(int i=0; i<list2.size(); i++){
            // index 0부터 마지막 인덱스까지 인덱스1씩 증가
            String str = list2.get(i);
            System.out.println(str);
        }
        // 2. 향상된for문: 콜론 기준으로 오른쪽에 리스트들을 *하나씩* 왼쪽에 대입
        for(String str : list2){System.out.println(str);}
        // 3. forEach문: 반복메소드, 리스트객체.forEach((반복변수명)->{실행문})
        list2.forEach((str)->{System.out.println(str);});

        // [4] List 구현체 차이 : 사용법(함수/메소드) 동일 , 구조적 차이
        // ArrayList:  인덱스 기반의 배열 구조 + 동기화 미지원
        //              [A] [B] [C] [D]     // E 저장한 경우 마지막 뒤에 E 저장한다.
        //               0   1   2   3      // B 삭제한 경우 삭제된 B 이후로 C D 한칸씩 앞으로 이동한다.
        //              *1000개의 자료가 있다는 가정에 일부 삭제/수정 하면 999 이동발생
        // 즉] 뒤에 삽입 빠르다.

        // LinkedList: 링크 [h헤더][d본문][t꼬리] = (노드) 기반의 리스트 구조
        //              [][ A ][B주소]   [A주소][B][C주소]   [B주소][C][D주소]    [C주소][D][]
        //              // E 저장한 경우 마지막 D 꼬리에 E주소 저장하고  E헤더에 D주소 저장한다.                  
        //              // B 삭제한 경우 삭제할 노드에 꼬리에 주소를 헤더노드에 꼬리에 대입한다.
        //              [][ A ][C주소]   [A주소][C][D주소]    [C주소][D][]
        //              *1000개의 자료가 있다는 가정에 일부 삭제/수정 하면 앞뒤만 이동발생
        // 즉] 중간 삽입/삭제 빠르다.

        // Vector:     ArrayList 동일한 구조 + 동기화(스레드)지원 
    }
}
