package day14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exam3 {
    public static void main(String[] args) {
        
        // Set 인터페이스: 여러개 자료들을 저장하는 컬렉션, 단 * 중복허용안함(자료의값으로 식별), 인덱스(순서)가 없다
        // 1. Set 구현
        Set<String> set1 = new HashSet<>();
        // 2. Set.add(추가할값);
        set1.add("유재석"); set1.add("강호동");
        set1.add("유재석"); // List 중복허용 , Set 중복허용안함
        set1.add(new String("유재석")); // 중복방지
        System.out.println(set1);   // [유재석, 강호동]
        // 3. .get(인덱스); 지원불가, 인덱스기 없어서
        // set1.get(0);
        // 4. .size()
        System.out.println(set1.size());
        // 5. .remove(자료);    인덱스가아닌 자료 삭제
        set1.remove("강호동");
        System.out.println(set1);
        // 6. .indexOf(인덱스); 지원불가 , 7. .contains(찾을값) 지원
        System.out.println(set1.contains("강호동"));
        // 8. .clear();  항목 전체삭제 가능 
        set1.clear();
        // 9. .isEmpty();  항목이 하나도 없으면 true/false  
        set1.isEmpty();
        // 10. set 컬렉션과 반복문 관계
        // 1. 일반for문 불가(인덱스가 없어서)
        // 2. 향상된 for문 지원
        for(String str : set1){System.out.println(str);}
        // 3. forEach 지원, 컬렉션객체.forEach((반복변수명)->{})
        set1.forEach((str)->{System.out.println(str);});
        // - 활용처: Set(JDBC ResultSet)
        
        Iterator<String> 순회자 =  set1.iterator();    // 인덱스가 아닌 자료들을 순회하는 인터페이스 반환
        while(순회자.hasNext()){    // 인터페이스 이용한 다음 자료 확인
            System.out.println(순회자.next());  // 다음 자료 꺼내기 지원
        }   
        // 즉] 위 코드 이용해 향상된 for문 / forEach / ResultSet가 만들어짐

        // 11. TreeSet 이용한 자동 정렬 지원
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(50);   set2.add(70);   set2.add(60);
        System.out.println(set2);   // [50, 60, 70] 자동정렬 : 기본값이 오름차순
        // descendingSet 메소드는 set인터페이스내 추상메소드가 없음 그래서 TreeSet인터페이스로 변경
        System.out.println(set2.descendingSet());   // 내림차순
    }
}
