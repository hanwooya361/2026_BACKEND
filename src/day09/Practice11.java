package day09;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        // 1.
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");
        System.out.println(nameList);
        // 2.
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(i + ": " + fruits.get(i));
        }
        // 3.
        ArrayList<String> fruits1 = new ArrayList<>();
        fruits1.add("사과"); fruits1.add("바나나"); fruits1.add("딸기");
        for(String fruit : fruits1){
            System.out.println(fruit);
        }
        // 4.
        ArrayList<String> alpha = new ArrayList<>();
        alpha.add("A");
        alpha.add("B");
        alpha.add("C");
        alpha.add("D");
        alpha.add("E");
        alpha.remove(2);
        System.out.println(alpha);
        // 5.
        ArrayList<String> study = new ArrayList<>();
        study.add("자바");
        study.add("파이썬");
        study.add("c++");
        study.add(1, "자바스크립트");
        System.out.println(study);
        // 6.
        ArrayList<Book> library = new ArrayList<>();
        library.add(new Book("조현우", "조현우"));
        library.add(new Book("조현우1", "조현우1"));
        library.add(new Book("조현우2", "조현우2"));
        for(Book book : library){
            System.out.println(book.getTitle() + ":" + book.getAuthor());
        }

        // 7.
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> text = new ArrayList<>();
        while(true){
            System.out.print("문자를 입력해주세요: ");
            String 문자 = scanner.next();
            if(문자.equals("종료")){ 
                System.out.println(text);
                break;
            }
            text.add(문자);
        }
        

        // 8.
        ArrayList<String> 수업 = new ArrayList<>();
        수업.add("국어");
        수업.add("수학");
        수업.add("사회");
        수업.add("과학");
        수업.set(1, "영어");
        System.out.println(수업);
    }
}
class Book{
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + "]";
    }
    
}
/*[문제 1] String 타입의 요소를 저장할 수 있는 ArrayList를 nameList 라는 이름으로 생성하세요.
1. .add() 메소드를 사용하여 "유재석", "강호동", "신동엽" 세 개의 이름을 리스트에 추가하세요.
2. 리스트의 모든 요소를 System.out.println()으로 한 번에 출력하세요.*/

/*[문제 2] 다음과 같이 초기화된 ArrayList가 있습니다.
1. ArrayList<String> fruits = new ArrayList<>();
2. fruits.add("사과"); fruits.add("바나나"); fruits.add("딸기");
3. 일반 for문을 사용하여, 각 인덱스와 해당 인덱스의 요소를 "인덱스 0: 사과" 형식으로 모두 출력하세요.*/

/*[문제 3] 문제 3의 fruits 리스트를 사용합니다.
1. 향상된 for문 을 사용하여 리스트의 모든 요소를 하나씩 출력하세요.*/

/*[문제 4] "A", "B", "C", "D", "E"를 요소로 가지는 ArrayList를 생성하세요.
1. .remove() 메소드를 사용하여 2번 인덱스의 요소("C")를 삭제하세요.
2. 삭제 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.*/

/*[문제 5] "자바", "파이썬", "C++"를 요소로 가지는 ArrayList를 생성하세요.
1. .add(인덱스, 요소) 메소드를 사용하여 1번 인덱스에 "자바스크립트"를 삽입하세요.
2. 삽입 후의 리스트 전체를 출력하여 순서가 올바르게 변경되었는지 확인하세요.*/

/*[문제 6] title(문자열)과 author(문자열) 멤버 변수를 가진 Book 클래스를 만드세요.
1. Book 객체를 저장할 수 있는 ArrayList를 library 라는 이름으로 생성하세요.
2. new Book(...)을 사용하여 3권의 책 객체를 생성하고 library 리스트에 추가하세요.
3. 향상된 for문을 사용하여 library에 저장된 모든 책의 제목과 저자를 출력하세요.*/

/*[문제 7] Scanner를 사용하여 사용자로부터 문자열을 계속해서 입력받습니다.
1. 입력받은 문자열은 ArrayList에 순서대로 저장합니다.
2. 만약 사용자가 "종료" 라는 단어를 입력하면, 입력을 멈추고 그때까지 리스트에 저장된 모든 내용을 출력한 뒤 프로그램을 종료하세요.*/

/*[문제 8] "국어", "수학", "사회", "과학"을 요소로 가지는 ArrayList를 생성하세요.
1. .set(인덱스, 요소) 메소드를 사용하여 1번 인덱스의 "수학"을 "영어"로 수정하세요.
2. 수정 후의 리스트 전체를 출력하여 결과가 올바른지 확인하세요.*/