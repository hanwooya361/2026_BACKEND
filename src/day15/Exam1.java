package day15;

import java.util.HashMap;
import java.util.Map;

public class Exam1 {
    public static void main(String[] args) {
        /*
            제네릭타입: 클래스 만들때 타입 정하지 않고 사용할때 타입 정한다.
                List<BoardDto> list = new ArrayList<>()
                - List 인터페이스 (정의)만들때 타입 정하지 않고 List 인터페이스 사용할 때 BoardDto 타입 정했다.

            컬렉션프레임워크
                List 인터페이스:    중복허용, 인덱스(순서) 보장, ArrayList, LinkedList, Vector 등
                Set 인터페이스:     중복불가, 인덱스(순서) 없음, HashSet, TreeSet 등
                Map 인터페이스:     KEY중복불가/VALUE중복허용, 인덱스(순서)없음, HashMap, TableMap, TreeMap 등
        */
        // [1] Map: key와value 한쌍(엔트리)으로 여러개 쌍(엔트리) 저장하는 자료구조 = JSON({}) 유사 / DTO가변
        Map<String, Integer> map = new HashMap<>();
        // [2] 사용법(메소드)
        // 1) .put(key, value): key/value 한쌍 엔트리(entry) 추가
        map.put("유재석", 95); 
        map.put("강호동", 100);
        map.put("서장훈", 80);
        map.put("유재석", 80); // 주의할점: 기존에 존재하면 key있으면 value 수정
        System.out.println(map); // {서장훈=80, 유재석=80, 강호동=100}
        // 2) .get(key): key의 해당하는 value 값 반환
        System.out.println(map.get("유재석")); // 80
        // 3) .size(): 총 엔트리 개수
        System.out.println(map.size()); // 3
        // 4) .containsKey(찾을key): 찾을key 존재하면 true / false
        //    .containsValue(찾을value): 찾을value 존재하면 true / false 
        System.out.println(map.containsKey("유재석")); // true
        System.out.println(map.containsValue(100));  // true
        // 5) .keySet(): 모든 key값 반환, .values(): 모든 value값 반환 
        System.out.println(map.keySet());
        System.out.println(map.values());
        // 6) .remove(key): 해당하는 key의 엔트리(key:value) 삭제
        map.remove("강호동");   System.out.println(map);
        // 7) .clear(): 모든 엔트리  삭제
        map.clear();
        // 8) .isEmpty(): 엔트리가 1개도 없으면 true/false
        System.out.println(map.isEmpty());
        // * 활용처: 1] JSOM(JS) <-- 통신 --> DTO/MAP   2] 자료구조(암호화)
        // 9) 반복문 관계
        // (1) 일반 for문 불가능, 인덱스가없음
        // (2) 향상된 for문 가능
        for(String key : map.keySet()){ // 모든 키들을 꺼내 반복을 돌림
            System.out.println(key + ":" + map.get(key));   // 키 이용한 값 호출
        }
        // (3) .forEach((반복변수)->{})
        map.keySet().forEach((key)->{System.out.println(key+":"+map.get(key));});
    }
}
