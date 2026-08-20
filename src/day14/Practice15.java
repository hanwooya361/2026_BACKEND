package day14;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// 1.
class  Box<T>{
    public T content;
}
// 2.

public class Practice15 {
    public static void main(String[] args) {
        // 1.
        Box<String> box1 = new Box();
        box1.content = "안녕하세요";
        System.out.println(box1.content);
        Box<Integer> box2 = new Box();
        box2.content = 100;
        System.out.println(box2.content);

        // 2.
        List<String> list = new ArrayList<>();
        list.add("유재석");
        list.add("강호동");
        list.add("서장훈");
        list.add("신동엽");
        list.add("유재석");
        System.out.println(list.contains("서장훈"));
        System.out.println(list.indexOf("서장훈"));
        list.remove(list.indexOf("서장훈"));
        System.out.println(list);

        // 3.
        int[] draw = {1,3,3,7,9,9,2,10,10,8,4,4,6,6,5};
        Set<Integer> lottoSet = new HashSet<>();
        for (int number : draw) {
            lottoSet.add(number);
        }
        System.out.println(lottoSet);
        System.out.println(lottoSet.size());
        System.out.println(lottoSet.contains(7));

        // 4.
        int[] draw2 = {1,3,3,7,9,9,2,10,10,8,4,4,6,6,5};
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int number : draw) {
            treeSet.add(number);
        }
        System.out.println(treeSet);

        // 5.
        
        

    }
}
